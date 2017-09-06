package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.PageObjects;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A094 Business Event Manager Objects
 * Purpose              :   Create Supplier Elements 
 * ACCESS               :   XEA
 * Date					:   Modified on 08-May-2017
 */

public class A094_Business_Event_Manager_ObjectsTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	private PageObjects pObject = new PageObjects();
	
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("currencyCode");
		List<String> businessEvent1 = dataRow.findNamesReturnValues("businessEvent1");
		List<String> businessEvent2 = dataRow.findNamesReturnValues("businessEvent2");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Object List","Currency search page","displayed");
		
		addBusinessEvent(currencyPage,businessEvent1);
		addBusinessEvent(currencyPage,businessEvent2);
		
		currencyPage.logOut(2);

	}
	
	/*Create elements for Supplier*/
	private void addBusinessEvent(CurrencyPageNew currencyPage,List<String> businessEvent){
	
		String SuccMessage = "The previously-requested action has been performed";

		currencyPage.searchValue(businessEvent.get(0), 1, 0);
		
		currencyPage.clickOnEvents();
		
		WebElement Selection = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection);
        		
		currencyPage.searchValue(businessEvent.get(1), 2, 1);
		
		currencyPage.clickOnAmend();
		
		boolean update = currencyPage.selectNotification(businessEvent);
		
		if(update == true){
			currencyPage.clickOnUpdate();	
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New business event "+businessEvent.get(0), "created successfully");
			
		}
		else{
			
			testcases.add(getCurreentDate()+" | Pass : New business event "+businessEvent.get(0)+ "already updated");
			currencyPage.clickOnCancel();
			
		}
		
	
		currencyPage.clickOnCancel();
		
	}
	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "phase3.xml";
		String[] nodeID = { "A094" };
		String [] selectedNames = {"userName","passWord","currencyCode","businessEvent1","businessEvent2"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
