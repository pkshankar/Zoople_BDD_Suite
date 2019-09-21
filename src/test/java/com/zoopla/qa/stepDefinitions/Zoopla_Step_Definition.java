package com.zoopla.qa.stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Assert;
import com.zoopla.qa.TestBase.TestBase;
import com.zoopla.qa.pages.AgentPage;
import com.zoopla.qa.pages.PropertyDetailPage;
import com.zoopla.qa.pages.PropertySearchResultPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class Zoopla_Step_Definition extends TestBase {

	PropertySearchResultPage propertySearchResultPage;
	PropertyDetailPage propertyDetailPage;
	AgentPage agentPage;

	@Before(order = 0)
	public void setUp() {

		TestBase.initialization();

	}

	@After
	public void tearDown() {

		 driver.quit();
	}

	/* TAGGED HOOKS */
	@Before({
			"@AgentNameOnPropDetailPage, @AgentLogoOnPropDetailPage, @SelectFifthProp, @AgentPhoneNoOnPropDetailPage" })
	public void enter_City_Name() {

		propertySearchResultPage = new PropertySearchResultPage();
		propertyDetailPage = new PropertyDetailPage();
		propertySearchResultPage.enterCityName();
	}

	@Before({ "@AgentName, @AgentPhoneNo" })
	public void before_Scenario() {

		propertySearchResultPage = new PropertySearchResultPage();
		propertyDetailPage = new PropertyDetailPage();
		agentPage = new AgentPage();
		propertySearchResultPage.enterCityName();
		propertySearchResultPage.selectFifthProperty();

	}

	@Then("^user enters the city name and clicks enter$")
	public void user_enters_the_city_name_and_clicks_enter() {

		propertySearchResultPage = new PropertySearchResultPage();
		propertySearchResultPage.enterCityName();
	}

	@Then("^user sorts the price list in descending order and prints on console$")
	public void user_sorts_the_arraylist_in_descending_order_and_prints_on_console() {

		propertySearchResultPage = new PropertySearchResultPage();
		ArrayList<Integer> al = propertySearchResultPage.getPropertyPriceList();
		Collections.sort(al, Collections.reverseOrder());
		System.out.println(al);

	}

	/***************************************************************************************************************/

	@Then("^user clicks on fifth property in the list$")
	public void user_clicks_on_fifth_property_in_the_list() {

		propertySearchResultPage.selectFifthProperty();

	}

	@Then("^user validates that agent logo is displayed$")
	public void user_validates_that_agent_logo_is_displayed() {

		propertySearchResultPage.selectFifthProperty();
		Assert.assertTrue(propertyDetailPage.isAgentLogoDisplayed());

	}

	@Then("^user validates that agent name is displayed$")
	public void user_validates_that_agent_name_is_displayed() {

		propertySearchResultPage.selectFifthProperty();
		Assert.assertTrue(propertyDetailPage.getAgentName().isDisplayed());

	}

	@Then("^user validates that agent phone no is displayed$")
	public void user_validates_that_agent_phone_no_is_displayed() {

		propertySearchResultPage.selectFifthProperty();
		Assert.assertTrue(propertyDetailPage.getAgentPhoneNo().isDisplayed());

	}

	@Then("^user validates that correct agent name is displayed$")
	public void user_validates_that_correct_agent_name_is_displayed() {

		String aNameExp = propertyDetailPage.getAgentName().getText();
		propertyDetailPage.clickAgentName();
		Assert.assertEquals(agentPage.getAgentNameAgentPage(), aNameExp);

	}

	@Then("^user validates that correct agent phone is displayed$")
	public void user_validates_that_correct_agent_phone_is_displayed() {

		String aPhoneNoExp = propertyDetailPage.getAgentPhoneNo().getText();
		propertyDetailPage.clickAgentName();
		Assert.assertEquals(agentPage.getAgentPhoneNoAgentPage().replaceAll("[^0-9]", ""),
				aPhoneNoExp.replaceAll("[^0-9]", ""));

	}

}
