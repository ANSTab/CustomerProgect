package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage extends HomePage {

    private Page page;

    public LoginPage(Page page) {
        super(page);
        this.page = page;
    }
    private String emailId = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
    private String emailInput = "//*[@type='email']";
    private String password_1 = "//*[@type='password']";
    private String loginButton = "//button[@title='Log In']";

    public String getLoginPageTitle() {
        return page.title();
    }

    @Step("Set credentials: '{0}' email, '{1}' password")
    public LoginPage setCredentials(String email, String password) {
        logger.info("Set Credentials of profile from properties");
        page.waitForSelector(emailInput).fill(email);
        page.waitForSelector(password_1).fill(password);
        return this;
    }

    @Step("Set credentials: '{0}' email, '{1}' password")
    public ProfilePage setCredentialsAndOpenProfilePage(String email, String password) {
        logger.info("Set Credentials and open profile page");
        setCredentials(email, password);
        page.click(loginButton);
        return new ProfilePage(page);
    }
}
