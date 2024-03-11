package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage 
{

	WebDriver driver;
	
	public EmployeePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement AddEmployeeButton;
	
	public void clickOnAddEmployeeButton() 
	{
		AddEmployeeButton.click();
	}
	
	@FindBy(id="department")
	private WebElement DepartmentDropdown;
	
	public WebElement getDepartmentDropdownfield() {
		return DepartmentDropdown;
	}
	
	@FindBy(id="designation")
	private WebElement DesignationDropdown;
	
	public WebElement getDesignationDropdownfield() {
		return DesignationDropdown;
	}
	
	@FindBy(id="name")
	private WebElement NameField;
	
	public void enterName(String name) 
	{
		NameField.sendKeys(name);
		
	}
	
	@FindBy(id="mobno")
	private WebElement MobileNumberField;
	
	public void enterMobileNumber(String mobileno) 
	{
		MobileNumberField.sendKeys(mobileno);
		
	}
	
	@FindBy(id="alt_mob_no_1")
	private WebElement alternateMobileno;
	
	public void enterAlternateMobileNumber(String alternatemobilenumber) 
	{
		alternateMobileno.sendKeys(alternatemobilenumber);
		
	}

	@FindBy(id="password")
	private WebElement Password;
	
	public void enterPassword(String password) 
	{
		Password.sendKeys(password);
		
	}
	
	@FindBy(id="confirm_password")
	private WebElement ConfirmPassword;
	
	public void enterConfirmPassword(String confirmpassword) 
	{
		ConfirmPassword.sendKeys(confirmpassword);
		
	}
	
	@FindBy(id="pan_no")
	private WebElement PANNumberfield;
	
	public void enterPANNumber(String pan_no) 
	{
		PANNumberfield.sendKeys(pan_no);
		
	}
	
	@FindBy(xpath="//div[@class='form-group']//select[@class='form-control select2 select2-hidden-accessible']")
	private WebElement city;
	
	public WebElement getCityField() 
	{
		return city;
		
	}
	
	
	@FindBy(id="address")
	private WebElement addressField;
	
	public void enterAddress(String address) 
	{
		PANNumberfield.sendKeys(address);
		
	}
	
	

}
