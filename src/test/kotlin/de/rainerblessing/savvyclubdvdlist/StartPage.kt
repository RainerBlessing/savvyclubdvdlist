package de.rainerblessing.savvyclubdvdlist

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class StartPage(private val driver: WebDriver) {

    @FindBy(xpath= "//*[@id=\"header-menu\"]/ul[1]/li[4]/a")
    private val signinLink: WebElement? = null

    @FindBy(xpath= "//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[1]/input")
    private val emailInput: WebElement? = null

    @FindBy(xpath= "//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[2]/input")
    private val passwordInput: WebElement? = null

    @FindBy(className = "bs-login-text")
    private val loginLink: WebElement? = null

    @FindBy(className= "searchTerm")
    private val searchInput: WebElement? = null

    @FindBy(name= "search")
    private val searchButton: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun login(email: String, password: String) {
        val wait2 = WebDriverWait(driver, 10)
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-menu\"]/ul[1]/li[4]/a")))

        val milliseconds: Long = 1000
        sleep(milliseconds)

        signinLink?.click()
        emailInput?.sendKeys(email)
        sleep(1000)
        passwordInput?.sendKeys(password)

//        wait2.until(ExpectedConditions.textMatches(By.xpath("//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[1]/input"),Pattern.compile(email)))
//        wait2.until(ExpectedConditions.textMatches(By.xpath("//*[@id=\"loginPopup\"]/div/div/div[2]/form/div[1]/div[2]/input"),Pattern.compile(password)))

        sleep(2000)

        loginLink?.click()
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