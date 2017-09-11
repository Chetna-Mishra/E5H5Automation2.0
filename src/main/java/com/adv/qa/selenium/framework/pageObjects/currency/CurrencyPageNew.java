package com.adv.qa.selenium.framework.pageObjects.currency;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.adv.qa.selenium.framework.pageObjects.PageObjects;
import com.adv.qa.selenium.helpers.CalenderDateTime;
import com.adv.qa.selenium.helpers.WaitHelper;

public class CurrencyPageNew extends CurrencyPage{
	
	private PageObjects pObject = new PageObjects();
	private CalenderDateTime calender = new CalenderDateTime();
	
	private String message = "The specified key already exists";
	private String SuccMessage = "The previously-requested action has been performed";
	
	public CurrencyPageNew(EventFiringWebDriver driver) {
		super(driver);
	}
	
	/**
	 * Description : Click on expand action
	 */
	public void expandAction(){
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]")).click();
		WaitHelper.waitAdditional(2);
		clickOnExpandAndCollapse();
	}
	
	/**
	 * Description : Click on expand and close
	 */	
	/**
	 * Click on Address button
	 * @param i
	 */
	public void clickOnExpandAndCollapse(){
		log.info("Click on expand collapse button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Expand/Collapse")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	
	/*Click on new New Trans*/
	
	public void clickOnNewTransaction() {
		log.info("Click on New Trans button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().trim().equals("New Trans")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}	
	
	/*Click on new Transaction*/	
	
	public void clickOnTransaction() {
		log.info("Click on Transaction button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().trim().equals("Transaction")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	/*Click on new Transaction*/		
	public void clickOnSA() {
		log.info("Click on S/A button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().trim().equals("S/A")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(4);
	}
	
	/**
	 * Amend supplier address-A091A-PBA
	 * @param elements
	 */
	public void amendSupplierAddress(List<String> elements){
		log.info("Enter suppler address details");
		WaitHelper.waitAdditional(3);
		
		clickOnAddress();
		WaitHelper.waitAdditional(5);
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).clear();//Address line 1
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(1));//Address line 1
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);//Address line 1
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).clear();//Address line 2
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(2));//Address line 2
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.TAB);//Address line 2
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).clear();//Address line 3
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(3));//Address line 3
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(Keys.TAB);//Address line 3
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).clear();//Address line 4
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(4));//Address line 4
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(Keys.TAB);//Address line 4
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[8]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[8]/input")).sendKeys(Keys.TAB);//Address line 5
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[9]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[9]/input")).sendKeys(Keys.TAB);//Address line 6
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[10]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[10]/input")).sendKeys(Keys.TAB);//Post Code
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[11]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[11]/input")).sendKeys(Keys.TAB);//Telephone
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[12]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[12]/input")).sendKeys(Keys.TAB);//Telex
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[13]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[13]/input")).sendKeys(Keys.TAB);//Fax
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[14]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[14]/input")).clear();//Contact Name
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[14]/input")).sendKeys(elements.get(9));//Contact Name
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[14]/input")).sendKeys(Keys.ENTER);//Contact Name
			
		WaitHelper.waitAdditional(6);

	}
	
	/**
	 * Enter supplier elements A092-PBH
	 * @param elements 
	 */
	public boolean enterSupplierElements(List<String> elements){
		boolean update=false;
		log.info("Create supplier elements");
		WaitHelper.waitAdditional(1);
		
		
		enterSupplierElementDetails(elements.get(0),1);
		enterSupplierElementDetails(elements.get(1),2);
		enterSupplierElementDetails(elements.get(2),3);
		enterSupplierElementDetails(elements.get(3),4);
		WaitHelper.waitAdditional(1);
		
		if(!getErrorContentText().contains("Element already exists")){
			
			update= true;
		}
		
		return update;
		
		
	}

	/*Enter supplier elements*/
	private void enterSupplierElementDetails(String elements,int i){
		
		log.info("Enter supplier elements");
		WaitHelper.waitAdditional(5);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();//Element
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]/input")).sendKeys(elements);//Element
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();//Balance
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]/input")).sendKeys("Y");//Balance
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();//Turnover
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys("Y");//Turnover
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);//Turnover
		WaitHelper.waitAdditional(4);
		
		
		
	}

	/**
	 * Amend Transactional Legend details - A93-GAE
	 * @param elements
	 */
	public boolean amendTransactionLegendDetails(List<String> elements){
		log.info("Amend transaction legend details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		String Authorisation_Code = getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).getText();
		String Authorisation_Group = getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).getText();
		
		if(!(Authorisation_Code.equals(elements.get(2)) && Authorisation_Group.equals(elements.get(3)))){
			getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(elements.get(2));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(3));
			WaitHelper.waitAdditional(1);
			
			if(!(getDriver().findElement(By.xpath(pObject.A093_CHK_REV)).isSelected())){
				getDriver().findElement(By.xpath(pObject.A093_CHK_REV)).click();
			}
			update = true;
		}
		return update;
	}


	/**
	 * Click on Events : A094-XEA
	 */
	
	public void clickOnEvents(){
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Events button");
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_BTM_BUT_SECTION));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Events")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on Events : A094-XEA
	 */
	
	public boolean selectNotification(List<String> elements){
		log.info("Select notification value");
		boolean update = false;
			
		String selectedOption = new Select(getDriver().findElement(By.xpath(pObject.A094_NOTI))).getFirstSelectedOption().getText();
		
		if(!elements.get(2).equals(selectedOption))
				
			{
			
			getDriver().findElement(By.xpath(pObject.A094_NOTI)).sendKeys(elements.get(2));
			update = true;
		}
	
	WaitHelper.waitAdditional(1);
	return update;
}	


	
	/**
	 * Create program Event : A095-XEE
	 * @param elements
	 */
	
	public void createProgramEvent(List<String> program){
		log.info("Create program event");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A095_PRG)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A095_PRG)).sendKeys(program.get(0));//Program A095_PRG
		
		getDriver().findElement(By.xpath(pObject.A095_EVNT)).clear();
		getDriver().findElement(By.xpath(pObject.A095_EVNT)).sendKeys(program.get(1));//Program A095_EVNT
		getDriver().findElement(By.xpath(pObject.A095_PRG_EVT_HNDLER)).click();//pgm event = 1.Handler A095_PRG_EVT_HNDLER
		WaitHelper.waitAdditional(2);
			
	}

	
	/**
	 * Business Event Manager Action List : A096-XEG
	 */
	
	
	public boolean verifyManagerEvent(List<String> elements){
		log.info("Verify business event manager action");
		WaitHelper.waitAdditional(2);
		boolean action = false;
		
		//Multiple tab
		if(getDriver().findElement(By.xpath(pObject.A096_CHK_MULTI)).isSelected()){
			action = true;
		}
		
		ClickOnAnyTab("Email/DiaryText", 1);//Email/Diary text tab
		WaitHelper.waitAdditional(4);
		
		String substitution = getDriver().findElement(By.xpath(pObject.A096_SUBS_CHAR)).getText();//Substitution Character A096_SUBS_CHAR
		String messageLine1 = getDriver().findElement(By.xpath(pObject.A096_MSGLN1)).getText();//Message line 1 A096_MSGLN1
		String messageLine2 = getDriver().findElement(By.xpath(pObject.A096_MSGLN2)).getText();//Message line 2 A096_MSGLN2
		
		if(substitution.equals(elements.get(1)) && messageLine1.equals(elements.get(2)) && messageLine2.equals(elements.get(3))){
			action = true;
		}
		
		return action;
	}

	
	/**
	 * Create Stock code : A097
	 */
	
	public boolean createStockType(List<String> elements){
		log.info("In create stock type");
		WaitHelper.waitAdditional(2);
		
		boolean update=false;
		
		getDriver().findElement(By.xpath(pObject.A097_STK)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A097_STK)).sendKeys(elements.get(0));//Stock type A097_STK
		
		getDriver().findElement(By.xpath(pObject.A097_STK)).sendKeys(Keys.ENTER);//Stock type A097_STK
		
		if(!getErrorContentText().contains(message)){
			
				
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));//Description A002_DESCRIPTION
		
		
		update=true;
		
		}
		
		return update;
		
	}
	
	/**
	 * Item creations - A098
	 */	
	
	public boolean createItem(String companyId, List<String> elements,int i){
		log.info("In create item");
		boolean update=false;
		getDriver().findElement(By.xpath(pObject.A098_ITM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_ITM)).sendKeys(elements.get(0));//Item A098_ITM
		
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));//Description A002_DESCRIPTION
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(Keys.ENTER);
		
		if(!getErrorContentText().contains(message)){
	
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();
		ClickOnAnyTab("Primary Details", 1);
		log.info("On the Primary Details Tab");
		WaitHelper.waitAdditional(1);
		
		
		if(elements.get(2).equals("Stock")){
			getDriver().findElement(By.xpath(pObject.A098_CHK_STK_ITM)).click();//Stock Item A098_CHK_STK_ITM
		}
		else if(elements.get(2).equals("Generic")){
			getDriver().findElement(By.xpath(pObject.A098_CHK_GENER_ITM)).click();//Generic Item A098_CHK_GENER_ITM
		}
		else if(elements.get(2).equals("Service")){
			getDriver().findElement(By.xpath(pObject.A098_CHK_SRVIC_ITM)).click();//Service Item A098_CHK_SRVIC_ITM
		}
		
		if(!elements.get(3).equals("null")){
			getDriver().findElement(By.xpath(pObject.A098_STK_TYP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_STK_TYP)).sendKeys(elements.get(3));//Stock type A098_STK_TYP
		}
		if(!elements.get(4).equals("null")){
			getDriver().findElement(By.xpath(pObject.A098_UNIT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_UNIT)).sendKeys(elements.get(4));//Unit A098_UNIT
		}
		WaitHelper.waitAdditional(1);
		if(!elements.get(5).equals("null")){
			getDriver().findElement(By.xpath(pObject.A098_ISSU_UOM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_ISSU_UOM)).sendKeys(elements.get(5));//Issue Uom A098_ISSU_UOM
			WaitHelper.waitAdditional(1);
		}
		
		ClickOnAnyTab("Order Processing", 1);
		log.info("On the Order Processing Tab");
		WaitHelper.waitAdditional(4);
		

		if(!elements.get(6).equals("null")){
			getDriver().findElement(By.xpath(pObject.A098_RCPT_CNTRL)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_RCPT_CNTRL)).sendKeys(elements.get(6));//Receipt Control A098_RCPT_CNTRL
		}

		
		ClickOnAnyTab("Stops/Variance/CPV", 1);
		log.info("On the Stops/Variance/CPV Tab");
		WaitHelper.waitAdditional(3);
		
		
		if(elements.get(7).equals("1")){
			getDriver().findElement(By.xpath(pObject.A098_CHK_PUR_PRZ)).click();//purchase price A098_CHK_PUR_PRZ
		}
		if(!elements.get(8).equals("null")){
			getDriver().findElement(By.xpath(pObject.A098_PPV_ACCT_GRP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_PPV_ACCT_GRP)).sendKeys(companyId);//PPV account code A098_PPV_ACCT_GRP
		}
		
		ClickOnAnyTab("GL/Replacement", 1);
		log.info("On the GL/Replacement Tab");
		WaitHelper.waitAdditional(4);
		
		
		if(!elements.get(9).equals("null")){
			getDriver().findElement(By.xpath(pObject.A098_ACC)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_ACC)).sendKeys(elements.get(9));//Account A098_ACC
		}
		if(!elements.get(10).equals("null")){
			getDriver().findElement(By.xpath(pObject.A098_CST)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_CST)).sendKeys(elements.get(10));//Cost A098_CST
		}
		
		ClickOnAnyTab("Sales Invoicing", 1);
		log.info("On the Sales Invoicing Tab");
		WaitHelper.waitAdditional(3);
		
			
		if(!elements.get(11).equals("null")){
			//Purchasing Only
			getDriver().findElement(By.xpath(pObject.A098_USAGE)).sendKeys(elements.get(11));//Usage A098_USAGE
		}
			
		if(!elements.get(12).equals("null")){
			getDriver().findElement(By.xpath(pObject.A098_ACC1)).clear();
		
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_ACC1)).sendKeys(elements.get(12));//Account A098_ACC1
	
			getDriver().findElement(By.xpath(pObject.A098_CST1)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A098_CST1)).sendKeys(elements.get(13));//Cost  A098_CST1
		}
		
		if(i==1){
			clickOnSTDCost();
			WaitHelper.waitAdditional(5);
			
			if(!elements.get(14).equals("null"))
			
			{
				getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();//Effective date
				WaitHelper.waitAdditional(1.5);
				
				getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(String.valueOf(calender.Fromdate()));//Effective date

				WaitHelper.waitAdditional(1.5);
			}
			if(!elements.get(15).equals("null")){
				
				getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();//Standard cost
				WaitHelper.waitAdditional(1.5);
				getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(15));//Standard cost
				WaitHelper.waitAdditional(3);
			}
			
			ClickOnAnyButton("Item", 1);
			ClickOnAnyButton("Item", 1);
		}
		

		
		getDriver().findElement(By.xpath(pObject.A098_ITM)).sendKeys(Keys.ENTER);//Item A098_ITM
		WaitHelper.waitAdditional(2);

		clickOnAcceptWarnings();
		
		update = true;
		}
		return update;
		

	}	
	

	
	/**
	 * Description : Click on STD Cost
	 */	
	 
	public void clickOnSTDCost(){
		log.info("Click on STD Cost button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("STD Cost")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}	
	
	/**
	 * Create Manufacturer : A098A-PYE
	 */
	
	public  boolean createManufacturer(List<String> elements){
		log.info("In create Manufacturer");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A098_MANUF_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_MANUF_CD)).sendKeys(elements.get(0));//Manufacturer code A098_MANUF_CD
		getDriver().findElement(By.xpath(pObject.A098_MANUF_NM_)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_MANUF_NM_)).sendKeys(elements.get(1));//Manufacturer Name A098_MANUF_NM_
		getDriver().findElement(By.xpath(pObject.A098_MANUF_NM_)).sendKeys(Keys.ENTER);
		
		if(!getErrorContentText().contains(message)){
			update = true;
		}
		return update;
	}
	

	/**
	 * Create manufacturer item : A098A-PIV
	 * @param elements
	 */
	
	public boolean createManufacturerItem(List<String> elements){
		log.info("In create Manufacturer");
		WaitHelper.waitAdditional(2);
		
		boolean update= false;
	
		getDriver().findElement(By.xpath(pObject.A098_ITM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_ITM)).sendKeys(elements.get(0));//Item A098_ITM
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_MANUF_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_MANUF_CD)).sendKeys(elements.get(1));//Manufacturer A098_MANUF_CD
		getDriver().findElement(By.xpath(pObject.A098_MANUF_CD)).sendKeys(Keys.ENTER);
		
		if(!getErrorContentText().contains(message)){
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_PART_NO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_PART_NO)).sendKeys(elements.get(2));//Part number A098_PART_NO
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A098_EFF_DT)).clear();
		getDriver().findElement(By.xpath(pObject.A098_EFF_DT)).sendKeys(String.valueOf(calender.Fromdate()));//Effective from A098_EFF_DT
		
		getDriver().findElement(By.xpath(pObject.A098_CHK_DEF)).click();//Dafault A098_CHK_DEF
		WaitHelper.waitAdditional(2);
		
		update=true;
		
		}
		return update;
	}
		

	/**
	 * Click on supplier : A099
	 */
	public void clickOnSupplier(){
		log.info("Clicking on supplier button");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.SEVEN+pObject.LABEL)).click();
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Create Item supplier : A099-PIK
	 * @param elements
	 */
	
	public boolean createItemSupplier(List<String> elements){
		log.info("In create Item supplier");
		WaitHelper.waitAdditional(2);
		
		boolean update = false;
		
		getDriver().findElement(By.xpath(pObject.A098_ITM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_ITM)).sendKeys(elements.get(0));//Item A098_ITM
		
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(elements.get(1));//Supplier  A091_SUPP
		
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(Keys.ENTER);//Supplier  A091_SUPP
		
		if(!getErrorContentText().contains(message)){
		
		
		getDriver().findElement(By.xpath(pObject.A099_CATLG_DESCR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A099_CATLG_DESCR)).sendKeys(elements.get(2));//Catalogue Description A099_CATLG_DESCR
			
		getDriver().findElement(By.xpath(pObject.A099_MAX_QTY_LIMIT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A099_MAX_QTY_LIMIT)).sendKeys(elements.get(3));//Max quantity limit A099_MAX_QTY_LIMIT
		
		getDriver().findElement(By.xpath(pObject.A099_AVRG_LEAD_DD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A099_AVRG_LEAD_DD)).sendKeys(elements.get(4));//Average lead time A099_AVRG_LEAD_DD
		WaitHelper.waitAdditional(2);
		
		update = true;
		}
		
		return update;
	}
	

	
	/**
	 * Insert price type :A100-PXO
	 * @param priceType
	 * @param elements
	 * @return
	 */
	
	public boolean insertPriceType(String companyId, List<String> priceType){
		log.info("In price type method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A100_PRC_TYPE)).clear();//A099_PRC_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A100_PRC_TYPE)).sendKeys(companyId);//Price type A099_PRC_TYPE
		
		getDriver().findElement(By.xpath(pObject.A100_PRC_TYPE)).sendKeys(Keys.ENTER);//Price type A099_PRC_TYPE
		WaitHelper.waitAdditional(2);
		
		if(!getErrorContentText().contains(message)){
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(priceType.get(0));//Description A002_DESCRIPTION
			
			update = true;
		}
		return update;
	}	
	

	/**
	 * Insert Item price :A100-PIM
	 * @param elements
	 * @param priceType
	 * @return
	 */
	
	public boolean insertItemPrice(String companyId,List<String> elements){
		log.info("In item price method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A098_ITM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_ITM)).sendKeys(elements.get(0));//Item A098_ITM
		
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(elements.get(1));//Supplier A091_SUPP
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(Keys.ENTER);//Supplier A091_SUPP
		WaitHelper.waitAdditional(2);
		
		if(!getErrorContentText().contains(message)){
			getDriver().findElement(By.xpath(pObject.A100_PRC)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A100_PRC)).sendKeys(elements.get(2));//Price A099_PRC
			
			getDriver().findElement(By.xpath(pObject.A100_PRC_TYPE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A100_PRC_TYPE)).sendKeys(companyId);//Price type A099_PRC_TYPE
			
			getDriver().findElement(By.xpath(pObject.A100_QTY)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A100_QTY)).sendKeys(elements.get(3));//Quantity A099_QTY
			
			getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(elements.get(4));//Currency A002_CURRENCY
			
			getDriver().findElement(By.xpath(pObject.A100_EFF_DT_FRM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A100_EFF_DT_FRM)).sendKeys(String.valueOf(calender.Fromdate()));//Currency A100_EFF_DT_FRM
			
			getDriver().findElement(By.xpath(pObject.A100_EXP_DT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A100_EXP_DT)).sendKeys(String.valueOf(calender.TOdate()));//Currency A100_EXP_DT
			
			
			ClickOnAnyTab("UOM/Tax Details", 1);
			
			getDriver().findElement(By.xpath(pObject.A100_PUOM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A100_PUOM)).sendKeys(elements.get(5));//Price UOM A099_PUOM
			
			getDriver().findElement(By.xpath(pObject.A100_QUOM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A100_QUOM)).sendKeys(elements.get(6));//Quantity UOM A099_QUOM
			
			getDriver().findElement(By.xpath(pObject.A043_CODE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A043_CODE)).sendKeys(elements.get(7));//Code A043_CODE
			
			getDriver().findElement(By.xpath(pObject.A043_TX_TYPE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A043_TX_TYPE)).sendKeys(elements.get(8));//Type  A043_TX_TYPE
			
			getDriver().findElement(By.xpath(pObject.A043_LOC)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A043_LOC)).sendKeys(elements.get(9));//Location A043_LOC
			
			getDriver().findElement(By.xpath(pObject.A062_HAND)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A062_HAND)).sendKeys(elements.get(10));//Handling code A062_HAND

			update = true;			
		}
		return update;
	}	

	
	/**
	 * Insert Item buyer : A101-PIJ
	 */
	public boolean insertItemBuyer(List<String> elements){
	
		boolean update= false;
		log.info("In Item buyer method");
		WaitHelper.waitAdditional(2);
	
	
		getDriver().findElement(By.xpath(pObject.A098_ITM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_ITM)).sendKeys(elements.get(0));//Item A098_ITM
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A081_BUYER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A081_BUYER)).sendKeys(elements.get(1));//Buyer A081_BUYER
	
		getDriver().findElement(By.xpath(pObject.A081_BUYER)).sendKeys(Keys.ENTER);//Buyer A081_BUYER
	
		if (!getErrorContentText().contains(message))
		{
	
		getDriver().findElement(By.xpath(pObject.A098_CHK_DEF)).click();//Default check box A098_CHK_DEF
		WaitHelper.waitAdditional(2);
	
		update=true;
		}
	
	return update;
}	
	
	/**
	 * Amend ICA trading relationship : A102-AKI
	 * @param elements
	 */
	
	public boolean amendICATradingRelationship(List<String> elements){
		log.info("In ICA trading relationship method");
		WaitHelper.waitAdditional(2);
		
		boolean update=false;
		
		getDriver().findElement(By.xpath(pObject.A102_ACC_PAY_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_ACC_PAY_ACC)).sendKeys(elements.get(0));//Accounts payable A102_ACC_PAY_ACC
		
		getDriver().findElement(By.xpath(pObject.A102_ACC_PAY_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_ACC_PAY_CST)).sendKeys(elements.get(1));//Accounts payable A102_ACC_PAY_CST

		getDriver().findElement(By.xpath(pObject.A102_COM_PUR_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_COM_PUR_ACC)).sendKeys(elements.get(2));//Common purchasing	 A102_COM_PUR_ACC
		
		getDriver().findElement(By.xpath(pObject.A102_COM_PUR_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_COM_PUR_CST)).sendKeys(elements.get(3));//Common purchasing A102_COM_PUR_CST

		getDriver().findElement(By.xpath(pObject.A102_PUR_MNGT_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_PUR_MNGT_ACC)).sendKeys(elements.get(4));//Purchasing mgmt	A102_PUR_MNGT_ACC
		
		getDriver().findElement(By.xpath(pObject.A102_PUR_MNGT_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_PUR_MNGT_CST)).sendKeys(elements.get(5));//Purchasing mgmt A102_PUR_MNGT_CST

		getDriver().findElement(By.xpath(pObject.A102_FXD__ASST_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_FXD__ASST_ACC)).sendKeys(elements.get(6));//Fixed assets A102_FXD__ASST_ACC
		
		getDriver().findElement(By.xpath(pObject.A102_FXD__ASST_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_FXD__ASST_CST)).sendKeys(elements.get(7));//Fixed assets  A102_FXD__ASST_CST
		
		getDriver().findElement(By.xpath(pObject.A102_INV_MNGT_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_INV_MNGT_ACC)).sendKeys(elements.get(8));//Inventory mgmt A102_INV_MNGT_ACC
		
		getDriver().findElement(By.xpath(pObject.A102_INV_MNGT_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A102_INV_MNGT_CST)).sendKeys(elements.get(9));//Inventory mgmt A102_INV_MNGT_CST
		getDriver().findElement(By.xpath(pObject.A102_INV_MNGT_CST)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
		
		clickOnUpdateWarnings();
		  
		clickOnUpdate();
		
		
		if (getErrorContentText().contains(SuccMessage))
		{
			update =true;	
			
		}
		
		return update;
	}	
	

	
	/**
	 * Insert IM Control accounts : A103-HAG
	 */
	public boolean insertImControl(List<String> elements){
		
		boolean update=false;
		log.info("Inside IM control accounts method");
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A103_ACC_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_ACC_CD)).sendKeys(elements.get(0));//Account code A103_ACC_CD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_ACC_CD)).sendKeys(Keys.ENTER);//Account code A103_ACC_CD
		
		if (!getErrorContentText().contains(message))
			
		{
		getDriver().findElement(By.xpath(pObject.A103_CD_DESC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_CD_DESC)).sendKeys(elements.get(1));//Description A103_CD_DESC
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A103_STK_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_STK_ACC)).sendKeys(elements.get(2));//Accounts payable	A103_STK_ACC
		
		getDriver().findElement(By.xpath(pObject.A103_STK_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_STK_CST)).sendKeys(elements.get(3));//Accounts payable A103_STK_CST

		getDriver().findElement(By.xpath(pObject.A103_REVCST_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_REVCST_ACC)).sendKeys(elements.get(4));//Accounts payable	 A103_REVCST_ACC	
		
		getDriver().findElement(By.xpath(pObject.A103_REVCST_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_REVCST_CST)).sendKeys(elements.get(5));//Accounts payable A103_REVCST_CST

		
		getDriver().findElement(By.xpath(pObject.A103_REV_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_REV_ACC)).sendKeys(elements.get(6));//Accounts payable	A103_REV_ACC	
		
		getDriver().findElement(By.xpath(pObject.A103_REV_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_REV_CST)).sendKeys(elements.get(7));//Accounts payable A103_REV_CST
	
		getDriver().findElement(By.xpath(pObject.A103_SUNDEB_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_SUNDEB_ACC)).sendKeys(elements.get(8));//Accounts payable A103_SUNDEB_ACC
		
		getDriver().findElement(By.xpath(pObject.A103_SUNDEB_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_SUNDEB_CST)).sendKeys(elements.get(9));//Accounts payable A103_SUNDEB_CST
		
		
		getDriver().findElement(By.xpath(pObject.A103_STKREV_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_STKREV_ACC)).sendKeys(elements.get(10));//Accounts payable	A103_STKREV_ACC
		
		getDriver().findElement(By.xpath(pObject.A103_STKREV_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_STKREV_CST)).sendKeys(elements.get(11));//Accounts payable A103_STKREV_CST
	
		
		getDriver().findElement(By.xpath(pObject.A103_RETSUPP_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_RETSUPP_ACC)).sendKeys(elements.get(12));//Accounts payable	A103_RETSUPP_ACC
		
		getDriver().findElement(By.xpath(pObject.A103_RETSUPP_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_RETSUPP_CST)).sendKeys(elements.get(13));//Accounts payable A103_RETSUPP_CST
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyTab("Default Movement Accounts", 1);
		WaitHelper.waitAdditional(4);
		
		getDriver().findElement(By.xpath(pObject.A103_MATISS_ACC)).clear(); 
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_MATISS_ACC)).sendKeys(elements.get(14));//Accounts payable A103_MATISS_ACC
		
		getDriver().findElement(By.xpath(pObject.A103_MATISS_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_MATISS_CST)).sendKeys(elements.get(15));//Accounts payable A103_MATISS_CST

		getDriver().findElement(By.xpath(pObject.A103_STKADJ_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_STKADJ_ACC)).sendKeys(elements.get(16));//Accounts payable A103_STKADJ_ACC
		
		getDriver().findElement(By.xpath(pObject.A103_STKADJ_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_STKADJ_CST)).sendKeys(elements.get(17));//Accounts payable A103_STKADJ_CST

		getDriver().findElement(By.xpath(pObject.A103_STKDIS_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_STKDIS_ACC)).sendKeys(elements.get(18));//Accounts payable A103_STKDIS_ACC
		
		getDriver().findElement(By.xpath(pObject.A103_STKDIS_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_STKDIS_CST)).sendKeys(elements.get(19));//Accounts payable A103_STKDIS_CST

		getDriver().findElement(By.xpath(pObject.A103_RETSTR_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_RETSTR_ACC)).sendKeys(elements.get(20));//Accounts payable A103_RETSTR_ACC
		
		getDriver().findElement(By.xpath(pObject.A103_RETSTR_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A103_RETSTR_CST)).sendKeys(elements.get(21));//Accounts payable A103_RETSTR_CST
		getDriver().findElement(By.xpath(pObject.A103_RETSTR_CST)).sendKeys(Keys.ENTER);//Accounts payable

		WaitHelper.waitAdditional(2);
		
		update = true;
		}
	
		return update;
	}
	
	/**
	 * Insert IM company control : A104-HAA
	 */
	public boolean insertIMCompanyControl(String companyName,List<String> elements){
		boolean update=false;
		log.info("In IM company control method");
		
		WaitHelper.waitAdditional(2);
		
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),getDriver().findElement(By.xpath(pObject.A006_COMPANY)));//Chetna Wait Added
		
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);//Company name A006_COMPANY
		
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(Keys.ENTER);//Company name A006_COMPANY
		
		if (!getErrorContentText().contains(message))
		{
		
		getDriver().findElement(By.xpath(pObject.A049_GL_HOld_CMPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A049_GL_HOld_CMPY)).sendKeys(companyName);//Company name A049_GL_HOld_CMPY
		
		getDriver().findElement(By.xpath(pObject.A104_GL_PER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_GL_PER)).sendKeys(elements.get(0));//Month A104_GL_PER

		getDriver().findElement(By.xpath(pObject.A104_GL_YY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_GL_YY)).sendKeys(String.valueOf(calender.fromyear()));//YEAR from  A104_GL_YY
		
		getDriver().findElement(By.xpath(pObject.A104_ACC_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_ACC_CD)).sendKeys(elements.get(2));//Account code A104_ACC_CD

		getDriver().findElement(By.xpath(pObject.A104_DEF_BTCH_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_DEF_BTCH_TYPE)).sendKeys(elements.get(3));//Default batch type A104_DEF_BTCH_TYPE

		getDriver().findElement(By.xpath(pObject.A104_RETAIN_TRAN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_RETAIN_TRAN)).sendKeys(elements.get(4));//Retain trans history  A104_RETAIN_TRAN

		getDriver().findElement(By.xpath(pObject.A104_UOM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_UOM)).sendKeys(elements.get(5));//UOM A104_UOM

		
		getDriver().findElement(By.xpath(pObject.A104_RETAIN_DOC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_RETAIN_DOC)).sendKeys(elements.get(6));//Retain doc history A104_RETAIN_DOC

		getDriver().findElement(By.xpath(pObject.A104_UOM1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_UOM1)).sendKeys(elements.get(7));//UOM A104_UOM1
		
		
		ClickOnAnyTab("Stock Valuation", 1);
		log.info("On the Stock Valuation Tab");
		WaitHelper.waitAdditional(4);
		
		getDriver().findElement(By.xpath(pObject.A104_PER_ISSUE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_PER_ISSUE)).sendKeys(elements.get(8));//% of issue A104_PER_ISSUE

		getDriver().findElement(By.xpath(pObject.A104_FXD_AMT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_FXD_AMT)).sendKeys(elements.get(9));//Fixed amount A104_FXD_AMT

		getDriver().findElement(By.xpath(pObject.A104_CHK_ALLWISS_PRCOVR)).click();//Allow issue price override A104_CHK_ALLWISS_PRCOVR
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A104_FIFO)).click();//FIFO A104_FIFO
		WaitHelper.waitAdditional(1);
			
		getDriver().findElement(By.xpath(pObject.A104_LOP)).click();//Last order price A104_LOP
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyTab("Numbering", 1);
		log.info("On the Numbering Tab");
		WaitHelper.waitAdditional(4);

				
		getDriver().findElement(By.xpath(pObject.A104_CHK_US_REQ)).click();//Use requisition A104_CHK_US_REQ
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_CHK_US_PICLST)).click();//Use picking lists A104_CHK_US_PICLST
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_CHK_COM_NUM)).click();//Company numbering A104_CHK_COM_NUM
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A104_NUM_LEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_NUM_LEN)).sendKeys(elements.get(10));//Number length A104_NUM_LEN

		getDriver().findElement(By.xpath(pObject.A104_NXT_NUM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_NXT_NUM)).sendKeys(elements.get(11));//Next number A104_NXT_NUM

		ClickOnAnyTab("Defaults", 1);
		log.info("On the Defaults Tab");
		WaitHelper.waitAdditional(4);
		
		getDriver().findElement(By.xpath(pObject.A104_MAT_ISSUE)).sendKeys(elements.get(12));//Mat number A104_MAT_ISSUE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_ADJ_IN)).sendKeys(elements.get(12));//ADJ IN number A104_ADJ_IN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_ADJ_OUT)).sendKeys(elements.get(12));// number A104_ADJ_OUT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_STK_DISP)).sendKeys(elements.get(12));//Next number A104_STK_DISP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_RET_STOR)).sendKeys(elements.get(12));//Next number A104_RET_STOR
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_STOR_TRANSF)).sendKeys(elements.get(12));//Next number A104_STOR_TRANSF
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_BIN_TRANSF)).sendKeys(elements.get(12));//Next number	A104_BIN_TRANSF
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_PICK_LIST)).sendKeys(elements.get(12));//Next number A104_PICK_LIST
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_STK_TK)).sendKeys(elements.get(12));//Next number A104_STK_TK
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyTab("Batch Types", 1);
		log.info("On the Batch Types Tab");
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FIFTH_TAB)).click();//Batch types tab
		WaitHelper.waitAdditional(4);
		
		getDriver().findElement(By.xpath(pObject.A104_MAT_ISSUE1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_MAT_ISSUE1)).sendKeys(elements.get(13));//Material issue A104_MAT_ISSUE1
		
		getDriver().findElement(By.xpath(pObject.A104_ADJ_IN1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_ADJ_IN1)).sendKeys(elements.get(14));//Adjustment in  A104_ADJ_IN1
		
		getDriver().findElement(By.xpath(pObject.A104_ADJ_OUT1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_ADJ_OUT1)).sendKeys(elements.get(15));//Adjustment out A104_ADJ_OUT1

		getDriver().findElement(By.xpath(pObject.A104_STK_DISP1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_STK_DISP1)).sendKeys(elements.get(16));//Stock disposal A104_STK_DISP1

		getDriver().findElement(By.xpath(pObject.A104_RET_STOR1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_RET_STOR1)).sendKeys(elements.get(17));//Return to store A104_RET_STOR1

		getDriver().findElement(By.xpath(pObject.A104_STOR_TRANSF1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_STOR_TRANSF1)).sendKeys(elements.get(18));//Store transfer A104_STOR_TRANSF1

		getDriver().findElement(By.xpath(pObject.A104_RET_SUPP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_RET_SUPP)).sendKeys(elements.get(19));//Return to supplier A104_RET_SUPP

		getDriver().findElement(By.xpath(pObject.A104_RCOST_VAR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_RCOST_VAR)).sendKeys(elements.get(20));//Revised cost variance A104_RCOST_VAR

		getDriver().findElement(By.xpath(pObject.A104_SCOST_REV)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_SCOST_REV)).sendKeys(elements.get(21));//Standard cost reevaluation A104_SCOST_REV
		getDriver().findElement(By.xpath(pObject.A104_SCOST_REV)).sendKeys(Keys.ENTER);//Standard cost reevaluation
		WaitHelper.waitAdditional(4);
		
		update=true;
		}
		
		return update;
		
	}	

	
	/************************************************************
	 * Insert new Inventory store controls : A106 :  HAD/HAC
	 * 
	 * **********************************************************/
	
	public boolean insertInventoryStore(List<String> elements){
		
		boolean update=false;
		log.info("In Inventory store control method");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A106_STORE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(elements.get(0));//Store A106_STORE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(Keys.ENTER);//Store A106_STORE
		WaitHelper.waitAdditional(2);
		
		if (!getErrorContentText().contains(message))
		{
		
		getDriver().findElement(By.xpath(pObject.A106_STD_STORE)).click();//Standard store A106_STD_STORE
		
		if(elements.get(18).equals(1)){
			getDriver().findElement(By.xpath(pObject.A104_CHK_US_REQ)).click();//Use requisitions A104_CHK_US_REQ
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A104_CHK_US_PICLST)).click();//Use picking lists A104_CHK_US_PICLST
			WaitHelper.waitAdditional(1);
		}
		
		getDriver().findElement(By.xpath(pObject.A104_ACC_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_ACC_CD)).sendKeys(elements.get(1));//Account code A104_ACC_CD

		getDriver().findElement(By.xpath(pObject.A040_BTZ_ELE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_BTZ_ELE)).sendKeys(elements.get(2));//BTZ element  A040_BTZ_ELE

		getDriver().findElement(By.xpath(pObject.A104_RETAIN_TRAN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_RETAIN_TRAN)).sendKeys(elements.get(3));//Retain trans period A104_RETAIN_TRAN

		getDriver().findElement(By.xpath(pObject.A104_UOM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_UOM)).sendKeys(elements.get(4));//UOM A104_UOM

		getDriver().findElement(By.xpath(pObject.A104_RETAIN_DOC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_RETAIN_DOC)).sendKeys(elements.get(5));//Retain document history A104_RETAIN_DOC

		getDriver().findElement(By.xpath(pObject.A104_UOM1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_UOM1)).sendKeys(elements.get(6));//UOM A104_UOM1
		
		ClickOnAnyTab("Stock Valuation", 1);
		log.info("On the Stock Valuation");
		WaitHelper.waitAdditional(4);
		
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Stock valuation tab
		
		getDriver().findElement(By.xpath(pObject.A106_FIFO1)).click();//FIFO A106_FIFO1
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_LOP)).click();//Last order price A104_LOP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_SUP_FRM_PUR)).click();//Supply from purchasing  A106_SUP_FRM_PUR
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A104_PER_ISSUE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_PER_ISSUE)).sendKeys(elements.get(7));//% of issue A104_PER_ISSUE

		getDriver().findElement(By.xpath(pObject.A104_FXD_AMT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A104_FXD_AMT)).sendKeys(elements.get(8));//Fixed amount A104_FXD_AMT

		getDriver().findElement(By.xpath(pObject.A106_CHK_ISS_PRCOVR)).click();//Issue price override A106_CHK_ISS_PRCOVR
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyTab("Defaults", 1);
		log.info("On the Defaults");
		WaitHelper.waitAdditional(4);
		
		getDriver().findElement(By.xpath(pObject.A106_MAT_ISSUE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_MAT_ISSUE)).sendKeys(elements.get(9));//Material issue A106_MAT_ISSUE

		getDriver().findElement(By.xpath(pObject.A106_ADJ_IN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_ADJ_IN)).sendKeys(elements.get(10));//Adjustment in  A106_ADJ_IN
		
		getDriver().findElement(By.xpath(pObject.A106_ADJ_OUT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_ADJ_OUT)).sendKeys(elements.get(11));//Adjustment out  A106_ADJ_OUT

		getDriver().findElement(By.xpath(pObject.A106_STK_DISP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STK_DISP)).sendKeys(elements.get(12));//Stock disposal  A106_STK_DISP

		getDriver().findElement(By.xpath(pObject.A106_RET_STOR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_RET_STOR)).sendKeys(elements.get(13));//Return to store A106_RET_STOR

		getDriver().findElement(By.xpath(pObject.A106_STOR_TRANSF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STOR_TRANSF)).sendKeys(elements.get(14));//Store transfer A106_STOR_TRANSF
		
		getDriver().findElement(By.xpath(pObject.A106_BIN_TRANSF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_BIN_TRANSF)).sendKeys(elements.get(15));//Bin transfer A106_BIN_TRANSF
		
		getDriver().findElement(By.xpath(pObject.A106_PICK_LIST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_PICK_LIST)).sendKeys(elements.get(16));//Picking list  A106_PICK_LIST

		getDriver().findElement(By.xpath(pObject.A106_STK_TK)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STK_TK)).sendKeys(elements.get(17));//Stock take A106_STK_TK
		
		getDriver().findElement(By.xpath(pObject.A106_LOT_CNT_ALL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_LOT_CNT_ALL)).sendKeys(elements.get(19));//Lot Container Allocation A106_LOT_CNT_ALL
		

		getDriver().findElement(By.xpath(pObject.A106_CHK_MAT_ISSUE)).click();//Imm print A106_CHK_MAT_ISSUE
		
		getDriver().findElement(By.xpath(pObject.A106_CHK_ADJ_IN)).click();//Imm print A106_CHK_ADJ_IN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_CHK_ADJ_OUT)).click();//Imm print A106_CHK_ADJ_OUT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_CHK_STK_DISP)).click();//Imm print A106_CHK_STK_DISP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_CHK_RET_STOR)).click();//Imm print A106_CHK_RET_STOR
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_CHK_STOR_TRANSF)).click();//Imm print A106_CHK_STOR_TRANSF
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_CHK_BIN_TRANSF)).click();//Imm print A106_CHK_BIN_TRANSF
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_CHK_LOT_CNT_ALL)).click();//Imm print A106_CHK_LOT_CNT_ALL
		
		WaitHelper.waitAdditional(3);
		
		update =true;
		}
		
		return update;
	}
	
	
	/* Create transit store : A106*/
	
	
	public boolean createTransitStore(List<String> elements){
		log.info("In transit store method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A106_IN_TRNST)).click();//In transit store A106_IN_TRNST
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STORE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(elements.get(0));//Store A106_STORE
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(Keys.ENTER);//Store
		WaitHelper.waitAdditional(1);
		
		if(!getErrorContentText().contains(message)){
			
			getDriver().findElement(By.xpath(pObject.A104_ACC_CD)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A104_ACC_CD)).sendKeys(elements.get(1));//Account code A104_ACC_CD
			
			update = true;
				}
		
			return update;		
		}	
	
	
	/* Update EAST store for : AD02001*/
	
	public void updateInventoryStore(){
		log.info("In Inventory store control method");
		WaitHelper.waitAdditional(2);
		
		ClickOnAnyTab("GL/Archiving", 1);
		WaitHelper.waitAdditional(2);
		
		if((getDriver().findElement(By.xpath(pObject.A104_CHK_US_REQ)).isSelected()))
		{
			getDriver().findElement(By.xpath(pObject.A104_CHK_US_REQ)).click();//Use requisitions A104_CHK_US_REQ
			WaitHelper.waitAdditional(1);
		}
		
		if((getDriver().findElement(By.xpath(pObject.A104_CHK_US_PICLST)).isSelected()))
		{
			getDriver().findElement(By.xpath(pObject.A104_CHK_US_PICLST)).click();//Use picking lists A104_CHK_US_PICLST
			WaitHelper.waitAdditional(1);
		}
		
	}
	
	
	
	
	
	
	/**
	 * Insert stores hierarchy : A107-HAI
	 */
	
	public boolean createStoresHierarchy(List<String> elements){
		log.info("In stores hierarchy method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A106_STORE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(elements.get(0)); //Store A106_STORE
		
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
		
		if(!getErrorContentText().contains(message)){
			getDriver().findElement(By.xpath(pObject.A107_NW_PAR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A107_NW_PAR)).sendKeys(elements.get(1));//A107_NW_PAR
			
			getDriver().findElement(By.xpath(pObject.A107_LD_TM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A107_LD_TM)).sendKeys(elements.get(2));//A107_LD_TM
	
			getDriver().findElement(By.xpath(pObject.A107_LD_TM_UOM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A107_LD_TM_UOM)).sendKeys(elements.get(3));//A107_LD_TM_UOM
			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}
	
	/**
	 * Insert IM Item/Store controls : A108-HAE
	 * 
	 */
	
	public boolean insertItemStoreControl(List<String> elements){
		log.info("In IM item store controld method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A098_ITM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A098_ITM)).sendKeys(elements.get(0));//Item A098_ITM
		
		getDriver().findElement(By.xpath(pObject.A106_STORE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(elements.get(1));//Store A106_STORE 
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(Keys.ENTER);//Store A106_STORE
		WaitHelper.waitAdditional(2);
		
		if(!getErrorContentText().contains(message)){

			ClickOnAnyTab("General/On costs",1);

			getDriver().findElement(By.xpath(pObject.A108_DFLT_BIN)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A108_DFLT_BIN)).sendKeys(elements.get(2));//Default bin A108_DFLT_BIN
			
			getDriver().findElement(By.xpath(pObject.A104_PER_ISSUE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A104_PER_ISSUE)).sendKeys(elements.get(3));//% of issue A104_PER_ISSUE
			
			getDriver().findElement(By.xpath(pObject.A108_FD_CST)).clear();//A108_FD_CST
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A108_FD_CST)).sendKeys(elements.get(4));//Fixed costs  A108_FD_CST
			
			if(!getDriver().findElement(By.xpath(pObject.A106_CHK_ISS_PRCOVR)).isSelected()){
				getDriver().findElement(By.xpath(pObject.A106_CHK_ISS_PRCOVR)).click();//Issue price override A106_CHK_ISS_PRCOVR
			}
			
			ClickOnAnyTab("Controls/Valuation", 1);
			
			getDriver().findElement(By.xpath(pObject.A108_SUP_FRM_PUR)).click();//Supply from purc A108_SUP_FRM_PUR
	
			
			getDriver().findElement(By.xpath(pObject.A107_LD_TM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A107_LD_TM)).sendKeys(elements.get(6));//Lead time A107_LD_TM
			
			getDriver().findElement(By.xpath(pObject.A107_LD_TM_UOM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A107_LD_TM_UOM)).sendKeys(elements.get(7));//Lead time UOM A107_LD_TM_UOM
			
			getDriver().findElement(By.xpath(pObject.A108_REORDR_LVL)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A108_REORDR_LVL)).sendKeys(elements.get(8));//Re-order level A108_REORDR_LVL

			getDriver().findElement(By.xpath(pObject.A108_REORDR_QTY)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A108_REORDR_QTY)).sendKeys(elements.get(9));//Re-order quantity A108_REORDR_QTY
			
			if(elements.get(10).equals("2"))
				
			{
				getDriver().findElement(By.xpath(pObject.A108_FIFO)).click();//FIFO A108_FIFO
				
				}
				
			if(elements.get(11).equals("1"))
				
			{
				getDriver().findElement(By.xpath(pObject.A104_LOP)).click();//LOP A104_LOP
				
				}
			
			else if(elements.get(11).equals("2"))
			{
				getDriver().findElement(By.xpath(pObject.A108_LIP)).click();//LOP A108_LIP
				
				}
			
			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}	
	
	
	
	
	/**
	 * Amend control accounts : A109-ECI, ECJ
	 */
	
	public void amendControlAccounts(List<String> elements){
		log.info("In Amend control accounts method");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A109_ACC_APY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A109_ACC_APY)).sendKeys(elements.get(1));//Accounts payable A109_ACC_APY
		
		getDriver().findElement(By.xpath(pObject.A109_COM_PUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A109_COM_PUR)).sendKeys(elements.get(2));//Common purchasing A109_COM_PUR

		getDriver().findElement(By.xpath(pObject.A109_PUR_MNGT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A109_PUR_MNGT)).sendKeys(elements.get(3));//Purchasing management A109_PUR_MNGT

		getDriver().findElement(By.xpath(pObject.A109_INV_MNGT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A109_INV_MNGT)).sendKeys(elements.get(4));//Inventory management A109_INV_MNGT

		WaitHelper.waitAdditional(2);
	}
		

	/**
	 * Insert security range : A110-ADI
	 */
	
	public void insertSecurityRange(List<String> elements){
		log.info("In Insert security range method");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A110_RNGE_LST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A110_RNGE_LST)).sendKeys(elements.get(0));//Range list code A110_RNGE_LST

		
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));//Description A002_DESCRIPTION

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A110_SYS)).sendKeys(elements.get(2));//System A110_SYS
		getDriver().findElement(By.xpath(pObject.A110_SYS)).sendKeys(elements.get(2));//
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A110_ID)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A110_ID)).sendKeys(elements.get(3));//Code Id A110_ID
		WaitHelper.waitAdditional(2);
			
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();//From value
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(4));//From value
		
		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();//To value
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(5));//To value
		WaitHelper.waitAdditional(3);
		
	}	

	
	/**
	 * Search security range - A110-ADH
	 * @param valueList
	 * @param i = button ID Position
	 * @param j = fields ID Position
	 *
	 * Chetna Dt: 16-May-2017
	 */
	
	public void searchsecurityrange(String companyId,List<String> elements){
		WaitHelper.waitAdditional(2);
		if(!ClickOnAnyButton("OK", 0))

		{
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).sendKeys(companyId);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A110_SYS_SEAR)).sendKeys(elements.get(2));//System A110_SYS_SEAR
		getDriver().findElement(By.xpath(pObject.A110_SYS_SEAR)).sendKeys(elements.get(2));//
		WaitHelper.waitAdditional(2);
		
		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);
		
	}
	
	
	/**
	 * Create security groups : A111-ADA
	 */
	public boolean insertSecurityGroup(List<String> elements){
		log.info("In security group method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).sendKeys(elements.get(0));// A011_NON_CMPNY
		
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).sendKeys(Keys.ENTER);
		
		if(!getErrorContentText().contains(message)){
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));//A002_DESCRIPTION
			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}
	
	/**
	 * Click on Denial button
	 */
	
	public void clickOnDenials(){
		log.info("In click on denials method");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Denials")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Select deny all check box
	 */
	public void selectDenyAll(){
		log.info("Click on Deny all");
		WaitHelper.waitAdditional(1);
		if(!getDriver().findElement(By.xpath(pObject.A111_CHK_DEN_Al)).isSelected()){
			getDriver().findElement(By.xpath(pObject.A111_CHK_DEN_Al)).click();//A111_CHK_DEN_Al 
		}
		WaitHelper.waitAdditional(1);
	}	

	
	/**
	 * Verify selection of Deny all
	 * @return
	 */
	public boolean verifyDenyAll(){		
		WaitHelper.waitAdditional(1);
		return driver.findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).getText().contains("Y");
	}
	
	/**
	 * Create users for security - A112-AFE
	 * @param elements
	 * @param companyId
	 * @return
	 */

	public boolean insertUserCompany(List<String> elements,String companyId){
		log.info("In insert company method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A011_USER1)).clear(); 
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_USER1)).sendKeys(elements.get(0));//User A011_USER1
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyId);//Company A006_COMPANY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(Keys.ENTER);//Company A006_COMPANY
		
		if(!getErrorContentText().contains(message)){
			getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).sendKeys(elements.get(1));//Security group A011_NON_CMPNY
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A011_REPORT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A011_REPORT)).sendKeys(elements.get(1));//Report security A011_REPORT
			WaitHelper.waitAdditional(1);
			update = true;
		}
		return update;
	}

	
	/**
	 * Insert Access code : A113-ADJ
	 * @param elements
	 */
	
	public void insertAccessCode(List<String> elements){
		log.info("In access code method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A110_SYS)).sendKeys(elements.get(2));//A110_SYS
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A113_ACCS_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A113_ACCS_CD)).sendKeys(elements.get(0));//Access code A113_ACCS_CD
		
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));//Description A002_DESCRIPTION
		
		getDriver().findElement(By.xpath(pObject.A113_ACCS_DATA)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A113_ACCS_DATA)).sendKeys(elements.get(3));//Access code expression A113_ACCS_DATA
		WaitHelper.waitAdditional(2);		
	}	
	
	
	/**
	 * Insert security group access code : A114
	 * @param elements
	 */
	
	public void insertSecurityGroupAccessCode(List<String> elements){
		log.info("In Security group access code");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A110_SYS)).sendKeys(elements.get(2));//System A110_SYS
		
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).clear();
		WaitHelper.waitAdditional(1); 
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).sendKeys(elements.get(0));//Security group A011_NON_CMPNY
		
		getDriver().findElement(By.xpath(pObject.A114_UPDT_ACCS)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A114_UPDT_ACCS)).sendKeys(elements.get(1));//Update access code A114_UPDT_ACCS
		
		getDriver().findElement(By.xpath(pObject.A114_ENQ_ACCS)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A114_ENQ_ACCS)).sendKeys(elements.get(3));//Enquire access code A114_ENQ_ACCS
		WaitHelper.waitAdditional(1);
	}


	/**
	 * Create security groups : A115-ADB
	 */
	public boolean createSecurityGroup(List<String> elements){
		log.info("In security group method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).sendKeys(elements.get(0));// A011_NON_CMPNY
		
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).sendKeys(Keys.ENTER);
		
		if(!getErrorContentText().contains(message)){
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));//A002_DESCRIPTION
			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}
	
	
	/**
	 * Click on Deny all
	 * @param i
	 * @return
	 */
	public boolean clickOnDenyAll()	
	{
		boolean update = false;
		log.info("In click on deny all method");
		if(!getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.SIX)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.SIX)).click();
			update = true;
		}
		return update;
	}
	
	/**
	 * Insert range code : A115 : ADH
	 * @param elements
	 * @return
	 */
	public boolean createRangeListCode(List<String> elements){
		log.info("In create range list code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(1));//Range list code		
			
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(2));//Description
	
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(0));//System
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(0));//System
			
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(Keys.ENTER);//Code id
		if(!getToolContentText().contains(message)){
				
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(3));//Code id
	
			WaitHelper.waitAdditional(2);
			Actions builder = new Actions(driver);
			
			/*Balance class field*/
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click().sendKeys(elements.get(4)).build().perform();//From value
			WaitHelper.waitAdditional(2);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[3]"))).click().sendKeys(elements.get(5)).build().perform();//To value
			WaitHelper.waitAdditional(2);
			update = true;
		}
		return update;
	}
	
	/**
	 * Create access code : A115 :ADJ
	 * @param elements
	 * @return
	 */
	public boolean createAccessCode(List<String> elements){
		log.info("In create access code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//System
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//System
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Access code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(Keys.ENTER);//Access code
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Description
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(3));//Access code
			WaitHelper.waitAdditional(1);
			update = true;
		}
		
		return update;
	}
	
	/**
	 * Create Security group access Code : A115 :ADL
	 * @param elements
	 * @return
	 */
	public boolean createSecurityGroupAccessCode(List<String> elements){
		log.info("In create access code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//System
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//System
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Security group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(Keys.ENTER);//Security group
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(2));//Update access code
	
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(3));//Enquiry access code
			update = true;
		}
		
		return update;
	}
		
	/**
	 * Create role : A115 :AF2-AF1
	 * @param elements
	 * @return
	 */
	
	public boolean createRole(List<String> elements){
		log.info("In create access code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A115_ROLE)).clear();
		getDriver().findElement(By.xpath(pObject.A115_ROLE)).sendKeys(elements.get(0));//Role A115_ROLE
		getDriver().findElement(By.xpath(pObject.A115_ROLE)).sendKeys(Keys.ENTER);//Role  A115_ROLE
		WaitHelper.waitAdditional(2);
				
		if(!getErrorContentText().contains(message)){
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));//Description	 A002_DESCRIPTION		

			getDriver().findElement(By.xpath(pObject.A115_FUNC_SCTY_GRP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A115_FUNC_SCTY_GRP)).sendKeys(elements.get(2));//Functional Security group A115_FUNC_SCTY_GRP
	
			getDriver().findElement(By.xpath(pObject.A115_DATA_SCTY_GRP)).clear();
			getDriver().findElement(By.xpath(pObject.A115_DATA_SCTY_GRP)).sendKeys(elements.get(3));//Data security group  A115_DATA_SCTY_GRP
			
			getDriver().findElement(By.xpath(pObject.A011_MENU)).clear();
			getDriver().findElement(By.xpath(pObject.A011_MENU)).sendKeys(elements.get(4));//Menu  A011_MENU
			getDriver().findElement(By.xpath(pObject.A011_MENU)).sendKeys(Keys.ENTER);//Menu A011_MENU
			update = true;
		}
		
		return update;
	}	
	
	
	/*A115 : Create user roles AF3*/
	public boolean createUserRole(String company,List<String> elements){
		log.info("In user role methods");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(company);//Company A006_COMPANY
		
		getDriver().findElement(By.xpath(pObject.A011_USER1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_USER1)).sendKeys(elements.get(0));//User A011_USER1
		
		getDriver().findElement(By.xpath(pObject.A115_ROLE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A115_ROLE)).sendKeys(elements.get(1));//Role  A115_ROLE
		getDriver().findElement(By.xpath(pObject.A115_ROLE)).sendKeys(Keys.ENTER);//Role A115_ROLE
		WaitHelper.waitAdditional(2);
		
		if(!getErrorContentText().contains(message)){
			
			if(elements.get(2).equals("1")){
				getDriver().findElement(By.xpath(pObject.A115_CHK_DEF_ROL)).click();
			}
			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}
	
	
	/**
	 * Verify security element list : A116-AD1
	 * @return
	 */
	 
	public boolean isSecurityElementListDisplayed(){
		log.info("In security element list");
		boolean securityData = false;
		WaitHelper.waitAdditional(2);
		
		String tableHeader = getDriver().findElement(By.xpath(pObject.A001A_NAV_BAR)).getText();//Table header
//		System.out.println("------"+tableHeader);
		String securityElement = getDriver().findElement(By.xpath(pObject.A116_SEC_ELE)).getText();//Security element
//		System.out.println("------"+securityElement);
		String Description = getDriver().findElement(By.xpath(pObject.A116_DESC)).getText();//Description
//		System.out.println("------"+Description);
		String parentElement = getDriver().findElement(By.xpath(pObject.A116_PAR_ELE)).getText();//Parent Element
//		System.out.println("------"+parentElement);
		
		int securityCount = getDriver().findElements(By.xpath(pObject.A116_SEC_ELE_TBLE)).size();//Security element list
//		System.out.println("------"+securityCount);
		
		if(tableHeader.equals("MAD1 - Security Element List") && securityElement.equals("Security Element") && Description.equals("Description")
				&& parentElement.equals("Parent Element") && securityCount>0)
		{
			securityData = true;
		}
		
		return securityData;
	}
	
	
	/**
	 * Create Stock Take on Using Positive Adjustment : AD01004
	 * @param elements
	 */
	public void enterPositiveAdjLineDetails(List<String> elements){
		log.info("In positive adjustment line method");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Store
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]")))
		.click().sendKeys(elements.get(1)).build().perform();//Item
		WaitHelper.waitAdditional(2);

		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[3]")))
		.click().sendKeys(elements.get(2)).build().perform();//Quantity
		WaitHelper.waitAdditional(2);
		
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]")))
		.click().sendKeys(elements.get(2)).build().perform();//UOM
		WaitHelper.waitAdditional(2);
		
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]")))
		.click().sendKeys(elements.get(2)).build().perform();//Price
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Store
		
	}
	
	/**
	 * Generate IM Audit Reports : AD01008
	 * @param companyName
	 * @param elements
	 */
	
	public void generateAuditReports(String companyName,List<String> elements){
		log.info("In Audit reports method");

		if(elements.get(2).equals("ED4")){
			log.info("Enter process details for ED4");
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(elements.get(1));//Request A035_REQ
			
			getDriver().findElement(By.xpath(pObject.A035_CMPY)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);//Company A035_CMPY
			getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(Keys.ENTER);//Company A035_CMPY
			
			ClickOnSubmitFooter();

		}
		if(elements.get(2).equals("PQ1")){
			log.info("Enter process details for PQ1");
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(elements.get(1));//Request A035_REQ
			
			getDriver().findElement(By.xpath(pObject.A035_CMPY)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);//Company A035_CMPY
			WaitHelper.waitAdditional(1);
			
		    getDriver().findElement(By.xpath(pObject.A100_EFF_DT_FRM)).clear();
			getDriver().findElement(By.xpath(pObject.A100_EFF_DT_FRM)).sendKeys(String.valueOf(calender.Fromdate()));//From date Fromdate A100_EFF_DT_FRM
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A100_EXP_DT)).clear();
			getDriver().findElement(By.xpath(pObject.A100_EXP_DT)).sendKeys(String.valueOf(calender.TOdate()));//To date TOdate A100_EXP_DT
			getDriver().findElement(By.xpath(pObject.A100_EXP_DT)).sendKeys(Keys.ENTER);
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath(pObject.AD01008_PERID)).sendKeys(elements.get(3));//Report ind AD01008_PERID
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD01008_PERID)).sendKeys(elements.get(3));//Report ind AD01008_PERID
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD01008_CALENDAR)).clear();//Calendar AD01008_CALENDAR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD01008_CALENDAR)).sendKeys(elements.get(4));//Calendar AD01008_CALENDAR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD01008_CALENDAR)).sendKeys(Keys.ENTER);//Calendar AD01008_CALENDAR
			WaitHelper.waitAdditional(2);
			ClickOnSubmitFooter();
			WaitHelper.waitAdditional(2);
		}		
		
		if(!(elements.get(2).equals("PQ1")) && (!elements.get(2).equals("ED4"))) {
			
			log.info("Enter process details for other then PQ1 and ED4");
			WaitHelper.waitAdditional(2);
			
			getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(elements.get(1));//Request A035_REQ
			WaitHelper.waitAdditional(5);
			
			/*Balance class field*/
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
			WaitHelper.waitAdditional(1.5);//Company
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(companyName);
			WaitHelper.waitAdditional(1.5);//Company
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);
			WaitHelper.waitAdditional(1.5);//submit enter
			
			ClickOnSubmitFooter();

		}
	}	
	
	

	
	/************************************************************************
	 * Stock Balance : HBA (AD02001, AD02009, AD03001,AD05001)- HCJ
	 * **********************************************************************
	/**
	 * Search Item store
	 * @param company
	 * @param element
	 */

	public void searchItemStore(String company,List<String> element){
		log.info("Search item store");
		WaitHelper.waitAdditional(2);
		if(!isOkButtonDisplayed(5)){
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).clear();//A042_CMPY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).sendKeys(company);//Company A042_CMPY
		
		getDriver().findElement(By.xpath(pObject.AD02001_STORE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02001_STORE)).sendKeys(element.get(1));//Store AD02001_STORE
		
		getDriver().findElement(By.xpath(pObject.AD02001_ITEM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02001_ITEM)).sendKeys(element.get(0));//Item AD02001_ITEM
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyButton("OK", 1);
				
		WaitHelper.waitAdditional(3);
	}
	
	
	/**
	 * Amend store control
	 */
	public void amendStoreControl(){
		log.info("Amend store control");
		WaitHelper.waitAdditional(2);
		if(getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).click();// Use Requisitions
		}
		if(getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR)).click();//Use Picking Lists
		}
	}

	/*Current Period : AD03016
	 * EYB
	 * 
	 * 
	 * */
	public List<String> getPeriodAndYear(){
		log.info("In get period and year");
		WaitHelper.waitAdditional(2);
		List<String> yearDetails = new ArrayList<String>();
		
		yearDetails.add(getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).getText());//Period
		yearDetails.add(getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).getText());//Year
		
