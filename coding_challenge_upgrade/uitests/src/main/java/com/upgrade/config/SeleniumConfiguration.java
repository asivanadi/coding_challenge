package com.upgrade.config;

public enum SeleniumConfiguration {
    INSTANCE;

    private final String browser;

    SeleniumConfiguration() {
        this.browser = System.getenv("BROWSER");
    }

    public String getBrowser() {
        return this.browser;
    }
}
