package de.rainerblessing.savvyclubdvdlist

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SavvyClubDVDPage(driver: WebDriver){
    @FindBy(css = ".prl__player__playlist__title")
    private val listItems: List<WebElement>? = null

    @FindBy(xpath= "//*[@id=\"content\"]/div/div[2]/div[1]/span")
    private val title: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun printTitle() {
        println(title?.text)
        title?.text!!.length.downTo(0).forEach { print("-") }
        println("")
    }

    fun printContent() {

        listItems?.forEach { listItem:WebElement ->
            run {
                try {
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                if(listItem.text!="") {
                    println(listItem.text)
                }
            }
            }
        40.downTo(0).forEach { print("=") }
        println("")
    }

}