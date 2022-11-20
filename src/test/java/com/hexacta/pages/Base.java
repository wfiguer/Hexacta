package com.hexacta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static WebDriver driver;

    By linkSearch = By.xpath("//*[@id=\"menu-social-menu\"]/li/ul/li[1]/a/span");
    By textBoxSearch = By.xpath("//*[@id=\"search-field\"]");
    By linkTitles = By.xpath("//*[@id=\"search-results\"]/div/div/div/div[1]/article");    
    By buttonGotIt = By.xpath("//*[@id=\"top\"]/div[1]/div/button");

    

    public By linkTextTitle(int index) {
        By linkTitle = By.xpath("//*[@id=\"search-results\"]/div/div/div/div[1]/article[" + index + "]/div/h3");
        return linkTitle;
    }

    public By linkReadMore(int index) {
        By linkReadMore = By.xpath("//*[@id=\"search-results\"]/div/div/div/div[1]/article["+index+"]/div/h3/following-sibling::div/a");
        return linkReadMore;
    }

    public void openDriver() {

        System.setProperty("webdriver.chrome.driver", "src//driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public void closeDriver() {
        driver.quit();

    }

    public void goPage() {
        driver.get("https://www.hexacta.com");
        driver.findElement(linkSearch).click();

    }

    public void search() {
        driver.findElement(textBoxSearch).sendKeys("Outsource");
        driver.findElement(textBoxSearch).sendKeys(Keys.ENTER);

    }

    /**
     * Waits for the provided element to be invisible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public Boolean waitForInvisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void verifyPageTitle() throws InterruptedException {
        int titleNumber = driver.findElements(linkTitles).size();
        System.out.println("Title number: " + titleNumber);
        for (int i = 1; i <= titleNumber; i++) {
            String titleText = driver.findElement(linkTextTitle(i)).getText();
            if (titleText.contains("WHAT NOT TO DO WHEN WORKING WITH AN OUTSOURCED SOFTWARE TEAM")) {

                //WebElement blockingElement = driver.findElement(By.xpath("//*[@id=\"top\"]/div[1]"));
                //waitForInvisibility(blockingElement,10);
                
                driver.findElement(buttonGotIt).click();
                driver.findElement(linkReadMore(i)).click();

            }

        }

        Thread.sleep(10000);

    }

}
