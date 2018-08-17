package de.rainerblessing.savvyclubdvdlist

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory


class SavvyClubDVDPage(private val driver: WebDriver) {
    @FindBy(css = ".prl__player__playlist__title")
    private val listItems: List<WebElement>? = null

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div[1]/span")
    private val title: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun printTitle() {
        printlnLocal(title?.text!!)
        title.text!!.length.downTo(0).forEach { print("-") }
        printlnLocal("")
    }

    fun printContent() {

        listItems?.forEach { listItem: WebElement ->
            run {
                try {
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                if (listItem.text != "") {
                    printlnLocal(listItem.text)
                }
            }
        }

    }

    fun printEnd() {
        40.downTo(0).forEach { print("=") }
        printlnLocal("")
    }

    fun printURL() {
        printlnLocal(driver.currentUrl)
    }

    fun clickTab(i: Int) {

        val tabElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/ul/li[$i]/a"))

        val js = driver as JavascriptExecutor
        js.executeScript("jQuery(\".active\").removeClass(\"active in\")")
        tabElement.click()
        try {
            Thread.sleep(1500)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        js.executeScript("jQuery(\".tab-content div:nth-child($i)\").addClass(\"active in\")")

    }

    var fileContent: String =""

    fun printlnLocal(line: String) {
        this.fileContent += line + "\n"
        System.out.println(line)
    }

    fun print(text: String) {
        this.fileContent += text
        System.out.print(text)
    }
}