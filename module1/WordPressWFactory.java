package module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import library.BrowserFactory;
import library.ReadWriteExcel;

public class WordPressWFactory {
	WebDriver driver = BrowserFactory.StartBroswer("chrome", "http://demosite.center/wordpress/wp-login.php");
	LoginPageFactory login=PageFactory.initElements(driver, LoginPageFactory.class);
	@Test
	public void checkValidLogin() {
		ReadWriteExcel exclData=new ReadWriteExcel(".\\UserCredentials.xls", "UserCredentials.xls","Testcase");
		
		login.pageLogin(exclData.ReadExcel(2, 1),exclData.ReadExcel(2, 2));
		Assert.assertTrue(driver.getTitle().contains("Dashboard"));
		exclData.writeData("Pass", 2, 3);
		exclData.writeData("Chrome", 2, 4);
	}
	@Test(dependsOnMethods={"checkValidLogin"})
	public void addVerfiyPost()
	
	{
		Actions action= new Actions(driver);
		action.clickAndHold(login.posts)
	.moveToElement(login.addPost).click().build().perform();
		Assert.assertTrue(driver.getTitle().contains("Add New Post"));
	}
	@AfterTest
	void Browser(){
		driver.quit();
		
	}
}
