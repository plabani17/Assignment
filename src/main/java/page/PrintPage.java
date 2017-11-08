package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintPage {
	WebDriver printPageDriver;
	
	public PrintPage(WebDriver driver) {
		printPageDriver = driver;
		PageFactory.initElements(printPageDriver, this);
	}

	@FindBy(xpath="(//*[contains(text(),'Change')])[1]")
	WebElement changeButton;
	
	public void clickOnChangeButton(){
		changeButton.click();
		
	}
}
