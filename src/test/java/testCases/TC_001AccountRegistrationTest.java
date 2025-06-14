package testCases;

import java.nio.channels.AcceptPendingException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001AccountRegistrationTest 
{
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void verify_Account_registration()
	{
		HomePage homepage= new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickRegister();
		AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
		registrationPage.setFirstName("Taran");
		registrationPage.setLastName("Deeep");
		registrationPage.setEmail("aman@gmail.com");   //EmailID should different every time
		registrationPage.setTelephone("75394849");
		registrationPage.setPassword("tara@123");
		registrationPage.setConfirmPassword("tara@123");
		registrationPage.setAgree();
		
		registrationPage.clickContinue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		String confirmationMessage = registrationPage.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");
	}
}
