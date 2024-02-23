package com.Utills;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	static ExtentReports report;
	static ExtentSparkReporter sparkReporter;
	static String dateTimeStamp = DateUtill.getTimeStamp();

	@Test
	public static ExtentReports getExtentReport() {

		if (report == null) {
			report = new ExtentReports();
		//	System.out.println(dateTimeStamp);
			sparkReporter = new ExtentSparkReporter("./Reports/" + dateTimeStamp + "report.html");
			
		//	sparkReporter = new ExtentSparkReporter("./Reports/report1.html");
			report.attachReporter(sparkReporter);

			sparkReporter.config().setReportName("Rediff Report");
			sparkReporter.config().setDocumentTitle("Rediff Document");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setTimeStampFormat("dd:MMM:yy-hh:mm:ss");

			report.setSystemInfo("Browser Name", System.getProperty("os.name"));
			report.setSystemInfo("os.version", System.getProperty("os.version"));
			System.out.println("report created");
		}

		return report;

	}

}
