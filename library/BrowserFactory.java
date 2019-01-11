package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	static WebDriver  driver;

	public static WebDriver StartBroswer(String browserName, String url) {

		if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer_Win32_3.8.0\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver-v0.19.1-win64\\geckodriver.exe");

			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
