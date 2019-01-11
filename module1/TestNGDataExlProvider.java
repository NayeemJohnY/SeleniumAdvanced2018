	 package module1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import library.ExcelAPI;



@Listeners(library.TestResultInterFace.class)
public class TestNGDataExlProvider {
public String filepath=".\\TestData.xlsx";
public String sheetName="Credentials";
ExcelAPI apitest;
public int k=1;
	WebDriver driver;
	
	@Test(dataProvider="UserData")
	void DataProvTest(String UserName, String PassWord,String Datecreated,String Screenshots,String Results)
	{
		
		System.out.println(UserName);
		System.out.println(PassWord);
		System.out.println(Results);
		
		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("log")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(PassWord);
		driver.findElement(By.id("wp-submit")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().contains("Dashboard"));
		
		
	}
	@AfterMethod
	void afterTesteach() throws Exception
	{ 
		k++;
		driver.quit();
	}
	
	@DataProvider (name="UserData")
	public Object[][] userData() throws Exception
	{
		Object[][] data= testData(filepath, sheetName);
		return data;	
	}
	
	   
	public Object[][]  testData(String filepath, String sheetName) throws Exception
	{
		Object[][] excelData=null;
		apitest=new ExcelAPI(filepath);
		int rows=apitest.getRowCount(sheetName);
		int columns=apitest.getColCount(sheetName);
		excelData= new Object[rows-1][columns];
		for (int i=1; i<rows; i++)
		{
			for ( int j=0; j<columns; j++)
			{
				excelData[i-1][j]=apitest.getCellData(sheetName, j, i);
				
			}
		}
		
		return excelData;
	
}
	public int rowNum(int i) {
		// TODO Auto-generated method stub
		System.out.println("i"+i);
		return i;
	}
	

}
