package stepDefinitions;

import com.qa.factory.DriverFactory;
import com.qa.pages.ContactUsPage;
import com.qa.utiles.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactUsSteps {

    private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @Given("User navigate to contact us page")
    public void user_navigate_to_contact_us_page() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
        String actual = contactUsPage.getContactUsPageTitle();
        System.out.println("The actual title of the contactUsPage is " + actual);
        Assert.assertEquals("Contact us - My Store",actual);
    }

    @When("User fills the form from given sheet name {string} and row number {int}")
    public void user_fills_the_form_from(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException,IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src\\test\\resources\\dataset\\contactus.xlsx",sheetName);

        String heading = testData.get(rowNumber).get("Subject Heading");

        String email = testData.get(rowNumber).get("Email");
        Thread.sleep(2000);
        String orderRef = testData.get(rowNumber).get("Order Ref");
        Thread.sleep(2000);
        String message = testData.get(rowNumber).get("message");
        Thread.sleep(2000);
        contactUsPage.fillContactUsForm(heading,email,orderRef,message);

    }

    @When("User click on submit button")
    public void user_click_on_submit_button() {
      //  contactUsPage.clickSend();

    }

    @Then("User verify the successful message {string}")
    public void user_verify_the_successful_message(String expected) {
        String actual = contactUsPage.getSuccessMessg();
        Assert.assertEquals(expected,actual);
    }


}
