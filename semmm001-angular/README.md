# semmm001 Angular POC

This project is a proof-of-concept migration of the legacy RichFaces login interface to an Angular-based single page application.  The implementation focuses on the login flow requested for the `semmmm001` user profile.

## Project Highlights

- Angular standalone application using feature-based folder structure.
- Login screen with form validation, password visibility toggle, and submit handling.
- Mock authentication service that simulates a server-side check for the `semmmm001` user.
- Token storage abstraction ready for integration with a backend or identity provider.
- Responsive styling that mirrors common enterprise layouts without depending on the legacy RichFaces stack.

## Getting Started

> **Note:** The project is intentionally lightweight and does not rely on Angular CLI to keep the POC portable inside this repository.  To work with the application using the full Angular toolchain, clone this folder into a new Git repository and run the steps below.

1. Ensure Node.js (>= 18) and npm (>= 9) are installed.
2. In a clean workspace, copy the contents of this folder and initialize a new Git repository:
   ```bash
   mkdir semmm001-angular
   cp -R /path/to/this/folder/* semmm001-angular/
   cd semmm001-angular
   git init
   ```
3. Install the dependencies:
   ```bash
   npm install
   ```
4. Run the development server:
   ```bash
   npm run start
   ```
5. Navigate to `http://localhost:4200` to interact with the login POC.

## Available Scripts

- `npm run start` – launches Vite for fast local development.
- `npm run build` – generates a production build with optimized bundles.
- `npm run test` – placeholder for future unit test integration.

## Extending the POC

- Replace the mock authentication logic in `auth.service.ts` with real API calls.
- Hook up JWT or session cookies by swapping the storage strategy in `token-storage.service.ts`.
- Add routing modules for post-login dashboards or multi-factor authentication flows.
- Integrate Angular Material or a design system of choice for enterprise-ready visuals.

## Connecting to the Legacy Database

The Angular shell is capable of authenticating against the existing SEMMM001 backend so you can keep using the legacy
database and user repository while the UI is modernized.  Configure the following environment variables in an `.env.local`
file at the project root before running `npm run start`:

```bash
VITE_USE_LEGACY_API=true
VITE_API_BASE_URL=https://legacy.sem.company.example
VITE_LEGACY_AUTH_PATH=/richfaces/services/authenticate
VITE_LEGACY_CLIENT_ID=SEMMM001_PORTAL
```

- `VITE_USE_LEGACY_API` toggles the live call path versus the built-in mock.
- `VITE_API_BASE_URL` should point to the application server that already talks to the legacy database.
- `VITE_LEGACY_AUTH_PATH` should target the endpoint that issues session cookies or tokens for the RichFaces stack.
- `VITE_LEGACY_CLIENT_ID` is passed through for auditing; keep the default or set the identifier that your backend expects.

The values are read inside `src/environments/environment.ts`, and the `AuthService` (`src/app/shared/auth.service.ts`)
will POST `username`, `password`, and the optional `rememberMe` flag to the configured endpoint.  Successful responses
that include a `token`, `accessToken`, or `userToken` field are automatically persisted using the existing token storage
utility, so downstream modules can keep using the legacy database session.

## License

This proof of concept is provided as-is for internal evaluation.
