package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
        webTableLoginPage.loginWithConfig();
        basePage.order.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);
    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(int quantity) {
        orderPage.inputQuantity.clear();
        orderPage.inputQuantity.sendKeys(String.valueOf(quantity));
    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String name) {
        orderPage.inputName.sendKeys(name);
    }
    @When("user enters street {string}")
    public void user_enters_street(String street) {
        orderPage.inputStreet.sendKeys(street);
    }
    @When("user enters city {string}")
    public void user_enters_city(String city) {
        orderPage.inputCity.sendKeys(city);
    }
    @When("user enters state {string}")
    public void user_enters_state(String state) {
        orderPage.inputState.sendKeys(state);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String zip) {
        orderPage.inputZipcode.sendKeys(zip);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
        BrowserUtilities.clickRadioButton(orderPage.cardType, expectedCardType);
    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String cardNo) {
        orderPage.inputCard.sendKeys(cardNo);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String expiryDate) {
        orderPage.inputCardExp.sendKeys(expiryDate);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.buttonProcessOrder.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        Assert.assertEquals(expectedName, viewAllOrdersPage.newCustomerCell.getText());
    }

}
