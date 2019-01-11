package module1;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestGridgoogle {
	public static final String USERNAME = "nayeemjohn1";
	  public static final String AUTOMATE_KEY = "4HeKLEgcsmqeq75JTaCp";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	RemoteWebDriver rmtedriver;
	//String hubUrl = "http://localhost:8888/wd/hub";

	
	@Test
	public void OpenGoogle() throws Exception
	
		{  System.out.println("Before Test");
		//.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		DesiredCapabilities caps=DesiredCapabilities.chrome();
		//caps.setBrowserName(BrowserType.CHROME);
		caps.setPlatform(Platform.MAC);
		
		rmtedriver = new RemoteWebDriver(new URL(URL), caps);
		rmtedriver.get("http://www.google.com");
		rmtedriver.manage().window().maximize();
		Thread.sleep(10000);
		rmtedriver.quit();
	}
}