//		yearDetails.add(driver.findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).getText());//Period
//		yearDetails.add(driver.findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).getText());//Year
		return yearDetails;
	}
	
	/**
	 * Get company control -DAH-AD03016
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	public List<String> getCompanyControl(){
		log.info("In get period and year");
		WaitHelper.waitAdditional(2);
		List<String> yearDetails = new ArrayList<String>();

		if(getTableHeader().contains("DAH"))
			{		
		yearDetails.add(getDriver().findElement(By.xpath(pObject.A067_GL_CURNT_PER)).getAttribute("value"));//Period A067_GL_CURNT_PER
		yearDetails.add(getDriver().findElement(By.xpath(pObject.A067_GL_CURNT_YY)).getAttribute("value"));//year A067_GL_CURNT_YY
		
			}
		else if(getTableHeader().contains("HAB"))
			
			{
			yearDetails.add(getDriver().findElement(By.xpath(pObject.A104_GL_PER)).getAttribute("value"));//Period 
			yearDetails.add(getDriver().findElement(By.xpath(pObject.A104_GL_YY)).getAttribute("value"));//year 
		
			}
		else if(getTableHeader().contains("GAB"))
			{
			
				ClickOnAnyTab("GL Controls", 1);
				yearDetails.add(getDriver().findElement(By.xpath(pObject.A023_CURNT_PER)).getAttribute("value"));//Period 
				yearDetails.add(getDriver().findElement(By.xpath(pObject.A023_CURNT_YR)).getAttribute("value"));//year 
				
			}
		
//		yearDetails.add(getDriver().findElement(By.xpath(pObject.ZERO_+i)).getAttribute("value"));//Period A067_GL_CURNT_PER
//		yearDetails.add(getDriver().findElement(By.xpath(pObject.ZERO_+j)).getAttribute("value"));//year A067_GL_CURNT_YY
		
		return yearDetails;
	}
	
	
	/**
	 * Create Stock Adjustment, addLineDetails-HBA : AD01004, AD02001, AD03001,AD05001 
	 */
	
	public void addLineDetails(List<String> elements,String reference){
		log.info("In Add Lines Method");
		
		getDriver().findElement(By.xpath("//div[text()='Item']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[2]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Item']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(1));
		WaitHelper.waitAdditional(1.5);//Item
		
		
			if(reference.equals("A")||reference.equals("M")){
				getDriver().findElement(By.xpath("//div[text()='Quantity']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[3]")).click();
				WaitHelper.waitAdditional(1.5);
				getDriver().findElement(By.xpath("//div[text()='Quantity']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(2));
				WaitHelper.waitAdditional(1.5);//Quantity
			}
			else if(reference.equals("T"))
			
			{
			getDriver().findElement(By.xpath("//div[text()='Transfer Quantity']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Transfer Quantity']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(2));
			WaitHelper.waitAdditional(1.5);//Quantity	
			
			}
		
		if(reference.equals("A")){
			
			getDriver().findElement(By.xpath("//div[text()='UOM']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='UOM']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(3));
			WaitHelper.waitAdditional(1.5);//UOM
			
			getDriver().findElement(By.xpath("//div[text()='Price']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Price']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(4));
			getDriver().findElement(By.xpath("//div[text()='Price']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);
			WaitHelper.waitAdditional(1.5);//Price

		}
		
		else if(reference.equals("M")||reference.equals("T")){
			getDriver().findElement(By.xpath("//div[text()='QUOM']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='QUOM']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(3));
			WaitHelper.waitAdditional(1.5);//QUOM
			getDriver().findElement(By.xpath("//div[text()='QUOM']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.ENTER);
		
		}
	
     }
		
		
	/**
	 * Click on Currenct stock   
	 * @param elements
	 * Description : Click on STD Cost
	 */	
	 
	public void clickOnCurrentStock(){
		log.info("Click on Current Stock button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Current Stock")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	
	/**
	 * Verify current stock value for AD02001,AD02009, AD03001, AD05001
	 * @param elements
	 */

	public boolean verifyCurrenctStock(List<String> elements,int i){
		log.info("Verify currenct stock details");
		WaitHelper.waitAdditional(2);
		
		boolean output = false;
		output = getDriver().findElement(By.xpath(pObject.AD02001_PHYS_QTY)).getText().equals(elements.get(2));//Physical quantity AD02001_PHYS_QTY
		output = getDriver().findElement(By.xpath(pObject.AD02001_AVL_QTY)).getText().equals(elements.get(3));//Available quantity AD02001_AVL_QTY
		output = getDriver().findElement(By.xpath(pObject.AD02001_NOTNL_QTY)).getText().equals(elements.get(4));//Notional quantity AD02001_NOTNL_QTY
		WaitHelper.waitAdditional(2);
		if(i==1){			
	
			WaitHelper.waitAdditional(2);
			output = getDriver().findElement(By.xpath(pObject.AD02001_RE_ORDR_LVL)).getText().equals(elements.get(5));//Re-order value AD02001_RE_ORDR_LVL
			output = getDriver().findElement(By.xpath(pObject.AD02001_RE_ORDR_QTY)).getText().equals(elements.get(6));//Re-order quantity  AD02001_RE_ORDR_QTY
		}
		return output;
	}
	
	

	/**
	 * Click on re-order level
	 */
	public void clickOnReOrderLevel(){
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Reorder levels/Average cost tab	
	}
	
	
	/**
	 * Click on Item totals : 
	 * @param elements
	 */
	
	
	public void clickOnTotalItems(){
		log.info("Click on Item Totals button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Item Totals")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	

	/**
	 * Verify total items
	 * AD02001
	 * @param elements
	 */
	
	public boolean verifyTotalItems(List<String> elements){
		log.info("Verify total items");
		boolean verify = false;
		WaitHelper.waitAdditional(1);
		verify =getDriver().findElement(By.xpath(pObject.AD02001_ITMTTL_PHYS_QTY)).getText().equals(elements.get(7));//Get total value physical quantity AD02001_ITMTTL_PHYS_QTY
		verify = getDriver().findElement(By.xpath(pObject.AD02001_ITMTTL_AVL_QTY)).getText().equals(elements.get(8));//Get total value available quantity AD02001_ITMTTL_AVL_QTY
		verify = getDriver().findElement(By.xpath(pObject.AD02001_ITMTTL_NOTNL_QTY)).getText().equals(elements.get(9));//Get total value national quantity AD02001_ITMTTL_NOTNL_QTY
		WaitHelper.waitAdditional(1);
		return verify;
	}	
	


	/**
	 * Insert material issue 
	 * AD02001
	 * @param elements
	 */
	
	public void insertMaterialIssue(List<String> elements,String reference){
		log.info("Inserting material issue");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A076_CIRCU)).clear();
		getDriver().findElement(By.xpath(pObject.A076_CIRCU)).sendKeys(elements.get(1));//Circulation A076_CIRCU
		
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(0));//Element : EAST A029_ELEMENT
		
		
		ClickOnAnyTab("GL Details", 1);
		WaitHelper.waitAdditional(3);
	
	
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[1]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).sendKeys(elements.get(5));//Account
		WaitHelper.waitAdditional(1.5);
		
		
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[2]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(6));//Cost
		WaitHelper.waitAdditional(1.5);
		
		ClickOnAnyTab("Line Details", 1);
		WaitHelper.waitAdditional(4);
		addLineDetails(elements,reference);

	}

	/**
	 * Insert material issue 
	 * AD05001
	 * @param elements
	 */	
	public void addStoreDetails(List<String> elements){
		log.info("Add store details");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A076_CIRCU)).clear();
		getDriver().findElement(By.xpath(pObject.A076_CIRCU)).sendKeys(elements.get(0));//Circulation A076_CIRCU
		getDriver().findElement(By.xpath(pObject.A076_CIRCU)).sendKeys(Keys.ENTER);//Circulation A076_CIRCU
		
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(1));//Element : EAST A029_ELEMENT
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A106_STORE)).clear();
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(elements.get(1));//Element : EAST A106_STORE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(Keys.ENTER);
		
		WaitHelper.waitAdditional(3);
		
		
	}	
	
	
	
	public void sortValues(){
		log.info("Sort Journal values");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.AD02001_JRNL_NUM)).click();//Number
		WaitHelper.waitAdditional(3);//Number

	}
	
	
		

	public void clickOnFetch_retrieve() {
		log.info("Clicking on Fetch and retrieve icon on topmenu");
		WaitHelper.waitAdditional(2);
	
		getDriver().findElement(By.xpath(pObject.TPMN_FETCH)).click();
		WaitHelper.waitAdditional(4);
		
		getDriver().findElement(By.xpath(pObject.TPMN_RETRIV)).click();
		WaitHelper.waitAdditional(4);
		
		
	}

	private boolean isFetchPopUpDisplayed() {
		WaitHelper.waitAdditional(2);
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.AD05001_FETCH)));// Chetna Failed for A035
																				// Wait
																				// Added
		return getDriver().findElement(By.xpath(pObject.AD05001_FETCH)).isDisplayed();

	}
	
	
	
	public void enterFetchDetails(List<String> elements, String glRefNumber ) {
		WaitHelper.waitAdditional(4);

		if (!isFetchPopUpDisplayed()) {
			WaitHelper.waitAdditional(3);
		}
		
		getDriver().findElement(By.xpath(pObject.AD05001_FETCH_DOC)).sendKeys(glRefNumber);
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath(pObject.AD05001_FETCH_LINE)).sendKeys(elements.get(4));
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath(pObject.AD05001_FETCH)).click();// Fetch
		WaitHelper.waitAdditional(6);
	}

	
	
	
	
	/*Verify Journal details
	 * EDA- AD02001, AD02009,AD02010,AD03001, AD10001, AD10002
	 * 
	 * 
	 * */
	
	
	public boolean verifyJournalDetails(int i,List<String> elements){
		log.info("Verify journal Lines detailed Base");
		WaitHelper.waitAdditional(2);
		boolean verify = false;
		
		WebElement Account = driver.findElement(By.xpath(pObject.AD02001_JRNL_ACC));
		driver.executeScript("arguments[0].scrollIntoView(true);", Account);
		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_JRNL_ACC)).getText().contains("Account");//account header AD02001_JRNL_ACC
		verify = getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).getText().equals(elements.get(0));//account value
		WaitHelper.waitAdditional(1);
		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_JRNL_COST)).getText().equals("Cost");//cost header AD02001_JRNL_COST
		verify = getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[6]")).getText().equals(elements.get(1));//cost value
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[10]")).click();//Click on 
		verify = getDriver().findElement(By.xpath(pObject.AD02001_JRNL_DESC)).getText().trim().equals("Description");//description header AD02001_JRNL_DESC
		int description = getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[10]")).getText().length();//description value
		
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[10]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);
		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_JRNL_BS_VAL)).getText().trim().equals("Base Value");//base header AD02001_JRNL_BS_VAL
		verify = getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[11]")).getText().equals(elements.get(2));//base value
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[11]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);

		verify = getDriver().findElement(By.xpath(pObject.AD02001_JRNL_QNTY)).getText().trim().equals("Quantity");//quantity header AD02001_JRNL_QNTY
		verify = getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[12]")).getText().equals(elements.get(3));//quantity value
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[12]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[12]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[13]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[14]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[15]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[16]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[17]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[18]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[19]")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);

		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_JRNL_REF)).getText().trim().equals("Reference");//reference header AD02001_JRNL_REF
		int referenceHeader = getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[20]")).getText().length();//reference value
		
		if(i==1 || i==2){
			if(referenceHeader>0 && description>0){			
				verify = true;
			}
		}
		return verify;
	}

	
	/*Verify total Stock Balance and valuation
	 * AD02001, AD02009,AD03001,AD05001
	 * 
	 * */
	public boolean verifyTotalStockBalance(List<String> elements){
		log.info("Verify total stock balance ");
		WaitHelper.waitAdditional(2);
		
		return getDriver().findElement(By.xpath(pObject.AD02001_TL_STK_VAL)).getText().equals(elements.get(2));//Total currenct stock value AD02001_TL_STK_VAL
		 
	}

	/**
	 * Verify store Item : Verify column header and column value
	 * AD02001, AD02009,AD03001,AD05001
	 * @param elements
	 */
	public boolean verifyStoreItemValues(List<String> elements,int i){
		log.info("Verify store item header and value");
		boolean verify = false ;
		WaitHelper.waitAdditional(2);
		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_ITMSTKVAL_ITM)).getText().contains("Item");//Item header
		verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]")).getText().equals(elements.get(0));//Item value
		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_ITMSTKVAL_PHY)).getText().trim().equals("Physical");//Physical header
		verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).getText().equals(elements.get(3));//Physical value

		verify = getDriver().findElement(By.xpath(pObject.AD02001_ITMSTKVAL_REQ_OUT)).getText().trim().equals("Reqs Out");//Reqs Out header AD02001_ITMSTKVAL_REQ_OUT
		verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).getText().equals(elements.get(4));//Reqs Out value

		verify = getDriver().findElement(By.xpath(pObject.AD02001_ITMSTKVAL_STK_VAL)).getText().trim().equals("Stock Value");//Stock header AD02001_ITMSTKVAL_STK_VAL
		verify = getDriver().findElement(By.xpath("//div/div[1]/table/tbody/tr/td[7]")).getText().equals(elements.get(5));//Stock value

		if(i==1){
			verify = getDriver().findElement(By.xpath(pObject.AD02001_ITMSTKVAL_PHY_AVL)).getText().trim().equals("Physical Avail");//Physical header
			verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).getText().equals(elements.get(6));//Physical value
	
			verify = getDriver().findElement(By.xpath(pObject.AD02001_ITMSTKVAL_REQIN)).getText().trim().equals("Reqs/Orders In");//Reqs & orders header
			verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).getText().equals(elements.get(7));//Reqs & orders value
		}
		return verify;
	}
	
	/**
	 * Verify store Item : Verify column header and column value
	 * @param elements
	 */
	
	public boolean verifyStoreItemValuation(List<String> elements,int i){
		log.info("Verify store item header and value");
		WaitHelper.waitAdditional(2);
		
		WebElement Selection = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection);

		
		boolean verify = false;
		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_STRITMVAL_GEN)).getText().contains("GRN");//GRN AD02001_STRITMVAL_GEN
		String GRN = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]")).getText();//GRN value
		
		if(!GRN.equals(null)){
			verify = true;
		}
		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_STRITMVAL_RECDT)).getText().trim().equals("Receipt Date");//Receipt Date AD02001_STRITMVAL_RECDT
		String date = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).getText();//Receipt Date value
		if(!date.equals(null)){
			verify = true;
		}
		
		
		verify = getDriver().findElement(By.xpath(pObject.AD02001_STRITMVAL_REMQTY)).getText().trim().equals("Remained Quantity");//Receipt Date header AD02001_STRITMVAL_REMQTY
		verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).getText().equals(elements.get(0));//Receipt Date value

		verify = getDriver().findElement(By.xpath(pObject.AD02001_STRITMVAL_RECPRZ)).getText().trim().equals("Receipt Price");//Receipt Price header AD02001_STRITMVAL_RECPRZ
		verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).getText().equals(elements.get(1));//Receipt Price value

		if(i==1){
			verify = getDriver().findElement(By.xpath(pObject.AD02001_STRITMVAL_ORGVAl)).getText().trim().equals("Original Value");//Original Value header AD02001_STRITMVAL_ORGVAl
			verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).getText().equals(elements.get(2));//Original Value value
	
			verify = getDriver().findElement(By.xpath(pObject.AD02001_STRITMVAL_STRVAL)).getText().trim().equals("Source");//Source header AD02001_STRITMVAL_STRVAL
			verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]")).getText().equals(elements.get(3));//Source value
		}
		return verify;
	}


	
	/**
	 * Verify store Item : Verify column header and column value
	 * AD10001-GCK or LOGGBTCH ACT=INSERT,CMPY=IM,TRAN-TYPE=1, AD10014
	 * @param elements
	 */
	public boolean verifyStoreItem(List<String> elements,int i){
		log.info("Verify store item header and value");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		WebElement SYSREF = driver.findElement(By.xpath(pObject.AD10001_SYSREF));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", SYSREF);
		
		update = getDriver().findElement(By.xpath(pObject.AD10001_SYSREF)).getText().trim().contains(elements.get(0));//System header
		
		update = getDriver().findElement(By.xpath(pObject.AD10001_SUPP)).getText().trim().equals(elements.get(1));//Supplier header
		update = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).getText().trim().equals(elements.get(2)); //Supplier Value

		update = getDriver().findElement(By.xpath(pObject.AD10001_TRANREF)).getText().trim().equals(elements.get(3));//Trans Refer header
		update = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).getText().trim().equals(elements.get(4));//Trans Refer values

        update = getDriver().findElement(By.xpath(pObject.AD10001_TRANDT)).getText().equals(elements.get(5));//Trans Date header
        update = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).getText().trim().equals(calender.Presentdate());//Trans Date Value

        update = getDriver().findElement(By.xpath(pObject.AD10001_GRSAMT)).getText().equals(elements.get(6));//Gross AMT header
        update = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).getText().equals(elements.get(7));//Gross Values

		if(i==1){
			update = getDriver().findElement(By.xpath(pObject.AD10001_TXAMT)).getText().equals(elements.get(8));//Tax header
			update = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]")).getText().equals(elements.get(9));//Tax Values
		}
		
		return update;
	}
	

	/**
	 * Click on Address button
	 * @param i
	 */
	public void clickOnValuation(){
		log.info("Click on Valuation button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Valuation")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	
	
	
	/************************************************
	 * Create classification code : AT2 AD09004
	 * **********************************************/
	/**
	 * Create classification code
	 * @param elements
	 * @return
	 */
	public boolean createClassificationCode(List<String> elements){
		log.info("Create classification code");
		boolean update = false;
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.AD09004_CLSFCTN)).clear();//Classification AD09004_CLSFCTN 
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD09004_CLSFCTN)).sendKeys(elements.get(0));		
		getDriver().findElement(By.xpath(pObject.AD09004_CLSFCTN)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
		
		if(!getErrorContentText().contains(message)){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD09004_DESC)).clear();//Description AD09004_DESC
			WaitHelper.waitAdditional(1); 
			getDriver().findElement(By.xpath(pObject.AD09004_DESC)).sendKeys(elements.get(1));
			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}	

	
	/************************************************
	 * Classification Parentage : PYB AD09005
	 * **********************************************/
	
	
	public void createClassificationStructure(List<String> elements){
		log.info("In classification structure method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.AD09005_CLSFCTN_STRU)).clear();//Classification structure AD09005_CLSFCTN_STRU
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD09005_CLSFCTN_STRU)).sendKeys(elements.get(0));		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();//Description A002_DESCRIPTION
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(2));	

	}	
	
