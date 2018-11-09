package pageObject.Udemy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObject.BasePage;

public class UdemyRelevantCoursesPage extends BasePage {

	private final By FILTERS_CLICK = By.xpath("//button[contains(@class, 'all-filters-toggle--all-filters-toggle')]");
	private final By CONTAINER = By.xpath("//div[contains(@class,'search-result-page--results-container')]");
	private final By SINGLE_COURSE = By.xpath(".//div[contains(@class,'course-card-list--course-card-wrapper')]");
	
	public UdemyRelevantCoursesPage(WebDriver driver) {
		super(driver);
	}

	public List<UdemyCourseSection> getCoursesSections() {
		List<UdemyCourseSection> output = new ArrayList<UdemyCourseSection>();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(CONTAINER, 0));
		wait.until(ExpectedConditions.presenceOfElementLocated(CONTAINER));
		List<WebElement>containerChildren = driver.findElement(CONTAINER).findElements(SINGLE_COURSE);
		for(WebElement courseElement : containerChildren){
			output.add(new UdemyCourseSection(courseElement));
		}
		return output;
	}

	public UdemyCourseFilterPageSection openFilters() {
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(FILTERS_CLICK, 0));
		driver.findElement(FILTERS_CLICK).click();
		return new UdemyCourseFilterPageSection(driver);
	}

}
