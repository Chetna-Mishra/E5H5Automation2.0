package com.adv.qa.selenium.framework.pageObjects.currency;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.Page;
import com.adv.qa.selenium.framework.pageObjects.PageObjects;
import com.adv.qa.selenium.helpers.CalenderDateTime;
import com.adv.qa.selenium.helpers.DatabaseQuery_Oracle;
import com.adv.qa.selenium.helpers.DatabaseQuery_PostgreSQL;
import com.adv.qa.selenium.helpers.DatabaseQuery_SQL;
import com.adv.qa.selenium.helpers.SeleniumDaoException;
import com.adv.qa.selenium.helpers.WaitHelper;

public class CurrencyPage extends Page {

	private PageObjects pObject = new PageObjects();
	private DatabaseQuery_SQL dbQuery = new DatabaseQuery_SQL();
	private DatabaseQuery_Oracle OdbQuery = new DatabaseQuery_Oracle();

	private DatabaseQuery_PostgreSQL PdbQuery = new DatabaseQuery_PostgreSQL();
	private CalenderDateTime calender = new CalenderDateTime();

	private String message = "The specified key already exists";

	public CurrencyPage(EventFiringWebDriver driver) {
		super(driver);
		log.info("In currency page");
	}

	private WebElement msgNode() {
		// return getDriver().findElement(By.id(pObject.MESSAGE_NODE_LABEL));
		return getDriver().findElement(By.xpath(pObject.AllPG_MSG_BUTTON_LABEL));

	}

	/**
	 * Get tool content message
	 * 
	 * @return tool content
	 */
	public String getToolContentText() {
		log.info("Inside getToolContext method");

		WaitHelper.waitAdditional(1);
		String toolTipValue = "";
		try {
			if (!getDriver().findElement(By.xpath(pObject.AllPG_MSG_TOOLBAR)).isDisplayed()) {
				WaitHelper.waitAdditional(1);
				msgNode().click();
				WaitHelper.waitAdditional(2);
			}
			toolTipValue = getDriver().findElement(By.xpath(pObject.AllPG_MSG_TOOLBAR)).getText();
		} catch (NoSuchElementException e) {
			toolTipValue = "";
		}
		WaitHelper.waitAdditional(2);
		return toolTipValue;
	}

	/**
	 * Get Error message content
	 * 
	 * @return Error content
	 */
	public String getErrorContentText() {
		log.info("Inside getToolContext method");

		WaitHelper.waitAdditional(1);
		String toolTipValue = "";
		try {
			if (!getDriver().findElement(By.xpath(pObject.ERROR_MSG_BAR)).isDisplayed()) {
				WaitHelper.waitAdditional(1);
				msgNode().click();
				WaitHelper.waitAdditional(2);
			}
			toolTipValue = getDriver().findElement(By.xpath(pObject.ERROR_MSG_BAR)).getText();
		} catch (NoSuchElementException e) {
			toolTipValue = "";
		}
		WaitHelper.waitAdditional(2);
		return toolTipValue;
	}

	/**
	 * New Method Added by Chetna, Dt: 17-01-2017 for "VerifyToolContentMessage"
	 * Get toolBar content message
	 * 
	 * @return tool content
	 * 
	 */

