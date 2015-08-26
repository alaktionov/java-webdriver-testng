package logic.applogici;


/**
 * Created by alaktionov on 31.10.2014.
 */
public interface ApplicationManager {
    UserHelper getUserHelper();
    NavigationHelper getNavigationHelper();

    void stop();
}
