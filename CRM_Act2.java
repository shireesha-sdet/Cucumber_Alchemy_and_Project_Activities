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

public class CRM_Act2 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open the browser to the ​Alchemy CRM​ site and login with the given credentials$")
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
	
	@Then("^Navigate to Sales -> Leads -> Create Lead$")
	public void navigateToCreateLead() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dashlet-title")));
		WebElement sales = driver.findElement(By.id("grouptab_0"));
		
		Actions action = new Actions(driver);
		action.moveToElement(sales);
		action.build().perform();
		WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
		wait.until(ExpectedConditions.elementToBeClickable(leads));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",leads);
		leads.click();
		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Create Lead']")));
		driver.findElement(By.xpath("//div[text()='Create Lead']")).click();
	}

	@And("^Fill in the \"(.*)\", \"(.*)\" details to create lead accounts using the values passed from the Feature file$")
	public void fillCreateLeadForm(String firstName, String lastName) throws InterruptedException {
		Thread.sleep(3500);
		
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		
		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys(lastName);
 	}
	
	@Then("^Click Save to finish$")
	public void clickOnSaveButton() {
		driver.findElement(By.id("SAVE")).click();
	}
	
	@And("^Navigate to the View Leads page to see results \"(.*)\"$")
	public void navigateToViewLeads(String leadName) throws InterruptedException {
		Thread.sleep(3500);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='View Leads']")));
		driver.findElement(By.xpath("//div[text()='View Leads']")).click();
		
		Thread.sleep(3500);
		
		String actualLeadName = driver.findElement(By.linkText(leadName)).getText();
		System.out.println(actualLeadName);
		
		Assert.assertEquals(actualLeadName, leadName);
	}
	
	/*@And("^Close Browser$")
	public void closeBrowser() throws Throwable {
		driver.close();
	}*/

}
