package ru.sazonov.clients;

import static ru.sazonov.ApiSpecifications.base;

public final class HttpClientFactory {
    private HttpClientFactory() {
    }

    public static AdminApiClient createAdminClient() {
        return new AdminApiClient(base());
    }

    public static AuthHttpClient createAuthClient() {
        return new AuthHttpClient(base());
    }
}
