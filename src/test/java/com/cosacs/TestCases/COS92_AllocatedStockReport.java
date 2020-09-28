package com.cosacs.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS92_AllocatedStockReport extends BaseClass {
	
	public static String Location="COURTS CROSS ROADS";
    String ExpectedAllocatedStockReport="Allocated Stock Report";
	
	
	@Test
	public void StockReport() throws IOException
	{
		
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.AllocatedStockReport.merchandising);
			Library.Interaction.userWait();
			log.info("User clicked on merchandising option");
			Library.Interaction.moveToElement(Xpath.AllocatedStockReport.Reports);
			Library.Interaction.userWait();
			log.info("Cursor moved to Reporst Option");
			Library.Interaction.moveToElement(Xpath.AllocatedStockReport.AllocatedStock);
			Library.Interaction.userWait();
			log.info("Cursor moved to AllocatedStock Option");
			Library.Interaction.click(Xpath.AllocatedStockReport.AllocatedStock);
			Library.Interaction.userWait();
			log.info("User clicked on AllocatedStock Option");
			Library.Interaction.MaxWait();
		    String AlloctedStockReport = driver.findElement(By.xpath(Xpath.AllocatedStockReport.VerifyAllocatedStockReportPage)).getText();
			Assert.assertEquals(AlloctedStockReport,ExpectedAllocatedStockReport);
	        log.info("User are in Allocated Stock Report Page");
			Library.Interaction.minWait();
			Library.Interaction.selectAndSerachEle(Xpath.AllocatedStockReport.Location,Xpath.AllocatedStockReport.LocationSearch,Xpath.AllocatedStockReport.LocationData,Location);
			Library.Interaction.userWait();
			log.info("User Selected Location Data");
	        Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.AllocatedStockReport.Search);
			log.info("User Clicked on Search Button");
			Library.Interaction.IsDisplayed(Xpath.AllocatedStockReport.hideShowButton);
			Library.Interaction.click(Xpath.AllocatedStockReport.Export);
			Library.Interaction.userWait();
			 Thread.sleep(20000);
			log.info("User clicked on Export button");
			Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.AllocatedStockReport.Print);
			Library.Interaction.userWait();
			 Thread.sleep(20000);
			log.info("User Clicked on Print Button");
            Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.AllocatedStockReport.Clear);
			Library.Interaction.userWait();
			 Thread.sleep(20000);
			log.info("User Clicked on Clear Button");

			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			captureScreen(driver, "StockReport");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

}
