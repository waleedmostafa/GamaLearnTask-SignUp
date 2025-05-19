package signup;

import base.BaseTest;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import static reader.ReadDataFromJson.dataModel;
import static utils.MethodHandles.myAssertEquals;

public class SignUpTests extends BaseTest {

    @Test
    public void signUpWithValidData() throws FileNotFoundException{
        homePage.insertOrganization(dataModel().SignUpData.Organization);
        homePage.insertName(dataModel().SignUpData.Name);
        homePage.insertEmail(dataModel().SignUpData.Email2);
        homePage.selectCountry("Egypt");
        homePage.selectAccountType("General");
        homePage.insertAccountName(dataModel().SignUpData.AccountName);
        homePage.clickOnSignUpButton();
        String expectedResult = dataModel().ValidationMessage;
        String actualResult = homePage.getValidationMessage();
        myAssertEquals(expectedResult,actualResult);
    }

    @Test
    public void signUpWithoutUnRequiredFields() throws FileNotFoundException{
        homePage.insertName(dataModel().SignUpData.Name);
        homePage.insertEmail(dataModel().SignUpData.Email);
        homePage.insertAccountName(dataModel().SignUpData.AccountName);
        homePage.clickOnSignUpButton();
        String expectedResult = dataModel().ValidationMessage;
        String actualResult = homePage.getValidationMessage();
        myAssertEquals(expectedResult,actualResult);
    }



    @Test
    public void signUpWithInValidEmailFormat() throws FileNotFoundException{
        homePage.insertOrganization(dataModel().SignUpData.Organization);
        homePage.insertName(dataModel().SignUpData.Name);
        homePage.insertEmail(dataModel().InvalidEmail);
        homePage.selectCountry("Egypt");
        homePage.selectAccountType("College");
        homePage.insertAccountName(dataModel().SignUpData.AccountName);
        homePage.clickOnSignUpButton();
        String expectedResult = dataModel().EmailErrorMessage;
        String actualResult = homePage.getEmailErrorMessage();
        myAssertEquals(expectedResult,actualResult);
    }

    @Test
    public void signUpWithoutEnterEmail() throws FileNotFoundException{
        homePage.insertOrganization(dataModel().SignUpData.Organization);
        homePage.insertName(dataModel().SignUpData.Name);
        homePage.selectCountry("Egypt");
        homePage.selectAccountType("General");
        homePage.insertAccountName(dataModel().SignUpData.AccountName);
        homePage.clickOnSignUpButton();
        String expectedResult = dataModel().EmailRequiredErrorMessage;
        String actualResult = homePage.getEmailRequiredErrorMessage();
        myAssertEquals(expectedResult,actualResult);
    }


    @Test
    public void signUpWithoutEnterValidName() throws FileNotFoundException{
        homePage.insertOrganization(dataModel().SignUpData.Organization);
        homePage.insertEmail(dataModel().SignUpData.Email);
        homePage.selectCountry("Egypt");
        homePage.selectAccountType("School");
        homePage.insertAccountName(dataModel().SignUpData.AccountName);
        homePage.clickOnSignUpButton();
        String expectedResult = dataModel().NameErrorMessage;
        String actualResult = homePage.getNameErrorMessage();
        myAssertEquals(expectedResult,actualResult);
    }

    @Test
    public void signUpWithoutEnterAccountName() throws FileNotFoundException{
        homePage.insertOrganization(dataModel().SignUpData.Organization);
        homePage.insertName(dataModel().SignUpData.Name);
        homePage.insertEmail(dataModel().SignUpData.Email);
        homePage.selectCountry("Egypt");
        homePage.selectAccountType("General");
        homePage.clickOnSignUpButton();
        String expectedResult = dataModel().AccountNameErrorMessage;
        String actualResult = homePage.getAccountNameErrorMessage();
        myAssertEquals(expectedResult,actualResult);
    }

    @Test
    public void signUpWitEmptyAccountName() throws FileNotFoundException{
        homePage.insertOrganization(dataModel().SignUpData.Organization);
        homePage.insertName(dataModel().SignUpData.Name);
        homePage.insertEmail(dataModel().SignUpData.Email);
        homePage.selectCountry("Egypt");
        homePage.selectAccountType("General");
        homePage.clickOnSignUpButton();
        String expectedResult = dataModel().AccountNameEmptyErrorMessage;
        String actualResult = homePage.getAccountNameEmptyErrorMessage();
        myAssertEquals(expectedResult,actualResult);
    }


}
