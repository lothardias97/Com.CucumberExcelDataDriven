package stepDefinitions;

import com.qa.factory.DriverFactory;
import com.qa.pages.CoopRegisterPage;
import com.qa.utiles.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CoopRegisterSteps {

    private CoopRegisterPage coopRegisterPage = new CoopRegisterPage(DriverFactory.getDriver());

    @Given("User is on Coop Membership URL nad click on join membership button")
    public void user_is_on_coop_membership_url_nad_click_on_join_membership_button() {
        DriverFactory.getDriver().get("https://www.coop.co.uk/membership");
        coopRegisterPage.joinMemberClick();
    }

    @When("User Select No radio button for member card and click Next")
    public void user_select_no_radio_button_for_member_card_and_click_next() {
        coopRegisterPage.clickOnRadio();
    }

    @When("User fills form from given sheet name {string} and row number {int}")
    public void user_fills_form(String Sheet, Integer Row) throws InvalidFormatException, IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> registerData = reader.getData("src\\test\\resources\\dataset\\coopRegister.xlsx",Sheet);
        String titleSel = registerData.get(Row).get("Title");
        String first = registerData.get(Row).get("FirstName");
        String last = registerData.get(Row).get("LastName");
        String dayPickUp = registerData.get(Row).get("Day");
        String monthPickUp = registerData.get(Row).get("Month");
        String yearPickUp = registerData.get(Row).get("Year");
        coopRegisterPage.fillDetailsOne(titleSel,first,last,dayPickUp,monthPickUp,yearPickUp);
        String postCode = registerData.get(Row).get("Postcode");
        String emailField = registerData.get(Row).get("Email");
        String confirmEmailField = registerData.get(Row).get("ConfirmEmail");
        String passwordField = registerData.get(Row).get("Password");
        String confirmPasswordField = registerData.get(Row).get("ConfirmPassword");
        coopRegisterPage.fillDetailsTwo(postCode,emailField,confirmEmailField,passwordField,confirmPasswordField);
    }
    @Then("User must register Successfully")
    public void user_must_register_successfully() {
        // Write code here that turns the phrase above into concrete actions

    }

}
