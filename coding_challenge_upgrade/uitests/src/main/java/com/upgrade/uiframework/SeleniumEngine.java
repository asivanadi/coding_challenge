package com.upgrade.uiframework;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

public class SeleniumEngine extends WebDriverBase{
    public static final int DEFAULT_WAIT_TIMEOUT = 180;

    private static By getByElement(final ElementType elementType, final String element) {
        switch(elementType) {
            case XPATH:
                return By.xpath(element);
            case CSS_SELECTOR:
                return By.cssSelector(element);
            case ID:
                return By.id(element);
            case NAME:
                return By.name(element);
            default:
                throw new RuntimeException(String.format("Type %s Not Supported", elementType));
        }
    }

    public static WebElement getWebElement(By by) {
        try {
            getDriver().findElement(by);
            return getDriver().findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    @Step("Wait until clickable for the element {0}")
    public void waitForByElementClickable(final PageElement pageElement) {
        final By byElement = this.getByElement(pageElement.getElementType(), pageElement.getElement());
        Objects.requireNonNull(byElement);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(webDriver -> ExpectedConditions.elementToBeClickable(byElement));
    }

    @Step("Navigating to {0}")
    public void navigate(final String text) {
        getDriver().get(text);
        waitForPageToLoad();
    }

    public boolean waitForPageToLoad() {
        return new WebDriverWait(getDriver(), DEFAULT_WAIT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @Step("Selecting option for com.upgrade.page element {0}, text {1}")
    public void selectOptionbyText(final PageElement pageElement, final String text) {
        final By byElement = this.getByElement(pageElement.getElementType(), pageElement.getElement());
        this.waitUntilVisible(pageElement);
        new Select(getDriver().findElement(byElement)).selectByVisibleText(text);
    }

    @Step("Sending keys for com.upgrade.page element {0}, text {1}")
    public void sendKeys(final PageElement pageElement, final String text) {
        final By byElement = this.getByElement(pageElement.getElementType(), pageElement.getElement());
        this.waitUntilVisible(pageElement);
        Objects.requireNonNull(getWebElement(byElement)).sendKeys(text);
    }

    @Step("Performing click for com.upgrade.page element {0}")
    public void click(PageElement pageElement) {
        final By byElement = this.getByElement(pageElement.getElementType(), pageElement.getElement());
        this.waitUntilVisible(pageElement);
        this.waitForByElementClickable(pageElement);
        Objects.requireNonNull(getWebElement(byElement)).click();
    }

    @Step("Performing click for com.upgrade.page element {0}")
    public void doubleclick(PageElement pageElement) {
        final By byElement = this.getByElement(pageElement.getElementType(), pageElement.getElement());
        this.waitUntilVisible(pageElement);
        Objects.requireNonNull(getWebElement(byElement)).click();
        Objects.requireNonNull(getWebElement(byElement)).click();
    }

    @Step("Get text for page element {0}")
    public String getText(final PageElement pageElement) {
        final By byElement = this.getByElement(pageElement.getElementType(), pageElement.getElement());
        this.waitUntilVisible(pageElement);
        return Objects.requireNonNull(getWebElement(byElement)).getText();
    }

    @Step("Wait for {0} milliseconds")
    public void waitFor(final long timeInMilliseconds) {
        try {
            Thread.sleep(timeInMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Wait until visible for the element {0}")
    public void waitUntilVisible(final PageElement pageElement) {
        final By byElement = this.getByElement(pageElement.getElementType(), pageElement.getElement());
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver ) {
                return driver.findElement(byElement);
            }
        });
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

}
