package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class steps {
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		lp=new LoginPage(driver);
		
	    
	}

	@When("User Opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
	   lp.clickLogin();
	}

	@Then("Page Title Should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful"))
	    {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }else {
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}

	@When("User click on Logout Link")
	public void user_click_on_logout_link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(3000);
	    
	}

	
	@Then("close browser")
	public void close_browser() {
	 driver.quit();
	}

}
