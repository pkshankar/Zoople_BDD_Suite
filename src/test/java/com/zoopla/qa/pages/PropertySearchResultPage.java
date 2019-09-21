package com.zoopla.qa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.TestBase.TestBase;
import com.zoopla.qa.testdata.TestData;
import com.zoopla.qa.util.TestUtil;


public class PropertySearchResultPage extends TestBase {

	/* OBJECT REPOSITORY */

	@FindBy(xpath = "//input[@id='search-input-location']")
	private WebElement citySearchBox;

	@FindBy(xpath = "//button[@id='search-submit']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[text()='Filter results']/parent::div/following::ul[@data-role='listview']//descendant::div[@class='listing-results-right clearfix']/a")
	private static List<WebElement> wPropertyPriceList;

	@FindBy(xpath = "//img[@class=' lazy']")
	WebElement obsElement;

	public PropertySearchResultPage() {

		PageFactory.initElements(driver, this);
	}

	/* ACTIONS */

	public void enterCityName() {

		TestUtil.sendKeys(citySearchBox, TestData.cityName);
	}

	public ArrayList<Integer> getPropertyPriceList() {

		ArrayList<Integer> alPropertyPrice = new ArrayList<Integer>();

		for (WebElement wElement : wPropertyPriceList) {

			alPropertyPrice.add(Integer.parseInt(wElement.getText().replaceAll("[^0-9]", "").trim()));

		}

		return alPropertyPrice;
	}

	public void selectFifthProperty() {

		//TestUtil.explicitWait(obsElement, 10);

		wPropertyPriceList.get(TestData.propertyToSelect).click();

	}

}
