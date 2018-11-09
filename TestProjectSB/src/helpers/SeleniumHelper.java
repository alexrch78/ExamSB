package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHelper {
	
	public static void moseOverElement(WebDriver driver, WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}

}
