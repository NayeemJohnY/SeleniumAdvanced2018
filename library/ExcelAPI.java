package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Hyperlink;



public class ExcelAPI {

	public FileInputStream fis = null;
	public FileOutputStream fos=null;
	 String filepath=null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	

	public ExcelAPI(String filepath) throws Exception {
		fis = new FileInputStream(filepath);
		this.filepath=filepath;
		workbook = new XSSFWorkbook(fis);
		fis.close();

	}

	public String getCellData(String sheetname, int colNum, int rowNum) {
		try {
			sheet = workbook.getSheet(sheetname);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if  (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
		
			
		} catch (Exception e) {
			e.printStackTrace();
			return "No match value";
		}
	}

	public String getCellData(String sheetname, String colName, int rowNum) {
		try {
			int colNum = -1;
			sheet = workbook.getSheet(sheetname);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
				colNum = i;
			}
			row=sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {
			e.printStackTrace();
			return "No match value";
		}

	}
	public XSSFCell setCellData(String sheetname, int colNum, int rowNum,String value) {
		
		try {
			
			sheet = workbook.getSheet(sheetname);
			row = sheet.getRow(rowNum);
			if(row==null)
			{
				row=sheet.createRow(rowNum);
			}
			cell=row.getCell(colNum);
			if(cell==null)
			{
				cell=row.createCell(colNum);
			}
			//setupFont(cell);
			cell.setCellValue(value);
			fos= new FileOutputStream(filepath);
			workbook.write(fos);
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return cell;
		}
		return cell;
	}

public XSSFCell setCellData(String sheetname, String colName, int rowNum,String value) {
	
	try {
		
		int colNum = -1;
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName))
			colNum = i;
		}
		row=sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		if(row==null)
		{
			row=sheet.createRow(rowNum);
		}
		cell=row.getCell(colNum);
		if(cell==null)
		{
			cell=row.createCell(colNum);
		}
		//setupFont(cell);
		cell.setCellValue(value);
		fos= new FileOutputStream(filepath);
		workbook.write(fos);
		fos.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return cell;
	}
	return cell;
}
public int getRowCount(String sheetname)
{
	
	sheet=workbook.getSheet(sheetname);
	int rowCount=sheet.getLastRowNum()+1;
	return rowCount;
	
}
public int getColCount(String sheetname)
{
	
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(0);
	int colCount=row.getLastCellNum();
	return colCount;
	
	
}
public void setupFont(XSSFCell cell,short color) throws Exception
{
	
	XSSFFont font=workbook.createFont();
	XSSFCellStyle style=workbook.createCellStyle();
	font.setFontName(HSSFFont.FONT_ARIAL);
	font.setFontHeight(14.0);
	font.setBold(true);
	font.setColor(HSSFColor.WHITE.index);
	style.setFont(font);
	style.setFillForegroundColor(color);
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	fos= new FileOutputStream(filepath);
	workbook.write(fos);
	fos.close();
}
public void createHyperlink(XSSFCell cell, String linktext) throws Exception
{
	CreationHelper createHelper = workbook.getCreationHelper();
	XSSFFont link_font=workbook.createFont();
	XSSFCellStyle link_style=workbook.createCellStyle();
	link_font.setUnderline(FontUnderline.SINGLE);
	link_font.setColor(HSSFColor.BLUE.index);
	link_style.setFont(link_font);
	if(!linktext.isEmpty()){
		Hyperlink link=createHelper.createHyperlink(HyperlinkType.NONE);
		link.setAddress(linktext);
		cell.setHyperlink(link);
		cell.setCellStyle(link_style);
	}
	
	fos= new FileOutputStream(filepath);
	workbook.write(fos);
	fos.close();
}
}
