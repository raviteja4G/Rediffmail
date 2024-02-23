package com.RediffPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RediffBaseClass.BaseClassUtills;
import com.aventstack.extentreports.ExtentTest;

public class LandingPage extends BaseClassUtills {
	
	
	public LandingPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger=logger;
//		super(driver,logger);
	}

	@FindBy(xpath="//a[contains(@class,'moneyicon relative')]")
	public WebElement money_Control_TabElement;
	
	public RediffMoneyWiz clickMoneyControl() {
		
		try {
		money_Control_TabElement.click();
		reportInfo("clicked on money link");
		System.out.println("report info in landing page after report call");
		}catch(Exception ex) {
			reportFail(ex.getMessage());
		}
		
		RediffMoneyWiz rediffMoneyWiz = new RediffMoneyWiz(driver,logger);
		PageFactory.initElements(driver, rediffMoneyWiz);
		return rediffMoneyWiz;
	}
}
