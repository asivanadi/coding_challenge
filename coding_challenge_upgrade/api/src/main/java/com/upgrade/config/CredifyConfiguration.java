package com.upgrade.config;

public enum CredifyConfiguration {
    INSTANCE;

    private final String url;
    private final String webUrl;

    CredifyConfiguration() {
        this.url = System.getenv("CREDIFY_URL");
        this.webUrl = System.getenv("CREDIFY_WEB_URL");
    }

    public String getUrl() {
        return this.url;
    }

    public String getWebUrl() {
        return this.webUrl;
    }
}
