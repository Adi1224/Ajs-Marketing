package pettyCashTest;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PettyCashPage;
import resources.Base;
import util.DataUtil;
import util.MyXLSReader;

public class AddPettyCash extends Base
{
	DashboardPage dashboardpage;
	MyXLSReader excelReader;
	WebDriver driver;
	boolean isSuccess ;
	@Test(dataProvider = "getPettyCashData")
	public void addPettyCash(HashMap<String,String> hmap) throws IOException, InterruptedException 
	{
		
		if(DataUtil.isRunnable(excelReader, "AddPettyCashTest", "Testcases") && hmap.get("Runmode").equalsIgnoreCase("N")) 
		{
			throw new SkipException("Run mode is set to N, hence not executed.");
		}
		
		PettyCashPage pettycashpage = new PettyCashPage(driver);
		pettycashpage.clickOnAddPettyCashButton();
		
		WebElement nameDropdown = pettycashpage.getNameDropdown();
		
		Select select= new Select(nameDropdown);
		select.selectByVisibleText(hmap.get("Name"));
		
		if(hmap.get("With_Project").equalsIgnoreCase("Y")) 
		{
		pettycashpage.clickOnWithProjectRadioButton();
		
		select= new Select(pettycashpage.getProjectNameDropdown());
		select.selectByVisibleText("1234 || project101");;
		
		}else if(hmap.get("With_Project").equalsIgnoreCase("N"))
		{
			
		}
		
		
		
		
		pettycashpage.enterPettyAmount(hmap.get("Petty_Amount"));
		pettycashpage.enterDescription(hmap.get("Description"));
		pettycashpage.clickSubmitButton();
		
		Thread.sleep(3000);
		String Actualresult="";
		
		if( hmap.get("Name").equalsIgnoreCase(pettycashpage.getListingEmployeeName()) &&  
			hmap.get("Petty_Amount").equalsIgnoreCase(pettycashpage.getListingPettyAmount()) && 
			hmap.get("Description").equalsIgnoreCase(pettycashpage.getListingDescription())) 
		{
			System.out.println("name, petty amount and description is matched");
			if(hmap.get("With_Project").equalsIgnoreCase("Y")) 
			{
				System.out.println("for employee with project name");
				if(pettycashpage.getListingProjectName().equalsIgnoreCase(hmap.get("Project_Name"))) 
				{
					System.out.println("project name match for withproject");
					Actualresult="Success";
				}else {
					System.out.println(pettycashpage.getListingProjectName());
					System.out.println("project name not match for withproject");
					Actualresult="Failure";
				}
			}else if(hmap.get("With_Project").equalsIgnoreCase("N")) 
			{
				System.out.println("for employee without project name");
				if(pettycashpage.getListingProjectName().equalsIgnoreCase("-")) 
				{
					System.out.println(" - is matched");
					Actualresult="Success";
				}else {
					System.out.println(" - is not matched");
					Actualresult="Failure";
				}
			}
			
		}else {
			System.out.println("name, petty amount and description is not matched");
			Actualresult="Failure";
		}
		
		Assert.assertEquals(Actualresult, hmap.get("ExpectedResult"));
		
		Thread.sleep(5000);
		
		pettycashpage.clickOnActionButton();
		pettycashpage.clickOnDeleteButton();
		
		
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
	
	
	@AfterMethod
	public void closure() 
	{
		driver.close();
	}
	
	
}
