

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

public class COS16_StockRequisitionProcess extends BaseClass {
	
	String ExpecStckRequisitionTitle = "Create Stock Requisition";
	String SearchText = "KE";
	String RecLocValue = "KENGERITOWN";
	String WarehouseText = "TW";
	String WarehouseVal = "TWICKENHAM CLOSE";
	String ProductSrchText = "SST773";
	String ProductText = "SST773";
	String ProductQuantity = "5";
	String ProductComments = "Testing";

	
	// The below method helps the user to land the Create Stock Requisition Page
	
	@Test
	public void StockRequisition() throws Throwable {
	
		try {
			Library.Interaction.userWait();
			
			Library.Interaction.click(Xpath.LocationCreation.merchandising);
			log.info("User Clicked on Merchandising");
			Library.Interaction.userWait();
			Library.Interaction.moveToElement(Xpath.LocationCreation.create);
			log.info("User Clicked on Create");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockRequisitionProcess.stockRequisition);
			Library.Interaction.userWait();
			log.info("User Clicked on StockRequisition");
			String StockRequisitionCreationTitle = driver.findElement(By.xpath(Xpath.StockRequisitionProcess.verifyStockRequisition)).getText();
			Assert.assertEquals(StockRequisitionCreationTitle, ExpecStckRequisitionTitle);
			log.info("User is in Stock Requisition Creation Page");

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen(driver, "StockRequisition");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}


	// The below method helps the user to create stock Requisition
	@Test(dependsOnMethods = "StockRequisition")
	
	public void createStockRequisition() throws IOException {
		try {

			Library.Interaction.selectSuggestion(Xpath.StockRequisitionProcess.RecLocDrpDown, Xpath.StockRequisitionProcess.RecLocSrch,Xpath.StockRequisitionProcess.RecLocName, SearchText, RecLocValue);
			log.info("User clicked LUCKY DOLLAR MAY PEN");
			Library.Interaction.selectSuggestion(Xpath.StockRequisitionProcess.WarehouseDro, Xpath.StockRequisitionProcess.WarehouseSearch,Xpath.StockRequisitionProcess.WarehouseName, WarehouseText, WarehouseVal);
			Library.Interaction.selectEle(Xpath.StockRequisitionProcess.ProductDrp, Xpath.StockRequisitionProcess.ProductSrch, Xpath.StockRequisitionProcess.Productname, ProductSrchText, ProductText);
			log.info("User clicked  SST773:456510168-RED HYACINTH 95CM 456510168");
			Library.Interaction.setTextBoxByXpath(Xpath.StockRequisitionProcess.ProductQty, ProductQuantity);
			Library.Interaction.setTextBoxByXpath(Xpath.StockRequisitionProcess.ProductCmnts, ProductComments);
			Library.Interaction.click(Xpath.StockRequisitionProcess.AddButton);
			WebElement SKU = driver.findElement(By.xpath(Xpath.StockRequisitionProcess.SKUnumb));
			String SKUnumb = SKU.getText();
			log.info("SKU number is "+SKUnumb);
			WebElement Description = driver.findElement(By.xpath(Xpath.StockRequisitionProcess.DescSRP));
			String Desc = Description.getText();
			log.info("Description of Product is " +Desc);
			WebElement Comments = driver.findElement(By.xpath(Xpath.StockRequisitionProcess.CommentsSRP));
			String Cmnts = Comments.getText();
			log.info("Comments is "+Cmnts);
			WebElement AvgWeighCost = driver.findElement(By.xpath(Xpath.StockRequisitionProcess.AvgWeighCostSRP));
			String str1 = AvgWeighCost.getText().replaceAll("[^0-9]","");
			int number1 = Integer.parseInt(str1);
			int LineCostProd = Integer.parseInt(ProductQuantity)*number1;
			log.info("The line cost is "+LineCostProd);
			WebElement LineCost = driver.findElement(By.xpath(Xpath.StockRequisitionProcess.LineCostSRP));
			String Str2 = LineCost.getText().replaceAll("[^0-9]","");
			int number2 = Integer.parseInt(Str2);
			Assert.assertEquals(LineCostProd, number2);
			log.info("Line cost is displayed as per Quantity");
			Library.Interaction.click(Xpath.StockRequisitionProcess.SaveBtn);
			Library.Interaction.IsDisplayed(Xpath.StockRequisitionProcess.SuccMsgSRP);
			WebElement SuccMsg = driver.findElement(By.xpath(Xpath.StockRequisitionProcess.SuccMsgSRP));
			String Success = SuccMsg.getText();
			log.info("Success Message is "+Success);
			Library.Interaction.userWait();
			log.info("User Created Stock Requisition Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			captureScreen(driver, "CreateStockAllocation");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}	
			
	// The below method helps the user to search the created stock Requisition		
@Test(dependsOnMethods = "createStockRequisition")
			
	public void SearchStockRequisition() throws IOException {
			try {
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.LocationCreation.merchandising);
			log.info("User Clicked on Merchandising");
			Library.Interaction.userWait();
			Library.Interaction.moveToElement(Xpath.StockAllocation.Search);
			log.info("User Clicked on Search");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockRequisitionProcess.SrchStockRequisitions);
			log.info("User Clicked on StockRequisitions");
			Thread.sleep(5000);
			Library.Interaction.IsDisplayed(Xpath.StockRequisitionProcess.StockReqSrchbtn);
			int day, month, year;
			GregorianCalendar date = new GregorianCalendar();
			day = date.get(Calendar.DAY_OF_MONTH);
			month = date.get(Calendar.MONTH) + 1;
			year = date.get(Calendar.YEAR);
			String today =day+"-"+month+"-"+year;
			log.info(today);
			Library.Interaction.setTextBoxByXpath(Xpath.StockRequisitionProcess.StockReqCreatedForm, today);
			Library.Interaction.selectSuggestion(Xpath.StockRequisitionProcess.RecvingArrow, Xpath.StockRequisitionProcess.RecLocSrch,Xpath.StockRequisitionProcess.RecLocName, SearchText, RecLocValue);
			Library.Interaction.click(Xpath.StockRequisitionProcess.StockReqSrchbtn);
			Library.Interaction.userWait();
			WebElement ShipmentID = driver.findElement(By.xpath(Xpath.StockRequisitionProcess.ShipmentIdSRP));
			String ShipmentNumb = ShipmentID.getText();
			log.info("Shipment ID is "+ShipmentNumb);
			log.info("Create and Search Stock Requisitions is Successfull");
			

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen(driver, "SearchStockRequisition");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}
}
