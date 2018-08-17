package de.rainerblessing.savvyclubdvdlist

import org.apache.commons.io.FileUtils
import org.openqa.selenium.By
import org.openqa.selenium.TimeoutException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import java.io.File


class StartPage(private val driver: WebDriver) {

    @FindBy(xpath = "//*[@id=\"header-menu\"]/ul[1]/li[4]/a")
    private val signinLink: WebElement? = null

    @FindBy(xpath = "//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[1]/input")
    private val emailInput: WebElement? = null

    @FindBy(xpath = "//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[2]/input")
    private val passwordInput: WebElement? = null

    @FindBy(className = "bs-login-text")
    private val loginLink: WebElement? = null

    @FindBy(className = "searchTerm")
    private val searchInput: WebElement? = null

    @FindBy(name = "search")
    private val searchButton: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun login(email: String, password: String) {
        val wait2 = WebDriverWait(driver, 20)
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-menu\"]/ul[1]/li[4]/a")))

        val milliseconds: Long = 5000
        sleep(milliseconds)
        try {
            signinLink?.click()
            emailInput?.sendKeys(email)
            sleep(milliseconds)
            passwordInput?.sendKeys(password)

//        wait2.until(ExpectedConditions.textMatches(By.xpath("//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[1]/input"),Pattern.compile(email)))
//        wait2.until(ExpectedConditions.textMatches(By.xpath("//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[2]/input"),Pattern.compile(password)))

            sleep(milliseconds)

            loginLink?.click()
        } catch (e: TimeoutException) {
            val scrFile = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
            FileUtils.copyFile(scrFile, File("failure.jpg"));
        }

    }

    private fun sleep(sleep: Long) {
        try {
            Thread.sleep(sleep)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun search(searchText: String) {
        searchInput?.sendKeys(searchText)
        searchButton?.click()
    }
}