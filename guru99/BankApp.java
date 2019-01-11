package guru99;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import library.BrowserFactory;

public class BankApp {
	WebDriver driver;
	
	@Test(priority=1)
	void Test1() throws Exception
	{
		driver=BrowserFactory.StartBroswer("chrome", "http://www.seleniumeasy.com/test/");
		driver.findElement(By.partialLinkText("Others")).click();
		driver.findElement(By.partialLinkText("Drag")).click();
		WebElement source=driver.findElement(By.xpath("//*[@id='todrag']/span[1]"));
		WebElement target=driver.findElement(By.xpath("//*[@id='mydropzone']"));
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(source)
		    .moveByOffset(-1, -1)
		    .moveToElement(target)
		    .release(target)
		    .build();
		dragAndDrop.perform();
	    
	}
	
	
	//@Test(priority=2)
	void Test2() throws InterruptedException
	{
		driver=BrowserFactory.StartBroswer("firefox", "http://www.seleniumeasy.com/test/");
		Actions action  = new Actions(driver);
		driver.findElement(By.partialLinkText("Others")).click();
		action.moveToElement(driver.findElement(By.partialLinkText("Drag and Drop")))
		.click().build().perform(); 
		Thread.sleep(3000);
		WebElement source=driver.findElement(By.xpath("//*[@id='todrag']/span[1]"));
		WebElement target=driver.findElement(By.xpath("//*[@id='mydropzone']"));
		
		action.dragAndDrop(source, target).perform();
	}
}
