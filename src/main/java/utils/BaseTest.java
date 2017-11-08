package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
public WebDriver driver;


	@BeforeTest
	public void launchDriver(){
		
		/*System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"\\Browsers\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Browsers\\chromedriver.exe");
		
		ChromeOptions chrome_Profile = new ChromeOptions();
		chrome_Profile.addArguments("chrome.switches","--disable-extensions"); 
		chrome_Profile.addArguments("--disable-save-password");
		chrome_Profile.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	/*@AfterTest
	public void TearDown(){
		driver.close();
		driver.quit();
	}*/
}
