package com.cosacs.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS57_TechnicianDairy extends BaseClass{
	
	public static Robot rb;
	public String ExpectedTitle="Technician Diary";
	public static JavascriptExecutor js;
	public static String ExpectedColor="rgba(236, 0, 140, 1)";
	public static String AvailableTo="09/26/2020";
	public static String AvailableFrom="09/26/2020";
	public static String TechnicianName="AYON";
	public static String VisibleWeeks="1";
	
	@Test
	public void TechnicianDairy()throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.Services);
			log.info("User Clicked on Service");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.TechnicianDairy);
			log.info("User clicked on TechnicianDairy");
			Library.Interaction.userWait();
			String ActualTitle = Library.Interaction.verifyPageTitle();
			Assert.assertEquals(ActualTitle, ExpectedTitle);
			log.info("Page Title is Verified Successfully");
			Thread.sleep(5000);
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.TechnicanDairy.TechnicianName, Xpath.TechnicanDairy.TechnicianNameSearch, Xpath.TechnicanDairy.TechnicianList, TechnicianName, TechnicianName);
			log.info("User selected Technician Name");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.Date);
			Thread.sleep(2000);
			Library.Interaction.click(Xpath.TechnicanDairy.TD);
			log.info("User Selected Date of Start Week to View");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.VisibleWeeks);
			driver.findElement(By.xpath(Xpath.TechnicanDairy.VisibleWeeks)).clear();
			Library.Interaction.setTextBoxByXpath(Xpath.TechnicanDairy.VisibleWeeks, VisibleWeeks);
			log.info("User entered visible weeks");
			rb=new Robot();
			rb.keyPress(KeyEvent.VK_END);
			rb.keyRelease(KeyEvent.VK_END);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			Library.Interaction.setTextBoxByXpath(Xpath.TechnicanDairy.AvailbleFromDate, AvailableFrom);
			log.info("User Selected Technician Unavailable From Date");
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			Library.Interaction.setTextBoxByXpath(Xpath.TechnicanDairy.AvailbleToDate, AvailableTo);
			log.info("User Selected Technician Unavailable To Date");
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.ASubmit);
			log.info("Technician Unavailablity Dates Submited Successfully");
			Thread.sleep(2000);
			Library.Interaction.userWait();
			String Actualcolor = driver.findElement(By.xpath(Xpath.TechnicanDairy.color)).getCssValue("background-color");
			Assert.assertEquals(Actualcolor, ExpectedColor);
			log.info("Technician Not Available From "+ AvailableFrom + " To "+AvailableTo);
			Thread.sleep(1000);
			Library.Interaction.click(Xpath.TechnicanDairy.HolidayApprove);
			log.info("User clicked on holiday approve date");
			Library.Interaction.click(Xpath.TechnicanDairy.Delete);
			log.info("User deleted approved date");
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

