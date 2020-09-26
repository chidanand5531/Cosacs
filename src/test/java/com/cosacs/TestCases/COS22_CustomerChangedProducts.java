package com.cosacs.TestCases;
//
import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS22_CustomerChangedProducts extends BaseClass {
	
	String locationId="123";
	String SalesSystemId="6789";
	String name="Agra";
	String ExpectedcreateLocaLabel="Create Location";

	@Test
	public void Customer() throws IOException {
		try {
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CustomerChangedProducts.Logistics);
			Library.Interaction.click(Xpath.CustomerChangedProducts.SearchShipments);
			//verify the dot option
			
			Library.Interaction.click(Xpath.CustomerChangedProducts.SelectPicking);
		    	
		    Library.Interaction.selectEleByText(Xpath.CustomerChangedProducts.DeliveryZone, "ABaySout");
		    Library.Interaction.scrollto_Element_Regular(Xpath.CustomerChangedProducts.Dot);
		    Thread.sleep(3000);
			Library.Interaction.click(Xpath.CustomerChangedProducts.Dot);
		    
		
		
		} 
		catch (Exception e) {
			captureScreen(driver, "Customer");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
		}
     }

	@Test(dependsOnMethods = "Customer")
	public void CustomerChanged() throws IOException {
		try {
			
			
			
		} 
		catch (Exception e) {
			captureScreen(driver, "CustomerChanged");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
		}
    }
}
