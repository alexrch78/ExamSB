package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UdemySanity {
	
	private final String USERNAME = "alexander@playbuzz.com";
	private final String PASSWORD = "Aa123456";
	
  @Test
  public void testSeleniumCourses() {
	  UdemyBasePage basePage = new UdemyBasePage(driver);
	  UdemyLoginPage login = homePage.goToLogin();
	  UdemyHomePage homePage = login.performLogin(USERNAME, PASSWORD);
	  UdemyPopularCoursesPage popularCourses =  homePage.headerSection.selectCategory(category).selectSubCategory(subCategory);
	  UdemyRelevantCoursesPage relevantCoursesPage = popularCourses.headerSection.searchForCourserWithSearchBox(topic);
	  relevantCourses.openFilters().choosePriceFilter(PriceOptions.FREE);
	  List<UdemyCourse> coursesCollection = relevantCourses.coursesCollection;
	  Assert.assertTrue(coursesCollection.length >= minimumNumberOfCourses);
	  bool keyWordExists = false;
	  for(UdemyCourse course : coursesCollection) {
		  Assert.assertTrue(course.isFree());
		  if(course.getTitle().contains(keyWord))
			  keyWordExists = true;
	  }
	  Assert.assertTrue(keyWordExists);
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
