package com.Utills;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelFile {

	String path;
	XSSFWorkbook xssfWb;
	XSSFSheet sheet;

	public void readExcelData(String path) {

		this.path = path;
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			xssfWb = new XSSFWorkbook(fileInputStream);
			fileInputStream.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public int getRowCount(String sheetName) {

		int index = xssfWb.getSheetIndex(sheetName);
		
		if (index == -1) 
			return 0; 
		else {
			sheet = xssfWb.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum() + 1;
			return rowCount;
		}

	}

//	public String getCellData(int rowNum, String sheetName) {
//		
//		if (rowNum<0)
//			return "";
//		
//		int index = xssfWb.getSheetIndex(sheetName);
//		if(index== -1)
//			return "";
//		
//
//	}

}















































