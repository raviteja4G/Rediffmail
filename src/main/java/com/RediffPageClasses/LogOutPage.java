package com.RediffPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RediffBaseClass.BaseClassUtills;
import com.RediffBaseClass.TopMenuPage;
import com.aventstack.extentreports.ExtentTest;


public class LogOutPage extends BaseClassUtills{
	
	TopMenuPage topmenupageObj;
	
	public LogOutPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger = logger;
//		super(driver,logger);
		topmenupageObj= new TopMenuPage(driver,logger);
		PageFactory.initElements(driver, topmenupageObj);
	}

	@FindBy(xpath="//a[contains(text(),'Login again')]")
	public WebElement login_Again;
	
	public SigninPage loginAgain() {
		try {
		login_Again.click();
		reportInfo("Login Again into Rediff");
		}catch(Exception ex) {
			reportFail(ex.getMessage());
		}
		
		SigninPage signinPage = new SigninPage(driver,logger);
		PageFactory.initElements(driver, signinPage);
		return signinPage;
	}
	
	
	
}
