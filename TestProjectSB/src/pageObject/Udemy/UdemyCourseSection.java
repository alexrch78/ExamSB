package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UdemyCourseSection {
	
	private static By PRICE = By.cssSelector("[data-purpose=\"course-price-text\"]");
	private static By TITLE = By.cssSelector("[data-purpose=\"search-course-card-title\"]");
	private WebElement rootElement;

	public UdemyCourseSection(WebElement rootElement) {
		this.rootElement = rootElement;
	}

	public boolean isFree() {
		WebElement priceElement = rootElement.findElement(PRICE);
		String priceText = priceElement.getAttribute("innerText");
		boolean isFree = priceText.contains("Free");
		return isFree;
	}

	public String getTitle() {
		return rootElement.findElement(TITLE).getAttribute("innerText");
	}
}
