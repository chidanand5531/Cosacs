package com.cosacs.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS65_Service_Suppliers extends BaseClass{

		public String ExpectedTitle="Service Suppliers";
		public static JavascriptExecutor js;
		public String companyname="IFB";
		Robot rb;
		
		@Test
		public void Suppliers()throws Exception
		{
			try
			{
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.Services);
				log.info("User Clicked On Services");
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.Suppliers);
				log.info("User Clicked On Suppliers");
				Library.Interaction.userWait();
				String ActualTitle = Library.Interaction.verifyPageTitle();
				Assert.assertEquals(ActualTitle, ExpectedTitle);
				log.info("Page Title is Verified Successfully");
				rb=new Robot();
				rb.keyPress(KeyEvent.VK_END);
				Thread.sleep(5000);
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.Add);
				log.info("User Clicked On Add Icon");
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.SupplierTextbox);
				Thread.sleep(3000);
				Library.Interaction.setTextBoxByXpath(Xpath.Suppliers.SupplierTextbox,companyname);
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.SupplierSave);
				log.info("Supplier Saved Successfully");
				Library.Interaction.userWait();
				String SuccessMsg= Library.Interaction.verifyToastMessage(Xpath.Suppliers.SupplierSuccessMsg).trim();
				log.info(SuccessMsg);
				rb.keyPress(KeyEvent.VK_HOME);
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.SupplierSearchtbox);
				Library.Interaction.setTextBoxByXpath(Xpath.Suppliers.SupplierSearchtbox,companyname);
				Library.Interaction.click(Xpath.Suppliers.Search);
				log.info("Supplier Searched Successfully");
				Thread.sleep(2000);
				
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.Edit);
				log.info("User Clicked on Edit Icon");
				
				Thread.sleep(1000);
				
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.SupplierTextbox);
				Library.Interaction.setTextBoxByXpath(Xpath.Suppliers.SupplierTextbox, "Co");
				Library.Interaction.click(Xpath.Suppliers.SupplierSave);
				log.info("Supplier Edited Successfully");
				String EditSuccessMsg = Library.Interaction.verifyToastMessage(Xpath.Suppliers.SupplierSuccessMsg).trim();
				log.info(EditSuccessMsg);
				
				Thread.sleep(3000);
				
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.Delete);
				log.info("User Clicked On Delete Icon");
				
				Thread.sleep(2000);
				
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.Suppliers.DeleteBtn);
				String DeleteMsg = Library.Interaction.verifyToastMessage(Xpath.Suppliers.SupplierSuccessMsg).trim();
				log.info(DeleteMsg);
				driver.close();
				
				
			}
			catch (Exception e) {
				captureScreen(driver, "location");
				AssertJUnit.assertFalse(false);
				log.info("Test Failed");
				throw(e);
			}
		}

	}