package stepDefinitions;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRM_Act2 {
	
	WebDriver driver;
	WebDriverWait wait;
	

	Double d = (Math.random() + 1) * 1000;
	String firstName = "FName_" + Math.round(d);
	String lastName = "lName_" + Math.round(d);
	String email = firstName + lastName +"@gmail.com";
	String candidateName = firstName + " " + lastName;
	
	
	
	String path = System.getProperty("user.dir")+"\\File\\HRMfile.docx";

	@Given("^Open the OrangeHRM​ page and login with the credentials provided$")
	public void openBrowser() throws Throwable {
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);

		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.manage().window().maximize();

		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("orange");

		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();
	}

	@When("^Navigate to the Recruitment page and click on the Add button to add candidate information$")
	public void navigateToRecruitmentPage() {
		//WebElement dashboardLink = driver.findElement(By.id("menu_dashboard_index"));
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebElement recruitmentLink = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
		//WebElement recruitmentLink = driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]"));
		//wait.until(ExpectedConditions.elementToBeClickable(recruitmentLink));
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",recruitmentLink);
		//recruitmentLink.click();

		//recruitmentLink.click();
		/*if (dashboardLink.isEnabled()) {

			recruitmentLink.click();

		} else {

			dashboardLink.click();
			recruitmentLink.click();
		}*/
		
		driver.findElement(By.id("btnAdd")).click();
	}

	@Then("^On the next page, fill in the details of the candidate$")
	public void fillAddCandidateForm() {
		driver.findElement(By.id("addCandidate_firstName")).clear();
		driver.findElement(By.id("addCandidate_firstName")).sendKeys(firstName);
		
		driver.findElement(By.id("addCandidate_lastName")).clear();
		driver.findElement(By.id("addCandidate_lastName")).sendKeys(lastName);
		
		driver.findElement(By.id("addCandidate_email")).clear();
		driver.findElement(By.id("addCandidate_email")).sendKeys(email);		
	}

	@And("^Upload a resume docx or pdf to the form$")
	public void uploadResume() {
		driver.findElement(By.id("addCandidate_resume")).sendKeys(path);
	}

	@And("^Click on Save$")
	public void clickSaveButton() {
		driver.findElement(By.id("btnSave")).click();
	}

	@Then("^Navigate back to the Recruitments page to confirm candidate entry$")
	public void verifyVacancyCreation() {
		driver.findElement(By.id("btnBack")).click();

		driver.findElement(By.id("candidateSearch_candidateName")).clear();
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(candidateName);
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("btnSrch")).click();

		String actualCandidateName = driver.findElement(By.linkText(candidateName)).getText();

		Assert.assertEquals(actualCandidateName, candidateName);
	}

	/*@And("^Close the Browser$")
	public void closeTheBrowser() {
		driver.quit();
	}*/

}
