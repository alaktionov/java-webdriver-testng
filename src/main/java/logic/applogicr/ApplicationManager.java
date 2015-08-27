package logic.applogicr;


import logic.applogici.ApplicationManagerI;
import logic.applogici.NavigationHelperI;
import logic.applogici.UserHelperI;
import logic.util.Browser;
import logic.util.PropertyLoader;
import logic.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by alaktionov on 31.10.2014.
 */
public class ApplicationManager implements ApplicationManagerI {
    private UserHelperI userHelper;
    private NavigationHelperI navHelper;

    private WebDriver driver;
    private String baseUrl;

    public ApplicationManager() {
        baseUrl = PropertyLoader.loadProperty("site.url");
        String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
        Browser browser = new Browser();
        browser.setName(PropertyLoader.loadProperty("browser.name"));
        browser.setVersion(PropertyLoader.loadProperty("browser.version"));
        browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

        String username = PropertyLoader.loadProperty("user.username");
        String password = PropertyLoader.loadProperty("user.password");

        driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); - active/deactivate implicitly waits

        //give this ApplicationManager to each helper to speak with all helpers through the appmanager
        userHelper = new UserHelper(this);
        navHelper = new NavigationHelper(this);

        getNavigationHelper().openMainPage();
    }

    @Override
    public UserHelperI getUserHelper() {
        return userHelper;
    }

    @Override
    public NavigationHelperI getNavigationHelper() {
        return navHelper;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }


    @Override
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
