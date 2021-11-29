package com.upgrade.page;

import com.upgrade.uiframework.ElementType;
import com.upgrade.uiframework.PageElement;
import com.upgrade.uiframework.SeleniumEngine;

public class OfferPage {
    public static final String pageURI = "/funnel/offer-page";
    public static final PageElement LOAN_AMOUNT
            = new PageElement(ElementType.XPATH,
            "(.//*[normalize-space(text()) and normalize-space(.)='Your Loan Amount'])[1]/following::span[2]");
    public static final PageElement MONTHLY_PAYMENT
            = new PageElement(ElementType.XPATH,
            "(.//*[normalize-space(text()) and normalize-space(.)='Monthly Payment'])[2]/following::div[1]");
    public static final PageElement TERM
            = new PageElement(ElementType.XPATH,
            "(.//*[normalize-space(text()) and normalize-space(.)='Term'])[1]/following::div[1]");
    public static final PageElement INTEREST_RATE
            = new PageElement(ElementType.XPATH,
            "(.//*[normalize-space(text()) and normalize-space(.)='Interest Rate'])[1]/following::div[1]");
    public static final PageElement APR
            = new PageElement(ElementType.XPATH,
            "(.//*[normalize-space(text()) and normalize-space(.)='w/ optional Autopay'])[1]/following::div[1]");

    public static final PageElement MENU_BUTTON
            = new PageElement(ElementType.XPATH,
            "//div[@id='root']/div/main/div/header/div/label");

    public static final PageElement SIGN_OUT
            = new PageElement(ElementType.XPATH,
            "//a[contains(text(),'Sign Out')]");
    final SeleniumEngine seleniumEngine= new SeleniumEngine();

    public void signOut() {
        seleniumEngine.click(OfferPage.MENU_BUTTON);
        seleniumEngine.waitFor(2000);
        seleniumEngine.click(OfferPage.SIGN_OUT);
    }
}
