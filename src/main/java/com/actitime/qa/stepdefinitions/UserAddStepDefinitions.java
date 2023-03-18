package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.actitime.qa.base.TestBase.driver;
import static com.actitime.qa.base.TestBase.initialization;

public class UserAddStepDefinitions extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;
    String sheetName = "userData";
    TestUtil testUtil;
    @Given("admin of the Actitime add new user")
    public void admin_of_the_actitime_add_new_user() {
        initialization();
        loginPage = new LoginPage();
       homePage=loginPage.loging(properties.getProperty("username"),properties.getProperty("password"));
    }

    @When("admin login to the system with username and password as  {string} {string}")
    public void admin_login_to_the_system_with_username_and_password_as(String username, String password) {
        loginPage.loging(username,password);
    }

    @Then("admin navigate to users page")
    public void admin_navigate_to_users_page() {
        homePage.clickOnUsersLink();
    }

    @Then("admin click on add new user button")
    public void admin_click_on_add_new_user_button() {
       usersPage.clickNewUserButton();
    }

    @Then("fill all the mandatory fields using the excel sheet and send the invitation and validate user creation  {string} {string} {string} {string}")
    public void fill_all_the_mandatory_fields_using_the_excel_sheet_and_send_the_invitation_and_validate_user_creation(String fname, String lname, String mname, String email) {
        usersPage.fillTheForm(fname,lname,mname,email);
        driver.quit();
    }
}
