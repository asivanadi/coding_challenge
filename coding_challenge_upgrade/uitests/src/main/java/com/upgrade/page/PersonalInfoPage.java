package com.upgrade.page;

import com.upgrade.uiframework.ElementType;
import com.upgrade.uiframework.PageElement;
import com.upgrade.uiframework.SeleniumEngine;

public class PersonalInfoPage {
    public static final PageElement BORROWER_FIRST_NAME
            = new PageElement(ElementType.NAME, "borrowerFirstName");
    public static final PageElement BORROWER_LAST_NAME
            = new PageElement(ElementType.NAME, "borrowerLastName");
    public static final PageElement BORROWER_STREET
            = new PageElement(ElementType.NAME, "borrowerStreet");
    public static final PageElement BORROWER_STREET_FIRST_SUGGESTION
            = new PageElement(ElementType.XPATH, "//ul[@id='geosuggest__list--borrowerStreet']/li[1]");
    public static final PageElement BORROWER_CITY
            = new PageElement(ElementType.NAME, "borrowerCity");
    public static final PageElement BORROWER_DOB
            = new PageElement(ElementType.NAME, "borrowerDateOfBirth");
    public static final PageElement SUBMIT_BUTTON
            = new PageElement(ElementType.XPATH, "//button[@type='submit']");
    public static final PageElement BORROWER_INCOME
            = new PageElement(ElementType.NAME, "borrowerIncome");
    public static final PageElement BORROWER_ADD_INCOME
            = new PageElement(ElementType.NAME, "borrowerAdditionalIncome");
    public static final PageElement USERNAME
            = new PageElement(ElementType.NAME, "username");
    public static final PageElement PASSWORD
            = new PageElement(ElementType.NAME, "password");
    public static final PageElement ACCEPT_CONDITIONS
            = new PageElement(ElementType.XPATH, "//label/div");
    final SeleniumEngine seleniumEngine= new SeleniumEngine();

    public void submitPersonalInfo(String firstName, String lastName, String streetAddress,
                                   String dob, String income, String addincome, String userName, String password) {
        seleniumEngine.sendKeys(PersonalInfoPage.BORROWER_FIRST_NAME, firstName);
        seleniumEngine.sendKeys(PersonalInfoPage.BORROWER_LAST_NAME, lastName);
        seleniumEngine.sendKeys(PersonalInfoPage.BORROWER_STREET, streetAddress);
        seleniumEngine.click(PersonalInfoPage.BORROWER_STREET_FIRST_SUGGESTION);
        seleniumEngine.sendKeys(PersonalInfoPage.BORROWER_DOB, dob);
        seleniumEngine.click(PersonalInfoPage.SUBMIT_BUTTON);
        seleniumEngine.sendKeys(PersonalInfoPage.BORROWER_INCOME, income);
        seleniumEngine.sendKeys(PersonalInfoPage.BORROWER_ADD_INCOME, addincome);
        seleniumEngine.doubleclick(PersonalInfoPage.SUBMIT_BUTTON);
        seleniumEngine.sendKeys(PersonalInfoPage.USERNAME, userName);
        seleniumEngine.sendKeys(PersonalInfoPage.PASSWORD, password);
        seleniumEngine.click(PersonalInfoPage.ACCEPT_CONDITIONS);
        seleniumEngine.click(PersonalInfoPage.SUBMIT_BUTTON);
    }
}
