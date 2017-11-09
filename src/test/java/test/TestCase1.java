package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import page.VerifyBrokenLinks;
import utils.BaseTest;

public class TestCase1 extends BaseTest {
	
	
	
  @Test(enabled=false)
  public void test2(String URL) throws InterruptedException {

	  getDriver().get(URL);	 
	  String baseUrl = "https://rishubhatia.wixsite.com/website";
      driver.get(baseUrl);
	  
	  VerifyBrokenLinks verifybrokenlinkspage = new VerifyBrokenLinks();
	  verifybrokenlinkspage.VerifyTitle();
	  verifybrokenlinkspage.validateLinks();
	 
  }
	  
}