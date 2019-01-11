package module1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.ReadConfigFile;

public class ObjectRepo {
	ReadConfigFile config = new ReadConfigFile(".\\Config.properties");
	WebDriver driver;

	void SetBrowser() {
		String browser = config.getKeyValue("BrowserSelect");
		System.out.println(browser);
		switch (browser) {
		case "IE":
			System.setProperty("webdriver.ie.driver", config.getKeyValue("IEDriver"));
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", config.getKeyValue("ChromeDriver"));
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", config.getKeyValue("MozilaDriver"));
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("fails");

		}
	}

	

}
