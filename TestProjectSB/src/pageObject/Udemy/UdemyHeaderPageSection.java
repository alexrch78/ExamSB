package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import enums.Categories;
import enums.SubCategories;
import helpers.SeleniumHelper;
import pageObject.BasePage;

public class UdemyHeaderPageSection extends BasePage {

	private final By CATEGORIES = By.id("header.browse");
	private final By SEARCH = By.id("header-search-field");
	
	public UdemyHeaderPageSection(WebDriver driver) {
		super(driver);
	}
	
	public UdemyPopularCoursesPage selectCategoryAndSubCategory(Categories category,
			SubCategories subCategory) {
		SeleniumHelper.moseOverElement(driver, driver.findElement(CATEGORIES));
		String pattern = "//ul[contains(@class,'dropdown-menu')]//a[contains(@href,'/%s/')]";
		String categoryPath = String.format(pattern, category.getValue());
		WebElement categoryElement = driver.findElement(By.xpath(categoryPath));
		SeleniumHelper.moseOverElement(driver, categoryElement);
		String subCategoryPath = String.format(pattern, subCategory.getValue());
		WebElement subCategoryElement = driver.findElement(By.xpath(subCategoryPath));
		subCategoryElement.click();
		return new UdemyPopularCoursesPage(driver);
	}

	public UdemyRelevantCoursesPage searchForCourseWithSearchBox(String topic) {
			driver.findElement(SEARCH).sendKeys(topic);
			driver.findElement(SEARCH).sendKeys(Keys.ENTER);
			return new UdemyRelevantCoursesPage(driver);
	}

}
