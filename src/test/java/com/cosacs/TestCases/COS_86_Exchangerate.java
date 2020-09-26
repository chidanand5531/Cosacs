package com.cosacs.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

/*
* Project Name : CosaCS -  Unicomer - COS_86_Exchangerate
* Author : Shivaprasad
* Version : v10.6.1.2171
* Reviewed By : 
* Date of Creation : 
* Date of change : 
* changed function : 
* Steps followed : Login-->Home page-->Payments-->Add and delete required currency type--> update Exchange rate-->NOte down the required exchange rate value-->POS-->Purchase sale--->Payment screen-->Validate Exchange rate value
* Modified By : 
*/

//Note : Update test data for different location and update TOmorrow's date

public class COS_86_Exchangerate extends BaseClass {
	
	public static int verifyrate;
	@Test

	public static void verifyexchangerate_Test() throws Exception {

		try {
			log.info("User is in home page");			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.paymenttab);
			log.info("User clicked on payment tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.exchangeratetab);
			log.info("User clicked on exchangerate");
			Library.Interaction.userWait();
			String header = driver.findElement(By.xpath(Xpath.Exchangerate.verifyheader)).getText();
			Assert.assertEquals(header, JsonParser.testData("ExchangeRate.verifyheader"));
			log.info("User successfully logged into Exchange Rate page");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.addicon);
			log.info("User clicked on add icon for adding currency rate");
			Library.Interaction.userWait();
			Library.Interaction.selectSuggestion(Xpath.Exchangerate.currencydroparrow2,
					Xpath.Exchangerate.currencydroptextbox2, Xpath.Exchangerate.currencydropselect2, JsonParser.testData("ExchangeRate.codeselect"),
					JsonParser.testData("ExchangeRate.codeselectName"));
			log.info("User selected the required currency in the list");
			Thread.sleep(3000);
			Library.Interaction.setTextBoxByXpath(Xpath.Exchangerate.rateinput, JsonParser.testData("ExchangeRate.CurrencyRate"));
			log.info("User added the exchangerate value for selected currency");
			Thread.sleep(500);
			Library.Interaction.setTextBoxByXpath(Xpath.Exchangerate.datefrom, JsonParser.testData("ExchangeRate.date"));
			log.info("User slected the date from when the exchangerate should be in active in the application");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.savecurrency);
			log.info("User clicked on save icon");		
			Library.Interaction.IsDisplayed(Xpath.Exchangerate.sucessnotifyclose);			
			Library.Interaction.click(Xpath.Exchangerate.sucessnotifyclose);		
			Library.Interaction.IsDisplayed_Click(Xpath.Exchangerate.deletecurrencyicon);
			log.info("User clicked on delete icon");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.deletebutton);
			log.info("User successfully deleted the added currency");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.addicon);
			log.info("User clicked on add icon for adding currency rate");
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.Exchangerate.currencydroparrow2,
					Xpath.Exchangerate.currencydroptextbox2, Xpath.Exchangerate.currencydropselect2, JsonParser.testData("ExchangeRate.codeselect"),
					JsonParser.testData("ExchangeRate.codeselect"));
			log.info("User selected the required currency in the list");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.Exchangerate.rateinput, "100");
			log.info("User added the exchangerate value for selected currency");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.Exchangerate.datefrom, JsonParser.testData("ExchangeRate.date"));
			log.info("User slected the date from when the exchangerate should be in active in the application");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.undoicon);
			log.info("User clicked on undo icon");
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.Exchangerate.currencydroparrow1, Xpath.Exchangerate.currencytextbox1,
					Xpath.Exchangerate.currencyselect1, JsonParser.testData("ExchangeRate.currencyselect"), JsonParser.testData("ExchangeRate.currencyselect"));
			Library.Interaction.userWait();
			log.info("User selecetd the required currency for fetching the details of exchange rate");
			Library.Interaction.setTextBoxByXpath(Xpath.Exchangerate.effdate, JsonParser.testData("ExchangeRate.date"));
			Library.Interaction.userWait();
			log.info("User selcted the effected date");
			Library.Interaction.click(Xpath.Exchangerate.searchbutton);
			log.info("All related currency exchange rate details is displayed");
			log.info(
					"Currency name -->" + driver.findElement(By.xpath(Xpath.Exchangerate.currencydisplayed)).getText());
			Thread.sleep(2000);
			String digit = Library.Interaction.retainonlynumberswithdeci(Xpath.Exchangerate.Ratedisplayed);
			double rate = Double.parseDouble(digit);
			 verifyrate = (int) rate;
			log.info("Exchange rate for above currency--> " + "$" + verifyrate);

			Library.Interaction.userWait();
			log.info("Effective date for above currency--> "
					+ driver.findElement(By.xpath(Xpath.Exchangerate.datedisplayed)).getText());
		
		}catch (InterruptedException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		} }
			

			@Test(dependsOnMethods={"verifyexchangerate_Test"})
			public void Validate_ExchangeRtae_Test() throws Exception{
				try {
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.salesbut);
			log.info("User successfully clicked on sales tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.pointofsalesbut);
			log.info("User successfully clicked on Point of sales tab");			
			Library.Interaction.IsDisplayed(Xpath.Exchangerate.salespage);
			String expsalespage = driver.findElement(By.xpath(Xpath.Exchangerate.salespage)).getText();
			Assert.assertEquals(JsonParser.testData("ExchangeRate.verifysalespage"), expsalespage);
			log.info("User is in Sales_Pos page");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.Exchangerate.POSsearchtextbox, JsonParser.testData("ExchangeRate.productcode"));
			log.info("User entered product code in search box");
			Thread.sleep(3500);
			Library.Interaction.IsDisplayed_Click(Xpath.Exchangerate.selectproductPOS);
			log.info("User selected and added the product into basket");			
			Library.Interaction.IsDisplayed_Click(Xpath.Exchangerate.paymentbuttonPOS);
			log.info("User clicked on payment tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.foriengcashPOS);
			log.info("User clicked on Forieng cash button");
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.Exchangerate.currencydroparrowPOS,
					Xpath.Exchangerate.currencytextboxPOS, Xpath.Exchangerate.currencyselectPOS, JsonParser.testData("ExchangeRate.currencyselect"),
					JsonParser.testData("ExchangeRate.poscurrency"));
			log.info("User selected required currency type");
			Library.Interaction.userWait();
			String posrate = Library.Interaction.splithequal(Xpath.Exchangerate.verifyconversionpos);
			System.out.println(posrate);
			int verifyposrate = Integer.parseInt(posrate);
			log.info("$" + Math.round(verifyposrate));
			System.out.println(verifyrate);
			Assert.assertEquals(verifyrate, verifyposrate);
			log.info("Conversion Exchange rate is verified and currency value are matching successfully");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.menubutton);
			log.info("User click on menu button");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Exchangerate.homeicon);
			log.info("User is in home page");

		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

}
