package com.RediffPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RediffBaseClass.BaseClassUtills;
import com.RediffBaseClass.TopMenuPage;
import com.aventstack.extentreports.ExtentTest;

public class SigninPage extends BaseClassUtills{
	
	
	TopMenuPage topmenupageObj;
	
	public SigninPage(WebDriver driver,ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
//		super(driver,logger);
		topmenupageObj= new TopMenuPage(driver,logger);
		PageFactory.initElements(driver, topmenupageObj); 
	}
	
	@FindBy(id="useremail")
	public WebElement signin_usermail;
	
	@FindBy(id="userpass")
	public WebElement signin_password;
	
	@FindBy(id="loginsubmit")
	public WebElement signin_submit;
	
	public MyportfolioPage sign() {
		
		try {
		signin_usermail.sendKeys("raviteja2924@rediffmail.com");
		signin_password.sendKeys("rediffmail@4R");
		signin_submit.click();
		reportPass("Enter username and passowrd and click on signIn button");
		}catch(Exception ex) {
			reportFail(ex.getMessage());
		}
		
		
		MyportfolioPage myportfolioPage = new MyportfolioPage(driver,logger);
		PageFactory.initElements(driver, myportfolioPage);
		return myportfolioPage;
	}
	
	public TopMenuPage gettopMenu() {
		
		return topmenupageObj;
	}

}
