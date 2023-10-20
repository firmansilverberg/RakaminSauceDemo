package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class login {

    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo")
    public void halaman_login_saucedemo() {
        WebDriverManager.firefoxdriver().setup();

        //apply firefox driver setup
        //open login page
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String LoginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(LoginPageAssert, "Swag Labs");

    }

    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String username = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(username, "Products");
//        driver.close();
    }

    @And("Input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @When("I input (.*) as username$")
    public void i_input_standard_user_as_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("I input (.*) as password$")
    public void i_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I verify (.*) login result$")
    public void i_verify_failed_login_result(String status) {
        if (status.equals("success")) { //Jika Sukses
            driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
            String username = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
            Assert.assertEquals(username, "Products");
        } else { //Jika Failed
            String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        }
        driver.close();

    }
}
