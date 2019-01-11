package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {
	Workbook wb;
	Sheet sh;
	FileOutputStream fileOutput;
	FileInputStream fileInput;
	File file;

	public  ReadWriteExcel(String filePath, String fileName, String SheetName) {
		file = new File(filePath);

		try {
			fileInput = new FileInputStream(file);
			String fileExt = fileName.substring(fileName.indexOf("."));
			if (file.exists() == true) {
				if (fileExt.equals(".xlsx")) {
					wb = new XSSFWorkbook(fileInput);
					sh = wb.getSheet(SheetName);

				} else if (fileExt.equals(".xls")) {
					wb = new HSSFWorkbook(fileInput);
					sh = wb.getSheet(SheetName);
				} else
					System.out.println("unable to find " + fileExt + "type of file");
			}
				

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void writeData(String cellContent, int row, int col) {
		try {

			fileOutput = new FileOutputStream(file);
			if (sh.getRow(row) == null) {
				sh.createRow(row).createCell(col).setCellValue(cellContent);
			} else {
			
				if (sh.getRow(row).getCell(col) == null) {
			
					sh.getRow(row).createCell(col).setCellValue(cellContent);
				} else
					sh.getRow(row).getCell(col).setCellValue(cellContent);

			}

			fileInput.close();
			wb.write(fileOutput);
			fileOutput.flush();
			fileOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void ReadExcel() {

		for (int i = 0; i < sh.getLastRowNum() + 1; i++) {

			for (int j = 0; j < sh.getRow(i).getLastCellNum(); j++) {

				if (sh.getRow(i).getCell(j) == null) {
					System.out.print("Blank\t");

				} else {
					System.out.print(sh.getRow(i).getCell(j).getStringCellValue() + "\t");
				
				}

			}
			System.out.println();
		}

	}

	public void ReadExcel(int rowNum) {

		for (int j = 0; j < sh.getRow(rowNum).getLastCellNum(); j++) {
			if (sh.getRow(j).getCell(j) == null) {
				System.out.print("Blank\t");

			}
			System.out.print(sh.getRow(rowNum).getCell(j).getStringCellValue() + "\t");
		

		}

	}

	public String ReadExcel(int rowNum, int colNum) {
		if (sh.getRow(rowNum).getCell(colNum) == null) {
			System.out.print("Blank\t");
		}
		System.out.print(sh.getRow(rowNum).getCell(colNum).getStringCellValue() + "\t");
		return(sh.getRow(rowNum).getCell(colNum).getStringCellValue());
		

	}

}