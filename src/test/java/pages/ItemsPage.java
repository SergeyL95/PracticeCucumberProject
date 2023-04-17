package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DataReader;
import utilities.Driver;

public class ItemsPage {
	
	public ItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (linkText = "Items")
	public WebElement itemsLink;
	
	@FindBy (xpath = "//h3[text()='New Item']")
	public WebElement newItemHeader;
	
	@FindBy (xpath = "//h3[text()='Edit Item']")
	public WebElement editItemHeader;
	
	@FindBy (xpath = "//button[text()=' Add Item']")
	public WebElement addItemBtn;
	
	@FindBy (xpath = "//div[@class='relative rounded-md shadow-sm font-base']/input")
	public WebElement itemNameField;
	
	@FindBy (xpath = "//input[@id=0]")
	public WebElement itemPriceField;
	
	@FindBy (name = "description")
	public WebElement itemDescriptionField;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement itemSaveBtn;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement itemUpdateBtn;
	
	@FindBy (xpath = "//span[@class='bg-multiselect-caret bg-center bg-no-repeat w-5 h-5 py-px box-content z-5 relative mr-1 opacity-40 shrink-0 grow-0 transition-transform']")
	public WebElement itemUnitDropDown;
	
	@FindBy (xpath = "//a[text()='Books']")
	public WebElement createdItemInList;
	
	@FindBy (xpath = "//tr[1]/td[4]/span")
	public WebElement priceOfElementInList;
	
}
