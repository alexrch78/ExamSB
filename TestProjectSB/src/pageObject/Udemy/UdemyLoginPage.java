package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObject.BasePage;

public class UdemyLoginPage extends BasePage {

	private final By EMAIL = By.name("email");
	private final By PASSWORD = By.name("password");
	
	public UdemyLoginPage(WebDriver driver) {
		super(driver);
	}

	public UdemyHomePage performLogin(String username, String password) {
		driver.findElement(EMAIL).sendKeys(username);
		driver.findElement(PASSWORD).sendKeys(password);
		return new UdemyHomePage(driver);
	}
	 

}
