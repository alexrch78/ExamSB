package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import helpers.SeleniumHelper;
import pageObject.BasePage;

public class UdemyBasePage extends BasePage {
	
	public UdemyBasePage(WebDriver driver) {
		super(driver);
		driver.navigate().to(URL);
	}
	
	private final String URL = "https://www.udemy.com/";
	private final By LOGIN = By.cssSelector("[data-purpose=\"header-login\"]");

	public UdemyLoginPage goToLogin() {
		wait.until(ExpectedConditions.numberOfElementsToBe(LOGIN, 1));
		SeleniumHelper.clickElementWithJS(driver, LOGIN);
		return new UdemyLoginPage(driver);
	}

}
