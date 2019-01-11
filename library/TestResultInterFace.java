package library;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import module1.TestNGDataExlProvider;

public class TestResultInterFace implements ITestListener {
	ExcelAPI apitest;
	TestNGDataExlProvider obj = new TestNGDataExlProvider();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			apitest = new ExcelAPI(obj.filepath);
			obj = (TestNGDataExlProvider) result.getInstance();
			XSSFCell cell = apitest.setCellData(obj.sheetName, "Results", obj.k, "Pass");
			apitest.setupFont(cell, HSSFColor.GREEN.index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			apitest = new ExcelAPI(obj.filepath);
			obj = (TestNGDataExlProvider) result.getInstance();
			XSSFCell cell = apitest.setCellData(obj.sheetName, "Results", obj.k,"Fail");
			apitest.setupFont(cell, HSSFColor.RED.index);
			apitest.createHyperlink(cell, "F:\\Selenium\\webdriver\\LearnSeleniumAdvance");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
