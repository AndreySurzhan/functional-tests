package org.jtalks.tests.jcommune.tests.profile;

/**
 * @author: erik
 * Date: 09.03.12
 * Time: 20:54
 */
public class JC53ChangeEmailWithoutSaving {
	//TODO uncomment after X servers will be installed
//	String currentEmail;
//	String uniqEmail;
//
//	@BeforeMethod(alwaysRun = true)
//	@Parameters({"app-url", "uUsername", "uPassword"})
//	public void setupCase(String appUrl, String username, String password) {
//		driver.get(appUrl);
//		signIn(username, password);
//		profilePage.getCurrentUserLink().click();
//		uniqEmail = StringHelp.getRandomEmail();
//		currentEmail = profilePage.getEmail().getText();
//		profilePage.getEditProfileButton().click();
//	}
//
//	@AfterMethod(alwaysRun = true)
//	@Parameters({"app-url"})
//	public void destroy(String appUrl) {
//		logOut(appUrl);
//	}
//
//	@Test
//	public void testEmptyEmail() {

//		profilePage.getEmailEditField().clear();
//		profilePage.getEmailEditField().sendKeys(uniqEmail);
//		profilePage.getBackButton().click();
//		assertEquals(profilePage.getEmail().getText(), currentEmail);
//	}
}