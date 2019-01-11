package library;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JxlReadExcel {

	public static void main(String[] args) {
		File file=new File(".\\USerFormat.xls");
		
		try {
			Workbook wb= Workbook.getWorkbook(file);
			int sheetNo=wb.getNumberOfSheets();
			Sheet[] sheets=wb.getSheets();
			System.out.println(sheetNo);
			
		for (Sheet sheet:sheets )
		{ 
			int rows=sheet.getRows();
			int colm=sheet.getColumns();

			 
			for (int j=0; j<rows; j++)
			{
				for (int k=0; k<colm; k++)
				{
					
					sheet.getCell(k, j).getContents();
				}
				
			}
			
		}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());// TODO Auto-generated catch block
		
		}
		
	}
}
