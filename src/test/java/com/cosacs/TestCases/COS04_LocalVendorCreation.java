/**

* Project Name : COSACS

* Author : Chidanand

* Version : 10.5.2.2124

* Reviewed By : Vivek Bharti

* Date of Creation : march 12, 2020

* Modification History :

* Date of change : 

* Version : V1.1

* changed function :

* change description :

* Modified By : 

*/
package com.cosacs.TestCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

public class COS04_LocalVendorCreation extends BaseClass{
	
	@Test
	public void createVendor_Test() throws IOException {
		try {
			
			boolean flag = driver.findElement(By.xpath(Xpath.LoginPage.Logo)).isDisplayed();
			Assert.assertTrue(flag);
			log.info("User verified Logo successfully");
			String title = driver.getTitle();
			Assert.assertEquals(title,JsonParser.testData("vendordata.Title"));
			log.info("User verified HomePage Title successfully");
			Library.Interaction.IsDisplayed_Click(Xpath.Vendor_Creation.merchandising);
			log.info("User Clicked on Merchandising");
			Library.Interaction.IsDisplayed(Xpath.Vendor_Creation.create);
			Library.Interaction.moveToElement(Xpath.Vendor_Creation.create);
			log.info("User Clicked on Create");
			Library.Interaction.click(Xpath.Vendor_Creation.vendor);
			log.info("User Clicked on Vendor");
			Library.Interaction.IsDisplayed(Xpath.Vendor_Creation.Verify_VendorPage);
			String create_VendorLabel = driver.findElement(By.xpath(Xpath.Vendor_Creation.Verify_VendorPage)).getText();
			Assert.assertEquals(create_VendorLabel, JsonParser.testData("vendordata.Expectedcreate_VendorLabel"));
			log.info("User verified Create Location PageLabel Successfully");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.vendorCode, JsonParser.testData("vendordata.vendorcode"));
			log.info("User enetered the vendorcode ");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.vendorName, JsonParser.testData("vendordata.vendorName"));
			log.info("User enetered the vendorName");
			Library.Interaction.selectEleByText(Xpath.Vendor_Creation.SelectVendor,JsonParser.testData("vendordata.eleText"));
			log.info("User selected Local vendor");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.AddressLine1, JsonParser.testData("vendordata.AddressLine1"));
			log.info("User enetered the  addressline1");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.City, JsonParser.testData("vendordata.City"));
			log.info("User enetered the  City");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.State, JsonParser.testData("vendordata.State"));
			log.info("User enetered the State");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.postcode, JsonParser.testData("vendordata.Postcode"));
			log.info("User enetered the Pincode");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.countryCode,JsonParser.testData("vendordata.IsoCode"));
			log.info("User enetered the IsoCode");
			Library.Interaction.selectEleByText(Xpath.Vendor_Creation.Currency, JsonParser.testData("vendordata.Currency"));
			log.info("User selected the Currency");
			Library.Interaction.selectEleByText(Xpath.Vendor_Creation.Status, JsonParser.testData("vendordata.Status"));
			log.info("User  selected the  Status successfully");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.PaymentTerms,JsonParser.testData("vendordata.PaymentTerms"));
			log.info("User entered the  Payment Terms successfully");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.orderEmail, JsonParser.testData("vendordata.Contact_Email"));
			log.info("User entered the order Email successfully");
			Library.Interaction.selectSuggestions(Xpath.Vendor_Creation.Contact_ArrowMark,
					Xpath.Vendor_Creation.Enter_ContactType, Xpath.Vendor_Creation.Select_Contact,
					JsonParser.testData("vendordata.Contact"),JsonParser.testData("vendordata.ContactEmail"));
			log.info("User  selected the  Contact Email successfully");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Creation.Email_Contact, JsonParser.testData("vendordata.Contact_Email"));
			log.info("User Entered the Email in contact field successfully");
			Library.Interaction.click(Xpath.Vendor_Creation.PlusMark);
			Library.Interaction.selectSuggestions(Xpath.Vendor_Creation.Contact_ArrowMark2,
					Xpath.Vendor_Creation.Enter_ContactType, Xpath.Vendor_Creation.Select_Contact,
					JsonParser.testData("vendordata.Contact"),JsonParser.testData("vendordata.ContactEmail"));
			Library.Interaction.click(Xpath.Vendor_Creation.Delete_Contact);
			log.info("User Filled the Local vendor creation form successfully ");
			Library.Interaction.ScrollDownTill_ElementFound(Xpath.Vendor_Creation.SaveBTN);
			Library.Interaction.click(Xpath.Vendor_Creation.SaveBTN);
			log.info("User Clicked on Save successfully");
			Library.Interaction.IsDisplayed(Xpath.Vendor_Creation.Message_catch);
			String SuccessMessage = Library.Interaction.verifyToastMessage(Xpath.Vendor_Creation.Message_catch);
			Assert.assertEquals(SuccessMessage, JsonParser.testData("vendordata.VendorMessage"));
			log.info("Caught the Success Message successfully--->"+ SuccessMessage);
			Library.Interaction.IsDisplayed(Xpath.Vendor_Creation.MessageClick);
			Library.Interaction.click(Xpath.Vendor_Creation.MessageClick);
			Library.Interaction.ScrollUpTill_ElementFound(Xpath.Vendor_Creation.AddBTN);
			Library.Interaction.selectSuggestions(Xpath.Vendor_Creation.AddTag_Text, Xpath.Vendor_Creation.AddTag_Text, Xpath.Vendor_Creation.selectTag, JsonParser.testData("vendordata.Tag_Search"), JsonParser.testData("vendordata.TagText"));
			log.info("User selected suggestions tag successfully");
			Library.Interaction.click(Xpath.Vendor_Creation.AddBTN);
			log.info("User  Clicked on addBTN successfully");
			Library.Interaction.IsDisplayed(Xpath.Vendor_Creation.Message_catch);
			String TagMessage = Library.Interaction.verifyToastMessage(Xpath.Vendor_Creation.Message_catch);
			log.info("Toast TagMessage is --->" + TagMessage);
			Assert.assertEquals(TagMessage, JsonParser.testData("vendordata.AddTagMessage"));
			Library.Interaction.IsDisplayed_Click(Xpath.Vendor_Creation.MessageClick);
			String vendor = Library.Interaction.getelementText(Xpath.Vendor_Creation.Verify_VendorPage);
			String text = "";
			String[] str1 = vendor.split(" ");
			for (int i = 0; i < str1.length; i++) {
				if (str1[i].equals("-")) {
					text = str1[i + 1]+" "+str1[i + 2]+" "+str1[i + 3];
					break;
				}
			}
			log.info("Assrtion text-->"+text);
			Assert.assertEquals(text, JsonParser.testData("vendordata.vendorName"));
			log.info("User successfully validated vendorName");

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Test Failed");
		}
	}
	
	@Test(dependsOnMethods ="createVendor_Test")
	public void SearchVendor_Test() throws Exception{
		try {
			Library.Interaction.click(Xpath.Vendor_Creation.merchandising);
			Library.Interaction.print("User has Clicked on merchandising successfully");
			Library.Interaction.moveToElement(Xpath.Vendor_Search.SearchMenu);
			Library.Interaction.print("User able to Mouse hover on SearchMenu successfully");
			Library.Interaction.click(Xpath.Vendor_Search.VendorSearch);
			Library.Interaction.print("User Clicked on VendorSearch successfully");
			Library.Interaction.IsDisplayed(Xpath.Vendor_Search.VendorSearchField);
			String VendorCoricom = Library.Interaction.getelementText(Xpath.Vendor_Search.VendorSearch_Pageheading);
			Assert.assertEquals(VendorCoricom, JsonParser.testData("vendordata.Vendorsearch_label"));
			log.info("User is in Vendor searchPage ");
			Library.Interaction.setTextBoxByXpath(Xpath.Vendor_Search.VendorSearchField, JsonParser.testData("vendordata.vendorName"));
			Library.Interaction.IsDisplayed(Xpath.Vendor_Search.VendorCode);
			String VendorCodesearch = driver.findElement(By.xpath(Xpath.Vendor_Search.VendorCode)).getText();
			log.info("VendorCode-->" + VendorCodesearch);
			Assert.assertEquals(VendorCodesearch, JsonParser.testData("vendordata.vendorcode"));
			String VendorNamesearch = driver.findElement(By.xpath(Xpath.Vendor_Search.VendorName)).getText();
			log.info("VendorName-->" + VendorNamesearch);
			Assert.assertEquals(VendorNamesearch, JsonParser.testData("vendordata.vendorName"));
			String Vendortype = Library.Interaction.getelementText(Xpath.Vendor_Search.VendorType);
			Assert.assertEquals(Vendortype, JsonParser.testData("vendordata.eleText"));
			log.info("Vendortype-->" + Vendortype);
			String VendorStatus = Library.Interaction.getelementText(Xpath.Vendor_Search.VendorStatus);
			Assert.assertEquals(VendorStatus, JsonParser.testData("vendordata.Status"));
			log.info("VendorStatus-->" + VendorStatus);
			String VendorTag = Library.Interaction.getelementText(Xpath.Vendor_Search.VendorTag);
			Assert.assertEquals(VendorTag, JsonParser.testData("vendordata.TagText"));
			log.info("VendorTag-->" + VendorTag);
			log.info("User successfully Validated Local_Vendor Search");
		
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Test Failed");
		}
	}
}
