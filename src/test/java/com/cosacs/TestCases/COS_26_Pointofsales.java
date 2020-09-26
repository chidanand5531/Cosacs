package com.cosacs.TestCases;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

/*
* Project Name : CosaCS -  Unicomer
* Author : Shivaprasad
* Version : v10.5.2.2124
* Reviewed By : 
* Date of Creation : 
* Date of change : 
* changed function : 
* Steps followed : Login-->Sales-->Point of Sales-->Select random products-->Add and delete the added product-->Validate the Unit cost of the product-->Make the payment with cash-->Check receipt is enabled -->Search the product sold by validating Invoice number-->Home page-->Exit
* Modified By : 
*/
//**NOTE  --->>Before running the script change the 'date from' and 'date to' data as Today' date *****************

public class COS_26_Pointofsales extends BaseClass {

	public static int qtyadded = 1;
	public static int discount = 2;
	static String invnumber;

	@Test

	public static void SearchForTheProduct_AddRandomProducts_Test() throws Exception {

		try {
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.salesbut);
			log.info("User successfully clicked on sales tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.pointofsalesbut);
			log.info("User successfully clicked on Point of sales tab");
			String saleverify = driver.findElement(By.xpath(Xpath.PointOfSales.saleverify)).getText();
			Assert.assertEquals(saleverify, JsonParser.testData("PointOfSales.verifysalepage"));
			log.info("User is in Point of Sales Page ");
			Library.Interaction.IsDisplayed_Click(Xpath.PointOfSales.majorwhitegreen);
			log.info("User clicked on majorwhite division");
			Library.Interaction.IsDisplayed_Click(Xpath.PointOfSales.randaomproduct);
			log.info("User selected random product under Majorwhite division and added to basket");
			Library.Interaction.IsDisplayed_Click(Xpath.PointOfSales.resetbutton);
			log.info("User cleared all selected product");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.majorwhitegreen);
			log.info("User clicked on majorwhite division");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.randaomproduct1);
			log.info("User successfully added a product");

		} catch (IOException e) {

			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	@Test(dependsOnMethods = { "SearchForTheProduct_AddRandomProducts_Test" })
	public void Add_CustomerDetails_Test() throws IOException, Exception {
		try

		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.customer);
			log.info("User is in Customer form fill up page");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.PointOfSales.customeridtextbox,
					JsonParser.testData("PointOfSales.customerid"));
			Library.Interaction.print("User Entered customer id in the textbox");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.searchbutton);
			log.info("Customer details is displayed related to customer id provided");
			Library.Interaction.IsDisplayed_Click(Xpath.PointOfSales.clearbutton);
			log.info("User successfully cleared the customer deatils");
			Library.Interaction.IsDisplayed(Xpath.PointOfSales.customeridtextbox);
			Library.Interaction.setTextBoxByXpath(Xpath.PointOfSales.customeridtextbox,
					JsonParser.testData("PointOfSales.customerid"));
			Library.Interaction.print("User Entered customer id in the textbox");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.searchbutton);
			Library.Interaction.print("User clicked on Search button");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.selectcustomer);
			log.info("User successfully selected customer detail");

			// **********************Customer details*********************************

		} catch (IOException e) {

			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	@Test(dependsOnMethods = { "Add_CustomerDetails_Test" })
	public void Validate_AddedProduct_And_UnitCost_Test() throws IOException, Exception {
		try {

			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.basketbutton);
			log.info("User is in basket page");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.deleteselectedproduct);
			log.info("User successfully deleted the added product");
			Library.Interaction.userWait();
			String unitcost = Library.Interaction.retainonlynumbers(Xpath.PointOfSales.Basketunitcost);
			int costunit = Integer.parseInt(unitcost.trim());
			log.info(costunit + " <--Unit cost of product");
			Library.Interaction.userWait();
			String taxcost = Library.Interaction.retainonlynumbers(Xpath.PointOfSales.Baskettaxcost);
			int costtax = Integer.parseInt(taxcost.trim());
			log.info(costtax + " <--tax cost of product");
			Library.Interaction.userWait();
			String saleitemcost = Library.Interaction.retainonlynumbers(Xpath.PointOfSales.Salestotalitem);
			int costitemsale = Integer.parseInt(saleitemcost.trim());
			log.info(costitemsale + " <--Total item cost in sale");
			Library.Interaction.userWait();
			String salecosttax = Library.Interaction.retainonlynumbers(Xpath.PointOfSales.Saletotaltax);
			int taxcostsale = Integer.parseInt(salecosttax.trim());
			log.info(taxcostsale + " <--Total tax cost item in sale");
			Library.Interaction.userWait();
			String totalbalance = Library.Interaction.retainonlynumbers(Xpath.PointOfSales.Saletotalbalance);
			int balancetotal = Integer.parseInt(totalbalance.trim());
			log.info(balancetotal + " <--Toatal balance cost in sale");
			Assert.assertEquals(costunit, costitemsale);
			log.info("Successfully verified the unit cost value in sales section");
			Assert.assertEquals(costtax, taxcostsale);
			log.info("Successfully verified the unit tax cost value in sales section");
			Library.Interaction.userWait();
			int verifybalance = costitemsale + taxcostsale;
			Assert.assertEquals(balancetotal, verifybalance);
			log.info(verifybalance + " <--Verified with the total added cost for the product");
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.PointOfSales.soldbydroparrow1, Xpath.PointOfSales.soldbytextbox,
					Xpath.PointOfSales.soldbyselectlist, JsonParser.testData("PointOfSales.cashier"),
					JsonParser.testData("PointOfSales.soldbyname"));
			log.info("User succesfully entered cashier name and selected");

		} catch (IOException e) {

			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");

		}
	}

	@Test(dependsOnMethods = { "Validate_AddedProduct_And_UnitCost_Test" })
	public void Make_Payment_And_GenerateInvoiceNumber_Test() throws IOException, Exception {
		try

		{

			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.paymentbutton);
			log.info("User is in paymnent page");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.cashoption);
			log.info("User successfully selected cash method to pay the cashier");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.paybutton);
			log.info("User clicked on pay button");
			Library.Interaction.userWait();
			driver.findElement(By.xpath(Xpath.PointOfSales.salescomplete));
			log.info("Successfully sales completed");
			Thread.sleep(8000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			log.info("User clciked on Esc button to eliminate Receipt print out");
			Library.Interaction.userWait();
			invnumber = Library.Interaction.retainonlynumbers(Xpath.PointOfSales.invoicenumber);
			log.info("User successfully noted the invoice number");

		} catch (IOException e) {

			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	@Test(dependsOnMethods = { "Make_Payment_And_GenerateInvoiceNumber_Test" })
	public void Validate_Generated_InvoiceNumber_Test() throws IOException, Exception {
		try {

			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.menubutton);
			log.info("User clicked on menu tab for the visible of main tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.salesbut);
			log.info("User successfully clicked on sales tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.searchorder);
			log.info("User clicked on search order button");
			Library.Interaction.userWait();
			String searchorder = driver.findElement(By.xpath(Xpath.PointOfSales.verifysearchorder)).getText();
			Assert.assertEquals(searchorder, JsonParser.testData("PointOfSales.verifysearchorder"));
			log.info("User is in Search Order page");
			Library.Interaction.IsDisplayed(Xpath.PointOfSales.datefrom);
			Library.Interaction.setTextBoxByXpath(Xpath.PointOfSales.datefrom,
					JsonParser.testData("PointOfSales.datefrom"));
			log.info("User selected from date");
			Library.Interaction.IsDisplayed(Xpath.PointOfSales.Todate);
			Library.Interaction.click(Xpath.PointOfSales.Todate);
			Library.Interaction.setTextBoxByXpath(Xpath.PointOfSales.Todate,
					JsonParser.testData("PointOfSales.Todate"));
			log.info("User selected To date");
			Thread.sleep(2000);
			Library.Interaction.click(Xpath.PointOfSales.SOsearchbutton);
			log.info("User clicked on search button");
			Library.Interaction.verifylist(Xpath.PointOfSales.verifyinvnumberpresent, invnumber);
			log.info("User found the invoice number");
			log.info(invnumber + " <--Invoice number");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.PointOfSales.homeicon);
			log.info("User is in Home page");

			// *********************Verified the invoice number**************

		} catch (IOException e) {

			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");

		}

	}
}
