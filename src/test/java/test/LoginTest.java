package test;

import logic.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

	@Test
	public void login() {
		User user = new User().setEmail("laktionov_artem@ukr.net").setPassword("qv6969700");

		app.getUserHelper().loginAs(user);
		Assert.assertTrue(app.getUserHelper().isLoggedIn());
	}
}
