package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass{
	
	
	@Test
	public void LoginFailiureTest() {
		
		//test = report.startTest("LoginFailiureTest");
		
		LoginPage login = new LoginPage();//object Created
		
		login.LoginFunction("xyz@abc.com","Abc@12345"); 
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		//report.endTest(test);
		
	}
	
	@Test
	public void LoginSuccessTest() {
		
		LoginPage login = new LoginPage(); // object Created
		
		login.LoginFunction("sham.mtech@gmail.com","Vinayagar*123");////we called the Login Page Method
		
	}
	
	//======= Parameterized Test Case =========
	// Param1 and Param2  Value given in XML - run thru xml

	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);	
		
	}
	// ===========getting input from Excel =================

	@Test
	public void ExternalDataTest() {
			
			String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
			String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
			
			LoginPage login = new LoginPage();
			login.LoginFunction(UserNameVal,PasswordVal);		
		}

}





