package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import enums.FilterCategories;
import enums.FilterOptions;
import pageObject.BasePage;

public class UdemyCourseFilterPageSection extends BasePage {

	private final By APPLAY = By.xpath("//button[text()='Applay']");
	
	public UdemyCourseFilterPageSection(WebDriver driver) {
		super(driver);
	}

	public void chooseFilter(FilterCategories category, FilterOptions option) {
		WebElement filterContainer = getContainerElement(category.getValue());
		String optionXpath = String.format(".//label[span/span='%s']/input", option.getValue());
		WebElement priceElement = filterContainer.findElement(By.xpath(optionXpath));
		priceElement.click();
		driver.findElement(APPLAY).click();
	}

	private WebElement getContainerElement(String category) {
		String xpath = String.format("//div[@class='filter--filter-container--1ZAUI' and span/text=%s]", category);
		return driver.findElement(By.xpath(xpath));
	}

}
