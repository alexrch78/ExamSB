package pageObject.Udemy;

import org.openqa.selenium.WebDriver;

import pageObject.BasePage;

public class UdemyPopularCoursesPage extends BasePage {
	
	public UdemyHeaderPageSection headerSection;

	public UdemyPopularCoursesPage(WebDriver driver) {
		super(driver);
		headerSection = new UdemyHeaderPageSection(driver);
	}

}
