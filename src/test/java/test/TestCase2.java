package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.CommentPage;
import page.HomePage;
import page.UserHomePage;
import utils.BaseTest;


public class TestCase2 extends BaseTest{
	
  
  @Test(enabled= false)
//  (dataProvider = "userData")
  
  @Parameters("url")
  public void test2(String URL) throws InterruptedException {

	  getDriver().get(URL);	  
	  HomePage homePage=new HomePage(getDriver());
	  homePage.Login();
	  
	  System.out.println("Login Sucess");
		  
	  UserHomePage userhomepage=new UserHomePage(getDriver());
	  userhomepage.SearchBlog();
	  
	  CommentPage commentpage=new CommentPage(getDriver());
	  commentpage.AddComment();
	  
	  
	  
	  
//  @DataProvider(name="userData")
//  public Object[][] Authentication() throws Exception{
//	  ReadExcel ExcelUtils=new ReadExcel();
//       Object[][] testObjArray = ExcelUtils.readFile();
//       
//       for(int i=0;i<4;i++){
//   		for(int j=0;j<2;j++){
//   			 System.out.println(testObjArray[i][j]);
//   			 }
//   		 }
//    	   
//       return (testObjArray);
//
		}
}
