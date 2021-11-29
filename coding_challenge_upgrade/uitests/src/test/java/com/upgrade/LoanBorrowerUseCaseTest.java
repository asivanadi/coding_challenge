package com.upgrade;

import com.github.javafaker.Faker;
import com.upgrade.page.OfferPage;
import com.upgrade.page.PersonalInfoPage;
import com.upgrade.page.PortalLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.upgrade.page.NonDMFFunnelPage;
import com.upgrade.uiframework.SeleniumEngine;
import com.upgrade.uiframework.WebDriverBase;

import java.util.UUID;

public class LoanBorrowerUseCaseTest extends WebDriverBase {
    final static NonDMFFunnelPage nonDMFFunnelPage = new NonDMFFunnelPage();
    final static PortalLoginPage portalLoginPage = new PortalLoginPage();
    final static PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    final static OfferPage offerPage = new OfferPage();
    final static SeleniumEngine seleniumEngine = new SeleniumEngine();
    final static Faker faker = new Faker();

    @Test
    void test() {
        final String streetAddress = "1650 Homestead Road";
        final String userName = String.format("%s%s@upgrade-challenge.com.com", "asivanadi", UUID.randomUUID().toString());
        final String password = "dvyWSPa6R9Fy5Vn";
        nonDMFFunnelPage.navigateToPage();
        nonDMFFunnelPage.checkRate();
        personalInfoPage.submitPersonalInfo(faker.name().firstName(), faker.name().lastName(), streetAddress, "01/01/1990",
                "120,000", "5,000", userName, password);
        seleniumEngine.waitUntilVisible(OfferPage.LOAN_AMOUNT);
        Assertions.assertTrue(seleniumEngine.getCurrentUrl().contains(OfferPage.pageURI));

        //Collect all the values
        String loanAmount = seleniumEngine.getText(OfferPage.LOAN_AMOUNT);
        String monthlyPayment = seleniumEngine.getText(OfferPage.MONTHLY_PAYMENT);
        String term = seleniumEngine.getText(OfferPage.TERM);
        String interestRate = seleniumEngine.getText(OfferPage.INTEREST_RATE);
        String apr = seleniumEngine.getText(OfferPage.APR);

        offerPage.signOut();
        portalLoginPage.navigateToPage();
        portalLoginPage.portalLogin(userName, password);
        seleniumEngine.waitUntilVisible(OfferPage.LOAN_AMOUNT);

        // Assert all the values
        Assertions.assertEquals(loanAmount, seleniumEngine.getText(OfferPage.LOAN_AMOUNT));
        Assertions.assertEquals(monthlyPayment, seleniumEngine.getText(OfferPage.MONTHLY_PAYMENT));
        Assertions.assertEquals(term, seleniumEngine.getText(OfferPage.TERM));
        Assertions.assertEquals(interestRate, seleniumEngine.getText(OfferPage.INTEREST_RATE));
        Assertions.assertEquals(apr, seleniumEngine.getText(OfferPage.APR));
    }
}