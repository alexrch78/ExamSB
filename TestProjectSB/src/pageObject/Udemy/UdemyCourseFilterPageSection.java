package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import enums.FilterCategories;
import enums.FilterOptions;
import helpers.SeleniumHelper;
import pageObject.BasePage;

public class UdemyCourseFilterPageSection extends BasePage {

	private final By APPLY = By.className("btn-secondary");
	private final By FILTER_LAYER = By.xpath("//div[contains(@class,'search-loader--loading-container')]");
	
	
	public UdemyCourseFilterPageSection(WebDriver driver) {
		super(driver);
	}

	public UdemyRelevantCoursesPage chooseFilter(FilterCategories category, FilterOptions option) {
		WebElement filterContainer = getContainerElement(category.getValue());
		String optionXpath = String.format(".//label[span/span='%s']/span", option.getValue());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
		WebElement priceElement = filterContainer.findElement(By.xpath(optionXpath));
		priceElement.click();
		wait.until(ExpectedConditions.elementToBeClickable(APPLY));
		SeleniumHelper.clickElementWithJS(driver, APPLY);
		wait.until(ExpectedConditions.numberOfElementsToBe(FILTER_LAYER, 0));
		return new UdemyRelevantCoursesPage(driver);
	}

	private WebElement getContainerElement(String category) {
		String xpath = String.format("//div[@class='filter--filter-container--1ZAUI' and span/text()='%s']", category);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), 0));
		return driver.findElement(By.xpath(xpath));
	}

}
