package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage
{
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

	@FindBy(xpath="//section//div//h3")
	private WebElement title;
	
	public WebElement gettitle() 
	{
		return title;
	}
	
	@FindBy(xpath="//span[normalize-space()='Employee']")
	WebElement Employee;
	
	public void clickonEmployeeName() 
	{
		Employee.click();
	}
	
	@FindBy(xpath="//span[normalize-space()='Petty Cash']")
	WebElement Petty_Cash;
	
	public void clickonPettyCashName() 
	{
		Petty_Cash.click();
	}
	
}
