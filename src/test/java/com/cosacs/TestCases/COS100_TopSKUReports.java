/**

* Project Name : COSACS JAMAICA 

* Author : Chidanand Chigari

* Version : 10.5.2.2124

* Reviewed By : Vivek Bharti

* Date of Creation : Sept 16, 2020

* Modification History :

* Date of change :  Sept 16, 2020 

*/
package com.cosacs.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

public class COS100_TopSKUReports extends BaseClass{

	
// User should be able to generate TopSKU reports
	@Test
	public void topSkuReports_Test() throws Exception {
		try {
			Library.Interaction.IsDisplayed_Click(Xpath.TopskuReports.merchandising);
			log.info("merchandising element is displayed and Clicked on it");
			Library.Interaction.moveToElement(Xpath.TopskuReports.Reports);
			log.info("Mouse hovered on Reports");
			Library.Interaction.IsDisplayed_Click(Xpath.TopskuReports.TopSku);
			log.info("TopSku element is displayed and Clicked on it");
			String Heirarchylabel = Library.Interaction.getelementText(Xpath.TopskuReports.TopSkulabel);
			Assert.assertEquals(Heirarchylabel, JsonParser.testData("topSKUdata.pageLabel"));
			log.info("User is in Top SKU Reports Page");
			Library.Interaction.setTextBoxByXpath(Xpath.TopskuReports.fromDate, JsonParser.testData("topSKUdata.fromDate"));
			String Todays_date=Library.Interaction.Current_Date();
			log.info("Today's Date is : "+Todays_date);
			Library.Interaction.setTextBoxByXpath(Xpath.TopskuReports.ToDate, Todays_date);
			log.info("User Selected from date and to date successfully");
			Library.Interaction.selectSuggestions(Xpath.TopskuReports.Divsionarrow, Xpath.TopskuReports.DivSearchbox,
					Xpath.TopskuReports.DivSelectText, JsonParser.testData("topSKUdata.Search_SlectDiv"),JsonParser.testData("topSKUdata.Search_SlectDiv"));
			Library.Interaction.selectSuggestions(Xpath.TopskuReports.Deptarrow, Xpath.TopskuReports.DeptSearchbox,
					Xpath.TopskuReports.DeptSelectText,JsonParser.testData("topSKUdata.Search_SlectDept") ,JsonParser.testData("topSKUdata.Search_SlectDept"));
			Library.Interaction.selectSuggestions(Xpath.TopskuReports.Classarrow, Xpath.TopskuReports.ClassSearchbox,
					Xpath.TopskuReports.classSelectText,JsonParser.testData("topSKUdata.Search_SlectClass") ,JsonParser.testData("topSKUdata.Search_SlectClass"));
			Library.Interaction.selectSuggestions(Xpath.TopskuReports.Locationarrow, Xpath.TopskuReports.LocationSearchbox,
					Xpath.TopskuReports.LocationSelectText,JsonParser.testData("topSKUdata.Search_SlectLocation") ,JsonParser.testData("topSKUdata.Search_SlectLocation"));
			log.info("User Selected Division,Department,Class and Location successfully");
			Library.Interaction.Enabled_Click(Xpath.TopskuReports.SearchBTN);
			 log.info("Waiting for Results to be loaded");		  
			 Library.Interaction.IsDisplayed(Xpath.TopskuReports.Quantity);
			log.info(" result is displayed successfully");					  
			String Text=Library.Interaction.getelementText(Xpath.TopskuReports.ResultsFound);
			log.info("Results found are---->"+Text);
			String skuNo=Library.Interaction.getelementText(Xpath.TopskuReports.SkuLink);
			log.info("Sku No in results found is-->"+skuNo);
			String Quantity=Library.Interaction.getelementText(Xpath.TopskuReports.Quantity);
			log.info("No of quantities available in results are -->"+Quantity);
			String NetsaleValue=Library.Interaction.getelementText(Xpath.TopskuReports.NetsaleValue);
			log.info("NetsaleValue in results is -->"+NetsaleValue);
			Library.Interaction.Enabled_Click(Xpath.TopskuReports.printBTN);
			Library.Interaction.switchNewwindow();
			String PrintSkuLink=Library.Interaction.getelementText(Xpath.TopskuReports.PrintSkuLink);
			log.info("Sku No in printpage is-->"+PrintSkuLink);
			Assert.assertEquals(PrintSkuLink, skuNo);
			String PrintQuantity=Library.Interaction.getelementText(Xpath.TopskuReports.PrintQuantity);
			log.info("No of quantities available in printpage are -->"+PrintQuantity);
			Assert.assertEquals(Quantity, PrintQuantity);
			String PrintNetsalevalue=Library.Interaction.getelementText(Xpath.TopskuReports.PrintNetsalevalue);
			log.info("NetsaleValue in printpage is -->"+PrintNetsalevalue);
			Assert.assertEquals(PrintNetsalevalue, NetsaleValue);
			log.info("User successfully validated Quantity,SKU_No and NetSaleValue in TopSKuReport Page and Print Report page ");
			Library.Interaction.switchParentwindow();
			log.info("User switched to parent window");
			Library.Interaction.Enabled_Click(Xpath.TopskuReports.ExportBTN);
			log.info("User Clicked on ExportBTN");
			Library.Interaction.Enabled_Click(Xpath.TopskuReports.ClearBTN);
			log.info("User Clicked on ClearBTN and Data eneterd is cleared successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

}
