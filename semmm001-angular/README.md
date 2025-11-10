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

## License

This proof of concept is provided as-is for internal evaluation.
