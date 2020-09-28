
/*Project Name : IGT Framework
  Author : Vincy Virgenia James*/


package com.cosacs.TestCases;


	import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.cosacs.Locators.Xpath;
	import com.cosacs.PageObject.BaseClass;
	import com.cosacs.PageObject.Library;


	public class COS15_StockAllocation extends BaseClass {

		String ExpecStckAllocTitle = "Create Stock Allocation";
		String WarehouseValue = "KENGERITOWN";
		String Search_Text = "KE";
		String ReceivingVal = "KENGERITOWN";
		String WarehouseComments = "STOCK ALLOCATION Test ";
		String ProductCode = "OPU250";
		String ProductValue = "OPU250";
		String Quantity = "2";

		
		
		// The below method helps the user to land the Create Stock Allocation Page

		@Test
		public void StockAllocation() throws Throwable {
		
			try {
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.LocationCreation.merchandising);
				Library.Interaction.print("User Clicked on Merchandising");
				Library.Interaction.userWait();
				Library.Interaction.moveToElement(Xpath.LocationCreation.create);
				Library.Interaction.print("User Clicked on Create");
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.StockAllocation.stockAllocation);
				Library.Interaction.print("User Clicked on StockAllocation");
				Library.Interaction.IsDisplayed(Xpath.StockAllocation.verifyStockAllocPage);
				String StockAllocCreationTitle = driver.findElement(By.xpath(Xpath.StockAllocation.verifyStockAllocPage)).getText();
				Assert.assertEquals(StockAllocCreationTitle, ExpecStckAllocTitle);
				log.info("User is in Stock Allocation Creation Page");

			} catch (Exception e) {
				e.printStackTrace();
				captureScreen(driver, "StockAllocation");
				Assert.assertFalse(false);
				log.info("Test Failed");
			}
		}
	
		// The below method helps the user to create stock Allocation
		@Test(dependsOnMethods = "StockAllocation")
		
		public void createStockAllocation() throws IOException {
			try {

				Library.Interaction.selectSuggestions(Xpath.StockAllocation.WarehouseDrpDwn, Xpath.StockAllocation.WarehouseSrch, Xpath.StockAllocation.WarehousenName, Search_Text, WarehouseValue);
				Library.Interaction.setTextBoxByXpath(Xpath.StockAllocation.WarehouseCmnts, WarehouseComments);
				Library.Interaction.click(Xpath.StockAllocation.AddBtn);
				Library.Interaction.selectSuggestion(Xpath.StockAllocation.ReceivingLocDrpDwn, Xpath.StockAllocation.ReceivingLocSrch, Xpath.StockAllocation.ReceivingLocName, Search_Text, ReceivingVal);
				Library.Interaction.selectEle(Xpath.StockAllocation.ProductcodeDrpDwn, Xpath.StockAllocation.ProductCodeSrch, Xpath.StockAllocation.ProductCodeName, ProductCode, ProductValue);
				log.info("User Selected "+ProductValue);
				Library.Interaction.userWait();
				WebElement ProdDesc = driver.findElement(By.xpath(Xpath.StockAllocation.ProductDesc));
				String ProductDescription = ProdDesc.getText();
				log.info("Product Name "+ProductDescription+" is displayed in the description");
				WebElement QtyAvl = driver.findElement(By.xpath(Xpath.StockAllocation.QuantityAvl));
				String QuantityAvl = QtyAvl.getText();
				int Quant = Integer.parseInt(QuantityAvl);
				log.info("Quantity Available "+Quant+" is displayed");
				Library.Interaction.setTextBoxByXpath(Xpath.StockAllocation.Quantity, Quantity);
				WebElement AvgWeighCost = driver.findElement(By.xpath(Xpath.StockAllocation.AvgWeighCost));
				String str1 = AvgWeighCost.getText().replaceAll("[^0-9]","");
				int number1 = Integer.parseInt(str1);
				int LineCostProd = Integer.parseInt(Quantity)*number1;
				log.info("The line cost is "+LineCostProd);
				WebElement LineCost = driver.findElement(By.xpath(Xpath.StockAllocation.LineCost));
				String Str2 = LineCost.getText().replaceAll("[^0-9]","");
				int number2 = Integer.parseInt(Str2);
				Assert.assertEquals(LineCostProd, number2);
				log.info("Line cost is displayed as per Quantity");
				Library.Interaction.click(Xpath.StockAllocation.SaveAllocProd);
				Library.Interaction.click(Xpath.StockAllocation.SaveButton);
				Library.Interaction.IsDisplayed(Xpath.StockAllocation.SuccMessage);
				WebElement SuccMsg = driver.findElement(By.xpath(Xpath.StockAllocation.SuccMessage));
				String Success = SuccMsg.getText();
				log.info("Success Message is "+Success);
				Library.Interaction.userWait();
				log.info("User Created Stock Allocation Successfully");
				
			} catch (Exception e) {
				e.printStackTrace();
				captureScreen(driver, "CreateStockAllocation");
				Assert.assertFalse(false);
				log.info("Test Failed");
			}
		}
		
		// The below method helps the user to search the created stock allocation	
		
			@Test(dependsOnMethods = "createStockAllocation")
				
			public void SearchStockAllocation() throws IOException {
				try {
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.LocationCreation.merchandising);
				log.info("User Clicked on Merchandising");
				Library.Interaction.userWait();
				Library.Interaction.moveToElement(Xpath.StockAllocation.Search);
				log.info("User Clicked on Search");
				Library.Interaction.userWait();
				Library.Interaction.click(Xpath.StockAllocation.SrchStckAllocs);
				Library.Interaction.userWait();
				log.info("User Clicked on StockAllocations");
				Library.Interaction.selectSuggestion(Xpath.StockAllocation.RecvingArrow, Xpath.StockAllocation.ReceivingLocSrch, Xpath.StockAllocation.ReceivingLocName, Search_Text, ReceivingVal);
				int day, month, year;
				GregorianCalendar date = new GregorianCalendar();
				day = date.get(Calendar.DAY_OF_MONTH);
				month = date.get(Calendar.MONTH) + 1;
				year = date.get(Calendar.YEAR);
				String today =day+"-"+month+"-"+year;
				log.info(today);
				Library.Interaction.setTextBoxByXpath(Xpath.StockAllocation.CreatedForm, today);
				Library.Interaction.click(Xpath.StockAllocation.ProdSrchBtn);
				log.info("User clicked on Search Button"); 
				Library.Interaction.IsDisplayed(Xpath.StockAllocation.ShipmentID);
				WebElement ShipmentID = driver.findElement(By.xpath(Xpath.StockAllocation.ShipmentID));
				String ShipmentNum = ShipmentID.getText();
				log.info("Shipment ID is "+ShipmentNum);
				log.info("Stock Allocation Creation and Search is Successfull");
				

			} catch (Exception e) {
				e.printStackTrace();
				captureScreen(driver, "SearchStockAllocation");
				Assert.assertFalse(false);
				log.info("Test Failed");
			}
		}
	}

