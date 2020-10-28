package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity_2 {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is on the Login page$")
    public void loginPage() {
        
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    @When("^User enters the username and password$")
    public void enterCredentials() {
        
        driver.findElement(By.id("username")).sendKeys("admin");
        
        driver.findElement(By.id("password")).sendKeys("password");
        
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    
    @Then("^Read the page title and confirmation the message$")
    public void readTitleAndHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
        
        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
    }
    
   /* @And("^Close the Browser$")
    public void closeTheBrowser() {
        
        driver.close();
    }*/

}
