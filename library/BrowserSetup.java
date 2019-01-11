package library;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import library.ReadConfigFile;

public class BrowserSetup {
	
	
	ReadConfigFile config;
	WebDriver driver;

	public BrowserSetup(ReadConfigFile config ) {
		this.config=config;
	
		String browser = this.config.getKeyValue("BrowserSelect");
		System.out.println(browser);
		switch (browser) {
		case "IE":
			System.setProperty("webdriver.ie.driver", this.config.getKeyValue("IEDriver"));
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", this.config.getKeyValue("ChromeDriver"));
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", this.config.getKeyValue("MozilaDriver"));
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Unable to Launch the browser");

		}
	}

	public WebDriver LoginPage(String userid, String password)
	{	
		//Identifying Elements
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(config.getKeyValue("URL"));
		By usernameloc=By.xpath(this.config.getKeyValue("UserLoc"));
		By passwordloc=By.xpath(this.config.getKeyValue("PasswordLoc"));
		By LoginButton=By.xpath(this.config.getKeyValue("LoginLoc"));
	
		driver.findElement(usernameloc).sendKeys(userid);
		driver.findElement(passwordloc).sendKeys(password);
		driver.findElement(LoginButton).click();
		return driver;
	}
}
