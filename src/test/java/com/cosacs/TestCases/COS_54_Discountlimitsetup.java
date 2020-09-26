package com.cosacs.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

/*
* Project Name : CosaCS -  Unicomer - COS_54_Discountlimitsetup
* Author : Shivaprasad
* Version : v10.5.2.2124
* Reviewed By : 
* Date of Creation : 
* Date of change : 
* changed function : 
* Steps followed : Login-->Configuration-->System settings-->Edit ALl required fields-->POS -->Validate Changes made-->Take a print out for validating and save in local folder-->Re-correct previous data-->save-->HOme page -->Exit
* * Modified By : 
*/

public class COS_54_Discountlimitsetup extends BaseClass {

	@Test

	public static void Adding_discountvalue_Test() throws Exception {

		try {

		Thread.sleep(2000);
			Library.Interaction.switchduplicate();
			log.info("User opened a duplicate window ");
			Library.Interaction.switchtochildwin1();
			log.info("User switched to child window");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.salesbut);
			log.info("USer clicked on sales tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.discountlimitsetupbutton);
			log.info("USer clicked on discountlimit setup tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.addicon);
			Library.Interaction.IsDisplayed(Xpath.discountlimit.brachdroparrow2);
			Library.Interaction.selectele(Xpath.discountlimit.brachdroparrow2, Xpath.discountlimit.branchdroptextbox2,
					Xpath.discountlimit.branchdropselect2, JsonParser.testData("DiscountLimitSetup.branchcode"), JsonParser.testData("DiscountLimitSetup.discountbranchcode"));
			Library.Interaction.IsDisplayed(Xpath.discountlimit.limitpercentage);
			Library.Interaction.setTextBoxByXpath(Xpath.discountlimit.limitpercentage, JsonParser.testData("DiscountLimitSetup.discountpercentage1"));
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.saveicon);
			log.info("User successfully added a discount percentage for particular location");

			
		}
		catch (InterruptedException e) {

			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}
		@Test(dependsOnMethods={"Adding_discountvalue_Test"})
		public void Verify_DiscountLimit_Test() throws Exception {
			try {
			
			Library.Interaction.switchtoparent();
			log.info("User switched back to parent window");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.salesbut);
			log.info("User successfully clicked on sales tab");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.pointofsalesbut);
			log.info("User successfully clicked on Point of sales tab");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.discountlimit.POSsearchtextbox, JsonParser.testData("DiscountLimitSetup.productcode"));
			log.info("User entered product code in search box");
			Thread.sleep(4000);
			Library.Interaction.IsDisplayed(Xpath.discountlimit.basketicon);
			Library.Interaction.click(Xpath.discountlimit.basketicon);
			log.info("User successfully added a product");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.basketbutton);
			log.info("User is in basket page");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.downarrow);
			log.info("User clicked on discount adding drop down for selecting discount code");
			Library.Interaction.userWait();
			Library.Interaction.selecteleequal(Xpath.discountlimit.discountdropdownarrow,
					Xpath.discountlimit.discounttextbox, Xpath.discountlimit.discounttextselectlist, JsonParser.testData("DiscountLimitSetup.discountcodename"),
					JsonParser.testData("DiscountLimitSetup.discountcode"));
			log.info("User successfully added the discount code");
			Library.Interaction.setTextBoxByXpath(Xpath.discountlimit.discountpercentagetextbox, JsonParser.testData("DiscountLimitSetup.discountpercentage"));
			log.info("User successfully added the discount percentage given");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.discountlimit.discountaddicon);
			log.info("User clicked on Discount Add icon ");

			Library.Interaction.IsDisplayed(Xpath.discountlimit.adminauthority);
			if (driver.findElement(By.xpath(Xpath.discountlimit.adminauthority)).getText().equals(JsonParser.testData("DiscountLimitSetup.adminpermission")))

			{

				Library.Interaction.userWait();
				Library.Interaction.setTextBoxByXpath(Xpath.discountlimit.user, JsonParser.testData("DiscountLimitSetup.user"));
				log.info("User entered user credentials");
				Library.Interaction.userWait();
				Library.Interaction.setTextBoxByXpath(Xpath.discountlimit.pwd, JsonParser.testData("DiscountLimitSetup.pwd"));
				log.info("User entered Password credentials");
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.discountlimit.authorise);
				log.info("User successfully gave authority for granting discount");
				Thread.sleep(1000);
				Library.Interaction.switchtochildwin1();
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.discountlimit.deleteicon);
				log.info("User deleted the added discount limit setup");
				Thread.sleep(2000);
				Library.Interaction.click(Xpath.discountlimit.deletepopup);
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.discountlimit.homeicon);
				log.info("User is in Home page");

			} else {
				captureScreen(driver, "verifypaymentpage(");
				Assert.assertFalse(false);
				log.info("Test Failed");

			}

		} catch (InterruptedException e) {
			
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
			
		}
	}
}
