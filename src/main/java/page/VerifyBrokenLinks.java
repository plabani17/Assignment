package page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import utils.BaseTest;

import java.net.HttpURLConnection;

public class VerifyBrokenLinks{
	
	public static WebDriver driver;
	
	private int invalidLinksCount = 0;
	List<WebElement> allInvalidLinks = new ArrayList<WebElement>() ;
	
	
	public void validateLinks() {
		List<WebElement> allLinks= driver.findElements(By.tagName("a"));
		
		System.out.println("Total no. of links are "+ allLinks.size());
		for (WebElement linkElement : allLinks)
		{
			if (linkElement != null) {
				String url = linkElement.getAttribute("href");
				if (url != null && !url.contains("javascript")) {
					verifyLinkStatus(url, linkElement );
				}
				
			}
		}
	}
		
			
	public void verifyLinkStatus(String url, WebElement linkElement ) {
		
		
		try {
			   URL uri = new URL(url);
			   
	           HttpURLConnection httpURLConnect=(HttpURLConnection)uri.openConnection();
	           
	           httpURLConnect.setConnectTimeout(3000);
	           
	           httpURLConnect.connect();
	           
	           if(httpURLConnect.getResponseCode()==200)
	           {
	               System.out.println(url+" - "+httpURLConnect.getResponseMessage());
	               
	            }
	          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(url+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	               allInvalidLinks.add(linkElement) ;
	            }
	          
	          
	          if(httpURLConnect.getResponseCode()>= 400 && httpURLConnect.getResponseCode()!= 999  )  
	           {
	               System.out.println(url+" - "+httpURLConnect.getResponseMessage() + httpURLConnect.getResponseCode() );
	               allInvalidLinks.add(linkElement) ;
	            }
			
			
		} catch (Exception e) {
			
		}
	}
	
		
	//public static void main(String[] args) throws InterruptedException {
		
		/*System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		
		VerifyBrokenLinks objValidate= new VerifyBrokenLinks();
	
		 driver = new FirefoxDriver();
		
		String baseUrl = "https://rishubhatia.wixsite.com/website";
      
 
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Thread.sleep(3000);*/
	
	public void VerifyTitle()
	{
	
		String expectedTitle= "SDET Test";
		String actualTitle= driver.findElement(By.xpath("//span[text()= 'SDET Test']")).getText();


		if (actualTitle.equals(expectedTitle)) {
	
			System.out.println(actualTitle + "" + "is present");}
		
		else {
			System.out.println(actualTitle +" " + "is NOT present");
		}
				
		}

			
		//objValidate.validateLinks();
		public void DisplayBrokenLinks()
		{
			VerifyBrokenLinks objValidate= new VerifyBrokenLinks();
			objValidate.validateLinks();
			
			System.out.println("Details of broken links detected are shown Below");
		
		if(!objValidate.allInvalidLinks.isEmpty())
		{
		for (WebElement linkElement : objValidate.allInvalidLinks)
		{
			System.out.println(linkElement.getAttribute("href")) ;
	
		}
		}
		
		else
		{
			System.out.println("No Broken Link Detected..!!!") ;
		}
	}

}
