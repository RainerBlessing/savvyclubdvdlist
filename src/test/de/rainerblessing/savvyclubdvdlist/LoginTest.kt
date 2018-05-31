package de.rainerblessing.savvyclubdvdlist

import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.URI
import java.util.regex.Pattern


class LoginTest() : TestBase() {
    @Test
    fun loginEmail() {
        val startPage = StartPage(driver)
        startPage.login("rainer.blessing@gmail.com", "*9@C9R@HH99d")
        val wait = WebDriverWait(driver, 40)
        val element = wait.until(ExpectedConditions.textMatches(By.xpath("//*[@id=\"main\"]/dashboard-header/div/div/div[1]/h1"), Pattern.compile("My Dashboard")))
        Assert.assertTrue(driver.currentUrl.contains("dashboard"))

//        driver.get(URI("https://parellisavvyclub.com/#!/library/12/categories").toString())

        //https://parellisavvyclub.com/#!/library/308/resources?parent=12&title=Savvy%20Club%20DVD%20Issue%201%20December%202003
//        driver.get(URI("https://parellisavvyclub.com/#!/library/308/resources?parent=12&title=Savvy%20Club%20DVD%20Issue%201%20December%202003").toString())
//        driver.get(URI("https://parellisavvyclub.com/#!/library/12/categories").toString())
        driver.get(URI("https://parellisavvyclub.com/#!/library/659/categories").toString())


        val dvdOverViewPage = DvdOverViewPage(driver)
        val hrefs = dvdOverViewPage.getDVDs()

        for (href: String in hrefs) {
            driver.get(URI(href).toString())
            val dvdPage = SavvyClubDVDPage(driver)

            dvdPage.printTitle()
            dvdPage.printContent()
        }

    }
}
