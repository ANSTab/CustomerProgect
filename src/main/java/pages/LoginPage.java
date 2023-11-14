package pages;

import com.codeborne.selenide.SelenideElement;
import tools.WebElementUtils;
import user.User;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends HomePage {

    private final SelenideElement loginInput = $x("//*[@type='email']");
    private final SelenideElement passwordInput = $x("//*[@type='password']");
    private final SelenideElement logInButton = $x("//button[@title='Log In']");

    public HomePage setCredentials(String email, String password) {
        logger.info("Set Credentials of profile from properties");
        WebElementUtils.shouldBeVisible(loginInput).click();
        loginInput.setValue(email);
        WebElementUtils.shouldBeVisible(passwordInput).click();
        passwordInput.setValue(password);
        return this;
    }

    public ProfilePage setCredentialsAndOpenProfilePage(String email, String password) {
        logger.info("Set Credentials and open profile page");
        setCredentials(email, password);
        WebElementUtils.shouldBeVisible(logInButton).click();
        return new ProfilePage();
    }

}
