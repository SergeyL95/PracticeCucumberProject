package step_defenitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class ItemManagementSteps {
	LoginPage loginPage = new LoginPage();
	ItemsPage itemsPage = new ItemsPage();
	BrowserUtils utils = new BrowserUtils();
	
	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		utils.actionsSendKeys(loginPage.nameField, DataReader.getProperty("username"));
		utils.actionsSendKeys(loginPage.passwordField, DataReader.getProperty("password"));
		loginPage.loginBtn.click();
	}
	
	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {
	   itemsPage.itemsLink.click();
	}
	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
	   itemsPage.addItemBtn.click();
	}
	@When("I should be on item input page")
	public void i_should_be_on_item_input_page() {
	    Assert.assertTrue(itemsPage.newItemHeader.isDisplayed());
	}
	@When("I provide item information name {string}, price {int}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String string, Integer int1, String string2, String string3) {
	    itemsPage.itemNameField.sendKeys("Books");
	    itemsPage.itemPriceField.sendKeys("1800");
	    //utils.selectDropDownByValue(itemsPage.itemUnitDropDown, "pc");
	    itemsPage.itemDescriptionField.sendKeys("a good book");
	}
	@When("I click Save Item button")
	public void i_click_save_item_button() {
	   itemsPage.itemSaveBtn.click();
	}
	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
	   Assert.assertTrue(itemsPage.createdItemInList.isDisplayed());
	}
	
	@When("I select the item “Books”")
	public void i_select_the_item_books() {
	    itemsPage.createdItemInList.click();
	}
	@When("I should be on item details page")
	public void i_should_be_on_item_details_page() {
	    Assert.assertTrue(itemsPage.editItemHeader.isDisplayed());
	}
	@When("I update the item price to {int} dollars")
	public void i_update_the_item_price_to_dollars(Integer int1) {
	    itemsPage.itemPriceField.sendKeys(Keys.CONTROL + "a");
	    itemsPage.itemPriceField.sendKeys("3000");
	}
	@When("I click Update Item button")
	public void i_click_update_item_button() {
	    itemsPage.itemUpdateBtn.click();
	}
	@Then("The Item price is updated to {int} dollars")
	public void the_item_price_is_updated_to_dollars(Integer int1) {
	    Assert.assertTrue(itemsPage.priceOfElementInList.getText().equals("$ 30.00"));
	}
}
