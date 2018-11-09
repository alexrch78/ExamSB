package test;

import org.testng.annotations.Test;

import enums.Categories;
import enums.SubCategories;
import pageObject.Udemy.UdemyBasePage;
import pageObject.Udemy.UdemyCourseSection;
import pageObject.Udemy.UdemyHomePage;
import pageObject.Udemy.UdemyLoginPage;
import pageObject.Udemy.UdemyPopularCoursesPage;
import pageObject.Udemy.UdemyRelevantCoursesPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UdemySanity {
	
	private final String USERNAME = "alexander@playbuzz.com";
	private final String PASSWORD = "Aa123456";
	
	private WebDriver driver;
	
  @Test
  public void testSeleniumCourses() {
	  Categories category = Categories.DEVELOPMENT;
	  SubCategories subCategory = SubCategories.WEB_DEVELOPMENT;
	  Boolean usingMenuBarInSelecting = true;
	  String topic = "selenium";
	  
	  UdemyBasePage basePage = new UdemyBasePage(driver);
	  UdemyLoginPage login = basePage.goToLogin();
	  UdemyHomePage homePage = login.performLogin(USERNAME, PASSWORD);
	  UdemyPopularCoursesPage popularCourses =  homePage.menuBarSection.selectCategoryAndSubCategory(category, subCategory); //Can also perform this action with header instead of menu bar
	  UdemyRelevantCoursesPage relevantCoursesPage = popularCourses.headerSection.searchForCourseWithSearchBox(topic);
	  relevantCoursesPage.openFilters().choosePriceFilter(PriceOptions.FREE);
	  List<UdemyCourseSection> coursesCollection = relevantCourses.coursesSectionCollection;
	  Assert.assertTrue(coursesCollection.length >= minimumNumberOfCourses);
	  Boolean keyWordExists = false;
	  for(UdemyCourseSection course : coursesCollection) {
		  Assert.assertTrue(course.isFree());
		  if(!keyWordExists && course.getTitle().contains(keyWord))
			  keyWordExists = true;
	  }
	  Assert.assertTrue(keyWordExists);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "./src/lib/chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
