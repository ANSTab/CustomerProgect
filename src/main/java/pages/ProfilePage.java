package pages;

import com.microsoft.playwright.Page;

public class ProfilePage extends HomePage{

    private Page page;

   public ProfilePage(Page page) {
       super(page);
       this.page = page;
    }

        private final String profileTitle = "//*[@class='account-content']//*[text()='Мій профіль']";
//
//    public boolean isPhoneNumberShown(String number) {
//        logger.info("Is Phone Number Shown");
//        return Selenide.$(By.xpath(String.format("//*[contains(text(),'%s')]", number))).isDisplayed();
//    }
//
    @Override
    protected void waitUntilLoaded() {
        page.waitForSelector(profileTitle);
    }
}