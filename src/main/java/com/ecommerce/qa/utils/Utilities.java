package com.ecommerce.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "").replace(":", "_");
		return "tony"+timeStamp+"@gmail.com";
	}
	
	public static Object[][] getTestDataFromExcelFiles(String sheetName) throws IOException {
		Object[][] data;

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/ecommerce/qa/testdata/ecommercetestdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Login");

		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getLastCellNum();

		data = new Object[totalRows][totalColumns];

		for (int r = 0; r < totalRows; r++) {
			XSSFRow row = sheet.getRow(r + 1);
			for (int c = 0; c < totalColumns; c++) {
				XSSFCell cell = row.getCell(c);
				data[r][c] = cell.getStringCellValue();
			}
		}

		workbook.close();
		fis.close();
		return data;
	}
}
