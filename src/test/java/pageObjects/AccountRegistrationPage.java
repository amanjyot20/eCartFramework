package pageObjects;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//input[@name='firstname' and @id='input-firstname']")WebElement textFirstname;
	@FindBy(xpath="//input[@name='lastname' and @id='input-lastname']")WebElement textLastname;
	@FindBy(xpath="//input[@name='email' and @id='input-email']")WebElement textEmail;
	@FindBy(xpath="//input[@name='telephone' and @id='input-telephone']")WebElement textTelephone;
	@FindBy(xpath="//input[@name='password' and @id='input-password']")WebElement textPassword;
	@FindBy(xpath="//input[@name='confirm' and @id='input-confirm']")WebElement textConfirmpassword;
	@FindBy(xpath="//input[@name='agree']")WebElement checkboxAgree;
	@FindBy(xpath="//input[@value='Continue' and @class='btn btn-primary']")WebElement buttonContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgConfirmation;
	
	//h1[normalize-space()='Your Account Has Been Created!']
	public void setFirstName(String firstName)
	{
		textFirstname.sendKeys(firstName);
	}
	public void setLastName(String lastName)
	{
		textLastname.sendKeys(lastName);
	}
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	public void setTelephone(String telephone)
	{
		textTelephone.sendKeys(telephone);
	}
	public void setPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	public void setConfirmPassword(String confrimPassword)
	{
		textConfirmpassword.sendKeys(confrimPassword);
	}
	public void setAgree()
	{
		checkboxAgree.click();
	}
	public void clickContinue()
	{
		buttonContinue.click();
		//buttonContinue.sendKeys(Keys.RETURN);  otherway to click on Continue button
	}
	public String getConfirmationMessage()
	{
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) 
		{
			return(e.getMessage());
		}
	}
}
