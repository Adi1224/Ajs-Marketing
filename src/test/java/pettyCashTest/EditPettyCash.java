package pettyCashTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PettyCashPage;
import resources.Base;
import util.DataUtil;
import util.MyXLSReader;

public class EditPettyCash extends Base 
{
	DashboardPage dashboardpage;
	MyXLSReader excelReader;
	WebDriver driver;
	
	@Test
	public void editPettyCash() 
	{
		PettyCashPage pettycashpage = new PettyCashPage(driver);
		String employeename = pettycashpage.getListingEmployeeName();
		String projectname = pettycashpage.getListingProjectName();
		String pettyamount = pettycashpage.getListingPettyAmount();
		pettycashpage.clickOnActionButton();
		pettycashpage.clickOnEditButton();
		
		System.out.println(pettycashpage.getEditWithProjectRadioButton().isSelected());
	
	}
	
	@BeforeMethod
	public void getURL() throws IOException 
	{
		
		driver=initializer();
		driver.get("https://ajs.dvadminpanel.in/login");
		LoginPage loginpage= new LoginPage(driver);	
		loginpage.getusernamefield().sendKeys("9372923236");
		loginpage.getpasswordfield().sendKeys("1234");
		loginpage.getLoginButton().click();
		loginpage.getAlertButton().click();
		
		 dashboardpage = new DashboardPage(driver);
		boolean actualresult=false;
		try 
		{
			if(dashboardpage.gettitle().isDisplayed()) 
			{
				actualresult=true;
			}else 
			{
			actualresult=false;
			}
		}catch(Exception e) {
			
		}
		
		Assert.assertTrue(actualresult);
		dashboardpage.clickonPettyCashName();
	
	}
	
	@DataProvider
	public  Object[][] getPettyCashData() throws Exception 
	{
		Object[][] data = null;
		try 
		{
			 excelReader = new MyXLSReader("src//main//java//resources//TutorialsNinja.xlsx");
			data = DataUtil.getTestData(excelReader, "AddPettyCashTest", "Data");
		
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	
	
//	@AfterMethod
//	public void closure() 
//	{
//		driver.close();
//	}
	
	
	
}
