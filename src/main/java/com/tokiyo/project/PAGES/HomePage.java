//package
package com.tokiyo.project.PAGES;
//****************************************************************************

import org.openqa.selenium.By;
//imported packages
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.tokiyo.project.TESTBASE.TestBase;
import com.tokiyo.project.UTIL.TestUtil;
//***************************************************************************************

//HOMEPAGE
public class HomePage extends TestBase{
	
	//HOMEPAGE CONSTRUCTOR STARTS
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	//HOMEPAGE CONSTRUCTOR ENDS
	
	//WEBELEMENTS

	
/*	@FindBy(xpath="//a[@id='wine']")
	WebElement wineGoodsLink;
	@FindBy(xpath="//a[contains(text(),'WA137')]")
	WebElement winePumpWA137Link;*/
	
	@FindBy(xpath="//button[@class='add-to-cart btn btn-primary']")
	WebElement addToCartButton;
	@FindBy(xpath="//div[contains(@class,'mb-sm-3')]//a[contains(@class,'')]")
	WebElement proceedToCheckOutButton;
	@FindBy(xpath="//input[@id='login-form-email']")
	WebElement emailaddressTextField;
	@FindBy(xpath="//input[@id='login-form-password']")
	WebElement passwordTextField;
	@FindBy(xpath="//button[@class='btn btn-block btn-primary']")
	WebElement loginButton;
	@FindBy(xpath="//button[@class='btn btn-primary btn-block submit-shipping']")
	WebElement proceedToEnterPaymentInformationButton;
	@FindBy(xpath="//input[@id='phoneNumber']")
	WebElement phoneNumberTextField;
	@FindBy(xpath="//input[@id='saved-payment-security-code']")
	WebElement cvvTextField;
	@FindBy(xpath="//button[@class='btn btn-primary btn-block submit-payment']")
	WebElement toconfirmScreenButton;
	@FindBy(xpath="//button[@class='btn btn-primary btn-block place-order']")
	WebElement confirmOrderButton;
	@FindBy(xpath="//font[contains(text(),'Thank you for your order.')]")
	WebElement getSuccessOrderConfirmationMsg;
	@FindBy(xpath="//p[@class='error-message-text']")
	WebElement inValidPaymentMsg;
	
	//***************************************************************************************************
	
	//
	//
	public static WebElement getProductWebElement(String productXpath)
	{
		WebElement product = driver.findElement(By.xpath(productXpath));
		return product;
	}
	//
	
	public void orderItemUsingmailPayment(String mailId, String passWord,String phoneNumber, String cvv, String xpathOfProdCategory,String xpathOfProd, String t)
	{
		
		WebElement prodCategory = getProductWebElement(xpathOfProdCategory);
		prodCategory.click();
		WebElement product = getProductWebElement(xpathOfProd);
		product.click();
		
		
		//
		//wineGoodsLink.click();
		//winePumpWA137Link.click();
		addToCartButton.click();
		proceedToCheckOutButton.click();
		emailaddressTextField.sendKeys(mailId);
		passwordTextField.sendKeys(passWord);
		loginButton.click();
		proceedToEnterPaymentInformationButton.click();
		phoneNumberTextField.clear();
		phoneNumberTextField.sendKeys(phoneNumber);
		cvvTextField.sendKeys(cvv);
		TestUtil.delayToSync();
		TestUtil.scrollDown();
		toconfirmScreenButton.click();
		TestUtil.delayToSync();
		TestUtil.scrollDown();
		
		confirmOrderButton.click();
		
		/*TestUtil.delayToSync();
		
		String getSuccessOrderConfirmationString=null;
		String inValidPaymentMsgString=null;
		try {
				getSuccessOrderConfirmationString = getSuccessOrderConfirmationMsg.getText();
				
			}catch(Exception e)
			{
				inValidPaymentMsgString = inValidPaymentMsg.getText();
			}
	
		
		finally
		{
		if(getSuccessOrderConfirmationString!=null)
		{
			//Assert.assertEquals(getSuccessOrderConfirmationString, "Thank you for your order.");
			if(getSuccessOrderConfirmationString.length()>0)
			Reporter.log("Item Ordered successfully TESTCASE Passed-----", true);
		}
		else if(inValidPaymentMsgString!=null)
		{
			//Assert.assertEquals(inValidPaymentMsgString, "The payment you sent is not valid.");
			if(inValidPaymentMsgString.length()>0)
			Reporter.log("The payment you sent is not valid.", true);
		}
		}
		*/
		
	}
	//*****************************************************************************
	
}
