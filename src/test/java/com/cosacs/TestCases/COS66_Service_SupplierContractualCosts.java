package com.cosacs.TestCases;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS66_Service_SupplierContractualCosts extends BaseClass{
	public static Robot rb;
	public String ExpectedPageTitle="Supplier Contractual Costs";
	public String Supplier="Acer";
	public String RowsNumber="1";
	public String ProductName="Indecator";
	public String PartType="SparePart";
	public String PartPercentage="20";
	public String PartValue="100";
	public String LabourPercentage="10";
	public String LabourValue="110";
	public String AddtionalPercentage="10";
	public String AddtionalValue="120";
	public String Rownumber="1";
	@Test
	public void SupplierContractualCosts()throws Throwable
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.Services);
			log.info("User Clicked On Services");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.SupplierContractualCost);
			log.info("User Clicked On Supplier COntractual Cost");
			
			Thread.sleep(10000);
			
			Library.Interaction.userWait();
			String ActualPageTitle = Library.Interaction.verifyPageTitle();
			Assert.assertEquals(ActualPageTitle, ExpectedPageTitle);
			log.info("Page Title is Verified Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.SupplierContractualCost.Supplier, Xpath.SupplierContractualCost.SupplierSearch, Xpath.SupplierContractualCost.SupplierList, Supplier, Supplier);
			log.info("Supplier Selected Successfully");

							
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.RowNumbers);
			driver.findElement(By.xpath(Xpath.SupplierContractualCost.RowNumbers)).clear();
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.RowNumbers, Rownumber);
			Thread.sleep(2000);
			Library.Interaction.click(Xpath.SupplierContractualCost.Addrow);
			log.info("Rows Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.Product);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.Product, ProductName);
			log.info("Product Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.PartType);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.PartType,PartType);
			log.info("Part Type Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.PartPercent);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.PartPercent,PartPercentage);
			log.info("Part Percentage Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.PartValue);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.PartValue,PartValue);
			log.info("Part Percentage Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.LabourPercent);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.LabourPercent,LabourPercentage);
			log.info("Labour Percentage Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.LabourValue);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.LabourValue,LabourValue);
			log.info("Labour Value Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.AddPercent);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.AddPercent,AddtionalPercentage);
			log.info("Addtional Percentage Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.AddtionalValue);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.AddtionalValue,AddtionalValue);
			log.info("Addtional Value Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.Save);
			
			log.info("Saved Successfully");
			
			Library.Interaction.userWait();
			String SuccessMsg = Library.Interaction.verifyToastMessage(Xpath.SupplierContractualCost.SupplierSuccessMsg);
			log.info(SuccessMsg);
			
		}
		catch (Exception e) {
			captureScreen(driver, "location");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
		
	}

}
