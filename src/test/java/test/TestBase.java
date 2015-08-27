package test;


import logic.applogici.ApplicationManagerI;
import logic.applogicr.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

/**
 * Created by alaktionov on 31.10.2014.
 */
public class TestBase {
    protected ApplicationManagerI app;

    @BeforeMethod
    public void init() {
        app = new ApplicationManager();
    }

    @BeforeMethod
    public void mayBeLogout() {
        if (app.getUserHelper().isLoggedIn()) {
            app.getUserHelper().logout();
        }
    }

    @AfterSuite
    public void stop() {
        app.stop();
        System.out.println("Closing Browser");
    }
}