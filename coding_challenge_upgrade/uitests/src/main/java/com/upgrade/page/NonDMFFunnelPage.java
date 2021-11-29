package com.upgrade.page;

import com.upgrade.config.CredifyConfiguration;
import com.upgrade.uiframework.ElementType;
import com.upgrade.uiframework.PageElement;
import com.upgrade.uiframework.SeleniumEngine;

public class NonDMFFunnelPage implements HomePage {
        private final CredifyConfiguration credifyConfiguration;
        public static final String pageURI = "/funnel/nonDMFunnel";
        public static final PageElement LOAN_AMOUNT_TEXT_FIELD
                = new PageElement(ElementType.NAME, "desiredAmount");
        public static final PageElement LOAN_PURPOSE_DROPDOWN
                = new PageElement(ElementType.NAME, "loan-purpose");
        public static final PageElement CHECK_YOUR_RATE_BUTTON
                = new PageElement(ElementType.XPATH, "//button[@type='submit']");
        final SeleniumEngine seleniumEngine= new SeleniumEngine();

        public NonDMFFunnelPage() {
                this.credifyConfiguration = CredifyConfiguration.INSTANCE;
        }

        @Override
        public void navigateToPage() {
                seleniumEngine.navigate(String.format("%s%s", credifyConfiguration.getWebUrl(), pageURI));
        }

        public void checkRate() {
                seleniumEngine.sendKeys(NonDMFFunnelPage.LOAN_AMOUNT_TEXT_FIELD, "2000");
                seleniumEngine.selectOptionbyText(NonDMFFunnelPage.LOAN_PURPOSE_DROPDOWN, "Large Purchase");
                seleniumEngine.click(NonDMFFunnelPage.CHECK_YOUR_RATE_BUTTON);
        }

}
