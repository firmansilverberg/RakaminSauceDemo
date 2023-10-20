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

public class logout {

    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo2")
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

    @When("Input username2")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password2")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button2")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page2")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String dashboard = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(dashboard, "Products");
    }

    @And("User click hamburger menu")
    public void userClickHamburgerMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click logout")
    public void userClickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User on login page")
    public void userOnLoginPage() {
        String LoginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(LoginPageAssert, "Swag Labs");
    }
}
