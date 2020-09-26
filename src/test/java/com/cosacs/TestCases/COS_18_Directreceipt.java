package com.cosacs.TestCases;

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
* Version : v10.5.2.2124 and v10.6
* Reviewed By : 
* Date of Creation : 
* Date of change : 
* changed function : 
* Steps followed : Login-->Merchandising-->search product-->Verify the stock quantity of product-->Create-->Direct Receipt-->Printing Direct receipt number-->Validate the Stock count after DRN process-->Home page
* Modified By : 
*/

public class COS_18_Directreceipt extends BaseClass {

	public static int countv;
	public static int qty1 = 1;

	@Test

	public static void Directreceipt_verify_stockcount_Test() throws Exception {

		try {

			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Directreceipt.merchandising);
			log.info("User clicked on merchandising");
			Library.Interaction.moveToElement(Xpath.Directreceipt.search);
			Library.Interaction.print("mouse over action on search");
			Library.Interaction.click(Xpath.Directreceipt.productenquiry);
			log.info("User clicked on product enquiry");
			Library.Interaction.userWait();
			String verifypage = driver.findElement(By.xpath(Xpath.Directreceipt.verifyproductpage)).getText();
			Assert.assertEquals(verifypage, JsonParser.testData("DirectReceipt.propage"));
			log.info("User successfully logged into Product Enquiry page");
			Library.Interaction.setTextBoxByXpath(Xpath.Directreceipt.searchtext,
					JsonParser.testData("DirectReceipt.val"));
			log.info("User entered the product code");
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.product);
			Library.Interaction.IsDisplayed_required(Xpath.Directreceipt.product,
					JsonParser.testData("DirectReceipt.val"));
			log.info("User selected required product for next process");
			String verifysparepage = Library.Interaction.splitsymbol(Xpath.Directreceipt.verifysparepartpage);
			System.out.println(verifysparepage + "<--");
			Assert.assertEquals(verifysparepage, JsonParser.testData("DirectReceipt.sparepage"));
			log.info("User successfully logged into spare part maintenance page");// verify spare part maintain page
			Library.Interaction.userWait();
			String locname = driver.findElement(By.xpath(Xpath.Directreceipt.verifylocation)).getText();
			log.info(locname + " <--Stock Count Location Name");
			String scount1 = driver.findElement(By.xpath(Xpath.Directreceipt.verifylocationcount1)).getText();
			log.info(scount1 + "   <----Stock count value");
			log.info("User noted the stockcount of the product");
			countv = Integer.parseInt(scount1.trim());

		} catch (InterruptedException e) {

			captureScreen(driver, "Directreceipt_verify_stockcount");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	@Test(dependsOnMethods = { "Directreceipt_verify_stockcount_Test" })
	public void Generate_Directreceipt_number_form_Test() throws Exception {
		try {

			Library.Interaction.click(Xpath.Directreceipt.merchandising);
			log.info("clicked on merchandising");
			Library.Interaction.moveToElement(Xpath.Directreceipt.create);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Directreceipt.directreceipt);
			log.info("clicked on create direct receipt");
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.verifydirectpage);
			String header = driver.findElement(By.xpath(Xpath.Directreceipt.verifydirectpage)).getText();
			Assert.assertEquals(header, JsonParser.testData("DirectReceipt.headerpage"));
			log.info("USer successfully logged into Direct Receipt page");
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.recarrowclick);
			Library.Interaction.selectele(Xpath.Directreceipt.recarrowclick, Xpath.Directreceipt.recsearchval,
					Xpath.Directreceipt.recslectlist, JsonParser.testData("DirectReceipt.recinputval"),
					JsonParser.testData("DirectReceipt.recval"));
			log.info("User successfully selected the receiving location");
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.Directreceipt.vendorarrowclick, Xpath.Directreceipt.vendorsearchval,
					Xpath.Directreceipt.vendorselectlist, JsonParser.testData("DirectReceipt.vendinputval"),
					JsonParser.testData("DirectReceipt.vendval"));
			log.info("User successfully selected the vendor");
			Library.Interaction.selectEleByIndex(Xpath.Directreceipt.receivedby, 4);
			log.info("User successfully selected the receiving person");
			Library.Interaction.setTextBoxByXpath(Xpath.Directreceipt.vendordevnum,
					JsonParser.testData("DirectReceipt.vendornum"));
			log.info("User successfully entered the vendor referance number");
			Library.Interaction.setTextBoxByXpath(Xpath.Directreceipt.vendorinvnum,
					JsonParser.testData("DirectReceipt.vendorinvnum"));
			log.info("User successfully entered the vendor invoice number");
			Library.Interaction.click(Xpath.Directreceipt.refaddicon);
			log.info("Referance add icon is clicked successfully");
			Library.Interaction.selectele(Xpath.Directreceipt.refarrow, Xpath.Directreceipt.reftext,
					Xpath.Directreceipt.refselect, JsonParser.testData("DirectReceipt.reftext"),
					JsonParser.testData("DirectReceipt.reftextval"));
			log.info("User successfully selected the referance option");
			Library.Interaction.setTextBoxByXpath(Xpath.Directreceipt.refinput,
					JsonParser.testData("DirectReceipt.reftextnum"));
			log.info("User successfully entered contacts details");
			Library.Interaction.setTextBoxByXpath(Xpath.Directreceipt.textarea,
					JsonParser.testData("DirectReceipt.comment"));
			log.info("User successfully updated comment details");
			Library.Interaction.click(Xpath.Directreceipt.addicon);
			log.info("User clicked on add icon fro adding product");
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.Directreceipt.addproductarrow, Xpath.Directreceipt.productcode,
					Xpath.Directreceipt.productselect, JsonParser.testData("DirectReceipt.Sku"),
					JsonParser.testData("DirectReceipt.Sku"));
			log.info("User successfully entered product code and selected");
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.qtyReceived);
			Library.Interaction.setTextBoxByXpath(Xpath.Directreceipt.qtyReceived,
					JsonParser.testData("DirectReceipt.qty"));
			log.info("User successfully entered product code and selected");
			Library.Interaction.setTextBoxByXpath(Xpath.Directreceipt.procomment,
					JsonParser.testData("DirectReceipt.procomment"));
			log.info("User successfully updated comment details of product");
			Library.Interaction.click(Xpath.Directreceipt.tickmark);
			log.info("product added successfully");
			Library.Interaction.ScrollElemntsmallH(Xpath.Directreceipt.addicon);
			Library.Interaction.print("scrolled down");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Directreceipt.createreceiptbut);
			log.info("User successfully clicked on create receipt button");
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.status);
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.verifydirectpage);
			String verifydirectpage = Library.Interaction.splithashandverify(Xpath.Directreceipt.verifydirectpage);
			System.out.println(verifydirectpage);
			System.out.println(JsonParser.testData("DirectReceipt.directreceiptpage"));
			Assert.assertEquals(verifydirectpage, JsonParser.testData("DirectReceipt.directreceiptpage"));
			log.info("User successfully logged into directreceipt page for approval");
			String statusbeforeapprove = driver.findElement(By.xpath(Xpath.Directreceipt.status)).getText();
			System.out.println(statusbeforeapprove);
			System.out.println(JsonParser.testData("DirectReceipt.statusbfrapprove"));
			Assert.assertEquals(statusbeforeapprove, JsonParser.testData("DirectReceipt.statusbfrapprove"));
			log.info("Status is Awaiting still");
			String dircode = Library.Interaction.splithash(Xpath.Directreceipt.verifyapprovepage);
			log.info("Direct receipt number has been noted");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Directreceipt.approvebut);
			log.info("User successfully clicked on approved button");
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.approvedstatus);
			String statusdirect1 = driver.findElement(By.xpath(Xpath.Directreceipt.status)).getText();
			log.info(statusdirect1 + "   <-----Status after approval");
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.printcostbut);
			Library.Interaction.IsDisplayed_Click(Xpath.Directreceipt.printcostbut);
			log.info("User successfully clicked on print cost button for printing");
			Library.Interaction.IsDisplayed_Click(Xpath.Directreceipt.okbutton);
			log.info("Clicked on ok button for confirmation");
			Library.Interaction.switchtochildwin1();
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.refnumber);
			String retainval = Library.Interaction.retainonlynumbers(Xpath.Directreceipt.refnumber);
			Assert.assertEquals(retainval, dircode);
			log.info("Successfully validated the Receipt number generated");
			Library.Interaction.switchtoparent();
			log.info("User is now successfully switched back to main page from print page");

		} catch (InterruptedException e) {

			captureScreen(driver, "Directreceipt_form");
			Assert.assertFalse(false);
			log.info("Test Failed");
		} }
	
	@Test(dependsOnMethods = { "Generate_Directreceipt_number_form_Test" })
	public void Validate_Directreceipt_stockcount_afterDRN_Test() throws Exception {

		try {

			Library.Interaction.IsDisplayed_Click(Xpath.Directreceipt.productlinkforverify);
			Library.Interaction.IsDisplayed(Xpath.Directreceipt.verifysparepartpage);
			String verifysparepage = Library.Interaction.splitsymbol(Xpath.Directreceipt.verifysparepartpage);
			System.out.println(verifysparepage + "<--");
			Assert.assertEquals(verifysparepage, JsonParser.testData("DirectReceipt.sparepage"));
			log.info("User successfully logged into spare part maintenance page");// verify spare part maintain page
			Library.Interaction.userWait();
			String locname = driver.findElement(By.xpath(Xpath.Directreceipt.verifylocation)).getText();
			log.info(locname + " <--Stock Count Location Name");
			String scount1 = driver.findElement(By.xpath(Xpath.Directreceipt.verifylocationcount1)).getText();
			log.info(scount1 + "   <----Stock count value");
			log.info("User noted the stockcount of the product");
			int actualcount = Integer.parseInt(scount1.trim());
			log.info(countv + " <-- Initial product stock count");
			log.info(qty1 + " <--Added stock count quantity");
			log.info(actualcount + " <--Actual count after adding product stock");
			int expectedquantity = countv + qty1;
			log.info(expectedquantity + " <--Expected product count");
			Assert.assertEquals(actualcount, expectedquantity);
			log.info("User successfully validated the total quantity added to the location");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Directreceipt.homeicon);
			log.info("User is in Home Page");

		} catch (InterruptedException e) {

			captureScreen(driver, "Directreceipt_stockcount_afterDRN");
			Assert.assertFalse(false);
			log.info("Test Failed");

		} 
	}
}

	