//	public void createClassificationStructure(List<String> elements){
//		log.info("In classification structure method");
//		WaitHelper.waitAdditional(2);
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();//Classification structure AD09005_CLSFCTN_STRU
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));		
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();//Description A002_DESCRIPTION
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(2));	
//
//	}

	
	
	
	public void amendPurchasingCompanyControl(List<String> elements){
		log.info("Amend purchasing company control");
		
		
		WaitHelper.waitAdditional(2);
		
		ClickOnAnyTab("Goods Receipting/IM", 1);
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A077_AUT_RET_ORCD)).clear();
		getDriver().findElement(By.xpath(pObject.A077_AUT_RET_ORCD)).sendKeys(elements.get(0));//Returning order code A077_AUT_RET_ORCD
		
		
		ClickOnAnyTab("Miscellaneous/ERS", 1);
		WaitHelper.waitAdditional(2);	
		getDriver().findElement(By.xpath(pObject.AD09005_CLSFCTN_STRU)).clear();
		getDriver().findElement(By.xpath(pObject.AD09005_CLSFCTN_STRU)).sendKeys(elements.get(1));//Classification structure AD09005_CLSFCTN_STRU

	}
	
	
//	public void amendPurchasingCompanyControl(List<String> elements){
//		log.info("Amend purchasing company control");
//		
//		
//		WaitHelper.waitAdditional(2);
//		
//		ClickOnAnyTab("Goods Receipting/IM", 1);
//		WaitHelper.waitAdditional(2);
//		
//		WaitHelper.waitAdditional(2);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO+pObject.EIGHT)).clear();
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO+pObject.EIGHT)).sendKeys(elements.get(0));//Returning order code A077_AUT_RET_ORCD
//		
//		
//		ClickOnAnyTab("Miscellaneous/ERS", 1);
//		WaitHelper.waitAdditional(2);	
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.SEVEN+pObject.ONE)).clear();
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.SEVEN+pObject.ONE)).sendKeys(elements.get(1));//Classification structure AD09005_CLSFCTN_STRU
//
//	}
	
	/**
	 * Create classification parentage
	 * @param elements
	 */

	
	public void classificationParentage(List<String> elements,int i){
		log.info("Inside classification parentage");
	
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.AD09005_CLSFCTN_STRU)).clear();//Structure AD09005_CLSFCTN_STRU
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD09005_CLSFCTN_STRU)).sendKeys(elements.get(0));//AD09005_CLSFCTN_STRU	
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD09004_CLSFCTN)).clear();//Classification AD09004_CLSFCTN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD09004_CLSFCTN)).sendKeys(elements.get(1));
		WaitHelper.waitAdditional(1);

		if(i==1){
			getDriver().findElement(By.xpath(pObject.AD09005_PRNT_CLSFCTN)).clear();//Parent Classification
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD09005_PRNT_CLSFCTN)).sendKeys(elements.get(2));//AD09005_PRNT_CLSFCTN
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.AD09005_PRNT_CLSFCTN)).sendKeys(Keys.ENTER);//AD09005_PRNT_CLSFCTN
		}
	}	
	

	
	/************************************************
	 * Create Item Classification : PYB AD09006
	 * **********************************************/
	/**
	 * Click on Classification button
	 */
	
	
