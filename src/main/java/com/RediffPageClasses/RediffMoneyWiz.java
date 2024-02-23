package com.RediffPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RediffBaseClass.BaseClassUtills;
import com.RediffBaseClass.TopMenuPage;
import com.aventstack.extentreports.ExtentTest;

public class RediffMoneyWiz extends BaseClassUtills{
	
	TopMenuPage topmenupageObj;
	
	public RediffMoneyWiz(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger= logger;
//		super(driver,logger);
		topmenupageObj= new TopMenuPage(driver,logger);
		PageFactory.initElements(driver, topmenupageObj);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	public WebElement signinButton;
	
	public SigninPage signin_click() {
		
		System.out.println("signin_click-Method");
		
		try {
		signinButton.click();
		reportInfo("clicked on signion button");
		System.out.println("signin click happened ");
		}catch(Exception ex) {
			reportFail(ex.getMessage());
			System.out.println("signin not click happened ");
		}
		
		SigninPage signinPage = new SigninPage(driver,logger);
		PageFactory.initElements(driver, signinPage);
		return signinPage;
	}
}
