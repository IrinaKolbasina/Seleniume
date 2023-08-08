package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestData {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
   public void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
        driver = null;
    }

   // @Test
   // void shouldTestV1() {
      //  List<WebElement> elements = driver.findElements(By.className("input__control"));
     //   elements.get(0).sendKeys("Василий");
     //   elements.get(1).sendKeys("+79270000000");
     //   driver.findElement(By.className("checkbox__box")).click();
     //   driver.findElement(By.className("button")).click();
     //   String text = driver.findElement(By.className("alert-success")).getText();
     //   assertEquals("Ваша заявка успешно отправлена!", text.trim());
    //}

    @Test
    void shouldTestV2() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79270000000");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector("button.button")).click();
        var actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actualText.trim());
    }
}

