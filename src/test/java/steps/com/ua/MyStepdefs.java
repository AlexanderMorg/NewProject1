package steps.com.ua;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {

    WebDriver driver;

    String getRegEmail;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }


    @Given("Navigate to www.sharelane.com")
    public void navigateToWwwSharelaneCom() {
        driver.get("http://www.sharelane.com/cgi-bin/main.py");
    }

    @When("You've been navigated to it, click Sign-Up")
    public void youVeBeenNavigatedToItClickSignUp() {
        WebElement signUp = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[4]/a"));
        signUp.click();
    }

    @And("Enter zipCode")
    public void enterZipCode() {
        WebElement zipCode = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input"));
        zipCode.sendKeys("55555");
    }

    @And("Click Continue")
    public void clickContinue() {
        WebElement clickContinue = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"));
        clickContinue.click();
        
    }

    @And("Fill FirstName")
    public void fillFirstName() {
        WebElement firstName = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input"));
        firstName.sendKeys("Alex");
    }

    @And("Fill Email")
    public void fillEmail() {
        WebElement email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"));
        email.sendKeys("Alex@mail.ru");
        
    }

    @And("Fill Password")
    public void fillPassword() {
        WebElement password = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input"));
        password.sendKeys("12345");
        
    }

    @And("Fill confirm password")
    public void fillConfirmPassword() {
        WebElement confirmPsw = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/input"));
        confirmPsw.sendKeys("12345");
    }

    @Then("Click Register")
    public void clickRegister() {
        WebElement register = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input"));
        register.click();
    }

    @When("You've been registered, click underlined here")
    public void youVeBeenRegisteredClickUnderlinedHere() {
        WebElement regmessage = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td/span"));
        Assert.assertEquals("Account is created!", regmessage.getText());

        WebElement regEmail = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b"));
        getRegEmail = regEmail.getText();

        WebElement clickHere = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td/p/a"));
        clickHere.click();
    }

    @Then("Enter email")
    public void enterEmail() {
        WebElement regEmail = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[1]/p/input"));
        regEmail.sendKeys(getRegEmail);
    }

    @And("Enter password")
    public void enterPassword() {
        WebElement regPsw = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[2]/p/input"));
        regPsw.sendKeys("1111");
    }

    @And("Click Login")
    public void clickLogin() {
        WebElement loginBtn = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[3]/input"));
        loginBtn.click();
    }


    @After
    public void theEnd() {
        driver.quit();
    }
}
