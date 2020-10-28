package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CRM_Act1 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open the browser to the ​Alchemy CRM​ site and login$")
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
	
	@Then("^Count the number of Dashlets on the homepage$")
	public void countNumberOfDashlets() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dashlet-title")));
		List<WebElement> dashlets = driver.findElements(By.cssSelector(".dashlet-title"));
		System.out.println("Total number of Dashlets are: " + dashlets.size());
	}

	@And("^Print the number and title of each Dashlet into the console$")
	public void printNumberAndDashletTitle() {
		List<WebElement> dashletTitles = driver.findElements(By.xpath("//td[@class='dashlet-title']/h3/span[contains(@class,'suitepicon-module-')]/following-sibling::span"));
				
		for (WebElement dashletTitle : dashletTitles) {
			System.out.println("Dashlet Title is: " + dashletTitle.getText());			
		}
		
		List<WebElement> dashletNumbers = driver.findElements(By.cssSelector(".pageNumbers"));
		
		for (WebElement dashletNumber : dashletNumbers) {
			System.out.println("Dashlet Number is: " + dashletNumber.getText());
		}
 	}
	
	@And("^Close browser$")
	public void closeBrowser() throws Throwable {
		driver.close();
	}


}
