package logic.applogicr;

import logic.applogici.ApplicationManager;
import logic.applogici.NavigationHelper;
import logic.model.User;

/**
 * Created by alaktionov on 31.10.2014.
 */
public class NavigationHelperRealisation extends DriverBasedHelper implements NavigationHelper {


    public NavigationHelperRealisation(ApplicationManagerRealisation manager) {
        super(manager.getWebDriver());
        this.baseURL = manager.getBaseUrl();
    }

    private String baseURL;

    @Override
    public void openMainPage() {
        driver.get(baseURL);
    }

    @Override
    public void openRelativeUrl(String url) {
        driver.get(baseURL + url);
    }
}
