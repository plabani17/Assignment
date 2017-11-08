package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ReadExcel ;

public class HomePage {
	WebDriver homePagedriver;
	
	public HomePage(WebDriver driver) {
		homePagedriver = driver;
			PageFactory.initElements(homePagedriver, this);
	}

	@FindBy(id="email")
	private WebElement emailId;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	

	public void Login(){
		
		/*ReadExcel excelobj = new ReadExcel();
	   String [][] arr = excelobj.readFile();
	   UserID = arr[0][0];
	   Password = arr[0][1];
	   emailId.sendKeys(UserID);
	   password.sendKeys(Password);*/
		
		emailId.sendKeys("plabani.17@gmail.com");
		password.sendKeys("Nature@2017");
	   loginButton.click();
	}
		
	
}
	
	