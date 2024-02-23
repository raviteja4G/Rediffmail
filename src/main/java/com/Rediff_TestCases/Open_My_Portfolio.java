package com.Rediff_TestCases;

import org.testng.annotations.Test;

import com.RediffBaseClass.BaseClassUtills;
import com.RediffPageClasses.LandingPage;
import com.RediffPageClasses.RediffMoneyWiz;
import com.RediffPageClasses.SigninPage;

@Test
public class Open_My_Portfolio {

	public void openMyPortfolio() throws Throwable {

		BaseClassUtills baseObj = new BaseClassUtills();
		baseObj.InvokeBrowser();
		LandingPage landingpageObj = baseObj.openBrowser();
		baseObj.validateTitle("Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		Thread.sleep(10);
		RediffMoneyWiz rediffMoneyWizObj = landingpageObj.clickMoneyControl();
		baseObj.validateTitle("BSE: 71,941.57 | NSE: 21,737.60 - Live Stock Market | Share Prices | Mutual Fund India: Rediff MoneyWiz");
		SigninPage signinpageObj = rediffMoneyWizObj.signin_click();
		signinpageObj.sign();
		baseObj.closeBrowser();

	}

}
