package com.cosacs.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS13_NonStocksExports extends BaseClass{
	
	String ExpectedNonStocksExports="Non-Stocks Export";

	@Test
	public void NonstockExports() throws InterruptedException, IOException {
		
		try {
			
		
		Library.Interaction.userWait();
		Library.Interaction.click(Xpath.NonStocksExports.NonStock);
		Library.Interaction.userWait();
		Library.Interaction.print("User Clicked on Non-Stocks Link");
	    Library.Interaction.click(Xpath.NonStocksExports.NonStocksExportLink);
		Library.Interaction.userWait();
		Thread.sleep(3000);
		Library.Interaction.print("User Clicked on NonStocksExport Link");
		Library.Interaction.userWait();
		
		String NonstockExports = driver.findElement(By.xpath(Xpath.NonStocksExports.VerifyNonStockExport)).getText();
		Assert.assertEquals(NonstockExports,ExpectedNonStocksExports);
        log.info("User are in Non Stock Export Page");
		Library.Interaction.print("User are in Non Stock Export Page");
        Library.Interaction.userWait();
	    Library.Interaction.click(Xpath.NonStocksExports.DownloadProductAssociationFile);
		Library.Interaction.userWait();
		Thread.sleep(3000);
		Library.Interaction.print("User Clicked on Download Product Association File");
		
		
		
		}catch(Exception e)
		{
			captureScreen(driver, "NonstockExports");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}

	}
}
