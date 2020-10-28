package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JOB_Act1 {
	
	WebDriver driver;
    WebDriverWait wait;
    
    Double d = (Math.random() + 1) * 10000;
	String username = "Username_" + Math.round(d);
	String emailId = username + "@gmail.com";
    
    @Given("^Open a browser$")
    public void openBrowser()
    {
    	driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
    }
    
    @When("^Navigate to Alchemy Jobs and log in$")
    public void logIN()
    {
    	driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    	driver.manage().window().maximize();
    	driver.findElement(By.id("user_login")).sendKeys("root");
    	driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    	driver.findElement(By.id("wp-submit")).click();
    }
    
    @Then("^Locate the left hand menu and click the menu item that says Users$")
    public void clickOnUsers()
    {
    	driver.findElement(By.xpath("//div[contains(text(),'Users')][1]")).click();
    }
    
    @And("^Locate the Add New button and click it$")
    public void clickOnAddNew()
    {
    	driver.findElement(By.linkText("Add New")).click();
    }
    
    @Then("^Fill in the necessary details")
    public void fillDetails()
    {
   driver.findElement(By.id("user_login")).clear();
   driver.findElement(By.id("user_login")).sendKeys(username);
   
   driver.findElement(By.id("email")).clear();
   driver.findElement(By.id("email")).sendKeys(emailId);
    	
    }
    
    @And("^Click the Add New User button$")
    public void clickOnAddNewUserButton()
    {
    	driver.findElement(By.id("createusersub")).click();
    }
    
    @Then("^Verify that the user was created$")
	public void verifyUserCreation() {
		driver.findElement(By.id("user-search-input")).clear();
		driver.findElement(By.id("user-search-input")).sendKeys(username);

		driver.findElement(By.id("search-submit")).click();

		String actualUserName = driver.findElement(By.linkText(username)).getText();

		Assert.assertEquals(actualUserName, username);
    }
    
    /*@And("^Close the browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}*/

}
