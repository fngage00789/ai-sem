import { Component, EventEmitter, Output, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

import { AuthService } from '../shared/auth.service';

@Component({
  selector: 'login-screen',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  @Output() loginSuccess = new EventEmitter<{ username: string; token: string }>();

  loginForm: FormGroup;
  revealPassword = signal(false);
  errorMessage = signal('');

  constructor(private fb: FormBuilder, private authService: AuthService) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      rememberMe: [false],
    });
  }

  get usernameInvalid() {
    const control = this.loginForm.get('username');
    return control?.touched && control?.invalid;
  }

  get passwordInvalid() {
    const control = this.loginForm.get('password');
    return control?.touched && control?.invalid;
  }

  toggleReveal() {
    this.revealPassword.update((value) => !value);
  }

  submit() {
    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      return;
    }

    const { username, password, rememberMe } = this.loginForm.getRawValue() as {
      username: string;
      password: string;
      rememberMe: boolean;
    };

    this.authService.login(username, password, rememberMe).subscribe({
      next: (token) => {
        this.errorMessage.set('');
        this.loginSuccess.emit({ username, token });
      },
      error: (err) => {
        this.errorMessage.set(err.message ?? 'Unable to authenticate.');
      },
    });
  }
}
