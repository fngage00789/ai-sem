import { Injectable } from '@angular/core';

const TOKEN_KEY = 'semmm001-token';

@Injectable()
export class TokenStorageService {
  persist(token: string) {
    if (typeof localStorage !== 'undefined') {
      localStorage.setItem(TOKEN_KEY, token);
    }
  }

  rememberForSession(token: string) {
    if (typeof sessionStorage !== 'undefined') {
      sessionStorage.setItem(TOKEN_KEY, token);
    }
  }

  clear() {
    if (typeof localStorage !== 'undefined') {
      localStorage.removeItem(TOKEN_KEY);
    }

    if (typeof sessionStorage !== 'undefined') {
      sessionStorage.removeItem(TOKEN_KEY);
    }
  }
}
