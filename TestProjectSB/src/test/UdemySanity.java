package test;

import org.testng.annotations.Test;

import pageObject.UdemyBasePage;
import pageObject.UdemyCourseSection;
import pageObject.UdemyHomePage;
import pageObject.UdemyLoginPage;
import pageObject.UdemyPopularCoursesPage;
import pageObject.UdemyRelevantCoursesPage;

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
	  UdemyBasePage basePage = new UdemyBasePage(driver);
	  UdemyLoginPage login = basePage.goToLogin();
	  UdemyHomePage homePage = login.performLogin(USERNAME, PASSWORD);
	  UdemyPopularCoursesPage popularCourses =  homePage.headerSection.selectCategory(category).selectSubCategory(subCategory);
	  UdemyRelevantCoursesPage relevantCoursesPage = popularCourses.headerSection.searchForCourserWithSearchBox(topic);
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