	public boolean VerifyToolContentMessage(String value) {
		WaitHelper.waitAdditional(2);
		log.info("Verify presence of Message in the ToolBar Message list");
		boolean MessageValue = false;
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_MSG_TOOLBAR));
		for (WebElement wb : wbs) {
			if (wb.getText().contains(value)) {
				MessageValue = true;
				break;
			}
		}
		return MessageValue;
	}

	/**
	 * New Method Added by Chetna, Dt: 23-01-2017 for
	 * "VerifySeachToolContentMessage" Get search Page toolBar content message
	 * 
	 * @return tool content
	 * 
	 */

	public boolean VerifySeachToolContentMessage(String value) {
		WaitHelper.waitAdditional(2);
		log.info("Verify presence of Message in the Search ToolBar Message list");
		boolean MessageValue = false;
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.All_SEARCH_MSG_TOOLBAR));
		for (WebElement wb : wbs) {
			if (wb.getText().contains(value)) {
				MessageValue = true;
				break;
			}
		}
		return MessageValue;
	}

	public boolean isToolTipDisplayed() {
		boolean toolTip = false;

		try {

			// if(getDriver().findElement(By.id(pObject.MESSAGE_NODE_LABEL)).isDisplayed()){
			if (getDriver().findElement(By.xpath(pObject.AllPG_MSG_DIV)).isDisplayed()) {

				toolTip = true;
			}
		} catch (NoSuchElementException e)

		{
			toolTip = false;
		}
		return toolTip;
	}

	/**
	 * Verify command box
	 * 
	 * @return true/false
	 */
	// public boolean isCommandDisplayed() {
	// log.info("Inside isCommandDisplayed method");
	// WaitHelper.waitAdditional(2);
	// boolean command = false;
	// try {
	//
	// if (getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed())
	// {
	//
	// command = true;
	// }
	// } catch (NoSuchElementException e) {
	// clickOnCancel();
	//
	// if (getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed())
	// {
	// command = true;
	// }
	// WaitHelper.waitAdditional(2);
	// }
	// return command;
	// }

	/**
	 * Verify command box
	 * 
	 * @return true/false
	 */
	public boolean isCommandDisplayed() {
		log.info("Inside isCommandDisplayed method");
		WaitHelper.waitAdditional(2);

		try {

			if (!getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed()) {

				WaitHelper.waitUntilWebElementDisplayed(getDriver(),
						getDriver().findElement(By.xpath(pObject.CMD_COMMAND)));// Chetna
																				// Wait
																				// Added
				return getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed();

			}
		} catch (NoSuchElementException e) {
			clickOnCancel();

			if (!getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed()) {
				WaitHelper.waitUntilWebElementDisplayed(getDriver(),
						getDriver().findElement(By.xpath(pObject.CMD_COMMAND)));// Chetna
																				// Wait
																				// Added
				return getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed();

			}
		}
		return getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed();

	}

	/**
	 * Verify presence of Change Company/Role pop up
	 * 
	 * @return
	 */

	private boolean isChangeCMPYPopUpDisplayed() {
		WaitHelper.waitAdditional(2);
		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.A039_LKP_OK)));// Chetna
																														// Wait
																														// Added
		return getDriver().findElement(By.xpath(pObject.A039_LKP_OK)).isDisplayed();

	}

	/**
	 * Change company from default company
	 * 
	 * @param company
	 */
	public void clickOnChangeCompany(String company) {
		log.info("Inside change Company method");
		WaitHelper.waitAdditional(2);

		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A039_CHANGE_CMPY)));// Chetna
																				// Wait
																				// Added
		getDriver().findElement(By.xpath(pObject.A039_CHANGE_CMPY)).click();// ChangeCompany/Role
																			// button
		WaitHelper.waitAdditional(2);

		if (!isChangeCMPYPopUpDisplayed()) {
			WaitHelper.waitAdditional(3);
		}

		getDriver().findElement(By.xpath(pObject.A039_LKP_CMPY)).clear(); // Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A039_LKP_CMPY)).sendKeys(company);// Company
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A039_LKP_OK)).click(); // Ok
																		// Button
		WaitHelper.waitAdditional(4);

	}

	/**
	 * Modified by Chetna, Dt: 17-01-2017 Enter currency code in the command
	 * line
	 * 
	 * @param code
	 * @throws InterruptedException
	 */
	public void fillCurrenceyCode(String code) throws InterruptedException {
		WaitHelper.waitAdditional(4);
		log.info("Fill currency code");

		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.CMD_COMMAND)));// Chetna
																														// Wait
																														// Added
		getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).sendKeys(code);
		getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).sendKeys(Keys.ENTER);

		WaitHelper.waitAdditional(4);
	}

	/**
	 * Click on OK button
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnButton(int i) throws InterruptedException {
		log.info("Clicking button");
		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.id(pObject.ZERO_ + i + pObject.LABEL)).click();
		WaitHelper.waitAdditional(4);
	}

	private WebElement getSecondHeader() {
		// return
		// getDriver().findElement(By.xpath("//html//body//div[2]/div/div[2]/div/div/div[2]/div/div"));
		return getDriver().findElement(By.xpath(pObject.A001A_NAV_BAR));
	}

	/**
	 * Verify title of table displayed with currency code
	 * 
	 * @return page header
	 */
	public String getTableHeader() {
		log.info("Inside getTab header method");
		WaitHelper.waitAdditional(2);
		String header = "";
		if (getSecondHeader() != null)

		{
			header = getSecondHeader().getText().trim();

			// header = getSecondHeader().getText();
		}
		WaitHelper.waitAdditional(3);
		return header;
	}

	/**
	 * Verify Currency list
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isCurrencyListDisplayed() throws InterruptedException {
		log.info("Inside isCurrencyDisplayed method");
		WaitHelper.waitAdditional(2);
		return getDriver().findElement(By.className(pObject.CURRENCY_PANE)).isDisplayed();
	}

	/**
	 * Click on Insert button
	 */

	public void clickOnInsert() {
		WaitHelper.waitAdditional(2);
		boolean isclicked = false;
		log.info("Clicking on Insert button");
		int count = 0;
		do {
			count = count + 1;
			List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
			for (WebElement wb : wbs) {
				if (wb.getText().equals("Insert")) {
					wb.click();
					isclicked = true;
					break;
				}
			}
		} while (isclicked = false);// (!(getTableHeader().contains("Edit")) &&
									// count !=3);
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Click on Insert1 button for A028 and A0029, A075, A092
	 */

	public void clickOnInsert1() {
		log.info("Clicking on Insert button for A028, A029, A075, A092");
		getDriver().findElement(By.xpath(pObject.AllPG_INSERT1)).click();
		WaitHelper.waitAdditional(2);
	}

	public void clickOnUpdate1() {
		log.info("Clicking on Update button for A075");
		getDriver().findElement(By.xpath(pObject.AllPG_UPDATE1)).click();
		WaitHelper.waitAdditional(2);
	}

	public void clickOnCancel1() {
		log.info("Clicking on cancel button for A028 & A029, A098");
		getDriver().findElement(By.xpath(pObject.AllPG_CANCEL1)).click();
		WaitHelper.waitAdditional(2);
	}

	public void clickOnAmed1() {
		log.info("Clicking on Amend button for A028 & A029");
		getDriver().findElement(By.xpath(pObject.AllPG_AMEND1)).click();
		WaitHelper.waitAdditional(2);
	}

	public void clickOnRefresh1() {
		log.info("Clicking on Refresh button for A092");
		getDriver().findElement(By.xpath(pObject.AllPG_REFRESH1)).click();
		getDriver().findElement(By.xpath(pObject.AllPG_REFRESH1)).click();
		WaitHelper.waitAdditional(5);

	}

	/**
	 * Modified by Chetna, Dt: 17-01-2017 Add new currency
	 * 
	 * @throws InterruptedException
	 */
	public boolean addNewCurrency(List<String> currencyList) throws InterruptedException {
		log.info("Adding new currency");
		boolean update = false;

		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(currencyList.get(0));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(Keys.ENTER); // Currency
																						// Test

		WaitHelper.waitAdditional(2);

		if (!VerifyToolContentMessage("The specified key already exists"))
		// if(!getToolContentText().contains(message))

		{
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();// (pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(currencyList.get(1));// Description

			getDriver().findElement(By.xpath(pObject.A002_DECIMAL_P)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DECIMAL_P)).sendKeys(currencyList.get(2));// Decimal
																									// places

			getDriver().findElement(By.xpath(pObject.A002_UNIT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_UNIT)).sendKeys(currencyList.get(3));// Unit

			getDriver().findElement(By.xpath(pObject.A002_UNITS)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_UNITS)).sendKeys(currencyList.get(4));// Units

			getDriver().findElement(By.xpath(pObject.A002_SUN_UNIT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_SUN_UNIT)).sendKeys(currencyList.get(5));// Sub-Unit

			getDriver().findElement(By.xpath(pObject.A002_SUN_UNITS)).clear();
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A002_SUN_UNITS)).sendKeys(currencyList.get(6));// Sub-Units
			WaitHelper.waitAdditional(2);

			// getDriver().findElement(By.cssSelector("[name^='EMU-IND_']")).sendKeys(currencyList.get(7));//Emu
			// Indicator dropdown
			// WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath(pObject.A002_EMU_IND)).sendKeys(currencyList.get(7));// Emu
																									// Indicator
																									// dropdown
			WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath(pObject.A002_FIXED_RATE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_FIXED_RATE)).sendKeys(currencyList.get(8));// Fixed
																										// rate
			WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).sendKeys(currencyList.get(9));// Date
			WaitHelper.waitAdditional(3);

			// getDriver().findElement(By.cssSelector("[name^='RNDG-IND_']")).sendKeys(currencyList.get(10));//Rounding
			// Ind
			// WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath(pObject.A002_ROUNDING_IND)).sendKeys(currencyList.get(10));// Rounding
																										// Ind
			WaitHelper.waitAdditional(1);

			update = true;
		}
		return update;
	}

	/**
	 * Click on update button
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnUpdateCurrency() throws InterruptedException {
		log.info("Clicking on Update btton");
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE + pObject.ONE + pObject.LABEL)).click();
		try {
			isRefreshDisplayed();
		} catch (NoSuchElementException e) {
			clickOnCancel();
		}
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Verify Entity present in Currency table by iterating in to each column
	 * 
	 * @param value
	 * @return true
	 */
	public boolean verifyValues(String value)

	{

		WaitHelper.waitAdditional(2);
		log.info("Verify presence of value in the list");
		boolean currencyValue = false;
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A001A_CURRENCY_TABLE_CELL));

		for (WebElement wb : wbs) {
			if (wb.getText().contains(value))

			{
				currencyValue = true;
				break;
			}
		}
		return currencyValue;
	}

	/**
	 * Get cancel button
	 */

	public List<WebElement> getAlllButton() {
		log.info("Verify presence of button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		return wbs;
	}

	public List<WebElement> getAllFooterButton() {
		log.info("Verify presence of button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_FOOT_SEC));
		return wbs;
	}

	// button[starts-with(@class,'button roundedbutton')]

	/**
	 * Click on Cancel button
	 */

	public void clickOnCancel() {
		log.info("Clicking on cancel button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAlllButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Cancel")) {

				// WaitHelper.waitAdditional(3); //for Edge Browser
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Verify presence of confirmation window
	 * 
	 * @return true/false
	 */
	public void isConfirmPopUpDisplayed()

	{
		log.info("Verify confirmation pop up");
		WaitHelper.waitAdditional(3);
		try {
			if (getDriver().findElement(By.xpath(pObject.CONF_BUT_YES)).isDisplayed())

			{
				getDriver().findElement(By.xpath(pObject.CONF_BUT_YES)).click();
			}
		} catch (NoSuchElementException e) {

		}
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Verify presence of Cancel button
	 * 
	 * @return
	 */
	public boolean isCancelDisplayed() {
		log.info("Verify cancel button");
		WaitHelper.waitAdditional(2);
		boolean cancel = false;
		List<WebElement> wbs = getAlllButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Cancel")) {
				cancel = true;
				break;
			}
		}
		return cancel;
	}

	private List<WebElement> getButton() {
		return getDriver().findElements(By.className("button"));
	}

	/**
	 * Click On Any Button method
	 * 
	 * @return
	 */

	public boolean ClickOnAnyButton(String buttonName, int action)

	{
		log.info("Click on Any Buttomn Method");
		WaitHelper.waitAdditional(2);

		boolean isDisplayed = false;
		List<WebElement> listOfButtons = getButton();
		for (WebElement button : listOfButtons) {
			if (button.getAttribute("value").equals(buttonName)) {
				if (button.isDisplayed()) {
					if (action == 0) {
						isDisplayed = true;
					} else {
						button.click();
						WaitHelper.waitAdditional(2);
					}

					break;
				}
			}
		}
		return isDisplayed;
	}

	/**
	 * Click on Yes button
	 */
	public void clickOnYesButton() {
		log.info("Verify Yes button");
		WaitHelper.waitAdditional(2);
		ClickOnAnyButton("Yes", 1);

	}

	/**
	 * Logout from the application
	 * 
	 * @throws InterruptedException
	 */
	public void logOut(int i) throws InterruptedException {
		log.info("Logging out from the application");
		if (i == 2) {
			clickOnCancel();
		}
		clickOnCancel();
		clickOnYesButton();

		WaitHelper.waitAdditional(5);
	}

	/**
	 * Click on Exit form top header
	 */
	public void clickOnExit() {
		log.info("Clicking on Exit button");

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Exit")) {
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
				for (WebElement wb2 : wbs1) {
					if (wb2.getText().equals("Exit")) {
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * Click on Exit form top header
	 */
	// public void exitFromSupplierElement(){
	// log.info("Clicking on Exit button");
	// List<WebElement> wbs =
	// getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
	// for(WebElement wb : wbs){
	// if(wb.getText().equals("Exit")){
	// wb.click();
	// break;
	// }
	// }
	// }
	//
	/**
	 * Delete currency from the currency ist
	 */
	public void clickOnPurge() {
		log.info("Clicking on Purge button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Edit")) {
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for (WebElement wb2 : wbs1) {
					if (wb2.getText().equals("Purge")) {
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * Click on view button
	 */
	public void clickOnView() {
		log.info("Clicking on View button");
		WaitHelper.waitAdditional(2);

		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("View")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Refresh after deleting currency
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRefresh() {
		log.info("Clicking on Refresh button");
		WaitHelper.waitAdditional(5);

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Refresh")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Verify Refresh button
	 * 
	 * @throws InterruptedException
	 */
	public boolean isRefreshDisplayed() throws InterruptedException {
		log.info("Verify refresh button");
		boolean refreshButton = false;
		WaitHelper.waitAdditional(5);
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Refresh")) {
				refreshButton = true;
				break;
			}
		}
		WaitHelper.waitAdditional(2);
		return refreshButton;
	}

	/**
	 * Get Extended sections
	 * 
	 * @return
	 */
	private List<WebElement> getEXTSections() {
		return getDriver().findElements(By.xpath(pObject.A040_SELE_SEC1));

	}

	/**
	 * Click on Extended sections of Search page
	 * 
	 * @param i
	 */
	public void clickOnEXTSections() {
		log.info("Expanding Extednded Search Section");

		getDriver().findElement(By.xpath(pObject.A039_EXT_SEL)).click();

		// getEXTSections().get(i).click();
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Get sections
	 * 
	 * @return
	 */
	private List<WebElement> getSections() {
		return getDriver().findElements(By.xpath(pObject.TPMN_SELECTION));

	}

	/**
	 * Click on sections of Search page
	 * 
	 * @param i
	 */
	public void clickOnSections(int i) {
		log.info("Expanding Search Section");

		getDriver().findElement(By.xpath(pObject.AllPG_SELEC)).click();

		// getSections().get(i).click();
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Click on the entity
	 * 
	 * @param entity
	 * @return Modified by Chetna Dt: 16-01-2017
	 */

	public void selectEntity(String entity) {
		log.info("Select Entity method");
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A001A_CURRENCY_TABLE_CELL));
		for (WebElement wb : wbs) {
			if (wb.getText().contains(entity)) {
				wb.click();
				break;
			}
		}
	}

	/**
	 * Click on the entity
	 * 
	 * @param entity
	 * @return Modified by Chetna Dt: 16-01-2017
	 */
	public boolean selectEntityValue(List<String> entity) throws InterruptedException

	{
		log.info("Select Entity method");

		boolean update = false;

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A001A_CURRENCY_TABLE_CELL));
		for (WebElement wb : wbs) {
			if (wb.getText().contains(entity.get(0))) {
				wb.click();
				break;

			}
			update = true;
		}

		return update;
	}

	/**
	 * Edit currency from the currency list Modified by Chetna Dt: 16-01-2017
	 */
	public boolean isEditDisplayed() {
		log.info("Verify edit button");
		boolean edit = false;

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Edit")) {
				wb.click();
				edit = true;
				break;
			}
		}
		return edit;
	}

	/**
	 * Click on Amend button Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnAmend() {
		WaitHelper.waitAdditional(1);
		boolean isClicked = false;
		log.info("Click on Amend button");
		int count = 0;
		do {
			count = count + 1;
			List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
			for (WebElement wb2 : wbs1) {
				if (wb2.getText().equals("Amend")) {
					wb2.click();
					break;
				}
			}
			WaitHelper.waitAdditional(2);
		}

		while (isClicked = false); // (!(getTableHeader().contains("Edit")) &&
									// count !=3);

		WaitHelper.waitAdditional(2);
	}

	/**
	 * Click on prompt button Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnPrompt() {
		log.info("Click on prompt button");

		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Prompt")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on Update currency Modified by Chetna Dt: 16-01-2017
	 */

	public void clickOnUpdate() {
		log.info("Clicking on update button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs = getAlllButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Update")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	// public void clickOnUpdate() {
	// log.info("Clicking on update button");
	// WaitHelper.waitAdditional(3);
	// List<WebElement> wbs1 =
	// getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
	// for (WebElement wb2 : wbs1) {
	// if (wb2.getText().equals("Update")) {
	// wb2.click();
	// break;
	// }
	// }
	// WaitHelper.waitAdditional(2);
	// }

	/**
	 * Click on BackWard Button
	 * 
	 */
	public void clickOnBKWD() {
		log.info("Clicking on Backward button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Bkwd")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on Forward Button
	 * 
	 */
	public void clickOnFwd() {
		log.info("Clicking on Forward button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Fwd")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on Update currency Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnUpdateCompany() {
		log.info("Clicking on update button");
		WaitHelper.waitAdditional(2);

		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		int i = 0;
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Update")) {
				if (i == 1) {
					wb2.click();
					break;
				}
				i = i + 1;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Click on Update warnings
	 */
	public void clickOnUpdateWarnings() {
		log.info("Clicking on update warnings");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Update Warnings")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Click on UpdatWarnings
	 */
	public void clickOnUpdtWarn() {
		log.info("Clicking on updt warn");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Updt Warn")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Click on Updt warnings
	 */
	public void clickOnUpdtWarnings() {
		log.info("Clicking on Updt warnings method");
		WaitHelper.waitAdditional(2);

		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Updt Warnings"))

			{
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Click on accept warnings
	 */
	public void clickOnAcceptWarnings() {
		log.info("Clicking on Accept warnings");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Accept Warnings")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}

	/*
	 * Click on accept warnings
	 */
	public void clickOnAcceptWarn() {
		log.info("Clicking on Accept warn");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Accept Warn")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}

	/*
	 * Click on accept warnings
	 */
	public void clickOnAccptWarnings() {
		log.info("Clicking on Accpt Warnings");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Accpt Warnings")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}

	/*
	 * Click on Exit
	 */

	public void exitFromSupplierElement() {
		log.info("Clicking on Exit button");
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Exit")) {
				wb.click();
				break;

			}
			WaitHelper.waitAdditional(5);
		}
	}

	/**
	 * Verify Column Definition tab displayed
	 * 
	 * @return true Modified by Chetna Dt: 16-01-2017
	 */

	public boolean isColumnDefinitionTabSelected() {
		return ColumnDefinitionTab().isSelected();
	}

	private WebElement ColumnDefinitionTab() {
		return getDriver().findElement(By.xpath(pObject.A001A_COLUMN_DEFINATION_TAB));
	}

	public boolean isColumnDefinitionDispayed() {

		log.info("Inside isColumnDefinitionDispayed Method");
		return columnDefinition().isDisplayed();

	}

	private WebElement columnDefinition() {
		log.info("Inside columnDefinition Method");
		return getDriver().findElement(By.xpath(pObject.A001A_COLUMN_DEFINATION_TAB));

	}

	/**
	 * Click on clickOnColumnDefinition Tab Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnColumnDefinition() {

		getDriver().findElement(By.xpath(pObject.A001A_COLUMN_DEFINATION_TAB)).click();

	}

	/**
	 * Verify Definition defn tab displayed Modified by Chetna Dt: 16-01-2017
	 * 
	 * @return true
	 */
	public boolean isDefinitionDefnDispayed() {
		log.info("Verify Definition Def method");

		WebElement clickOnDefinitionDef = getDriver().findElement(By.xpath(pObject.A001A_DEFINATION_DEF_TAB));

		WaitHelper.waitUntilWebElementDisplayed(getDriver(), clickOnDefinitionDef);
		return clickOnDefinitionDef.isDisplayed();
	}

	/**
	 * Click on Definition defn tab
	 */
	public void clickOnDefinitionDef() {
		log.info("click On Definition Def Tab");

		getDriver().findElement(By.xpath(pObject.A001A_DEFINATION_DEF_TAB)).click();
	}

	/**
	 * Verify Primary Details Tab displayed
	 * 
	 * @return true
	 */
	public boolean isPrimaryDetailsTabSelected() {
		return getPrimaryDetailsTab().isSelected();
	}

	public boolean isPrimaryDetailsTabDisplayed() {
		return getPrimaryDetailsTab().isDisplayed();
	}

	/**
	 * Get primary details tab id
	 */
	private WebElement getPrimaryDetailsTab() {
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB)));// Chetna
																				// Wait
																				// Added
		return getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB));
	}

	/**
	 * Click on Primary Details Tab Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnPrimaryDetailsTab() {
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB)));// Chetna
																				// Wait
																				// Added
		getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB)).click();
	}

	/**
	 * Click on Currency Intrastat Tab
	 */
	public void clickOnSecondTab() {

		getDriver().findElement(By.xpath(pObject.A006_CURRENCY_EC_TAB)).click();

	}

	/**
	 * Verify Currency Intrastat Tab displayed
	 * 
	 * @return true
	 */
	public boolean isSecondTabDisplayed() {
		return getSecondTab().isDisplayed();
	}

	/**
	 * Get second tab
	 * 
	 * @return
	 */
	private WebElement getSecondTab() {

		return getDriver().findElement(By.xpath(pObject.A006_CURRENCY_EC_TAB));
	}

	/**
	 * Verify ColumnDefinition Tab for A001A
	 * 
	 */
	public void verifyColumnDefinitionTab(List<String> entityname)

	{

		if (!getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[2]/input")).isSelected())

		{
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[2]/input")).click();// Short
																								// Name
																								// chk
			WaitHelper.waitAdditional(1);
		}

		if (!getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/input")).isSelected())

		{
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/input")).click();// Account
																								// Type
																								// chk
			WaitHelper.waitAdditional(1);
		}

		if (!getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[2]/input")).isSelected())

		{
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[2]/input")).click();// Purchaging
																								// Flag
																								// chk
			WaitHelper.waitAdditional(1);
		}

		if (!getDriver().findElement(By.xpath("//div[7]/table/tbody/tr/td[2]/input")).isSelected())

		{
			getDriver().findElement(By.xpath("//div[7]/table/tbody/tr/td[2]/input")).click();// PL
																								// Flag
																								// chk
			WaitHelper.waitAdditional(1);
		}

		if (!getDriver().findElement(By.xpath("//div[8]/table/tbody/tr/td[2]/input")).isSelected())

		{
			getDriver().findElement(By.xpath("//div[8]/table/tbody/tr/td[2]/input")).click();// POP
																								// Flag
																								// chk
			WaitHelper.waitAdditional(1);
		}

		if (!getDriver().findElement(By.xpath("//div[9]/table/tbody/tr/td[2]/input")).isSelected())

		{
			getDriver().findElement(By.xpath("//div[9]/table/tbody/tr/td[2]/input")).click();// IM
																								// Flag
																								// chk
			WaitHelper.waitAdditional(1);
		}

		if (entityname.get(0).equals("TPBSUPP"))

		{

			if (!getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).isSelected())

			{
				getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).click();// Company
																									// chk
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[2]/input")).isSelected())

			{
				getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[2]/input")).click();// Supplier
																									// chk
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[2]/input")).isSelected())

			{
				getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[2]/input")).click();// Name
																									// chk
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath("//div[10]/table/tbody/tr/td[2]/input")).isSelected())

			{
				getDriver().findElement(By.xpath("//div[10]/table/tbody/tr/td[2]/input")).click();// currency
																									// chk
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath("//div[11]/table/tbody/tr/td[2]/input")).isSelected())

			{
				getDriver().findElement(By.xpath("//div[11]/table/tbody/tr/td[2]/input")).click();// category
																									// chk
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath("//div[12]/table/tbody/tr/td[2]/input")).isSelected())

			{
				getDriver().findElement(By.xpath("//div[12]/table/tbody/tr/td[2]/input")).click();// Settlment
																									// code
																									// chk
				WaitHelper.waitAdditional(1);
			}

		}

	}

	/**
	 * Verify DefinitionDef Tab for A001A
	 * 
	 */

	public void verifyDefinitionDefTab(List<String> entityname)

	{
		{
			if (entityname.get(1).equals("1"))

			{

				if (!getDriver().findElement(By.xpath(pObject.A001A_AUDIT)).isSelected())

				{
					getDriver().findElement(By.xpath(pObject.A001A_AUDIT)).click();// Audit
					WaitHelper.waitAdditional(1);
				}

			}

			if (entityname.get(2).equals("1")) {

				if (!getDriver().findElement(By.xpath(pObject.A001A_SUPP_AUDIT)).isSelected())

				{
					getDriver().findElement(By.xpath(pObject.A001A_SUPP_AUDIT)).click();// Support
																						// Audit
					WaitHelper.waitAdditional(1);
				}

			}
		}
		getDriver().findElement(By.xpath(pObject.A001A_AUD_KEPT)).clear();
		getDriver().findElement(By.xpath(pObject.A001A_AUD_KEPT)).sendKeys(entityname.get(3));
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A001A_PROC_LVL)).clear();
		getDriver().findElement(By.xpath(pObject.A001A_PROC_LVL)).sendKeys(entityname.get(4));
		WaitHelper.waitAdditional(1);

		clickOnUpdate();

	}

	/**
	 * Enter primary details of company
	 * 
	 * @param companydetails
	 */
	public void enterPrimaryDetails(String companyName, List<String> companydetails) {
		log.info("Enter preimary details");
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);// Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(companydetails.get(0));// Description
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A006_NAME)).sendKeys(companydetails.get(1));// Name
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR1)).sendKeys(companydetails.get(2));// Address
																								// line1
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR2)).sendKeys(companydetails.get(3));// Address
																								// line2
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR3)).sendKeys(companydetails.get(4));// Address
																								// line3
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR4)).sendKeys(companydetails.get(5));// Address
																								// line4
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR5)).sendKeys(companydetails.get(6));// Address
																								// line5
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR6)).sendKeys(companydetails.get(7));// Address
																								// line6
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_PSOT_CODE)).sendKeys(companydetails.get(8));// Post
																									// code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_TEL)).sendKeys(companydetails.get(9));// Telephone
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_FAX)).sendKeys(companydetails.get(10));// Fax

	}

	/**
	 * Enter Currency/EC Intrastat details of company
	 * 
	 * @param companydetails
	 */
	public void enterCurrencyIntrastatDetails(List<String> companydetails) {
		log.info("Enter currency intrastat details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A006_COUNTRY)).sendKeys(companydetails.get(11));// Country
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).sendKeys(companydetails.get(12));// Currency
		WaitHelper.waitAdditional(1);

		if (!getDriver().findElement(By.xpath(pObject.A006_EMU_FLAG)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A006_EMU_FLAG)).click();// Emu
																				// flag
		}

		WaitHelper.waitAdditional(1);

		if (!getDriver().findElement(By.xpath(pObject.A006_CURR_FLAG)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A006_CURR_FLAG)).click();// Currency
																				// flag
		}

		if (!getDriver().findElement(By.xpath(pObject.A006_CACHE)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A006_CACHE)).click();// Cache
		}

	}

	/**
	 * Enter device details
	 * 
	 * @param deviceDetails
	 */
	public void enterDeviceDetails(List<String> deviceDetails) {
		log.info("Enter device details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A007_DEVICE)).clear();// Device
																		// name
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEVICE)).sendKeys(deviceDetails.get(0));

		getDriver().findElement(By.xpath(pObject.A006_UPPR_CASE)).click();// Upper
																			// case
																			// check
																			// box
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(deviceDetails.get(1));// Description
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A007_DEFINATION1)).sendKeys(deviceDetails.get(2));// Definition1
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEFINATION2)).sendKeys(deviceDetails.get(3));// Definition2
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEFINATION3)).sendKeys(deviceDetails.get(4));// Definition3
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A007_DEFINATION4)).sendKeys(deviceDetails.get(5));// Definition4
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEFINATION5)).sendKeys(deviceDetails.get(6));// Definition5
	}

	/**
	 * Enter Distribution profile details
	 * 
	 * @param profileDetails
	 */
	public boolean enterDistributionProfileDetails(List<String> profileDetails) {
		log.info("Enter distribution profiles details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A009_PROFILE)).sendKeys(profileDetails.get(0));// D
																								// Profile
		getDriver().findElement(By.xpath(pObject.A009_PROFILE)).sendKeys(Keys.ENTER);// D
																						// Profile
		WaitHelper.waitAdditional(2);
		if (!getToolContentText().contains(message)) {
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(profileDetails.get(1));// Description
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A007_DEST)).sendKeys(profileDetails.get(2));// Destination
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A009_NO_COPIES)).sendKeys(profileDetails.get(3));// No.of
																										// copies
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A009_SUPPR_BANN)).click();// Suppress
																				// Banner
			update = true;
		}
		return update;
	}

	/**
	 * Search currency
	 * 
	 * @param currencyList
	 *            Modified by Chetna Dt: 16-01-2017
	 */
	public void searchCurrency(String currencyValue) {
		log.info("search currency method");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A001A_TABLE)).clear();
		getDriver().findElement(By.xpath(pObject.A001A_TABLE)).sendKeys(currencyValue);
		getDriver().findElement(By.xpath(pObject.A001A_OK)).click();
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Search currency
	 * 
	 * @param currencyList
	 *            Modified by Chetna Dt: 16-01-2017
	 */
	public void searchEntityValue(List<String> valueList) {
		log.info("Search value");
		WaitHelper.waitAdditional(5);
		if (!ClickOnAnyButton("OK", 0)) {
			clickOnSections(0);
		}

		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(valueList.get(0));
		getDriver().findElement(By.xpath(pObject.A001A_OK)).click();
		WaitHelper.waitAdditional(4);

	}

	/**
	 * 
	 * @param user
	 * @param i
	 *            = OK button ID
	 * @param j
	 *            = Search testbox ID
	 */
	public void search(String user, int i, int j) {

		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_SEARCH_USER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_SEARCH_USER)).sendKeys(user);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A001A_OK)).click();
		WaitHelper.waitAdditional(3);
	}

	public void searchOrder(String companyId, String user, int i) {
		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(companyId);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(user);

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);

	}

	/* Search document */
	public void searchDocument(String companyId, String user, int i) {
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
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(user);
		getDriver().findElement(By.id(pObject.ZERO_ + i + pObject.LABEL)).click();
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Enter calender activities
	 * 
	 * @param calenderActivity
	 * @param day
	 */
	public void createCalendar(List<String> calenderActivity, int day) {
		log.info("Create day calendar");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A012_ACTIVITY)).sendKeys(calenderActivity.get(0));// Activity
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(calenderActivity.get(1));// Desc
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A012_TYPE)).sendKeys(calenderActivity.get(2));// Type
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A012_TYPE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);

		if (calenderActivity.get(5).equals("day"))

		{

			getDriver().findElement(By.xpath(pObject.A012_MON)).sendKeys(calenderActivity.get(3));
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A012_TUE)).sendKeys(calenderActivity.get(4));

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A012_WED)).sendKeys(calenderActivity.get(6));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A012_THU)).sendKeys(calenderActivity.get(7));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A012_FRI)).sendKeys(calenderActivity.get(8));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A012_SAT)).sendKeys(calenderActivity.get(9));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A012_SUN)).sendKeys(calenderActivity.get(10));
			WaitHelper.waitAdditional(1);
		}

		else {
			getDriver().findElement(By.xpath(pObject.A012_O_FREQ)).sendKeys(calenderActivity.get(3));// Occurence
																										// Freq
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(Keys.ENTER);// Desc

			WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath(pObject.A012_EVENT_SPECIFIED)).sendKeys(calenderActivity.get(4));// Days
																												// of
																												// the
																												// Week

			WaitHelper.waitAdditional(2);

		}

	}

	/*
	 * Enter Account Defindation i =
	 * 
	 */

	public void enterAccountDefinitionDetails(String companyName, String accountDefinition,
			List<String> accountCodeList, List<String> costList, List<String> location, List<String> product) {
		log.info("Enter account definition details");

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();// Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);// Company

		getDriver().findElement(By.xpath(pObject.A014_NOMINAL_CODE)).clear();// Nomina
																				// code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A014_NOMINAL_CODE)).sendKeys(accountDefinition);// Nomina
																									// code
		WaitHelper.waitAdditional(2);

		enterAccountCodeDefinitionDetails(accountCodeList, 1);
		enterAccountCodeDefinitionDetails(costList, 2);
		enterAccountCodeDefinitionDetails(location, 3);
		enterAccountCodeDefinitionDetails(product, 4);
		WaitHelper.waitAdditional(4);
	}

	/*
	 * Enter Account Code Defindation Details i = Div ID
	 * 
	 */

	private void enterAccountCodeDefinitionDetails(List<String> elements, int i) {
		log.info("Enter account code definition details");
		WaitHelper.waitAdditional(2);

		if (BaseTest.browser.contains("internetexplorer")) {
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// id
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// id
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(0));// id
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();// Size
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();// Size
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(1));// Size
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();// Description
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();// Description
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(2));// Description
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();// Rel
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();// Rel
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(3));// Rel
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[6]")).click();// Ind
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[6]")).click();// Ind
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(4));// Ind
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]")).click();// Chk
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]")).click();// Chk
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(5));// Chk
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]")).click();// Heading
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]")).click();// Heading
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]/input")).sendKeys(elements.get(6));// Heading
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[9]")).click();// Hd
																								// size
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[9]")).click();// Hd
																								// size
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[9]/input")).sendKeys(elements.get(7));// Hd
																														// size
																														// input
			WaitHelper.waitAdditional(1.5);

		} else {

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// id
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(0));// id
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();// Size
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(1));// Size
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();// Description
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(2));// Description
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();// Rel
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(3));// Rel
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[6]")).click();// Ind
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(4));// Ind
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]")).click();// Chk
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(5));// Chk
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]")).click();// Heading
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]/input")).sendKeys(elements.get(6));// Heading
																														// input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[9]")).click();// Hd
																								// size
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[9]/input")).sendKeys(elements.get(7));// Hd
																														// size
																														// input
			WaitHelper.waitAdditional(1.5);
		}
	}

	/**
	 * Enter balance sheet control details
	 * 
	 * @param balanceSheetList
	 */
	public void enterBalanceSheetControls(List<String> balanceSheetList) {
		log.info("Enter balance sheet control details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A015_VERSION)).sendKeys(balanceSheetList.get(0));// VERSION
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A015_DESC)).sendKeys(balanceSheetList.get(1));// DESC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A015_NOM_MAN)).click();// NOM_MAN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A015_NOM_BAL_SHEET)).click();// NOM_BAL_SHEET

	}

	/**
	 * Enter balance sheet group details
	 * 
	 * @param balancegroupList
	 */
	public boolean enterBalanceSheetGroup(List<String> balancegroupList) {
		log.info("Enter Normal balance sheet group details");
		boolean update = false;
		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();// Group
																	// A016_GRP
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(balancegroupList.get(0));// Group
																								// A016_GRP
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(Keys.ENTER);// Group
																					// A016_GRP
		WaitHelper.waitAdditional(2);
		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(balancegroupList.get(1));// Desc
																										// A004A_DESCR
			WaitHelper.waitAdditional(2);

			if (balancegroupList.get(2).equals("1"))

			{

				getDriver().findElement(By.xpath(pObject.A016_PRPT_LS)).click();// Profit
																				// and
																				// loss
																				// chk
																				// box
																				// A016_PRPT_LS

			}
			update = true;
		}
		return update;
	}

	/**
	 * Search balance value
	 * 
	 * @param valueList
	 * @param i
	 *            = button ID Position
	 * @param j
	 *            = fields ID Position
	 */
	public void searchBalanceClass(List<String> valueList, int i, int j) {
		log.info("Search balance class");
		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("pObject.ZERO_+pObject.ZERO"))).click()
				.sendKeys(valueList.get(0)).build().perform();

		if (j == 1) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(1));
		}

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);

	}

	/**
	 * Search elements For Search Having only Company
	 * currencyPage.searchValue(companyId, 1, 0);
	 * 
	 * @param valueList
	 * @param i
	 *            = button ID Position
	 * @param j
	 *            = fields ID Position
	 */
	public void searchValue(String valueList, int i, int j) {
		log.info("Search values");
		WaitHelper.waitAdditional(2);

		if (!ClickOnAnyButton("OK", 0)) {
			clickOnSections(0);
		}

		if (j == 0) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}
		if (j == 1) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}
		if (j == 2) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}
		if (j == 4) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}

		if (j == 5) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FIVE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FIVE)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}

		if (j == 6) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.SIX)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.SIX)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);

	}

	/**
	 * Search value for A087
	 * 
	 * @param valueList
	 * @param i
	 *            = button ID Position
	 * @param j
	 *            = fields ID Position
	 */
	public void searchAUCode(String companyName, List<String> valueList, int k) {
		log.info("Into Search value method");
		WaitHelper.waitAdditional(2);

		if (!ClickOnAnyButton("OK", 0))

		{
			clickOnSections(0);
		}

		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(companyName);

		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(valueList.get(k));
		WaitHelper.waitAdditional(1);

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);

	}

	/**
	 * Search value
	 * 
	 * @param valueList
	 * @param i
	 *            = button ID Position
	 * @param j
	 *            = fields ID Position
	 */

	public void searchValue(String companyName, List<String> valueList, int i, int j) {
		log.info("Into Search value method");
		WaitHelper.waitAdditional(2);

		if (!isOkButtonDisplayed(i))

		{
			clickOnSections(0);
		}

		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(companyName);

		if (j == 1) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
		}

		if (j == 2) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
		}
		if (j == 3) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			if (!valueList.get(2).equals("NILL")) {
				getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(valueList.get(2));
			}
			WaitHelper.waitAdditional(1);
		}
		if (j == 4) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
		}
		if (j == 5) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
			if (!valueList.get(3).equals("NILL")) {
				getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).sendKeys(valueList.get(3));
			}
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FIVE)).sendKeys(valueList.get(4));
			WaitHelper.waitAdditional(1);
		}
		if (j == 6) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
		}
		if (j == 7) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(0));
		}
		if (j == 8) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(valueList.get(0));
		}
		if (j == 9) {
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
		}
		if (j == 10) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
		}
		if (j == 11) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
		}

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);

	}

	/**
	 * Search value for A032A
	 * 
	 * @param valueList
	 * @param i
	 *            = button ID Position
	 * @param j
	 *            = fields ID Position
	 */

	public void searchValuePathKey(String companyName, List<String> valueList, int i, int j) {
		log.info("Into PathKey Search value method");
		WaitHelper.waitAdditional(2);

		if (!ClickOnAnyButton("OK", 0))

		{
			clickOnSections(0);
		}
		{
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(companyName);

			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(Keys.ENTER);
			WaitHelper.waitAdditional(2);

			clickOnSections(0);

			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR_ + pObject.ZERO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR_ + pObject.ZERO)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
		}

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);

	}

	/**
	 * Search value for AD02009
	 * 
	 */

	public void searchAuthorisor(String companyName, List<String> elements, String orderNumber, int i) {
		log.info("Search value");

		WaitHelper.waitAdditional(2);
		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).sendKeys(companyName);// Company
																					// A042_CMPY

		getDriver().findElement(By.xpath(pObject.A011_SEARCH_USER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_SEARCH_USER)).sendKeys(elements.get(0));// USer
																								// A011_SEARCH_USER
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_SEAUT_STR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_SEAUT_STR)).sendKeys(elements.get(1));// Structure
																								// AD02009_SEAUT_STR
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_SEAUT_DOCREF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.AD02009_SEAUT_DOCREF)).sendKeys(String.valueOf(orderNumber));// Doc
																												// ref
																												// AD02009_SEAUT_DOCREF
		WaitHelper.waitAdditional(1);

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);

	}

	// public void searchAuthorisor(String companyName, List<String> elements,
	// String orderNumber, int i) {
	// log.info("Search value");
	// WaitHelper.waitAdditional(2);
	// if (!isOkButtonDisplayed(i)) {
	// clickOnSections(0);
	// }
	// getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
	// WaitHelper.waitAdditional(2);
	// getDriver().findElement(By.id(pObject.ZERO_ +
	// pObject.ZERO)).sendKeys(companyName);// Company A042_CMPY
	//
	// getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
	// WaitHelper.waitAdditional(1);
	// getDriver().findElement(By.id(pObject.ZERO_ +
	// pObject.ONE)).sendKeys(elements.get(0));// USer A011_SEARCH_USER
	// WaitHelper.waitAdditional(1);
	// getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
	// WaitHelper.waitAdditional(1);
	// getDriver().findElement(By.id(pObject.ZERO_ +
	// pObject.THREE)).sendKeys(elements.get(1));// Structure AD02009_SEAUT_STR
	// WaitHelper.waitAdditional(1);
	// getDriver().findElement(By.id(pObject.ZERO_ + pObject.FIVE)).clear();
	// WaitHelper.waitAdditional(1);
	// getDriver().findElement(By.id(pObject.ZERO_ +
	// pObject.FIVE)).sendKeys(orderNumber);// Doc ref AD02009_SEAUT_DOCREF
	// WaitHelper.waitAdditional(1);
	//
	// ClickOnAnyButton("OK", 1);
	// WaitHelper.waitAdditional(2);
	//
	// }

	/**
	 * Search value -Common
	 * 
	 * @param valueList
	 * @param i
	 *            = button ID Position
	 * @param j
	 *            = fields ID Position
	 */
	public void searchValue(List<String> valueList, int i, int j) {
		log.info("Search value");
		WaitHelper.waitAdditional(2);
		if (!ClickOnAnyButton("OK", 0)) {
			clickOnSections(0);
		}

		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(valueList.get(0));

		if (j == 1) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
		}

		if (j == 2) {
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
		}

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Search structure
	 * 
	 * @param companyName
	 * @param valueList
	 * @param i
	 */
	public void searchStructure(String companyName, List<String> valueList, int i) {
		log.info("Search structure");
		WaitHelper.waitAdditional(2);
		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(companyName);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(valueList.get(0));
		WaitHelper.waitAdditional(1);

		ClickOnAnyButton("OK", 1);

		WaitHelper.waitAdditional(2);
	}

	/**
	 * Search element
	 * 
	 * @param companyName
	 * @param ledgerControl
	 * @param i
	 */
	public void searchElement(String companyName, List<String> ledgerControl, int i) {
		log.info("Inside search element");
		WaitHelper.waitAdditional(2);
		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(companyName);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(ledgerControl.get(0));
		WaitHelper.waitAdditional(1);

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);

	}

	/**
	 * Search nominal balance
	 * 
	 * @param ledgerControl
	 * @param i
	 */
	public void searchElement(List<String> ledgerControl, int i) {
		log.info("Inside search element");
		WaitHelper.waitAdditional(2);
		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(ledgerControl.get(0));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(ledgerControl.get(1));
		WaitHelper.waitAdditional(1);

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Search calendar
	 * 
	 * @param element
	 * @param i
	 */
	public void searchCalendar(List<String> element, int i) {
		log.info("Inside search calendar");
		WaitHelper.waitAdditional(3);
		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}

		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(element.get(0));

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);

	}

	/**
	 * Is ok button displayed
	 * 
	 * @param i
	 * @return
	 */
	public boolean isOkButtonDisplayed(int i) {
		log.info("Is ok button displayed");
		boolean displayed = false;

		WebElement wb = getDriver().findElement(By.xpath(pObject.A001A_OK));

		if (wb.isDisplayed()) {

			displayed = true;
		}
		WaitHelper.waitAdditional(2);
		return displayed;

	}

	/**
	 * Enter balance sheet category details - A017
	 * 
	 * @param balanceCategoryList
	 */
	public boolean enterBalanceSheetCategory(List<String> balanceCategoryList) {
		log.info("Inside balance sheet category method");
		boolean update = false;

		WaitHelper.waitAdditional(5);
		getDriver().findElement(By.xpath(pObject.A015_VERSION)).clear();// A015_VERSION
		getDriver().findElement(By.xpath(pObject.A015_VERSION)).sendKeys(balanceCategoryList.get(0));// Version
																										// A015_VERSION
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();// Group
																	// A016_GRP
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(balanceCategoryList.get(1));// Group
																									// A016_GRP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();// A017_CATEG
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(balanceCategoryList.get(2));// Category
																									// A017_CATEG
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(Keys.ENTER);// Category
																					// A017_CATEG
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();// A004A_DESCR
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(balanceCategoryList.get(3));// Desc
																										// A004A_DESCR
			WaitHelper.waitAdditional(4);
			getDriver().findElement(By.xpath(pObject.A017_CATEG_TYPE)).sendKeys(balanceCategoryList.get(4));// Category
																											// type
																											// A017_CATEG_TYPE
			WaitHelper.waitAdditional(1);

			update = true;
		}
		return update;
	}

	/**
	 * Double click on row
	 * 
	 * @param i
	 */
	public void doubleClick(int i) {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("0_" + i))).doubleClick().build().perform();
	}

	/**
	 * Click on delete and refresh
	 * 
	 * @throws InterruptedException
	 */
	public void deleteAndRefresh() throws InterruptedException {
		clickOnPurge();
		clickOnUpdate();
		clickOnRefresh();
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Create Nominal controls
	 */
	public boolean enterNominalControl(List<String> nominalList) {
		log.info("Inside nominal control method");
		boolean update = false;
		if (!isPrimaryDetailsTabSelected()) {
			ClickOnAnyTab("Primary Details", 1);
		}

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A018_NOMINAL)).clear();// A018_NOMINAL
		getDriver().findElement(By.xpath(pObject.A018_NOMINAL)).sendKeys(nominalList.get(0));// Nominal
																								// A018_NOMINAL
		getDriver().findElement(By.xpath(pObject.A018_NOMINAL)).sendKeys(Keys.ENTER);// Nominal
																						// A018_NOMINAL
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {

			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();// A004A_DESCR
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(nominalList.get(1));// Description
																								// A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();// A016_GRP
			getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(nominalList.get(2));// Group
																								// A016_GRP
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();
			getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(nominalList.get(3));// Category

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A018_NOML_TYPE)).sendKeys(nominalList.get(4));// Nominal
																									// type
																									// A018_NOML_TYPE
			WaitHelper.waitAdditional(3);
			getDriver().findElement(By.xpath(pObject.A018_NOML_PST_TYPE)).sendKeys(nominalList.get(5));// Nominal
																										// posting
																										// type
																										// A018_NOML_PST_TYPE
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A018_MNGT_CODE_REL1)).clear();// A018_MNGT_CODE_REL1
			getDriver().findElement(By.xpath(pObject.A018_MNGT_CODE_REL1)).sendKeys(nominalList.get(6));// Management
																										// Code
																										// Relationships1
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A018_MNGT_CODE_REL2)).clear();// Management
																					// Code
																					// Relationships
			WaitHelper.waitAdditional(1);

			if (!getDriver().findElement(By.xpath(pObject.A018_FIN_ALLW)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A018_FIN_ALLW)).click();// Financial
																					// Allowed
			}
			if (getDriver().findElement(By.xpath(pObject.A018_PLN_ALLW)).isSelected()) {
				getDriver().findElement(By.xpath(pObject.A018_PLN_ALLW)).click();// Planning
																					// Allowed
			}
			if (getDriver().findElement(By.xpath(pObject.A018_CST_ALLW)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A018_CST_ALLW)).click();// Cost
																					// allocation
			}

			WaitHelper.waitAdditional(2);

			ClickOnAnyTab("Currency / Group Category", 1);
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A018_CURR_CODE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A018_CURR_CODE)).sendKeys(nominalList.get(7));// Currency
																									// code
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A018_CURR_PROCESS)).sendKeys(nominalList.get(8));// Currency
																										// processing
																										// A018_CURR_PROCESS
			if (nominalList.get(0).equals("6200"))

			{
				getDriver().findElement(By.xpath(pObject.A018_CHK_REV_ALLW)).click(); // A018_CHK_REV_ALLW

			}

			WaitHelper.waitAdditional(2);

			update = true;
		}
		return update;
	}

	/**
	 * Create Management/Analysis code
	 */
	public boolean enterManagementDetails(List<String> managementList)

	{
		log.info("Inside management details");
		boolean update = false;

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).clear();// A019_MNGT_KEY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).sendKeys(managementList.get(0));// Management
																									// code
																									// A019_MNGT_KEY
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).sendKeys(Keys.ENTER);// Management
																						// code
																						// A019_MNGT_KEY
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message))

		{

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();// A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(managementList.get(1));// Description
																									// A004A_DESCR

			getDriver().findElement(By.xpath(pObject.A019_SHRT_NAME)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A019_SHRT_NAME)).sendKeys(managementList.get(2));// Short
																										// Description
																										// A019_SHRT_NAME
			WaitHelper.waitAdditional(1);

			if (!getDriver().findElement(By.xpath(pObject.A019_FINC)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A019_FINC)).click();// Financial
																				// A019_FINC
			}

			if (!getDriver().findElement(By.xpath(pObject.A019_PLNG)).isSelected()) {
				getDriver().findElement(By.xpath(pObject.A019_PLNG)).click();// Planning
																				// A019_PLNG
			}

			if (!getDriver().findElement(By.xpath(pObject.A019_CST_ALC)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A019_CST_ALC)).click();// Cost
																				// allocation
																				// A019_CST_ALC
			}

			if (getDriver().findElement(By.xpath(pObject.A019_SUMM_TRANC)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A019_SUMM_TRANC)).click();// Sum
																					// A019_SUMM_TRANC
			}

			if (getDriver().findElement(By.xpath(pObject.A019_AVG_BLNC)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A019_AVG_BLNC)).click();// AVG
																					// Bal
																					// A019_AVG_BLNC
			}

			update = true;
		}
		return update;
	}

	/**
	 * Create Analysis code
	 */
	public boolean enterAnalysisDetails(List<String> managementList)

	{
		log.info("Inside management details");
		boolean update = false;

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).clear();// A019_MNGT_KEY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).sendKeys(managementList.get(0));// Management
																									// code
																									// A019_MNGT_KEY
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).sendKeys(Keys.ENTER);// Management
																						// code
																						// A019_MNGT_KEY
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message))

		{

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();// A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(managementList.get(1));// Description
																									// A004A_DESCR

			getDriver().findElement(By.xpath(pObject.A019_SHRT_NAME)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A019_SHRT_NAME)).sendKeys(managementList.get(2));// Short
																										// Description
																										// A019_SHRT_NAME
			WaitHelper.waitAdditional(1);

			if (!getDriver().findElement(By.xpath(pObject.A019_FINC)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A019_FINC)).click();// Financial
																				// A019_FINC
			}

			if (!getDriver().findElement(By.xpath(pObject.A019_PLNG)).isSelected()) {
				getDriver().findElement(By.xpath(pObject.A019_PLNG)).click();// Planning
																				// A019_PLNG
			}

			if (!getDriver().findElement(By.xpath(pObject.A019_CST_ALC)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A019_CST_ALC)).click();// Cost
																				// allocation
																				// A019_CST_ALC
			}

			if (getDriver().findElement(By.xpath(pObject.A019_SUMM_TRANC)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A019_SUMM_TRANC)).click();// Sum
																					// A019_SUMM_TRANC
			}

			getDriver().findElement(By.xpath(pObject.A033_PST_LIMIT_CHECKS)).click();// Post
																						// Limit
																						// Checks
																						// A033_PST_LIMIT_CHECKS
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A033_PST_LIMIT_CHECKS)).sendKeys(managementList.get(5));// Limit
																												// Checks
																												// A033_PST_LIMIT_CHECKS
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A033_BAL_LIMIT_CHECKS)).click();// BAL
																						// Limit
																						// Checks
																						// A033_BAL_LIMIT_CHECKS
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A033_BAL_LIMIT_CHECKS)).sendKeys(managementList.get(5));// A033_BAL_LIMIT_CHECKS
			WaitHelper.waitAdditional(1);

			update = true;
		}
		return update;
	}

	/**
	 * Create Formula
	 */

	public boolean enterFormulaDetails(List<String> fomulaList) {
		log.info("Inside Formula details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A025_FORM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A025_FORM)).sendKeys(fomulaList.get(0));// Formula
																							// A025_FORM
		getDriver().findElement(By.xpath(pObject.A025_FORM)).sendKeys(Keys.ENTER);// Formula
																					// A025_FORM
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(fomulaList.get(1));// Description
																								// A004A_DESCR

			getDriver().findElement(By.xpath(pObject.A025_HEADN)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A025_HEADN)).sendKeys(fomulaList.get(2));// Heading
																								// A025_HEADN

			if (fomulaList.get(3).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A025_CHK_APPY_CURR)).click();// Apply
																						// currency
																						// A025_CHK_APPY_CURR
			}

			if (!fomulaList.get(4).equals("Sum Columns")) {

				getDriver().findElement(By.xpath(pObject.A025_TOTL_CNTRL)).sendKeys(fomulaList.get(4));// Totalling
																										// Control
																										// A025_TOTL_CNTRL
			}

			getDriver().findElement(By.xpath(pObject.A025_FOR_EXP_LNONE)).clear();
			WaitHelper.waitAdditional(3);
			getDriver().findElement(By.xpath(pObject.A025_FOR_EXP_LNONE)).sendKeys(fomulaList.get(5));// Formula
																										// expression
																										// A025_FOR_EXP_LNONE
			update = true;
		}
		return update;
	}

	/**
	 * Create Layout
	 */
	public void enterLayoutDetails(List<String> layoutList) {
		log.info("Enter layout details");

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).clear();

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).sendKeys(layoutList.get(0));// Layout
																							// A026_LAYT

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(layoutList.get(1));// Description
																							// A004A_DESCR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A025_TOTL_CNTRL)).sendKeys(layoutList.get(2));// Total
																								// display
																								// A025_TOTL_CNTRL
		WaitHelper.waitAdditional(2);

		enterFormulasForLayout(layoutList.get(3), layoutList.get(7), layoutList.get(8), 1);
		enterFormulasForLayout(layoutList.get(4), layoutList.get(7), layoutList.get(8), 2);
		enterFormulasForLayout(layoutList.get(5), layoutList.get(7), layoutList.get(8), 3);
		enterFormulasForLayout(layoutList.get(6), layoutList.get(7), layoutList.get(8), 4);

	}

	/**
	 * Enter fourmula for layout
	 * 
	 * @param formula
	 * @param i
	 */
	private void enterFormulasForLayout(String formula, String formula1, String formula2, int i)

	{
		log.info("Enter formula layout details");
		WaitHelper.waitAdditional(2);

		if (BaseTest.browser.contains("internetexplorer")) {
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(formula);// Formula
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/select[@class='dojoxGridSelect']"))
					.sendKeys(formula1);// Highlight Rule
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(formula2);// Highlight
																												// Value
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);// Highlight
																													// Rule
			WaitHelper.waitAdditional(2);
		} else {
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(formula);// Formula
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/select[@class='dojoxGridSelect']"))
					.sendKeys(formula1);// Highlight Rule
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(formula2);// Highlight
																												// Rule
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);// Highlight
																													// Rule
			WaitHelper.waitAdditional(2);
		}

	}

	/**
	 * Enter Destination details
	 * 
	 * @param destinatioList
	 * @param i
	 */
	public void enterDestinationDetails(List<String> destinatioList) {
		log.info("Enter destination details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A007_DEST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEST)).sendKeys(destinatioList.get(0));// Destination
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(destinatioList.get(1));// Description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_SPOOL_ONLY)).click();// Device
																			// type
																			// -
																			// Spool
																			// only
	}

	/**
	 * Enter environment details - AFA
	 * 
	 * @param destinatioList
	 * @param i
	 */
	public boolean enterEnvironmentDetails(List<String> destinatioList) {
		log.info("Enter environment details page");
		boolean update = false;
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).sendKeys(destinatioList.get(0));// Environment
																								// group
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);

		if (!getToolContentText().contains(message)) {
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();// Description
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(destinatioList.get(1));

			getDriver().findElement(By.xpath(pObject.A010_SESS_TIME)).clear();// Session
																				// time
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A010_SESS_TIME)).sendKeys(destinatioList.get(2));

			getDriver().findElement(By.xpath(pObject.A010_PASS_EXP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A010_PASS_EXP)).sendKeys(destinatioList.get(3));// Password
																										// expiry

			getDriver().findElement(By.xpath(pObject.A010_MAX_SESS)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A010_MAX_SESS)).sendKeys(destinatioList.get(4));// Maximum
																										// sessions

			getDriver().findElement(By.xpath(pObject.A010_PROFILE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A010_PROFILE)).sendKeys(destinatioList.get(6));// Profile
			WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath(pObject.A010_RAD_NORMAL)).click();// Indicator
																				// -
																				// Normal
			update = true;
		}
		return update;
	}

	/**
	 * Modified by Chetna, Dt: 18-Jan-2017 Create Currency Relationship -AGC
	 * 
	 * @param currencyList
	 * 
	 */
	public boolean enterCurrencyRelationshipDetails(List<String> currencyList) {
		log.info("Enter currency relationship details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).sendKeys(currencyList.get(0));// Base
																									// currency

		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).sendKeys(currencyList.get(1));// Non-base
																										// currency
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).sendKeys(Keys.ENTER);// Non-base
																								// currency
		WaitHelper.waitAdditional(2);

		if (!VerifyToolContentMessage("The specified key already exists"))

		{

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A003_DIRECTION)).sendKeys(currencyList.get(2));// Direction
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A003_CONVERSION_UNIT)).clear();// Conversion
																					// Units
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A003_CONVERSION_UNIT)).sendKeys(currencyList.get(3));

			getDriver().findElement(By.xpath(pObject.A003_TOLERANCE_PERC)).clear();// Tolerance
																					// %
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A003_TOLERANCE_PERC)).sendKeys(currencyList.get(4));

			getDriver().findElement(By.xpath(pObject.A003_TOLERANCE_AMT)).clear();// Tolerance
																					// amount
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A003_TOLERANCE_AMT)).sendKeys(currencyList.get(5));
			update = true;
		}
		return update;
	}

	/**
	 * New Method Added By Chetna Mishra, dt: 18-01-2017 Enter Rate Types
	 * 
	 * @param RateTypeList
	 */
	public boolean enterRateTypeDetails(List<String> RateTypeList) {
		log.info("Enter Rate Type details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).clear();// Rate
																			// Type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(RateTypeList.get(0));
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(Keys.ENTER);

		if (!VerifyToolContentMessage("The specified key already exists")) {

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(RateTypeList.get(1));

			update = true;
		}
		return update;
	}

	/**
	 * Enter currency exchange details
	 * 
	 * @param currencyExchangeList
	 */
	public boolean enterCurrencyExchangeDetails(List<String> currencyExchangeList) {
		log.info("Enter currency exchange details");
		boolean update = false;
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).clear();// Base
																				// currency
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).sendKeys(currencyExchangeList.get(0));

		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).clear();// Non
																				// base
																				// currency
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).sendKeys(currencyExchangeList.get(1));

		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).clear();// Rate
																			// type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(currencyExchangeList.get(2));

		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);

		if (IsMessageToolBarDisplayed())

		{
			if (!getToolContentText().contains(message))
				update = true;
		} else {
			update = true;
		}
		return update;
	}

	/**
	 * Enter currency exchange rate details
	 * 
	 * @param currencyExchangeList
	 */
	public boolean enterCurrencyExchangeRateDetails(List<String> currencyExchangeList) {
		log.info("Enter currency exchange rate details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).clear();// BC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).sendKeys(currencyExchangeList.get(0));

		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).clear();// NBC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).sendKeys(currencyExchangeList.get(1));

		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).clear();// Rate
																			// type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(currencyExchangeList.get(2));

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).clear();// Effective
																				// Date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).sendKeys(currencyExchangeList.get(3));
		getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);

		if (!getToolContentText().contains(message))

		{
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A005_EXCHANGE_RATE)).clear();// Exchange
																					// rate
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A005_EXCHANGE_RATE)).sendKeys(currencyExchangeList.get(4));
			WaitHelper.waitAdditional(1);

			if (getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_PER)).getText().equals("1.00"))

			{
				getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_PER)).clear();// Tolerance
																						// %
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_PER)).sendKeys(currencyExchangeList.get(5));
			}
			if (getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_AMT)).getText().equals("1.00")) {
				getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_AMT)).clear();// Tolerance
																						// Amount
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_AMT)).sendKeys(currencyExchangeList.get(6));
			}
			update = true;
		}

		return update;
	}

	/**
	 * Create Structure details
	 * 
	 * @param structureList
	 */
	public void enterStructureDetails(List<String> structureList) {
		log.info("Enter structure details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A027_STRUC)).clear();
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).sendKeys(structureList.get(0));// structure

		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(structureList.get(1));// Description

		getDriver().findElement(By.xpath(pObject.A027_UNI_ELE_REQ)).click();// Unique
																			// elements

		ClickOnAnyTab("Balance Class Update", 1);
		WaitHelper.waitAdditional(2);

		if (BaseTest.browser.contains("internetexplorer")) {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

		} else {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));

		}

	}

	/**
	 * Enter default structure control details - A028
	 * 
	 * @param controlList
	 */

	public void enterControlDetails(List<String> controlList) {
		log.info("Enter control details");
		WaitHelper.waitAdditional(2);

		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.A027_STRUC)));// Chetna
																													// Wait
																													// Added

		getDriver().findElement(By.xpath(pObject.A027_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).sendKeys(controlList.get(0));// structure
																							// A027_STRUC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A028_PATH_CODE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A028_PATH_CODE)).sendKeys(controlList.get(1));// Path
																								// code
																								// A028_PATH_CODE
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A028_SUSP_ELEMNT)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A028_SUSP_ELEMNT)).sendKeys(controlList.get(2));// Suspense
																									// element
																									// A028_SUSP_ELEMNT

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A028_UPDT_CNTRL)).click();// Update
																			// control
																			// A028_UPDT_CNTRL
		getDriver().findElement(By.xpath(pObject.A028_UPDT_CNTRL)).sendKeys(controlList.get(3));// Update
																								// control
																								// A028_UPDT_CNTRL

		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A028_NET_BAL_IND)).sendKeys(controlList.get(4));// Net
																									// balance
																									// indicator
																									// A028_NET_BAL_IND
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A028_NET_BAL_LYT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A028_NET_BAL_LYT)).sendKeys(controlList.get(5));// Net
																									// balance
																									// layout
																									// A028_NET_BAL_LYT
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A028_NOML_BAL_LYT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A028_NOML_BAL_LYT)).sendKeys(controlList.get(6));// Nominal
																									// balance
																									// layout
																									// A028_NOML_BAL_LYT
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Balance Sheet", 1);
		WaitHelper.waitAdditional(2);

		if (BaseTest.browser.contains("internetexplorer")) {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).clear();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(controlList.get(7));

		} else {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).clear();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(controlList.get(7));

		}

	}

	/**
	 * Enter ledger control list details
	 * 
	 * @param ledgerControlList
	 */
	public void enterLedgerControlDetails(List<String> ledgerControlList) {
		log.info("Enter ledger control details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A020_LEDGR_COD)).clear();
		getDriver().findElement(By.xpath(pObject.A020_LEDGR_COD)).sendKeys(ledgerControlList.get(0));// Ledger
																										// code
																										// A020_LEDGR_COD

		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(ledgerControlList.get(1));// Description
																									// A004A_DESCR
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A020_CURR_RND_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A020_CURR_RND_ACC)).sendKeys(ledgerControlList.get(2));// Account
																										// A020_CURR_RND_ACC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A020_CURR_RND_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A020_CURR_RND_CST)).sendKeys(ledgerControlList.get(3));// Cost
																										// A020_CURR_RND_CST
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A020_CLOS_OUT_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A020_CLOS_OUT_ACC)).sendKeys(ledgerControlList.get(4));// Account
																										// A020_CLOS_OUT_ACC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A020_CLOS_OUT_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A020_CLOS_OUT_CST)).sendKeys(ledgerControlList.get(5));// Cost
																										// A020_CLOS_OUT_CST
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A020_JRN_SUSP_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A020_JRN_SUSP_ACC)).sendKeys(ledgerControlList.get(6));// Account
																										// A020_JRN_SUSP_ACC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A020_JRN_SUSP_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A020_JRN_SUSP_CST)).sendKeys(ledgerControlList.get(7));// Cost
																										// A020_JRN_SUSP_CST

	}

	/**
	 * 
	 * @param command
	 * @param i
	 *            = OK button id eg: 0_4_label and here i==4
	 * @param j
	 */
	public void enterCommandParameters(List<String> command, int i, int j) {
		log.info("Entering command parameters");
		WaitHelper.waitAdditional(3);
		Actions builder = new Actions(driver);
		if (j == 01) {
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/table/tbody/tr/td[2]")))
					.click().sendKeys(command.get(0)).build().perform();
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + i + pObject.LABEL)).click();
		getDriver().findElement(By.id(pObject.ZERO_ + i + pObject.LABEL)).click();
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Click on financial module
	 */
	private void clickOnFinancialModule() {
		log.info("Click On Financial Tab");
		getDriver().findElement(By.xpath(pObject.A001_FINANCIAL_MODULE_TAB)).click();
		WaitHelper.waitAdditional(2);

	}

	/**
	 * Click on purchasing module
	 */
	private void clickOnPurchasingModule() {
		log.info("Click On purchasing Tab");
		getDriver().findElement(By.xpath(pObject.A001_PURCHASING_MODULE_TAB)).click();

		WaitHelper.waitAdditional(2);
	}

	/**
	 * Verify financial module
	 * 
	 * @return
	 */

	private boolean verifyFinancialModule() {
		log.info("Verifying Financial module");
		WaitHelper.waitAdditional(2);

		boolean value = false;

		{

			if (!getDriver().findElement(By.xpath(pObject.A001_GENERAL_LEDGER)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_GENERAL_LEDGER)).click();// General
																						// Ledger
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_INTRA_COMPANY_ACCOUNTING)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_INTRA_COMPANY_ACCOUNTING)).click();// Intra
																									// Company
																									// Accounting
				WaitHelper.waitAdditional(1);
			}
			if (!getDriver().findElement(By.xpath(pObject.A001_AVERAGE_DAY_BALANCE)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_AVERAGE_DAY_BALANCE)).click();// AVg
																							// Day
																							// Balance
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_VALUE_DATED_ACCOUNTING)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_VALUE_DATED_ACCOUNTING)).click();// Value
																								// Dated
																								// Accounting
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_VALUE_DATED_ACCOUNTING)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_VALUE_DATED_ACCOUNTING)).click();// Value
																								// Dated
																								// Accounting
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_COMM_ACCOUNTING)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_COMM_ACCOUNTING)).click();// Comm
																						// Acco
				WaitHelper.waitAdditional(1);
			}
			if (!getDriver().findElement(By.xpath(pObject.A001_TIME_RECO)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_TIME_RECO)).click();// Timesheet
																					// Recd
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_JOB_BIL)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_JOB_BIL)).click();// Job
																				// Billng
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_PROJECT_TRACKING)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_PROJECT_TRACKING)).click();// Project
																							// Tracking
				WaitHelper.waitAdditional(1);
			}
			if (!getDriver().findElement(By.xpath(pObject.A001_BANK_REC)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_BANK_REC)).click();// Bank
																					// Recon
				WaitHelper.waitAdditional(1);
			}
			if (!getDriver().findElement(By.xpath(pObject.A001_DRIECT)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_DRIECT)).click();// Direct
																				// Debit
																				// Mand
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_PROPS_MNGT)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_PROPS_MNGT)).click();// Proposed
																					// Project
																					// Mngt
				WaitHelper.waitAdditional(1);
			}
			if (!getDriver().findElement(By.xpath(pObject.A001_FIXD_ASS)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_FIXD_ASS)).click();// Fixed
																					// Assets
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_LEAS)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_LEAS)).click();// Fixed
																				// Assets
				WaitHelper.waitAdditional(1);
			}

			value = true;
		}

		return value;
	}

	// private boolean verifyFinancialModule(){
	// log.info("Verifying Financial module");
	// WaitHelper.waitAdditional(2);
	// boolean value = false;
	//
	// boolean generalLedger =
	// getDriver().findElement(By.xpath(pObject.A001_GENERAL_LEDGER)).isSelected();
	// boolean projectTracking =
	// getDriver().findElement(By.xpath(pObject.A001_PROJECT_TRACKING)).isSelected();
	// boolean intraCompanyAccounting =
	// getDriver().findElement(By.xpath(pObject.A001_INTRA_COMPANY_ACCOUNTING)).isSelected();
	// boolean averageDaysBalance =
	// getDriver().findElement(By.xpath(pObject.A001_AVERAGE_DAY_BALANCE)).isSelected();
	// boolean valueDatedAccounting =
	// getDriver().findElement(By.xpath(pObject.A001_VALUE_DATED_ACCOUNTING)).isSelected();
	//
	// if(generalLedger==true && projectTracking==true)
	// {
	// value = true;
	// }
	// if(intraCompanyAccounting==true && averageDaysBalance==true &&
	// valueDatedAccounting==true){
	// value = true;
	// }
	//
	// return value;
	// }

	/**
	 * Verify finance module
	 * 
	 * @return
	 */
	public boolean verifyFinancialModules() {
		log.info("Verify Financial module");
		boolean value = false;
		clickOnFinancialModule();
		if (verifyFinancialModule() == true) {
			value = true;
		}
		return value;
	}

	/**
	 * Verify purchasing module
	 * 
	 * @return
	 */

	private boolean verifyPurchasingModule() {
		log.info("Verifying purchasing module");
		WaitHelper.waitAdditional(2);
		boolean value = false;

		{

			if (!getDriver().findElement(By.xpath(pObject.A001_ACCOUNTS_PAYABLE)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_ACCOUNTS_PAYABLE)).click();// Fixed
																							// Assets
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_cISEDI)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_cISEDI)).click();// cISEDI
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_SER_LDGR)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_SER_LDGR)).click();// Fixed
																					// Assets
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_PURCHASING_MANAGEMENT)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_PURCHASING_MANAGEMENT)).click();// Fixed
																								// Assets
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_INVENTORY_MANAGEMENT)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_INVENTORY_MANAGEMENT)).click();// Fixed
																								// Assets
				WaitHelper.waitAdditional(1);
			}

			if (!getDriver().findElement(By.xpath(pObject.A001_IN_FLIGHT)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A001_IN_FLIGHT)).click();// In
																					// Flight
				WaitHelper.waitAdditional(1);
			}

			clickOnUpdate();

			value = true;
		}
		return value;
	}

	/**
	 * Verify purchasing module
	 * 
	 * @return
	 */
	public boolean verifyPurchasingModules() {
		log.info("Verify purchasing module");
		boolean value = false;
		clickOnPurchasingModule();
		if (verifyPurchasingModule() == true) {
			value = true;
		}
		return value;
	}

	/**
	 * Enter structure build details A035
	 * 
	 * @param structureList
	 */

	public void enterStructureReBuildDetails(List<String> structureList, String companyName) {
		log.info("Enter structure rebuild details");
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(structureList.get(1));// Request
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);// Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(Keys.ENTER);// Press
																					// Enter
																					// to
																					// view
																					// years
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A035_YEAR1)).click();// Select
																		// years
																		// 2017
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_YEAR2)).click();// Select
																		// years
																		// 2016
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_YEAR3)).click();// Select
																		// years
																		// 2015
		WaitHelper.waitAdditional(1);

		if (BaseTest.browser.contains("internetexplorer")) {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();// Add
																						// structure
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(structureList.get(2));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);

			WaitHelper.waitAdditional(1);

			ClickOnSubmitFooter();// Submit button
			WaitHelper.waitAdditional(1);

		} else {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();// Add
																						// structure
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(structureList.get(2));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);

			WaitHelper.waitAdditional(1);

			ClickOnSubmitFooter();// Submit button
			WaitHelper.waitAdditional(1);

		}

	}

	public void ClickOnSubmitFooter() {
		log.info("Click on Submit Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Submit")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	public void doubleClick(WebElement structure) {
		WebElement structure1 = driver.findElement(By.xpath("//div[1]/table/tbody/tr/td[2]"));

		try {
			Actions action = new Actions(driver).doubleClick(structure1);
			action.build().perform();

		} catch (NoSuchElementException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Verify presence of About to Submit pop up
	 * 
	 * @return
	 */
	private boolean isAboutSubmitPopUpDisplayed() {
		WaitHelper.waitAdditional(2);
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)));// Chetna
																				// Wait
																				// Added
		return getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).isDisplayed();

	}

	/**
	 * 
	 * @param Submit
	 *            details
	 */
	public void enterAboutsubmitDetails() {
		WaitHelper.waitAdditional(4);
		if (!isAboutSubmitPopUpDisplayed()) {
			WaitHelper.waitAdditional(3);
		}
		getDriver().findElement(By.xpath(pObject.A035_HOLD)).click();// Hold
		WaitHelper.waitAdditional(2);

		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)));// Chetna
																				// Wait
																				// Added
		getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).click();// Submit

		WaitHelper.waitAdditional(5);
	}

	/**
	 * Verify presence of About to Submit pop up for A118
	 * 
	 * @return
	 */
	private boolean isAboutSubmitPopUpDisplayed1() {
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)));// Chetna
																				// Wait
																				// Added
		return getDriver().findElement(By.xpath(pObject.A118_CONFM_SUBMIT)).isDisplayed();

	}

	/**
	 * 
	 * @param Submit
	 *            details for A118
	 */
	public void enterAboutsubmitDetails1() {
		WaitHelper.waitAdditional(4);
		if (!isAboutSubmitPopUpDisplayed1()) {
			WaitHelper.waitAdditional(3);
		}
		getDriver().findElement(By.xpath(pObject.A118_HOLD)).click();// Hold
		WaitHelper.waitAdditional(2);

		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)));// Chetna
																				// Wait
																				// Added
		getDriver().findElement(By.xpath(pObject.A118_CONFM_SUBMIT)).click();// Submit

		WaitHelper.waitAdditional(5);
	}

	public void submitDetails(int i) {
		WaitHelper.waitAdditional(4);
		if (!isAboutSubmitPopUpDisplayed()) {
			WaitHelper.waitAdditional(3);
		}
		if (i == 1) {
			getDriver().findElement(By.xpath(pObject.A035_HOLD)).click();// Hold
		}
		WaitHelper.waitAdditional(2);
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)));// Chetna
																				// Wait
																				// Added
		getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).click();// Submit

		WaitHelper.waitAdditional(5);
	}

	/**
	 * Enter security group structure details
	 * 
	 * @param securityList
	 */
	public void enterSecurityGroupStructureDetails(List<String> securityList) {
		log.info("Enter security structure details");
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.SEVEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.SEVEN)).sendKeys(securityList.get(1));
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.NINE)).sendKeys(securityList.get(2));
	}

	/**
	 * Enter action commands
	 * 
	 * @param parameters
	 */
	public void enterCommands(String parameters) {
		log.info("Enter commands");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO + pObject.LABEL)).sendKeys(parameters);// Enter
																											// currency
																											// code
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO + pObject.LABEL)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Verify security group has access to e5h5 application
	 * 
	 * @param parameters
	 * @return
	 */
	public void enterUserDetails(List<String> parameters) {
		log.info("Enter user details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.FIVE)).sendKeys(parameters.get(3));// security
																									// element
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.SEVEN)).sendKeys(parameters.get(3));// security
																									// element
		WaitHelper.waitAdditional(2);
	}

	public boolean getUserDetails(List<String> parameters) {
		log.info("Get user details method");
		WaitHelper.waitAdditional(2);
		boolean userDetails = false;
		String securityGroup = " ";
		String reportSecurity = " ";

		securityGroup = getDriver().findElement(By.id("0_4")).getText();

		reportSecurity = getDriver().findElement(By.id("0_6")).getText();

		if (securityGroup.equals(parameters.get(4)) && reportSecurity.equals(parameters.get(4))) {
			userDetails = true;
		}
		WaitHelper.waitAdditional(2);
		return userDetails;

	}

	/**
	 * Create Batch type
	 */
	public boolean enterBatchTypeDetails(List<String> batachTypeList)

	{
		log.info("Inside batch type details method");
		boolean update = false;

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).clear(); // Batch
																			// type
																			// A021_BATCH_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).sendKeys(batachTypeList.get(0));// Batch
																									// type
																									// A021_BATCH_TYPE
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).sendKeys(Keys.ENTER);// Batch
																						// type
																						// A021_BATCH_TYPE
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message))

		{

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();// A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(batachTypeList.get(1));// Description
																									// A004A_DESCR

			getDriver().findElement(By.xpath(pObject.A021_LEDR_CTRL_CD)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A021_LEDR_CTRL_CD)).sendKeys(batachTypeList.get(2));// Ledger
																											// Control
																											// Code:
																											// A021_LEDR_CTRL_CD

			getDriver().findElement(By.xpath(pObject.A021_UPDT_IND)).sendKeys(batachTypeList.get(3));// Update
																										// Indicator
																										// A021_UPDT_IND

			getDriver().findElement(By.xpath(pObject.A021_BS_VALUE)).click();// Base
																				// A021_BS_VALUE
			WaitHelper.waitAdditional(1);

			if (batachTypeList.get(4).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A021_FRN_VALUE)).click();// Foreign
																					// A021_FRN_VALUE
				WaitHelper.waitAdditional(1);

			}
			if (batachTypeList.get(5).equals("1")) {

				getDriver().findElement(By.xpath(pObject.A021_BSN_FRN)).click();// Base
																				// and
																				// Foreign
																				// A021_BSN_FRN
				WaitHelper.waitAdditional(1);
			}
			update = true;
		}
		return update;
	}

	/**
	 * Enter ledger batch details
	 * 
	 * @param batchList
	 * @return
	 */

	public boolean enterLedgerBatchTypeDetails(List<String> batchList) {
		log.info("Inside ledger batch type details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).clear(); // A021_BATCH_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).sendKeys(batchList.get(0));// Batch
																								// type
																								// A021_BATCH_TYPE
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).sendKeys(Keys.ENTER);// Batch
																						// type
																						// A021_BATCH_TYPE
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();// A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(batchList.get(1));// Batch
																								// description
																								// A004A_DESCR

			getDriver().findElement(By.xpath(pObject.A021_LEDR_CTRL_CD)).clear();// A021_LEDR_CTRL_CD
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A021_LEDR_CTRL_CD)).sendKeys(batchList.get(2));// Ledger
																									// code
																									// A021_LEDR_CTRL_CD

			if (!batchList.get(3).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A021_UPDT_IND)).sendKeys(batchList.get(3));// Update
																									// indicator
																									// A021_UPDT_IND
			}
			if (batchList.get(4).equals("1")) {
				if (!getDriver().findElement(By.xpath(pObject.A024_SECDRY_IND)).isSelected()) {
					getDriver().findElement(By.xpath(pObject.A024_SECDRY_IND)).click();// Secondary
																						// index
																						// A024_SECDRY_IND
				}
			}
			if (batchList.get(5).equals("1")) {
				if (!getDriver().findElement(By.xpath(pObject.A021_BS_VALUE)).isSelected()) {
					getDriver().findElement(By.xpath(pObject.A021_BS_VALUE)).click();// Base
																						// values
																						// A021_BS_VALUE
				}
			}
			if (batchList.get(6).equals("1")) {
				if (!getDriver().findElement(By.xpath(pObject.A021_FRN_VALUE)).isSelected()) {
					getDriver().findElement(By.xpath(pObject.A021_FRN_VALUE)).click();// Foreign
																						// Values
																						// A021_FRN_VALUE
				}
			}
			if (batchList.get(7).equals("1")) {
				if (!getDriver().findElement(By.xpath(pObject.A021_BSN_FRN)).isSelected()) {
					getDriver().findElement(By.xpath(pObject.A021_BSN_FRN)).click();// Base
																					// and
																					// Foreign
																					// values
																					// A021_BSN_FRN
				}
			}
			WaitHelper.waitAdditional(2);
			if (!batchList.get(8).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A024_ACCRL)).sendKeys(batchList.get(8));// Accruals
																									// A024_ACCRL
			}
			WaitHelper.waitAdditional(2);
			if (!batchList.get(9).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A024_RCCRL)).sendKeys(batchList.get(9));// Recurrals
																									// A024_RCCRL
			}
			WaitHelper.waitAdditional(1);
			update = true;
		}
		return update;
	}

	/**
	 * Enter default structure element details
	 * 
	 * @param elementList
	 * @return
	 */

	public boolean enterElementDetails(List<String> elementList)

	{
		log.info("Inside default structure elements method");
		boolean update = false;

		getDriver().findElement(By.xpath(pObject.A027_STRUC)).clear();// A027_STRUC
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).sendKeys(elementList.get(0));// Structure
																							// A027_STRUC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear(); // A028_ELEMENT
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elementList.get(1));// Element
																								// A029_ELEMENT

		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(Keys.ENTER);// Element
																						// A029_ELEMENT
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear(); // Description
																			// A004A_DESCR
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(elementList.get(2));// Description
																								// A004A_DESCR
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT)).clear();// A028_NEW_PARENT
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT)).sendKeys(elementList.get(3));// New
																									// Parent
																									// A028_NEW_PARENT
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A029_CHK_NOM_BAL)).click();// Nominal
																				// balance
																				// A028_CHK_NOM_BAL
			WaitHelper.waitAdditional(2);
			update = true;
		}

		return update;
	}

	/**
	 * Click on path key
	 * 
	 * @param i
	 */
	public void clickOnPathKey() {
		log.info("Click on path key");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Path")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Search path key
	 * 
	 * @param pathList
	 * @param i
	 */
	public void searchPathKey(List<String> pathList, int i) {
		log.info("Search path key details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(pathList.get(0));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(pathList.get(1));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(pathList.get(2));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR + pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR + pObject._ZERO)).sendKeys(pathList.get(3));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + i + pObject.LABEL));
		WaitHelper.waitAdditional(2);
	}

	public void createPathKey(List<String> pathList) {
		log.info("Enter path key details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY_IN)).clear();// A029_PATH_KEY_IN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY_IN)).sendKeys(pathList.get(2));/// Path
																								/// key
																								/// A029_PATH_KEY_IN
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear(); // A004A_DESCR
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(pathList.get(3));// Description
																							// A004A_DESCR
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT_IN)).clear();// A029_NEW_PARENT_IN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT_IN)).sendKeys(pathList.get(4));// New
																								// Parent
																								// A029_NEW_PARENT_IN
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Click on Return button
	 * 
	 */

	public void clickOnReturnButton() {
		log.info("Click on Return Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Return")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Verify company control check list
	 * 
	 * @param companyControl
	 * @return
	 */
	public boolean verifyCompanyControl(List<String> companyControl) {
		log.info("Verify company control details");
		boolean control = false;
		boolean accLayout = false;
		boolean bSPLLayout = false;
		boolean icaStructure = false;
		boolean transfer = false;
		boolean reversal = false;
		WaitHelper.waitAdditional(3);

		if (!isPrimaryDetailsTabSelected()) {
			ClickOnAnyTab("Primary Details", 1);
		}

		String acc = getDriver().findElement(By.xpath(pObject.A031_ACC_LAY1)).getText();// A031_ACC_LAY1
		String bspl = getDriver().findElement(By.xpath(pObject.A031_BSPL_LAY1)).getText(); // A031_BSPL_LAY1
		String structure = getDriver().findElement(By.xpath(pObject.A031_IC_STRUCT)).getText();// A031_IC_STRUCT

		if (acc.equals(companyControl.get(6))) {
			accLayout = true;
		}
		if (bspl.equals(companyControl.get(7))) {
			bSPLLayout = true;
		}
		if (structure.equals(companyControl.get(8))) {
			icaStructure = true;
		}

		ClickOnAnyTab("Batch Types", 1);

		WaitHelper.waitAdditional(3);

		String TRANS = getDriver().findElement(By.xpath(pObject.A031_TRANS1)).getText(); // A031_TRANS1
		String REVRSL = getDriver().findElement(By.xpath(pObject.A031_REVRS1)).getText();// A031_REVRS1

		if (TRANS.equals(companyControl.get(9))) {
			transfer = true;
		}
		if (REVRSL.equals(companyControl.get(10))) {
			reversal = true;
		}

		if (accLayout == true && bSPLLayout == true && icaStructure == true && transfer == true && reversal == true) {
			control = true;
		}

		WaitHelper.waitAdditional(3);
		return control;
	}

	/*
	 * Enter user details
	 * 
	 * @param companyID
	 */

	public void amendUsersDetails(String companyID)

	{
		log.info("Inside Amending/User Edit Page");
		WaitHelper.waitAdditional(1);
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB)));

		if (!isPrimaryDetailsTabSelected())

		{

			ClickOnAnyTab("Primary Details", 1);

		}

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_DEFAULT_CMPNY)).clear();// Default
																				// company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_DEFAULT_CMPNY)).sendKeys(companyID);
		WaitHelper.waitAdditional(1);
	}

	/*
	 * Enter user details
	 * 
	 * @param userDetails
	 */
	public void enterUsersDetails(String companyName, List<String> userDetails) {
		log.info("Inside Insert user detail page");
		WaitHelper.waitUntilWebElementDisplayed(getDriver(),
				getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB)));// Chetna
																				// Wait
																				// Added

		if (!isPrimaryDetailsTabSelected()) {
			ClickOnAnyTab("Primary Details", 1);
		}

		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).sendKeys(userDetails.get(0));// User
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(userDetails.get(1));// Description

		getDriver().findElement(By.xpath(pObject.A011_MENU)).clear();// Menu
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_MENU)).sendKeys(userDetails.get(2));

		getDriver().findElement(By.xpath(pObject.A011_DEFAULT_CMPNY)).clear();// Default
																				// company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_DEFAULT_CMPNY)).sendKeys(companyName);

		getDriver().findElement(By.xpath(pObject.LOGIN_PASSWORD)).clear();// Password
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.LOGIN_PASSWORD)).sendKeys(userDetails.get(3));

		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).clear();// Non-Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).sendKeys(userDetails.get(4));

		getDriver().findElement(By.xpath(pObject.A011_CMPNY)).clear();// Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_CMPNY)).sendKeys(userDetails.get(5));

		getDriver().findElement(By.xpath(pObject.A011_REPORT)).clear();// Report
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_REPORT)).sendKeys(userDetails.get(6));

		getDriver().findElement(By.xpath(pObject.A011_REPORT_CMPNY)).clear();// Report
																				// Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_REPORT_CMPNY)).sendKeys(userDetails.get(7));

		WaitHelper.waitAdditional(1);
		ClickOnAnyTab("Job/ Location Details", 1);

		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).clear();// Environment
																		// Group
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).sendKeys(userDetails.get(8));

		getDriver().findElement(By.xpath(pObject.A011_EWS_PRTN)).clear();// EWS
																			// Partition
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_EWS_PRTN)).sendKeys(userDetails.get(9));

		getDriver().findElement(By.xpath(pObject.A011_LANG)).clear();// Language
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_LANG)).sendKeys(userDetails.get(10));
		WaitHelper.waitAdditional(1);
	}

	/**
	 * Enter balance class details - A022
	 * 
	 * @param balanceList
	 */

	public boolean enterBalanceClass(List<String> balanceList) {
		log.info("Inside balance class method");
		boolean update = false;
		WaitHelper.waitAdditional(3);

		if (!isPrimaryDetailsTabSelected()) {
			clickOnPrimaryDetailsTab();
			WaitHelper.waitAdditional(1);
		}

		String[] element = balanceList.get(0).split(",");

		getDriver().findElement(By.xpath(pObject.A022_BAL_CLS)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A022_BAL_CLS)).sendKeys(element[0]);// Balance
																						// class
																						// A022_BAL_CLS
		getDriver().findElement(By.xpath(pObject.A022_BAL_CLS)).sendKeys(element[1]);// Balance
																						// class
																						// A022_BAL_CLS

		getDriver().findElement(By.xpath(pObject.A022_BAL_CLS)).sendKeys(Keys.ENTER);// Balance
																						// class
																						// A022_BAL_CLS
		WaitHelper.waitAdditional(2);
		if (!getToolContentText().contains(message)) {
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(balanceList.get(1));// Description
																								// A004A_DESCR

			if (balanceList.get(2).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A022_STASTICAL)).click();// Statistical
																					// A022_STASTICAL
			}
			if (balanceList.get(3).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A022_TRANSATION)).click();// Transaction
																					// A022_TRANSATION
			}

			if (getDriver().findElement(By.xpath(pObject.A022_ROLL_FLAG)).isSelected())

			{
				getDriver().findElement(By.xpath(pObject.A022_ROLL_FLAG)).click();// Roll
																					// Flag
																					// A022_ROLL_FLAG
			}

			getDriver().findElement(By.xpath(pObject.A022_CALN_TYPE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A022_CALN_TYPE)).sendKeys(balanceList.get(5));// Calendar
																									// Type
																									// A022_CALN_TYPE

			getDriver().findElement(By.xpath(pObject.A022_PATH)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A022_PATH)).sendKeys(balanceList.get(6));// Path
																								// Code
																								// A022_PATH

			WaitHelper.waitAdditional(3);

			if (!isSecondaryDetailsTabSelected()) {
				clickOnSecondaryDetailsTab();
			}

			WaitHelper.waitAdditional(1);
			if (balanceList.get(7).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A022_FRN_CURR)).click();// Foreign
																					// Currency
																					// A022_FRN_CURR
			}
			WaitHelper.waitAdditional(1);
			if (balanceList.get(8).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A022_VAT)).click();// VAT//chk_0_11
																			// A022_VAT
			}
			WaitHelper.waitAdditional(1);
			if (balanceList.get(9).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A022_ALW_BTCH_BAL)).click();// Allow
																						// Batches
																						// Out
																						// Of
																						// Balance
																						// A022_ALW_BTCH_BAL
			}
			WaitHelper.waitAdditional(2);

			if (!balanceList.get(10).equals("Not Active")) {

				getDriver().findElement(By.xpath(pObject.A022_AVG_DLY_BAL)).sendKeys(balanceList.get(10));// Average
																											// Daily
																											// Balances
																											// A022_AVG_DLY_BAL
			}

			WaitHelper.waitAdditional(2);
			update = true;
		}
		return update;
	}

	/**
	 * Enter company controls - A023
	 * 
	 * @param companyControl
	 */
	public void enterCompanyControlDetails(String companyName, List<String> companyControl)

	{
		log.info("Enter company control details");
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);// Company
																						// A006_COMPANY

		getDriver().findElement(By.xpath(pObject.A023_CURNT_PER)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CURNT_PER)).sendKeys(companyControl.get(0));// Period
																									// A023_CURNT_PER

		getDriver().findElement(By.xpath(pObject.A023_CURNT_YR)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CURNT_YR)).sendKeys(String.valueOf(calender.fromyear()));// Year
																												// A023_CURNT_YR

		getDriver().findElement(By.xpath(pObject.A023_CNTL_AC_CD)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CNTL_AC_CD)).sendKeys(companyControl.get(2));// Control
																									// account
																									// code
																									// A023_CNTL_AC_CD

		getDriver().findElement(By.xpath(pObject.A023_CALDR)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CALDR)).sendKeys(companyControl.get(3));// Calender
																								// A023_CALDR

		getDriver().findElement(By.xpath(pObject.A023_YR_RNGE_FUTR)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_YR_RNGE_FUTR)).sendKeys(companyControl.get(4));// Future
																										// A023_YR_RNGE_FUTR

		getDriver().findElement(By.xpath(pObject.A023_YR_RNGE_HIST)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_YR_RNGE_HIST)).sendKeys(companyControl.get(5));// History
																										// A023_YR_RNGE_HIST

		getDriver().findElement(By.xpath(pObject.A023_CHK_AVGBALSH)).click();// Alternative
																				// Balance
																				// Sheet
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Batch Types", 1);

		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A023_SUMMAR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_SUMMAR)).sendKeys(companyControl.get(6));// Summ
																								// A023_SUMMAR
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Account Controls", 1);

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_TRANSAC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_TRANSAC)).sendKeys(companyControl.get(7)); // Transac
																									// A023_TRANSAC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_STSCL_BAL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_STSCL_BAL)).sendKeys(companyControl.get(8));// Stat
																									// balance
																									// Class
																									// A023_STSCL_BAL
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_CHK_FINC)).click();// Financial
																			// A023_CHK_FINC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_CST_ALOC)).click();// Cost
																				// allocation
																				// A023_CHK_CST_ALOC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_AVG_BAL)).click();// Average
																			// balances
																			// A023_CHK_AVG_BAL
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_CHK_PLANG)).click();// Planning
																			// A023_CHK_PLANG
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Data Entry Controls", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A023_SUSPN_ACC)).sendKeys(companyControl.get(9));// Suspense
																									// account
																									// A023_SUSPN_ACC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_CHK_TOTL_ON_QTY)).click();// Totaling
																				// on
																				// quantity
																				// A023_CHK_TOTL_ON_QTY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_GNE_BATCH_BAL_RCRD)).click();// Generate
																						// batch
																						// balancing
																						// records
																						// A023_CHK_GNE_BATCH_BAL_RCRD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_CLS_ACC_LST_YR)).click();// Close
																					// account
																					// for
																					// last
																					// year
																					// A023_CHK_CLS_ACC_LST_YR
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_REV_WRIT_FLG)).click();// Revolution
																					// write
																					// off
																					// flag
																					// A023_CHK_REV_WRIT_FLG
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_DTA_ENTRY_IMD_UPD)).click();// Data
																						// entry
																						// immidiate
																						// update
																						// A023_CHK_DTA_ENTRY_IMD_UPD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_REC_MSG)).click();// Reconcilation
																			// message
																			// A023_CHK_REC_MSG
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_DEL_CHK)).click();// Delete
																			// check
																			// A023_CHK_DEL_CHK
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_ACCEPT_WAR_OFF)).click();// Accept
																					// warnings
																					// off
																					// line
																					// A023_CHK_ACCEPT_WAR_OFF
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Currency Controls/PEV", 1);

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CURR_R_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CURR_R_TYPE)).sendKeys(companyControl.get(11));// Currency
																										// rate
																										// type
																										// A023_CURR_R_TYPE

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_RNDG_TOLRN_AMT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_RNDG_TOLRN_AMT)).sendKeys(companyControl.get(12));// Rounding
																										// currency
																										// A023_RNDG_TOLRN_AMT
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_RNDG_TOLRN_PERC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_RNDG_TOLRN_PERC)).sendKeys(companyControl.get(13));// Rounding
																											// tolerance
																											// %
																											// A023_RNDG_TOLRN_PERC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_CHK_CURR_REV_ALLW)).click();// Currency
																					// revaluation
																					// allowed
																					// A023_CHK_CURR_REV_ALLW
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_CURR_TOL_PROC)).sendKeys(companyControl.get(14));// Currency
																										// tolerence
																										// processing
																										// A023_CURR_TOL_PROC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_BTCH_TYPE)).sendKeys(companyControl.get(15));// Batch
																									// type
																									// A023_BTCH_TYPE
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Reconciliation/Archive", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A023_CHK_ACCT_PAYBL)).click();// Archive
																				// A023_CHK_ACCT_PAYBL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_ACCT_RECIBL)).click();// Archive
																				// A023_CHK_ACCT_RECIBL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_PURC_MNGT)).click(); // A023_CHK_PURC_MNGT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_INV_MNGT)).click();// A023_CHK_INV_MNGT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_FIX_ASST)).click();// A023_CHK_FIX_ASST
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_FIX_ASST_LEA)).click();// A023_CHK_FIX_ASST_LEA

		getDriver().findElement(By.xpath(pObject.A023_CHK_ARC_TRAN_INDI)).click();// A023_CHK_ARC_TRAN_INDI
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A023_CHK_ARC_UNREC_TRANS)).click();// A023_CHK_ARC_UNREC_TRANS
		WaitHelper.waitAdditional(1);

	}

	/**
	 * Update company controls A031
	 * 
	 * @param companyControl
	 */
	public void updateCompanyControlDetails(List<String> companyControl) {
		log.info("Update company controls");
		WaitHelper.waitAdditional(2);

		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.A031_ACC_LAY)));// Chetna
																														// Wait
																														// Added

		getDriver().findElement(By.xpath(pObject.A031_ACC_LAY)).clear();// A031_ACC_LAY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A031_ACC_LAY)).sendKeys(companyControl.get(0));// Account
																								// Layout
																								// A031_ACC_LAY
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A031_BSPL_LAY)).clear();// A031_BSPL_LAY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A031_BSPL_LAY)).sendKeys(companyControl.get(1));// BPSL
																									// Layout
																									// A031_BSPL_LAY
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A031_STRUCT)).clear();// A031_STRUCT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A031_STRUCT)).sendKeys(companyControl.get(2));// Structure
																								// A031_STRUCT
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A031_CODE_ID)).clear();// A031_CODE_xpath
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A031_CODE_ID)).sendKeys(companyControl.get(3));// Code
																								// id
																								// A031_CODE_ID
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Batch Types", 1);

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A031_TRANS)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A031_TRANS)).sendKeys(companyControl.get(4));// Transfer
																								// A031_TRANS

		getDriver().findElement(By.xpath(pObject.A031_REVRS)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A031_REVRS)).sendKeys(companyControl.get(5));// Reversal
																								// A031_REVRS
		WaitHelper.waitAdditional(2);
		clickOnUpdate();
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Enter BTZ ICA elements details - A036
	 * 
	 * @param elements
	 */

	public boolean enterICAElements(List<String> elements) {
		log.info("Inside ICA elements method");
		boolean update = false;
		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.A036_EELE)));// Chetna
																													// Wait
																													// Added

		getDriver().findElement(By.xpath(pObject.A036_EELE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A036_EELE)).sendKeys(elements.get(0));// Element
		getDriver().findElement(By.xpath(pObject.A036_EELE)).sendKeys(Keys.ENTER);// Element
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A036_ICA_MNGT_CODE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A036_ICA_MNGT_CODE)).sendKeys(elements.get(1));// ICA
																									// management
																									// code
			getDriver().findElement(By.xpath(pObject.A036_GEN_LEDGR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A036_GEN_LEDGR)).sendKeys(elements.get(2));// General
																								// ledger
			WaitHelper.waitAdditional(1);
			update = true;
		}
		return update;
	}

	/**
	 * Enter ICA relationship details - A037
	 * 
	 * @param elments
	 */
	public void enterICARelationShip(List<String> elments) {
		log.info("Enter ICA relationship");
		WaitHelper.waitAdditional(2);
		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.A037_FRM_BTZ)));// Chetna
																														// Wait
																														// Added
		getDriver().findElement(By.xpath(pObject.A037_FRM_BTZ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_FRM_BTZ)).sendKeys(elments.get(0));// From
																							// BTZ
																							// entity

		getDriver().findElement(By.xpath(pObject.A037_TO_BTZ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_TO_BTZ)).sendKeys(elments.get(1));// To
																						// BTZ
																						// entity
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_GEN_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A037_GEN_ACC)).sendKeys(elments.get(2));// General
																							// Ledger
																							// Account
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_GEN_COST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_GEN_COST)).sendKeys(elments.get(3));// Cost
		WaitHelper.waitAdditional(1);

	}

	/**
	 * Enter Process EP2 details A038
	 * 
	 * @param processDetails
	 */
	public void enterEP2ProcessDetails(List<String> processDetails, String companyName) {
		log.info("Enter EP2 process details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();// Request
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(processDetails.get(1));// Request

		getDriver().findElement(By.xpath(pObject.A035_CMPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);// Company
																					// ID
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(3);

		getDriver().findElement(By.xpath(pObject.A038_CHK_UPDT_All)).click();// Update
																				// all
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A038_CHK_NET_BAL)).click();// Net
																			// balances
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A038_CHK_NET_BAL)).sendKeys(Keys.TAB);
		getDriver().findElement(By.xpath(pObject.A038_CHK_NET_BAL)).sendKeys(Keys.ENTER);

		WaitHelper.waitAdditional(3);
		ClickOnSubmitFooter();// Submit button

		WaitHelper.waitAdditional(5);

	}

	/**
	 * Enter Process EP4 details - A041
	 * 
	 * @param processDetails
	 */

	public void enterEP4ProcessDetails(List<String> processDetails, String companyName) {

		getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(processDetails.get(3));// Request
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);// Company
																					// ID
		WaitHelper.waitAdditional(1);

		ClickOnSubmitFooter();

	}

	/**
	 * Click on submit button
	 */
	public void clickOnSubmit() {
		log.info("Clicking on Submit button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Submit")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Enter Process EP5 details - A041
	 * 
	 * @param processDetails
	 */
	public void enterEP5ProcessDetails(List<String> processDetails, String companyName) {
		log.info("Enter EP5 process details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();// Request
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(processDetails.get(3));// Request

		getDriver().findElement(By.xpath(pObject.A035_CMPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);// Company
																					// ID
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(3);

		getDriver().findElement(By.xpath(pObject.A038_CHK_UPDT_All)).click();// Update
																				// all
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A038_CHK_INCLD)).click();// Include
		WaitHelper.waitAdditional(2);

		ClickOnAnyButton("Submit", 1);
		ClickOnAnyButton("Submit", 1);
		WaitHelper.waitAdditional(2);

	}

	/**
	 * Enter balance sheet details - A039
	 * 
	 * @param group
	 */
	public void balanceSheetDetails(List<String> group) {
		log.info("Enter balance sheet details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).clear();
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).sendKeys(group.get(0));// Enter
																					// Layout

		getDriver().findElement(By.xpath(pObject.A039_EXT_SEL)).click();

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(group.get(1));// Enter
																					// Group
		WaitHelper.waitAdditional(1);

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A039_EXT_OK)).click();// Ok
																		// button
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Verify balance sheet - A039
	 * 
	 * @param group
	 */
	public void verifyBalanceSheetDetails(List<String> group) {
		log.info("Verify balance sheet details");
		List<WebElement> wbs = driver.findElements(By.xpath("//div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]"));
		for (WebElement wb : wbs) {
			wb.getText().contains(group.get(1));
		}

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]")).getText();// gets
																												// Group
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]")).getText();// gets
																												// Cat
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[3]")).getText();// gets
																												// Description
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[4]")).getText();// gets
																												// CP
																												// actl
																												// Balance
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[5]")).getText();// gets
																												// YTD
																												// actl
																												// Balance
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Click on Years H button
	 */

	public void clickOnYearsH() {
		log.info("Clicking on Years (H) button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Years (H)")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Click on Run activity
	 */
	public void clickOnRunActivity() {
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Run activity button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Run Activity")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Click on years
	 */
	public void clickOnYears() {
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Years button");

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_BTM_BUT_SECTION));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Years")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on Events H
	 */
	public void clickOnEventsH() {
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Events (H) button");
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_BTM_BUT_SECTION));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Events (H)")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on Activity
	 */
	public void clickOnActivity() {
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Years button");

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_BTM_BUT_SECTION));
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Activity")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Enter fiscal calendar details
	 * 
	 * @param calender
	 * @param year1
	 * @param year2
	 * @param year3
	 * @param year4
	 * @param year5
	 */
	public void enterFiscalCalendarDetails(List<String> calender) {
		log.info("Enter fiscal calender details");

		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.xpath(pObject.A013_CALENDER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A013_CALENDER)).sendKeys(calender.get(0));// Calender
																							// A013_CALENDER

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(calender.get(1));// Description
																							// A004A_DESCR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(calender.get(2));// Company
																							// Code
																							// A006_COMPANY

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A013_WEEKENDDAY)).sendKeys(calender.get(3));// Weekend
																								// Day

		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A013_LVL_NAME)).click();// Level
																			// Name
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A013_LVL_NAME1)).sendKeys(calender.get(4));// Level
																							// Name
																							// Input
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A013_LVL_DESC)).click();// Level
																			// description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A013_LVL_DESC1)).sendKeys(calender.get(5));// Level
																							// description
																							// input
		WaitHelper.waitAdditional(1);

		WebElement years = driver.findElement(By.xpath(pObject.A013_YEARS));
		driver.executeScript("arguments[0].scrollIntoView(true);", years);

		ClickOnAnyButton("Years", 1);
		ClickOnAnyButton("Years", 1);

		WaitHelper.waitAdditional(5);

		/* Enter fiscal years */
		enterFiscalYears(1);

		clickOnEventsH();

		getCalendarEvents("01 Dec 1999", calender.get(6));
		WaitHelper.waitAdditional(2);

	}

	/**
	 * Enter fiscal years in the grid
	 * 
	 * @param years
	 * @param i
	 */
	private void enterFiscalYears(int i) {
		log.info("Enter fiscal years");

		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// Year
																							// 1996
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input"))
				.sendKeys(String.valueOf(calender.calStartFromYear()));// Year
																		// 1996
																		// input
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();// Name
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input"))
				.sendKeys(String.valueOf(calender.calStartFromYear()));// Name
																		// input
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();// Start
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/input"))
				.sendKeys(String.valueOf(calender.calStartFromDate()));// Start
																		// input
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();// End
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input"))
				.sendKeys(String.valueOf(calender.calStartToDate()));// End
																		// input
		WaitHelper.waitAdditional(1);

		int nextYear = Integer.parseInt(calender.calStartFromYear());
		while (!(nextYear == cal.get(Calendar.YEAR) + 1))

		{
			nextYear++;
			i++;
			// Calendar calendar = new GregorianCalendar();

			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// Year
																								// 1996
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input"))
					.sendKeys(String.valueOf(nextYear));// Year 1996 input
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();// Name
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input"))
					.sendKeys(String.valueOf(nextYear));// Name input
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();// Start
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/input"))
					.sendKeys(calender.calStartNextDate(nextYear));// Start
																	// input
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();// End
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input"))
					.sendKeys(calender.calEndNextDate(nextYear));// End input
			WaitHelper.waitAdditional(1);

			if (i == 16) {

				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);
				WaitHelper.waitAdditional(1);
				clickOnFwd();
				i = 1;

			}

			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);// Press
																													// Enter
																													// to
																													// get
																													// days

			WaitHelper.waitAdditional(3);
		}

	}

	/**
	 * Get calendar events
	 * 
	 * @param date
	 * @param calender
	 */
	public void getCalendarEvents(String date, String calender) {
		log.info("Get calendar");

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A013_START_DATE)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A013_START_DATE)).sendKeys(date);// Enter
																					// date
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A013_START_DATE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);

		clickOnActivity();

		getDriver().findElement(By.xpath(pObject.A013_ACTIVITY)).sendKeys(calender);
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A013_ACTIVITY)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);

		clickOnActivity();
		WaitHelper.waitAdditional(2);
	}

	/**
	 * searchPeriodAndYearDetails
	 */

	public void enterLockCalendarDetails(int i)

	{
		log.info("Enter fiscal calender Lock details");

		clickOnBKWD();
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]/input")).sendKeys("Y");// Year
																										// 1996
																										// input
																										// onwards
		WaitHelper.waitAdditional(1);

		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		int nextYear = Integer.parseInt(calender.calStartFromYear());

		while (!(nextYear == cal.get(Calendar.YEAR) + 1))

		{
			nextYear++;
			i++;

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[7]/input")).sendKeys("Y");// Year
																											// 1996
																											// input
																											// onwards
			WaitHelper.waitAdditional(1);

			if (i == 16) {

				clickOnFwd();
				i = 1;

			}
		}
	}

	/**
	 * searchPeriodAndYearDetails
	 */

	public void searchPeriodAndYearDetails(String element) {
		if (!isOkButtonDisplayed(5)) {
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).clear();
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).sendKeys(element);// Company
		WaitHelper.waitAdditional(1);
		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Click on GL period
	 */

	public void clickOnCloseGLPeriod() {
		log.info("Click on GL period");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Close GL Period")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Click on period of the year
	 * 
	 * @return
	 */
	public String periodOfTheYear() {
		log.info("Get period of the year");
		String period = null;
		WaitHelper.waitAdditional(2);
		period = driver.findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).getText();// Period
		return period;
	}

	/**
	 * Click on Lines button Modified by Chetna
	 */

	public void clickOnLines() {
		log.info("Click on lines");

		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Lines")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * EDB Enter Journal details
	 * 
	 * @param details
	 */
	public void enterJournalDetails(List<String> icaData) {
		log.info("Enter journal details");

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_JOUR_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_JOUR_TYPE)).sendKeys(icaData.get(0));// J
																							// Type

		getDriver().findElement(By.xpath(pObject.A040_JOUR_REF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_JOUR_REF)).sendKeys(icaData.get(1));// J
																							// Reference

		getDriver().findElement(By.xpath(pObject.A040_PERI)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_PERI)).sendKeys(icaData.get(4));// Period

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_YEAR)).sendKeys(icaData.get(5));// Year

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_BTZ_ELE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_BTZ_ELE)).sendKeys(icaData.get(2));// BTZ
																							// Element

		getDriver().findElement(By.xpath(pObject.A040_DESC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_DESC)).sendKeys(icaData.get(3));// Description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_DESC)).sendKeys(Keys.ENTER);// Description

		// WaitHelper.waitAdditional(2);
		// clickOnAcceptWarnings();
		WaitHelper.waitAdditional(2);

	}

	/**
	 * Enter journal lines
	 * 
	 * @param lines
	 */
	public void enterJournalLines(List<String> lines, int i) {
		log.info("Enter journal lines");

		if (BaseTest.browser.contains("internetexplorer")) {

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input")).sendKeys(lines.get(0));// Account
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/input")).sendKeys(lines.get(1));// Cost
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]")).click();
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]/input")).sendKeys(lines.get(2));// Base
			// Value
			WaitHelper.waitAdditional(1.5);

			clickOnUpdate();
			clickOnAcceptWarnings();
			clickOnUpdate();

		} else {

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input")).sendKeys(lines.get(0));// Account
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/input")).sendKeys(lines.get(1));// Cost
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]")).click();
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]")).click();
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[8]/input")).sendKeys(lines.get(2));// Base
			// Value
			WaitHelper.waitAdditional(1.5);

			clickOnUpdate();
			clickOnAcceptWarnings();
			clickOnUpdate();

		}

	}

	/**
	 * EJJ Structure Enquiry
	 * 
	 * @param group
	 */
	public void structureEnquiry(List<String> cat) {
		log.info("Inside Structure Enquiry Method");

		getDriver().findElement(By.xpath(pObject.A026_LAYT)).clear();
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).sendKeys(cat.get(0));// Layout

		getDriver().findElement(By.xpath(pObject.A027_STRUC)).clear();
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).sendKeys(cat.get(1));// Structure

		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(cat.get(2));// Element

		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(cat.get(4));// Group

		getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(cat.get(5));// Enter
																					// Category

		getDriver().findElement(By.xpath(pObject.A040_SELE1_OK)).click();// Ok
																			// button
		WaitHelper.waitAdditional(4);

	}

	/**
	 * EJJ Verify Structure Enquiry Values
	 * 
	 * @param elements
	 */

	public boolean verifyStrEnqValues(List<String> elements, int i) {
		log.info("Inside Verify Structure Enquiry Vaues Method");
		boolean verify = false;
		WaitHelper.waitAdditional(2);

		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[1]")).getText()
				.equals(elements.get(0));// Cost
		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).getText()
				.equals(elements.get(1));// CP Act Bal
		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).getText()
				.equals(elements.get(2));// YTd Act Bal
		WaitHelper.waitAdditional(1);
		return verify;

	}

	/**
	 * Verify balance sheet details
	 * 
	 * @param group
	 */
	public void verifyBalanceSheetDetail(List<String> group) {
		log.info("Verify balance sheet details");

		getDriver().findElement(By.xpath(pObject.A026_LAYT)).clear();
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).sendKeys(group.get(0));// Layout

		clickOnEXTSections(); // Click on sections

		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(group.get(1));// Group

		getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(group.get(2));// Category

		getDriver().findElement(By.xpath(pObject.A039_EXT_OK)).click();// Ok
																		// button
		WaitHelper.waitAdditional(4);
	}

	public void clickOnDrillDown() {
		log.info("Click on DrillDown button");

		List<WebElement> wbs = getAlllButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Drill Down")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Navigate to account details page
	 * 
	 * @param account
	 */
	public void navigateToAccountDetailPage() {
		log.info("Navigate to AccountDetailPage");
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[2]")).click();
		WaitHelper.waitAdditional(1);

		clickOnDrillDown();
		WaitHelper.waitAdditional(3);

	}

	public void getAccountDetailValues(List<String> Accs) {
		log.info("Verify account detail values");
		WaitHelper.waitAdditional(3);

		WebElement account1 = driver.findElement(By.xpath(pObject.A040_SELE_SEC));
		driver.executeScript("scroll(0,850);", account1);
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A040_SELE_ACCO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_SELE_ACCO)).sendKeys(Accs.get(0));// Account
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A040_SELE_OK)).click();
		WaitHelper.waitAdditional(2);

	}

	/**
	 * Search for the account & cost details page
	 * 
	 * @param Acc
	 */

	public void getTranDetailValues(List<String> Transc) {
		log.info("Verify account detail values");
		WaitHelper.waitAdditional(3);

		WebElement account1 = driver.findElement(By.xpath(pObject.A040_SELE_SEC));
		driver.executeScript("scroll(0,850);", account1);
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A040_SELE_ACCO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_SELE_ACCO)).sendKeys(Transc.get(0));// Account

		getDriver().findElement(By.xpath(pObject.A040_SELE_COST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_SELE_COST)).sendKeys(Transc.get(1));// Cost
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_SELE_OK)).click();
		WaitHelper.waitAdditional(2);
	}

	// public boolean VerifyAccountValue(String value) {
	// WaitHelper.waitAdditional(2);
	// log.info("Verify presence of Message in the ToolBar Message list");
	// boolean MessageValue = false;
	// List<WebElement> wbs =
	// getDriver().findElements(By.xpath(pObject.AllPG_MSG_TOOLBAR));
	// for (WebElement wb : wbs) {
	// if (wb.getText().contains(value)) {
	// MessageValue = true;
	// break;
	// }
	// }
	// return MessageValue;
	// }
	//

	/**
	 * EJI Verify Account Details Enquiry Values
	 * 
	 * @param elements
	 */

	public boolean verifyTranscValues(List<String> elements, int i) {
		log.info("Inside Verify Structure Enquiry Vaues Method");
		boolean verify = false;
		WaitHelper.waitAdditional(2);

		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).getText()
				.equals(elements.get(0));// Account
		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).getText()
				.equals(elements.get(1));// Cost
		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[9]")).getText()
				.equals(elements.get(2));// Financial Values
		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[13]")).getText()
				.equals(elements.get(3));// Reference
		WaitHelper.waitAdditional(1);
		return verify;

	}

	/**
	 * Navigate to Cost details page Created By Chetna dt:
	 */
	public void navigateToCostDetailPage() {

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]")).click();
		WaitHelper.waitAdditional(1);

		clickOnDrillDown();
		WaitHelper.waitAdditional(3);

	}

	/**
	 * EJB/EJE Verify Transaction Details Values
	 * 
	 * @param elements
	 */

	public boolean verifyAccValues(List<String> elements, int i) {
		log.info("Inside Verify Structure Enquiry Vaues Method");
		boolean verify = false;
		WaitHelper.waitAdditional(2);

		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[1]")).getText()
				.equals(elements.get(0));// Account
		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).getText()
				.equals(elements.get(1));// YTd Act Bal
		verify = getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).getText()
				.equals(elements.get(2));// STAT BAL
		WaitHelper.waitAdditional(1);
		return verify;

	}

	public void searchAccount(String account) {
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id("0_1_0")).sendKeys(account);
		getDriver().findElement(By.id("0_1_0")).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Search management code
	 * 
	 * @param element
	 * @param i
	 */
	public void searchManagementCode(String element, int i) {
		log.info("Search management code");
		WaitHelper.waitAdditional(2);

		if (!ClickOnAnyButton("OK", 0)) {

			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY)).clear();// A029_PATH_KEY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY)).sendKeys(element);// A029_PATH_KEY
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY)).sendKeys(Keys.ENTER);// A029_PATH_KEY
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Create management link
	 * 
	 * @param element
	 */
	public void createManagementLink(String element) {
		log.info("Create management link");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A032A_NEW_PAR)).clear();
		getDriver().findElement(By.xpath(pObject.A032A_NEW_PAR)).sendKeys(element);// New
																					// Parent
		WaitHelper.waitAdditional(4);
		getDriver().findElement(By.xpath(pObject.A032A_NEW_PAR)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(4);
	}

	/**
	 * Search value
	 * 
	 * @param ValueList
	 * @param i
	 *            = button
	 * @param j
	 *            = fields
	 */
	public void searchEement(String companyName, int i) {
		log.info("Search elemnt");
		if (!isOkButtonDisplayed(i)) {
			clickOnSections(0);
		}

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(companyName.subSequence(0, 1));
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(companyName.subSequence(1, 2));

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
		;

	}

	/**
	 * Start and stop dispatcher
	 * 
	 * @throws InterruptedException
	 */

	public void startAndStopDispatcher() {
		log.info("Amend transaction legend details");

		WaitHelper.waitAdditional(2);

		for (int i = 1; i <= 5; i++) {
			String Desp = getDriver().findElement(By.xpath(
					"//div[text()='Region']/../../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[1]"))
					.getText();

			String DespStatus = getDriver().findElement(By.xpath(
					"//div[text()='Region']/../../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[2]"))
					.getText();

			getDriver().findElement(By.xpath(
					"//div[text()='Region']/../../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[1]"))
					.click();

			if (!(Desp.equals("Null")) && ((DespStatus.equals("Active")))) {

				clickOnStop();

				isStopConfirmPopUpDisplayed();

				clickOnRefresh();

				getDriver().findElement(By.xpath(
						"//div[text()='Region']/../../../../../../../../../../..//div[" + i + "]/table/tbody/tr/td[1]"))
						.click();

				clickOnForce();

				isForceConfirmPopUpDisplayed();

				clickOnRefresh();
			} else if (!(Desp.equals("Null")) && ((DespStatus.equals("Inactive")))) {

				clickOnForce();

				isForceConfirmPopUpDisplayed();

				clickOnRefresh();

			}
		}

	}

	/**
	 * Click on Stop button
	 */

	/**
	 * Click on clickOnStart button
	 * 
	 * @param i
	 */
	public void clickOnStart() {
		log.info("Click on Start Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Start")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on clickOnStop Button
	 * 
	 * @param i
	 */
	public void clickOnStop() {
		log.info("Click on Stop Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Stop")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on clickOnForce button
	 * 
	 * @param i
	 */
	public void clickOnForce() {
		log.info("Click on Force Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Force")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Verify presence of Start confirmation window for Executor and Dispatcher
	 * 
	 * @return true/false
	 */
	public void isStartConfirmPopUpDisplayed()

	{
		log.info("Verify Start confirmation pop up");
		WaitHelper.waitAdditional(3);
		try {
			if (getDriver().findElement(By.xpath(pObject.A035_START_CONFIRM)).isDisplayed())

			{
				getDriver().findElement(By.xpath(pObject.A035_START_CONFIRM)).click();
			}
		} catch (NoSuchElementException e) {

		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Verify presence of Stop confirmation window for Executor and Dispatcher
	 * 
	 * @return true/false
	 */
	public void isStopConfirmPopUpDisplayed()

	{
		log.info("Verify Stop confirmation pop up");
		WaitHelper.waitAdditional(3);
		try {
			if (getDriver().findElement(By.xpath(pObject.A035_STOP_CONFIRM)).isDisplayed())

			{
				getDriver().findElement(By.xpath(pObject.A035_STOP_CONFIRM)).click();
			}
		} catch (NoSuchElementException e) {

		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Verify presence of Force Start confirmation window for Executor and
	 * Dispatcher
	 * 
	 * @return true/false
	 */
	public void isForceConfirmPopUpDisplayed()

	{
		log.info("Verify Force confirmation pop up");
		WaitHelper.waitAdditional(3);
		try {
			if (getDriver().findElement(By.xpath(pObject.A035_FORCE_CONFIRM)).isDisplayed())

			{
				getDriver().findElement(By.xpath(pObject.A035_FORCE_CONFIRM)).click();
			}
		} catch (NoSuchElementException e) {

		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Verify presence of Submit confirmation window for Structure Rebuild
	 * 
	 * @return true/false
	 */
	public void isSubmitConfirmPopUpDisplayed()

	{
		log.info("Verify Submit confirmation window for Structure Rebuild");
		WaitHelper.waitAdditional(3);
		try {
			if (getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).isDisplayed())

			{
				getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).click();
			}
		} catch (NoSuchElementException e) {

		}
		WaitHelper.waitAdditional(3);
	}

	/*--------------------------------PHASE II METHODS----------------------------------------------------------------*/

	/**
	 * Create tax type - A043
	 * 
	 * @param taxList
	 */

	public boolean createTaxType(List<String> taxList) {
		log.info("In Tax code type method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A043_TX_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A043_TX_TYPE)).sendKeys(taxList.get(0));// Type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A043_TX_TYPE)).sendKeys(Keys.ENTER);// Type
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(taxList.get(1));// Desc
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A043_TOLRN_PERC)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A043_TOLRN_PERC)).sendKeys(taxList.get(2));// Percentage
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A043_TOLRN_AMT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A043_TOLRN_AMT)).sendKeys(taxList.get(3));// Amount
			if (taxList.get(4).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A043_CHK_TX_RATE_EXP)).click();// Tax
																						// rate
																						// chk
			}
			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}

	/**
	 * Create Tax Location - A043
	 * 
	 * @param taxList
	 */

	public boolean createLocation(List<String> location) {
		log.info("In Tax Code Location Method");

		boolean update = false;
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A043_LOC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A043_LOC)).sendKeys(location.get(0));// location
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A043_LOC)).sendKeys(Keys.ENTER);// location
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(location.get(1));// Desc
			WaitHelper.waitAdditional(1);

			if (location.get(2).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A043_CHK_ECSTATE)).click();// EC
																					// State
																					// chk
			}

			ClickOnAnyTab("Address", 1);

			getDriver().findElement(By.xpath(pObject.A006_ADDR1)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A006_ADDR1)).sendKeys(location.get(3));// ADDR1
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A006_ADDR2)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A006_ADDR2)).sendKeys(location.get(4));// ADDR2

			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}

	/**
	 * Create Locations for Tax code created - A043
	 * 
	 * @param elments
	 */

	public boolean createTaxCodeLocation(List<String> elements) {
		log.info("In Tax code creation method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A043_CODE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A043_CODE)).sendKeys(elements.get(0));// Code
																						// A043_CODE

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A043_CODE)).sendKeys(Keys.ENTER);// Code
																					// A043_CODE

		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {

			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Desc
																									// A002_DESCRIPTION
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A043_LOC)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A043_LOC)).sendKeys(elements.get(2));// Location
																							// A043_LOC
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A043_TX_TYPE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A043_TX_TYPE)).sendKeys(elements.get(3));// Type
																								// A043_TX_TYPE
			WaitHelper.waitAdditional(1);
			update = true;
		}
		return update;
	}

	/**
	 * Create Tax Rate - A044
	 * 
	 * @param elments
	 */

	public boolean createTaxRate(List<String> elements) {
		log.info("In Tax rate  method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A043_CODE)).clear();
		getDriver().findElement(By.xpath(pObject.A043_CODE)).sendKeys(elements.get(0));// Code
																						// A043_CODE
		getDriver().findElement(By.xpath(pObject.A043_CODE)).sendKeys(Keys.ENTER);// Code
																					// A043_CODE

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A044_EFF_DATE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A044_EFF_DATE)).sendKeys(elements.get(1));// Date
																							// A044_EFF_DATE

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A044_TOT_RATE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A044_TOT_RATE)).sendKeys(elements.get(4));// Tax
																							// rate
																							// A044_TOT_RATE
		clickOnUpdate();

		if (!getToolContentText().contains(message)) {
			update = true;
		}
		return update;
	}

	/**
	 * BACS Calendar - A045
	 * 
	 * @param elements
	 */
	public void enterCalendarDetails(List<String> elements) {
		log.info("In Enter calendar method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A045_CAL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_CAL)).sendKeys(elements.get(0));// Calendar
																						// A045_CAL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
		WaitHelper.waitAdditional(1);

		if (elements.get(5).equals("BACS")) {
			getDriver().findElement(By.xpath(pObject.A045_RAD_BACS)).click();// Type
																				// A045_RAD_BACS
			WaitHelper.waitAdditional(1);
		} else if (elements.get(5).equals("Other")) {
			getDriver().findElement(By.xpath(pObject.A045_RAD_OTH)).click();// Type
																			// A045_RAD_OTH
			WaitHelper.waitAdditional(1);
		}

		getDriver().findElement(By.xpath(pObject.A045_WK_DAY)).sendKeys(elements.get(2));// Week
																							// end
																							// day
																							// A045_WK_DAY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_CHK_SHOW_WK_END)).click(); // A045_CHK_SHOW_WK_END
		WaitHelper.waitAdditional(3);
		clickOnYearsH();
		WaitHelper.waitAdditional(5);
		getDriver().findElement(By.xpath(pObject.A045_YEAR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_YEAR)).sendKeys(elements.get(3));// Year
																						// A045_YEAR
		WaitHelper.waitAdditional(2);
	}

	/**
	 * BACS Calendar - A045
	 * 
	 * @param elements
	 */
	public void runActivityForCalendar(List<String> elements) {
		log.info("In calendar run activity method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A045_CAL)).clear();// A045_CAL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_CAL)).sendKeys(elements.get(0));// Calendar
																						// to
																						// populate
																						// A045_CAL

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_ACT)).clear();// A045_ACT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_ACT)).sendKeys(elements.get(4));// Activity
																						// to
																						// use
																						// A045_ACT

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_FRM_YR)).clear(); // A045_FRM_YR
		// WaitHelper.waitAdditional(1);
		// getDriver().findElement(By.xpath(pObject.A045_FRM_YR)).sendKeys(elements.get(6));//From
		// Year A045_FRM_YR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_FRM_YR)).sendKeys(String.valueOf(calender.fromyear()));// From
																												// Year
																												// A045_FRM_YR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_TO_YR)).clear();// A045_TO_YR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A045_TO_YR)).sendKeys(String.valueOf(calender.Toyear()));// To
																											// Year
																											// A045_TO_YR
		WaitHelper.waitAdditional(2);

		// WaitHelper.waitAdditional(1);
		// getDriver().findElement(By.xpath(pObject.A045_TO_YR)).sendKeys(elements.get(7));//To
		// Year A045_TO_YR
		// WaitHelper.waitAdditional(2);

	}

	/**
	 * Create bank sort code - A046
	 * 
	 * @param elements
	 */
	public boolean bankSortCode(List<String> elements) {
		log.info("In Bank sort code  method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A046_CNTRY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A046_CNTRY)).sendKeys(elements.get(0));// Country
																						// A046_CNTRY

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A046_SRTCODE)).clear();// A046_SRTCODE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A046_SRTCODE)).sendKeys(elements.get(1));// Sort
																							// code
																							// A046_SRTCODE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A046_SRTCODE)).sendKeys(Keys.ENTER);// Sort
																						// code
																						// A046_SRTCODE
		WaitHelper.waitAdditional(2);
		if (!getToolContentText().contains(message)) {

			getDriver().findElement(By.xpath(pObject.A046_BANK_NAME)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A046_BANK_NAME)).sendKeys(elements.get(2));// Bank
																								// name
																								// A046_BANK_NAME
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A046_ADDRES1)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A046_ADDRES1)).sendKeys(elements.get(3));// Ad
																								// L1
																								// A046_ADDRES1

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A046_ADDRES2)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A046_ADDRES2)).sendKeys(elements.get(4));// Ad
																								// L2
																								// A046_ADDRES2
			WaitHelper.waitAdditional(1);

			if (!elements.get(5).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A046_ADDRES3)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A046_ADDRES3)).sendKeys(elements.get(5));// Ad
																									// L2
																									// A046_ADDRES3
				WaitHelper.waitAdditional(1);
			}
			WaitHelper.waitAdditional(1);
			if (!elements.get(6).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A046_PSTCD)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A046_PSTCD)).sendKeys(elements.get(6));// Postal
																								// code
																								// A046_PSTCD
				WaitHelper.waitAdditional(1);
			}
			update = true;
		}
		return update;
	}

	/**
	 * Create UOM - A048
	 * 
	 * @param elements
	 */

	public boolean enterUomDetails(List<String> elements) {
		log.info("In Uom Details  method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A048_UOM_CODE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A048_UOM_CODE)).sendKeys(elements.get(0));// UOM
																							// Code
																							// A048_UOM_CODE
		getDriver().findElement(By.xpath(pObject.A048_UOM_CODE)).sendKeys(Keys.ENTER);// UOM
																						// Code
																						// A048_UOM_CODE
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// UOM
																									// Description
																									// A002_DESCRIPTION
			WaitHelper.waitAdditional(1);

			if (elements.get(2).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A048_CHK_SUBD)).click();// Sub-Division
																					// A048_CHK_SUBD
			}
			update = true;
		}

		return update;
	}

	/**
	 * Create UOM Relationship - A048
	 * 
	 * @param elements
	 */

	public boolean enterUOMRelationShip(List<String> elements) {
		log.info("In Uom Relationship Details  method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A048_BASE_UOM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A048_BASE_UOM)).sendKeys(elements.get(0));// Base
																							// UOM
																							// Code
																							// A048_BASE_UOM

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A048_UOM_NBASE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A048_UOM_NBASE)).sendKeys(elements.get(1));// Non
																							// Base
																							// UOM
																							// Code
																							// A048_UOM_NBASE
		getDriver().findElement(By.xpath(pObject.A048_UOM_NBASE)).sendKeys(Keys.ENTER);// Non
																						// Base
																						// UOM
																						// Code

		WaitHelper.waitAdditional(1);
		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A048_NBASE_BASE_FACT)).clear();//
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A048_NBASE_BASE_FACT)).sendKeys(elements.get(2));// Non-Base
																										// to
																										// Base
																										// Factor
			getDriver().findElement(By.xpath(pObject.A048_NBASE_BASE_FACT)).sendKeys(Keys.ENTER);// Non-Base
																									// to
																									// Base
																									// Factor
			WaitHelper.waitAdditional(1);

			// getDriver().findElement(By.xpath(pObject.A048_BASE_NBASE_FACT)).clear();//
			// WaitHelper.waitAdditional(1);
			// getDriver().findElement(By.xpath(pObject.A048_BASE_NBASE_FACT)).sendKeys(elements.get(3));//Base
			// to Non-Base to Factor

			update = true;
		}
		return update;
	}

	/**
	 * Enter Purchasing company control details - A049
	 * 
	 * @param elements
	 */

	public void enterPurchasingCompanyControlDetails(String companyName, List<String> elements) {
		log.info("Enter purchasing company control details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();// Company
																		// A006_COMPANY
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);// Company
																						// A006_COMPANY

		// GL - Numbering
		getDriver().findElement(By.xpath(pObject.A049_EXCH_RATE_TYPE)).clear();// A049_EXCH_RATE_TYPE
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A049_EXCH_RATE_TYPE)).sendKeys(elements.get(0));// Foreign
																									// exchangerate
																									// A049_EXCH_RATE_TYPE

		getDriver().findElement(By.xpath(pObject.A049_GL_HOld_CMPY)).clear();// A049_GL_HOld_CMPY
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A049_GL_HOld_CMPY)).sendKeys(companyName);// GL
																							// Holding
																							// company
																							// A049_GL_HOld_CMPY
		WaitHelper.waitAdditional(2);

		if (elements.get(1).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A049_RAD_NOR)).click();// GL
																			// Relationship
																			// indicator
																			// A049_RAD_NOR
		}
		WaitHelper.waitAdditional(1);

		// Click On Miscellaneous/ERS

		ClickOnAnyTab("Miscellaneous/ERS", 1);
		// getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.FIFTH_TAB)).click();
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A049_DD_UOM)).clear();// A049_DD_UOM
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A049_DD_UOM)).sendKeys(elements.get(2));// Days
																							// UOM
																							// A049_DD_UOM

		getDriver().findElement(By.xpath(pObject.A049_WRK_DAYS_CLNDR)).clear(); // A049_WRK_DAYS_CLNDR
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A049_WRK_DAYS_CLNDR)).sendKeys(elements.get(3));// Working
																									// days
																									// calender
																									// A049_WRK_DAYS_CLNDR
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A049_CHK_KEYWD_INUSE)).click();// Keyword
																				// in
																				// use
																				// A049_CHK_KEYWD_INUSE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A049_CHK_NSV_INUSE)).click();// NSV
																				// in
																				// use
																				// A049_CHK_NSV_INUSE
		WaitHelper.waitAdditional(1);

		// Click on Supplier tab
		// getDriver().findElement(By.xpath(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();

		ClickOnAnyTab("Supplier", 1);

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A049_RAD_SUPP_PST_ALLSUP)).click();// Supplier
																					// Postcode
																					// Enquiry
																					// -
																					// All
																					// supplier
																					// types
																					// A049_RAD_SUPP_PST_ALLSUP

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A049_RAD_PM_ADDR_NNOT)).click();// PM
																					// Multiple
																					// Supplier
																					// Address
																					// notification

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A049_RAD_AP_ADDR_NNOT)).click();// AP
																					// Multiple
																					// Supplier
																					// Address
																					// notification

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A049_RAD_DUP_PST_NR)).click();// Duplicate
																				// Postcode
																				// Validation
																				// -
																				// Nor-req
																				// A049_RAD_DUP_PST_NR

	}

	/**
	 * Amend batch details A051A
	 */
	public void editBatchTypes() {
		log.info("Inside batch type edit method");
		WaitHelper.waitAdditional(2);
		clickOnRefresh();
		WaitHelper.waitAdditional(2);

		ClickOnAnyTab("Controls", 1);
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A051_CHK_SUMM_TRANSC)).click();// Reconciliation
																				// required
																				// A051_CHK_SUMM_TRANSC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_CHK_AVG_BAL)).click();// Bank
																			// account
																			// A051_CHK_AVG_BAL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_CHK_RECO_REQ)).click();// Reconciliation
																				// required
																				// A051_CHK_RECO_REQ
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_CHK_BANK_ACC)).click();// Bank
																				// account
																				// A051_CHK_BANK_ACC

	}

	/**
	 * Enter Account payable control details -AO50
	 * 
	 * @param elements
	 */

	public void enterAccountPayableControlDetails(List<String> elements) {
		log.info("Enter account payable control details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A050_CNTL_AC_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_CNTL_AC_CD)).sendKeys(elements.get(0));// Control
																								// account
																								// Code
																								// A050_CNTL_AC_CD

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_CRE_CONT_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_CRE_CONT_ACC)).sendKeys(elements.get(2));// Creditors
																								// control
																								// Account
																								// A050_CRE_CONT_ACC

		getDriver().findElement(By.xpath(pObject.A050_CRE_CONT_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_CRE_CONT_CST)).sendKeys(elements.get(3));// Creditors
																								// control
																								// Cost
																								// A050_CRE_CONT_CST

		getDriver().findElement(By.xpath(pObject.A050_DIS_RECE_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_DIS_RECE_ACC)).sendKeys(elements.get(4));// Discount
																								// receivable
																								// Account
																								// A050_DIS_RECE_ACC

		getDriver().findElement(By.xpath(pObject.A050_DIS_RECE_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_DIS_RECE_CST)).sendKeys(elements.get(5));// Discount
																								// receivable
																								// Cost
																								// A050_DIS_RECE_CST

		getDriver().findElement(By.xpath(pObject.A050_BNK_CHG_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_BNK_CHG_ACC)).sendKeys(elements.get(6));// Bank
																								// charges
																								// Account
																								// A050_BNK_CHG_ACC

		getDriver().findElement(By.xpath(pObject.A050_BNK_CHG_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_BNK_CHG_CST)).sendKeys(elements.get(7));// Bank
																								// charges
																								// Cost
																								// A050_BNK_CHG_CST

		getDriver().findElement(By.xpath(pObject.A050_PREPAY_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_PREPAY_ACC)).sendKeys(elements.get(8));// Pre-payments
																								// Account
																								// A050_PREPAY_ACC

		getDriver().findElement(By.xpath(pObject.A050_PREPAY_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_PREPAY_CST)).sendKeys(elements.get(9));// Pre-payments
																								// Cost
																								// A050_PREPAY_CST

		getDriver().findElement(By.xpath(pObject.A050_DET_VAR_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_DET_VAR_ACC)).sendKeys(elements.get(10));// Detail
																								// variance
																								// Account
																								// A050_DET_VAR_ACC

		getDriver().findElement(By.xpath(pObject.A050_DET_VAR_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_DET_VAR_CST)).sendKeys(elements.get(11));// Detail
																								// variance
																								// Cost
																								// A050_DET_VAR_CST

		getDriver().findElement(By.xpath(pObject.A050_TRD_CUR_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_TRD_CUR_ACC)).sendKeys(elements.get(12));// Detail
																								// variance
																								// Cost
																								// A050_TRD_CUR_ACC

		getDriver().findElement(By.xpath(pObject.A050_TRD_CUR_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_TRD_CUR_CST)).sendKeys(elements.get(13));// Detail
																								// variance
																								// Cost
																								// A050_TRD_CUR_CST

		getDriver().findElement(By.xpath(pObject.A050_SRV_ACCR_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_SRV_ACCR_ACC)).sendKeys(elements.get(14));// Service
																								// ledger
																								// accurals
																								// Account
																								// A050_SRV_ACCR_ACC

		getDriver().findElement(By.xpath(pObject.A050_SRV_ACCR_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_SRV_ACCR_CST)).sendKeys(elements.get(15));// Service
																								// ledger
																								// accurals
																								// Cost
																								// A050_SRV_ACCR_CST

		getDriver().findElement(By.xpath(pObject.A050_SRV_DEFE_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_SRV_DEFE_ACC)).sendKeys(elements.get(16));// Service
																								// ledger
																								// deferrals
																								// Account
																								// A050_SRV_DEFE_ACC
		getDriver().findElement(By.xpath(pObject.A050_SRV_DEFE_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_SRV_DEFE_CST)).sendKeys(elements.get(17));// Service
																								// ledger
																								// deferrals
																								// Account
																								// A050_SRV_DEFE_CST

		getDriver().findElement(By.xpath(pObject.A050_AP_AR_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_AP_AR_ACC)).sendKeys(elements.get(18));// Service
																								// ledger
																								// deferrals
																								// Cost
																								// A050_AP_AR_ACC

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_AP_AR_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_AP_AR_CST)).sendKeys(elements.get(19));// Service
																								// ledger
																								// deferrals
																								// Cost
																								// A050_AP_AR_CST
		WaitHelper.waitAdditional(1);

		// Control accounts tab2

		ClickOnAnyTab("Control Accounts - 2", 1);

		// getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A050_TAX_SUP_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_TAX_SUP_ACC)).sendKeys(elements.get(20));// Tax
																								// suspense
																								// Account
																								// A050_TAX_SUP_ACC

		getDriver().findElement(By.xpath(pObject.A050_TAX_SUP_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_TAX_SUP_CST)).sendKeys(elements.get(21));// Tax
																								// suspense
																								// Cost
																								// A050_TAX_SUP_CST

		getDriver().findElement(By.xpath(pObject.A050_TAX_VAR_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_TAX_VAR_ACC)).sendKeys(elements.get(22));// Tax
																								// suspense
																								// Account
																								// A050_TAX_VAR_ACC

		getDriver().findElement(By.xpath(pObject.A050_TAX_VAR_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_TAX_VAR_CST)).sendKeys(elements.get(23));// Tax
																								// suspense
																								// Cost
																								// A050_TAX_VAR_CST

		getDriver().findElement(By.xpath(pObject.A050_SLF_ASS_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_SLF_ASS_ACC)).sendKeys(elements.get(24));// Tax
																								// suspense
																								// Account
																								// A050_SLF_ASS_ACC

		getDriver().findElement(By.xpath(pObject.A050_SLF_ASS_CST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A050_SLF_ASS_CST)).sendKeys(elements.get(25));// Tax
																								// suspense
																								// Cost
																								// A050_SLF_ASS_CST
		WaitHelper.waitAdditional(1);

	}

	/**
	 * Create BR company - A051A
	 * 
	 * @param elements
	 */
	public void createBRCompanyControl(String companyName, List<String> elements) {
		log.info("Create BR company control");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);// Company

		getDriver().findElement(By.xpath(pObject.A051_BMK_STMT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_BMK_STMT)).sendKeys(elements.get(0));// Bank
																							// stmt
																							// A051_BMK_STMT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_ADJMT_BAL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_ADJMT_BAL)).sendKeys(elements.get(1));// Bank
																							// adj
																							// A051_ADJMT_BAL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_STMNT_BTCH_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_STMNT_BTCH_TYPE)).sendKeys(elements.get(2));// Bank
																									// stmt
																									// A051_STMNT_BTCH_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_ADJMT_BTCH_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_ADJMT_BTCH_TYPE)).sendKeys(elements.get(3));// Bank
																									// adj
																									// A051_ADJMT_BTCH_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_GL_AD_BTCH_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_GL_AD_BTCH_TYPE)).sendKeys(elements.get(4));// GL
																									// adj
																									// A051_GL_AD_BTCH_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_RAD_ORG_DT)).click();// Origional
																			// date
																			// A051_RAD_ORG_DT
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A051_CHQ_VAD_FOR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_CHQ_VAD_FOR)).sendKeys(elements.get(5));// cheques
																								// A051_CHQ_VAD_FOR

	}

	/**
	 * Create BR Bank code - A051
	 * 
	 * @param elements
	 */
	public boolean enterBRBankCodeList(List<String> elements) {
		log.info("Enter BR bank code list");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(elements.get(0));// Bank
																								// code
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);
		if (!getToolContentText().contains(message)) {

			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(elements.get(1));// Description
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO)).sendKeys(elements.get(2));// Closing
																									// Balance
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(elements.get(3));// Statement
																									// Date
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).sendKeys(elements.get(4));// Bank
																									// sort
																									// code
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.SIX)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.SIX)).sendKeys(elements.get(5));// Account
																									// number
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.EIGHT + pObject._ZERO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.EIGHT + pObject._ZERO)).sendKeys(elements.get(6));// GL
																													// -
																													// Account
																													// Account
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.EIGHT + pObject._FIRST)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.EIGHT + pObject._FIRST)).sendKeys(elements.get(7));// GL
																														// -
																														// Account
																														// Cost
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.NINE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.NINE)).sendKeys(elements.get(8));// BTZ
																									// Element
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE + pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE + pObject.ONE)).sendKeys(elements.get(9));// Currency

			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.TAB_STRIP + pObject.SECOND_TAB)).click();// Currency
																							// tab
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE + pObject.SIX)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE + pObject.SIX)).sendKeys(elements.get(10));// User
			getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE + pObject.SIX)).sendKeys(Keys.ENTER);// User
			update = true;
		}

		return update;
	}

	/**
	 * Enter Tax account details - A052
	 * 
	 * @param elements
	 * @param elements1
	 * @param elements2
	 * @param elements3
	 */
	public void enterTaxAccountDetails(List<String> elements, List<String> elements1, List<String> elements2,
			List<String> elements3) {
		log.info("Enter tax account details");
		enterTaxAccountByCode(elements, 1);
		enterTaxAccountByCode(elements1, 2);
		enterTaxAccountByCode(elements2, 3);
		enterTaxAccountByCode(elements3, 4);
	}

	private void enterTaxAccountByCode(List<String> elements, int i) {
		log.info("Enter tax account details");
		WaitHelper.waitAdditional(3);

		if (BaseTest.browser.contains("internetexplorer")) {

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();//
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();//
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(0));//
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();//
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();//
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(1));//
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();//
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();//
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(2));//
			WaitHelper.waitAdditional(1.5);

		}

		else {

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();//
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(0));//
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();//
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(1));//
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]")).click();//
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(2));//
			WaitHelper.waitAdditional(1.5);
		}
	}

	/**
	 * Enter Category code details - A053
	 * 
	 * @param elements
	 */

	public void enterCategoryCodeDetails(List<String> elements) {
		log.info("Enter category code details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(elements.get(0));// Category
																						// A017_CATEG

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION

		getDriver().findElement(By.xpath(pObject.A053_HLD_DAY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A053_HLD_DAY)).sendKeys(elements.get(2));// Hold
																							// days
																							// A053_HLD_DAY
		WaitHelper.waitAdditional(2);

		if (elements.get(3).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A053_CHK_AUTO_SUPP_CLER)).click();// Auto
																						// supplier
																						// Cleardown
																						// A053_CHK_AUTO_SUPP_CLER
		}
	}

	/**
	 * Enter Discount terms - A054
	 * 
	 * @param elements
	 */

	public void enterDiscountTerms(List<String> elements) {
		log.info("Enter discount terms");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A054_DSCNT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A054_DSCNT)).sendKeys(elements.get(0));// Discount
																						// term
																						// A054_DSCNT

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
		WaitHelper.waitAdditional(2);

		if (elements.get(2).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A054_RAD_PER_D)).click();// Period
																				// details
																				// A054_RAD_PER_D
		}
		getDriver().findElement(By.xpath(pObject.A054_NUM_DD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A054_NUM_DD)).sendKeys(elements.get(3));// No.of
																							// days
																							// A054_NUM_DD

		getDriver().findElement(By.xpath(pObject.A054_RATE_PERC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A054_RATE_PERC)).sendKeys(elements.get(4));// Rate
																							// %
																							// A054_RATE_PERC
		WaitHelper.waitAdditional(2);

		if (elements.get(5).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A054_RAD_SRTP_INVDT)).click();// Invoice
																					// date
																					// A054_RAD_SRTP_INVDT

		}
	}

	/**
	 * Enter Settlement Terms - A055
	 * 
	 * @param elements
	 */

	public boolean enterSettlementTerms(List<String> elements) {
		log.info("Inside settlement terms method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).clear(); // A055_SETT_TERM
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).sendKeys(elements.get(0));// Settlement
																							// terms
																							// A055_SETT_TERM
		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).sendKeys(Keys.ENTER);// Settlement
																						// terms
																						// A055_SETT_TERM
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																									// A002_DESCRIPTION

			WaitHelper.waitAdditional(1);
			if (elements.get(2).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A054_RAD_PER_D)).click();// Monthly
																					// A054_RAD_PER_D
			}

			WaitHelper.waitAdditional(1);
			if (elements.get(3).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A055_RAD_PERD_M)).click();// Monthly
																					// A055_RAD_PERD_M
			}
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A055_FROM_DD)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A055_FROM_DD)).sendKeys(elements.get(4));// Daily
																								// A055_FROM_DD

			getDriver().findElement(By.xpath(pObject.A055_TO_DD)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A055_TO_DD)).sendKeys(elements.get(5));// Monthly
																							// A055_TO_DD
			WaitHelper.waitAdditional(1);

			if (!elements.get(6).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A055_MONTH)).clear(); // A055_MONTH
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A055_MONTH)).sendKeys(elements.get(6));// Month
																								// A055_MONTH
			}
			if (!elements.get(7).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A055_DAYS)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A055_DAYS)).sendKeys(elements.get(7));// Days
																								// A055_DAYS
			}
			if (!elements.get(8).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A055_DATE)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A055_DATE)).sendKeys(elements.get(8));// Date
																								// A055_DATE
			}
			WaitHelper.waitAdditional(1);
			if (elements.get(9).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A055_RAD_STRT_PER)).click();// Period
																						// A055_RAD_STRT_PER
			}

			WaitHelper.waitAdditional(1);
			if (elements.get(9).equals("0")) {
				getDriver().findElement(By.xpath(pObject.A055_RAD_STRT_INV)).click();// Period
																						// A055_RAD_STRT_INV
			}

			update = true;
		}
		return update;
	}

	/**
	 * Create bank account A051
	 * 
	 * @param elements
	 * @return
	 */

	public boolean createBankAccount(List<String> elements) {
		log.info("Create bank account");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A051_BNK_CODE)).clear();//
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_BNK_CODE)).sendKeys(elements.get(0));// Bank
																							// code
																							// A051_BNK_CODE
		getDriver().findElement(By.xpath(pObject.A051_BNK_CODE)).sendKeys(Keys.ENTER);// Bank
																						// code
																						// A051_BNK_CODE
		WaitHelper.waitAdditional(1);
		if (!getToolContentText().contains(message)) {
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A051_BNK_ACC_NU)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A051_BNK_ACC_NU)).sendKeys(elements.get(1));// Bank
																									// account
																									// no
																									// A051_BNK_ACC_NU
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(2));// Bank
																									// account
																									// desc
																									// A002_DESCRIPTION
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A018_CURR_CODE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A018_CURR_CODE)).sendKeys(elements.get(3));// Currency
																								// A018_CURR_CODE
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A051_SRT_CODE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A051_SRT_CODE)).sendKeys(elements.get(4));// Bank
																								// sort
																								// code
																								// A051_SRT_CODE
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A050_GL_BNK_ACC)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A050_GL_BNK_ACC)).sendKeys(elements.get(5));// Bank
																									// sort
																									// code
																									// A050_GL_BNK_ACC
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A050_GL_BNK_CST)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A050_GL_BNK_CST)).sendKeys(elements.get(6));// Bank
																									// sort
																									// code
																									// A050_GL_BNK_CST
			update = true;
		}
		return update;
	}

	/**
	 * AP Ledger Controls - A056-GAA
	 * 
	 * @param elements
	 */
	public void enterAccountPayableCompanyControl(String companyId, List<String> elements) {
		log.info("Enter account payable company control details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyId);// Company
																					// A006_COMPANY

		ClickOnAnyTab("Data Entry", 1);

		log.info("Enter Data Entry Tab Details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A056_TRANS_DUP)).sendKeys(elements.get(0));// Transaction
																							// Duplicate
																							// -
																							// A056_TRANS_DUP
																							// -Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_LOG_TRANS)).sendKeys(elements.get(1));// Log
																							// Transactions
																							// -A056_LOG_TRANS-
																							// Optional
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_POSTCD_ETRY)).sendKeys(elements.get(2));// Post
																								// code
																								// entry
																								// -
																								// A056_POSTCD_ETRY-Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CRDT_NT_DUE_DT)).sendKeys(elements.get(3));// Credit
																									// Note
																									// due
																									// date
																									// -A056_CRDT_NT_DUE_DT-
																									// Transaction
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CHK_TRNS_TTL_CORR)).click();// Transaction
																					// Totals
																					// Correction
																					// A056_CHK_TRNS_TTL_CORR
		WaitHelper.waitAdditional(1);

		log.info("Enter Batched Data Entry Section Details");

		getDriver().findElement(By.xpath(pObject.A056_CHK_BTCH_TOT_CORR)).click();// Batch
																					// Totals
																					// Correction
																					// A056_CHK_BTCH_TOT_CORR
		getDriver().findElement(By.xpath(pObject.A056_CHK_BTCH_TOT_NUM_TRAN)).click();// Batch
																						// Totals
																						// on
																						// Number
																						// of
																						// Transactions
																						// A056_CHK_BTCH_TOT_NUM_TRAN
		getDriver().findElement(By.xpath(pObject.A056_CHK_BTCH_TOT_OVER)).click();// Batch
																					// Totals
																					// Overrxpathe
																					// A056_CHK_BTCH_TOT_OVER
		getDriver().findElement(By.xpath(pObject.A056_CHK_BTCH_ON_ENT)).click();// Batch
																				// on
																				// Entry
																				// A056_CHK_BTCH_ON_ENT
		getDriver().findElement(By.xpath(pObject.A056_CHK_BTCH_ON_LOG)).click();// Batch
																				// on
																				// Logging
																				// A056_CHK_BTCH_ON_LOG
		getDriver().findElement(By.xpath(pObject.A056_CHK_BTCH_ON_EXP)).click();// Batch
																				// on
																				// Expense
																				// A056_CHK_BTCH_ON_EXP
		getDriver().findElement(By.xpath(pObject.A056_CHK_MNDTY_TRAN_DT)).click();// Mandatory
																					// Transaction
																					// Date
																					// A056_CHK_MNDTY_TRAN_DT

		log.info("Enter Currency Section Details");
		getDriver().findElement(By.xpath(pObject.A049_EXCH_RATE_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A049_EXCH_RATE_TYPE)).sendKeys(elements.get(4));// Foreign
																									// currency
																									// rate
																									// type
																									// A049_EXCH_RATE_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TOL_PROC)).sendKeys(elements.get(5));// A056_TOL_PROC-None
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CHK_CURR_TURN)).click();// Currency
																				// turnover
																				// mentioned
																				// A056_CHK_CURR_TURN

		log.info("Enter TAX Section Details");

		getDriver().findElement(By.xpath(pObject.A056_CHK_TX_DET_LVL)).click();// Tax
																				// at
																				// Detail
																				// Level
																				// A056_CHK_TX_DET_LVL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CHK_TX_PST_LOG)).click();// Tax
																				// Posting
																				// at
																				// logging
																				// A056_CHK_TX_PST_LOG
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CHK_TX_ON_EXP_AT_DL)).click();// Tax
																					// On
																					// Expenses
																					// at
																					// Detail
																					// Level
																					// A056_CHK_TX_ON_EXP_AT_DL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TAX_VRNC_CODE)).clear(); // A056_TAX_VRNC_CODE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TAX_VRNC_CODE)).sendKeys(elements.get(6));// Tax
																								// Variance
																								// Tax
																								// Code
																								// A056_TAX_VRNC_CODE
		WaitHelper.waitAdditional(1);

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A056_AP_AR_NETT_OFF)).sendKeys(elements.get(7));// Netting
																									// off
																									// allowed
																									// A056_AP_AR_NETT_OFF-Not
																									// Allowed

		ClickOnAnyTab("Authorisation/VAT", 1);
		WaitHelper.waitAdditional(2);
		log.info("Enter Authorisation/VAT Tab Details");
		getDriver().findElement(By.xpath(pObject.A056_CHK_USE_VAT_ANLS)).click();// A056_CHK_USE_VAT_ANLS
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_COD_IDNT)).clear(); // A056_COD_IDNT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_COD_IDNT)).sendKeys(elements.get(8));// A056_COD_IDNT
																							// -B
		WaitHelper.waitAdditional(1);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_PSTNG_TYPE)).sendKeys(elements.get(9));// Psoting
																								// Type
																								// -A056_PSTNG_TYPE-Cost
																								// Centre
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A056_DAYS_BFR_ARCHV)).clear();
		getDriver().findElement(By.xpath(pObject.A056_DAYS_BFR_ARCHV)).sendKeys(elements.get(10));// Number
																									// of
																									// Days
																									// Before
																									// Archiving-
																									// A056_DAYS_BFR_ARCHV
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Withholding", 1);
		log.info("Enter Withholding Tab Details");

		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A056_WITH_TYPE)).sendKeys(elements.get(11));// Withholding
																								// type
																								// -A056_WITH_TYPE-
																								// None

		getDriver().findElement(By.xpath(pObject.A056_TX_RATE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TX_RATE)).sendKeys(elements.get(12));// Tax
																							// Rate-A056_TX_RATE

		getDriver().findElement(By.xpath(pObject.A056_NTCOMP_TX_RATE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_NTCOMP_TX_RATE)).sendKeys(elements.get(13));// Non-compliant
																									// Tax
																									// Rate
																									// A056_NTCOMP_TX_RATE

		getDriver().findElement(By.xpath(pObject.A056_NUM_DAY_TX_PRMPT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_NUM_DAY_TX_PRMPT)).sendKeys(elements.get(14));// Number
																									// of
																									// days
																									// to
																									// Tax
																									// prompt
																									// -
																									// A056_NUM_DAY_TX_PRMPT
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Supplier", 1);
		log.info("Enter Supplier Tab Details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A056_CHK_TURN_IN_TAX)).click();// Turnover
																				// to
																				// include
																				// tax
																				// A056_CHK_TURN_IN_TAX
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CHK_TRNS_ENQ)).click();// Transaction
																				// enquiry
																				// in
																				// reverse
																				// date
																				// sequence
																				// A056_CHK_TRNS_ENQ
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_AUTO_CNCL)).sendKeys(elements.get(15));// A056_AUTO_CNCL-Await
																								// Payment
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TURN_PER_IND)).sendKeys(elements.get(16));// A056_TURN_PER_IND-GL
																								// Calendar
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Payment Processing", 1);
		log.info("Enter Payment Processing Tab Details");

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A056_SCHD_ADV_WARN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_SCHD_ADV_WARN)).sendKeys(elements.get(17));// Schedule
																									// Days
																									// Advance
																									// Warning-
																									// A056_SCHD_ADV_WARN

		getDriver().findElement(By.xpath(pObject.A051_BNK_CODE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_BNK_CODE)).sendKeys(elements.get(18));// Default
																							// Bank
																							// Code
																							// -
																							// A051_BNK_CODE

		getDriver().findElement(By.xpath(pObject.A056_MIN_PAY_BAL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_MIN_PAY_BAL)).sendKeys(elements.get(19));// Minimum
																								// Payment
																								// Value
																								// A056_MIN_PAY_BAL

		getDriver().findElement(By.xpath(pObject.A056_PAY_REGST_VAL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_PAY_REGST_VAL)).sendKeys(elements.get(20));// Payment
																									// Register
																									// Value
																									// A056_PAY_REGST_VAL

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_PAY_RECON)).sendKeys(elements.get(21));// Payment
																								// Reconciliation
																								// -A056_PAY_RECON-
																								// AP
																								// and
																								// GL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CHQ_DUP)).sendKeys(elements.get(22));// Cheque
																							// duplication
																							// -
																							// A056_CHQ_DUP-
																							// Warning
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("GL Controls", 1);
		log.info("Enter GL Controls Tab Details");

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A056_REL_IND)).sendKeys(elements.get(23));// Relationship
																							// -
																							// A056_REL_IND-Normal
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CNTRL_ACC_CD)).clear();
		getDriver().findElement(By.xpath(pObject.A056_CNTRL_ACC_CD)).sendKeys(elements.get(24));// Control
																								// Accounts
																								// Code
																								// A056_CNTRL_ACC_CD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CHK_DEF_PER)).click();// Default
																			// Period
																			// A056_CHK_DEF_PER

		getDriver().findElement(By.xpath(pObject.A023_CURNT_PER)).clear();// A023_CURNT_PER
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CURNT_PER)).sendKeys(elements.get(25));// Current
																								// Period
																								// /
																								// Ye-A023_CURNT_PER

		getDriver().findElement(By.xpath(pObject.A023_CURNT_YR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CURNT_YR)).sendKeys(String.valueOf(calender.fromyear()));// Current
																												// Period
																												// /
																												// Ye
																												// -
																												// A023_CURNT_YR-
																												// fromyear

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_DEF_BATCH_TYP)).clear();// A056_DEF_BATCH_TYP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_DEF_BATCH_TYP)).sendKeys(elements.get(26));// Default
																									// Batch
																									// Type-
																									// A056_DEF_BATCH_TYP

		getDriver().findElement(By.xpath(pObject.A056_LOG_TRANC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_LOG_TRANC)).sendKeys(elements.get(27));// Logged
																								// Transactions
																								// A056_LOG_TRANC

		getDriver().findElement(By.xpath(pObject.A056_ENTR_TRANC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_ENTR_TRANC)).sendKeys(elements.get(28));// Entered
																								// Transactions
																								// A056_ENTR_TRANC

		getDriver().findElement(By.xpath(pObject.A056_CANLD_TRANC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CANLD_TRANC)).sendKeys(elements.get(29));// Cancelled
																								// Transactions
																								// A056_CANLD_TRANC

		getDriver().findElement(By.xpath(pObject.A056_TRANC_TRANSF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TRANC_TRANSF)).sendKeys(elements.get(30));// Transaction
																								// Transfer
																								// A056_TRANC_TRANSF

		getDriver().findElement(By.xpath(pObject.A056_VAT_ANYS_CST_CNTR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_VAT_ANYS_CST_CNTR)).sendKeys(elements.get(31));// VAT
																										// Analysis
																										// by
																										// Cost
																										// Centre
																										// A056_VAT_ANYS_CST_CNTR
		getDriver().findElement(By.xpath(pObject.A056_PAYMNT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_PAYMNT)).sendKeys(elements.get(32));// Payments
																							// A056_PAYMNT
		WaitHelper.waitAdditional(2);

		ClickOnAnyTab("Matching", 1);
		log.info("Enter Matching Tab Details");

		WaitHelper.waitAdditional(3);
		log.info("Enter Invoice/Order Matching Details");
		getDriver().findElement(By.xpath(pObject.A056_TOL_TYPE)).sendKeys(elements.get(33));// Tolerance
																							// type
																							// A056_TOL_TYPE-
																							// %
																							// and
																							// Amount
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TOLRNC_PSTV)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TOLRNC_PSTV)).sendKeys(elements.get(34));// Tolerance
																								// (+)
																								// A056_TOLRNC_PSTV

		getDriver().findElement(By.xpath(pObject.A056_TOLRNC_NEG)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TOLRNC_NEG)).sendKeys(elements.get(35));// Tolerance
																								// (-)
																								// A056_TOLRNC_NEG
		getDriver().findElement(By.xpath(pObject.A056_TOLRNC_AMT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_TOLRNC_AMT)).sendKeys(elements.get(36));// Tolerance
																								// Amount
																								// A056_TOLRNC_AMT

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CHK_TRNC_HD_DIFF)).click();// Transaction
																					// Held
																					// for
																					// Price
																					// Difference
																					// A056_CHK_TRNC_HD_DIFF
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_OVR_INVO_GRN)).sendKeys(elements.get(37));// Over
																								// Invoicing
																								// of
																								// Auto
																								// GRN
																								// Orders
																								// -
																								// A056_OVR_INVO_GRN-Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_GRN_FURT_MAT)).sendKeys(elements.get(38));// Goods
																								// Receipt
																								// Further
																								// Matching
																								// Option
																								// -
																								// A056_GRN_FURT_MAT-Prorata

		log.info("Enter Credit/Debit Matching Details");
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CR_TOL_TYPE)).sendKeys(elements.get(39));// Tolerance
																								// Type
																								// -
																								// A056_CR_TOL_TYPE
		getDriver().findElement(By.xpath(pObject.A056_CR_TOLRNC_PSTV)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A056_CR_TOLRNC_PSTV)).sendKeys(elements.get(40));// Tolerance
																									// (+)
																									// -A056_CR_TOLRNC_PSTV
		getDriver().findElement(By.xpath(pObject.A056_CR_TOLRNC_AMT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_CR_TOLRNC_AMT)).sendKeys(elements.get(41));// Tolerance
																									// Amount
																									// -
																									// A056_CR_TOLRNC_AMT
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("BEM/Diary", 1);
		log.info("Enter BEM/Diary Tab Details");
		getDriver().findElement(By.xpath(pObject.A056_DAYS_RESIT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_DAYS_RESIT)).sendKeys(elements.get(42));// Days
																								// Resident
																								// A056_DAYS_RESIT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_DAYS_RESIT)).sendKeys(Keys.ENTER);// Days
																						// Resident
																						// A056_DAYS_RESIT
		WaitHelper.waitAdditional(1);

	}

	/**
	 * Set Up Additional Batch Types - A056A
	 * 
	 * @param elements
	 */
	public void amendBatchTypes(List<String> elements) {
		log.info("Amend batch types");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A056_CHK_SECD_IND)).click();
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A056_CHK_GEN_BTCH_REF)).click();
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A056_LST_BTCH_REF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A056_LST_BTCH_REF)).sendKeys(elements.get(1));// Last
																								// Batch
																								// Reference

	}

	/**
	 * Enter Transactional Legend details - A057
	 * 
	 * @param elements
	 */
	public boolean enterTransactionLegendDetails(List<String> elements) {
		log.info("Inside transaction legend details");
		boolean update = false;

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A057_TRAN_TYP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A057_TRAN_TYP)).sendKeys(elements.get(0));// Transaction
																							// Type
																							// A057_TRAN_TYP

		getDriver().findElement(By.xpath(pObject.A057_TRAN_SUBTYP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A057_TRAN_SUBTYP)).sendKeys(elements.get(1));// Transaction
																								// Sub-type
																								// A057_TRAN_SUBTYP
		getDriver().findElement(By.xpath(pObject.A057_TRAN_SUBTYP)).sendKeys(Keys.ENTER);// Transaction
																							// Sub-type
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(2));// Description
																									// A002_DESCRIPTION

			getDriver().findElement(By.xpath(pObject.A057_LGND)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A057_LGND)).sendKeys(elements.get(3));// Legend
																							// A057_LGND
			update = true;
		}
		return update;
	}

	/**
	 * Enter payment methods - A058
	 * 
	 * @param elements
	 */
	public boolean enterPaymentMethod(List<String> elements) {
		log.info("Inside payment methods");
		boolean update = false;
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A058_PYMNT_MTHD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A058_PYMNT_MTHD)).sendKeys(elements.get(0));// Payment
																								// method
																								// A058_PYMNT_MTHD
		getDriver().findElement(By.xpath(pObject.A058_PYMNT_MTHD)).sendKeys(Keys.ENTER);// Payment
																						// method
																						// A058_PYMNT_MTHD
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Payment
																									// description
																									// A002_DESCRIPTION

			getDriver().findElement(By.xpath(pObject.A018_CURR_CODE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A018_CURR_CODE)).sendKeys(elements.get(2));// Currency
																								// A018_CURR_CODE
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A058_PYMNT_MDUM)).sendKeys(elements.get(3));// Payment
																									// Medium
																									// A058_PYMNT_MDUM
			WaitHelper.waitAdditional(1);
			if (!elements.get(4).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A058_PYMNT_RATE)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A058_PYMNT_RATE)).sendKeys(elements.get(4));// Payment
																										// Rate
																										// A058_PYMNT_RATE
			}
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A058_IND)).sendKeys(elements.get(5));// Indicator
																							// A058_IND
			WaitHelper.waitAdditional(1);

			if (elements.get(6).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A058_CHK_SPLT_PRNT)).click();// Split
																						// print
																						// A058_CHK_SPLT_PRNT
			}
			update = true;
		}
		return update;

	}

	/**
	 * Enter Bank payment methods - A059
	 * 
	 * @param elements
	 */

	public boolean enterBankPayMethods(List<String> elements) {
		log.info("Inside bank payment methods");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A051_BNK_CODE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A051_BNK_CODE)).sendKeys(elements.get(0));// Bank
																							// code
																							// A051_BNK_CODE

		getDriver().findElement(By.xpath(pObject.A058_PYMNT_MTHD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A058_PYMNT_MTHD)).sendKeys(elements.get(1));// Payment
																								// method
																								// A058_PYMNT_MTHD
		getDriver().findElement(By.xpath(pObject.A058_PYMNT_MTHD)).sendKeys(Keys.ENTER);// Payment
																						// method
																						// A058_PYMNT_MTHD
		WaitHelper.waitAdditional(2);
		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A057_TRAN_SUBTYP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A057_TRAN_SUBTYP)).sendKeys(elements.get(2));// Payment
																									// Sub-Type
																									// A057_TRAN_SUBTYP
			update = true;
		}
		return update;
	}

	/**
	 * Enter payment code - A060
	 * 
	 * @param elements
	 */

	public boolean enterPaymentCode(List<String> elements) {
		log.info("Inside payment code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A060_PYMNT_COD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A060_PYMNT_COD)).sendKeys(elements.get(0));// Payment
																							// code
																							// A060_PYMNT_COD
		getDriver().findElement(By.xpath(pObject.A060_PYMNT_COD)).sendKeys(Keys.ENTER);// Payment
																						// code
																						// A060_PYMNT_COD
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A060_DESC)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A060_DESC)).sendKeys(elements.get(1));// Payment
																							// description
																							// A060_DESC

			if (elements.get(2).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A060_RAD_SET_DU_DT)).click();// Settlement
																						// Due
																						// Date
																						// A060_RAD_SET_DU_DT
			}

			WaitHelper.waitAdditional(3);

			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();// Currency
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(3));// Currency
																												// Input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();// Payment
																						// method
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(4));// Payment
																												// method
																												// Input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();// Bank
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(5));// Bank
																												// Input
			WaitHelper.waitAdditional(1.5);

			if (elements.get(6).equals("Y")) {

				getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).click();// Auto-Payment
				getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(6));// Auto-Payment
																													// Input
				WaitHelper.waitAdditional(1.5);

			}

			ClickOnAnyTab("Destination", 1);
			WaitHelper.waitAdditional(2);

			getDriver()
					.findElement(By
							.xpath("//div[text()='Schedule Destination']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[1]"))
					.click();
			getDriver()
					.findElement(By
							.xpath("//div[text()='Schedule Destination']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[1]/input"))
					.sendKeys(elements.get(7));// Schedule Destination Input
			WaitHelper.waitAdditional(1.5);

			getDriver()
					.findElement(By
							.xpath("//div[text()='Payment Destination']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[2]"))
					.click();// Payment Destination
			getDriver()
					.findElement(By
							.xpath("//div[text()='Payment Destination']/../../../../../../../../../../..//div[1]/table/tbody/tr/td[2]/input"))
					.sendKeys(elements.get(8));// Payment Destination Input
			WaitHelper.waitAdditional(1.5);

			update = true;
		}
		return update;
	}

	/**
	 * Create Location Code - A061 -AK2
	 * 
	 * @param elements
	 */

	public boolean enterLocationCodeDetails(List<String> elements) {
		log.info("Inside location code details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A061_LOC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A061_LOC)).sendKeys(elements.get(0));// Location
																						// A061_LOC
		getDriver().findElement(By.xpath(pObject.A061_LOC)).sendKeys(Keys.ENTER);// Location
																					// A061_LOC
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																									// A002_DESCRIPTION

			getDriver().findElement(By.xpath(pObject.A061_ADDR_LINE1)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A061_ADDR_LINE1)).sendKeys(elements.get(2));// Address
																									// line
																									// 1
																									// A061_ADDR_LINE1
			WaitHelper.waitAdditional(1);

			if (!elements.get(3).equals("NILL"))

			{
				getDriver().findElement(By.xpath(pObject.A061_PSTCD)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A061_PSTCD)).sendKeys(elements.get(3));// Post
																								// code
																								// A061_PSTCD
			}

			ClickOnAnyTab("Details", 1);
			WaitHelper.waitAdditional(2);

			if (!elements.get(4).equals("NILL"))

			{
				getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(4));// Management
																									// code
																									// A029_ELEMENT
			}

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A061_ACPT_USR)).sendKeys(elements.get(5));// Accept
																								// user
																								// A061_ACPT_USR
			update = true;
		}
		return update;
	}

	/**
	 * Create Tax handlers - A062-RAF
	 * 
	 * @param elements
	 */

	public boolean enterTaxHandlingDetails(List<String> elements) {
		log.info("Inside tax handling details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A062_HAND)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A062_HAND)).sendKeys(elements.get(0));// Handling
																						// A062_HAND
		getDriver().findElement(By.xpath(pObject.A062_HAND)).sendKeys(Keys.ENTER);// Handling
																					// A062_HAND

		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																									// A002_DESCRIPTION

			WaitHelper.waitAdditional(1);
			if (elements.get(2).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A062_CHK_INCL)).click();// Inclusive
																					// A062_CHK_INCL
			}

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A062_RCVBLE)).sendKeys(elements.get(3));// Recoverable
																								// A062_RCVBLE

			WaitHelper.waitAdditional(1);
			if (elements.get(4).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A062_CHK_PRO_RAT)).click();// Pro-data
																					// A062_CHK_PRO_RAT
			}

			update = true;
		}
		return update;
	}

	/**
	 * Create Standard Reference details - A063-PXU
	 * 
	 * @param elements
	 * @param lines
	 */

	public boolean enterStandardTextReferenceDetails(List<String> elements, List<String> lines) {
		log.info("Enter standard text reference details");
		boolean update = false;
		WaitHelper.waitAdditional(2);

		if (elements.get(1).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A063_CHK_DISBLD)).click();// Disabled
																				// check
																				// box
																				// A063_CHK_DISBLD
		}
		getDriver().findElement(By.xpath(pObject.A063_TXTREF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A063_TXTREF)).sendKeys(elements.get(0));// Text
																							// ref
																							// A063_TXTREF

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A063_TXTREF)).sendKeys(Keys.ENTER);// Text
																					// ref
																					// A063_TXTREF
		WaitHelper.waitAdditional(1);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(2));// Description
																									// A002_DESCRIPTION
			WaitHelper.waitAdditional(1);

			for (int i = 1; i <= lines.size(); i++) {
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input"))
						.sendKeys(lines.get(i - 1));// Lines of Text

				WaitHelper.waitAdditional(1);
			}
			update = true;
		}

		return update;
	}

	/**
	 * Create PPV Control Account - A064-PXM
	 * 
	 * @param elements
	 */

	public void enterPPVControlAccount(String companyId, List<String> elements) {

		// public void enterPPVControlAccount(List<String> elements){
		log.info("Enter PPV control account details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A064_PPV_CON_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A064_PPV_CON_CD)).sendKeys(companyId);// PPV
																						// Control
																						// code
																						// A064_PPV_CON_CD

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A064_PPV_ACC)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A064_PPV_ACC)).sendKeys(elements.get(2));// PPV
																							// Account
																							// A064_PPV_ACC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A064_PPV_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A064_PPV_CST)).sendKeys(elements.get(3));// PPV
																							// Account
																							// A064_PPV_CST
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A064_PPVREV_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A064_PPVREV_ACC)).sendKeys(elements.get(4));// PPV
																								// Reserve
																								// A064_PPVREV_ACC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A064_PPVREV_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A064_PPVREV_CST)).sendKeys(elements.get(5));// PPV
																								// Reserve
																								// A064_PPVREV_CST
	}

	/**
	 * Edit purchasing company control - A065-PAA
	 * 
	 * @param elements
	 */

	public void editCommonPurchasingComany(String companyId, List<String> elements) {
		log.info("Edit company purchasing company");
		WaitHelper.waitAdditional(2);

		log.info("On tab- GL/Numbering/Variance- and section -Variance Processing-");

		if (!getDriver().findElement(By.xpath(pObject.A065_CHK_PUR_PRZ)).isSelected())
			;
		{
			getDriver().findElement(By.xpath(pObject.A065_CHK_PUR_PRZ)).click();// Purchasing
																				// price
																				// A065_CHK_PUR_PRZ
		}

		getDriver().findElement(By.xpath(pObject.A065_PPV_ACC_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A065_PPV_ACC_CD)).sendKeys(companyId);// PPV
																						// account
																						// code
																						// A065_PPV_ACC_CD
		WaitHelper.waitAdditional(1);

		log.info("On Supplier tab, Defaults Section");

		ClickOnAnyTab("Supplier", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A065_PRZ_EXP)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A065_PRZ_EXP)).sendKeys(elements.get(1));// Price
																							// expiry
																							// A065_PRZ_EXP
		WaitHelper.waitAdditional(1);

		log.info("On Goods Receipting/IM tab");
		ClickOnAnyTab("Goods Receipting/IM", 1);
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A065_CHK_PTREC_RET)).click();// Print
																				// receipt/Return
																				// Note
																				// A065_CHK_PTREC_RET
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A065_NUM_COPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A065_NUM_COPY)).sendKeys(elements.get(2));// No.of
																							// copies
																							// A065_NUM_COPY

		getDriver().findElement(By.xpath(pObject.A065_CHK_AT_PTREC)).click();// At
																				// point
																				// of
																				// receipt
																				// A065_CHK_AT_PTREC
		WaitHelper.waitAdditional(1);
	}

	/**
	 * Create Accrual control account - A066-DAA
	 * 
	 * @param elements
	 */

	public void enterAccrualControlAccount(String companyId, List<String> elements)

	{
		log.info("Enter accrual control account details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A066_ACCRU_CNTRL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A066_ACCRU_CNTRL)).sendKeys(companyId);// Accrual
																						// Control
																						// code
																						// A066_ACCRU_CNTRL

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A066_ACC_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A066_ACC_ACC)).sendKeys(elements.get(2));// Accrual
																							// Account
																							// A066_ACC_ACC
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A066_ACC_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A066_ACC_CST)).sendKeys(elements.get(3));// Accrual
																							// Account
																							// A066_ACC_CST
	}

	/**
	 * Create Inspection code - A067- DAG
	 * 
	 * @param elements
	 */
	public void enterPOPCompanyControls(String companyName, List<String> elements) {
		log.info("Enter POP company controls");
		WaitHelper.waitAdditional(2);

		ClickOnAnyTab("Numbering/GL/Supplier", 1);// Numbering / GL /Supplier

		log.info("On Numbering/GL/Supplier tab");

		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);// Company
																						// A006_COMPANY

		getDriver().findElement(By.xpath(pObject.A067_CMPY_NUM_LEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_CMPY_NUM_LEN)).sendKeys(elements.get(0));// Company
																								// no
																								// length
																								// A067_CMPY_NUM_LEN

		getDriver().findElement(By.xpath(pObject.A067_NEXT_DOC_NUM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_NEXT_DOC_NUM)).sendKeys(elements.get(1));// Next
																								// doc
																								// no
																								// A067_NEXT_DOC_NUM

		getDriver().findElement(By.xpath(pObject.A067_CNTRL_ACC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_CNTRL_ACC)).sendKeys(companyName);// Control
																						// Account
																						// A067_CNTRL_ACC

		getDriver().findElement(By.xpath(pObject.A067_BTCH_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_BTCH_TYPE)).sendKeys(elements.get(3));// Batch
																							// Type
																							// A067_BTCH_TYPE

		getDriver().findElement(By.xpath(pObject.A067_GL_CURNT_PER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_GL_CURNT_PER)).sendKeys(elements.get(4));// Current
																								// GL
																								// Period/Year
																								// A067_GL_CURNT_PER

		getDriver().findElement(By.xpath(pObject.A067_GL_CURNT_YY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_GL_CURNT_YY)).sendKeys(String.valueOf(calender.fromyear()));// Current
																													// GL
																													// Period/Year
																													// A067_GL_CURNT_YY

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_CHK_MAIN_TURN)).click();// Maintain
																				// Turnover
																				// A067_CHK_MAIN_TURN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_CHK_TNVR_INC_TX)).click();// Turnover
																				// to
																				// Include
																				// Tax
																				// A067_CHK_TNVR_INC_TX
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_CHK_MAIN_CURR_TNVR)).click();// Maintain
																					// Currency
																					// Turnover
																					// A067_CHK_MAIN_CURR_TNVR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_TNVR_PER_DEF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_TNVR_PER_DEF)).sendKeys(elements.get(6));// Turn-over
																								// period
																								// definition
																								// A067_TNVR_PER_DEF

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_PRMPT_ACTVE)).sendKeys(elements.get(7));// Prompts
																								// Active
																								// A067_PRMPT_ACTVE

		getDriver().findElement(By.xpath(pObject.A067_NUM_PRC_RETN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_NUM_PRC_RETN)).sendKeys(elements.get(8));// Number
																								// of
																								// Prices
																								// to
																								// Return
																								// A067_NUM_PRC_RETN
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Data Entry", 1);
		log.info("On Data Entry tab");

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_AMD_REV)).click();// Amend
																		// or
																		// revise
																		// A067_AMD_REV

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_SUPP_ADDR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_SUPP_ADDR)).sendKeys(elements.get(9));// Supplier
																							// address
																							// A067_SUPP_ADDR

		getDriver().findElement(By.xpath(pObject.A067_INV_PNT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_INV_PNT)).sendKeys(elements.get(10));// Invoice
																							// point
																							// A067_INV_PNT

		getDriver().findElement(By.xpath(pObject.A067_DLVRY_PNT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_DLVRY_PNT)).sendKeys(elements.get(11));// Delivery
																								// point
																								// A067_DLVRY_PNT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_PRT_CNCL_SUPP)).click();// Print
																				// cancelled
																				// lines-
																				// suppressed
																				// A067_PRT_CNCL_SUPP
		WaitHelper.waitAdditional(1);

		if (!getDriver().findElement(By.xpath(pObject.A067_CHK_ITM_DESC_AMD)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A067_CHK_ITM_DESC_AMD)).click();// Item
																						// Description
																						// Amendable
																						// A067_CHK_ITM_DESC_AMD
		}
		WaitHelper.waitAdditional(1);
		if (!getDriver().findElement(By.xpath(pObject.A067_CHK_USE_EDI)).isSelected())

		{
			getDriver().findElement(By.xpath(pObject.A067_CHK_USE_EDI)).click();// Use
																				// EDI
																				// Processing
																				// A067_CHK_USE_EDI
		}
		WaitHelper.waitAdditional(1);
		if (!getDriver().findElement(By.xpath(pObject.A067_CHK_LOC_CD_MNDR)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A067_CHK_LOC_CD_MNDR)).click();// Location
																					// Codes
																					// Mandatory
																					// A067_CHK_LOC_CD_MNDR
		}
		WaitHelper.waitAdditional(1);
		if (!getDriver().findElement(By.xpath(pObject.A067_CHK_ORDR_LN_ACCPT)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A067_CHK_ORDR_LN_ACCPT)).click();// Order
																						// Line
																						// Accept
																						// User
																						// A067_CHK_ORDR_LN_ACCPT
		}
		WaitHelper.waitAdditional(1);
		if (!getDriver().findElement(By.xpath(pObject.A067_CHK_ALLW_AUTO_ORDR)).isSelected())

		{
			getDriver().findElement(By.xpath(pObject.A067_CHK_ALLW_AUTO_ORDR)).click();// Allow
																						// Auto
																						// Order
																						// creation
																						// from
																						// Requisitions
																						// A067_CHK_ALLW_AUTO_ORDR
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_NUMB)).sendKeys(elements.get(12));// Numbering
																						// A067_NUMB

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_QUTN_REQ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_QUTN_REQ)).sendKeys(elements.get(13));// Quotation
																							// Request
																							// A067_QUTN_REQ

		getDriver().findElement(By.xpath(pObject.A067_QUTN_ACCPT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_QUTN_ACCPT)).sendKeys(elements.get(14));// Quotation
																								// Acceptance
																								// A067_QUTN_ACCPT

		getDriver().findElement(By.xpath(pObject.A067_QUTN_REJ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_QUTN_REJ)).sendKeys(elements.get(15));// Quotation
																							// Rejection
																							// A067_QUTN_REJ

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_DOCU_RET_PER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_DOCU_RET_PER)).sendKeys(elements.get(16));// Document
																								// Retention
																								// Period
																								// A067_DOCU_RET_PER

		getDriver().findElement(By.xpath(pObject.A067_FOR_CURR_RTYP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_FOR_CURR_RTYP)).sendKeys(elements.get(17));// Foreign
																									// Currency
																									// Rate
																									// Type
																									// A067_FOR_CURR_RTYP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A067_FOR_CURR_RTYP)).sendKeys(Keys.ENTER);// Foreign
																							// Currency
																							// Rate
																							// Type
																							// A067_FOR_CURR_RTYP
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Create Inspection code - A068-PXG
	 * 
	 * @param elements
	 */
	public void enterInspectionCode(List<String> elements) {
		WaitHelper.waitAdditional(3);
		log.info("Enter inspection code details");
		getDriver().findElement(By.xpath(pObject.A068_INSP_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A068_INSP_CD)).sendKeys(elements.get(0));// Inspection
																							// code
																							// A068_INSP_CD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A068_TYP_INSP)).click();// Inspection
																			// type
																			// A068_TYP_INSP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
	}

	/**
	 * Create Disposal code - A0069-PXE
	 * 
	 * @param elements
	 */
	public boolean enterDisposalCode(List<String> elements) {
		log.info("Enter disposal code details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A069_CODE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A069_CODE)).sendKeys(elements.get(0));// Disposal
																						// code
																						// A069_CODE

		getDriver().findElement(By.xpath(pObject.A069_CODE)).sendKeys(Keys.ENTER);// Disposal
																					// code
																					// A069_CODE
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																									// A002_DESCRIPTION
			update = true;
		}
		return update;
	}

	/**
	 * Create Disposal code - A0070-PXQ
	 * 
	 * @param elements
	 */
	public void enterReasonCode(List<String> elements) {
		log.info("Enter reason code details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A070_RES_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A070_RES_CD)).sendKeys(elements.get(0));// Reason
																							// code
																							// A070_RES_CD

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
	}

	/**
	 * Document prefix code - A071-PXJ-PXI
	 * 
	 * @param elements
	 */
	public boolean enterDocumentPrefixCode(List<String> elements) {
		log.info("Inside document prefix code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A071_DOC_TYP)).sendKeys(elements.get(0));// Document
																							// type
																							// A071_DOC_TYP
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A071_PRFX)).clear();
		getDriver().findElement(By.xpath(pObject.A071_PRFX)).sendKeys(elements.get(1));// Prefix
																						// A071_PRFX
		getDriver().findElement(By.xpath(pObject.A071_PRFX)).sendKeys(Keys.ENTER);// Prefix
																					// A071_PRFX
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(2));// Description
																									// A002_DESCRIPTION
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A071_SFX_TYP)).sendKeys(elements.get(3));// Suffix
																								// type
																								// A071_SFX_TYP
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A071_SFX_LEN)).clear();
			getDriver().findElement(By.xpath(pObject.A071_SFX_LEN)).sendKeys(elements.get(4));// Length
																								// A071_SFX_LEN
			update = true;
		}
		return update;
	}

	/**
	 * Search CP user
	 * 
	 * @param elements
	 */
	public void searchCPUser(List<String> elements) {
		log.info("Search CP User");
		WaitHelper.waitAdditional(2);
		if (!isOkButtonDisplayed(6)) {
			clickOnSections(0);
		}
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.FOUR)).sendKeys(elements.get(0));
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.FIVE)).sendKeys(elements.get(1));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.SIX + pObject.LABEL)).click();

	}

	/**
	 * Create CP User - A072
	 * 
	 * @param elements
	 */

	public void enterCPUserDetails(List<String> elements) {
		log.info("Inside CP User details page");

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).sendKeys(elements.get(0));// CP
																								// User
																								// LOGIN_USER_NAME

		WaitHelper.waitAdditional(2);

		if (elements.get(1).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A072_CHK_BUYER)).click();// Buyer
																				// A072_CHK_BUYER
		}
		WaitHelper.waitAdditional(1);
		if (elements.get(2).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A072_CHK_EXPEDITOR)).click();// Expediter
																					// A072_CHK_EXPEDITOR
		}
		WaitHelper.waitAdditional(1);
		if (elements.get(3).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A072_CHK_ACCEPTOR)).click();// Acceptor
																					// A072_CHK_ACCEPTOR
		}
		WaitHelper.waitAdditional(1);
		if (elements.get(4).equals("1")) {
			getDriver().findElement(By.xpath(pObject.A072_CHK_GOOD_REC)).click();// Goods
																					// Receiver
																					// A072_CHK_GOOD_REC
		}

		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Default Details", 1);
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A072_BUYER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A072_BUYER)).sendKeys(elements.get(5));// Buyer
																						// A072_BUYER
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Create Receipt Control details - A073-PX3
	 * 
	 * @param elements
	 */

	public void enterReceiptControlsDetails(List<String> elements) {
		log.info("Enter receipt control details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A073_RCPT_CNTRL)).clear();
		getDriver().findElement(By.xpath(pObject.A073_RCPT_CNTRL)).sendKeys(elements.get(0));// Receipt
																								// Control
																								// A073_RCPT_CNTRL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A073_TOL_PROC)).sendKeys(elements.get(2));// Tolerance
																							// Processing
																							// A073_TOL_PROC

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A073_UNDCHK_WAR)).click();// Under
																			// Check
																			// Warning
																			// A073_UNDCHK_WAR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A073_UNDCHK_PER)).clear();
		getDriver().findElement(By.xpath(pObject.A073_UNDCHK_PER)).sendKeys(elements.get(3));// Under
																								// Check
																								// %
																								// A073_UNDCHK_PER

		// getDriver().findElement(By.xpath(pObject.A073_UNDCHK_VAL)).clear();
		// getDriver().findElement(By.xpath(pObject.A073_UNDCHK_VAL)).sendKeys("1.00");//Under
		// Check value A073_UNDCHK_VAL

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A073_OVRCHK_WAR)).click();// Over
																			// Check
																			// Warning
																			// A073_OVRCHK_WAR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A073_OVRCHK_PER)).clear();
		getDriver().findElement(By.xpath(pObject.A073_OVRCHK_PER)).sendKeys(elements.get(4));// Over
																								// Check
																								// %
																								// A073_OVRCHK_PER

		// getDriver().findElement(By.xpath(pObject.A073_OVRCHK_VAL)).clear();
		// getDriver().findElement(By.xpath(pObject.A073_OVRCHK_VAL)).sendKeys("1.00");//Under
		// Check value A073_OVRCHK_VAL

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A073_EARCHK_WAR)).click();// Early
																			// check
																			// Warning
																			// A073_EARCHK_WAR

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A073_EARCHK_DAYS)).clear();
		getDriver().findElement(By.xpath(pObject.A073_EARCHK_DAYS)).sendKeys(elements.get(5));// Early
																								// check
																								// Days
																								// A073_EARCHK_DAYS
	}

	/**
	 * CreatebAutomatic bank code - A074
	 * 
	 * @param elements
	 */
	public void enterAutomaticBankCode(List<String> elements, String protocolId) {
		log.info("Enter automatic bank code details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A074_AUTO_BNK_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A074_AUTO_BNK_CD)).sendKeys(elements.get(0));// Automatic
																								// Banking
																								// Code
																								// A074_AUTO_BNK_CD

		getDriver().findElement(By.xpath(pObject.A074_USR_NUM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A074_USR_NUM)).sendKeys(elements.get(1));// User
																							// Number
																							// A074_USR_NUM

		getDriver().findElement(By.xpath(pObject.A074_USR_NAME)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A074_USR_NAME)).sendKeys(elements.get(2));// User
																							// Name
																							// A074_USR_NAME
		WaitHelper.waitAdditional(1);

		if (!elements.get(3).equals("NILL")) {
			getDriver().findElement(By.xpath(pObject.A074_BUREAU_NUM)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A074_BUREAU_NUM)).sendKeys(elements.get(3));// Bureau
																									// Number
																									// A074_BUREAU_NUM
		}
		getDriver().findElement(By.xpath(pObject.A074_PRTCL_ID)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A074_PRTCL_ID)).sendKeys(protocolId);// Protocol
																						// Id
																						// A074_PRTCL_ID

		getDriver().findElement(By.xpath(pObject.A074_CLNDR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A074_CLNDR)).sendKeys(elements.get(4));// Calendar
																						// A074_CLNDR

		getDriver().findElement(By.xpath(pObject.A074_PROC_CYC_DD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A074_PROC_CYC_DD)).sendKeys(elements.get(5));// Processing
																								// Cycle/Days
																								// A074_PROC_CYC_DD
	}

	/**
	 * Create Circulation code - A075A,B
	 * 
	 * @param elements
	 */
	public boolean enterCirculationCode(String companyId, List<String> elements) {
		log.info("Inside circulation code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A075_CIRC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A075_CIRC)).sendKeys(elements.get(0));// Circulation
																						// A075_CIRC
		getDriver().findElement(By.xpath(pObject.A075_CIRC)).sendKeys(Keys.ENTER);// Circulation
																					// A075_CIRC
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A075_CIRC_DESC)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A075_CIRC_DESC)).sendKeys(elements.get(1));// Descrption
																								// A075_CIRC_DESC
			WaitHelper.waitAdditional(3);

			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(5));// Company
			WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(2));// Mapping
			WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(3));// Profile
			WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(4));// Profile
			WaitHelper.waitAdditional(2);

			update = true;
		}
		return update;
	}

	/* Company control QSA */

	public boolean createCompanyControl(String companyName, List<String> elements) {
		log.info("Create company control");
		boolean update = false;
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);// Company
																						// A006_COMPANY
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(Keys.ENTER);// Company
																						// A006_COMPANY

		if (!getToolContentText().contains(message)) {

			getDriver().findElement(By.xpath(pObject.A075_NOTIY_USR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A075_NOTIY_USR)).sendKeys(elements.get(0));// Problems
																								// Notify
																								// User
																								// A075_NOTIY_USR

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A075_DFLT_RPRT_PRFX)).clear();
			getDriver().findElement(By.xpath(pObject.A075_DFLT_RPRT_PRFX)).sendKeys(elements.get(1));// Default
																										// Report
																										// Prefix
																										// A075_DFLT_RPRT_PRFX

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A075_DFLT_RPRT_NO)).clear();
			getDriver().findElement(By.xpath(pObject.A075_DFLT_RPRT_NO)).sendKeys(elements.get(2));// Default
																									// Report
																									// Prefix
																									// No
																									// A075_DFLT_RPRT_NO

			update = true;

		}
		return update;

	}

	/* Create Mappings QMA */
	public boolean createMappings(List<String> elements) {
		log.info("Inside create maappings method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A075_MAPPNG)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A075_MAPPNG)).sendKeys(elements.get(0));// Mapping
																							// A075_MAPPNG
		getDriver().findElement(By.xpath(pObject.A075_MAPPNG)).sendKeys(Keys.ENTER);// Mapping
																					// A075_MAPPNG

		if (!getToolContentText().contains(message)) {

			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																									// A002_DESCRIPTION
			update = true;

		}

		return update;

	}

	/**
	 * Document Codes - A076
	 * 
	 * @param elements
	 */

	public boolean enterDocumentCodeDetails(List<String> elements) {
		log.info("Enter document code details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A076_DOC_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A076_DOC_CD)).sendKeys(elements.get(0));// Document
																							// code
																							// A076_DOC_CD

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A076_DOC_TYP)).sendKeys(elements.get(2));// Document
																							// type
																							// A076_DOC_TYP
		getDriver().findElement(By.xpath(pObject.A076_DOC_TYP)).sendKeys(Keys.ENTER);// Document
																						// type
																						// A076_DOC_TYP
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			ClickOnAnyTab("Miscellaneous", 1);
			log.info("On the Miscellaneous Tab");
			WaitHelper.waitAdditional(1.5);

			if (!elements.get(3).equals("NILL")) {
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_HEAD_ENT)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_HEAD_ENT)).sendKeys(elements.get(3));// Header
																									// Entry
																									// A076_HEAD_ENT
			}
			if (!elements.get(4).equals("NILL")) {
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_DETL_ENT)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_DETL_ENT)).sendKeys(elements.get(4));// Detail
																									// Entry
																									// A076_DETL_ENT
			}
			if (!elements.get(5).equals("NILL")) {
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_FAST_ENT)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_FAST_ENT)).sendKeys(elements.get(5));// Fast
																									// Entry
																									// A076_FAST_ENT
			}
			WaitHelper.waitAdditional(1);

			ClickOnAnyTab("Print Options", 1);
			log.info("On the Print Options Tab");
			WaitHelper.waitAdditional(2);
			if (elements.get(6).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A076_AMD_PNTALL)).click();// Amendments
																					// -
																					// Print
																					// All
																					// A076_AMD_PNTALL
				WaitHelper.waitAdditional(1);
			}
			if (elements.get(7).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A076_REV_PNTALL)).click();// Revisions
																					// -
																					// Print
																					// All
																					// A076_REV_PNTALL
				WaitHelper.waitAdditional(1);
			}

			if (elements.get(8).equals("0")) {
				getDriver().findElement(By.xpath(pObject.A076_PNTCANL_ASOTHR)).click();// Printing
																						// of
																						// Cancelled
																						// Lines
																						// -
																						// As
																						// Others
																						// A076_PNTCANL_ASOTHR
				WaitHelper.waitAdditional(1);
			}

			if (elements.get(8).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A076_PNTCANL_SUPP)).click();// Printing
																						// of
																						// Cancelled
																						// Lines
																						// -
																						// Suppressed
																						// A076_PNTCANL_SUPP
				WaitHelper.waitAdditional(1);
			}
			if (elements.get(8).equals("2")) {
				getDriver().findElement(By.xpath(pObject.A076_PNTCANL_ANNOT)).click();// Printing
																						// of
																						// Cancelled
																						// Lines
																						// -
																						// Annotated
																						// A076_PNTCANL_ANNOT
				WaitHelper.waitAdditional(1);
			}
			if (elements.get(9).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A076_CHK_IM_PRNT_REQ)).click();// Immediate
																						// Print
																						// Required
																						// A076_CHK_IM_PRNT_REQ
				WaitHelper.waitAdditional(1);
			}
			if (!elements.get(10).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A076_CIRCU)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_CIRCU)).sendKeys(elements.get(10));// Circulation
																									// A076_CIRCU
			}
			WaitHelper.waitAdditional(1);

			ClickOnAnyTab("Data Entry", 1);
			log.info("On the Data Entry Tab");
			WaitHelper.waitAdditional(2);

			if (!elements.get(11).equals("NILL")) {
				WaitHelper.waitAdditional(2);
				getDriver().findElement(By.xpath(pObject.A076_PRC_MAN)).sendKeys(elements.get(11));// Price
																									// Mandatory
																									// A076_PRC_MAN
			}
			if (!elements.get(12).equals("NILL")) {
				WaitHelper.waitAdditional(2);
				getDriver().findElement(By.xpath(pObject.A076_AUTO_NUM_REQ)).sendKeys(elements.get(12));// Auto-Numbering
																										// Required
																										// A076_AUTO_NUM_REQ
			}
			if (!elements.get(13).equals("NILL")) {
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_VAL_CEL_DOC)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_VAL_CEL_DOC)).sendKeys(elements.get(13));// Value
																										// Ceiling
																										// For
																										// Document
																										// A076_VAL_CEL_DOC
			}
			if (elements.get(14).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A076_RETN)).click();// Returns
																				// A076_RETN
			}
			if (!elements.get(15).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A076_MAT_REQ)).sendKeys(elements.get(15));// Material
																									// Request
																									// A076_MAT_REQ

			}

			if (elements.get(2).equals("Requisition")) {
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_SUP_MAND)).sendKeys(elements.get(20));// Supplier
																									// Manadatory

			}

			WaitHelper.waitAdditional(1);
			ClickOnAnyTab("Invoices and Commitments", 1);
			log.info("On the Invoices and Commitments Tab");
			WaitHelper.waitAdditional(2);

			if (elements.get(16).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A076_CHK_MIS_CHRG_ACC)).click();// Miscellaneous
																							// Charges
																							// Accepted
																							// A076_CHK_MIS_CHRG_ACC
			}
			WaitHelper.waitAdditional(1);
			if (elements.get(17).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A076_CHK_INVPRC_TOL)).click();// Invoice
																						// Price
																						// Tolerance
																						// Check
																						// A076_CHK_INVPRC_TOL
			}
			WaitHelper.waitAdditional(1);
			if (!elements.get(18).equals("NILL")) {
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_ORDR_LN_SELDEF)).sendKeys(elements.get(18));// Order
																											// Line
																											// Selection
																											// Default
																											// A076_ORDR_LN_SELDEF
			}
			WaitHelper.waitAdditional(1);
			if (!elements.get(19).equals("NILL")) {
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_ACCRL)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A076_ACCRL)).sendKeys(elements.get(19));// Accruals
																									// Batch
																									// type
																									// A076_ACCRL
			}

			update = true;
		}
		return update;

	}

	/**
	 * Edit CP company controls - A077-PAA
	 * 
	 * @param elements
	 */
	public void editCPCompanyControls(List<String> elements) {
		log.info("Edit CP company controls");
		WaitHelper.waitAdditional(4);

		ClickOnAnyTab("Goods Receipting/IM", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A077_AUT_RET_ORCD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A077_AUT_RET_ORCD)).sendKeys(elements.get(0));// Automatic
																								// Returns
																								// Order
																								// Code
																								// A077_AUT_RET_ORCD

		getDriver().findElement(By.xpath(pObject.A077_PUR_REQSNCD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A077_PUR_REQSNCD)).sendKeys(elements.get(1));// Purchase
																								// Requisition
																								// Code
																								// A077_PUR_REQSNCD

		getDriver().findElement(By.xpath(pObject.A077_REPL_REQSNCD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A077_REPL_REQSNCD)).sendKeys(elements.get(2));// Replenishment
																								// Requisition
																								// Code
																								// A077_REPL_REQSNCD

		getDriver().findElement(By.xpath(pObject.A077_BYR_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A077_BYR_CD)).sendKeys(elements.get(3));// Buyer
																							// Code
																							// A077_BYR_CD
	}

	/**
	 * Authorisation Controls - A078-GOA
	 * 
	 * @param elements
	 */
	public boolean enterAuthorisationControlDetails(List<String> elements) {
		log.info("Inside authorisation control details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).clear();
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(elements.get(0));// Authorisation
																								// Control
																								// Code
																								// A078_AUTH_CNTRL_CD
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																									// A002_DESCRIPTION
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A078_MEHOD)).sendKeys(elements.get(2));// Method
																							// A078_MEHOD

			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A078_TYPE)).sendKeys(elements.get(3));// Type
																							// A078_TYPE
			WaitHelper.waitAdditional(2);

			if (elements.get(4).equals("0")) {
				getDriver().findElement(By.xpath(pObject.A078_LVL_NON)).click();// Level-None
																				// A078_LVL_NON
				WaitHelper.waitAdditional(1);
			}

			if (elements.get(4).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A078_LVL_DOC)).click();// Level-Document
																				// A078_LVL_DOC
				WaitHelper.waitAdditional(1);
			}
			if (elements.get(4).equals("2")) {
				getDriver().findElement(By.xpath(pObject.A078_LVL_LIN)).click();// Level-
																				// Line
																				// A078_LVL_LIN
				WaitHelper.waitAdditional(1);
			}

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A078_MIN_VAL)).clear();
			getDriver().findElement(By.xpath(pObject.A078_MIN_VAL)).sendKeys(elements.get(5));// Minimum
																								// Value
																								// A078_MIN_VAL

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A078_QRY_AUTH)).clear();
			getDriver().findElement(By.xpath(pObject.A078_QRY_AUTH)).sendKeys(elements.get(6));// Query
																								// Authoriser
																								// A078_QRY_AUTH

			WaitHelper.waitAdditional(1);
			if (elements.get(7).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A078_CHK_AUTH_REL_TRNSC)).click();// Auth
																							// Order
																							// Related
																							// Transaction
																							// A078_CHK_AUTH_REL_TRNSC
			}
			update = true;
		}
		return update;
	}

	/**
	 * Authorisation Group for Purchase management - A079-DBC
	 * 
	 * @param elements
	 */
	public void enterAuthorisationGroupForPM(List<String> elements) {
		log.info("Enter authorisation group for PM");
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(0));// Authorisation
																							// Group
																							// A079_AUTH_GRP

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
	}

	/**
	 * Authorisation Group for Accounts Payable - A079-GOC
	 * 
	 * @param elements
	 */
	public void enterAuthorisationGroupForAP(List<String> elements) {
		log.info("Enter authorisation group for AP");
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(0));// Authorisation
																							// Group
																							// A079_AUTH_GRP

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
	}

	/**
	 * Authorisation Control Details For PM - A080-DBA
	 * 
	 * @param elements
	 */
	public boolean enterAuthorisationControlDetailsForPM(List<String> elements) {
		log.info("Inside authorisation control details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(elements.get(0));// Authorisation
																								// Control
																								// Code
																								// A078_AUTH_CNTRL_CD
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																									// A002_DESCRIPTION
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A080_MEHOD)).sendKeys(elements.get(2));// Method
																							// A080_MEHOD

			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A080_TYPE)).sendKeys(elements.get(3));// Type
																							// A080_TYPE
			WaitHelper.waitAdditional(1);

			if (elements.get(4).equals("0")) {
				getDriver().findElement(By.xpath(pObject.A078_LVL_NON)).click();// Level-None
																				// A078_LVL_NON
				WaitHelper.waitAdditional(1);
			}

			if (elements.get(4).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A078_LVL_DOC)).click();// Level-Document
																				// A078_LVL_DOC
				WaitHelper.waitAdditional(1);
			}
			if (elements.get(4).equals("2")) {
				getDriver().findElement(By.xpath(pObject.A078_LVL_LIN)).click();// Level-
																				// Line
																				// A078_LVL_LIN
				WaitHelper.waitAdditional(1);
			}

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A078_MIN_VAL)).clear();
			getDriver().findElement(By.xpath(pObject.A078_MIN_VAL)).sendKeys(elements.get(5));// Minimum
																								// Value
																								// A078_MIN_VAL

			WaitHelper.waitAdditional(1);
			if (!elements.get(6).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A078_QRY_AUTH)).clear();
				getDriver().findElement(By.xpath(pObject.A078_QRY_AUTH)).sendKeys(elements.get(6));// Query
																									// Authoriser
																									// A078_QRY_AUTH
			}

			if (elements.get(7).equals("0")) {
				getDriver().findElement(By.xpath(pObject.A080_AUT_AMD_NA)).click();// Authorisation-
																					// Not
																					// Applicable
																					// A080_AUT_AMD_NA
				WaitHelper.waitAdditional(1);
			}

			if (elements.get(7).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A080_AUT_AMD_NON)).click();// Authorisation-None
																					// A080_AUT_AMD_NON
				WaitHelper.waitAdditional(1);
			}
			if (elements.get(7).equals("2")) {
				getDriver().findElement(By.xpath(pObject.A080_AUT_AMD_KEYONLY)).click();// Authorisation-Key
																						// Fields
																						// Only
																						// A080_AUT_AMD_KEYONLY
				WaitHelper.waitAdditional(1);
			}

			if (elements.get(7).equals("3")) {
				getDriver().findElement(By.xpath(pObject.A080_AUT_AMD_ALWAYS)).click();// Authorisation-Always
																						// A080_AUT_AMD_ALWAYS
				WaitHelper.waitAdditional(1);
			}

			WaitHelper.waitAdditional(1);

			if (elements.get(8).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A080_CHK_SITE)).click();// Site
																					// A080_CHK_SITE
			}
			WaitHelper.waitAdditional(1);

			if (elements.get(9).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A080_CHK_DOC_TYP)).click();// Document
																					// Type
																					// A080_CHK_DOC_TYP
			}
			WaitHelper.waitAdditional(1);
			if (elements.get(10).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A080_CHK_DOC_CD)).click();// Document
																					// Code
																					// A080_CHK_DOC_CD
			}
			WaitHelper.waitAdditional(1);
			if (elements.get(11).equals("1")) {
				getDriver().findElement(By.xpath(pObject.A080_CHK_BUYER)).click();// Buyer
																					// A080_CHK_BUYER
			}
			update = true;
		}
		return update;
	}

	/**
	 * Authorisation Groupings Details FOR PM - A081
	 * 
	 * @param elements
	 */
	public boolean enterAuthorisationGroupingsDetails(List<String> elements) {
		log.info("Inside authorisation grouping details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(elements.get(5));// Authorisation
																								// Control
																								// Code
																								// A078_AUTH_CNTRL_CD

		getDriver().findElement(By.xpath(pObject.A061_LOC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A061_LOC)).sendKeys(elements.get(0));// Location
																						// A061_LOC

		getDriver().findElement(By.xpath(pObject.A081_DOC_TYP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A081_DOC_TYP)).sendKeys(elements.get(1));// Document
																							// Type
																							// A081_DOC_TYP

		getDriver().findElement(By.xpath(pObject.A081_DOC_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A081_DOC_CD)).sendKeys(elements.get(2));// Document
																							// Code
																							// A081_DOC_CD
		getDriver().findElement(By.xpath(pObject.A081_DOC_CD)).sendKeys(Keys.ENTER);// Document
																					// Code
																					// A081_DOC_CD
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			if (!elements.get(3).equals("NILL")) {
				getDriver().findElement(By.xpath(pObject.A081_BUYER)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A081_BUYER)).sendKeys(elements.get(3));// Buyer
																								// A081_BUYER
			}
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(4));// Authorisation
																								// Group
																								// A079_AUTH_GRP

			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(6));// Grouping
																									// Description
																									// A002_DESCRIPTION
			update = true;
		}
		return update;
	}

	/**
	 * Authorisation Structure For AP - A082-GOP
	 * 
	 * @param elements
	 */
	public void enterAuthorisationStructureForAP(List<String> elements) {
		log.info("Enter authorisation structure for AP");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).sendKeys(elements.get(0));// Authorisation
																								// Structure
																								// A082_AUTH_STRUC

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
	}

	/**
	 * Authorisation Structure For PM - A082-DBP
	 * 
	 * @param elements
	 */
	public void enterAuthorisationStructureForPM(List<String> elements) {
		log.info("Enter authorisation structure for AP");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).sendKeys(elements.get(0));// Authorisation
																								// Structure

		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(1));// Description
																								// A002_DESCRIPTION
	}

	/**
	 * Structure Authorisor For AP - A083-GOS
	 * 
	 * @param elements
	 */
	public void enterStructureAuthorisorForAP(List<String> elements) {
		log.info("Inside authorisor for AP method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).sendKeys(elements.get(0));// Authorisation
																								// Structure
																								// A082_AUTH_STRUC

		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).sendKeys(elements.get(1));// User
																								// LOGIN_USER_NAME
		WaitHelper.waitAdditional(1);

		if (!elements.get(2).equals("NILL")) {
			getDriver().findElement(By.xpath(pObject.A083_PRNT_USR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A083_PRNT_USR)).sendKeys(elements.get(2));// Parent
																								// User
																								// A083_PRNT_USR
		}
		getDriver().findElement(By.xpath(pObject.A083_RATNG)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A083_RATNG)).sendKeys(elements.get(3));// Rating
																						// A083_RATNG
	}

	/**
	 * Structure Authorisor For PM - A083-DBS
	 * 
	 * @param elements
	 */
	public void enterStructureAuthorisorForPM(List<String> elements) {
		log.info("Inside authorisation for PM method");

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).sendKeys(elements.get(0));// Authorisation
																								// Structure
																								// A082_AUTH_STRUC

		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).sendKeys(elements.get(1));// User
																								// LOGIN_USER_NAME
		WaitHelper.waitAdditional(1);

		if (!elements.get(2).equals("NILL")) {
			getDriver().findElement(By.xpath(pObject.A083_PRNT_USR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A083_PRNT_USR)).sendKeys(elements.get(2));// Parent
																								// User
																								// A083_PRNT_USR
		}
		if (!elements.get(3).equals("NILL")) {
			getDriver().findElement(By.xpath(pObject.A083_RATNG)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A083_RATNG)).sendKeys(elements.get(3));// Rating
																							// A083_RATNG
		}
	}

	/**
	 * Authorisation Value PM - A084-DBE
	 * 
	 * @param elements
	 */
	public boolean enterAuthorisationValuePM(List<String> elements) {
		log.info("Inside Authorisation Value for PM");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).sendKeys(elements.get(0));// Value
																							// Level
																							// A084_VAL_LVL
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).sendKeys(Keys.ENTER);// Value
																						// Level
																						// A084_VAL_LVL
		WaitHelper.waitAdditional(2);
		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A084_VAL)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A084_VAL)).sendKeys(elements.get(1));// Value
																							// A084_VAL

			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(2));// Description
																									// A002_DESCRIPTION
			update = true;
		}
		return update;
	}

	/**
	 * Authorisation Value AP - A084-GOE
	 * 
	 * @param elements
	 */
	public boolean enterAuthorisationValueAP(List<String> elements) {
		log.info("Inside Authorisation Value for AP method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).sendKeys(elements.get(0));// Value
																							// Level
																							// A084_VAL_LVL
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).sendKeys(Keys.ENTER);// Value
																						// Level
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A084_VAL1)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A084_VAL1)).sendKeys(elements.get(1));// Value
																							// A084_VAL1

			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(elements.get(2));// Description
																									// A002_DESCRIPTION
			update = true;
		}
		return update;
	}

	/**
	 * Value Level Auth For AP - A085-GOG
	 * 
	 * @param elements
	 */
	public boolean enterValueLevelAuthForAP(List<String> elements) {
		log.info("Inside authorisation by value method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(0));// Authorisation
																							// Group
																							// A079_AUTH_GRP

		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).sendKeys(elements.get(1));// Value
																							// A084_VAL_LVL
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).sendKeys(Keys.ENTER);// Value
																						// A084_VAL_LVL
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).clear();
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).sendKeys(elements.get(2));// Minimum
																								// Authorisers
																								// A085_MIN_AUTH

			WaitHelper.waitAdditional(2);
			int users = Integer.parseInt(elements.get(2));
			int j = 3;
			for (int i = 1; i <= users; i++) {
				WaitHelper.waitAdditional(3);
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// User
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input"))
						.sendKeys(elements.get(j));// User

				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);// User

				WaitHelper.waitAdditional(4);
				j++;
			}
			update = true;
		}
		return update;
	}

	public void searcValueLevel(List<String> elements) {
		log.info("Search value level");
		WaitHelper.waitAdditional(3);
		if (!isOkButtonDisplayed(2)) {
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ZERO)).sendKeys(elements.get(0));// Company
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.ONE)).sendKeys(elements.get(1));// Auth
																								// group
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.THREE)).sendKeys(elements.get(2));// Value
																								// level
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_ + pObject.TWO + pObject.LABEL)).click();
	}

	/**
	 * Value Level Auth For PM - A085-DBG
	 * 
	 * @param elements
	 */

	public boolean enterValueLevelAuthForPM(List<String> elements) {
		log.info("Inside authorisation by value method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(0));// Authorisation
																							// Group
																							// A079_AUTH_GRP

		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).sendKeys(elements.get(1));// Value
																							// A084_VAL_LVL
		getDriver().findElement(By.xpath(pObject.A084_VAL_LVL)).sendKeys(Keys.ENTER);// Value
																						// A084_VAL_LVL
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).clear();
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).sendKeys(elements.get(2));// Minimum
																								// Authorisers
																								// A085_MIN_AUTH
			WaitHelper.waitAdditional(2);

			int users = Integer.parseInt(elements.get(2));
			int j = 3;
			for (int i = 1; i <= users; i++) {
				WaitHelper.waitAdditional(3);
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// User
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input"))
						.sendKeys(elements.get(j));// User
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);// User

				WaitHelper.waitAdditional(4);// Need to check
				j++;
			}
			update = true;
		}
		return update;
	}

	/**
	 * GL Responsibility Auth For AP - A086-GOI
	 * 
	 * @param elements
	 */

	public boolean enterGLResponsibilityAuthForAP(List<String> elements) {
		log.info("Inside GL responsibility method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(0));// Authorisation
																							// Group
																							// A079_AUTH_GRP

		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(1));// Element
																							// A029_ELEMENT
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(Keys.ENTER);// Element
																						// A029_ELEMENT
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).clear();
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).sendKeys(elements.get(2));// Minimum
																								// Authorisers
																								// A085_MIN_AUTH
			WaitHelper.waitAdditional(2);

			int users = Integer.parseInt(elements.get(2));
			int j = 3;

			for (int i = 1; i <= users; i++) {
				WaitHelper.waitAdditional(2);
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// User
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input"))
						.sendKeys(elements.get(j));// User
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);// User

				WaitHelper.waitAdditional(4);
				j++;
			}
			update = true;
		}
		return update;
	}

	/**
	 * Authorisation by Level/GL Responsibility for Accounts Payable - A087-GOK
	 * 
	 * @param elements
	 * @param l1Users
	 * @param l2Users
	 * @param l3Users
	 * @param l4Users
	 */

	public void enterAuthorisationByLevelOrGLResponsibilityForAP(List<String> elements, List<String> Level1,
			List<String> Level2, List<String> Level3, List<String> Level4) {
		log.info("In authorisation by Level Or GL responsibility for AP method");

		for (int i = 1; i <= 5; i++) {

			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(0));// Authorisation
																								// Group
																								// A079_AUTH_GRP

			getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(i));// Element
			getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(Keys.ENTER);// Element

			WaitHelper.waitAdditional(1);

			AddAuthorisers(Level1, 1);
			AddAuthorisers(Level2, 2);
			AddAuthorisers(Level3, 3);
			AddAuthorisers(Level4, 4);

		}
	}

	private void AddAuthorisers(List<String> Level, int i) {

		log.info("Adding Value Level and Minimum Authorization");

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(Level.get(0));
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();// Min
																							// Authorisers
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();// Min
																							// Authorisers
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(Level.get(1));
		getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);

		addUsers(Level, i);

	}

	private void addUsers(List<String> users, int i) {
		log.info("Adding users");
		WaitHelper.waitAdditional(1);

		clickOnAuthorisors();

		if (isToolTipDisplayed()) {
			clickOnAcceptWarnings();

			getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[5]")).click();
			clickOnAuthorisors();
		}

		WaitHelper.waitAdditional(4);
		getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).sendKeys(users.get(1));// Min
																						// Authorisers
																						// A085_MIN_AUTH
		getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);

		int userCount = Integer.parseInt(users.get(1));

		int k = 2;
		for (int j = 1; j <= userCount; j++)

		{
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath("//div[" + j + "]/table/tbody/tr/td[2]")).click();
			getDriver().findElement(By.xpath("//div[" + j + "]/table/tbody/tr/td[2]/input")).sendKeys(users.get(k));
			getDriver().findElement(By.xpath("//div[" + j + "]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);

			WaitHelper.waitAdditional(3);
			k++;
		}

		clickOnUpdate();
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on authorisors
	 */

	public void clickOnAuthorisors() {
		log.info("Click on Authorisors button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Authorisors")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Verify authorisors button
	 * 
	 * @return
	 */
	public boolean isAuthorisorsButtonVisible() {
		log.info("Verify presence of Authorisors button");
		boolean visible = false;
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Authorisors")) {
				visible = true;
				break;
			}
		}
		WaitHelper.waitAdditional(2);
		return visible;
	}

	/**
	 * Value/GL Responsibility For AP - A088-GON
	 * 
	 * @param elements
	 */

	public boolean enterValueORGLResponsibilityForAP(List<String> elements) {
		log.info("Inside GL responsibility of AP method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A079_AUTH_GRP)).sendKeys(elements.get(0));// Authorisation
																							// Group
																							// A079_AUTH_GRP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elements.get(1));// Element
																							// A029_ELEMENT
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(Keys.ENTER);// Element
																						// A029_ELEMENT
		WaitHelper.waitAdditional(2);

		if (!getToolContentText().contains(message)) {
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).sendKeys(elements.get(2));// Minimum
																								// Authorisers
																								// A085_MIN_AUTH
			getDriver().findElement(By.xpath(pObject.A085_MIN_AUTH)).sendKeys(Keys.ENTER);
			WaitHelper.waitAdditional(3);

			int userCount = Integer.parseInt(elements.get(3));

			int j = 4;
			for (int i = 1; i <= userCount; i++) {
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]")).click();// User
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[2]/input"))
						.sendKeys(elements.get(j));// User
				WaitHelper.waitAdditional(2);
				j = j + 1;
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).click();// Authorization
																									// Value
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]/input"))
						.sendKeys(elements.get(j));// Value
				WaitHelper.waitAdditional(2);
				getDriver().findElement(By.xpath("//div[" + i + "]/table/tbody/tr/td[3]")).sendKeys(Keys.ENTER);// Value
				WaitHelper.waitAdditional(2);
				j++;
				WaitHelper.waitAdditional(2);
			}
			update = true;
		}
		return update;
	}

	/**
	 * AP Company Control - A089
	 * 
	 * @param elements
	 */
	public void editAPCompanyControl(List<String> elements) {
		log.info("Edit AP company control details");
		WaitHelper.waitAdditional(2);

		ClickOnAnyTab("Authorisation/VAT", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(elements.get(0));// Code
																								// A078_AUTH_CNTRL_CD

		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).sendKeys(elements.get(1));// Structure
																								// A082_AUTH_STRUC

		getDriver().findElement(By.xpath(pObject.A089_AUTH_CMPY_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A089_AUTH_CMPY_STRUC)).sendKeys(elements.get(2));// Company
																									// Structure
																									// A089_AUTH_CMPY_STRUC

		getDriver().findElement(By.xpath(pObject.A089_AUTH_STRUC_PTH)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A089_AUTH_STRUC_PTH)).sendKeys(elements.get(3));// Structure
																									// Path
																									// A089_AUTH_STRUC_PTH

		WaitHelper.waitAdditional(1);

		if (!getDriver().findElement(By.xpath(pObject.A056_CHK_USE_VAT_ANLS)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A056_CHK_USE_VAT_ANLS)).click();// A056_CHK_USE_VAT_ANLS
		}

		WaitHelper.waitAdditional(1);

		if (!elements.get(4).equals("NILL")) {

			getDriver().findElement(By.xpath(pObject.A056_COD_IDNT)).clear(); // A056_COD_IDNT
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A056_COD_IDNT)).sendKeys(elements.get(4));// Code
																								// Identifier
																								// A056_COD_IDNT
		}
		WaitHelper.waitAdditional(3);
		if (!elements.get(5).equals("NILL")) {
			getDriver().findElement(By.xpath(pObject.A056_PSTNG_TYPE)).sendKeys(elements.get(5));// Posting
																									// Type
																									// A056_PSTNG_TYPE
		}
	}

	/**
	 * Amend PM Company Control - A090- DAG
	 * 
	 * @param elements
	 */
	public void editPMCompanyControl(List<String> elements) {
		log.info("Edit PM company control detais");
		WaitHelper.waitAdditional(2);

		ClickOnAnyTab("Data Entry", 1);
		log.info("Enter Data Entry Tab, Authorization Section Details");
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(elements.get(0));// Control
																								// Code
																								// A078_AUTH_CNTRL_CD

		getDriver().findElement(By.xpath(pObject.A089_AUTH_CMPY_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A089_AUTH_CMPY_STRUC)).sendKeys(elements.get(1));// Company
																									// structure
																									// A089_AUTH_CMPY_STRUC

		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A082_AUTH_STRUC)).sendKeys(elements.get(2));// Default
																								// structure
																								// A082_AUTH_STRUC

		getDriver().findElement(By.xpath(pObject.A078_AUTH_CD_ID)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CD_ID)).sendKeys(elements.get(3));// Code
																								// id
																								// A078_AUTH_CD_ID
	}

	/**
	 * Edit document code- A090-DAI
	 * 
	 * @param elements
	 */
	public void editDocumentCodes(String elements) {
		log.info("Edit/Amend document code details");

		ClickOnAnyTab("Miscellaneous", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(elements);// Control
																							// Code
																							// A078_AUTH_CNTRL_CD
	}

	/**
	 * Set Up Suppliers - A091-PBA
	 * 
	 * @param elements
	 */

	public void enterSupplierListDetail(List<String> elements) {
		log.info("Enter supplier details");
		WaitHelper.waitAdditional(2);

		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.A091_SUPP)));// Chetna
																													// Wait
																													// Added
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A091_SUPP)).sendKeys(elements.get(0));// Supplier
																						// A091_SUPP

		getDriver().findElement(By.xpath(pObject.A091_NAME)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A091_NAME)).sendKeys(elements.get(1));// Name
																						// A091_NAME

		getDriver().findElement(By.xpath(pObject.A091_SRT_NAME)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A091_SRT_NAME)).sendKeys(elements.get(2));// Short
																							// name
																							// A091_SRT_NAME
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A091_TYP_SUPP)).click();// Supplier
																			// A091_TYP_SUPP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).clear();
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(elements.get(3));// Currency
																							// A002_CURRENCY
		WaitHelper.waitAdditional(2);

		enterSupplierAddress(elements);
		enterSupplierPurchasingControl(elements);
		enterSupplierTaxDetails(elements);
		enterSupplierLedgerControlDetails(elements);
		enterPOPControlDetails();
	}

	/**
	 * Enter supplier address-A091-PBA
	 * 
	 * @param elements
	 */
	public void enterSupplierAddress(List<String> elements) {
		log.info("Enter suppler address details");
		WaitHelper.waitAdditional(2);

		clickOnAddress();// Address
		WaitHelper.waitAdditional(5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();// Address
																					// number
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(4));// Address
																											// number
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(5));// Address
																											// line
																											// 1
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);// Address
																									// line
																									// 1
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(6));// Address
																											// line
																											// 2
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.TAB);// Address
																									// line
																									// 2
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(7));// Address
																											// line
																											// 3
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(Keys.TAB);// Address
																									// line
																									// 3
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(8));// Address
																											// line
																											// 4
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(Keys.TAB);// Address
																									// line
																									// 4
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[10]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[10]/input")).sendKeys(elements.get(9));// post
																											// code
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[10]/input")).sendKeys(Keys.TAB);// post
																										// code
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[11]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[11]/input")).sendKeys(elements.get(10));// Phone
																												// Number
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[11]/input")).sendKeys(Keys.TAB);// Phone
																										// Number
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[12]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[12]/input")).sendKeys(elements.get(11));// Telex
																												// Number
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[12]/input")).sendKeys(Keys.TAB);// Telex
																										// Number
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[13]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[13]/input")).sendKeys(elements.get(12));// Fax
																												// Number
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[13]/input")).sendKeys(Keys.TAB);// Fax
																										// Number
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[14]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[14]/input")).sendKeys(elements.get(13));// Contact
																												// Name
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[14]/input")).sendKeys(Keys.ENTER);// Contact
																										// Name
		WaitHelper.waitAdditional(5);

	}

	/**
	 * Enter supplier purchasing control-A091-PBA
	 * 
	 * @param elements
	 */
	private void enterSupplierPurchasingControl(List<String> elements) {

		log.info("Enter PM control details");
		WaitHelper.waitAdditional(5);
		clickOnPurControl();
		WaitHelper.waitAdditional(5);

		ClickOnAnyTab("Processing", 1);
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(elements.get(14));// Category
																							// code
																							// A017_CATEG
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Discount Defaults", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A091_DSCNT_1)).clear();
		getDriver().findElement(By.xpath(pObject.A091_DSCNT_1)).sendKeys(elements.get(15));// Discount
																							// terms
																							// A091_DSCNT_1
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).clear();
		getDriver().findElement(By.xpath(pObject.A055_SETT_TERM)).sendKeys(elements.get(16));// Settlement
																								// terms
																								// A055_SETT_TERM
		WaitHelper.waitAdditional(1.5);

		if (!getDriver().findElement(By.xpath(pObject.A091_DIS_SUPP)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A091_DIS_SUPP)).click();// Supplier
																				// discount
																				// A091_DIS_SUPP
		}
		if (!getDriver().findElement(By.xpath(pObject.A091_DIS_ALWYS_TK)).isSelected()) {
			getDriver().findElement(By.xpath(pObject.A091_DIS_ALWYS_TK)).click();// Always
																					// take
																					// A091_DIS_ALWYS_TK
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Enter supplier tax details-A091-PBA
	 * 
	 * @param elements
	 */
	private void enterSupplierTaxDetails(List<String> elements) {
		log.info("Enter supplier tax details");
		WaitHelper.waitAdditional(3);

		clickOnTax();
		WaitHelper.waitAdditional(5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(17));// Location
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.TAB);// Location
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(18));// Registration
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(Keys.TAB);// Registration
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(19));// Tax
																											// type
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.TAB);// Tax
																									// type
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(20));// Tax
																											// code
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[6]/input")).sendKeys(Keys.TAB);// Tax
																									// code
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(21));// Handling
																											// code
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[7]/input")).sendKeys(Keys.TAB);// Handling
																									// code
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[9]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[9]/input")).sendKeys(elements.get(22));// Default
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[9]/input")).sendKeys(Keys.ENTER);// Default
		WaitHelper.waitAdditional(3);

		clickOnPurControl();
		WaitHelper.waitAdditional(5);
	}

	/**
	 * Enter suppler ledger control details-A091-PBA
	 * 
	 * @param elements
	 */
	private void enterSupplierLedgerControlDetails(List<String> elements) {
		log.info("Enter AP control details");

		clickOnAPControl();
		WaitHelper.waitAdditional(5);

		ClickOnAnyTab("Supplier", 1);
		WaitHelper.waitAdditional(3);

		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).clear();
		getDriver().findElement(By.xpath(pObject.A078_AUTH_CNTRL_CD)).sendKeys(elements.get(23));// Authorisation
																									// Code
																									// A078_AUTH_CNTRL_CD
		WaitHelper.waitAdditional(1);

		getDriver().findElement(By.xpath(pObject.A091_SEF_ASS_TX)).sendKeys(elements.get(24));// Self
																								// Assessed
																								// Tax
																								// A091_SEF_ASS_TX
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath(pObject.A091_TNVR)).sendKeys(elements.get(25));// Turnover
																						// A091_TNVR
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath(pObject.A091_INVCE_PYMNT)).sendKeys(elements.get(26));// Invoice
																								// Payment
																								// A091_INVCE_PYMNT
		WaitHelper.waitAdditional(1.5);

		ClickOnAnyTab("Payment", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A058_PYMNT_MTHD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A058_PYMNT_MTHD)).sendKeys(elements.get(27));// Method
																								// A058_PYMNT_MTHD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A060_PYMNT_COD)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A060_PYMNT_COD)).sendKeys(elements.get(28));// Code
																								// A060_PYMNT_COD
		WaitHelper.waitAdditional(2);

		ClickOnAnyTab("Retention/CR and DR", 1);
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A091_RET_NT_GRSS)).click();// Retain
																			// net
																			// A091_RET_NT_GRSS
		WaitHelper.waitAdditional(3);

	}

	/**
	 * Enter POP control details-A091-PBA
	 */
	private void enterPOPControlDetails() {
		log.info("Enter POP control details");
		WaitHelper.waitAdditional(4);
		clickOnPMControl();
		WaitHelper.waitAdditional(5);

		ClickOnAnyTab("Order Details", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A091_OR_TUNVR_NTM)).click();// Not
																				// Maintained
																				// A091_OR_TUNVR_NTM
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A091_EDI_ORD_CRET)).click();// EDI
																				// Orders
																				// A091_EDI_ORD_CRET
		WaitHelper.waitAdditional(1);

		ClickOnAnyTab("Invoice Order Matching", 1);
		WaitHelper.waitAdditional(2);

		getDriver().findElement(By.xpath(pObject.A091_MISC_INV_CHAR)).click();// Miscellaneous
																				// Invoice
																				// Charges
																				// A091_MISC_INV_CHAR
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on Address button
	 * 
	 * @param i
	 */
	public void clickOnAddress() {
		log.info("Click on Address Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for (WebElement wb : wbs) {
			if (wb.getText().equals("Address")) {
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on PUR control
	 */
	public void clickOnPurControl() {
		log.info("Click on Pur Cntrl button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Pur Cntrl")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on PM control
	 */
	public void clickOnPMControl() {
		log.info("Click on PM Cntrl button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("PM Cntrl")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on AP control
	 */
	public void clickOnAPControl() {
		log.info("Click on AP Cntrl button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("AP Cntrl")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Click on Tax
	 */
	public void clickOnTax() {
		log.info("Click on Tax button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for (WebElement wb2 : wbs1) {
			if (wb2.getText().equals("Tax")) {
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}

	/*--------------------------------PHASE-I and PHASE II METHODS ENDS HERE----------------------------------------------------------------*/

	/*--------------------------------PHASE I ADDITIONAL METHODS BY CHETNA----------------------------------------------------------------*/

	/**
	 * List of Tabs based on ClassName
	 */

	private List<WebElement> getTab() {
		return getDriver().findElements(By.className("ui-tabs-anchor"));
	}

	/**
	 * Click on Any Tab Based on Tabname and action
	 */

	public boolean ClickOnAnyTab(String TabName, int action) {
		WaitHelper.waitAdditional(2);
		boolean isDisplayed = false;
		List<WebElement> listOfTabs = getTab();
		for (WebElement tab : listOfTabs) {
			if (tab.getText().equals(TabName)) {
				if (tab.isDisplayed()) {
					if (action == 0) {
						isDisplayed = true;
					} else {
						tab.click();
						WaitHelper.waitAdditional(2);
					}

					break;
				}
			}
		}
		return isDisplayed;
	}

	/**
	 * Verify Secondary Details Tab Selected
	 * 
	 * @return true
	 */
	public boolean isSecondaryDetailsTabSelected() {
		return GetSecondaryDetailsTab().isSelected();
	}

	private WebElement GetSecondaryDetailsTab() {
		return getDriver().findElement(By.xpath(pObject.A022_SECND_TAB));
	}

	public void clickOnSecondaryDetailsTab() {

		getDriver().findElement(By.xpath(pObject.A022_SECND_TAB)).click();
	}

	/**
	 * Verify Message Toolbar displayed or not
	 */

	public boolean IsMessageToolBarDisplayed() {
		boolean messageToolBar = false;
		try {
			if (getDriver().findElement(By.xpath(pObject.AllPG_MSG_TOOLBAR)).isDisplayed()) {
				messageToolBar = true;
			}

		} catch (NoSuchElementException e) {
			messageToolBar = false;
		}
		return messageToolBar;
	}

	/**
	 * Amend Fiscal Calender
	 * 
	 */
	public boolean verifyEventsForLevel(String value)

	{
		WaitHelper.waitAdditional(2);
		log.info("Verify presence of Event value in the Row");
		boolean EventValue = false;
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_EVENT_LVL));
		for (WebElement wb : wbs) {
			if (wb.getText().contains(value))

			{
				EventValue = true;
				break;
			}
		}
		return EventValue;
	}

	public void zoomIn() {
		// To zoom In page 2 tim = 80% using CTRL and + keys.
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.ADD);
		}
	}

	public void zoomOut() {
		// To zoom out page 2 time using CTRL and - keys.
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.SUBTRACT);
			// driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,
			// Keys.SUBTRACT));
		}
	}

	// For SQL Database Related Process

	public int getProcessorCount() {
		log.info("Get process count");
		int dspatcherCnt = 0;
		try {
			dspatcherCnt = dbQuery.getProcessCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		log.info("dispatcherCount : " + dspatcherCnt);
		WaitHelper.waitAdditional(2);
		return dspatcherCnt;
	}

	public void updateHoldFlag() {
		log.info("Update Hold flag");
		try {
			dbQuery.updateHoldFlag();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(2);
		log.info("Preocess is updated.");
	}

	public String getProcessDetails(String process, String request)

	{
		log.info("Get process details");
		WaitHelper.waitAdditional(4);
		String stat = null;

		if (BaseTest.database.equals("SQL")) {
			log.info("Get process details for SQL");
			try {
				stat = dbQuery.getStatProcess(process, request);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}

		} else if (BaseTest.database.equals("Oracle"))

		{
			log.info("Get process details for Oracle");
			try {
				stat = OdbQuery.getStatProcessOracle(process, request);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}

		}

		else if (BaseTest.database.equals("PostgreSQL"))

		{
			log.info("Get process details for PostgreSQL");
			try {
				stat = PdbQuery.getStatProcessPostgreSQL(process, request);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}

		}

		log.info("stat value :" + stat);
		WaitHelper.waitAdditional(2);
		return stat;

	}

	public void updateProcess(String process, String request) {
		log.info("Update process");
		WaitHelper.waitAdditional(3);

		if (BaseTest.database.contains("SQL")) {
			log.info("Update process for SQL");

			try {
				dbQuery.updateProcess(process, request);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}

		} else if (BaseTest.database.contains("Oracle"))

		{
			log.info("Update process for Oracle");
			try {
				OdbQuery.updateProcessOracle(process, request);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}

		}

		else if (BaseTest.database.contains("PostgreSQL"))

		{

			log.info("Update process for PostgreSQL");

			try {
				PdbQuery.updateProcessPostgreSQL(process, request);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}

		}

		WaitHelper.waitAdditional(5);
		log.info("Preocess is updated.");
	}

	public void testing() {
		log.info("Testing");
		try {
			dbQuery.checkProcess();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(3);
		log.info("Preocess is updated.");

	}

	// For A035 Oracle Database Related Process

	public int getProcessorCountOracle() {
		log.info("Get process count");
		int dspatcherCnt = 0;
		try {
			dspatcherCnt = OdbQuery.getProcessCountOracle();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		log.info("dispatcherCount : " + dspatcherCnt);
		WaitHelper.waitAdditional(2);
		return dspatcherCnt;
	}

	public void updateHoldFlagOracle() {
		log.info("Update Hold flag");
		try {
			OdbQuery.updateHoldFlagOracle();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(2);
		log.info("Preocess is updated.");
	}

	public String getProcessDetailsOracle(String process, String request) {
		log.info("Get process details");
		WaitHelper.waitAdditional(5);
		String stat = null;
		try {
			stat = OdbQuery.getStatProcessOracle(process, request);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		log.info("stat value :" + stat);
		WaitHelper.waitAdditional(2);
		return stat;
	}

	public void updateProcessOracle(String process, String request) {
		log.info("Update process");
		try {
			OdbQuery.updateProcessOracle(process, request);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(3);
		log.info("Preocess is updated.");
	}

	public void testingOracle() {
		log.info("Testing");
		try {
			OdbQuery.checkProcessOracle();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(3);
		log.info("Preocess is updated.");

	}

	public boolean selectStruValue(String value)

	{
		log.info("Select Structure method");

		boolean update = false;

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A035_GLSTRUCT));
		for (WebElement wb : wbs) {
			if (wb.getText().contains(value)) {
				wb.click();
				break;

			}
			update = true;
		}

		return update;

	}

	/*--------------------------------PHASE III METHODS----------------------------------------------------------------*/

	// For AD01008_IM_Audit_Reports PostgreSQL Database Related Process

	public int getProcessorCountPostgreSQL() {
		log.info("Get process count");
		int dspatcherCnt = 0;
		try {
			dspatcherCnt = PdbQuery.getProcessCountPostgreSQL();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		log.info("dispatcherCount : " + dspatcherCnt);
		WaitHelper.waitAdditional(2);
		return dspatcherCnt;
	}

	public void updateHoldFlagPostgreSQL() {
		log.info("Update Hold flag");
		try {
			PdbQuery.updateHoldFlagPostgreSQL();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(2);
		log.info("Preocess is updated.");
	}

	public String getProcessDetailsPostgreSQL(String process, String request) {
		log.info("Get process details");
		WaitHelper.waitAdditional(5);
		String stat = null;
		try {
			stat = PdbQuery.getStatProcessPostgreSQL(process, request);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		log.info("stat value :" + stat);
		WaitHelper.waitAdditional(2);
		return stat;
	}

	public void updateProcessPostgreSQL(String process, String request) {
		log.info("Update process");

		try {
			PdbQuery.updateProcessPostgreSQL(process, request);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(5);
		log.info("Preocess is updated.");
	}

	public void testingPostgreSQL() {
		log.info("Testing");
		try {
			PdbQuery.checkProcessPostgreSQL();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(3);
		log.info("Preocess is updated.");

	}

	/*--------------------------------PHASE I ADDITIONAL METHODS BY CHETNA ENDS HERE----------------------------------------------------------------*/

	public void getUserNameTextBox() {
		log.info("Inside get username text box method");
		WaitHelper.waitAdditional(2);
		// WebElement wb =
		// getDriver().findElement(By.cssSelector("input[name='USR_field_0'][type='text']"));
		WebElement wb = getDriver()
				.findElement(By.cssSelector("input[name[contains(text(),'USR_field_0')]][type='text']"));

		wb.sendKeys("T66");

	}

	public void createLearner(String uName, String pwd) throws InterruptedException {
		getDriver().findElement(By.id("UserName")).sendKeys(uName);// "PaChand1");
		getDriver().findElement(By.id("Password")).sendKeys(pwd);// ("299@CaP010458");
		getDriver().findElement(By.id("loginbtn")).click();
		Thread.sleep(3000);
	}

	public void createLearner12() throws InterruptedException {

		getDriver().get("https://perf.progresso.net/LearnerRecord/LearnerList");
		getDriver().findElement(By.linkText("Add")).click();
		Thread.sleep(1000);

		for (int i = 70; i <= 100; i++) {

			// driver.get("https://perf.progresso.net/LearnerRecord/LearnerList");
			// driver.findElement(By.linkText("Add")).click();

			getDriver().findElement(By.id("ETS2001")).sendKeys("abc");
			getDriver().findElement(By.id("ETS2004")).sendKeys("efg");
			getDriver().findElement(By.id("ETS2007")).sendKeys("14512" + i);
			getDriver().findElement(By.id("ETS2003")).sendKeys("13/08/2000");

			getDriver().findElement(By.xpath(".//*[@id='dvActionbtnArea']/div[3]/div[2]")).click();
			Thread.sleep(2000);

			getDriver().findElement(By.id("okatag")).click();
			Thread.sleep(2000);

			getDriver().findElement(By.xpath(".//*[@id='fourthNavItemPersonal']/div[2]/a")).click();
			Thread.sleep(2000);

			WebElement gender = getDriver().findElement(By.id("ETS3017"));
			Select selectgender = new Select(gender);
			selectgender.selectByVisibleText("Female");

			getDriver().findElement(By.id("SectionHeader3")).click();

			getDriver().findElement(By.id("ETS3025")).sendKeys("05/09/2011");

			WebElement course = getDriver().findElement(By.id("ETS3028"));
			Select selectcourse = new Select(course);
			selectcourse.selectByVisibleText("Key Stage 4");
			Thread.sleep(2000);

			WebElement year = getDriver().findElement(By.id("ETS3030"));
			Select selectyear = new Select(year);
			selectyear.selectByVisibleText("Year 10");
			Thread.sleep(2000);

			WebElement ncyear = getDriver().findElement(By.id("ETS3026"));
			Select selectNCyear = new Select(ncyear);
			selectNCyear.selectByVisibleText("Year 10");
			Thread.sleep(2000);

			getDriver().findElement(By.xpath(".//*[@id='dvActionbtnArea']/div[3]/div[2]")).click();
			Thread.sleep(2000);

			getDriver().findElement(By.id("okatag")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='modalcontent']/div/div[2]/div/div[1]/div[2]/a")).click();
			Thread.sleep(2000);

			getDriver().findElement(By.id("okatag")).click();

			Thread.sleep(2000);
			getDriver().findElement(By.linkText("Add")).click();
		}
	}

	public void createLearner45() throws InterruptedException {

		getDriver().get("https://perf.progresso.net/LearnerRecord/LearnerList");
		getDriver().findElement(By.linkText("Add")).click();
		Thread.sleep(1000);

		for (int i = 70; i <= 100; i++) {

			// driver.get("https://perf.progresso.net/LearnerRecord/LearnerList");
			// driver.findElement(By.linkText("Add")).click();

			getDriver().findElement(By.id("ETS2001")).sendKeys("xcbc");
			getDriver().findElement(By.id("ETS2004")).sendKeys("efg");
			getDriver().findElement(By.id("ETS2007")).sendKeys("14542" + i);
			getDriver().findElement(By.id("ETS2003")).sendKeys("13/08/2000");

			getDriver().findElement(By.xpath(".//*[@id='dvActionbtnArea']/div[3]/div[2]")).click();
			Thread.sleep(2000);

			getDriver().findElement(By.id("okatag")).click();
			Thread.sleep(2000);

			getDriver().findElement(By.xpath(".//*[@id='fourthNavItemPersonal']/div[2]/a")).click();
			Thread.sleep(2000);

			// getDriver().findElement(By.id("ETS3001")).sendKeys("xcbcz");
			// Thread.sleep(2000);

			WebElement gender = getDriver().findElement(By.id("ETS3017"));
			Select selectgender = new Select(gender);
			selectgender.selectByVisibleText("Female");

			Thread.sleep(1000);

			getDriver().findElement(By.id("SectionHeader3")).click();
			Thread.sleep(1000);

			getDriver().findElement(By.id("ETS3025")).sendKeys("05/09/2011");
			Thread.sleep(1000);

			WebElement course = getDriver().findElement(By.id("ETS3028"));
			Select selectcourse = new Select(course);
			selectcourse.selectByVisibleText("Key Stage 4");
			Thread.sleep(2000);

			WebElement year = getDriver().findElement(By.id("ETS3030"));
			Select selectyear = new Select(year);
			selectyear.selectByVisibleText("Year 10");
			Thread.sleep(2000);

			WebElement ncyear = getDriver().findElement(By.id("ETS3026"));
			Select selectNCyear = new Select(ncyear);
			selectNCyear.selectByVisibleText("Year 10");
			Thread.sleep(2000);

			getDriver().findElement(By.xpath(".//*[@id='dvActionbtnArea']/div[3]/div[2]")).click();
			Thread.sleep(2000);

			getDriver().findElement(By.id("okatag")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='modalcontent']/div/div[2]/div/div[1]/div[2]/a")).click();
			Thread.sleep(2000);

			getDriver().findElement(By.id("okatag")).click();

			Thread.sleep(2000);
			getDriver().findElement(By.linkText("Add")).click();
		}
	}
}
