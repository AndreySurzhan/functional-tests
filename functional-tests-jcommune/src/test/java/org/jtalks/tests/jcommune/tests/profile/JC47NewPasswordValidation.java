package org.jtalks.tests.jcommune.tests.profile;

import org.jtalks.tests.jcommune.pages.ProfilePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.jtalks.tests.jcommune.assertion.Exsistence.assertionExistById;
import static org.jtalks.tests.jcommune.assertion.Exsistence.assertionNotExistById;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.driver;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.logOut;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.profilePage;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.signIn;


/**
 * @author: erik
 * Date: 09.03.12
 * Time: 15:32
 */
public class JC47NewPasswordValidation {

	String currentPassword;
	String tooShortPassword;
	String tooLongPassword;
	String newPassword;

	@BeforeMethod(alwaysRun = true)
	@Parameters({"app-url", "uUsername", "uPassword"})
	public void setupCase(String appUrl, String username, String password) {

		currentPassword = password;
		tooLongPassword = "passgreaterthan20chaw";
		tooShortPassword = "new";
		newPassword = "new4";

		driver.get(appUrl);
		signIn(username, password);
		profilePage.getCurrentUserLink().click();
		profilePage.getEditProfileButton().click();
	}

	@AfterMethod(alwaysRun = true)
	@Parameters({"app-url"})
	public void destroy(String appUrl) {
		logOut(appUrl);
	}

	@Test
	public void newPasswordValidationTest() {
		profilePage.getNewPasswordField().sendKeys(tooShortPassword);
		profilePage.getSaveEditButton().click();
		assertionExistById(driver, ProfilePage.errorNewUserPasswordMessageIdSel);
		assertionExistById(driver, ProfilePage.errorNewUserPasswordConfirmMessageIdSel);


		profilePage.getNewPasswordField().clear();
		profilePage.getNewPasswordField().sendKeys(tooLongPassword);
		profilePage.getSaveEditButton().click();
		assertionExistById(driver, ProfilePage.errorNewUserPasswordMessageIdSel);
		assertionExistById(driver, ProfilePage.errorNewUserPasswordConfirmMessageIdSel);

		profilePage.getNewPasswordField().clear();
		profilePage.getNewPasswordField().sendKeys("NewPass");
		profilePage.getConfirmNewPasswordField().sendKeys("newPass");
		profilePage.getSaveEditButton().click();
		assertionExistById(driver, ProfilePage.errorNewUserPasswordConfirmMessageIdSel);


		profilePage.getNewPasswordField().clear();
		profilePage.getConfirmNewPasswordField().clear();
		profilePage.getNewPasswordField().sendKeys(newPassword);
		profilePage.getConfirmNewPasswordField().sendKeys(newPassword);
		profilePage.getSaveEditButton().click();
		assertionNotExistById(driver, ProfilePage.errorNewUserPasswordConfirmMessageIdSel);


	}

}