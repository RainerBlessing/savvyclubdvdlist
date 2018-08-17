package de.rainerblessing.savvyclubdvdlist

import org.apache.commons.io.FileUtils
import org.openqa.selenium.*
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
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

    @FindBy(xpath = "*[@id=\"header\"]/div/div/nav/div[1]/button")
//    @FindBy(className = "navbar-toggle")
    private val navbarToggle: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun login(email: String, password: String): Boolean {
        try {

            val milliseconds: Long = 2000
            sleep(milliseconds)
            if (signinLink?.isDisplayed!!) {
                signinLink?.click()
            } else {

                val js = driver as JavascriptExecutor
                js.executeScript("\$('.navbar-toggle').click()")
                sleep(1000)
                signinLink?.click()
            }
            sleep(5000)
            emailInput?.sendKeys(email)
            sleep(milliseconds)
            passwordInput?.sendKeys(password)

//        wait2.until(ExpectedConditions.textMatches(By.xpath("//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[1]/input"),Pattern.compile(email)))
//        wait2.until(ExpectedConditions.textMatches(By.xpath("//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[2]/input"),Pattern.compile(password)))

            sleep(milliseconds)

            loginLink?.click()
        } catch (e: Exception) {
            val scrFile = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
            FileUtils.copyFile(scrFile, File("failure.jpg"));
        }

        return true
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