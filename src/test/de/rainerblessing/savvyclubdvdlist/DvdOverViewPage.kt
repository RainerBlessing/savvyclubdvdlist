package de.rainerblessing.savvyclubdvdlist

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class DvdOverViewPage(private val driver: WebDriver){

    @FindBy(css= ".ll-subcategories__container ul li a")
    private val dvdLinks: List<WebElement>? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun getDVDs(): List<String> {
        var hrefs:MutableList<String> = mutableListOf()
        if (dvdLinks != null) {
            dvdLinks.mapTo(hrefs) { it!!.getAttribute("href") }
        }
        return hrefs
    }
}