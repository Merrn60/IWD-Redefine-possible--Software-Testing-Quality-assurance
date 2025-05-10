package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.HashMap;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        // Set ChromeOptions to disable Password Manager, notifications, and use Incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed: Inventory list not displayed");
    }

    @Test(dependsOnMethods = "testLogin")
    public void testAddProductToCart() {
        productsPage.addBackpackToCart();
    }

    @Test(dependsOnMethods = "testAddProductToCart")
    public void testGoToCart() {
        productsPage.goToCart();
    }

    @Test(dependsOnMethods = "testGoToCart")
    public void testProceedToCheckout() {
        checkoutPage.proceedToCheckout();
        Assert.assertTrue(checkoutPage.isCheckoutPageLoaded(), "Failed to load checkout page");
    }

    @Test(dependsOnMethods = "testProceedToCheckout")
    public void testFillCheckoutInfo() {
        checkoutPage.fillCheckoutInfo("Rannona", "Ellsayed", "0222");
    }

    @Test(dependsOnMethods = "testFillCheckoutInfo")
    public void testClickContinue() {
        checkoutPage.clickContinue();
    }

    @Test(dependsOnMethods = "testClickContinue")
    public void testClickFinish() {
        checkoutPage.clickFinish();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}