public void clickOnClassification() {
		log.info("Click on Classification button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().trim().equals("Classification")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}	

	
	/**
	 * AD09006 - PIA
	 * @param elements
	 */

public void createItemClassification(List<String> elements){
	log.info("Create Item Classification");
	WaitHelper.waitAdditional(2);

	getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
	WaitHelper.waitAdditional(1.5);
	getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(1));
	
	
	getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
	WaitHelper.waitAdditional(1.5);
	getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(2));
	WaitHelper.waitAdditional(1.5);
	getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.ENTER);
	
}

/* Search document
 * 
 *  AD09008-HCA
 *  
 *  
 */
public void searchDocument(String companyId, String storeElement, int i) {
	
	if (!isOkButtonDisplayed(i)) {
		
		clickOnSections(0);
	}
	WaitHelper.waitAdditional(1);
	getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
	WaitHelper.waitAdditional(1);
	getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(companyId);
	WaitHelper.waitAdditional(1);
	getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
	WaitHelper.waitAdditional(1);
	getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(storeElement);
	
	ClickOnAnyButton("OK", 1);
	WaitHelper.waitAdditional(4);
}


	
	/**
	 * Get document list
	 * 
	 * AD09008-HCA
	 * @return
	 */
	public int getDocumentList(){
		log.info("Get document list");
		WaitHelper.waitAdditional(2);
		int count = 0;
	
		List<WebElement> documentList = getDriver().findElements(By.xpath("//div[1]/table/tbody/tr/td[6]"));//Security element list
		
		for(WebElement wb : documentList){
			if(wb.getText().length() > 0)
			{
				count++;
			}
		}
		return count;
	} 
	
	
	/************************************************
	 * Create Goods Receiving : PYB AD02009-DOA, AD10006
	 * **********************************************/

	/**
	 * Create order
	 * @param elements
	 */
	
	public void createOrderCode(List<String> elements){
		log.info("In create order code method");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A076_DOC_CD)).clear();
		WaitHelper.waitAdditional(1);
		
	
		getDriver().findElement(By.xpath(pObject.A076_DOC_CD)).sendKeys(elements.get(0));//Order code A076_DOC_CD
		
		log.info("Into Supplier Details Section");
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(elements.get(1));//Supplier A091_SUPP

		getDriver().findElement(By.xpath(pObject.AD02009_ADDR_NUM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_ADDR_NUM)).sendKeys(elements.get(2));//Address number AD02009_ADDR_NUM

		log.info("Into Order Details Section");
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(3));//Element A029_ELEMENT

		getDriver().findElement(By.xpath(pObject.A061_LOC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A061_LOC)).sendKeys(elements.get(4));//Location A061_LOC

		getDriver().findElement(By.xpath(pObject.A081_BUYER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A081_BUYER)).sendKeys(elements.get(5));//Buyer A081_BUYER
		
		log.info("Into Currency Section");
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(elements.get(6));//Currency code A002_CURRENCY

		if(!elements.get(7).equals("NULL")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD02009_INVCE_SITE)).sendKeys(elements.get(7));//Invoice location AD02009_INVCE_SITE
		}
		if(!elements.get(8).equals("NULL")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A076_CIRCU)).sendKeys(elements.get(8));//Circulation A076_CIRCU
 
		}
		
		log.info("Into Settlement Section");
		
		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).sendKeys(elements.get(9));//Terms A055_SETT_TERM

		getDriver().findElement(By.xpath(pObject.AD02009_DSTRM_1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_DSTRM_1)).sendKeys(elements.get(10));//Discount AD02009_DSTRM_1
		
		
		ClickOnAnyTab("Primary Detail Lines", 1);
		log.info("On the Primary Detail Lines Tab");
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FOURTH_TAB)).click();//Primary detail lines tab	
		WaitHelper.waitAdditional(4);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(11));//Item
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);//Item
		
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(12));//Description
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.TAB);//Description
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(13));//Quantity
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(Keys.TAB);//Quantity
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(14));//Price
		WaitHelper.waitAdditional(1.5);
		
		ClickOnAnyTab("Delivery", 1);
		log.info("On the Delivery Tab");
		WaitHelper.waitAdditional(4);		
		
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]/input")).sendKeys(elements.get(15));//Location
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]/input")).sendKeys(Keys.TAB);//Location

				
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(String.valueOf(calender.TOdate()));//Due date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.TAB);//Due date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(Keys.TAB);//Due date
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);//Due date
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.TAB);//Due date
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(Keys.TAB);//Due date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(21));//Store
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyTab("GL Detail", 1);
		log.info("On the GL Detail Tab");
		WaitHelper.waitAdditional(4);	

		
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(18));//Account
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.TAB);
		

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(19));//Cost	
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1);

		
//		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).click();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(21));//location
//		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);//location
//		WaitHelper.waitAdditional(1.5);
	
		ClickOnAnyTab("Tax/Discounts", 1);
		log.info("On the Tax/Discounts Tab");
		WaitHelper.waitAdditional(4);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]/input")).sendKeys(elements.get(22));//Code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]/input")).sendKeys(Keys.TAB);//Code
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(23));//Type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.TAB);//Type
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(24));//Location
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(Keys.TAB);//Location
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(25));//Handling code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.ENTER);//Handling code
	
		WaitHelper.waitAdditional(2);
	}
	

	
	/**
	 * Receive Goods :AD02009, AD10006
	 */
	
	public void addGoodsReceive(List<String> elements, String ADVICE,String GRN){
		log.info("Adding goods receive");
		WaitHelper.waitAdditional(4);
		getDriver().findElement(By.xpath(pObject.AD02009_ADV_NT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02009_ADV_NT)).sendKeys(ADVICE);//Advice note
		
		getDriver().findElement(By.xpath(pObject.AD02009_DELV)).clear();
		getDriver().findElement(By.xpath(pObject.AD02009_DELV)).sendKeys(GRN);//Delivery
		
		
		ClickOnAnyTab("Primary Details", 1);
		log.info("On the Primary Details Tab");
		WaitHelper.waitAdditional(3);
		
		if(!elements.get(2).equals("NULL")){
			getDriver().findElement(By.xpath("//div[text()='Received Qty']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[text()='Received Qty']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).clear();
			getDriver().findElement(By.xpath("//div[text()='Received Qty']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(2));//Add received qty
			WaitHelper.waitAdditional(1);
		}
		if(!elements.get(3).equals("NULL")){
			
			getDriver().findElement(By.xpath("//div[text()='UOM']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[text()='UOM']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).clear();
			getDriver().findElement(By.xpath("//div[text()='UOM']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(3));//UOM
			WaitHelper.waitAdditional(1);
		
		}
		if(!elements.get(4).equals("NULL")){
			
			getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[1]/table/tbody/tr/td[6]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[1]/table/tbody/tr/td[6]/input")).clear();
			getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[1]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(4));//Location
			WaitHelper.waitAdditional(1);
			
		}
	
		ClickOnAnyTab("Advised", 1);
		log.info("On the Advised Tab");
		WaitHelper.waitAdditional(3);
		
		if(!elements.get(5).equals("NULL")){
			
			getDriver().findElement(By.xpath("//div[text()='Advised Quantity']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[text()='Advised Quantity']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).clear();
			getDriver().findElement(By.xpath("//div[text()='Advised Quantity']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).sendKeys(elements.get(5));//Advised qty
			WaitHelper.waitAdditional(1);
			
		}
		
		if(!elements.get(6).equals("NULL")){
			
			getDriver().findElement(By.xpath("//div[text()='UOM']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[text()='UOM']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).clear();
			getDriver().findElement(By.xpath("//div[text()='UOM']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(6));//UOM
			WaitHelper.waitAdditional(1);
			
		}
		
		if(!elements.get(7).equals("NULL")){
			
			getDriver().findElement(By.xpath("//div[text()='Receipt']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[text()='Receipt']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(7));//Receipt
			WaitHelper.waitAdditional(1);
							
		}
	}	

	
	/************************************************
	 * Create Service Order : PYB AD02013-DOA
	 * **********************************************/

	/**
	 * Create service order
	 * @param elements
	 */
	
	public void createServiceOrderCode(List<String> elements){

		
		log.info("In create order code method");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A076_DOC_CD)).clear();
		WaitHelper.waitAdditional(1);
	
		getDriver().findElement(By.xpath(pObject.A076_DOC_CD)).sendKeys(elements.get(0));//Order code A076_DOC_CD
		
		
		log.info("Into Supplier Details Section");
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(elements.get(1));//Supplier A091_SUPP

		getDriver().findElement(By.xpath(pObject.AD02009_ADDR_NUM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_ADDR_NUM)).sendKeys(elements.get(2));//Address number AD02009_ADDR_NUM
		

		log.info("Into Order Details Section");
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(3));//Element A029_ELEMENT

		getDriver().findElement(By.xpath(pObject.A061_LOC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A061_LOC)).sendKeys(elements.get(4));//Location A061_LOC

		
		getDriver().findElement(By.xpath(pObject.AD02009_INVCE_SITE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_INVCE_SITE)).sendKeys(elements.get(5));//Invoice location AD02009_INVCE_SITE
		
		

		getDriver().findElement(By.xpath(pObject.A081_BUYER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A081_BUYER)).sendKeys(elements.get(6));//Buyer
		
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(elements.get(7));//Currency code A002_CURRENCY
		
		
		
		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).sendKeys(elements.get(8));//Terms A055_SETT_TERM

		getDriver().findElement(By.xpath(pObject.AD02009_DSTRM_1)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_DSTRM_1)).sendKeys(elements.get(9));//Discount AD02009_DSTRM_1
		getDriver().findElement(By.xpath(pObject.AD02009_DSTRM_1)).sendKeys(Keys.ENTER);//Discount AD02009_DSTRM_1

		
		ClickOnAnyTab("Primary Detail Lines", 1);
		WaitHelper.waitAdditional(4);
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FOURTH_TAB)).click();//Primary detail lines tab	
		
		
		getDriver().findElement(By.xpath("//div[text()='Item']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Item']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(10));//Item
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Item']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);//Item
		
		getDriver().findElement(By.xpath("//div[text()='Description']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.TAB);//Desc
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Quantity']/../../../../../../../../../..//div[1]/table/tbody/tr/td[6]/input")).sendKeys(Keys.TAB);//QTY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Price']/../../../../../../../../../..//div[1]/table/tbody/tr/td[7]/input")).sendKeys(Keys.TAB);//Price
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='QUOM']/../../../../../../../../../..//div[1]/table/tbody/tr/td[8]/input")).sendKeys(Keys.TAB);//QUOM
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='PUOM']/../../../../../../../../../..//div[1]/table/tbody/tr/td[9]/input")).sendKeys(Keys.TAB);//PUOM
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Service Value']/../../../../../../../../../..//div[1]/table/tbody/tr/td[10]/input")).sendKeys(elements.get(11));//Service Value
		WaitHelper.waitAdditional(1);		

		ClickOnAnyTab("Delivery", 1);
		log.info("On the Delivery Tab");
		WaitHelper.waitAdditional(4);	
		
		getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).sendKeys(elements.get(12));//Location
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).sendKeys(Keys.TAB);//Location
		
		
		
		getDriver().findElement(By.xpath("//div[text()='Due Date']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Due Date']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(String.valueOf(calender.Presentdate()));//Due date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Due Date']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.TAB);//Due date
		WaitHelper.waitAdditional(2);
		
		ClickOnAnyTab("GL Detail", 1);
		log.info("On the GL Detail Tab");
		WaitHelper.waitAdditional(4);	
		
		
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(13));//Account
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.TAB);
		

		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(14));//Cost
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyTab("Primary Detail Lines", 1);
		WaitHelper.waitAdditional(4);
		getDriver().findElement(By.xpath("//div[text()='Cmd']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Item']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).sendKeys(elements.get(15));//CMD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Item']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).sendKeys(Keys.ENTER);//CMD
		
		ClickOnAnyTab("Delivery", 1);
		log.info("On the Delivery Tab");
		WaitHelper.waitAdditional(4);
		
			
			int i=2;
			String dateFormat1 = "dd MMM yyyy";
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat(dateFormat1);
			while (i<=6)
			
			{
	
		Calendar date = calender.presentDatePlusOneMonth(cal);
		getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[1]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[1]/input")).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[1]/input")).sendKeys(elements.get(12));//Location
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Location']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[1]/input")).sendKeys(Keys.TAB);//Location
		
		getDriver().findElement(By.xpath("//div[text()='Due Date']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[2]/input")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Due Date']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[2]/input")).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Due Date']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(dateFormat.format(date.getTime()));//Due date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[text()='Due Date']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(Keys.TAB);//Due date
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath("//div[text()='Expected Date']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[3]/input")).clear();//Expected date
		WaitHelper.waitAdditional(1);

		i++;
		
			}
			getDriver().findElement(By.xpath("//div[text()='Expected Date']/../../../../../../../../../..//div[6]/table/tbody/tr/td[3]/input")).sendKeys(Keys.ENTER);//Expected date
			WaitHelper.waitAdditional(2);	
		
		}
		
		
		
//		Need Help
		
/*		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.SEVENTH_TAB)).click();//Status tab
		WaitHelper.waitAdditional(4);
		builder.moveToElement(driver.findElement(By.xpath("//div[7]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[5]"))).click().
			sendKeys(elements.get(14)).build().perform();//15
		WaitHelper.waitAdditional(5);//Service value
		
		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.TAB+9)).click();//Recurring details tab
		WaitHelper.waitAdditional(4);
		builder.moveToElement(driver.findElement(By.xpath("//div[9]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]"))).click().
			sendKeys(elements.get(15)).build().perform();//16
		WaitHelper.waitAdditional(5);//Interval
		builder.moveToElement(driver.findElement(By.xpath("//div[9]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[3]"))).click().
			sendKeys(elements.get(16)).build().perform();
		WaitHelper.waitAdditional(5);//Frequency//17
		builder.moveToElement(driver.findElement(By.xpath("//div[9]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[4]"))).click().
			sendKeys(elements.get(17)).build().perform();
		WaitHelper.waitAdditional(5);//Occurrences//18
		
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(5);//Occurrences
*/		
	
	
	
//	public void createServiceOrderCode(List<String> elements){
//		log.info("In create order code method");
//		WaitHelper.waitAdditional(2);
//		
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ZERO)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Order code
//		
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Supplier tab
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.FOUR)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(1));//Supplier
//
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.SIX)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(2));//Address number
//
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Order currency tab	
//		WaitHelper.waitAdditional(2);
//		
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.ONE)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.ONE)).sendKeys(elements.get(3));//Element
//
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.THREE)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.THREE)).sendKeys(elements.get(4));//Location
//		
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.FOUR)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.FOUR)).sendKeys(elements.get(5));//Invoice location
//
//
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.FIVE)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.FIVE)).sendKeys(elements.get(6));//Buyer
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.NINE)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.NINE)).sendKeys(elements.get(7));//Currency code
//		
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.THIRD_TAB)).click();//Settlement/Authorisation tab	
//		
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO+pObject.THREE)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO+pObject.THREE)).sendKeys(elements.get(8));//Terms
//
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO+pObject.FOUR)).clear();
//		WaitHelper.waitAdditional(1);
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO+pObject.FOUR)).sendKeys(elements.get(9));//Discount
//
//		
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FOURTH_TAB)).click();//Primary detail lines tab	
//		WaitHelper.waitAdditional(4);
//		Actions builder = new Actions(driver);
//		
//		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[3]"))).click().
//			sendKeys(elements.get(10)).build().perform();
//		WaitHelper.waitAdditional(5);//Item
//
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FIFTH_TAB)).click();//Delivery tab
//		WaitHelper.waitAdditional(4);		
//		
//		builder.moveToElement(driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]"))).click().
//		sendKeys(elements.get(11)).build().perform();
//		WaitHelper.waitAdditional(5);//Location
//		
//		Calendar currentMonth = Calendar.getInstance();
//		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
//		String currDate = dateFormat1.format(currentMonth.getTime());
//		
//		builder.moveToElement(driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[4]"))).click().
//			sendKeys(currDate).build().perform();
//		WaitHelper.waitAdditional(5);//Due date
//
//		
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.SIXTH_TAB)).click();//GL details tab
//		WaitHelper.waitAdditional(4);
//		builder.moveToElement(driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[2]"))).click().
//			sendKeys(elements.get(12)).build().perform();
//		WaitHelper.waitAdditional(5);//Account
//		builder.moveToElement(driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[3]"))).click().
//			sendKeys(elements.get(13)).build().perform();
//		WaitHelper.waitAdditional(5);//Cost
//		
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.SEVENTH_TAB)).click();//Status tab
//		WaitHelper.waitAdditional(4);
//		builder.moveToElement(driver.findElement(By.xpath("//div[7]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[5]"))).click().
//			sendKeys(elements.get(14)).build().perform();
//		WaitHelper.waitAdditional(5);//Service value
//		
//		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.TAB+9)).click();//Recurring details tab
//		WaitHelper.waitAdditional(4);
//		builder.moveToElement(driver.findElement(By.xpath("//div[9]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]"))).click().
//			sendKeys(elements.get(15)).build().perform();
//		WaitHelper.waitAdditional(5);//Interval
//		builder.moveToElement(driver.findElement(By.xpath("//div[9]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[3]"))).click().
//			sendKeys(elements.get(16)).build().perform();
//		WaitHelper.waitAdditional(5);//Frequency
//		builder.moveToElement(driver.findElement(By.xpath("//div[9]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[4]"))).click().
//			sendKeys(elements.get(17)).build().perform();
//		WaitHelper.waitAdditional(5);//Occurrences
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);
//		WaitHelper.waitAdditional(5);//Occurrences
//	}
	
	/**
	 * click On Order explode
	 */
	public void clickOnOrderExplode(){
		log.info("Clicking on Order explode button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Order")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Explode")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
	
	/**
	 * click On maintain parameters
	 */
	public void clickOnAuthorisationLineView(){
		log.info("Clicking on authorisation button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Authorisation")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Line View")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
	
	/**
	 * click On Authorise  
	 */	
	
	public void ClickOnAuthoriseFooter() {
		log.info("Click on Authorise Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().trim().equals("Authorise")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	
	/**
	 * click On Select  
	 */	
	
	public void ClickOnSelectFooter() {
		log.info("Click on Select Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().trim().equals("Select")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	  
	
	
	/**
	 * click On Select All
	 */	
	
	public void ClickOnSelectAllFooter() {
		log.info("Click on Select All Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().trim().equals("Select All")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	
	
	/**
	 * click On Confirm  
	 */	
	
	public void ClickOnConfirmFooter() {
		log.info("Click on Confirm Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().trim().equals("Confirm")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Authorise order for AD02009, AD02013
	 */
	public void selectOrderAuthorisor(){
		log.info("In select Order Authorisor mrthod");
		WaitHelper.waitAdditional(2);
			
		ClickOnSelectFooter();
		WaitHelper.waitAdditional(1);
		
		ClickOnAuthoriseFooter();
		WaitHelper.waitAdditional(3);
		
		ClickOnConfirmFooter();
		WaitHelper.waitAdditional(4);

		WebElement Selection = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection);

	}
	
	
	/**
	 * Authorise order for AD02013 for multiple lines upto 6
	 */
	
	public void selectMultiOrder(){
			
		for(int i=1;i<=6;i++){
				
			getDriver().findElement(By.xpath("//div[text()='Sel']/../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[1]")).click();
			WaitHelper.waitAdditional(1.5);
			ClickOnSelectFooter();

		}
			
		ClickOnAuthoriseFooter();
		WaitHelper.waitAdditional(3);
		
		ClickOnConfirmFooter();
		WaitHelper.waitAdditional(4);
		
		WebElement Selection = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection);
			
		}
//		
//		clickOnReturnButton();
//		WaitHelper.waitAdditional(5);

	/**
	 * Enter goods details on pop up 
	 * @param elements
	 * AD02009, AD10006
	 */
	
	public void enterGoodsDetailsInPopUp(String elements){
		log.info("Enter goods details");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.AD02009_FETCH_ORDER)).sendKeys(elements);//Order
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.AD02009_FETCH_ORDER)).sendKeys(Keys.ENTER);
//		getDriver().findElement(By.xpath(pObject.AD02009_FETCH)).click();//Fetch
		WaitHelper.waitAdditional(3);

	}
	
	
	/************************************************
	 * Enter Invoices : GBB AD02010, AD10001, AD10002
	 * **********************************************/
	
	
	
	public void enterInvoice(List<String> elements,String transtype){
		log.info("Enter invoice details");
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(0));//Description A002_DESCRIPTION
		
		getDriver().findElement(By.xpath(pObject.A040_NUM_OF_TRANC)).clear();
		getDriver().findElement(By.xpath(pObject.A040_NUM_OF_TRANC)).sendKeys(elements.get(1));//No.of transaction A040_NUM_OF_TRANC
		
		getDriver().findElement(By.xpath(pObject.AD02010_TOTAL_GRAMT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TOTAL_GRAMT)).sendKeys(elements.get(2));//Total gross amount AD02010_TOTAL_GRAMT
		
		getDriver().findElement(By.xpath(pObject.AD02010_TOTAL_TXAMT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TOTAL_TXAMT)).sendKeys(elements.get(3));//Total tax amount AD02010_TOTAL_TXAMT
		
		
		if(transtype.equals("Invoice")){
			
			
			getDriver().findElement(By.xpath(pObject.AD02010_PERI)).clear();
			getDriver().findElement(By.xpath(pObject.AD02010_PERI)).sendKeys(elements.get(4));//Period AD02010_PERI
			
			getDriver().findElement(By.xpath(pObject.AD02010_YR)).clear();
			getDriver().findElement(By.xpath(pObject.AD02010_YR)).sendKeys(String.valueOf(calender.fromyear()));;//Year AD02010_YR
			getDriver().findElement(By.xpath(pObject.AD02010_YR)).sendKeys(Keys.ENTER);//Year AD02010_YR
		
		}
		
		
		if(transtype.equals("Transaction")){
				
				getDriver().findElement(By.xpath(pObject.AD02010_MODE)).clear();
				getDriver().findElement(By.xpath(pObject.AD02010_MODE)).sendKeys(elements.get(5));//Mode AD02010_MODE
				getDriver().findElement(By.xpath(pObject.AD02010_MODE)).sendKeys(Keys.ENTER);//Mode AD02010_MODE
				WaitHelper.waitAdditional(2);		
		}
			
		
	}
	
	
/************************************************
 * Amending Sony Supplier Tax as per TC AD10001
 * **********************************************/

	public void aMendSupplierTaxInfo(List<String> elements)
	{
		log.info("Amend Tax Tab information for any supplier");
		
		WaitHelper.waitAdditional(4);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).clear();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(1));//Tax Type
		WaitHelper.waitAdditional(1);																	
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.TAB);//Tax Type
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).clear();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(2));// Tax Code
		WaitHelper.waitAdditional(1);																	
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(Keys.TAB);// Tax Code
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).clear();// Handling Code
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(3));// Handling Code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(Keys.ENTER);//Handling Code
		WaitHelper.waitAdditional(3);

		
	}
	

	
	/**
	 * Get invoice details and amend invoice
	 * @param elements
	 * @param orderNumber
	 * @return
	 * AD10006-GBB
	 */
	
