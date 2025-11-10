const apiBaseUrl = (import.meta.env.VITE_API_BASE_URL as string | undefined)?.trim();
const legacyAuthPath = (import.meta.env.VITE_LEGACY_AUTH_PATH as string | undefined)?.trim();

export const environment = {
  production: import.meta.env.PROD ?? false,
  apiBaseUrl: apiBaseUrl && apiBaseUrl.length > 0 ? apiBaseUrl : 'https://api.example.com',
  useLegacyApi: (import.meta.env.VITE_USE_LEGACY_API as string | undefined)?.toLowerCase() === 'true',
  legacyAuthPath: legacyAuthPath && legacyAuthPath.length > 0 ? legacyAuthPath : '/legacy/auth/login',
  legacyClientId: (import.meta.env.VITE_LEGACY_CLIENT_ID as string | undefined) ?? 'SEMMM001_PORTAL',
};
