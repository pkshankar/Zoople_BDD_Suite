package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.TestBase.TestBase;

public class PropertyDetailPage extends TestBase {

	@FindBy(xpath = "(//div[@class='ui-agent__logo']/img)[1]")
	private WebElement agentLogo;

	@FindBy(xpath = "(//h4[@class='ui-agent__name'])[1]")
	private WebElement agentName;

	@FindBy(xpath = "//a[@data-track-label='Agent phone number 1']")
	private WebElement agentPhoneNo;

	public PropertyDetailPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean isAgentLogoDisplayed() {

		return agentLogo.isDisplayed();
	}

	public WebElement getAgentName() {

		return agentName;
	}

	public WebElement getAgentPhoneNo() {

		return agentPhoneNo;
	}

	public AgentPage clickAgentName() {

		agentName.click();
		return new AgentPage();
	}

}
