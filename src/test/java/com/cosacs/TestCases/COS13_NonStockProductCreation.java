package com.cosacs.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS13_NonStockProductCreation extends BaseClass {

	public static String SKU="402231"; 
	public static String ShortDescription="OPTIPLUS OP-225 SPORT COR";
	public static String LongDescription="PIXMA 3010 - CANON PIXMA 3010 AIO PRINTER\r\n" + 
			"Is Active(Default)";
	public static String TaxRate="17.5";
	public static String ExpectedNewNonstockCreation="Non-Stock Details";
	public static String CostPrice="10000";
	public static String RetailPrice="5000";
	public static String Name="Athin";
	public static String NonStockData="402217 - OPTIPLUS OP-225 SPORT COR PIXMA 3010 - CANON PIXMA 3010 AIO PRINTE";
	public static String Name2="Canon Printer";
	public static String SKU2="123";
	public static String Discount="15";
    public static String NonStockData2="402217 - OPTIPLUS OP-225 SPORT COR PIXMA 3010 - CANON PIXMA 3010 AIO PRINTE";
	public static String ExpectedNonStocksExports="Non-Stocks Export";
	public static String ExpectedSearchNonStocks="Search Non-Stocks";
	public static String ExpectedNonStockProductLink="Non-Stocks/Product Link";
	public static String ExpectedNonStockPromotions="Non-Stock Promotions";
	
	

	@Test(priority=1)

	public void NonStock() throws IOException, InterruptedException {
		try
		{

			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.NewNonStockCreation.NonStocks);
			log.info("User Clicked on Non-Stocks Link");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.NewNonStockCreation.NewNonStocks);
			log.info("User Clicked on New Non-Stocks Link");
			Library.Interaction.userWait();
            Library.Interaction.MaxWait();
			String createNewNonStocks = driver.findElement(By.xpath(Xpath.NewNonStockCreation.VerifyNonStoctDetailspage)).getText();
			Assert.assertEquals(createNewNonStocks,ExpectedNewNonstockCreation);
			log.info("User are in Non Stock Details Page");

		}catch (Exception e) {

			captureScreen(driver, "NonStock");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}

	@Test(priority=2)
	public void NonStockCreation() throws IOException
	{
		try
		{

			Library.Interaction.setTextBoxByXpath(Xpath.NewNonStockCreation.SKU,SKU);
			Library.Interaction.userWait();
			log.info("User Entered SKU Code");
			Library.Interaction.selectAndSerachEle(Xpath.NewNonStockCreation.Type,Xpath.NewNonStockCreation.TypeSearch,Xpath.NewNonStockCreation.TypeData,"Installation");
			Library.Interaction.userWait();
			log.info("User Selected on Type");
            Library.Interaction.setTextBoxByXpath(Xpath.NewNonStockCreation.ShorDescription,ShortDescription);
			Library.Interaction.userWait();
			log.info("User Entered Vendor ShortDescription");
			Library.Interaction.setTextBoxByXpath(Xpath.NewNonStockCreation.LongDescription, LongDescription);
			Library.Interaction.userWait();
			log.info("User Entered Vendor LongDescription");
			Library.Interaction.setTextBoxByXpath(Xpath.NewNonStockCreation.TaxRate, TaxRate);
			Library.Interaction.userWait();
			log.info("User Entered Vendor TaxRate");
			Library.Interaction.selectAndSerachEle(Xpath.NewNonStockCreation.Divison,Xpath.NewNonStockCreation.DivisonSearch,Xpath.NewNonStockCreation.DivisonData,"COMPUTER AND OFFICE");
			Library.Interaction.userWait();
			log.info("User Selected on Divison");
			Library.Interaction.selectAndSerachEle(Xpath.NewNonStockCreation.Department,Xpath.NewNonStockCreation.DepartmentSearch,Xpath.NewNonStockCreation.DepartmentData,"COMPUTER AND ACCESSORIES");
			Library.Interaction.userWait();
			log.info("User Selected on Department");
			Library.Interaction.selectAndSerachEle(Xpath.NewNonStockCreation.Class,Xpath.NewNonStockCreation.ClassSearch,Xpath.NewNonStockCreation.ClassData,"PRINTER");
			Library.Interaction.userWait();
			log.info("User Selected on Class");
			Library.Interaction.click(Xpath.NewNonStockCreation.SaveButton);
			Library.Interaction.userWait();
			Library.Interaction.minWait();
			log.info("User Clicked on SaveButton");
            Library.Interaction.MaxWait();

		}catch(Exception e)
		{
			captureScreen(driver, "NonStockCreation");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}


	}



	@Test(priority=3)


	public void SearchNonStocks() throws InterruptedException, IOException
	{
		try {


			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchNonStocks.NonStocks);
			log.info("User Clicked on NonStocks Link");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchNonStocks.SearchNonStocks);
			log.info("User Clicked on SearchNonStocks Link");			
            Library.Interaction.MaxWait();
			String SearchNonStock = driver.findElement(By.xpath(Xpath.SearchNonStocks.VerifyNonStockSearchPage)).getText();
			Assert.assertEquals(SearchNonStock,ExpectedSearchNonStocks);
			log.info("User are in Search NonStocks Page");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.SearchNonStocks.SearchBox,SKU);
			log.info("User Entered Value to Search TextBox");
            Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.SearchNonStocks.ThreeDots);
			log.info("User Clicked on Three Dots");
			Library.Interaction.userWait();
			Library.Interaction.ScrollDown();
			Library.Interaction.userWait();
			log.info("User is able to scroll down");
			Library.Interaction.click(Xpath.SearchNonStocks.Plusbutton);
			log.info("User Clicked on Plus Button");
			Library.Interaction.userWait();
			Library.Interaction.selectAndSerachEle(Xpath.SearchNonStocks.Fascia,Xpath.SearchNonStocks.FasciaSearch,Xpath.SearchNonStocks.FasciaData,"Courts Store");
			log.info("User Selected Fascia Drop down ");
			Library.Interaction.userWait();
			Library.Interaction.selectAndSerachEle(Xpath.SearchNonStocks.Barnch,Xpath.SearchNonStocks.BranchSearch,Xpath.SearchNonStocks.BranchData,"910 COURTS CROSS ROADS");
			log.info("User Selected Barnch Drop down ");
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.SearchNonStocks.CostPrice, CostPrice);
			log.info("User Entered Cost Price");
            Library.Interaction.MaxWait();
			Library.Interaction.setTextBoxByXpath(Xpath.SearchNonStocks.RetailPrice, RetailPrice);
			log.info("User Entered Retail Price");
            Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.SearchNonStocks.SaveButton);
			log.info("User Clicked on Save Button");

		}catch(Exception e)
		{
			captureScreen(driver, "SearchNonStocks");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}



	@Test(priority=4)
	public void NonStockProduct() throws InterruptedException, IOException
	{   
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.NonStockProductLink.NonStock);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.NonStockProductLink.NonStockProductLinks);
            Library.Interaction.MaxWait();
			String NonStockProductLink = driver.findElement(By.xpath(Xpath.NonStockProductLink.VerifyNonStockProductLinkPage)).getText();
			Assert.assertEquals(NonStockProductLink,ExpectedNonStockProductLink);
			log.info("User are in NonStock Product link Page");
			Library.Interaction.click(Xpath.NonStockProductLink.AddNewButton);
			Library.Interaction.userWait();
			log.info("User Clicked on AddNewButton");
			Library.Interaction.setTextBoxByXpath(Xpath.NonStockProductLink.Name,Name);
			Library.Interaction.userWait();
			log.info("User Entered Name");
			Library.Interaction.click(Xpath.NonStockProductLink.Plusbutton1);
            Library.Interaction.MaxWait();
			Library.Interaction.selectAndSerachEle(Xpath.NonStockProductLink.Divison,Xpath.NonStockProductLink.DivisonSearch,Xpath.NonStockProductLink.DivisonData,"COMPUTER AND OFFICE");
			Library.Interaction.userWait();
			log.info("User Selected on Divison");
            Library.Interaction.selectAndSerachEle(Xpath.NonStockProductLink.Department,Xpath.NonStockProductLink.DepartmentSearch,Xpath.NonStockProductLink.DepartmentData,"COMPUTER AND ACCESSORIES");
			Library.Interaction.userWait();
			log.info("User Selected on Department");
            Library.Interaction.selectAndSerachEle(Xpath.NonStockProductLink.Class,Xpath.NonStockProductLink.ClassSearch,Xpath.NonStockProductLink.ClassData,"PRINTER");
			Library.Interaction.userWait();
			log.info("User Selected on Class");
			Library.Interaction.click(Xpath.NonStockProductLink.SaveButton1);
			Library.Interaction.userWait();
			log.info("User Clicked on Save Button1");
            Library.Interaction.MaxWait();
			Library.Interaction.ScrollDown();
			log.info("User is able to scrolldown");
			Library.Interaction.minWait();
			Library.Interaction.click(Xpath.NonStockProductLink.plusbutton2);
			Library.Interaction.minWait();
			Library.Interaction.selectAndSerachEle(Xpath.NonStockProductLink.NonStockDropDown,Xpath.NonStockProductLink.NonStockDropDownSearch,Xpath.NonStockProductLink.NonStockDropDownData,NonStockData);
			Library.Interaction.userWait();
			log.info("User Selected on NonStock Dropdown Data");
			Library.Interaction.click(Xpath.NonStockProductLink.SaveButton2);
			Library.Interaction.userWait();
			log.info("User Clicked on Save Button2");
			Library.Interaction.minWait();
            Library.Interaction.ScrollUp();
			log.info("User is able to scrollup");
			Library.Interaction.minWait();
            Library.Interaction.click(Xpath.NonStockProductLink.SaveButtonDisble);
			Library.Interaction.userWait();
			Library.Interaction.minWait();
			log.info("User Clicked on Main Save Button");
			
		}catch (Exception e) 
		{
			e.printStackTrace();
			captureScreen(driver, "locatNonStockProduction");
			Assert.assertFalse(false);
			log.info("Test Failed");

		}

	}



	@Test(priority=5)
	public static void NonStockPromotion() throws InterruptedException, IOException
	{
		try {
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.NonStockPromotions.NonStocks);
			log.info("User Clicked on Non-Stocks link");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.NonStockPromotions.NonStockProomotions);
			Library.Interaction.userWait();
			log.info("User Clicked on Non-Stock Promotions link");
            Library.Interaction.MaxWait();
			String NonStockPromotionsPage = driver.findElement(By.xpath(Xpath.NonStockPromotions.VerifyNonStockPromotionsPage)).getText();
			Assert.assertEquals(NonStockPromotionsPage,ExpectedNonStockPromotions);
			log.info("User are in NonStock Promotions Page");
            Library.Interaction.ScrollDown();
			Library.Interaction.userWait();
			Library.Interaction.minWait();
			log.info("User is able to scroll down page ");
			Library.Interaction.click(Xpath.NonStockPromotions.PlusButton);
            Library.Interaction.MaxWait();
			log.info("User clicked on plus button ");
			Library.Interaction.selectAndSerachEle(Xpath.NonStockPromotions.NonStock,Xpath.NonStockPromotions.NonStockSearch,Xpath.NonStockPromotions.NonStockData,NonStockData2);
			Library.Interaction.userWait();
			log.info("User Selected on NonStock Dropdown ");
			Library.Interaction.selectAndSerachEle(Xpath.NonStockPromotions.Fascia,Xpath.NonStockPromotions.FasciaSearch,Xpath.NonStockPromotions.FasciaData,"Courts Store");
			Library.Interaction.userWait();
			log.info("User clicked on Fascia Dropdown ");
			Library.Interaction.selectAndSerachEle(Xpath.NonStockPromotions.Branch,Xpath.NonStockPromotions.BranchSearch,Xpath.NonStockPromotions.BranchData,"910 COURTS CROSS ROADS");
			Library.Interaction.userWait();
			log.info("User selected on Branch Dropwon");
			Library.Interaction.selectAndSerachEle(Xpath.NonStockPromotions.PromotionType,Xpath.NonStockPromotions.PromotionTypeSearch,Xpath.NonStockPromotions.PromotionData,"Percentage Discount");
			Library.Interaction.userWait();
			log.info("User selected on PromotionType Dropwon");
			Library.Interaction.setTextBoxByXpath(Xpath.NonStockPromotions.Discount,Discount);
			Library.Interaction.userWait();
			log.info("User Entered Discount");
			Library.Interaction.click(Xpath.NonStockPromotions.SaveButton);
			Library.Interaction.userWait();
            Library.Interaction.MaxWait();
			log.info("User Clicked on Save Button");
		}catch(Exception e)
		{
			e.printStackTrace();
			captureScreen(driver, "NonStockPromotion");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}

	}

	@Test(priority=6)
	public void NonstockExports() throws InterruptedException, IOException {

		try {

			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.NonStocksExports.NonStock);
			Library.Interaction.userWait();
			log.info("User Clicked on Non-Stocks Link");
			Library.Interaction.click(Xpath.NonStocksExports.NonStocksExportLink);
			Library.Interaction.userWait();
			Library.Interaction.minWait();
			log.info("User Clicked on NonStocksExport Link");
			Library.Interaction.userWait();
			String NonstockExports = driver.findElement(By.xpath(Xpath.NonStocksExports.VerifyNonStockExport)).getText();
			Assert.assertEquals(NonstockExports,ExpectedNonStocksExports);
			log.info("User are in Non Stock Export Page");
			log.info("User are in Non Stock Export Page");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.NonStocksExports.DownloadProductsFile);
			Library.Interaction.userWait();
			log.info("User Clicked on Download Products File");
			Library.Interaction.click(Xpath.NonStocksExports.DownloadPromotionsFile);
			Library.Interaction.userWait();
			log.info("User Clicked on Download Promotions File");
			Library.Interaction.click(Xpath.NonStocksExports.DownloadProductAssociationFile);
			Library.Interaction.userWait();
			log.info("User Clicked on Download Product Association File");
            Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.NonStockPromotions.Logoutbutton);
			Library.Interaction.userWait();
			log.info("User clicked on Logout Button ");


		}catch(Exception e)
		{
			captureScreen(driver, "NonstockExports");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}

	}

}
