package module1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.BrowserSetup;
import library.ReadConfigFile;

public class PageObjWoFactry {
	ReadConfigFile config = new ReadConfigFile(".\\Config.properties");
	BrowserSetup setup;
	WebDriver driver;
	@BeforeTest
	void EnvSetup()
	{
		setup=new BrowserSetup(config);
		
	}
	
	@Test(priority=2)
	void validLogin()
	{	
	driver=setup.LoginPage("8015110219", "Nayeem94");
	Assert.assertTrue(driver.getTitle().contains("Facebook"));
	
		
	}
	@Test(priority=1)
	void invalidLogin()
	{	
	driver=setup.LoginPage("8015110219", "Nayeem1994");
	Assert.assertNotEquals(driver.getTitle(),("Facebook"));
	
		
	}

}
