/*Project Name : IGT Framework
  Author : Vincy Virgenia James*/

package com.cosacs.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;

public class COS48_WarrantyProductLink extends BaseClass {
	
	String ExpecWarrantyProdLinkTitle = "Warranty/Product Link"; 
	String NameVal = "Testing Jamaica60"; 
	String DeptNameVal = "ADMIN CHARGES"; 
	String DivNameVal = "AFFINITY"; 
	String ClassNameVal = "10 PORC PROCESSING FEE"; 
	String StoreNameVal = "Courts Store";  
	String WarrantySrchVal = "191024"; 
	String WarrantyValue = "191024 : 4YR LCD/PLASMA>20000"; 
	String MinValue = "2500"; 
	String MaxValue = "5000";
	
	// The below method helps the user to land the Create Warranty Page
	
			@Test
			public void WarrantyProductLink() throws Throwable {
			
				try {
					Library.Interaction.userWait();
					Library.Interaction.click(Xpath.WarrantyProductLink.WarrantyLink);
					log.info("User Clicked on Warranty");
					Library.Interaction.userWait();
					Library.Interaction.click(Xpath.WarrantyProductLink.WarrantyProductLink);
					log.info("User Clicked on Warranty Product Link");
					Thread.sleep(2000);
					String WarrantyProdLinkTitle = driver.findElement(By.xpath(Xpath.WarrantyProductLink.WarntyProdTitle)).getText();
					Assert.assertEquals(WarrantyProdLinkTitle, ExpecWarrantyProdLinkTitle);
					log.info("User is in Warranty Product Link Page");
					Thread.sleep(3000);

				} catch (Exception e) {
					e.printStackTrace();
					captureScreen(driver, "Warranty Product Link");
					Assert.assertFalse(false);
					log.info("Test Failed");
				}
			}
			
			// The below method helps the user to Link Warranty Product
			@Test(dependsOnMethods = "WarrantyProductLink")
			
			public void LinkProduct() throws IOException {
				try {
					Library.Interaction.click(Xpath.WarrantyProductLink.AddNewBtn);
					Thread.sleep(2000);
					Library.Interaction.setTextBoxByXpath(Xpath.WarrantyProductLink.NameTextBox, NameVal);
					Library.Interaction.click(Xpath.WarrantyProductLink.Effdate);
					Library.Interaction.click(Xpath.WarrantyProductLink.EffDatePic);
					Library.Interaction.click(Xpath.WarrantyProductLink.ProdAddBtn);
					Thread.sleep(1000);
					Library.Interaction.click(Xpath.WarrantyProductLink.Division);
					List<WebElement> DivDropDownVal = driver.findElements(By.xpath(Xpath.WarrantyProductLink.DivName));
					for (int i = 0; i < DivDropDownVal.size(); i++)
						
					{
						if (DivDropDownVal.get(i).getText().equals(DivNameVal))
						{
							log.info("Text-->"+DivDropDownVal.get(i).getText());
							Thread.sleep(2000);
							DivDropDownVal.get(i).click();
							break;
						}
					}
					log.info("User clicked AFFINITY under Division");
					Library.Interaction.click(Xpath.WarrantyProductLink.Department);
					List<WebElement> DeptDropDownVal = driver.findElements(By.xpath(Xpath.WarrantyProductLink.DeptName));
					for (int i = 0; i < DeptDropDownVal.size(); i++)
					{
						if (DeptDropDownVal.get(i).getText().equals(DeptNameVal))
						{
							log.info("Text-->"+DeptDropDownVal.get(i).getText());
							Thread.sleep(2000);
							DeptDropDownVal.get(i).click();
							break;
						}
					}
					log.info("User clicked ADMIN CHARGES under Department");
					Library.Interaction.click(Xpath.WarrantyProductLink.Class);
					List<WebElement> ClassDropDownVal = driver.findElements(By.xpath(Xpath.WarrantyProductLink.ClassName));
					for (int i = 0; i < ClassDropDownVal.size(); i++)
					{
						if (ClassDropDownVal.get(i).getText().equals(ClassNameVal))
						{
							log.info("Text-->"+ClassDropDownVal.get(i).getText());
							Thread.sleep(2000);
							ClassDropDownVal.get(i).click();
							break;
						}
					}
					log.info("User clicked 10 PORC PROCESSING FEE under Class");
					Library.Interaction.click(Xpath.WarrantyProductLink.StoreType);
					List<WebElement> StoreDropDownVal = driver.findElements(By.xpath(Xpath.WarrantyProductLink.StoreTypeName));
					for (int i = 0; i < StoreDropDownVal.size(); i++)
					{
						if (StoreDropDownVal.get(i).getText().equals(StoreNameVal))
						{
							log.info("Text-->"+StoreDropDownVal.get(i).getText());
							Thread.sleep(2000);
							StoreDropDownVal.get(i).click();
							break;
						}
					}
					
					log.info("User clicked Courts Store under Store Type");

					Library.Interaction.click(Xpath.WarrantyProductLink.ProdSaveBtn);
					Thread.sleep(2000);
					Library.Interaction.click(Xpath.WarrantyProductLink.AssocWrntyAddBtn);
					Thread.sleep(2000);
					Library.Interaction.click(Xpath.WarrantyProductLink.WarrantyDrpdwn);
					Library.Interaction.setTextBoxByXpath(Xpath.WarrantyProductLink.WarrantySrchname, WarrantySrchVal);
					List<WebElement> WarrantyName = driver.findElements(By.xpath(Xpath.WarrantyProductLink.WarrantyValue));
					for (int i = 0; i < WarrantyName.size(); i++)
					{
						if (WarrantyName.get(i).getText().equals(WarrantyValue))
						{
							log.info("Text-->"+WarrantyName.get(i).getText());
							Thread.sleep(2000);
							WarrantyName.get(i).click();
							break;
						}
					}
					
					log.info("User clicked 191024 : 4YR LCD/PLASMA>20000");
					Thread.sleep(2000);
					Library.Interaction.setTextBoxByXpath(Xpath.WarrantyProductLink.MinVal, MinValue);
					Library.Interaction.setTextBoxByXpath(Xpath.WarrantyProductLink.MaxVal, MaxValue);
					Library.Interaction.click(Xpath.WarrantyProductLink.AssocSaveBtn);
					log.info("User Clicked on Associate warranty save button");
					Library.Interaction.click(Xpath.WarrantyProductLink.DetailSaveBtn);
					log.info("User Clicked on details Save Button");
					
				} catch (Exception e) {
					e.printStackTrace();
					captureScreen(driver, "Warranty Product Link");
					Assert.assertFalse(false);
					log.info("Test Failed");
				}

}
}
