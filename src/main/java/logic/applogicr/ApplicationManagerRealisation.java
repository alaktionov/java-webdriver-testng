package logic.applogicr;


import logic.applogici.ApplicationManager;
import logic.applogici.NavigationHelper;
import logic.applogici.UserHelper;
import logic.util.Browser;
import logic.util.PropertyLoader;
import logic.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by alaktionov on 31.10.2014.
 */
public class ApplicationManagerRealisation implements ApplicationManager{
    private UserHelper userHelper;
    private NavigationHelper navHelper;

    private WebDriver driver;
    private String baseUrl;

    public ApplicationManagerRealisation() {
        baseUrl = PropertyLoader.loadProperty("site.url");
        String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
        Browser browser = new Browser();
        browser.setName(PropertyLoader.loadProperty("browser.name"));
        browser.setVersion(PropertyLoader.loadProperty("browser.version"));
        browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

        String username = PropertyLoader.loadProperty("user.username");
        String password = PropertyLoader.loadProperty("user.password");

        driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        userHelper = new UserHelperRealisation(this);


        getNavigationHelper().openMainPage();
    }

    @Override
    public UserHelper getUserHelper() {
        return userHelper;
    }

    @Override
    public NavigationHelper getNavigationHelper() {
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
