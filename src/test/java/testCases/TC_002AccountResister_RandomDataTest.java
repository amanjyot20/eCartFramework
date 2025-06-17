package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002AccountResister_RandomDataTest extends BaseClass
{

	@Test
	public void verify_Account_registration() throws InterruptedException
	{
		logger.info("***** Starting TC_002AccountResister_RandomDataTest  *****");    //log
	try {
		HomePage homepage= new HomePage(driver);
		homepage.clickMyAccount();
		logger.info("Click on MyAccount Link");
		homepage.clickRegister();
		logger.info("Click on Register Link");
		AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
		logger.info("Providing customer Details...");
		registrationPage.setFirstName(randomStringGenerater().toUpperCase());
		registrationPage.setLastName(randomStringGenerater().toUpperCase());
		registrationPage.setEmail(randomStringGenerater()+"@gmail.com");   //EmailID should different every time
		registrationPage.setTelephone(randomNumberGenerater());
		
		String password = randomAlphaNumerisGenerater();
		registrationPage.setPassword(password);
		registrationPage.setConfirmPassword(password);
		registrationPage.setAgree();
		
		registrationPage.clickContinue();
		logger.info("Validating expected message");
		String confirmationMessage = registrationPage.getConfirmationMessage();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		//Thread.sleep(10);
		Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		logger.info("***** Finished TC_002AccountResister_RandomDataTest  *****"); 
	}
}