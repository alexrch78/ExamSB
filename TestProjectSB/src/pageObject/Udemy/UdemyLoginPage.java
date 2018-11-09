package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObject.BasePage;

public class UdemyLoginPage extends BasePage {

	private final By EMAIL = By.name("email");
	private final By PASSWORD = By.name("password");
	private final By LOGIN_FORM = By.name("login-form");
	private final By SUBMIT = By.name("submit");
	
	public UdemyLoginPage(WebDriver driver) {
		super(driver);
	}

	public UdemyHomePage performLogin(String username, String password) {
		wait.until(ExpectedConditions.numberOfElementsToBe(EMAIL, 1));
		driver.findElement(EMAIL).sendKeys(username);
		driver.findElement(PASSWORD).sendKeys(password);
		driver.findElement(SUBMIT).click();
		wait.until(ExpectedConditions.numberOfElementsToBe(LOGIN_FORM, 0));
		return new UdemyHomePage(driver);
	}
	 

}
