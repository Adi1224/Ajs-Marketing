package employeeTests;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.EmployeePage;
import pageObjects.LoginPage;
import resources.Base;
import util.DataUtil;
import util.MyXLSReader;

public class AddEmployeeTest extends Base 
{
	MyXLSReader excelReader;
	WebDriver driver;
	DashboardPage dashboardpage;
	Select select;
	@Test(dataProvider = "getEmployeeData")
	public void addEmployee(HashMap<String,String> hmap) throws IOException, InterruptedException 
	{
		if(DataUtil.isRunnable(excelReader, "AddPincodes", "Testcases") && hmap.get("Runmode").equalsIgnoreCase("N")) 
		{
			throw new SkipException("Run mode is set to N, hence not executed.");
		}
		
		dashboardpage.clickonEmployeeName();
		
		EmployeePage employeepage = new EmployeePage(driver);
		employeepage.clickOnAddEmployeeButton();	
		
		select=new Select(employeepage.getDepartmentDropdownfield());
		select.selectByVisibleText(hmap.get("Department"));	
		
		select=new Select(employeepage.getDesignationDropdownfield());
		select.selectByVisibleText(hmap.get("Designation"));
		
		employeepage.enterName(hmap.get("Name"));
		employeepage.enterMobileNumber(hmap.get("Mobile_No"));
		employeepage.enterAlternateMobileNumber(hmap.get("Alternate_Mobile_No"));
		employeepage.enterPassword(hmap.get("Password"));
		employeepage.enterConfirmPassword(hmap.get("Confirm_Password"));
		employeepage.enterPANNumber(hmap.get("PAN_No"));
		
		select=new Select(employeepage.getCityField());
		select.selectByVisibleText(hmap.get("city1"));
		select.selectByVisibleText(hmap.get("city2"));
		
		
		
		
		
//		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		
		
		
	}
	
	@BeforeTest
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
	
	}
	
	@DataProvider
	public  Object[][] getEmployeeData() throws Exception 
	{
		Object[][] data = null;
		try 
		{
			 excelReader = new MyXLSReader("src//main//java//resources//testdatafarm.xlsx");
			data = DataUtil.getTestData(excelReader, "AddPincodes", "Data");
		
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	
	
//	@AfterTest
//	public void closure() {
//		driver.close();
//	}
}
