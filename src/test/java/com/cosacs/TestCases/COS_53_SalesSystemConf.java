package com.cosacs.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IBaseBeforeAfter;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

/*
* Project Name : CosaCS -  Unicomer - COS_53_SalesSystemConf
* Author : Shivaprasad
* Version : v10.5.2.2124
* Reviewed By : 
* Date of Creation : 
* Date of change : 
* changed function : 
* Steps followed : Login-->Configuration-->System settings-->Edit ALl required fields-->POS -->Validate Changes made-->Take a print out for validating and save in local folder-->Re-correct previous data-->save-->HOme page -->Exit
* * Modified By : 
*/

public class COS_53_SalesSystemConf extends BaseClass {

	static String header;
	static String name1;
	static String countryname;
	static String name2;
	static String currencysymbol;
	static String name3;
	static String taxnumber;
	static String name4;
	static String taxname;
	static String name5;
	static String dutyfree;

	public static Robot r;

	@Test
	public static void Provide_TestData_In_SalesSystemConfigPage_Test() throws Exception {
		try {
			Thread.sleep(3000);
			Library.Interaction.switchduplicate();
			log.info("Duplicate tab is created");
			Library.Interaction.switchtochildwin1();
			log.info("Control swited to child window");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.configurationtab);
			log.info("User clicked on configuration tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.systemsetting);
			log.info("User clicked on system settings");
			Library.Interaction.userWait();
			header = driver.findElement(By.xpath(Xpath.systemconfig.systemsettingheader)).getText();
			Assert.assertEquals(header, JsonParser.testData("SalesConfiguration.verifysysheader"));
			log.info("User successfully logged into system setting page");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.sales);
			log.info("User selected sales configuration setting");
			Library.Interaction.userWait();
			List<WebElement> val = driver.findElements(By.xpath(Xpath.systemconfig.presentreturnreason));
			for (WebElement wb : val) {
				System.out.println(wb.getText());
			}
			log.info("USer succesfully made a note of present reason list");
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.returnediticon);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.editreturnreason);
			Thread.sleep(500);
			log.info("User logged into reason text area to update reason point");
			Thread.sleep(1000);
			Library.Interaction.keyuparrow();
			Thread.sleep(500);
			Library.Interaction.typeCharacter(JsonParser.testData("SalesConfiguration.reason"));
			log.info("User updated the reason point as -->  " + JsonParser.testData("SalesConfiguration.reason"));
			r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveiconreturnreason);
			log.info("User saved the changes made");
			Library.Interaction.ScrollElemntsample(Xpath.systemconfig.countryname);
			name1 = driver.findElement(By.xpath(Xpath.systemconfig.countryname)).getText();
			log.info("Name to be changed -->   " + name1);
			Library.Interaction.userWait();
			countryname = driver.findElement(By.xpath(Xpath.systemconfig.presentcountryname)).getText();
			log.info("Current country name -->  " + countryname);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.countrynameediticon);
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.editcountrynametextbox,
					JsonParser.testData("SalesConfiguration.TestdataForCountryName"));
			log.info("User successfully made few changes in country name field");
			Thread.sleep(100);
			Library.Interaction.click(Xpath.systemconfig.saveiconcountryname);
			log.info("User saved the changes made");
			// ************COUNTRY NAME CHanged*********************
			Thread.sleep(100);
			name2 = driver.findElement(By.xpath(Xpath.systemconfig.currencysymbolname)).getText();
			log.info("Name to be changed -->   " + name2);
			Library.Interaction.userWait();
			currencysymbol = driver.findElement(By.xpath(Xpath.systemconfig.presentcurrency)).getText();
			log.info("Current currency symbol -->  " + currencysymbol);
			Library.Interaction.click(Xpath.systemconfig.currencysymbolediticon);
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.editcurrencysymbol,
					JsonParser.testData("SalesConfiguration.TestDataCurrency"));
			log.info("User successfully made few changes in currency symbol field");
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveiconcurrency);
			log.info("User saved the changes made");
			// ************CURRENCY CHanged*********************
			Thread.sleep(100);
			name3 = driver.findElement(By.xpath(Xpath.systemconfig.companytaxnumber)).getText();
			log.info("Name to be changed -->   " + name3);
			Library.Interaction.userWait();
			taxnumber = driver.findElement(By.xpath(Xpath.systemconfig.presenttaxnumber)).getText();
			log.info("Current Tax number -->  " + taxnumber);
			Library.Interaction.click(Xpath.systemconfig.taxnumberediticon);
			Thread.sleep(500);
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.edittaxnumber,
					JsonParser.testData("SalesConfiguration.TestDataTaxNumber"));
			log.info("User successfully made few changes in company Tax number field");
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveicontaxnumber);
			log.info("User saved the changes made");
			// ****TAX number changed*************
			Thread.sleep(100);
			name4 = driver.findElement(By.xpath(Xpath.systemconfig.Taxname)).getText();
			log.info("Name to be changed -->   " + name4);
			Library.Interaction.userWait();
			taxname = driver.findElement(By.xpath(Xpath.systemconfig.presenttaxname)).getText();
			log.info("Current Tax name -->  " + taxname);
			Library.Interaction.click(Xpath.systemconfig.taxnameediticon);
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.edittaxname,
					JsonParser.testData("SalesConfiguration.TestDatataTaxName"));
			log.info("User successfully made few changes in company Tax name field");
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveicontaxname);
			log.info("User saved the changes made");
			// ****TAX name changed*************
			Thread.sleep(100);
			name5 = driver.findElement(By.xpath(Xpath.systemconfig.dutyfree)).getText();
			log.info("Name to be changed -->   " + name5);
			Library.Interaction.userWait();
			dutyfree = driver.findElement(By.xpath(Xpath.systemconfig.presentdutyfreesales)).getText();
			log.info("Current status 'true' or 'false' -->  " + dutyfree);
			Library.Interaction.click(Xpath.systemconfig.dutyfreeediticon);
			Library.Interaction.click(Xpath.systemconfig.editdutyfree);
			log.info("User successfully made changes by clicking on check box");
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveicondutyfree);
			log.info("User saved the changes made");
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	@Test(dependsOnMethods = { "Provide_TestData_In_SalesSystemConfigPage_Test" })
	public void Generate_SalesReceipt_Test() throws Exception {
		try {
			Library.Interaction.switchtoparent();
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.salesbut);
			log.info("User successfully clicked on sales tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.pointofsalesbut);
			log.info("User successfully clicked on Point of sales tab");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.POSsearchtextbox,
					JsonParser.testData("SalesConfiguration.productcode"));
			log.info("User entered product code in search box");
			Thread.sleep(2000);
			Library.Interaction.IsDisplayed_Click(Xpath.systemconfig.addtocart);
			log.info("User selected and added the product into basket");
			Library.Interaction.IsDisplayed(Xpath.systemconfig.soldbydroparrow);
			Library.Interaction.selectele(Xpath.systemconfig.soldbydroparrow, Xpath.PointOfSales.soldbytextbox,
					Xpath.PointOfSales.soldbyselectlist, JsonParser.testData("SalesConfiguration.cashier"),
					JsonParser.testData("SalesConfiguration.soldbyname"));
			log.info("User successfully entered cashier name and selected");
			Library.Interaction.IsDisplayed(Xpath.systemconfig.taxfreecheckbox);
			String vvv = driver.findElement(By.xpath(Xpath.systemconfig.taxfreecheckbox)).getText();
			System.out.println(vvv);
			if (driver.findElement(By.xpath(Xpath.systemconfig.taxfreecheckbox)).isDisplayed()) {
				log.info("Found Tax FRee option");
			} else {
				System.out.println("Not Found Tax Free option");
			}
			// if
			// (driver.findElement(By.xpath(Xpath.systemconfig.dutyfreecheckbox)).isDisplayed())
			// {
			// log.info("Found Duty tax option");
			// }else {
			// System.out.println("Not Found Duty tax option ");
			// }
			Library.Interaction.IsDisplayed(Xpath.systemconfig.addtocart);
			Library.Interaction.IsDisplayed_Click(Xpath.systemconfig.addtocart);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.customer);
			Library.Interaction.print("User clicked on Customer button");
			log.info("User is in Customer form fill up page");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.customeridtextbox,
					JsonParser.testData("SalesConfiguration.customerid"));
			Library.Interaction.print("User Entered customer id in the textbox");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.searchbutton);
			log.info("Customer details is displayed related to customer id provided");
			Library.Interaction.click(Xpath.systemconfig.selectcustomer);
			log.info("User successfully selected customer detail");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.basketbutton);
			log.info("User is in basket page");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.paymentbutton);
			log.info("User clicked on payment screen");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.cashoption);
			log.info("User successfully selected cash method to pay cashier");
			Library.Interaction.Enabled_Click(Xpath.systemconfig.paybutton);
			log.info("User clicked on pay button");
			Library.Interaction.userWait();
			driver.findElement(By.xpath(Xpath.systemconfig.salescomplete));
			log.info("Successfully sales completed");	
			Thread.sleep(10000);
			r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("clicked Prinit button");
			Thread.sleep(4000);
			Library.Interaction.typeCharacter(JsonParser.testData("SalesConfiguration.filename"));
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	@Test(dependsOnMethods = { "Provide_TestData_In_SalesSystemConfigPage_Test" })
	public void ReEnter_All_TestDataProvided_Test() throws Exception {
		try {
			Library.Interaction.switchtochildwin1();
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.systemconfig.countrynameediticon);
			Thread.sleep(100);
			Library.Interaction.click(Xpath.systemconfig.editcountrynametextbox);
			Thread.sleep(100);
			Library.Interaction.cleartext();
			Thread.sleep(100);
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.editcountrynametextbox, countryname);
			Thread.sleep(100);
			Library.Interaction.click(Xpath.systemconfig.saveiconcountryname);
			log.info("User succesfully Re entered the existing country name");
			Library.Interaction.ScrollElemntsample(Xpath.systemconfig.countryname);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.currencysymbolediticon);
			Thread.sleep(100);
			Library.Interaction.click(Xpath.systemconfig.editcurrencysymbol);
			Thread.sleep(100);
			Library.Interaction.cleartext();
			Thread.sleep(100);
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.editcurrencysymbol, currencysymbol);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveiconcurrency);
			log.info("User successfully Re entered the existing currency symbol");
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.taxnumberediticon);
			Thread.sleep(100);
			Library.Interaction.click(Xpath.systemconfig.edittaxnumber);
			Thread.sleep(100);
			Library.Interaction.cleartext();
			Thread.sleep(100);
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.edittaxnumber, taxnumber);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveicontaxnumber);
			log.info("User successfully Re entered the existing Tax number");
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.taxnameediticon);
			Thread.sleep(100);
			Library.Interaction.click(Xpath.systemconfig.edittaxname);
			Thread.sleep(100);
			Library.Interaction.cleartext();
			Thread.sleep(100);
			Library.Interaction.setTextBoxByXpath(Xpath.systemconfig.edittaxname, taxname);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveicontaxname);
			log.info("User successfully Re entered the existing Tax name");
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.dutyfreeediticon);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.editdutyfree);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.saveicondutyfree);
			Thread.sleep(2000);
			Library.Interaction.ScrollElemntdirectlocact(header);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.returnediticon);
			Thread.sleep(500);
			Library.Interaction.click(Xpath.systemconfig.editreturnreason);
			Thread.sleep(1000);
			Library.Interaction.keyuparrow();
			Thread.sleep(1000);
			Library.Interaction.keydel();
			Thread.sleep(100);
			Library.Interaction.click(Xpath.systemconfig.saveiconreturnreason);
			log.info("User successfully Re entered the existing Return Reason");
			Library.Interaction.click(Xpath.PointOfSales.homeicon);
			log.info("User is in home page");

		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}
}
