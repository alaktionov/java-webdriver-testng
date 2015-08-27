package logic.applogicr;

import logic.applogici.UserHelperI;
import logic.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


/**
 * Created by alaktionov on 31.10.2014.
 */
public class UserHelper extends DriverBasedHelper implements UserHelperI {
    public UserHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }


    @Override
    public void loginAs(User user) {
        pages.loginPage.ensurePageLoaded()
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .clickLoginButton();
    }

    @Override
    public boolean isLoggedIn() {
        return wait.until(presenceOfElementLocated(By.id("blueBarNAXAnchor"))).isDisplayed();
    }

    @Override
    public void logout() {

    }
}
