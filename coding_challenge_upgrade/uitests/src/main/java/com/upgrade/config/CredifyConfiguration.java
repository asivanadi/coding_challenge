package com.upgrade.config;

public enum CredifyConfiguration {
    INSTANCE;

    private final String webUrl;

    CredifyConfiguration() {
        this.webUrl = System.getenv("CREDIFY_WEB_URL");
    }

    public String getWebUrl() {
        return this.webUrl;
    }
}
