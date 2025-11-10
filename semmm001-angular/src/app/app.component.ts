import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { AuthService } from './shared/auth.service';
import { TokenStorageService } from './shared/token-storage.service';

@Component({
  selector: 'semmm001-root',
  standalone: true,
  imports: [CommonModule, LoginComponent],
  providers: [AuthService, TokenStorageService],
  template: `
    <main class="app-shell">
      <section class="brand-panel">
        <h1>SEMMM001 Console</h1>
        <p class="tagline">Modernized access portal built with Angular.</p>
      </section>
      <section class="content-panel">
        <login-screen (loginSuccess)="onLogin($event)"></login-screen>
        <article *ngIf="lastLogin" class="login-result">
          <h2>Last login</h2>
          <p>User: {{ lastLogin.username }}</p>
          <p>Token: {{ lastLogin.token }}</p>
        </article>
      </section>
    </main>
  `,
  styles: [
    `
      :host {
        display: block;
        min-height: 100vh;
        background: linear-gradient(120deg, #152238, #1b2b4b);
        color: #1f2937;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      }

      .app-shell {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
        min-height: 100vh;
      }

      .brand-panel {
        padding: 4rem 3rem;
        color: #f9fafb;
        display: flex;
        flex-direction: column;
        justify-content: center;
        background: radial-gradient(circle at top left, rgba(255, 255, 255, 0.15), transparent 60%),
          linear-gradient(180deg, rgba(15, 23, 42, 0.9), rgba(15, 23, 42, 0.7));
      }

      .brand-panel h1 {
        font-size: 2.8rem;
        margin-bottom: 1rem;
      }

      .tagline {
        font-size: 1.05rem;
        max-width: 360px;
        line-height: 1.6;
        opacity: 0.85;
      }

      .content-panel {
        display: flex;
        flex-direction: column;
        justify-content: center;
        padding: 3rem 1.5rem;
        background-color: #f3f4f6;
      }

      .login-result {
        margin-top: 2rem;
        padding: 1.5rem;
        border-radius: 0.75rem;
        background-color: #ffffff;
        box-shadow: 0 20px 45px -20px rgba(30, 64, 175, 0.4);
      }

      .login-result h2 {
        margin-top: 0;
        margin-bottom: 0.75rem;
        color: #1f2937;
      }

      @media (max-width: 768px) {
        .brand-panel {
          text-align: center;
          padding: 2.5rem 1.5rem;
        }

        .tagline {
          margin: 0 auto;
        }
      }
    `,
  ],
})
export class AppComponent {
  lastLogin: { username: string; token: string } | null = null;

  onLogin(event: { username: string; token: string }) {
    this.lastLogin = event;
  }
}
