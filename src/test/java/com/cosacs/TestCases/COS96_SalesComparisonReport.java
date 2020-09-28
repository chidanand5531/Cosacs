package com.cosacs.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS96_SalesComparisonReport extends BaseClass {

	String ExpectedSalesComparisonReport="Sales Comparison Report";
	String PeriodData="Period 12, 31 Mar 2020";
	String BrandData="CANON";
	String FasciaData="Courts";
	String DivisonData="COMPUTER AND OFFICE";
	String DepartmentData="COMPUTER AND ACCESSORIES";
	String ClassData="PRINTER";

	@Test
	public void SalesComparisonReport() throws IOException {

		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SalesComparisonReport.merchandising);
			Library.Interaction.userWait();
			log.info("User clicked on merchandising option");
			Library.Interaction.moveToElement(Xpath.SalesComparisonReport.Reports);
			Library.Interaction.userWait();
			log.info("Cursor moved to Reporst Option");
			Library.Interaction.moveToElement(Xpath.SalesComparisonReport.SalesComparison);
			Library.Interaction.userWait();
			log.info("Cursor moved to Sales Comparison Option");
			Library.Interaction.click(Xpath.SalesComparisonReport.SalesComparison);
			Library.Interaction.userWait();
			log.info("User clicked on Sales Comparison Option");
		    String SalesComparisonPage = driver.findElement(By.xpath(Xpath.SalesComparisonReport.VerifySalesComparisonpage)).getText();
			Assert.assertEquals(SalesComparisonPage,ExpectedSalesComparisonReport);
	        log.info("User are in Sales Comparison Report Page");
            Library.Interaction.selectAndSerachEle(Xpath.SalesComparisonReport.Period,Xpath.SalesComparisonReport.PeriodSearch,Xpath.SalesComparisonReport.PeriodData,PeriodData);
			Library.Interaction.userWait();
			log.info("User Selected Period Data");
			Library.Interaction.selectAndSerachEle(Xpath.SalesComparisonReport.Brand,Xpath.SalesComparisonReport.BrandSearch,Xpath.SalesComparisonReport.BranchData,BrandData);
			Library.Interaction.userWait();
			log.info("User Selected Brand Data");
			Library.Interaction.selectAndSerachEle(Xpath.SalesComparisonReport.Fascia,Xpath.SalesComparisonReport.FasciaSearch,Xpath.SalesComparisonReport.FasciaData,FasciaData);
			Library.Interaction.userWait();
			log.info("User Selected Fascia Data");
			Library.Interaction.selectAndSerachEle(Xpath.SalesComparisonReport.Divison,Xpath.SalesComparisonReport.DivisonSearch,Xpath.SalesComparisonReport.DivisonData,DivisonData);
			Library.Interaction.userWait();
			log.info("User Selected Divison Data");
			Library.Interaction.selectAndSerachEle(Xpath.SalesComparisonReport.Department,Xpath.SalesComparisonReport.DepartmentSearch,Xpath.SalesComparisonReport.DepartmentData,DepartmentData);
			Library.Interaction.userWait();
			log.info("User Selected Department Data");
			Library.Interaction.selectAndSerachEle(Xpath.SalesComparisonReport.Class,Xpath.SalesComparisonReport.ClassSearch,Xpath.SalesComparisonReport.ClassData,ClassData);
			Library.Interaction.userWait();
			log.info("User Selected Class Data");
            Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SalesComparisonReport.Search);
			log.info("User Clicked on Search Button");
			Library.Interaction.IsDisplayed(Xpath.SalesComparisonReport.hideShowButton);
			Library.Interaction.click(Xpath.SalesComparisonReport.Export);
			Library.Interaction.userWait();
			Library.Interaction.MaxWait();
			log.info("User clicked on Export button");
			Library.Interaction.click(Xpath.SalesComparisonReport.Print);
			Library.Interaction.userWait();
			Library.Interaction.MaxWait();
			log.info("User Clicked on Print Button");
			Library.Interaction.userWait();
			Library.Interaction.MaxWait();
			Library.Interaction.click(Xpath.SalesComparisonReport.Clear);
			Library.Interaction.userWait();
			Library.Interaction.MaxWait();
			log.info("User clicked on Clear button");

		}catch(Exception e)
		{
			e.printStackTrace();
			captureScreen(driver, "SalesComparisonReport");
			Assert.assertFalse(false);
			log.info("Test Failed");

		}
	}

}
