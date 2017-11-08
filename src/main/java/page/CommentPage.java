package page;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class CommentPage {
	
	 WebDriver commentPagePagedriver;
		
	 public CommentPage(WebDriver driver) {
		 commentPagePagedriver = driver;
				PageFactory.initElements(commentPagePagedriver, this);
	 }
	
	@FindBy(xpath= "//div[@class='_1mf _1mj']")
	private WebElement addComment;
	
	@FindBy(xpath= "//button[@type='submit']")
	private WebElement postButton;
	
	@FindBy(className= "_4k-6")
	private WebElement commentClass;
	
	
	private String firstName="Plabani";
	private String middleName= "Punyotoya";
	private String lastName="Sahoo";
	
	
	
  public void AddComment() {
	  
	  Set<String> allwindows= commentPagePagedriver.getWindowHandles();
	  Iterator<String> it=allwindows.iterator();
	  String firstTab=it.next();
	  String secondTab=it.next();
	  
	  commentPagePagedriver.switchTo().window(secondTab);
	  
	  //adding comment
	  addComment.sendKeys("[" + firstName + "]" + "" + "Test user likes to blog. The comment of the blog can be anything");
	  postButton.click();
	  
	  addComment.sendKeys("[" + lastName + "]" + "" + "Test user likes to blog. The comment of the blog can be anything");
	  postButton.click();
	  
	//Like the FirstName Comment
	  
	  String xpath_dy="//div//span[contains(text(),'{FIRST_NAME}')]/../parent::span/parent::div/../following-sibling::div/a[text()='Like']";
	  commentPagePagedriver.findElement(By.xpath(xpath_dy.replaceAll("{FIRST_NAME}","[Plabani]"))).click();
	  //commentPagePagedriver.findElement(By.xpath(xpath_dy.replaceAll("{FIRST_NAME}","[Sahoo]"))).click();
	  
	  
	  commentPagePagedriver.close();
	  commentPagePagedriver.switchTo().window(firstTab);
	  
	  
	  //Reply Comment
	   String xpath_dy1= "//div//span[contains(text(),'{LAST_NAME}')]/../parent::span/parent::div/../following-sibling::div/a[text()='Reply']";
	  commentPagePagedriver.findElement(By.xpath(xpath_dy1.replaceAll("{LAST_NAME}","[Sahoo]"))).click();
	  
	  
	  //Add reply to the LastName comment
	  String xpath_dy2= "//div//span[contains(text(),'{LAST_NAME}')]/../parent::span/parent::div/../parent::div/div[3]/div/div[2]/div/div/div/div/div";
	  WebElement comment_textbox= commentPagePagedriver.findElement(By.xpath(xpath_dy2.replaceAll("'{LAST_NAME}'","[Sahoo]")));
	  comment_textbox.sendKeys("[" + firstName+ "][" + lastName + "]"+ "-Replying to the parent comment");
	  
  }
}
