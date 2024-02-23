package com.RediffBaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RediffPageClasses.LogOutPage;
import com.aventstack.extentreports.ExtentTest;

public class TopMenuPage extends BaseClassUtills {

	public TopMenuPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	@FindBy(xpath = "//a[contains(text(),'My Watchlist')]")
	public WebElement myWatchList_Element;

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	public WebElement sign_out_Element;

	public LogOutPage clickSignout() {

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("top menu signout before click");
			sign_out_Element.click();
			System.out.println("top menu signout before click");
			reportPass("Signout is successfully");
		} catch (Exception ex) {
			reportFail(ex.getMessage());
		}

		LogOutPage logOutPage = new LogOutPage(driver, logger);
		PageFactory.initElements(driver, logOutPage);
		return logOutPage;
	}

}
