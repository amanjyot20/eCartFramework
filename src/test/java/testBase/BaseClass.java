package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class BaseClass 
{
	public WebDriver driver;
	public Logger logger;    //Log4j
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br)
	{
		logger= LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default : System.out.print("Invalid browser name.."); return;
			
		}
		//driver= new ChromeDriver();
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
