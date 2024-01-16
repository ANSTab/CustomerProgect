package pages;

import com.microsoft.playwright.Page;
import enums.ActivitiesRelatedToBooks;

import static pages.HomePage.logger;

public class MyBooksPage extends HomePage {
    private Page page;

    public MyBooksPage(Page page) {
        super(page);
        this.page = page;
    }

    private final String booksLabel = "//*[contains(@class,'disguised-select')]//*[text()='Books']";

    public boolean isMyBooksHeaderContainsProfileName(String profileName) {
        logger.info(String.format("Is My Books Header Contains '%s' Profile Name", profileName));
        waitUntilLoaded();
        return page.locator(String.format("//*[@class='section-header' and text()='%s']", profileName.toLowerCase())).isVisible();
    }

    public boolean isActivitiesRelatedToBooksShown(ActivitiesRelatedToBooks action) {
        logger.info(String.format("Is '%s' Activities Related To Books", action.getName()));
        return page.locator(String.format("//*[@class='details-content']//*[text()='My Loans']", action.getName())).isVisible();
    }

    @Override
    public void waitUntilLoaded() {
        page.waitForSelector("//*[@class='mybooks']").isVisible();
    }
}
