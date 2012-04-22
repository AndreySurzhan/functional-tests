package org.jtalks.tests.jcommune.tests.topic;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.CollectionHelp;

import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.clickOnRandomBranch;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.createTopicForTest;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.driver;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.logOut;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.signIn;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.topicPage;
import static org.testng.Assert.assertEquals;

/**
 * @author masyan
 */
public class JC75ViewsAmountToTopicWhenRefreshByAnonymous {

	@BeforeMethod(alwaysRun = true)
	@Parameters({"app-url", "uUsername", "uPassword"})
	public void setupCase(String appUrl, String username, String password) {
		driver.get(appUrl);
		;
		signIn(username, password);
		clickOnRandomBranch();
		createTopicForTest();
		topicPage.getBackButton().click();
		String url = driver.getCurrentUrl();
		logOut(appUrl);
		driver.get(url);
	}

	@Test
	public void viewsAmountToTopicWhenRefreshByAnonymousTest() {

		//amount views for first topic
		int amountBefore = new Integer(CollectionHelp.getFirstWebElementFromCollection(topicPage.getAmountsOfViewTopics()).getText()).intValue();

		CollectionHelp.getFirstWebElementFromCollection(topicPage.getTopicsList()).click();

		driver.navigate().refresh();

		topicPage.getBackButton().click();

		int amountAfter = new Integer(CollectionHelp.getFirstWebElementFromCollection(topicPage.getAmountsOfViewTopics()).getText()).intValue();

		assertEquals(amountBefore + 2, amountAfter);

	}

}