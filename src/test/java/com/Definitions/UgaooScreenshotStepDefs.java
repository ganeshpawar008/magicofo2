package com.Definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert; // Import the Assert class from JUnit
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class UgaooScreenshotStepDefs {

    private WebDriver driver;

    @Given("I open the Ugaoo.com seeds page")
    public void iOpenUgaooSeedsPage() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.ugaoo.com/seeds.html");
    }

    @When("I attempt to find a non-existent element")
    public void iAttemptToFindNonExistentElement() {
        try {
            WebElement nonExistentElement = driver.findElement(By.cssSelector("#nonExistentElement"));
            // Adding a hard assert to fail the test if the element is found
            Assert.fail("Non-existent element found, test should fail!");
        } catch (Exception e) {
            // Exception occurred, capture screenshot
            captureScreenshot("Ugaoo_Exception_Screenshot.png");
            e.printStackTrace();
        }
    }

    @Then("a screenshot is captured on exception")
    public void screenshotCapturedOnException() {
        // Close the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }

    private void captureScreenshot(String fileName) {
        // Use AShot to capture screenshot
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        // Specify the path where you want to save the screenshot in the src/log directory
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Log" + File.separator + fileName;

        // Save the screenshot to the specified path
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(filePath));
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
