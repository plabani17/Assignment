package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class UserHomePage {
 WebDriver userhomePagedriver;
	
 public UserHomePage(WebDriver driver) {
	 userhomePagedriver = driver;
			PageFactory.initElements(userhomePagedriver, this);
	}
	
	@FindBy(xpath = "//input[@aria-label= 'Search']")
	private WebElement searchbox;
	
	@FindBy(xpath = "//button[@data-testid= 'facebar_search_button']" )
	private WebElement searchButton;
	
	@FindBy(linkText="See All")
	private WebElement SeeALL;
	
	@FindBy(xpath="//div[contains(text(), '24 hours in Washington D.C. | blog')]")
	private WebElement linkToBlog;
	
	
	
	public void SearchBlog() throws InterruptedException {
		//userhomePagedriver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		searchbox.sendKeys("24 hours in Washington D.C.");
		Thread.sleep(2000);
		searchButton.click();
		Thread.sleep(2000);
		
		SeeALL.click();
		JavascriptExecutor jse = (JavascriptExecutor)userhomePagedriver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		
		linkToBlog.click();
			
		
  }
}
