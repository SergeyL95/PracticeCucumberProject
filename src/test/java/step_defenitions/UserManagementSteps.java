package step_defenitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class UserManagementSteps {
	LoginPage loginPage = new LoginPage();
	BrowserUtils utils = new BrowserUtils();
	
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
	    Driver.getDriver().get(DataReader.getProperty("appUrl"));
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		utils.actionsSendKeys(loginPage.nameField, DataReader.getProperty("username"));
		utils.actionsSendKeys(loginPage.passwordField, DataReader.getProperty("password"));
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		loginPage.loginBtn.click();
	}

	@Then("I should be on user profile page")
	public void i_should_be_on_user_profile_page() {
		Assert.assertTrue(loginPage.accountSettingsHeader.isDisplayed());
	}
	
	//invalid login scenario steps
	
	@When("I enter invalid username and valid password")
	public void i_enter_invalid_username_and_valid_password() {
	    utils.actionsSendKeys(loginPage.nameField, "invalid@primetechschool.com");
	    utils.actionsSendKeys(loginPage.passwordField, DataReader.getProperty("password"));
	}
	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		utils.waitUntilElementVisible(loginPage.invalidLoginErrorMessage);
	    Assert.assertTrue(loginPage.invalidLoginErrorMessage.isDisplayed());
	}
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
	    Assert.assertTrue(loginPage.nameField.isDisplayed());
	}
	
	@When("I enter valid username and vinalid password")
	public void i_enter_valid_username_and_vinalid_password() {
		utils.actionsSendKeys(loginPage.nameField, DataReader.getProperty("username"));
		utils.actionsSendKeys(loginPage.passwordField, "somerandompassword1");
	}
}
