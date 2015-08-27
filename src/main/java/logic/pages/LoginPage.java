package logic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Sample page
 */

public class LoginPage extends AnyPage {
	public LoginPage(PageManager pages) {
		super(pages);
	}

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "pass")
	private WebElement passwordField;

	@FindBy(id = "loginbutton")
	private WebElement loginButton;

	public LoginPage enterEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}

	public LoginPage enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
		return this;
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public LoginPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("login_form")));
		wait.until(presenceOfElementLocated(By.id("reg_box")));
		return this;
	}
}
