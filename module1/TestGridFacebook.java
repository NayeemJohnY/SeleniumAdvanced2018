package module1;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestGridFacebook {
	public static final String USERNAME = "nayeemjohn1";
	  public static final String AUTOMATE_KEY = "4HeKLEgcsmqeq75JTaCp";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
RemoteWebDriver rmtedriver;
String hubUrl = "http://localhost:8888/wd/hub";

	
	@Test
	public void OpenFacebook() throws Exception
	{  System.out.println("Before Test");
		//.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		DesiredCapabilities caps=DesiredCapabilities.firefox();
		caps.setPlatform(Platform.WINDOWS);
		
		rmtedriver = new RemoteWebDriver(new URL(URL), caps);
		rmtedriver.get("http://www.facebook.com");
		rmtedriver.manage().window().maximize();
		rmtedriver.getTitle();
		Thread.sleep(10000);
		rmtedriver.quit();
	}
}
