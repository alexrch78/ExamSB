package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObject.BasePage;

public class UdemyRelevantCoursesPage extends BasePage {

	private final By FILTERS_CLICK = By.xpath("//button[contains(@class, 'all-filters-toggle--all-filters-toggle')]");
	
	public UdemyRelevantCoursesPage(WebDriver driver) {
		super(driver);
	}

	public UdemyCourseFilterPageSection openFilters() {

		
	}

}
