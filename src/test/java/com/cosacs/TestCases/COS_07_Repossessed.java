package com.cosacs.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

/*
* Project Name : CosaCS -  Unicomer - COS_07_Repossessed
* Author : Shivaprasad
* Version : v10.5.2.2124
* Reviewed By : 
* Date of Creation : 
* Date of change : 
* changed function : 
* Steps followed : Login-->Merchandising-->search product-->Select random regular stock product-->Convert the product into repossessed product-->Verify the created new repossessed product are in non-active status-->Update the hierarchy based on parent product-->EOD process-->Product status will be active
* Modified By : 
*/

//*****NOTE - Before running the script GO to xpath and increase the required index value********
//*******Xpath is mentioned in Repossessed xpath list***********

public class COS_07_Repossessed extends BaseClass {

	static JavascriptExecutor j;

	@Test
	public static void Repossessed() throws Exception {
		try {

			// *****************Converting the product to Repossessed

			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Repossessed.merchandising);
			log.info("User clicked on merchandising");
			Library.Interaction.moveToElement(Xpath.Repossessed.search);
			Library.Interaction.print("User just did mouse over action on search");
			Library.Interaction.click(Xpath.Repossessed.productenquiry);
			log.info("User clicked on product enquiry");
			String verifyproductpage = driver.findElement(By.xpath(Xpath.Repossessed.productenquiryverify)).getText();
			Assert.assertEquals(verifyproductpage, JsonParser.testData("Repossessed.productenquiryverify"));
			log.info("User successfully logged in to Product Enquiry page");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Repossessed.regularstock);
			Library.Interaction.print("User clicked on regularstock product");
			Thread.sleep(1000);
			Library.Interaction.click(Xpath.Repossessed.activecurrent);
			Library.Interaction.print("User clicked on active current product");
			Thread.sleep(1000);
//			boolean volumeFound = driver.findElement(By.xpath(Xpath.Repossessed.volume)).isDisplayed();
//			System.out.println(volumeFound);
//			if(volumeFound =! true) {
//				Robot r = new Robot();
//				r.keyPress(KeyEvent.VK_END);
//				r.keyRelease(KeyEvent.VK_END);
//				Thread.sleep(3000);
//			}else {
//				System.out.println(" product Link found");
//			}
			 Library.Interaction.ScrollElemntsample(Xpath.Repossessed.volume);
			Library.Interaction.print("User scrolled to the required product code");		
		//	Library.Interaction.ScrollDownTill_ElementFound(Xpath.Repossessed.randomproduct);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Repossessed.randomproduct);
			Library.Interaction.print("randomly one Regular stock product is selected");
			log.info("User selected Regular Stock Product");
			Library.Interaction.userWait();
			String regularmaintenance = Library.Interaction.splitsymbol(Xpath.Repossessed.regularstockmaintenance);
			System.out.println(regularmaintenance + "--<");
			Assert.assertEquals(regularmaintenance, JsonParser.testData("Repossessed.regularpageverify"));
			String skucode = Library.Interaction.splitsymbolprintcode(Xpath.Repossessed.regularstockmaintenance);
			log.info(skucode + " <--Product code to be repossessed");
			log.info("User successfully logged into regular stock maintenance page");
			// ******************Selecting Regular Stock Product****************************
			Library.Interaction.userWait();
			String divpro = driver.findElement(By.xpath(Xpath.Repossessed.divpro)).getText();
			Library.Interaction.print(divpro + "<-- Division");
			String deppro = driver.findElement(By.xpath(Xpath.Repossessed.deppro)).getText();
			Library.Interaction.print(deppro + "<-- Department");
			String classpro = driver.findElement(By.xpath(Xpath.Repossessed.classpro)).getText();
			Library.Interaction.print(classpro + "<-- Class");
			Library.Interaction.click(Xpath.Repossessed.repossessedcodebutton);
			log.info("User successfully noted all the product hierarchy specified");
			Library.Interaction.print("clicked on repossessed code button");
			log.info("User successfully converted the product to Repossessed product");
			Library.Interaction.userWait();
			String text = driver.findElement(By.xpath(Xpath.Repossessed.repossessedsuccessfully)).getText()
					.replaceAll("[^A-Za-z0-9]", " ");
			Library.Interaction.print(text + "<--notification with Repossessed product code");
			Library.Interaction.print("notification displayed");
			log.info(text);
			log.info("User created Repossessed Product by 4 Porduct codes");
			// *****************Converting Regular Stock product into Repossessed
			 Library.Interaction.IsDisplayed(Xpath.Repossessed.productE);
			boolean Excellent = driver.findElement(By.xpath(Xpath.Repossessed.productE)).isDisplayed();
			if(Excellent == true) {		
			Library.Interaction.click(Xpath.Repossessed.productE);
			log.info("Clicked on Excellent product code");
			Thread.sleep(2000);
			String code1 = driver.findElement(By.xpath(Xpath.Repossessed.productcoderepoosessed)).getText();
			log.info(code1 + " <-- Excellent product code");
			String statusE = driver.findElement(By.xpath(Xpath.Repossessed.type)).getText();
			Library.Interaction.print(statusE + " <--  E - status of product code");
			log.info(statusE + " <--  E - status of product code");
			log.info("User noted the status of product-Excellent");			
			String condE = driver.findElement(By.xpath(Xpath.Repossessed.condition)).getAttribute("value");
			Library.Interaction.print(condE + " <--  condition of product");
			Library.Interaction.ScrollDownTill_ElementFound(Xpath.Repossessed.classE);
			Thread.sleep(1500);
		//	Library.Interaction.ScrollElemntsmallH(Xpath.Repossessed.savebut);
			Library.Interaction.IsDisplayed(Xpath.Repossessed.divisionE);
			Library.Interaction.selectele(Xpath.Repossessed.divisionE, Xpath.Repossessed.divisiontextboxE,
					Xpath.Repossessed.divisiontextE, JsonParser.testData("Repossessed.Div"),
					JsonParser.testData("Repossessed.Div"));
			Library.Interaction.print(divpro + "DIV-->  Same division as per parent product code");
			Library.Interaction.selectele(Xpath.Repossessed.depE, Xpath.Repossessed.deptextboxE,
					Xpath.Repossessed.deptextE, JsonParser.testData("Repossessed.Dep"),
					JsonParser.testData("Repossessed.Dep"));
			Library.Interaction.print(deppro + "DEP-->  Same department as per parent product code");
			Library.Interaction.selectele(Xpath.Repossessed.classE, Xpath.Repossessed.classtextboxE,
					Xpath.Repossessed.classtextE, "Repo", JsonParser.testData("Repossessed.Class"));
			Library.Interaction.print(classpro + "CLASS-->  Same class as  perparent product code");
			log.info("User verified the Excellent product code and updated the Product hierarchy");
			// *******************Updated The Product Hierarchy For Excellent Product code
			}else {
				
				log.info("Product Excellent code is not generated");
			}
			Library.Interaction.IsDisplayed(Xpath.Repossessed.productF);
			boolean Fair = driver.findElement(By.xpath(Xpath.Repossessed.productF)).isDisplayed();
			if(Fair == true) {
			
			
			Library.Interaction.click(Xpath.Repossessed.productF);
			log.info("Clicked on Fair Product code");
			Thread.sleep(4000);
			String code2 = driver.findElement(By.xpath(Xpath.Repossessed.productcoderepoosessed)).getText();
			log.info(code2 + " <-- Fair product code");
			String statusF = driver.findElement(By.xpath(Xpath.Repossessed.type)).getText();
			Library.Interaction.print(statusF + " <--  F - status of product code");
			log.info(statusF + " <--  F - status of product code");
			log.info("User noted the status of product-Fair");
			// *********************FAIR PRODUCT*********************
			String condF = driver.findElement(By.xpath(Xpath.Repossessed.condition)).getAttribute("value");
			Library.Interaction.print(condF + " <--  condition of product");
			//Library.Interaction.ScrollElemntsmallH(Xpath.Repossessed.savebut);
			Library.Interaction.ScrollDownTill_ElementFound(Xpath.Repossessed.classE);
			Thread.sleep(1500);
			Library.Interaction.IsDisplayed(Xpath.Repossessed.divisionE);
			Library.Interaction.selectele(Xpath.Repossessed.divisionE, Xpath.Repossessed.divisiontextboxE,
					Xpath.Repossessed.divisiontextE, JsonParser.testData("Repossessed.Div"),
					JsonParser.testData("Repossessed.Div"));
			Library.Interaction.print(divpro + "DIV-->  Same division as per parent product code");
			Library.Interaction.selectele(Xpath.Repossessed.depE, Xpath.Repossessed.deptextboxE,
					Xpath.Repossessed.deptextE, JsonParser.testData("Repossessed.Dep"),
					JsonParser.testData("Repossessed.Dep"));
			Library.Interaction.print(deppro + "DEP-->  Same department as per parent product code");
			Library.Interaction.selectele(Xpath.Repossessed.classE, Xpath.Repossessed.classtextboxE,
					Xpath.Repossessed.classtextE, "Repo", JsonParser.testData("Repossessed.Class"));
			Library.Interaction.print(classpro + "CLASS-->  Same class as  perparent product code");
			// *******************Updated The Product Hierarchy For Fair Product
			// *********************POOR PRODUCT*********************
			}else {
				log.info("Product Fair code is not generated");
			}
			Library.Interaction.IsDisplayed(Xpath.Repossessed.productP);
			boolean Poor = driver.findElement(By.xpath(Xpath.Repossessed.productP)).isDisplayed();
			if(Poor == true)
			{
			
			
			Library.Interaction.click(Xpath.Repossessed.productP);
			log.info("User clicked on Poor Product Code");
			Thread.sleep(4000);
			String code3 = driver.findElement(By.xpath(Xpath.Repossessed.productcoderepoosessed)).getText();
			log.info(code3 + " <-- Poor product code");
			String statusP = driver.findElement(By.xpath(Xpath.Repossessed.type)).getText();
			Library.Interaction.print(statusP + " <--  P - status of product code");
			log.info(statusP + " <--  P - status of product code");
			log.info("User noted the status of product- Poor");
			String condP = driver.findElement(By.xpath(Xpath.Repossessed.condition)).getAttribute("value");
			Library.Interaction.print(condP + " <--  condition of product");			
			//Library.Interaction.ScrollElemntsmallH(Xpath.Repossessed.savebut);
			Library.Interaction.ScrollDownTill_ElementFound(Xpath.Repossessed.classE);
			Thread.sleep(1500);
			Library.Interaction.IsDisplayed(Xpath.Repossessed.divisionE);
			Library.Interaction.selectele(Xpath.Repossessed.divisionE, Xpath.Repossessed.divisiontextboxE,
					Xpath.Repossessed.divisiontextE, JsonParser.testData("Repossessed.Div"),
					JsonParser.testData("Repossessed.Div"));
			Library.Interaction.print(divpro + "DIV-->  Same division as per parent product code");
			Library.Interaction.selectele(Xpath.Repossessed.depE, Xpath.Repossessed.deptextboxE,
					Xpath.Repossessed.deptextE, JsonParser.testData("Repossessed.Dep"),
					JsonParser.testData("Repossessed.Dep"));
			Library.Interaction.print(deppro + "DEP-->  Same department as per parent product code");
			Library.Interaction.selectele(Xpath.Repossessed.classE, Xpath.Repossessed.classtextboxE,
					Xpath.Repossessed.classtextE, "Repo", JsonParser.testData("Repossessed.Class"));
			Library.Interaction.print(classpro + "CLASS-->  Same class as  perparent product code");
			// *******************Updated The Product Hierarchy For Poor Product

			// *********************WRITE OFF PRODUCT*********************
			}else {
				log.info("Product Fair code is not generated");
			}
			
