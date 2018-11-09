package pageObject.Udemy;

import org.openqa.selenium.WebDriver;

import pageObject.BasePage;

public class UdemyHomePage extends BasePage {
 
	public UdemyHeaderPageSection headerSection;
	public UdemyMenuBarPageSection menuBarSection;
	
	public UdemyHomePage(WebDriver driver) {
		super(driver);
		headerSection = new UdemyHeaderPageSection(driver);
		menuBarSection = new UdemyMenuBarPageSection(driver);
	}

}
