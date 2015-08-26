package logic.applogici;

import logic.model.User;

/**
 * Created by alaktionov on 31.10.2014.
 */
public interface UserHelper {
    void loginAs(User user);
    void logout();
}
