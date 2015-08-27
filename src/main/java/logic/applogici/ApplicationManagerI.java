package logic.applogici;

/**
 * Created by alaktionov on 31.10.2014.
 */
public interface ApplicationManagerI {
    UserHelperI getUserHelper();
    NavigationHelperI getNavigationHelper();

    void stop();
}
