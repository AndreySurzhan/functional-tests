package org.jtalks.tests.jcommune.pages;

import org.jtalks.tests.jcommune.common.JCommuneSeleniumTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.getApplicationContextPath;

/**
 * @autor masyan
 */
public class LogOutPage {

	public static final String logOutButtonSel = "//a[@href='" + JCommuneSeleniumTest.contextPath + "/logout']";

	@FindBy(xpath = logOutButtonSel)
	private WebElement logOutButton;


	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getters
	public WebElement getLogOutButton() {
		return logOutButton;
	}

}