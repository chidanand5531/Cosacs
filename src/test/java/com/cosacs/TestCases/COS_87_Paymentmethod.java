package com.cosacs.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

public class COS_87_Paymentmethod extends BaseClass {

	@Test
	public static void Print_PaymentMethod_ListAvailableinPOS_Test() throws Exception {
		try {

			Thread.sleep(3000);
			Library.Interaction.switchduplicate();
			log.info("User created duplicate Tab");
			Thread.sleep(2000);
			Library.Interaction.switchtoparent();
			log.info("User is in main window");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.salesbut);
			log.info("User successfully clicked on sales tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.pointofsalesbut);
			log.info("User successfully clicked on Point of sales tab");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.paymentmethod.POSsearchtextbox,
					JsonParser.testData("PaymentMethod.productcode"));
			log.info("User entered product code in search box");			
			Thread.sleep(2000);
			Library.Interaction.IsDisplayed(Xpath.paymentmethod.selectproductPOS);
			Library.Interaction.click(Xpath.paymentmethod.selectproductPOS);
			log.info("User selected and added the product into basket");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.paymentbuttonPOS);
			log.info("User clicked on payment screen");
			Library.Interaction.IsDisplayed(Xpath.paymentmethod.saleverify);
			String Salescreenverify = driver.findElement(By.xpath(Xpath.paymentmethod.saleverify)).getText();
			System.out.println(Salescreenverify+"<--");
			System.out.println(JsonParser.testData("PaymentMethod.Salespage")+"<--");
			Assert.assertEquals(Salescreenverify, JsonParser.testData("PaymentMethod.Salespage"));
			log.info("User is in Sales screen");
			Thread.sleep(3000);
			log.info("************Start of payment method list present******");
			List<WebElement> payvalue = driver.findElements(By.xpath(Xpath.paymentmethod.paymentoption));
			for (WebElement wb : payvalue) {
				String text = wb.getText();
				log.info("  " + text);
			}
			log.info("************End of payment method list present**********");

		} catch (InterruptedException e) {
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	
	
	@Test(dependsOnMethods = { "Print_PaymentMethod_ListAvailableinPOS_Test" })
	public void Select_Required_PaymentMethodCheckBox_Test() throws Exception {

		try {
			Thread.sleep(2000);
			Library.Interaction.switchtochildwin1();
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.paymenttab);
			log.info("User clicked on payment tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.paymentsetup);
			log.info("User clicked on paymentsetup tab");
			Library.Interaction.userWait();
			
			String verifysetuppage = driver.findElement(By.xpath(Xpath.paymentmethod.verifypaymentsetuppage)).getText();
			Assert.assertEquals(verifysetuppage, JsonParser.testData("PaymentMethod.verifypage"));
			log.info("User successfully logged into payment setup page");
//			List<WebElement> val = driver.findElements(By.xpath(Xpath.paymentmethod.tablelist));
//			for (WebElement wb : val) {
//				String va = wb.getText();
//				System.out.print(va + "-");
//
//			}
			//log.info("User successfully noted all the present list of payment method");
			Library.Interaction.userWait();		
			List<WebElement> res = driver.findElements(By.xpath(Xpath.paymentmethod.tdd));// click
			for (WebElement check : res) {
				check.click();
			}
			log.info("User successfully checked the unchecked check box in the Payment list");

		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	
	
	@Test(dependsOnMethods = { "Select_Required_PaymentMethodCheckBox_Test" })
	public void Validate_PaymentMethod_Selected_Test() throws Exception {
		try {

			Thread.sleep(1000);
			Library.Interaction.switchtoparent();
			Thread.sleep(1000);
			Library.Interaction.refreshpage();
			Thread.sleep(5000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.selectproductPOS);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.paymentbuttonPOS);
			log.info("User is in payment screen");
			Thread.sleep(2000);		
			String Salescreenverify = driver.findElement(By.xpath(Xpath.paymentmethod.saleverify)).getText();
			Assert.assertEquals(Salescreenverify, JsonParser.testData("PaymentMethod.Salespage"));
			log.info("User is in Sales screen");
			log.info("********Start of payment method list present after update in payment list******");
			List<WebElement> paymethodverify = driver.findElements(By.xpath(Xpath.paymentmethod.paymentoption));
			for (WebElement wb : paymethodverify) {
				String text = wb.getText();
				log.info("  " + text);
			}					
			log.info("************End of payment method list present**********");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	
	
	@Test(dependsOnMethods = { "Validate_PaymentMethod_Selected_Test" })
	public void MakeChanges_AS_previous_Test4() throws Exception {
		try {
			Thread.sleep(1000);
			Library.Interaction.switchtochildwin1();
			Thread.sleep(1000);
			List<WebElement> res1 = driver.findElements(By.xpath(Xpath.paymentmethod.tdd));
			for (WebElement check : res1) {
				check.click();
			}
			log.info("User checked the unchecked check box");
			Library.Interaction.userWait();
			Library.Interaction.switchtoparent();
			Thread.sleep(1000);
			Library.Interaction.refreshpage();			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.menubutton);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.paymentmethod.homeicon);
			log.info("User is in home page");
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}
}
