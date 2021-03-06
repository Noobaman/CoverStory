package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.datautitlities.Excelutility;
import com.qa.globals.CommonMethods;
import com.qa.globals.Globals;
import com.qa.pageobjects.AddToCartObjects;
import com.qa.pageobjects.ForgotPassword;
import com.qa.pageobjects.LoginPageobjects;
import com.qa.pageobjects.OrderObjects;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestForgotPassword extends Globals{
	@BeforeTest
	public void launchUrl() throws Exception {
		System.setProperty("browser", "Chrome");
		setUp();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		browserNav(QA_CoverStoryURL);
	}	
	
	@Test(priority = 0)
	public void coverStoryForgotPassword() throws Exception {

		LoginPageobjects lgin = new LoginPageobjects(driver);
		ForgotPassword password = new ForgotPassword(driver);
		Thread.sleep(10000);
		lgin.loginIcon.click();
		lgin.loginButton.click();
		Thread.sleep(3000);
		password.forgotPassword.click();
		Thread.sleep(3000);
		password.resetPassword.click();
		log(Excelutility.excelData(2, 0, 0));
		password.email.sendKeys(Excelutility.excelData(2, 0, 0));
		password.proceedButoon.click();	
}
	@Test(priority = 1)
	public void coverStoryCheckoutForgotPassword() throws Exception {

		LoginPageobjects lgin = new LoginPageobjects(driver);
		ForgotPassword password = new ForgotPassword(driver);
		OrderObjects order = new OrderObjects(driver);
		TestAddCart cart = new TestAddCart();
		cart.AddToCart();	
		Thread.sleep(2000);
		lgin.pncode.sendKeys(Excelutility.excelData(2, 2, 0));	
		order.proceedToCheckout.click();
		Thread.sleep(2000);
		password.CheckoutforgotPassword.click();
		Thread.sleep(3000);
		password.resetPassword.click();
		log(Excelutility.excelData(2, 0, 0));
		password.email.sendKeys(Excelutility.excelData(2, 0, 0));
		password.proceedButoon.click();	
		//password.CheckoutSignInButton.click();
		
		
}
}