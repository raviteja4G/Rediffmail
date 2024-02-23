package com.Utills;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GetExtentReport {
	
	ExtentReports report;
	ExtentSparkReporter sparkReporter;
	ExtentTest logger;
	
	@Test
	public void getReport() {
		System.out.println(">> Start the report creation <<");
		 report = new ExtentReports();
		 sparkReporter = new ExtentSparkReporter("./Reports/report.html");
		report.attachReporter(sparkReporter);
		System.out.println(">> End the report creation <<");
		
		report.flush();
		
	}

}
 