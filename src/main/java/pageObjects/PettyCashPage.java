package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PettyCashPage 
{
	WebDriver driver;
	public PettyCashPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
//	--------------------------------------	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement addPettyCashButton;
	
	public void clickOnAddPettyCashButton()
	{
		addPettyCashButton.click();
	}
//	--------------------------------------	
	@FindBy(xpath="//select[@id='name ']")
	private WebElement selectName;
	
	public WebElement getNameDropdown()
	{
		return selectName;
	}
//	--------------------------------------	
	@FindBy(xpath="//label[@for='with_project']")
	private WebElement WithProjectRadioButton;
	
	public void clickOnWithProjectRadioButton()
	{
		 WithProjectRadioButton.click();;
	}
//	--------------------------------------
	@FindBy(className ="modal-title")
	private WebElement title;
	
	public WebElement getTitle()
	{
		return title;
	}
	
//	--------------------------------------
	
	@FindBy(xpath="label[for='without_project']")
	private WebElement WithoutProjectRadioButton;
	
	public void clickOnWithoutProjectRadioButton()
	{
		 WithoutProjectRadioButton.click();;
	}
	
//	--------------------------------------
	
	@FindBy(xpath="//select[@id='project_name'][@required='required']")
	private WebElement ProjectNameField;
	
	public  WebElement getProjectNameDropdown()
	{
		return ProjectNameField;
	}
	
//	--------------------------------------
	
	@FindBy(id="amount")
	private WebElement PettyAmountField;
	
	public  void enterPettyAmount(String amount)
	{
		 PettyAmountField.sendKeys(amount);
	}
	
//	--------------------------------------
	@FindBy(id="petty_cash_description")
	private WebElement DescriptionField;
	
	public  void enterDescription(String desc)
	{
		DescriptionField.sendKeys(desc);
	}
	
	
//	--------------------------------------
	@FindBy(css="form[id='add_petty_cash_form'] button[name='submit']")
	private WebElement SubmitButton;
	
	public  void clickSubmitButton()
	{
		SubmitButton.click();
	}
	
//	--------------------------------------
	@FindBy(xpath="//tbody/tr[1]/td[4]")
	private WebElement ListingEmployeeName;
	
	public  String getListingEmployeeName()
	{
		return ListingEmployeeName.getText();
	}
//	--------------------------------------
	@FindBy(xpath="//tbody/tr[1]/td[7]")
	private WebElement ListingPettyAmount;
	
	public  String getListingPettyAmount()
	{
		return ListingPettyAmount.getText();
	}

//	--------------------------------------
	@FindBy(xpath="//tbody/tr[1]/td[8]")
	private WebElement ListingDescription;
	
	public  String getListingDescription()
	{
		return ListingDescription.getText();
	}
//	--------------------------------------
	@FindBy(xpath="//tbody/tr[1]/td[6]")
	private WebElement ListingProjectName;
	
	public  String getListingProjectName()
	{
		return ListingProjectName.getText();
	}
	
//	--------------------------------------
	@FindBy(xpath="//tbody/tr[1]/td[11]/div[1]/button[1]")
	private WebElement ActionButton;
	
	public  void clickOnActionButton()
	{
		ActionButton.click();
	}	
	
	
	
//	--------------------------------------
	@FindBy(xpath="//a[@class='dropdown-item delete']")
	private WebElement ActionDeleteButton;
	
	public  void clickOnDeleteButton()
	{
		ActionDeleteButton.click();
	}	
//	--------------------------------------
	@FindBy(xpath="//tbody//tr[1]//td//a[1]")
	private WebElement ActionEditButton;
	
	public  void clickOnEditButton()
	{
		ActionEditButton.click();
	}	
	
//	--------------------------------------
	@FindBy(css="#editName")
	private WebElement EditNameInputField;
	
	public  WebElement getEditNameInputField()
	{
		return EditNameInputField;
	}	
	
//	--------------------------------------
	@FindBy(xpath="(//label[@for='edit_with_project'])[1]")
	private WebElement WithEditProjectRadioButton;
	
	public  WebElement getEditWithProjectRadioButton()
	{
		return WithEditProjectRadioButton;
	}		
	
	
	
}

