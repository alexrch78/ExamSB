package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObject.BasePage;

public class UdemyBasePage extends BasePage {
	
	public UdemyBasePage(WebDriver driver) {
		super(driver);
		driver.navigate().to(URL);
	}
	
	private final String URL = "https://www.udemy.com/";
	private final By LOGIN = By.cssSelector("[data-purpose=\"header-login\"]");

	public UdemyLoginPage goToLogin() {
		driver.findElement(LOGIN).click();
		return new UdemyLoginPage(driver);
	}

}
