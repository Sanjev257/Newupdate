package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import atu.testng.reports.logging.LogAs;
import commonMethods.Config;
import commonMethods.Keywords;
import commonMethods.Utils;

public class ChatBot extends Keywords {

	String MSSFoption = Utils.getDataFromTestData("Maruthi", "Excepted text5");

	public void createnexa(WebDriver driver, String URL) {

		navigateUrl(driver, URL);
		System.out.println("\nLaunched the URL : " + URL);

		System.out.println("\nSTEP1 : verify the welcome message is available with menu options");

		waitForElementWithLessWait(driver, chatbot);
		click(driver, chatbot);

//		    waitForElementWithLessWait(driver, loan);
		responseTimeCalculator1(driver, loan);

		WebElement text = driver.findElement(By.xpath("//*[@id='dave-canvas']//following::ul"));
		String option = text.getText();
		System.out.println("Actual option : " + "\n" + option);

//		    System.out.println("Excepted option : "+"\n" +MSSFoption);

		if (option.contains(MSSFoption)) {
			System.out.println("Verifying the expected results for STEP1 is done");
		} else {
			System.out.println("Response not got has our excepted");
		}
		click(driver, loan);

		System.out.println("\nSTEP2 : Verify the click ability of - MSSF Loan Process quick-access buttons");
		responseTimeCalculator1(driver, MssfText);
		asserterText(driver, MssfText, Config.MSSFassert, "Mssf loan");
		System.out.println("Verifying the expected results for STEP2 is done");

		System.out.println("\nSTEP3 : Verify the click ability of - Financier Options quick-access buttons");
		waitForElementWithLessWait(driver, financier);
		click(driver, financier);
		responseTimeCalculator1(driver, financierText);
		asserterText(driver, financierText, Config.financerassert, "finacier");
		System.out.println("Verifying the expected results for STEP3");

		System.out.println("\nSTEP4 : Verify user is able to type query");
		responseTimeCalculator(driver, raise);
//			waitForElementWithLessWait(driver, raise);
		sendKeys(driver, raise, "raise an issue");
		enter(driver);
		addfps(driver, "raise an issue query is typed", "", true, "");
		responseTimeCalculator1(driver, raiseText);
		asserterText(driver, raiseText, Config.raiseassert, "raise an issue");
		System.out.println("raise an issue query is typed STEP4 is done");

		System.out.println("\nSTEP5 : Verify Predictive text is availble when typing a query");
		waitForElementWithLessWait(driver, inputfield);
		sendKeys1(driver, inputfield, "doc");
		System.out.println("user is able type the text doc");
		addfps(driver, "user is able type the text doc", "", true, "");
//			waitForElementWithLessWait(driver, predictive_text);
		responseTimeCalculator1(driver, predictive_text);
		click(driver, predictive_text);
		enter(driver);
		System.out.println("Predictive text is availble when typing a query STEP5 is done");

		System.out.println("\nSTEP6 : Verify unsure state text is availble when typing a partial query");
		waitForElementWithLessWait(driver, inputfield);
		sendKeys(driver, inputfield, "process");
		enter(driver);
		System.out.println("Unsure state text is availble when typing a partial query process");
		addfps(driver, "Unsure state text is availble when typing a partial query process", "", true, "");
		responseTimeCalculator1(driver, processText);
		asserterText(driver, processText, Config.processassert, "process");
		System.out.println("It should go to an unsure state, with options available to select STEP6 is done");

		System.out.println("\nSTEP7 : Submit the Feedback");
		waitForElementWithLessWait(driver, Close_button);
		click(driver, Close_button);

		responseTimeCalculator1(driver, submit);
		waitForElementWithLessWait(driver, feedback1);
		click(driver, feedback1);

		waitForElementWithLessWait(driver, feedback2);
		click(driver, feedback2);

		waitForElementWithLessWait(driver, submit);
		click(driver, submit);
		System.out.println("Ratings and queries are submitted.");
		addfps(driver, "Ratings and queries are submitted.", "", true, "");

		if (Success_popup.contains("Thank you for your valuable feedback")) {
			System.out.println(
					"Thank you for the valuable feedback the popup has received, and the bot is getting closed.");
			addfps(driver, "Thank you for the valuable feedback the popup has received, and the bot is getting closed.",
					"", true, "");
		} else {
			System.out.println("Not get excepted message");
			add1(driver, "Not get excepted message", LogAs.FAILED, true, "");
		}

		System.out.println(
				"A popup should appear -Thank you for your valuable feedback- and the Bot should get closed STEP7 is done");

		System.out.println("\nSTEP8 : Re-opening the bot");
		wait(driver, "2");
//			waitForElementWithLessWait(driver, chatbot);
		click(driver, chatbot);
		System.out.println("Chat Bot opened with history of queries searched before");
		addfps(driver, "Chat Bot opened with history of queries searched before", "", true, "");
		System.out.println("Chat Bot should open with history of queries searched before STEP8 is done");

	}

}
