package com.cosacs.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cosacs.Locators.Name;
import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

public class COS17_GoodsReceipt extends BaseClass{
	
	static String PoNo;
	static String GRNumber;
	static String ProductCode;
	static String Onhand;
	
	
	@Test()
	public void create_GoodsReciept_Test() throws IOException {

		try {
			boolean flag = driver.findElement(By.xpath(Xpath.LoginPage.Logo)).isDisplayed();
			Assert.assertTrue(flag);
			log.info("User has verified Company Logo successfully");
			Library.Interaction.IsDisplayed_Click(Xpath.GoodsRecieptNO.merchandising);
			log.info("User Clicked on Merchandising");
			Library.Interaction.userWait();
			Library.Interaction.moveToElement(Xpath.GoodsRecieptNO.create);
			log.info("User Clicked on Create");
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.GoodsRecieptNO.Goodsreceipt);
			log.info("User Clicked on Goods Reciept");
			String create_GRNLabel = Library.Interaction.getelementText(Xpath.GoodsRecieptNO.Verify_GRNPage);
			Assert.assertEquals(create_GRNLabel, JsonParser.testData("GRNdata.ExpectedGRN_Label"));
			log.info("User are in Create Goods Reciept Page");
			Library.Interaction.selectSuggestions(Xpath.GoodsRecieptNO.RecievingArrow, Xpath.GoodsRecieptNO.RecievigSearch, Xpath.GoodsRecieptNO.SelectLocation, JsonParser.testData("GRNdata.Seachvalue"), JsonParser.testData("GRNdata.SelectSuggestion"));
			log.info("User selected receiving location");
			Library.Interaction.CalenderDate(Xpath.GoodsRecieptNO.SelectDate);
			log.info("User entered the Date");
			Library.Interaction.EnterTab();
			Library.Interaction.setTextBoxByXpath(Xpath.GoodsRecieptNO.VendordelvryNO, JsonParser.testData("GRNdata.vendordeliveryno"));
			log.info("User entered the Vendor delivery no");
			Library.Interaction.selectSuggestions(Xpath.GoodsRecieptNO.VendorArrow, Xpath.GoodsRecieptNO.VendorSearch, Xpath.GoodsRecieptNO.VendorSelect, JsonParser.testData("GRNdata.VendorsearchValue"), JsonParser.testData("GRNdata.SelectVendor"));
			log.info("User  selected Vendor");
			Library.Interaction.setTextBoxByXpath(Xpath.GoodsRecieptNO.Comment, JsonParser.testData("GRNdata.Comment"));
			log.info("User entered the Comment");
			Thread.sleep(2000);
			Library.Interaction.moveToElement(Xpath.GoodsRecieptNO.SelectPO);
			Robot robo=new Robot();
			Thread.sleep(1000);
			robo.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			robo.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(500);
			robo.keyPress(KeyEvent.VK_ENTER);
			Library.Interaction.selectLastDropDown(Name.GRNCreation.GRNR_PO);
			log.info("User selected the purchage order");
			Library.Interaction.selectVisibleText(Name.GRNCreation.GRNReciever, JsonParser.testData("GRNdata.RecievedBy"));
			log.info("User selected Recieved by");
			Library.Interaction.click(Xpath.GoodsRecieptNO.PlusMark);
			ProductCode=Library.Interaction.getelementText(Xpath.GoodsRecieptNO.ProductCode);
			log.info("ProductCode -->"+ProductCode);
			Library.Interaction.openNewTab(Xpath.GoodsRecieptNO.ProductCode);
			Library.Interaction.switchNewwindow();
			log.info("User switched to new window and checked the quantity available");
			String Onhand=driver.findElement(By.xpath("//a[contains(text(),'"+JsonParser.testData("GRNdata.SelectSuggestion")+"')]/parent::td/following-sibling::td[1]")).getText();
			log.info("onhand quantity in "+JsonParser.testData("GRNdata.SelectSuggestion")+" location are-->"+Onhand);
			String Available=driver.findElement(By.xpath("//a[contains(text(),'"+JsonParser.testData("GRNdata.SelectSuggestion")+"')]/parent::td/following-sibling::td[2]")).getText();
			log.info("available quantity in "+JsonParser.testData("GRNdata.SelectSuggestion")+" location are-->"+Available);
			String OnOrderQuantity=driver.findElement(By.xpath("//a[contains(text(),'"+JsonParser.testData("GRNdata.SelectSuggestion")+"')]/parent::td/following-sibling::td[2]")).getText();
			log.info("On order quantity in "+JsonParser.testData("GRNdata.SelectSuggestion")+" location are-->"+OnOrderQuantity);
			driver.close();
			Library.Interaction.switchParentwindow();
			log.info("User switched to parent window");
			String poNumber=Library.Interaction.getelementText(Xpath.GoodsRecieptNO.PONumber);
			PoNo=poNumber.replaceAll("[^0-9]", "");
			log.info("Purchage order No -->"+PoNo);
			String QuantityPendng=Library.Interaction.getelementText(Xpath.GoodsRecieptNO.QuantityPendng);
			log.info(" Quantity pending -->"+QuantityPendng);
			List<WebElement> ProdCodeVal = driver
					.findElements(By.xpath("//td[@class='quantity']//div[@class='has-error']//input"));
			System.out.println("Total purchage orders --> " + ProdCodeVal.size());
			for (int i = 0; i < ProdCodeVal.size(); i++) {
				ProdCodeVal.get(i).sendKeys("1");
			}
			Library.Interaction.ScrollDownTill_ElementFound(Xpath.GoodsRecieptNO.CreaterecptBTN);
			Library.Interaction.click(Xpath.GoodsRecieptNO.CreaterecptBTN);
			log.info("User clicked on Create reciept Button successfully");
			Library.Interaction.IsDisplayed(Xpath.GoodsRecieptNO.Message_catch);
			String successMessage=Library.Interaction.verifyToastMessage(Xpath.GoodsRecieptNO.Message_catch);
			Assert.assertEquals(successMessage, JsonParser.testData("GRNdata.GRNMessage"));
			Library.Interaction.click(Xpath.GoodsRecieptNO.MessageClick);
			String GRN_No=Library.Interaction.getelementText(Xpath.GoodsRecieptNO.GRNLabel);
			GRNumber=GRN_No.replaceAll("[^0-9]", "");
			log.info("User got the Goods reciept No-->"+ (GRN_No.replaceAll("[^0-9]", "")));
			Library.Interaction.ScrollUpTill_ElementFound(Xpath.GoodsRecieptNO.ApproveBTN);
			if(driver.findElement(By.xpath(Xpath.GoodsRecieptNO.VerifyCostBTN)).isDisplayed()==true){
				Library.Interaction.click(Xpath.GoodsRecieptNO.VerifyCostBTN);
				Library.Interaction.switchNewwindow();
				String NewwindowLabel=Library.Interaction.getelementText(Xpath.GoodsRecieptNO.GRNLabel);
				log.info("User switched to new window GRN cost Page");
				Assert.assertEquals(NewwindowLabel, JsonParser.testData("GRNdata.newWndoLabel"));
				String GReciept=Library.Interaction.getelementText(Xpath.GoodsRecieptNO.ChildWndGoodReciept);
				String goodsRCptNo=GReciept.replaceAll("[^0-9]", "");
				Assert.assertEquals(goodsRCptNo, GRNumber);
				log.info("User switched to new window Validated Goods reciept No");
				String PurchageORD=Library.Interaction.getelementText(Xpath.GoodsRecieptNO.ChildWnd_PONo);
				String PurchaORDNo=PurchageORD.replaceAll("[^0-9]", "");
				Assert.assertEquals(PurchaORDNo, PoNo);
				log.info("User switched to new window Validated Purchage order No");
				Library.Interaction.click(Xpath.GoodsRecieptNO.ChildWnd_ConfirmBTN);
				Library.Interaction.IsDisplayed(Xpath.GoodsRecieptNO.Message_catch);
				driver.close();
				Library.Interaction.switchParentwindow();
				log.info("User switched to parent window");
				Library.Interaction.click(Xpath.GoodsRecieptNO.ApproveBTN);
			}else {
				Library.Interaction.click(Xpath.GoodsRecieptNO.ApproveBTN);
			}
			Library.Interaction.IsDisplayed(Xpath.GoodsRecieptNO.Message_catch);
			String message3=Library.Interaction.verifyToastMessage(Xpath.GoodsRecieptNO.Message_catch);
			log.info(message3);
			driver.navigate().refresh();
			Library.Interaction.userWait();
			Thread.sleep(3000);
			Library.Interaction.IsDisplayed(Xpath.GoodsRecieptNO.ApproveStatus);
			String status=Library.Interaction.getElmtText(Xpath.GoodsRecieptNO.ApproveStatus);
			log.info("Status after Approving : "+status);
			Library.Interaction.openNewTab(Xpath.GoodsRecieptNO.UpdatedProductCode);
			Library.Interaction.switchNewwindow();
			log.info("User switched to new window and checked the quantity available");
			String updated_onhandQ=driver.findElement(By.xpath("//a[contains(text(),'"+JsonParser.testData("GRNdata.SelectSuggestion")+"')]/parent::td/following-sibling::td[1]")).getText();
			log.info("updated onhand quantity in "+JsonParser.testData("GRNdata.SelectSuggestion")+" location are-->"+updated_onhandQ);
			String updated_AvlQuantty=driver.findElement(By.xpath("//a[contains(text(),'"+JsonParser.testData("GRNdata.SelectSuggestion")+"')]/parent::td/following-sibling::td[2]")).getText();
			log.info("updated vailable quantity in "+JsonParser.testData("GRNdata.SelectSuggestion")+" location are-->"+updated_AvlQuantty);
			String updated_onOrder=driver.findElement(By.xpath("//a[contains(text(),'"+JsonParser.testData("GRNdata.SelectSuggestion")+"')]/parent::td/following-sibling::td[2]")).getText();
			log.info("Updated On order quantity in "+JsonParser.testData("GRNdata.SelectSuggestion")+" location are-->"+updated_onOrder);
			int QuantityAfterPO=Integer.parseInt(updated_onhandQ)+Integer.parseInt(JsonParser.testData("GRNdata.quantityRecived"));
			int UpdatedQuantity =Integer.parseInt(updated_onhandQ);
			if(QuantityAfterPO==UpdatedQuantity) {
				System.out.println("Quantity is Updated");
			}else {
				System.out.println("Quantity not Updated Reindexing needed");
			}
			driver.close();
			Library.Interaction.switchParentwindow();
			log.info("User switched to parent window");
			log.info("User Created goods reciept successfully");		
		} catch(Exception e) {
			e.printStackTrace();
			Assert.assertFalse(false);
			log.info("Test Failed");
		}
	}
	
	
}
