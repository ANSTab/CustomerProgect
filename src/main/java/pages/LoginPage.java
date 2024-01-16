package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class LoginPage extends HomePage {

    private Page page;

    // 1. String Locators - OR
    private String emailId = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    private String emailInput = "//*[@type='email']";
    private String password_1 = "//*[@type='password']";
    private String loginButton = "//button[@title='Log In']";

    // 2. page constructor:
    public LoginPage(Page page) {
        super(page);
        this.page = page;
    }

    // 3. page actions/methods:
    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgotPwdLinkExist() {
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String appUserName, String appPassword) {
        System.out.println("App creds: " + appUserName + ":" + appPassword);
        page.fill(emailId, appUserName);
        page.fill(password, appPassword);
        page.click(loginBtn);
        page.locator(logoutLink).waitFor();
        if (page.locator(logoutLink).isVisible()) {
            System.out.println("user is logged in successfully....");
            return true;
        } else {
            System.out.println("user is not logged in successfully....");
            return false;
        }
    }


//    private final ElementHandle logInButton = page.waitForSelector("//button[@title='Log In']");

    //    private final Page page;
//
//    public LoginPage(Page page) {
//        this.page = page;
//    }
//
//
    public LoginPage setCredentials(String email, String password) {
        logger.info("Set Credentials of profile from properties");
        page.waitForSelector(emailInput).fill(email);
        page.waitForSelector(password_1).fill(password);
        return this;
    }


    public ProfilePage setCredentialsAndOpenProfilePage(String email, String password) {
        logger.info("Set Credentials and open profile page");
        setCredentials(email, password);
        page.click(loginButton);
        return new ProfilePage(page);
    }

}
