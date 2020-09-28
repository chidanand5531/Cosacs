package com.cosacs.TestCases;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS38_TechServRepairs extends BaseClass {
	
	String ProdDivValue = "OPTICAL";
	String ProdDeptValue = "ADMIN CHARGES";
	String ProdClassValue = "PF WOMEN";
	String ItemNumbVal = "js";
	String ManufacValue = "Acer";
	String DateField = "Tue, 17 March, 2020";
	String TechValue = "AYON  WARREN (3804)";
	String CategoryVal = "BROWN GOODS";
	String SerialNum = "1235";
	String RepairTypeValue = "In branch assessment";
	String ResolutionValue = "Damage On Delivery";
	String AddPartItemVal = "J0010SP";
	String APQuantityVal = "2";
	String CommentsServRepair = "Test";
	
	@Test
	public void ServiceRepairs() throws Throwable {
	
		try {
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.ServiceRepairs.Service);
			Library.Interaction.print("User Clicked on Service");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.ServiceRepairs.NewServReq);
			Library.Interaction.print("User Clicked on New Service Request");
			Library.Interaction.userWait();
			String ServReqTitle = driver.findElement(By.xpath(Xpath.ServiceRepairs.ServReqTitle)).getText();
			log.info("The Title is "+ServReqTitle);
			log.info("User is in Service Request Page");

		} catch (Exception e) {
			e.printStackTrace();
			captureScreen(driver, "ServiceRepairs");
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}
	
			@Test(dependsOnMethods = "ServiceRepairs")
	
	public void ServiceRepairsFunction() throws IOException {
		try {
			
			/*Clicking on the Radio Button*/
			Library.Interaction.click(Xpath.ServiceRepairs.StockRepairRB);
			
			/*Clicking on Create Button */
			Library.Interaction.click(Xpath.ServiceRepairs.ServReqCreateBtn);
			Thread.sleep(2000);
		
			/*Clicking on Product Division val from drop down */
			Library.Interaction.click(Xpath.ServiceRepairs.SRhierDiv);
			
			List<WebElement> ProdDivDropDownVal = driver.findElements(By.xpath("//div[contains(text(),'OPTICAL')]"));
			for (int i = 0; i < ProdDivDropDownVal.size(); i++)
			{
				if (ProdDivDropDownVal.get(i).getText().equals(ProdDivValue))
				{
					ProdDivDropDownVal.get(i).click();
					break;
				}
				Thread.sleep(2000);
			}
			Library.Interaction.print("User clicked OPTICAL");
			
			
			/*Clicking on Product Department val from drop down */
			Library.Interaction.click(Xpath.ServiceRepairs.SRhierDept);
			
			List<WebElement> ProdDeptDropDownVal = driver.findElements(By.xpath("//div[contains(text(),'ADMIN CHARGES')]"));
			for (int i = 0; i < ProdDeptDropDownVal.size(); i++)
			{
				if (ProdDeptDropDownVal.get(i).getText().equals(ProdDeptValue))
				{
					ProdDeptDropDownVal.get(i).click();
					break;
				}
				Thread.sleep(2000);
			}
			Library.Interaction.print("User clicked ADMIN CHARGES");
			
			/*Clicking on Product Class val from drop down */
			Library.Interaction.click(Xpath.ServiceRepairs.SRhierClass);
			
			List<WebElement> ProdClassDropDownVal = driver.findElements(By.xpath("//div[contains(text(),'PF WOMEN')]"));
			for (int i = 0; i < ProdClassDropDownVal.size(); i++)
			{
				if (ProdClassDropDownVal.get(i).getText().equals(ProdClassValue))
				{
					ProdClassDropDownVal.get(i).click();
					break;
				}
				Thread.sleep(2000);
			}
			Library.Interaction.print("User clicked PF WOMEN");
			
			/*Entering the value in Item number*/
			Library.Interaction.setTextBoxByXpath(Xpath.ServiceRepairs.ItemNumb, ItemNumbVal);
			
			/*Clicking on Search icon*/
			Library.Interaction.click(Xpath.ServiceRepairs.ItemNumSrch);
			Thread.sleep(2000);
			
			/*Clicking on product from Matching stock*/
			Library.Interaction.click(Xpath.ServiceRepairs.MatchingStck);
			Thread.sleep(2000);
			
			/*Selecting value from manufacture Drop down*/
			Library.Interaction.click(Xpath.ServiceRepairs.Manufacture);
			
			List<WebElement> ManufacDropDownVal = driver.findElements(By.xpath("//div[contains(text(),'Acer')]"));
			for (int i = 0; i < ManufacDropDownVal.size(); i++)
			{
				if (ManufacDropDownVal.get(i).getText().equals(ManufacValue))
				{
					ManufacDropDownVal.get(i).click();
					break;
				}
				Thread.sleep(2000);
			}
			Library.Interaction.print("User clicked Acer");
			
			/*Clicking on Save Btn*/
			Library.Interaction.click(Xpath.ServiceRepairs.SaveBtn);
			Thread.sleep(5000);
			
			/*Displaying the status to New*/
			WebElement ServReqTitle = driver.findElement(By.xpath(Xpath.ServiceRepairs.ServReqTitle));
			String[] str1 = ServReqTitle.getText().split(" ");
			Library.Interaction.print("The status changed to-> "+str1);
			Thread.sleep(20000);
			
			/*To Scroll down the application */
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,750)", "");
			Thread.sleep(3000);
			
			//Clicking on the Date Received
			Library.Interaction.click(Xpath.ServiceRepairs.Date);
			Library.Interaction.click(Xpath.ServiceRepairs.DateReceiPic);
			Library.Interaction.print("User Entered Received Date");
			Thread.sleep(2000);
			
			/*Entering the date in the part field*/
			Library.Interaction.click(Xpath.ServiceRepairs.DatePart);
			Library.Interaction.click(Xpath.ServiceRepairs.DatePartPic);
			Library.Interaction.print("User Entered Part Date");
			
			/*Entering the date in the Schedule field*/
			//Library.Interaction.setTextBoxByXpath(Xpath.ServiceRepairs.DateRecSchd, DateField);
			//Library.Interaction.print("User Entered Schedule date");
			
			/*Selecting value from Category drop down */
			Library.Interaction.click(Xpath.ServiceRepairs.Category);
			
			List<WebElement> CategoryDropDownVal = driver.findElements(By.xpath("//div[contains(text(),'BROWN GOODS')]"));
			for (int i = 0; i < CategoryDropDownVal.size(); i++)
			{
				if (CategoryDropDownVal.get(i).getText().equals(CategoryVal))
				{
					CategoryDropDownVal.get(i).click();
					break;
				}
				Thread.sleep(2000);
			}
			Library.Interaction.print("User clicked BROWN GOODS");
			
			/*Selecting value from Technician drop down */
			Library.Interaction.click(Xpath.ServiceRepairs.TechDrpDwn);
			Library.Interaction.click(Xpath.ServiceRepairs.TechVal);
			Library.Interaction.print("User clicked AYON  WARREN (3804)");
			
			/*CLicking on the Time Slots*/
//			Library.Interaction.click(Xpath.ServiceRepairs.TimeSlot1);
//			Thread.sleep(1000);
//			Library.Interaction.click(Xpath.ServiceRepairs.TimeSlot2);
//			Thread.sleep(1000);
			
			/*Clicking on Save Btn*/
			Library.Interaction.click(Xpath.ServiceRepairs.SaveBtn);
			Thread.sleep(10000);
			
			
			/*Entering the Serial Number*/
			Library.Interaction.setTextBoxByXpath(Xpath.ServiceRepairs.SerialNumb, SerialNum);
			
			/*Selecting value from Repair Type drop down */
			Library.Interaction.click(Xpath.ServiceRepairs.RepairType);
			
			List<WebElement> RepairTypeDropDownVal = driver.findElements(By.xpath("//div[contains(text(),'In branch assessment')]"));
			for (int i = 0; i < RepairTypeDropDownVal.size(); i++)
			{
				if (RepairTypeDropDownVal.get(i).getText().equals(RepairTypeValue))
				{
					RepairTypeDropDownVal.get(i).click();
					break;
				}
				Thread.sleep(2000);
			}
			Library.Interaction.print("User clicked In branch assessment");
			
			/*Selecting value from Resolution drop down */
			Library.Interaction.click(Xpath.ServiceRepairs.Resolution);
			
			List<WebElement> ResolutionDropDownVal = driver.findElements(By.xpath("//div[contains(text(),'Damage On Delivery')]"));
			for (int i = 0; i < ResolutionDropDownVal.size(); i++)
			{
				if (ResolutionDropDownVal.get(i).getText().equals(ResolutionValue))
				{
					ResolutionDropDownVal.get(i).click();
					break;
				}
				Thread.sleep(2000);
			}
			Library.Interaction.print("User clicked Damage On Delivery");
			Library.Interaction.click(Xpath.ServiceRepairs.AddPart);
			
			/*To Scroll down the application */
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(3000);
			
			//Clicking on the Search Icon
			Library.Interaction.click(Xpath.ServiceRepairs.APitemSrchIcon);
			Thread.sleep(5000);
			
			//Entering the value in the Item Search Text Box
			Library.Interaction.setTextBoxByXpath(Xpath.ServiceRepairs.APitemTxt, AddPartItemVal);
			
			//Clicking on the Search icon
			Library.Interaction.click(Xpath.ServiceRepairs.SearchIcon);
			Thread.sleep(5000);
			
			//Clicking on the Item Searched Record
			Library.Interaction.click(Xpath.ServiceRepairs.APMatchStck);
			Thread.sleep(5000);
			
			//Entering the text in the Add Part Quantity Text box
			Library.Interaction.setTextBoxByXpath(Xpath.ServiceRepairs.APQuantity, APQuantityVal);
			
			//clicking on the Add Part Button
			Library.Interaction.click(Xpath.ServiceRepairs.AddPartButton);
			
			//Clicking on Save Button
			Library.Interaction.click(Xpath.ServiceRepairs.SaveBtn);
			Thread.sleep(20000);
			
			/*To Scroll down the application */
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,1700)", "");
			Thread.sleep(3000);
			
			//clicking on Reason for exchange drop down
			Library.Interaction.click(Xpath.ServiceRepairs.ReasonForExchange);
			Library.Interaction.click(Xpath.ServiceRepairs.ReasonForExchangeVal);
			
			//Clicking on Reason For Failure
			Library.Interaction.click(Xpath.ServiceRepairs.ReasonForFailure);
			Library.Interaction.click(Xpath.ServiceRepairs.ReasonForFailureVal);
			
			//Clicking on return Date
			Library.Interaction.click(Xpath.ServiceRepairs.ReturnDate);
			Library.Interaction.click(Xpath.ServiceRepairs.ReturnDatePick);
			
			//Clicking on Save Button
			Library.Interaction.click(Xpath.ServiceRepairs.SaveBtn);
			Thread.sleep(10000);
			
			
			} catch (Exception e) {
				e.printStackTrace();
				captureScreen(driver, "ServiceRepairsFunction");
				Assert.assertFalse(false);
				log.info("Test Failed");
}

}
			}

