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

public class checkout {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo5")
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

    @When("Input username5")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password5")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button5")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page5")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String dashboard = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboard, "Products");
    }

    @And("User add cart sauce labs backpack3")
    public void userAddCartSauceLabsBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }


    @Then("User click cart menu")
    public void userClickCartMenu() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User input first name")
    public void userInputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Firman");
    }

    @And("User input last name")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Iman");
    }

    @And("User input zip code")
    public void userInputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("94119");
    }

    @And("User click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("User click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @And("Checkout complete")
    public void checkoutComplete() {
        driver.findElement(By.xpath("//span[contains(text(), 'Complete!')]"));
        String dashboard = driver.findElement(By.xpath("//span[contains(text(), 'Complete!')]")).getText();
        Assert.assertEquals(dashboard, "Checkout: Complete!");
    }

    @And("User click back home button")
    public void userClickBackHomeButton() {
        driver.findElement(By.id("back-to-products")).click();
    }

    @Then("User in on dashboard page6")
    public void userInOnDashboardPage6() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String dashboard = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboard, "Products");
        driver.close();
    }


}
