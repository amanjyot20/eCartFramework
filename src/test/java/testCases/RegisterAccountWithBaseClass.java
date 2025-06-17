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

public class RegisterAccountWithBaseClass 
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
	public void verify_Account_registration() throws InterruptedException
	{
		HomePage homepage= new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickRegister();
		AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
		registrationPage.setFirstName(randomStringGenerater().toUpperCase());
		registrationPage.setLastName(randomStringGenerater().toUpperCase());
		registrationPage.setEmail(randomStringGenerater()+"@gmail.com");   //EmailID should different every time
		registrationPage.setTelephone(randomNumberGenerater());
		
		String password = randomAlphaNumerisGenerater();
		registrationPage.setPassword(password);
		registrationPage.setConfirmPassword(password);
		registrationPage.setAgree();
		
		registrationPage.clickContinue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		String confirmationMessage = registrationPage.getConfirmationMessage();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		Thread.sleep(10);
		Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		Thread.sleep(10);
	}
	public String randomStringGenerater()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	public String randomNumberGenerater()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomAlphaNumerisGenerater()
	{
		String chars = RandomStringUtils.randomAlphabetic(5);
		String number=RandomStringUtils.randomNumeric(3);
		return chars+"@"+number;
	}
}