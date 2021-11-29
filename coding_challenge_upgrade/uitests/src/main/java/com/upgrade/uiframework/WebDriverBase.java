package com.upgrade.uiframework;

import com.upgrade.config.SeleniumConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBase {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        switch (SeleniumConfiguration.INSTANCE.getBrowser()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException("Specified browser " + SeleniumConfiguration.INSTANCE.getBrowser() +
                        " is not supported. Supported Browsers are chrome/firefox.");
        }

    }

    @AfterEach
    void teardown() {
        driver.get().close();
        driver.remove();
    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }
}


