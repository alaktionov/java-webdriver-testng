package logic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * PageManager manages pages as well as ApplicationManager manages logic
 * The main object of PageManage is initialisation of pages
 */

public class PageManager {
    private WebDriver driver;
    public LoginPage loginPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = initElements(new LoginPage(this));
    }

    private <T extends Page> T initElements(T page) {
        //PageFactory.initElements(driver, help); //- init elements using implicitly waits
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), help); //- init elements using explicitly waits
        PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 30), page); //- init elements when they are visible on the page
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}

