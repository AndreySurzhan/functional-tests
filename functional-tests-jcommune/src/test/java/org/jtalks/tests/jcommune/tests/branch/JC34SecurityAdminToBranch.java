package org.jtalks.tests.jcommune.tests.branch;

import org.jtalks.tests.jcommune.pages.BranchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.jtalks.tests.jcommune.Assert.Exsistence.assertNotEmptyCollection;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.driver;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.logOut;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.signIn;

/**
 * @autor masyan
 */
public class JC34SecurityAdminToBranch {

	BranchPage branchPage;

	@BeforeMethod
	@Parameters({"app-url", "aUsername", "aPassword"})
	public void setupCase(String appUrl, String username, String password) {
		driver.get(appUrl);
		signIn(username, password);
		branchPage = new BranchPage(driver);
	}

	@AfterMethod
	@Parameters({"app-url"})
	public void destroy(String appUrl) {
		logOut(appUrl);
	}

	@Test
	public void securityAdminToBranchTest() {
		//view the branches list
		assertNotEmptyCollection(branchPage.getBranchList());
	}
}