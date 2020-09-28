
package com.cosacs.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS103_Merchandising_Warehouse_OverSupply extends BaseClass {
	   String Warehouse_Send="TWICKENHAM";
	    String Warehouse_Name="TWICKENHAM CLOSE";
	    String Division_Send="AUDIO VI";
	    String Division_Name="AUDIO VISUAL";
	    String Department_Send="VISI";
	    String Department_Name="VISION";
	    String Class_Send="TV 25IN";
	    String Class_Name ="TV 25INCH LT";
	    
	    
	@Test
	public void Reports_WarehouseOversupply() throws IOException {
	    try {
	        Library.Interaction.userWait();
	        Library.Interaction.click(Xpath.Reports_WarehouseOversupply.merchandising);
	        Library.Interaction.print("User Clicked on Merchandising");
	        Library.Interaction.userWait();
	        Library.Interaction.moveToElement(Xpath.Reports_WarehouseOversupply.Reports);
	        Library.Interaction.print("User Clicked on Reports");
	        Library.Interaction.userWait();
	        Library.Interaction.click(Xpath.Reports_WarehouseOversupply.WarehouseOversupply);
	        Library.Interaction.print("User Clicked on Warehouseoversupply reports");
	        Library.Interaction.userWait();
	}
	catch (Exception e) {
	    e.printStackTrace();
	    captureScreen(driver, "location");
	    Assert.assertFalse(false);
	    log.info("Test Failed");
	}
	}

	 

	@Test(dependsOnMethods={"Reports_WarehouseOversupply"})
	public void Reports_WarehouseOversupply1() throws IOException {
	    try {
	    	Library.Interaction.userWait();
	        Library.Interaction.print("User Enters the Warehouse");
	        Library.Interaction.selectSuggestion(Xpath.Reports_WarehouseOversupply.WarehouseDropDown, Xpath.Reports_WarehouseOversupply.WarehouseSearch, Xpath.Reports_WarehouseOversupply.WarehouseList, Warehouse_Send, Warehouse_Name);
	        Library.Interaction.print("User Enters the Heirarchy");
	        Library.Interaction.selectSuggestion(Xpath.Reports_WarehouseOversupply.DivisionDropDown, Xpath.Reports_WarehouseOversupply.DivisionSearch, Xpath.Reports_WarehouseOversupply.DivisionList, Division_Send, Division_Name);
	        Library.Interaction.selectSuggestion(Xpath.Reports_WarehouseOversupply.DepartmentDropDown, Xpath.Reports_WarehouseOversupply.DepartmentSearch, Xpath.Reports_WarehouseOversupply.DepartmentList, Department_Send, Department_Name);
	        Library.Interaction.selectSuggestion(Xpath.Reports_WarehouseOversupply.ClassDropDown, Xpath.Reports_WarehouseOversupply.ClassSearch, Xpath.Reports_WarehouseOversupply.ClassList, Class_Send, Class_Name);
	        Library.Interaction.click(Xpath.Reports_WarehouseOversupply.Search);
	        Library.Interaction.print("User Clicked on Search");
	        Library.Interaction.IsDisplayed(Xpath.Reports_WarehouseOversupply.hideShowButton);
	        Library.Interaction.click(Xpath.Reports_WarehouseOversupply.Print);
	        Library.Interaction.print("User Clicked on Print");
	        Thread.sleep(10000);
	        System.out.print("Warehouse Oversupply");
	        String windows = driver.getWindowHandle();
	        driver.switchTo().window(windows);
	        System.out.println("success");
	        Library.Interaction.click(Xpath.Reports_WarehouseOversupply.Export);
	        Library.Interaction.print("User Clicked on Export and Export the File");
	        Thread.sleep(10000);
	        Library.Interaction.click(Xpath.Combo_ProductCreation.Home);
   
	    }
	    catch (Exception e) {
	        captureScreen(driver, "createLocationForm");
	        Assert.assertFalse(false);
	        log.info("Test Failed");
	        }
	}
	}