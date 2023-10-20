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

public class failcheckout {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo6")
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

    @When("Input username6")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password6")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button6")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page7")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String dashboard = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboard, "Products");
    }

    @And("User add cart sauce labs backpack4")
    public void userAddCartSauceLabsBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }


    @Then("User click cart menu2")
    public void userClickCartMenu() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("User click checkout button2")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User input first name2")
    public void userInputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("");
    }

    @And("User input last name2")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("");
    }

    @And("User input zip code2")
    public void userInputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("");
    }

    @And("User click continue button2")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("Error alert show up")
    public void errorAlertShowUp() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin, "Error: First Name is required");
        driver.close();
    }
}
