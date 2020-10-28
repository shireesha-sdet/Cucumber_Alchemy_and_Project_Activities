package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CRM_Act3 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open the browser to the ​Alchemy CRM​ site and login with the credentials provided$")
	public void openBrowser() throws Throwable {
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);

		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();

		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys("admin");

		driver.findElement(By.id("username_password")).clear();
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");

		driver.findElement(By.id("bigbutton")).click();
	}
	
	@Then("^Navigate to Activities -> Meetings -> Schedule a Meeting$")
	public void navigateToScheduleMeeting() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dashlet-title")));
		WebElement activities = driver.findElement(By.id("grouptab_3"));
		
		Actions action = new Actions(driver);
		action.moveToElement(activities).build().perform();
		
		WebElement meeting = driver.findElement(By.id("moduleTab_9_Meetings"));
		wait.until(ExpectedConditions.elementToBeClickable(meeting));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",meeting);
		meeting.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Schedule Meeting']")));
		driver.findElement(By.xpath("//div[text()='Schedule Meeting']")).click();
	}

	@And("^Enter the details of the meeting \"(.*)\"$")
	public void fillMeetingDetails(String meetingSubject) throws InterruptedException {
		Thread.sleep(3500);
		
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(meetingSubject);
 	}
	
	@And("^Search for members and add them to the meeting \"(.*)\", \"(.*)\", \"(.*)\"$")
	public void addMembers(String member_1, String member_2, String member_3) {
		WebElement scroll = driver.findElement(By.id("invitees_search"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		scroll.click();		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(member_1)));
		
		driver.findElement(By.id(member_1)).click();
		driver.findElement(By.id(member_2)).click();
		driver.findElement(By.id(member_3)).click();
	}
	
	@Then("^Click Save$")
	public void clickOnSaveButton() {
		WebElement scroll = driver.findElement(By.id("SAVE_HEADER"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", scroll);
		scroll.click();
	}
	
	@And("^Navigate to View Meetings page and confirm creation of the meeting \"(.*)\"$")
	public void navigateToViewMeeting(String meetingSubject) throws InterruptedException {
		Thread.sleep(3500);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='View Meetings']")));
		driver.findElement(By.xpath("//div[text()='View Meetings']")).click();
		
		Thread.sleep(3500);
		
		String actualMeetingSubject = driver.findElement(By.linkText(meetingSubject)).getText();
		
		Assert.assertEquals(actualMeetingSubject, meetingSubject);
	}
	
	@And("^Close the Browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}

}
