package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class GoogleTitleTest {

    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(GoogleTitleTest.class);

    @BeforeClass
    public void setUp() {
        // Укажите путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        logger.info("Запускаем браузер");
    }

    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        logger.info("Получен заголовок страницы: " + title);
        Assert.assertEquals(title, "Google", "Заголовок страницы не соответствует ожидаемому значению");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Закрываем браузер");
        }
    }
}
