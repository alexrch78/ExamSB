package test;

import org.testng.annotations.Test;

import enums.Categories;
import enums.FilterCategories;
import enums.FilterOptions;
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
	  String topic = "selenium";
	  int minimumNumberOfCourses = 2;
	  String keyWord = "Selenium";
	  FilterCategories filterCategory = FilterCategories.PRICE;
	  FilterOptions filterOption = FilterOptions.FREE;
	  
	  UdemyBasePage basePage = new UdemyBasePage(driver);
	  UdemyLoginPage login = basePage.goToLogin();
	  UdemyHomePage homePage = login.performLogin(USERNAME, PASSWORD);
	  UdemyPopularCoursesPage popularCourses =  homePage.headerSection.selectCategoryAndSubCategory(category, subCategory); //Can also perform this action with menu bar instead of menu bar
	  UdemyRelevantCoursesPage relevantCoursesPage = popularCourses.headerSection.searchForCourseWithSearchBox(topic);
	  relevantCoursesPage.openFilters().chooseFilter(filterCategory, filterOption);
	  List<UdemyCourseSection> coursesCollection = relevantCoursesPage.getCoursesSections();
	  
	  Assert.assertTrue(coursesCollection.size() >= minimumNumberOfCourses, "number of courses is less than minimum");
	  Boolean keyWordExists = false;
	  int index = 1;
	  for(UdemyCourseSection course : coursesCollection) {
		  Assert.assertTrue(course.isFree(), String.format("course number %s is not free", Integer.toString(index)));
		  if(!keyWordExists && course.getTitle().contains(keyWord))
			  keyWordExists = true;
		  index++;
	  }
	  Assert.assertTrue(keyWordExists, "keyword selenium doesn't exist");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "./src/lib/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
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
