package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObject.BaseReproducedSection;

public class UdemyCourseSection  extends BaseReproducedSection{
	
	private static By PRICE = By.xpath(".//div[contains(@class,'price-text--base-price__discount')]");
	private static By TITLE = By.cssSelector("[data-purpose=\"search-course-card-title\"]");

	public UdemyCourseSection(WebElement rootElement) {
		super(rootElement);
	}

	public boolean isFree() {
		return rootElement.findElement(PRICE).getAttribute("innerText").contains("Free");
	}

	public String getTitle() {
		return rootElement.findElement(TITLE).getAttribute("innerText");
	}
}
