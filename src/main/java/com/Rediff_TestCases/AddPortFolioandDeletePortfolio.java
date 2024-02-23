package com.Rediff_TestCases;

import org.testng.annotations.Test;

import com.RediffBaseClass.BaseClassUtills;
import com.RediffBaseClass.TopMenuPage;
import com.RediffPageClasses.LandingPage;
import com.RediffPageClasses.LogOutPage;
import com.RediffPageClasses.MyportfolioPage;
import com.RediffPageClasses.RediffMoneyWiz;
import com.RediffPageClasses.SigninPage;

@Test
public class AddPortFolioandDeletePortfolio extends BaseClassUtills {

	LandingPage landingPage;
	RediffMoneyWiz rediffMoneyWiz;
	SigninPage signinPage;
	MyportfolioPage myportfolioPage;
	LogOutPage logOutPage;

	public void addPortFolio() {

		logger = report.createTest("Add portfolio in Rediff");
		InvokeBrowser();
		landingPage = openBrowser();
		rediffMoneyWiz = landingPage.clickMoneyControl();
		signinPage = rediffMoneyWiz.signin_click();
		myportfolioPage = signinPage.sign();
		myportfolioPage = myportfolioPage.createPortFolio("APPU");
		myportfolioPage = myportfolioPage.deletePortFolio("Raviteja5");
		TopMenuPage topmenupageObj = myportfolioPage.gettopMenuPage();
		logOutPage = topmenupageObj.clickSignout();

	}
}
