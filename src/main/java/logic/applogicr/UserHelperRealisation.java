package logic.applogicr;

import logic.applogici.UserHelper;
import logic.model.User;


/**
 * Created by alaktionov on 31.10.2014.
 */
public class UserHelperRealisation extends DriverBasedHelper implements UserHelper{
    public UserHelperRealisation(ApplicationManagerRealisation manager) {
        super(manager.getWebDriver());
    }


    @Override
    public void loginAs(User user) {

    }

    @Override
    public void logout() {

    }
}
