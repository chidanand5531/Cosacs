/**

* Project Name : COSAC

* Author : Chidanand

* Version : 10.5.2.2124

* Reviewed By : Vivek Bharti

* Date of Creation : March , 2020

* Modification History : 

*/

package com.cosacs.TestCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

public class COS02_ProductHierarchy extends BaseClass {

	//User Creates Product heirarchy
	@Test
	public  void create_prdthierarchy_Test() throws IOException {
		try {
			Library.Interaction.IsDisplayed_Click(Xpath.LocationCreation.merchandising);
			log.info("User Clicked on Merchandising");
			Library.Interaction.userWait();
			Library.Interaction.click((Xpath.productHierarchy.ProductHierarchy));
			log.info("User Clicked on Product Hierarchy");
			Library.Interaction.IsDisplayed(Xpath.productHierarchy.Heirarchylabel);
			String Heirarchylabel=Library.Interaction.getelementText(Xpath.productHierarchy.Heirarchylabel);
			Assert.assertEquals(Heirarchylabel,JsonParser.testData("ProductHeirarchy.pageLabel"));
			log.info("User validated Product Hierarchy Label successfully");
			Library.Interaction.CreateHeirarchy(Xpath.productHierarchy.DivOptions, Xpath.productHierarchy.CreateDivTag, JsonParser.testData("ProductHeirarchy.Dev"));
			Library.Interaction.click(Xpath.productHierarchy.DIvBTN);
			log.info("User clicked on Division save button");
			Library.Interaction.IsDisplayed(Xpath.productHierarchy.Message_catch);
			String text=Library.Interaction.verifyToastMessage(Xpath.productHierarchy.Message_catch);
			log.info("User Created Division successfully and Message is-->" +text);
			Library.Interaction.CreateHeirarchy(Xpath.productHierarchy.DeptOptions, Xpath.productHierarchy.CreateDepttag, JsonParser.testData("ProductHeirarchy.Dept"));
			Library.Interaction.click(Xpath.productHierarchy.DeptSaVeBTN);
			Library.Interaction.IsDisplayed(Xpath.productHierarchy.Message_catch);
			String text1=Library.Interaction.verifyToastMessage(Xpath.productHierarchy.Message_catch);
			log.info("User  Created Department successfully and Message is -->" +text1);
			Library.Interaction.CreateHeirarchy(Xpath.productHierarchy.ClassOptions, Xpath.productHierarchy.CreateClasstag, JsonParser.testData("ProductHeirarchy.Class"));
			Library.Interaction.click(Xpath.productHierarchy.ClassSaVeBTN);
			Library.Interaction.IsDisplayed(Xpath.productHierarchy.Message_catch);
			String text2=Library.Interaction.verifyToastMessage(Xpath.productHierarchy.Message_catch);
			log.info("User  Created Class successfully and Message is-->" +text2);
			log.info("User  Created Division,Department,Class successfully ");
			Library.Interaction.IsDisplayed_Click(Xpath.productHierarchy.merchandising);
			log.info("User Clicked on Merchandising");
			Library.Interaction.moveToElement(Xpath.productHierarchy.SearchMenu);
			Library.Interaction.IsDisplayed_Click(Xpath.productHierarchy.ProductEnquiry);
			Library.Interaction.IsDisplayed_Click(Xpath.productHierarchy.FirstLink);
			Library.Interaction.IsDisplayed(Xpath.productHierarchy.DivArrow);
			Library.Interaction.ScrollDownTill_ElementFound(Xpath.productHierarchy.DivArrow);
			Library.Interaction.selectSuggestions(Xpath.productHierarchy.DivArrow, Xpath.productHierarchy.Search, Xpath.productHierarchy.Select, JsonParser.testData("ProductHeirarchy.Dev"), JsonParser.testData("ProductHeirarchy.Dev"));
			Library.Interaction.IsDisplayed(Xpath.productHierarchy.Message_catch);
			Library.Interaction.click(Xpath.productHierarchy.Message_catch);
			log.info("New Division Updated");
/*			Library.Interaction.selectSuggestions(Xpath.productHierarchy.DivArrow, Xpath.productHierarchy.Search, Xpath.productHierarchy.Select, JsonParser.testData("ProductHeirarchy.Dept"), JsonParser.testData("ProductHeirarchy.Dept"));
			Library.Interaction.IsDisplayed(Xpath.productHierarchy.Message_catch);
			Library.Interaction.click(Xpath.productHierarchy.Message_catch);
			log.info("New Department Updated");
			Library.Interaction.selectSuggestions(Xpath.productHierarchy.DivArrow, Xpath.productHierarchy.Search, Xpath.productHierarchy.Select, JsonParser.testData("ProductHeirarchy.Class"), JsonParser.testData("ProductHeirarchy.Class"));
			log.info("New Class Updated");*/
			log.info("Product heirarchy created and Validated successfully");
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.info("Test Failed");
		}
     }
	

	
	
}
