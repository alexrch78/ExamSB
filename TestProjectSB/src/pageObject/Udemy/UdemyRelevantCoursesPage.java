package pageObject.Udemy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObject.BasePage;

public class UdemyRelevantCoursesPage extends BasePage {

	private final By FILTERS_CLICK = By.xpath("//button[contains(@class, 'all-filters-toggle--all-filters-toggle')]");
	private final By CONTAINER = By.xpath("//div[contains(@class,'search-result-page--results-container')]");
	
	public List<UdemyCourseSection> coursesSectionCollection;
	
	public UdemyRelevantCoursesPage(WebDriver driver) {
		super(driver);
		coursesSectionCollection = getCoursesSections();
	}

	private List<UdemyCourseSection> getCoursesSections() {
		List<UdemyCourseSection> output = new ArrayList<UdemyCourseSection>();
		WebElement containerElement = driver.findElement(CONTAINER);
		List<WebElement>containerChildren = containerElement.findElements(By.xpath("./div"));
		for(WebElement courseElement : containerChildren){
			output.add(new UdemyCourseSection(courseElement));
		}
		return output;
	}

	public UdemyCourseFilterPageSection openFilters() {
		driver.findElement(FILTERS_CLICK).click();
		return new UdemyCourseFilterPageSection(driver);
	}

}
