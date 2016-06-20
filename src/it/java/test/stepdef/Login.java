package test.stepdef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login{
	private static WebDriver driver = null;
	
	@Before
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:/Documents/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("^User is on the home page$")
	public void user_is_on_the_home_page() throws Throwable {
		driver.get("http://www.store.demoqa.com");
		Assert.assertEquals(0, driver.findElements(By.id("account_logout")).size());
	}

	@When("^User clicks the login button, nevigates to login page$")
	public void user_clicks_the_login_button_nevigates_to_login_page() throws Throwable {
		WebElement btnLogin = driver.findElement(By.id("account"));
		btnLogin.click();
		Assert.assertNotEquals(0, driver.findElements(By.id("login_form")).size());
	}

	@When("^User enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_valid_and(String username, String password) throws Throwable {
		driver.findElement(By.id("log")).sendKeys(username);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}

	@Then("^User successfully login$")
	public void user_successfully_login() throws Throwable {
		Assert.assertNotEquals(0, driver.findElements(By.id("account_logout")).size());
	}

	@When("^User clicks the logout button$")
	public void user_clicks_the_logout_button() throws Throwable {
		driver.findElement(By.id("account_logout")).click();
	}

	@Then("^User successfully Logout$")
	public void user_successfully_Logout() throws Throwable {
		Assert.assertNotEquals(0, driver.findElements(By.id("login_form")).size());
	}
	
	@After
	public void clean(){
		driver.close();
	}
}