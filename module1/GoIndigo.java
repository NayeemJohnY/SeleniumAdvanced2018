package module1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import library.BrowserFactory;

public class GoIndigo {

	WebDriver driver = BrowserFactory.StartBroswer("chrome", "https://www.goindigo.in/");

	@Test
	void indigoTest() {
		WebElement ele = driver
				.findElement(By.xpath("//*[@id='oneWay']//following::input[@class='count travellers-count']"));
		ele.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(
				By.xpath("//*[@id='oneWay']//following::select[@class='select-custome book-trip-infant']")));
		select.selectByVisibleText("1");

	}
}
