package com.testingexcel;

import com.Utills.ReadExcelFile;

public class TestExcel {

	public static void main(String args[]) {
		
		ReadExcelFile obj = new ReadExcelFile();
		obj.readExcelData("E:\\WebAutomationTesting\\SeleniumTesting\\OrangeHrmTestDataFiles\\OHRM_LogInTestData.xlsx");
		System.out.println(obj.getRowCount("TestData"));
		
		
	}
}
