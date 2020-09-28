package com.cosacs.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS79_ServiceIncomeAnalysis extends BaseClass {

	String ExpectedServiceIncomeAnalysis="Technical Service Income and Margin Analysis Report";
	String FromDate="";
    String ToDate="";
	
	@Test
	public void ServiceIncome() throws IOException
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.ServiceIncomeAnalysis.Service);
			Library.Interaction.userWait();
			Library.Interaction.print("User clicked on Service Link");
	        Library.Interaction.moveToElement(Xpath.ServiceIncomeAnalysis.Reportslink);
			Library.Interaction.userWait();
			Library.Interaction.print("Cursor moved to Reports Link");
			Library.Interaction.moveToElement(Xpath.ServiceIncomeAnalysis.ServiceIncomeAnalysis);
			Library.Interaction.userWait();
			Library.Interaction.print("Cursor moved to ServiceIncomeAnalysis Link");
			Library.Interaction.click(Xpath.ServiceIncomeAnalysis.ServiceIncomeAnalysis);
			Library.Interaction.userWait();
			Library.Interaction.print("User clicked on ServiceIncomeAnalysis Link");
			Library.Interaction.userWait();
			Library.Interaction.MaxWait();
            String ServiceIncomeAnalysis = driver.findElement(By.xpath(Xpath.ServiceIncomeAnalysis.VerifyServiceIncomeAnalysis)).getText();
			Assert.assertEquals(ServiceIncomeAnalysis,ExpectedServiceIncomeAnalysis);
			log.info("User are in Technical Service Income and Margin Analysis Report Page");

		}catch(Exception e)
		
		{
			e.printStackTrace();
			captureScreen(driver, "ServiceIncome");
			Assert.assertFalse(false);
			log.info("Test Failed");
			
		}
	}



	@Test(dependsOnMethods = {"ServiceIncome"})
	public void SerrviceIncomeAnalysis() throws InterruptedException, IOException {
		try {

            Library.Interaction.userWait();
            Library.Interaction.userWait();
			Library.Interaction.click(Xpath.ServiceIncomeAnalysis.Run);
			Library.Interaction.userWait();
			Library.Interaction.print("User clicked on Run Button");
		    Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.ServiceIncomeAnalysis.Export);
			Library.Interaction.userWait();
			Library.Interaction.print("User clicked on Export Button");
			Library.Interaction.userWait();
			Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.ServiceIncomeAnalysis.Clear);
			Library.Interaction.print("User clicked on Clear Button");
			Library.Interaction.userWait();
			Library.Interaction.MaxWait();
			
		}catch(Exception e)
		{
			captureScreen(driver, "SerrviceIncomeAnalysis");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

}


