package pageObject.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import enums.Categories;
import enums.SubCategories;
import pageObject.BasePage;

public class UdemyMenuBarPageSection extends BasePage {

	private final String CATEGORY_PATTERN =  "//div[contains(@class,'link-bar')]//a[contains(@href,'/%s/')]";
	
	public UdemyMenuBarPageSection(WebDriver driver) {
		super(driver);
	}
	
	public UdemyPopularCoursesPage selectCategoryAndSubCategory(Categories category,
			SubCategories subCategory) {
		selectCategory(category);
		selectSubCategory(subCategory);		
		return new UdemyPopularCoursesPage(driver);
	}

	private void selectSubCategory(SubCategories subCategory) {
		String subCategoryPath = String.format(CATEGORY_PATTERN, subCategory.getValue());
		driver.findElement(By.xpath(subCategoryPath)).click();
		
	}

	private void selectCategory(Categories category) {
		String categoryPath = String.format(CATEGORY_PATTERN, category.getValue());
		driver.findElement(By.xpath(categoryPath)).click();
	}

}
