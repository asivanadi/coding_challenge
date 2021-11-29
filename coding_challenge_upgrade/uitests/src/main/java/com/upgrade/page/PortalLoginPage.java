package com.upgrade.page;

import com.upgrade.config.CredifyConfiguration;
import com.upgrade.uiframework.ElementType;
import com.upgrade.uiframework.PageElement;
import com.upgrade.uiframework.SeleniumEngine;

public class PortalLoginPage implements HomePage{
    public static final String pageURI = "/portal/login";
    public static final PageElement USERNAME
            = new PageElement(ElementType.NAME, "username");
    public static final PageElement PASSWORD
            = new PageElement(ElementType.NAME, "password");
    public static final PageElement SIGN_IN_BUTTON
            = new PageElement(ElementType.XPATH, "//button[@type='submit']");
    final SeleniumEngine seleniumEngine= new SeleniumEngine();
    private final CredifyConfiguration credifyConfiguration;

    public PortalLoginPage() {
        this.credifyConfiguration = CredifyConfiguration.INSTANCE;
    }

    @Override
    public void navigateToPage() {
        seleniumEngine.navigate(String.format("%s%s", credifyConfiguration.getWebUrl(), pageURI));
    }

    public void portalLogin(String userName, String password) {
        seleniumEngine.sendKeys(PortalLoginPage.USERNAME, userName);
        seleniumEngine.sendKeys(PortalLoginPage.PASSWORD, password);
        seleniumEngine.click(PortalLoginPage.SIGN_IN_BUTTON);
    }
}