public boolean getInvoice(List<String> elements,String orderNumber){
		log.info("In get invoice details method");
		
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO)).clear();
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO)).sendKeys(orderNumber);//Order AD02010_ORDER
		
		
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.THREE)).clear();
//		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.THREE)).sendKeys(elements.get(0));//Order
		
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).clear();
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).sendKeys(elements.get(1));//Gross amount
		
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO+pObject.ZERO)).clear();
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO+pObject.ZERO)).sendKeys(elements.get(2));//Tax amount
		
        Calendar currentMonth = Calendar.getInstance();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
        String currDate = dateFormat1.format(currentMonth.getTime());
		
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.SIX)).clear();
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.SIX)).sendKeys(currDate);//Date

		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.SEVEN)).clear();
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.SEVEN)).sendKeys(currDate);//Due Date
		
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);//Order
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.SIX)).sendKeys(currDate);//Date
		
		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.THIRD_TAB)).click();//Tax/Discount tab
		getDriver().findElement(By.xpath(pObject.ZERO_+pObject.FOUR+pObject.ONE)).sendKeys(Keys.ENTER);//Tax type
		getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Main tab
		
		int postCode = getDriver().findElement(By.xpath(pObject.ZERO_+pObject.SEVEN)).getAttribute("value").length();
		int element = getDriver().findElement(By.xpath(pObject.ZERO_+pObject.NINE)).getAttribute("value").length();
		int period = getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.ONE)).getAttribute("value").length();
		int year = getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.TWO)).getAttribute("value").length();
		int subType = getDriver().findElement(By.xpath(pObject.ZERO_+pObject.ONE+pObject.FOUR)).getAttribute("value").length();
		
		if(postCode>0 && element>0 && period>0&& year>0 && subType>0){
			update = true;
		}
		return update;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public boolean getInvoice(List<String> elements,String orderNumber){
//		log.info("In get invoice details method");
//		
//		boolean update = false;
//		WaitHelper.waitAdditional(2);
//		
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(orderNumber);//Order AD02010_ORDER
//		
//		
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE)).clear();
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE)).sendKeys(elements.get(0));//Order
//		
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).clear();
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).sendKeys(elements.get(1));//Gross amount
//		
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ZERO)).clear();
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ZERO)).sendKeys(elements.get(2));//Tax amount
//		
//        Calendar currentMonth = Calendar.getInstance();
//        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
//        String currDate = dateFormat1.format(currentMonth.getTime());
//		
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).clear();
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).sendKeys(currDate);//Date
//
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SEVEN)).clear();
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SEVEN)).sendKeys(currDate);//Due Date
//		
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);//Order
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).sendKeys(currDate);//Date
//		
//		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.THIRD_TAB)).click();//Tax/Discount tab
//		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.ONE)).sendKeys(Keys.ENTER);//Tax type
//		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Main tab
//		
//		int postCode = getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).getAttribute("value").length();
//		int element = getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).getAttribute("value").length();
//		int period = getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).getAttribute("value").length();
//		int year = getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).getAttribute("value").length();
//		int subType = getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR)).getAttribute("value").length();
//		
//		if(postCode>0 && element>0 && period>0&& year>0 && subType>0){
//			update = true;
//		}
//		return update;
//	}
	

	
	/*Amend reference : A11008*/
	public void amendTransactionDetails(String element){
		log.info("Amend transaction details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(element);//Reference
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).clear();
		
	    Calendar currentMonth = Calendar.getInstance();
	    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
	    String currDate = dateFormat1.format(currentMonth.getTime());

	    getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).sendKeys(currDate);//Due date
	    WaitHelper.waitAdditional(1);
	    getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).sendKeys(Keys.ENTER);//Due date
	    WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Verify transaction details
	 * @param elements
	 * @return
	 * AD11008
	 */
	public boolean verifyTransactionDetails(String elements){
		log.info("Verify transaction details");
		boolean amendInvoice = false;
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/th[3]/div/div")).getText().contains("Transaction Ref");//Transaction Ref
		String tranRef = getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[3]")).getText();// value
		
		if(tranRef.contains(elements)){
			amendInvoice = true;
			log.info("Transaction reference is : " + tranRef);
		}
		
		getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/th[4]/div/div")).getText().contains("Transaction date");//Transaction date
		String date = getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]")).getText();// value
		
	    Calendar currentMonth = Calendar.getInstance();
	    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
	    String currDate = dateFormat1.format(currentMonth.getTime());

	    if(date.equals(currDate)){
	    	amendInvoice = true;
	    }
		
		return amendInvoice;
	}
		
	/*
	 * 
	 * Amend AP company control
	 * AD10002, AD10005
	 * 
	 */
	
	
	public void amendAPCompanyControl(int i,String value){
		log.info("Amend company control");
		WaitHelper.waitAdditional(2);
		
		if (i==4)
		{
		getDriver().findElement(By.xpath(pObject.A056_TAX_DRN_IND)).sendKeys(value);
		getDriver().findElement(By.xpath(pObject.A056_TAX_DRN_IND)).sendKeys(value);
		WaitHelper.waitAdditional(2); 
		}
		
		else if (i==3)
		{
			getDriver().findElement(By.xpath(pObject.A056_FOC_IND)).sendKeys(value);
			getDriver().findElement(By.xpath(pObject.A056_FOC_IND)).sendKeys(value);
			WaitHelper.waitAdditional(2);
			
		}
		
	}
	
	
	
	/**
	 * Enter transaction details , Separating function for AD02010 as not sure about other test case data order number
	 * 
	 */
	
	public void enterTransactionWithOdr(List<String> elements,String Ordernumber,String dueDate){
		log.info("Enter transaction details");
		WaitHelper.waitAdditional(2);
//		if(!elements.get(0).equals("null")){
		
		getDriver().findElement(By.xpath(pObject.AD02010_ORDER)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_ORDER)).sendKeys(Ordernumber);//Order AD02010_ORDER
		getDriver().findElement(By.xpath(pObject.AD02010_ORDER)).sendKeys(Keys.ENTER);//Order AD02010_ORDER
		
		/*getDriver().findElement(By.xpath(pObject.A091_SUPP)).clear();
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(elements.get(1));//Supplier A091_SUPP
		
		getDriver().findElement(By.xpath(pObject.AD02010_POSTCD)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_POSTCD)).sendKeys(elements.get(2));//Post code AD02010_POSTCD
		
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(3));//Element A029_ELEMENT
		
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_PERI)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_PERI)).sendKeys(elements.get(4));//Period AD02010_TR_PERI
		
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_YR)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_YR)).sendKeys(String.valueOf(calender.fromyear()));;//Year AD02010_TR_YR
				
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_STYP)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_STYP)).sendKeys(elements.get(8));//Sub type AD02010_TRN_STYP
		
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).clear();
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(elements.get(10));//Currency A002_CURRENCY
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(Keys.ENTER);//Currency A002_CURRENCY
*/		

		getDriver().findElement(By.xpath(pObject.AD02010_TRN_REF)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_REF)).sendKeys(Ordernumber);//Reference AD02010_TRN_REF
		
		getDriver().findElement(By.xpath(pObject.AD02010_DT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_DT)).sendKeys(String.valueOf(calender.Presentdate()));//Date AD02010_DT
		WaitHelper.waitAdditional(2);
	
		getDriver().findElement(By.xpath(pObject.AD02010_GRS_AMT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_GRS_AMT)).sendKeys(elements.get(7));//Gross amount AD02010_GRS_AMT

		getDriver().findElement(By.xpath(pObject.AD02010_TAX_AMT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TAX_AMT)).sendKeys(elements.get(9));//Tax amount AD02010_TAX_AMT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_TAX_AMT)).sendKeys(Keys.ENTER);//Tax amount AD02010_TAX_AMT
		WaitHelper.waitAdditional(1);

		WaitHelper.waitAdditional(2);
		
		if(!dueDate.equals("null")){
			getDriver().findElement(By.xpath(pObject.AD02010_DUE_DT)).clear();//Due Date
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD02010_DUE_DT)).sendKeys(String.valueOf(calender.TOdate()));//Due Date  AD02010_DUE_DT
			WaitHelper.waitAdditional(1);
		}
		
		if(elements.get(11).equals(1)){
			
			ClickOnAnyTab("Tax/Payment", 1);
			WaitHelper.waitAdditional(4);
			getDriver().findElement(By.xpath(pObject.AD02010_CHK_TX_ONL)).click();//Tax only AD02010_CHK_TX_ONL
			WaitHelper.waitAdditional(1);
		}
		if(!elements.get(12).equals("null") && !elements.get(12).equals("Week")){
			

			
			getDriver().findElement(By.xpath(pObject.AD02010_TAX_CD)).clear();
			getDriver().findElement(By.xpath(pObject.AD02010_TAX_CD)).sendKeys(elements.get(12));//Tax code AD02010_TAX_CD

			getDriver().findElement(By.xpath(pObject.AD02010_TAX_TYP)).clear();
			getDriver().findElement(By.xpath(pObject.AD02010_TAX_TYP)).sendKeys(elements.get(13));//Tax type AD02010_TAX_TYP

		}
		if(elements.get(12).equals("Week")){
			
			ClickOnAnyTab("Discount", 1);
			WaitHelper.waitAdditional(4);

			getDriver().findElement(By.xpath(pObject.AD02010_RECUR_FEQ)).sendKeys(elements.get(12));//Recurring frequency AD02010_RECUR_FEQ
			getDriver().findElement(By.xpath(pObject.AD02010_RECUR_FEQ)).sendKeys(elements.get(12));

			getDriver().findElement(By.xpath(pObject.AD02010_RECUR_OCCUR)).clear();
			getDriver().findElement(By.xpath(pObject.AD02010_RECUR_OCCUR)).sendKeys(elements.get(13));//Occurrences AD02010_RECUR_OCCUR

		}
	}
	
	
	/**
	 * Enter transaction details AD10002, AD10004,AD10005,AD10014,AD11010, AD11014, AD10006
	 * 
	 */	
	
	public void enterTransactionDetails(List<String> elements,String Ordernumber, String dueDate){
		log.info("Enter transaction details");
		WaitHelper.waitAdditional(2);
		
		if(!Ordernumber.equals("null")){
		
		getDriver().findElement(By.xpath(pObject.AD02010_ORDER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_ORDER)).sendKeys(Ordernumber);//Order AD02010_ORDER
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_ORDER)).sendKeys(Keys.ENTER);//Order AD02010_ORDER
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_REF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_REF)).sendKeys(elements.get(6));//Reference AD02010_TRN_REF
		
		getDriver().findElement(By.xpath(pObject.AD02010_DT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_DT)).sendKeys(String.valueOf(calender.Presentdate()));//Date AD02010_DT
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.AD02010_GRS_AMT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_GRS_AMT)).sendKeys(elements.get(7));//Gross amount AD02010_GRS_AMT

	
		getDriver().findElement(By.xpath(pObject.AD02010_TAX_AMT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TAX_AMT)).sendKeys(elements.get(9));//Tax amount AD02010_TAX_AMT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_TAX_AMT)).sendKeys(Keys.ENTER);//Tax amount AD02010_TAX_AMT
		
		}
	
		else {
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).clear();
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(elements.get(1));//Supplier A091_SUPP
		
		getDriver().findElement(By.xpath(pObject.AD02010_POSTCD)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_POSTCD)).sendKeys(elements.get(2));//Post code AD02010_POSTCD
		
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(3));//Element A029_ELEMENT
		
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_PERI)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_PERI)).sendKeys(elements.get(4));//Period AD02010_TR_PERI
		
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_YR)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_YR)).sendKeys(String.valueOf(calender.fromyear()));;//Year AD02010_TR_YR
		
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_REF)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_REF)).sendKeys(elements.get(6));//Reference AD02010_TRN_REF
		
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_STYP)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TRN_STYP)).sendKeys(elements.get(8));//Sub type AD02010_TRN_STYP
		
		getDriver().findElement(By.xpath(pObject.AD02010_DT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02010_DT)).sendKeys(String.valueOf(calender.Presentdate()));//Date AD02010_DT
		WaitHelper.waitAdditional(2);
		
	

		if(!dueDate.equals("null")){
			getDriver().findElement(By.xpath(pObject.AD02010_DUE_DT)).clear();//Due Date
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.AD02010_DUE_DT)).sendKeys(String.valueOf(calender.Presentdate()));//Due Date  AD02010_DUE_DT
			WaitHelper.waitAdditional(1);
			}
		
		getDriver().findElement(By.xpath(pObject.AD02010_GRS_AMT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_GRS_AMT)).sendKeys(elements.get(7));//Gross amount AD02010_GRS_AMT

	
		getDriver().findElement(By.xpath(pObject.AD02010_TAX_AMT)).clear();
		getDriver().findElement(By.xpath(pObject.AD02010_TAX_AMT)).sendKeys(elements.get(9));//Tax amount AD02010_TAX_AMT
		WaitHelper.waitAdditional(1);
	

		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).clear();
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(elements.get(10));//Currency A002_CURRENCY
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(Keys.ENTER);//Currency A002_CURRENCY
		
		WaitHelper.waitAdditional(2);
		
		if(elements.get(11).equals("1")){
			
			ClickOnAnyTab("Tax/Payment", 1);
			WaitHelper.waitAdditional(4);
			getDriver().findElement(By.xpath(pObject.AD02010_CHK_TX_ONL)).click();//Tax only AD02010_CHK_TX_ONL
			WaitHelper.waitAdditional(1);
		}
		
		
		if(!elements.get(12).equals("null") && !elements.get(12).equals("Week")){
			
			ClickOnAnyTab("Tax/Payment", 1);
			WaitHelper.waitAdditional(4);
			getDriver().findElement(By.xpath(pObject.AD02010_TAX_CD)).clear();
			getDriver().findElement(By.xpath(pObject.AD02010_TAX_CD)).sendKeys(elements.get(12));//Tax code AD02010_TAX_CD

			getDriver().findElement(By.xpath(pObject.AD02010_TAX_TYP)).clear();
			getDriver().findElement(By.xpath(pObject.AD02010_TAX_TYP)).sendKeys(elements.get(13));//Tax type AD02010_TAX_TYP

		}
		if(elements.get(12).equals("Week")){
			
			ClickOnAnyTab("Discount", 1);
			WaitHelper.waitAdditional(4);

			getDriver().findElement(By.xpath(pObject.AD02010_RECUR_FEQ)).sendKeys(elements.get(12));//Recurring frequency AD02010_RECUR_FEQ
			getDriver().findElement(By.xpath(pObject.AD02010_RECUR_FEQ)).sendKeys(elements.get(12));

			getDriver().findElement(By.xpath(pObject.AD02010_RECUR_OCCUR)).clear();
			getDriver().findElement(By.xpath(pObject.AD02010_RECUR_OCCUR)).sendKeys(elements.get(13));//Occurrences AD02010_RECUR_OCCUR

		}
		
		}
	
	}	
	

	/**
	 * Verify invoice details AD02010
	 * @param elements
	 */
	
	public boolean enterInvoiceDetails(List<String> elements){
		boolean verify = false;
		
		verify = getDriver().findElement(By.xpath(pObject.AD02010_INV_PRC)).getText().trim().equals("Invoice Price");//Invoice Price header AD02010_INV_PRC
		WaitHelper.waitAdditional(1);
		verify = getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).getText().trim().equals(elements.get(1));//Invoice Price value
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();//Invoice Price value
		getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).sendKeys(Keys.TAB);//Invoice Price value
		
		
		WaitHelper.waitAdditional(1);
		
		
		verify = getDriver().findElement(By.xpath(pObject.AD02010_INV_QTY)).getText().trim().equals("Invoice Qty");//Invoice QTY header AD02010_INV_QTY
		verify = getDriver().findElement(By.xpath("//div[text()='Invoice Qty']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[5]")).getText().trim().equals(elements.get(2));//Invoice QTY value
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div[text()='Invoice Qty']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[5]")).click();
		getDriver().findElement(By.xpath("//div[text()='Invoice Qty']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[5]")).sendKeys(Keys.TAB);
		
		verify = getDriver().findElement(By.xpath(pObject.AD02010_ITEM)).getText().trim().equals("Item");//Item header AD02010_ITEM
		verify = getDriver().findElement(By.xpath("//div[text()='Item']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[8]")).getText().trim().equals(elements.get(5));//Item value
		WaitHelper.waitAdditional(2);
	
		return verify;
		
	}

	
	
	/************************************************
	 * Enter Invoices : HBA AD03001
	 * **********************************************/


	
	public void addStoreTransferDetails(List<String> elements){
		log.info("Add store transfer details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A106_STORE)).clear();//A106_STORE
		getDriver().findElement(By.xpath(pObject.A106_STORE)).sendKeys(elements.get(0));//Store A106_STORE
		getDriver().findElement(By.xpath(pObject.AD03001_RCPT_STORE)).clear();
		getDriver().findElement(By.xpath(pObject.AD03001_RCPT_STORE)).sendKeys(elements.get(1));//Receipt store AD03001_RCPT_STORE
	}	
	
	
	
	/**
	 * Click on Forward button
	 */
	public void clickOnFwdButton(){
		log.info("Clicking on Forward button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAlllButton();
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Fwd")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on Forward button
	 */
	public void clickOnDetailButton(){
		log.info("Clicking on detail button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAlllButton();
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Detail")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	private WebElement getReportValue(int i){
		return getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td"));
	}
	
	/**
	 * Verify RHED report
	 * @param elements
	 * @return
	 */
	public boolean verifyRHEDReport(List<String> elements){
		log.info("Verify RHED report template");
		boolean verifyReport = false;
		WaitHelper.waitAdditional(2);

		verifyReport =  getReportValue(3).getText().trim().contains(elements.get(1));//From store
		verifyReport =  getReportValue(4).getText().trim().contains(elements.get(2));//Road and detail
		verifyReport =  getReportValue(5).getText().trim().contains(elements.get(3));//Tel
		verifyReport =  getReportValue(6).getText().trim().contains(elements.get(4));//Fax
		verifyReport =  getReportValue(7).getText().trim().contains(elements.get(5));//Contact
		verifyReport =  getReportValue(11).getText().trim().contains(elements.get(6));//To store
		verifyReport =  getReportValue(12).getText().trim().contains(elements.get(7));//To Road
		verifyReport =  getReportValue(19).getText().trim().contains(elements.get(8));//Document reference
		
		WaitHelper.waitAdditional(1);
		clickOnFwdButton();
		
		verifyReport =  getReportValue(1).getText().trim().contains(elements.get(9));//Line item
		verifyReport =  getReportValue(2).getText().trim().contains(elements.get(10));//Description
		
		verifyReport =  getReportValue(4).getText().contains(elements.get(11));//Item details
		verifyReport =  getReportValue(5).getText().trim().contains(elements.get(12));//Item
		verifyReport =  getReportValue(8).getText().contains(elements.get(13));//Document value
		
		WaitHelper.waitAdditional(2);
		return verifyReport;
	}
	

	/**
	 * Click on view document -ARA
	 */
	public void clickOnViewDocument(){
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for(WebElement wb2 : wbs1){
			if(wb2.getText().trim().equals("View Document")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	
	/**
	 * Click on view document -ARA
	 */
	public void clickOnSelectCheck(){
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.AD03001_CHK_SELRPT)).click();
	}	
	
	
	/************************************************
	 * Enter Invoices : GCA AD10001
	 * **********************************************/
	public void logTransactionDetails(List<String> elements){
		log.info("Log transaction details");
		WaitHelper.waitAdditional(2);
		
		ClickOnAnyTab("Main", 1);
		WaitHelper.waitAdditional(3);
		
		getDriver().findElement(By.xpath("//div[text()='Supplier']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]")).click();////Supplier
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Supplier']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(0));////Supplier
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Supplier Postcode']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]")).click();//Supplier post code
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Supplier Postcode']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(1));//Supplier post code
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Supplier Postcode']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.TAB);//Supplier post code
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[text()='Transaction Ref.']/../../../../../../../../../..//div[1]/table/tbody/tr/td[9]")).click();//Supplier post code
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Transaction Ref.']/../../../../../../../../../..//div[1]/table/tbody/tr/td[9]/input")).sendKeys(elements.get(5));//Supplier post code
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Transaction Ref.']/../../../../../../../../../..//div[1]/table/tbody/tr/td[9]/input")).sendKeys(Keys.TAB);//Supplier post code
		WaitHelper.waitAdditional(1.5);
			
		getDriver().findElement(By.xpath("//div[text()='Date']/../../../../../../../../../..//div[1]/table/tbody/tr/td[10]")).click();//Date
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Date']/../../../../../../../../../..//div[1]/table/tbody/tr/td[10]/input")).sendKeys(String.valueOf(calender.Presentdate()));//Date
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Date']/../../../../../../../../../..//div[1]/table/tbody/tr/td[10]/input")).sendKeys(Keys.TAB);//Date
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Due Date']/../../../../../../../../../..//div[1]/table/tbody/tr/td[11]/input")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Sub Type']/../../../../../../../../../..//div[1]/table/tbody/tr/td[12]")).click();//Sub type
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Sub Type']/../../../../../../../../../..//div[1]/table/tbody/tr/td[12]/input")).sendKeys(elements.get(2));//Sub type
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Sub Type']/../../../../../../../../../..//div[1]/table/tbody/tr/td[12]/input")).sendKeys(Keys.TAB);//Sub type
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Gross Amount']/../../../../../../../../../..//div[1]/table/tbody/tr/td[14]")).click();//Gross amount
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Gross Amount']/../../../../../../../../../..//div[1]/table/tbody/tr/td[14]/input")).sendKeys(elements.get(3));//Gross amount
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Gross Amount']/../../../../../../../../../..//div[1]/table/tbody/tr/td[14]/input")).sendKeys(Keys.TAB);//Gross amount
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Tax Amount']/../../../../../../../../../..//div[1]/table/tbody/tr/td[15]")).click();//Tax Amount
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Tax Amount']/../../../../../../../../../..//div[1]/table/tbody/tr/td[15]/input")).sendKeys(elements.get(4));//Tax Amount
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Tax Amount']/../../../../../../../../../..//div[1]/table/tbody/tr/td[15]/input")).sendKeys(Keys.TAB);//Tax Amount
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Order Reference']/../../../../../../../../../..//div[1]/table/tbody/tr/td[16]/input")).sendKeys(Keys.TAB);
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Element']/../../../../../../../../../..//div[1]/table/tbody/tr/td[17]")).click();//Element
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Element']/../../../../../../../../../..//div[1]/table/tbody/tr/td[17]/input")).sendKeys(elements.get(6));//Element
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Element']/../../../../../../../../../..//div[1]/table/tbody/tr/td[17]/input")).sendKeys(Keys.ENTER);//Element
		WaitHelper.waitAdditional(1.5);
		
		ClickOnAnyTab("GL Account", 1);
		WaitHelper.waitAdditional(3);
		
		
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]")).click();//Account
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(8));//Account
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]")).click();//Cost
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(9));//Cost
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(Keys.ENTER);//Cost
		WaitHelper.waitAdditional(2);

	}
	
	
	/************************************************
	 * Enter Invoices : GCA AD10002, AD10006
	 * **********************************************/
	
	public String enterTaxableDetails(List<String> elements,int glValue){
		log.info("Enter taxable details");
		String price="";
		WaitHelper.waitAdditional(2);
		
		
		WebElement desc = driver.findElement(By.xpath(("//div[text()='Description']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", desc);
		
		ClickOnAnyTab("Main", 1);
		
		WaitHelper.waitAdditional(3);
	
		if(!elements.get(0).equals("null")){
			
			getDriver().findElement(By.xpath("//div[text()='Description']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]")).click();//Description
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Description']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(0));//Description
			WaitHelper.waitAdditional(1.5);
		}
		
		if(!elements.get(1).equals("null")){
			
			getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();////invoice Price
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(1));//invoice Price
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);//invoice Price
			WaitHelper.waitAdditional(1.5);
		}
		
		
		else {
			
			price = getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).getText();
			getDriver().findElement(By.xpath("//div[text()='Select']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).click();//Select
			getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();////invoice Price
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Invoice Price']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);//invoice Price
			WaitHelper.waitAdditional(1.5);
					
		}
		
		if(!elements.get(2).equals("null")){
			
			getDriver().findElement(By.xpath("//div[text()='Invoice Qty']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]")).click();////invoice QTY
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Invoice Qty']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).clear();//invoice QTY
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Invoice Qty']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(2));//invoice QTY
			WaitHelper.waitAdditional(1.5);
			
			
			getDriver().findElement(By.xpath("//div[text()='Invoice Qty']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);//invoice QTY
			WaitHelper.waitAdditional(5);
		}		

		if(glValue==1){
			
			ClickOnAnyTab("GL Details", 1);
			WaitHelper.waitAdditional(4);
			getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]")).click();//Account
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(3));//Account
			WaitHelper.waitAdditional(1.5);
			
			getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();//Cost
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(4));//Cost
			WaitHelper.waitAdditional(1.5);
			
			getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.ENTER);//Cost
			WaitHelper.waitAdditional(2);

		}
		
		if(glValue==2){
			
			ClickOnAnyTab("GL Details", 1);
			WaitHelper.waitAdditional(4);
			
			getDriver().findElement(By.xpath("//div[text()='S/A type']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]")).click();//S/A type
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='S/A type']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).sendKeys("1");//S/A type
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='S/A type']/../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input")).sendKeys(Keys.ENTER);//S/A type
			WaitHelper.waitAdditional(3);

		}
		
		if(glValue==3){
			
			ClickOnAnyTab("Tax Controls", 1);
			WaitHelper.waitAdditional(4);
			
			getDriver().findElement(By.xpath("//div[text()='Handling']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();//Handling
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Handling']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).clear();
			getDriver().findElement(By.xpath("//div[text()='Handling']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(6));//Handling
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[text()='Handling']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.ENTER);//Handling
			
		}
		
		
		return price;
	}
		
	
	
//	public String enterTaxableDetails(List<String> elements,int glValue){
//		log.info("Enter taxable details");
//		String price="";
//		WaitHelper.waitAdditional(2);
		
		
		
//		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Main tab
//		WaitHelper.waitAdditional(1);
//		Actions builder = new Actions(driver);
//		
//		WaitHelper.waitAdditional(3);
//		if(!elements.get(0).equals("null")){
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[3]"))).click().sendKeys(elements.get(0)).build().perform();////Description		
//			WaitHelper.waitAdditional(5);
//		}
//		if(!elements.get(1).equals("null")){
//		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]"))).click().sendKeys(elements.get(1)).build().perform();////Price	
//			WaitHelper.waitAdditional(5);
//		}
//		else{
//			price = driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]")).getText();
//			
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click().build().perform();////Description
//		}
//		if(!elements.get(2).equals("null")){
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]"))).click().sendKeys("\u0008").sendKeys("\u0008").sendKeys("\u0008").sendKeys("\u0008").sendKeys("\u0008").sendKeys("\u0008").build().perform();
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]"))).click().sendKeys(elements.get(2)).build().perform();//Quantity		
//			WaitHelper.waitAdditional(5);
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]"))).click().sendKeys(Keys.ENTER).build().perform();////Quantity		
//			WaitHelper.waitAdditional(5);
//		}		
//
//		if(glValue==1){
//			getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//GL account tab
//			WaitHelper.waitAdditional(5);
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[3]"))).click().sendKeys(elements.get(3)).build().perform();////Account		
//			WaitHelper.waitAdditional(5);
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[4]"))).click().sendKeys(elements.get(4)).build().perform();////cost		
//			WaitHelper.waitAdditional(5);
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[4]"))).click().sendKeys(Keys.ENTER).build().perform();////cost		
//			WaitHelper.waitAdditional(5);
//		}
//		
//		if(glValue==2){
//			getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//S/L analysis tab
//			WaitHelper.waitAdditional(5);
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]"))).click().sendKeys("1").build().perform();//S/A type		
//			WaitHelper.waitAdditional(5);
//			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]"))).click().sendKeys(Keys.ENTER).build().perform();//S/A type		
//			WaitHelper.waitAdditional(5);
//
//		}
//		return price;
//	}
	
	/**
	 * Enter transaction split 
	 * @param elements AD10005
	 */
	public void enterTranSplitAnalysis(List<String> elements){
		log.info("Enter Transaction Split Analysis details");
		WaitHelper.waitAdditional(2);
		
		ClickOnAnyTab("Details", 1);
		WaitHelper.waitAdditional(3);
		
		getDriver().findElement(By.xpath("//div[text()='Percent']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]")).click();//Percent
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Percent']/../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(0));//Percent
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]")).click();//Account
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Account']/../../../../../../../../../..//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(1));//Account
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]")).click();//Cost
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[text()='Cost']/../../../../../../../../../..//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(2));//Cost
		WaitHelper.waitAdditional(1.5);
		

	}
	
	/************************************************
	 * Enter Invoice Due Today : GZA AD10014, AD10017
	 * **********************************************/
	
	public boolean verifySupplierTransaction(List<String> elements){
		log.info("Verify supplier transaction");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		update = getDriver().findElement(By.xpath("//th[@id='0_40Hdr2']")).getText().contains("Transaction Ref");//Transaction Ref header
		String tranRef = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).getText();// Transaction Ref value
		
		if(tranRef.length()>0){
			log.info("Transaction reference is : " + tranRef);
		}
		
		update = getDriver().findElement(By.xpath("//th[@id='0_40Hdr4']")).getText().contains("Legend");//Legend
		update = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).getText().equals(elements.get(1));// value

		update= getDriver().findElement(By.xpath("//th[@id='0_40Hdr5']")).getText().contains("Trans Status Desc");//Trans Status Desc
		update= getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]")).getText().equals(elements.get(2));// value

		update= getDriver().findElement(By.xpath("//th[@id='0_40Hdr6']")).getText().contains("Auth Status Desc");//Auth Status Desc
		update= getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]")).getText().equals(elements.get(3));// value
	
		update= getDriver().findElement(By.xpath("//th[@id='0_40Hdr7']")).getText().contains("Outstanding Amount");//Outstanding Amount
		update= getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[8]")).getText().equals(elements.get(4));//Value	
		
		return update;
	}	
	
	/**add authorisors
	 * 
	 * @param companyId
	 * @param elements
	 */
	public void addAuthorisors(String companyId,List<String> elements){
		log.info("Add authorisors to transaction");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyId);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(0));//Authorizer
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(1));//Supplier

		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE+pObject.LABEL)).click();//Ok button
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE+pObject.LABEL)).click();//Select button
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR+pObject.LABEL)).click();//Authorize button
		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE+pObject.LABEL)).click();//Confirm button				
	}
	
	
	/************************************************
	 * Create Manual Payment Schedule : AD10015 
	 * **********************************************/
	public void scheduleMaintenance(List<String> elements){
		log.info("Payment Schedule");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(0));//Payment method
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(1));//Payment code
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).sendKeys(elements.get(2));//Currency
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FOUR)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FOUR)).sendKeys(elements.get(3));//Print distribution
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FOUR)).sendKeys(Keys.ENTER);//Print distribution
		WaitHelper.waitAdditional(2);
		
	}
	
	/**
	 * Enter schduler details for supplier
	 * @param elements
	 */
	public void enterSchedueSupplierTranDetails(List<String> elements){
		log.info("In Schedue Supplier Tran Details");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(4));//Supplier
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(5));//Payment address
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(Keys.ENTER);//Payment address
		WaitHelper.waitAdditional(2);
		
	}
	
	/**
	 * Enter schedule request
	 * @param bankCode
	 */
	public void enterScheduleRequestRun(String bankCode){
		log.info("Enter schedule request");
		WaitHelper.waitAdditional(2);
		
		Actions builder = new Actions(driver);
		
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click().sendKeys(bankCode).build().perform();//Bank code		
		WaitHelper.waitAdditional(5);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click().sendKeys(Keys.ENTER).build().perform();		
		WaitHelper.waitAdditional(4);				
	}
	
	/**
	 * Verify status
	 * int i is column value of status=td[7]
	 * int j is place value of element from xml file
	 * @return
	 */
	public boolean verifyStatus(int i, int j, List<String> elements){
		boolean verify = false;
		
		verify = getDriver().findElement(By.xpath(pObject.AD02013_STATUS)).getText().contains("Status");//Status header AD02001_JRNL_ACC
		
		verify = getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td["+i+"]")).getText().equals(elements.get(j));//Status value
	
		return verify;
	}
	
	/************************************************
	 * Create Schedules : AD10016
	 * **********************************************/
	
	public void searchRequest(List<String> elements,int i){
		log.info("Search request");
		WaitHelper.waitAdditional(2);
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(0));//Schedule

		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(1));//Process
		
		getDriver().findElement(By.id(pObject.ZERO_+i+pObject.LABEL)).click();//Ok button
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Create schedules
	 * @param elements
	 */
	public void createSchedules(List<String> elements){
		log.info("Create schedules");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Schedule
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR)).click();//Dependent
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(2));//Dependency Level

		
		Actions builder = new Actions(driver);
		int j = 3;
		for(int i=1;i<=9;i++){
			WaitHelper.waitAdditional(5);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click()
				.sendKeys(elements.get(j)).sendKeys(Keys.ENTER).build().perform();//Process		
			
			WaitHelper.waitAdditional(5);
			if(i>=2){
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[4]"))).click()
				.sendKeys(elements.get(j-1)).sendKeys(Keys.ENTER).build().perform();//Parent		
				WaitHelper.waitAdditional(5);
			}
			j++;
		}
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(Keys.ENTER);//Description
		WaitHelper.waitAdditional(3);
		
	}
	
	/**
	 * Enter request details
	 * @param elements
	 * @return
	 */
	public boolean enterRequestDetails(List<String> elements){
		log.info("Enter request details");
		WaitHelper.waitAdditional(2);
		boolean update = false;
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//User
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(1));//Schedule
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(2));//Process
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(3));//Request
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(Keys.ENTER);//Description
		WaitHelper.waitAdditional(1);
		if(!getToolContentText().contains(message)){
			update = true;
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(elements.get(4));//Description
		
		
	
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.NINE)).click();//Default reports
		return update;
	}
	
	/**
	 * click On maintain reports
	 */
	public void clickOnMaintainReports(){
		log.info("Clicking on Maintain reports");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Maintain")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Reports")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
	
	/**
	 * Enter report details
	 * @param elements
	 */
	public void enterReportDetails(List<String> elements){
		log.info("Enter report details");
		WaitHelper.waitAdditional(2);
		Actions builder = new Actions(driver);
		
		int report = Integer.parseInt(elements.get(2));
		int j=3;
		for(int i=1;i<=report;i++){
			
			WaitHelper.waitAdditional(3);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click()
										.sendKeys(elements.get(j)).build().perform();//Report		
			WaitHelper.waitAdditional(3);	
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[3]"))).click()
										.sendKeys(elements.get(j+1)).build().perform();//Retain days		
			WaitHelper.waitAdditional(3);	
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[3]"))).click()
										.sendKeys(Keys.ENTER).build().perform();//Retain days
			WaitHelper.waitAdditional(3);
			j=j+2;
		}
		
			
	}
	
	/**
	 * click On maintain parameters
	 */
	public void clickOnMaintainParameters(){
		log.info("Clicking on Maintain parameters");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Maintain")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Parameters")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
	
	

	/**
	 * 
	 * 
	 * 
	 * click On maintain parameters
	 */
	
	
	public void clickOnAmendClassification(){
		log.info("Clicking on Purge button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Amend")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Classifications")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
	
	/**
	 * Update company parameters
	 * @param companyId
	 * @param element
	 */
	public void updateParameters(String companyId,String element){
		log.info("Update parameters");
		WaitHelper.waitAdditional(2);
		
		Actions builder = new Actions(driver);

		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click()
				.sendKeys(companyId).build().perform();//Company
		WaitHelper.waitAdditional(3);
			
		if(element.equals(1)){
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]"))).click()
						.sendKeys(element).build().perform();//Cheque sequence
			WaitHelper.waitAdditional(2);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]"))).click()
					.sendKeys(Keys.ENTER).build().perform();//Cheque sequence
		}
		else{
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click()
					.sendKeys(Keys.ENTER).build().perform();//Company
		}
		WaitHelper.waitAdditional(5);
	}
	
	/************************************************
	 * Submit Payment Processing : AD10017 
	 * **********************************************/

	/*Schedules ANM*/
	public void submitSchedules(List<String> elements){
		log.info("In submit schedules");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Schedule
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
	}
	
	/************************************************
	 * Cheque Number Allocation : AD10018
	 * **********************************************/

	
	/**
	 * click On Cheques 
	 */
	public void clickOnChequesAmend(){
		log.info("Clicking on Purge button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Cheques")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Amend")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
		
	/**
	 * Log supplier financial limit
	 * @param elements
	 * @param reviewDate
	 */
	public void logSupplierFinanacialLimit(List<String> elements,String reviewDate){
		log.info("Log supplier finanacial limit");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.TWO)).click();//Financial limit check box
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(reviewDate);	
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(reviewDate);	
		
		Actions builder = new Actions(driver);
		
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click()
				.sendKeys(elements.get(1)).build().perform();//Start date		
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[3]"))).click()
				.sendKeys(elements.get(2)).build().perform();//Financial limit		
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]"))).click()
				.sendKeys(elements.get(3)).build().perform();//Tolrn value		
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]"))).click()
				.sendKeys(elements.get(4)).build().perform();//Tolrn %		
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * click On Go-->Limits 
	 */
	public void clickOnGoLimits(){
		log.info("Click on Go limits");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Go")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Limits")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
	
	/**
	 * click On Go-->Limits 
	 */
	public void clickOnGoSplitAnalysis(){
		log.info("Clicking on Purge button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Go")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Split Anal")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Unauthorised Transaction : Verify column header and column value
	 * @param elements
	 * AD10014, AD11010
	 * 
	 */
	public boolean verifyUnauthorisedTransaction(List<String> elements){
		log.info("Verify store item header and value");
	
		boolean update = false;
		WaitHelper.waitAdditional(2);
		
		update = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/th[3]/div/div")).getText().contains("System Ref");//System Ref
		
		update = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/th[4]/div/div")).getText().trim().equals("Transaction Ref");//Tran Ref
		update = getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]")).getText().length()>0;
		
		update = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/th[5]/div/div")).getText().trim().equals("Entry date");//Entry date
		update = getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]")).getText().equals(calender.Presentdate());;//Entry date

		update = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/th[6]/div/div")).getText().trim().equals("Gross Value");//Gross value
		update = getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[6]")).getText().equals(elements.get(2));
		
        update = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/th[7]/div/div")).getText().trim().equals("Line");//Line
        update = getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[7]")).getText().equals(elements.get(3));

        update = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/th[9]/div/div")).getText().trim().equals("Supplier");//Suplier
        update = getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[9]")).getText().equals(elements.get(1));
		
		return update;
	}

	/**
	 * click On Transaction-->Select 
	 */
	public void clickOnTransactionSelect(){
		log.info("Clicking on Purge button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Transaction")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Select")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * click On Transaction-->Authorise 
	 */
	public void clickOnTransactionAuthorise(){
		log.info("Clicking on Purge button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().trim().equals("Transaction")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().trim().equals("Authorise")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Authorise transaction
	 * @throws InterruptedException
	 */
	public void authoriseTransaction() throws InterruptedException{
		log.info("Authorise invoice");
			
//		clickOnTransactionSelect();
		clickOnButton(15);
		
//		clickOnTransactionAuthorise();
		clickOnButton(14);
			
		clickOnButton(11);
	}
	
	/**
	 * Click on suspend 11010
	 */
	public void enterTransactionSuspendAndRelease(List<String> elements){
		log.info("In transaction suspend release");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ZERO)).sendKeys(elements.get(2));
		WaitHelper.waitAdditional(1);
		
		Calendar currentMonth = Calendar.getInstance();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
		String currDate = dateFormat1.format(currentMonth.getTime());

		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).sendKeys(currDate);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
		
	}
	
	/**
	 * Verify suspend index contains 'Y'
	 * @return boolean - True/False
	 */
	public boolean verifySuspendIndex(){
		log.info("Verify suspend index column");
		WaitHelper.waitAdditional(1);
		return getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div/table/tbody/tr")).getText().contains("Y");//Suspend index

	}
	
	/**
	 * 
	 * @return
	 */
	public boolean verifyAuthrisationStatus(){
		log.info("Verify authorisation status");
		boolean status = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIFTH_TAB)).click();//Authorisation/Withholding tab
		WaitHelper.waitAdditional(1);
		
		String authStatus = getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject.EIGHT)).getText();
		
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SIXTH_TAB)).click();//Authorisation/Withholding tab
		WaitHelper.waitAdditional(1);
		String suspendIndicatior = getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.EIGHT)).getText();//Suspend indicator
		
		if(authStatus.equals("Retain") && suspendIndicatior.equals("Y")){
			status = true;
		}
		return status;
	}
	
	public boolean verifyRecurringStatus(){
		log.info("Verify recurring interval and occur");
		boolean status = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FOURTH_TAB)).click();//Payment tab
		WaitHelper.waitAdditional(1);
		
		String recInterval = getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject.ZERO)).getText();//Recurring interval
		
		String recOccur= getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject.ONE)).getText();//Recurring occurs
		
		if(recInterval.equals("1") && recOccur.equals("10")){
			status = true;
		}
		return status;
	}
	



		}
		


