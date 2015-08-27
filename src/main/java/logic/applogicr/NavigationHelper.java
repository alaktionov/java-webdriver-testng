package logic.applogicr;

import logic.applogici.NavigationHelperI;

/**
 * Created by alaktionov on 31.10.2014.
 */
public class NavigationHelper extends DriverBasedHelper implements NavigationHelperI {


    public NavigationHelper(ApplicationManager manager) {
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
