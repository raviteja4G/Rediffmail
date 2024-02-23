package com.RediffBaseClass;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import com.RediffPageClasses.LandingPage;
import com.Utills.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClassUtills {

	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getExtentReport();
	public ExtentTest logger;
		
	
	

	public void InvokeBrowser() {
		
		try {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
		reportPass("Browser opened successfully");
		
		}catch(Exception ex) {
			reportFail(ex.getMessage());
		}

	}

	/************ Open Browser****************/
	public LandingPage openBrowser() {
		
		try {
		driver.get("https://www.rediff.com/");
		reportPass("Rediff url opened");
		}catch(Exception ex) {
			reportFail(ex.getMessage());
		}
		
		LandingPage landingPage = new LandingPage(driver,logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;

	}
	
	@AfterMethod
	/************ Close Browser****************/
	public void closeBrowser() {
		
		driver.close();
		//return PageFactory.initElements(driver, LandingPage.class);

	}
	
	/************ Flush report ****************/
	@AfterMethod
	public void flushReport() {
		
		report.flush();
		System.out.println("flush done");

	}


	public void validateTitle(String expectedCurrentPageTitle) {
		
		String actualCurrentPageTitle = driver.getTitle();
		if(actualCurrentPageTitle.equals(expectedCurrentPageTitle)) {
			System.out.println("Validation is done");
		}else {
			System.out.println("Validation Failed");
		}

	}
	
	/************* Reporting Functions ******************/
	public void reportFail(String message) {
		logger.log(Status.FAIL, message);
		getScreenShot();
		Assert.fail();
	}
	
	public void reportPass(String message) {
		logger.log(Status.PASS, message);
	}
	
	public void reportInfo(String message) {
		logger.log(Status.INFO, message);
		System.out.println("report info in base page");
	}
	
	
	/*************** Take Screenshot***********************/
	public void getScreenShot() {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Screenshots/"+getTimeStamp()+"image.png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			reportInfo("TakeScreenshot is failed as error message :"+e);
		}
		
	}
	
	public String getTimeStamp() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("E_dd_MMM_yy_hh_mm_ss");
		String timeStamp =dateTime.format(formatPattern);
		return timeStamp;
	}
	
	public void acceptAlert() {
		
		try {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		reportInfo("Accept the alert");
		}catch(Exception ex){
			reportFail("Issue in alert "+ex.getMessage());
		}
	}
	
	public void explicitwait(WebElement elementName) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(elementName));
		}catch(Exception ex) {
			reportFail(ex.getMessage());
		}
	}
	

}






































