package com.Rediff_TestCases;

import org.testng.annotations.Test;

import com.RediffBaseClass.BaseClassUtills;
import com.RediffBaseClass.TopMenuPage;
import com.RediffPageClasses.LandingPage;
import com.RediffPageClasses.LogOutPage;
import com.RediffPageClasses.RediffMoneyWiz;
import com.RediffPageClasses.SigninPage;

@Test
public class Signin_Signout_Again_Signin extends BaseClassUtills {

	public void signinsignoutAgainsign() {
		
		System.out.println("step1");

		logger = report.createTest("Rediff Again Signin");
		System.out.println("step2");

		InvokeBrowser();
		System.out.println("step3");

		LandingPage landingPageObj = openBrowser();

		RediffMoneyWiz rediffMoneyWizObj = landingPageObj.clickMoneyControl();

		SigninPage signinpageObj = rediffMoneyWizObj.signin_click();

		signinpageObj.sign();

		TopMenuPage topMenuPage = signinpageObj.gettopMenu();

		LogOutPage logoutPageObj = topMenuPage.clickSignout();

		signinpageObj = logoutPageObj.loginAgain();
		signinpageObj.sign();

		closeBrowser();

	}

}
