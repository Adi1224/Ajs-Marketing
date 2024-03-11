package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name = "submit")
	private WebElement loginbutton;
	
	@FindBy(css = "#swal2-title")
	private WebElement alert;
	
	@FindBy(css=".swal2-confirm.swal2-styled")
	private WebElement alertButton;
	
	
	public WebElement getusernamefield() 
	{
		return username;
	}
	
	public WebElement getpasswordfield() 
	{
		return password;
	}
	
	public WebElement getLoginButton() 
	{
		return loginbutton;
	}
	
	public WebElement getSweetAlert() {
		return alert;
	}

	public WebElement getAlertButton()
	{
		return alertButton;
	}
	
}
