package library;




import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExcel {

	String filepath=".\\TestData.xlsx";
	String sheetName="Credentials";
	
	void ReadDataFrmExl() throws Exception
	{
		System.out.println("starting of program");
		ReadWriteExcel objexl=new ReadWriteExcel(".\\UserCredentials.xls", "UserCredentials.xls","Testcase");
		objexl.ReadExcel();
		String filePath="Pass.xls";
		FileOutputStream fileOutput = new FileOutputStream(filePath);
		HSSFWorkbook workbook= new HSSFWorkbook();
		String sheetName="TestData";
		workbook.createSheet(sheetName);
		workbook.write(fileOutput);
		
		ReadWriteExcel newexl=new ReadWriteExcel(".\\Pass.xls", "Pass.xls",sheetName);
		newexl.writeData("logesh", 0, 0);
		newexl.ReadExcel();

		System.out.println("***********************************");
		//ReadWriteExcel objex2=new ReadWriteExcel(".\\data.xlsx", "data.xlsx","Testcase","Nayeem");
		
		//objexl.ReadExcel(2);
		//objexl.ReadExcel(5,2);
		
		
	}
	
	@Test(dataProvider="UserData")
	void APITest(String userName, String Password,String Date, String Attempts,String Results) throws Exception
	{
		
		ExcelAPI apitest=new ExcelAPI(".\\TestData.xlsx");
		/*System.out.println(apitest.getCellData("Credentials", 0, 1));
		System.out.println(apitest.getCellData("Credentials", 1, 1));
		System.out.println(apitest.getCellData("Credentials", 2, 1));
		System.out.println(apitest.getCellData("Credentials", 3, 1));
		
		System.out.println("**************************");
		System.out.println(apitest.getCellData("Credentials", "UserName", 1));
		System.out.println(apitest.getCellData("Credentials", "PassWord", 1));
		System.out.println(apitest.getCellData("Credentials", "DateCreated", 1));
		System.out.println(apitest.getCellData("Credentials", "No of Attempts", 1));
		System.out.println(apitest.getRowCount("Credentials"));
		System.out.println(apitest.getColCount("Credentials"));*/
		System.out.println(userName);
		System.out.println(Password);
		
		
		
		/*boolean valueset=apitest.setCellData("Credentials", "Results", 2, "Fail");
		if(valueset==true)
			System.out.println("Data added");
		else
			
			System.out.println("Data Not added");*/
	}
	@DataProvider(name="UserData")
	public Object[][] userData() throws Exception
	{
		Object[][] data= testData(filepath, sheetName);
		return data;	
	}
	
	public Object[][] testData(String filepath, String sheetName) throws Exception
	{
		Object[][] excelData=null;
		ExcelAPI apitest=new ExcelAPI(filepath);
		int rows=apitest.getRowCount(sheetName);
		int columns=apitest.getColCount(sheetName);
		excelData= new Object[rows-1][columns];
		for (int i=1; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
			{
				excelData[i-1][j]=apitest.getCellData(sheetName, j, i);
				
			}
		}
		return excelData;
	
	}
}