			Library.Interaction.IsDisplayed(Xpath.Repossessed.productW);
			boolean Writeoff = driver.findElement(By.xpath(Xpath.Repossessed.productW)).isDisplayed();
			if(Writeoff == true)
			{		
			Library.Interaction.click(Xpath.Repossessed.productW);
			log.info("Clicked on writeoff Product Code");
			Thread.sleep(4000);
			String code4 = driver.findElement(By.xpath(Xpath.Repossessed.productcoderepoosessed)).getText();
			log.info(code4 + " <-- Write-off product code");
			String statusW = driver.findElement(By.xpath(Xpath.Repossessed.type)).getText();
			Library.Interaction.print(statusW + " <--  W - status of product code");
			log.info(statusW + " <--  W - status of product code");
			log.info("User noted the status of product- Write-Off");
			String condW = driver.findElement(By.xpath(Xpath.Repossessed.condition)).getAttribute("value");
			Library.Interaction.print(condW + " <--  condition of product");			
		//	Library.Interaction.ScrollElemntsmallH(Xpath.Repossessed.savebut);
			Library.Interaction.ScrollDownTill_ElementFound(Xpath.Repossessed.classE);
			Thread.sleep(1500);
			Library.Interaction.IsDisplayed(Xpath.Repossessed.divisionE);
			Library.Interaction.selectele(Xpath.Repossessed.divisionE, Xpath.Repossessed.divisiontextboxE,
					Xpath.Repossessed.divisiontextE, JsonParser.testData("Repossessed.Div"),
					JsonParser.testData("Repossessed.Div"));
			Library.Interaction.print(divpro + "DIV-->  Same division as per parent product code");
			Library.Interaction.selectele(Xpath.Repossessed.depE, Xpath.Repossessed.deptextboxE,
					Xpath.Repossessed.deptextE, JsonParser.testData("Repossessed.Dep"),
					JsonParser.testData("Repossessed.Dep"));
			Library.Interaction.print(deppro + "DEP-->  Same department as per parent product code");
			Library.Interaction.selectele(Xpath.Repossessed.classE, Xpath.Repossessed.classtextboxE,
					Xpath.Repossessed.classtextE, "Repo", JsonParser.testData("Repossessed.Class"));
			Library.Interaction.print(classpro + "CLASS-->  Same class as  perparent product code");
			log.info("User verified the Write-off product code and updated the Product hierarchy");
			log.info("NOTE - Product status will be active after EOD process  ");

			// *******************Updated The Product Hierarchy For Write-off Product
			
			}else {
				log.info("Product Fair code is not generated");
			}
			
			
			Thread.sleep(2000);
			Library.Interaction.click(Xpath.Repossessed.notifyclose);
			Library.Interaction.print("Notification Closed");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Repossessed.homeicon);
			log.info("User is in Home page");
			

		} catch (InterruptedException e) {
			captureScreen(driver, "Repossessed");
			Assert.assertFalse(false);
			log.info("Test Failed");
			throw (e);
		}

	}
}
