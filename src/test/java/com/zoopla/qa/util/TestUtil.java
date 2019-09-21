package com.zoopla.qa.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zoopla.qa.TestBase.TestBase;

public class TestUtil extends TestBase {

	public static Properties writeProp;

	public static void sendKeys(WebElement inputBox, String textToEnter) {

		inputBox.sendKeys(textToEnter, Keys.ENTER);

	}

	public static void explicitWait(WebElement wElement, long waitTime) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		System.out.println(wElement.getText());
		wait.until(ExpectedConditions.invisibilityOf(wElement));
	}

//	public static void writeToProperties(String aName, String aPhoneNo) {
//
//		try {
//
//			FileOutputStream fos = new FileOutputStream(
//					"C:\\Users\\pkshank\\eclipse-workspace\\Zoople_BDD_Suite\\src\\test\\java\\com\\zoopla\\qa\\config\\agentDetails.properties");
//
//			writeProp = new Properties();
//			writeProp.setProperty("AGENT_NAME", aName);
//			writeProp.setProperty("AGENT_PHONE_NO", aPhoneNo);
//			writeProp.store(fos, null);
//
//		} catch (
//
//		FileNotFoundException e) {
//
//			e.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//	}

}