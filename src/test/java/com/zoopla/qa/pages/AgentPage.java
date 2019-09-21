package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.TestBase.TestBase;

public class AgentPage extends TestBase {

	@FindBy(xpath = "(//div[@class='main-content-area clearfix wrap']/descendant::b)[1]")
	private WebElement agentNameAgentPage;

	@FindBy(xpath = "//span[@class='agent_phone']/a")
	private WebElement agentPhoneAgentPage;

	public AgentPage() {

		PageFactory.initElements(driver, this);
	}

	public String getAgentNameAgentPage() {

		return agentNameAgentPage.getText();
	}

	public String getAgentPhoneNoAgentPage() {

		return agentPhoneAgentPage.getText().replaceAll("\\+44", "0");
	}

}
