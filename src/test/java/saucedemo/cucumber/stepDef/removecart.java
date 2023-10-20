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

public class removecart {
    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo4")
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

    @When("Input username4")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password4")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button4")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page4")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String dashboard = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboard, "Products");
    }

    @And("User add cart sauce labs backpack2")
    public void userAddCartSauceLabsBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User add cart sauce labs bike light2")
    public void userAddCartSauceLabsBikeLight() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("User add cart sauce labs bolt t-shirt2")
    public void userAddCartSauceLabsBoltTShirt() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    @And("User add cart sauce labs fleece jacket2")
    public void userAddCartSauceLabsFleeceJacket() {
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    @And("User add cart sauce labs onesie2")
    public void userAddCartSauceLabsOnesie() {
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }

    @And("User add cart sauce labs t-shirt red2")
    public void userAddCartSauceLabsTShirtRed() {
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
    }

    @Then("Cart added six items2")
    public void cartAddedSixItems() {
        driver.findElement(By.xpath("//span[contains(text(), '6')]"));
        String addcart = driver.findElement(By.xpath("//span[contains(text(), '6')]")).getText();
        Assert.assertEquals(addcart, "6");
    }

    @And("User remove cart sauce labs backpack")
    public void userRemoveCartSauceLabsBackpack() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @And("User remove cart sauce labs bike light")
    public void userRemoveCartSauceLabsBikeLight() {
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    }

    @And("User remove cart sauce labs bolt t-shirt")
    public void userRemoveCartSauceLabsBoltTShirt() {
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
    }

    @And("User remove cart sauce labs fleece jacket")
    public void userRemoveCartSauceLabsFleeceJacket() {
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
    }

    @And("User remove cart sauce labs onesie")
    public void userRemoveCartSauceLabsOnesie() {
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
    }

    @And("User remove cart sauce labs t-shirt red")
    public void userRemoveCartSauceLabsTShirtRed() {
        driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
    }

    @Then("Cart zero items")
    public void cartZeroItems() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String dashboard = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboard, "Products");
        driver.close();
    }
}
