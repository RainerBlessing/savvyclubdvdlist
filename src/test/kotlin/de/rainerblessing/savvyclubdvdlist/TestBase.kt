package de.rainerblessing.savvyclubdvdlist

import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Reporter
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeTest
import java.net.URI
import java.util.concurrent.TimeUnit
import org.openqa.selenium.chrome.ChromeOptions
import java.awt.SystemColor.window





abstract class TestBase {

    lateinit var driver: WebDriver
        private set

    @BeforeClass
    fun setup() {
        System.setProperty(UtilResources.getProperties("nameDriver"),
                UtilResources.getProperties("pathDriver") + UtilResources.getProperties("exeDriver"))
        val options = ChromeOptions()
        options.addArguments("headless")
        options.addArguments("disable-gpu")
        options.addArguments("no-sandbox")
        options.addArguments("disable-dev-shm-usage")
        driver = ChromeDriver(options)
        driver.manage().deleteAllCookies();
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
//        driver.manage()?.window()?.maximize()
        driver.manage().window().size = Dimension(2000, 1200)
        driver.get(URI(UtilResources.getProperties("pageURL")).toString())
    }

    @AfterClass
    fun driverClose() {
        driver.close()
    }
}