import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, delay, map, of, tap, throwError } from 'rxjs';

import { environment } from '../../environments/environment';
import { TokenStorageService } from './token-storage.service';

type LegacyLoginResponse = {
  token?: string;
  accessToken?: string;
  userToken?: string;
  expiresAt?: string;
};

@Injectable()
export class AuthService {
  constructor(private http: HttpClient, private tokenStorage: TokenStorageService) {}

  login(username: string, password: string, remember: boolean): Observable<string> {
    if (!username || !password) {
      return throwError(() => new Error('Username and password are required.'));
    }

    const trimmedUser = username.trim();

    if (!environment.useLegacyApi) {
      return this.performMockLogin(trimmedUser, password, remember);
    }

    const requestBody = {
      username: trimmedUser,
      password,
      rememberMe: remember,
      clientId: environment.legacyClientId,
    };

    return this.http
      .post<LegacyLoginResponse>(this.buildLegacyLoginUrl(), requestBody, {
        withCredentials: true,
      })
      .pipe(
        map((response) => {
          const token = response?.token ?? response?.accessToken ?? response?.userToken ?? '';

          if (!token) {
            throw new Error('Legacy login did not return an access token.');
          }

          return token;
        }),
        tap((issuedToken) => {
          if (remember) {
            this.tokenStorage.persist(issuedToken);
          } else {
            this.tokenStorage.rememberForSession(issuedToken);
          }
        }),
        catchError((error: HttpErrorResponse) => {
          const message = this.resolveHttpError(error);
          return throwError(() => new Error(message));
        }),
      );
  }

  private performMockLogin(username: string, password: string, remember: boolean): Observable<string> {
    const token = `token-${username}-${Date.now()}`;

    const isValidUser = username.toLowerCase() === 'semmmm001';
    const isValidPassword = password === 'p@ssw0rd!';

    if (!isValidUser || !isValidPassword) {
      return of(null).pipe(
        delay(600),
        map(() => {
          throw new Error('Invalid SEMMM001 credentials.');
        }),
      );
    }

    return of(token).pipe(
      delay(600),
      tap((issuedToken) => {
        if (remember) {
          this.tokenStorage.persist(issuedToken);
        } else {
          this.tokenStorage.rememberForSession(issuedToken);
        }
      }),
      map(() => token),
    );
  }

  private buildLegacyLoginUrl(): string {
    const base = environment.apiBaseUrl.replace(/\/$/, '');
    const path = environment.legacyAuthPath.replace(/^\//, '');
    return `${base}/${path}`;
  }

  private resolveHttpError(error: HttpErrorResponse): string {
    if (error.status === 0) {
      return 'Unable to reach the legacy authentication endpoint. Check network and VPN connectivity.';
    }

    if (error.status === 401 || error.status === 403) {
      return 'Legacy system rejected the provided credentials.';
    }

    if (error.status >= 500) {
      return 'Legacy authentication service reported an internal error. Please try again later.';
    }

    return error.error?.message ?? 'Unexpected error while contacting the legacy authentication service.';
  }
}
