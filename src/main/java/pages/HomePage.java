package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;
public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By organizationField = By.id("SignUp1_txtOrganization");
    private final By nameField = By.id("SignUp1_txtName");
    private final By emailField  = By.id("SignUp1_txtEmail");
    private final By country = By.id("SignUp1_ddlCountry");
    private final By accountType = By.id("SignUp1_ddlAccountType");
    private final By accountName = By.id("SignUp1_txtAccountURL");
    private final By signUpButton  = By.cssSelector("[class=\"floatR\"]");
    private final By validationMessage = By.id("SignUp1_litSuccess_HeadPanel");
    private final By emailErrorMessage = By.id("SignUp1_reqEmailFormat");
    private final By nameErrorMessage = By.id("SignUp1_reqName");
    private final By emailRequiredErrorMessage = By.id("SignUp1_reqEmail");
    private final By accountNameErrorMessage = By.id("SignUp1_reqComment");
    private final By accountNameEmptyErrorMessage = By.id("SignUp1_RequiredFieldValidator1");


    public void insertOrganization(String text){
        sendKeys(organizationField,text,20);
    }

    public void insertName(String text){
        sendKeys(nameField,text,20);
    }
    public void insertEmail(String text){
        sendKeys(emailField,text,20);
    }

    public void selectCountry(String text){
        selectByVisibleText(country,20,text);
    }

    public void selectAccountType(String text){
        selectByVisibleText(accountType,20,text);
    }

    public void insertAccountName(String text){
        clear(accountName,20);
        sendKeys(accountName,text,20);
    }

    public void clickOnSignUpButton(){
       clickAndHold(signUpButton,20);
       click(signUpButton,20);

    }

    public String getValidationMessage(){
       return getText(validationMessage,20);
    }

    public String getEmailErrorMessage(){
        return getText(emailErrorMessage,20);
    }

    public String getNameErrorMessage(){
        return getText(nameErrorMessage,20);
    }

    public String getEmailRequiredErrorMessage(){
        return getText(emailRequiredErrorMessage,20);
    }

    public String getAccountNameErrorMessage(){
        return getText(accountNameErrorMessage,20);
    }

    public String getAccountNameEmptyErrorMessage(){
        clear(accountName,20);
       return getText(accountNameEmptyErrorMessage,20);
    }

}
