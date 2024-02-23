package com.RediffPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.RediffBaseClass.BaseClassUtills;
import com.RediffBaseClass.TopMenuPage;
import com.aventstack.extentreports.ExtentTest;

public class MyportfolioPage extends BaseClassUtills{
	
	TopMenuPage topmenupageObj;
	
	
	public MyportfolioPage(WebDriver driver,ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
//		super(driver,logger);
		topmenupageObj= new TopMenuPage(driver,logger);
		PageFactory.initElements(driver, topmenupageObj);
	}
	
	@FindBy(id="createPortfolio")
	public WebElement create_portfolio_Element;
	
	@FindBy(xpath="//input[@id='create']")
	public WebElement portfolio_text_Element;
	
	@FindBy(id="createPortfolioButton")
	public WebElement create_portfolio_button;
	
	@FindBy(xpath="//select[@id='portfolioid']")
	public WebElement portfolio_Drop_DownElement;
	
	@FindBy(xpath="//img[@title='Delete']")
	public WebElement delete_portfolio_ButtonElement;
	
	public TopMenuPage gettopMenuPage() {
		return topmenupageObj;
	}
	
	public MyportfolioPage createPortFolio(String portfolioName) {
		
		try {
		create_portfolio_Element.click();
		portfolio_text_Element.clear();
		portfolio_text_Element.sendKeys(portfolioName);
		create_portfolio_button.click();
		
		reportPass("Add "+portfolioName+"in to Rediff Account");
		}catch (Exception e) {
			reportFail(e.getMessage());
		}
		
		MyportfolioPage myportfolioPage = new MyportfolioPage(driver,logger);
		PageFactory.initElements(driver, myportfolioPage);
		return myportfolioPage;
	}
	
	public MyportfolioPage deletePortFolio(String portfolioName) {
		

		selectPortfolio( portfolioName);
		
		try {
		delete_portfolio_ButtonElement.click();
		acceptAlert() ;
		reportPass("delete portfolio "+portfolioName+" sucessfully ");
		}catch(Exception ex) {
			
		}
		MyportfolioPage myportfolioPage = new MyportfolioPage(driver,logger);
		PageFactory.initElements(driver, myportfolioPage);
		return myportfolioPage;
	}
	
	public void selectPortfolio(String portfolioName) {
		
		try {
		Select select = new Select(portfolio_Drop_DownElement);
		select.selectByVisibleText(portfolioName);
		reportPass("Select portfolio "+portfolioName +" sucessfully");
		}catch(Exception ex) {
			reportFail("Portfolio not found +"+ex.getMessage());
		}
	}
	
	

	
	
}





















































