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

public class addcart {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo3")
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

    @When("Input username3")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password3")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button3")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page3")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String dashboard = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboard, "Products");
    }

    @And("User add cart sauce labs backpack")
    public void userAddCartSauceLabsBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User add cart sauce labs bike light")
    public void userAddCartSauceLabsBikeLight() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("User add cart sauce labs bolt t-shirt")
    public void userAddCartSauceLabsBoltTShirt() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    @And("User add cart sauce labs fleece jacket")
    public void userAddCartSauceLabsFleeceJacket() {
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    @And("User add cart sauce labs onesie")
    public void userAddCartSauceLabsOnesie() {
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }

    @And("User add cart sauce labs t-shirt red")
    public void userAddCartSauceLabsTShirtRed() {
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
    }

    @Then("Cart added six items")
    public void cartAddedSixItems() {
        driver.findElement(By.xpath("//span[contains(text(), '6')]"));
        String addcart = driver.findElement(By.xpath("//span[contains(text(), '6')]")).getText();
        Assert.assertEquals(addcart, "6");
        driver.close();
    }
}
