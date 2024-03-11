package LoginTest;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import resources.Base;
import util.DataUtil;
import util.MyXLSReader;

public class LoginTest extends Base
{
	MyXLSReader excelReader;
	WebDriver driver;
	
	@Test(dataProvider="getLoginData")
	public void login(HashMap<String,String> hmap) throws IOException, InterruptedException 
	{
		
		if(DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") && hmap.get("Runmode").equalsIgnoreCase("N")) 
		{
			throw new SkipException("Run mode is set to N, hence not executed.");
		}
		
		driver = initializer();
		driver.get(prop.getProperty("url"));
		
		LoginPage log =new LoginPage(driver);
		Thread.sleep(5000);
		log.getusernamefield().sendKeys(hmap.get("Username"));
		Thread.sleep(5000);
		log.getpasswordfield().sendKeys(hmap.get("Password"));
		Thread.sleep(5000);
		log.getLoginButton().click();
		
//		to test the error message of sweet alert
		String actualtext=log.getSweetAlert().getText();
		
		if(hmap.get("ExpectedResult").equalsIgnoreCase("Success")) 
		{
			Assert.assertEquals(actualtext, "Logged in Successful");
			
			
		}else if (hmap.get("ExpectedResult").equalsIgnoreCase("Failure")) 
		{
			Assert.assertEquals(actualtext, "Error!");
		}
		
		log.getAlertButton().click();
		
		
		
		DashboardPage dash = new DashboardPage(driver);
		
		String actualresult=null;
		
		try
		{
			if(dash.gettitle().isDisplayed()) // will give exception if title is not get displayed (failed) at this point hence we are taking it under try catch block
			{
				actualresult="Success";
				driver.quit();
			}
		
		}
		catch(Exception e)
		{
				
			actualresult="Failure";
		}
		
		Assert.assertEquals(actualresult, hmap.get("ExpectedResult"));
		
		
	}
	
	
	
	@DataProvider
	public  Object[][] getLoginData() throws Exception 
	{
		Object[][] data = null;
		try 
		{
			 excelReader = new MyXLSReader("src//main//java//resources//TutorialsNinja.xlsx");
			data = DataUtil.getTestData(excelReader, "LoginTest", "Data");
		
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@AfterMethod
	public void closure() 
	{
		driver.quit();
	}
	
	
}
