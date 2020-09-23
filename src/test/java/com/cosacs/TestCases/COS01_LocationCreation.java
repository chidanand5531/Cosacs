package com.cosacs.TestCases;
/**
* Project Name : COSAC

* Author : Chidanand

* Version : 10.5.2.2124

* Reviewed By : Vivek Bharti

* Date of Creation : march 16, 2020

* Modification History :

* Date of change : 

* Version : V1.1

* changed function :

* change description :

* Modified By : 

*/
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Utilities.JsonParser;
import com.cosacs.Locators.Name;
import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS01_LocationCreation extends BaseClass {

	
		//User fill the Location CreationForm
		@Test()
		public void createLocation_Test() throws IOException {
			try {
				Library.Interaction.IsDisplayed_Click(Xpath.LocationCreation.merchandising);
				log.info("User Clicked on Merchandising");
				Library.Interaction.moveToElement(Xpath.LocationCreation.create);
				log.info("User Clicked on Create");
				Library.Interaction.click(Xpath.LocationCreation.location);
				log.info("User Clicked on Location");
				Library.Interaction.IsDisplayed(Xpath.LocationCreation.verifyLocationPage);
				String createLocationLabel = driver.findElement(By.xpath(Xpath.LocationCreation.verifyLocationPage)).getText();
				Assert.assertEquals(createLocationLabel,JsonParser.testData("locationData.ExpectedLabel"));
				log.info("User verified Create Location PageLabel Successfully");
	            log.info("User is in Create Location Page");
	            Library.Interaction.IsDisplayed(Xpath.LocationCreation.locationID);
				Library.Interaction.setTextBoxByXpath(Xpath.LocationCreation.locationID,JsonParser.testData("locationData.LocationId"));
				log.info("User entered Location ID successfully ");
				Library.Interaction.setTextBoxByName(Name.LocationCreation.salesSystemID, JsonParser.testData("locationData.SalesSystemId"));
				log.info("User is able to enter text to 'Sales System ID'");
				Library.Interaction.setTextBoxByName(Name.LocationCreation.Name,JsonParser.testData("locationData.Name"));
				Library.Interaction.selectAndSerachEle(Xpath.LocationCreation.fascia,Xpath.LocationCreation.fasciaSerch,Xpath.LocationCreation.fasciaName,"Cou");
				log.info("User selected 'Facia' ");
				Library.Interaction.selectAndSerachEle(Xpath.LocationCreation.StoreType,Xpath.LocationCreation.StoreTypeSearch,Xpath.LocationCreation.StoteName,"All Cou");
				log.info("User is able to select 'Store Type'");
				Library.Interaction.click(Xpath.LocationCreation.Warehouse_checkbox);
				log.info("User selected 'Store Type' successfully");
				Library.Interaction.click(Xpath.LocationCreation.Virtual_checkbox);
				log.info("User Clicked on 'Virtual checkBox' successfully");
				Library.Interaction.click(Xpath.LocationCreation.Active_checkbox);
				log.info("User Clicked on 'Active checkBox' successfully");
				Library.Interaction.setTextBoxByXpath(Xpath.LocationCreation.addressLine1, JsonParser.testData("locationData.AddressLine1"));
				log.info("User Entered the Address in addressLine1 successfully");
				Library.Interaction.setTextBoxByXpath(Xpath.LocationCreation.addressLine2, JsonParser.testData("locationData.AddressLine2"));
				log.info("User Entered the Address in addressLine2 successfully");
				Library.Interaction.setTextBoxByXpath(Xpath.LocationCreation.City, JsonParser.testData("locationData.City"));
				log.info("User Entered the City successfully");
				Library.Interaction.setTextBoxByXpath(Xpath.LocationCreation.PostCode, JsonParser.testData("locationData.PostalCode"));
				log.info("User Entered the Postal code successfully");
				Library.Interaction.ScrollDownTill_ElementFound(Xpath.LocationCreation.SaveBTN);
				Library.Interaction.selectSuggestions(Xpath.LocationCreation.Contact_arrowMark, Xpath.LocationCreation.Contact_Search, Xpath.LocationCreation.SelectSuggestion,  JsonParser.testData("locationData.ContactSearch"),  JsonParser.testData("locationData.ContactSelect"));
				log.info("User Selected the Contact Type successfully");
				Library.Interaction.setTextBoxByXpath(Xpath.LocationCreation.Contact_Value,JsonParser.testData("locationData.ContactDeatils"));
				log.info("User Entered the Contact Type successfully");
				Library.Interaction.click(Xpath.LocationCreation.AddBTN);
				log.info("User has clicked on addBTN successfully");
				Library.Interaction.click(Xpath.LocationCreation.SaveBTN);
				log.info("User has clicked on SaveBTN successfully");
				Library.Interaction.IsDisplayed(Xpath.LocationCreation.verifyLocationPage);
				String SuccessMessage=Library.Interaction.verifyToastMessage(Xpath.LocationCreation.Message_catch);
				log.info("Toast Message is --->" + SuccessMessage);
				log.info("Location Creation Message-->"+ SuccessMessage);
				Assert.assertEquals(SuccessMessage, JsonParser.testData("locationData.UserInfoMessage"));
				Library.Interaction.scrollUp(Xpath.LocationCreation.verifyLocationPage);
				Library.Interaction.click(Xpath.LocationCreation.MessageClick);
				String LocationValue = driver.findElement(By.xpath(Xpath.LocationCreation.LocatinValueID)).getText().replaceAll("[^0-9]", "");
				log.info("LocationValue--->"+LocationValue);
				Assert.assertEquals(LocationValue, JsonParser.testData("locationData.LocationId"));
				log.info("User validated Locationvalue successfully-->"+LocationValue);
				log.info("User is able to Create Location successfully");
			} catch (Exception e) {
				e.printStackTrace();
				Assert.assertFalse(false);
				log.info("Test Failed");
			}
	    }
		
		//User Validates the Location Search with mandatory fields
		@Test(dependsOnMethods={"createLocation_Test"})
		public void searchLocation_Test() throws IOException {
			try {
				Library.Interaction.IsDisplayed_Click(Xpath.LocationCreation.merchandising);
				log.info("User Clicked on Merchandising");
				Library.Interaction.moveToElement(Xpath.LocationSearch.SearchMenu);;
				log.info("User Clicked on SearchMenu");
				Library.Interaction.click(Xpath.LocationSearch.Locations);
				log.info("User Clicked on Locations");
				String Location_Pageheading = driver.findElement(By.xpath(Xpath.LocationSearch.Location_Pageheading)).getText().replaceAll("[^0-9]", "");
				log.info("Location_Pageheading-->"+Location_Pageheading);
				Assert.assertEquals(Location_Pageheading, JsonParser.testData("locationData.LocationId"));
				log.info("User is in Location Search Page");
				Library.Interaction.setTextBoxByXpath(Xpath.LocationSearch.SearchLocation, JsonParser.testData("locationData.LocationId"));
				log.info("User entered text in search field successfully");
				Library.Interaction.IsDisplayed(Xpath.LocationSearch.LocationId);
				String Location_ID = driver.findElement(By.xpath(Xpath.LocationSearch.LocationId)).getText();
				log.info("Location_ID-->"+Location_ID);
				Assert.assertEquals(Location_ID,JsonParser.testData("locationData.LocationId"));
				log.info("User Validated LocationID successfully");
				String Location_Name = driver.findElement(By.xpath(Xpath.LocationSearch.LocationName)).getText();
				log.info("User Validated LocationName successfully-->"+Location_Name);
				Assert.assertEquals(Location_Name,JsonParser.testData("locationData.Name"));
				log.info("User Validated LocationName successfully");
				String SystemId = driver.findElement(By.xpath(Xpath.LocationSearch.SystemId)).getText().trim();
				Assert.assertEquals(SystemId,JsonParser.testData("locationData.SalesSystemId"));
				log.info("User Validated Sales SystemId successfully-->"+SystemId);
				String warehouse=Library.Interaction.getelementText(Xpath.LocationSearch.Warehouse);
				Assert.assertEquals(warehouse,JsonParser.testData("locationData.Warehouse"));
				log.info("User Validated warehouse Status successfully-->"+warehouse);
				String Active=Library.Interaction.getelementText(Xpath.LocationSearch.Active);
				Assert.assertEquals(Active,JsonParser.testData("locationData.Active"));
				log.info("User Validated Active Status successfully-->"+Active);
				String Virtual=Library.Interaction.getelementText(Xpath.LocationSearch.Virtual);
				Assert.assertEquals(Virtual,JsonParser.testData("locationData.Virtual"));
				log.info("User  Validated Virtual Status successfully-->"+Virtual);
				log.info("User successfully Validated Location Search ");
				
			} catch (Exception e) {
				e.printStackTrace();
				Assert.assertFalse(false);
				log.info("Test Failed");
			}
		}
}








