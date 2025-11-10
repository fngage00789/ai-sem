import { Injectable } from '@angular/core';
import { delay, map, Observable, of, throwError } from 'rxjs';

import { TokenStorageService } from './token-storage.service';

@Injectable()
export class AuthService {
  constructor(private tokenStorage: TokenStorageService) {}

  login(username: string, password: string, remember: boolean): Observable<string> {
    if (!username || !password) {
      return throwError(() => new Error('Username and password are required.'));
    }

    const trimmedUser = username.trim();
    const token = `token-${trimmedUser}-${Date.now()}`;

    const isValidUser = trimmedUser.toLowerCase() === 'semmmm001';
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
      map((issuedToken) => {
        if (remember) {
          this.tokenStorage.persist(issuedToken);
        } else {
          this.tokenStorage.rememberForSession(issuedToken);
        }

        return issuedToken;
      }),
    );
  }
}
