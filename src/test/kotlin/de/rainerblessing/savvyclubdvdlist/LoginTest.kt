package de.rainerblessing.savvyclubdvdlist

import org.testng.Assert
import org.testng.annotations.Test
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.File
import java.net.URI
import java.util.regex.Pattern


class LoginTest : TestBase() {
//    @Test
    fun loginEmail() {
        login()

//        driver.get(URI("https://parellisavvyclub.com/#!/library/12/categories").toString())

        //https://parellisavvyclub.com/#!/library/308/resources?parent=12&title=Savvy%20Club%20DVD%20Issue%201%20December%202003
        driver.get(URI("https://parellisavvyclub.com/#!/library/308/resources?parent=12&title=Savvy%20Club%20DVD%20Issue%201%20December%202003").toString())

        //https://dpibs2eze4uzg.cloudfront.net/hls424x240/kristie-20lesson-20one-20final-1508448069.m3u8
        //#EXTM3U
//        #EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=1140000,RESOLUTION=424x238,CODECS="mp4a.40.5"
//        hls424x240/vonnie-20lesson-20three-1504820408.m3u8
//        #EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=1520000,RESOLUTION=640x360,CODECS="avc1.42001e,mp4a.40.2"
//        hls640x480_PRESET/vonnie-20lesson-20three-1504820408.m3u8
//        #EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=2157000,RESOLUTION=848x476,CODECS="avc1.64001f,mp4a.40.2"
//        hls848x480/vonnie-20lesson-20three-1504820408.m3u8
//        #EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=3386000,RESOLUTION=960x540,CODECS="avc1.42001f,mp4a.40.2"
//        hls960x720/vonnie-20lesson-20three-1504820408.m3u8
//        #EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=3294000,RESOLUTION=1280x720,CODECS="avc1.64001f,mp4a.40.2"
//        hls1280x720/vonnie-20lesson-20three-1504820408.m3u8
//        #EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=4331000,RESOLUTION=1280x720,CODECS="avc1.640029,mp4a.40.2"
//        hls1280x720d/vonnie-20lesson-20three-1504820408.m3u8
//        #EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=12696000,RESOLUTION=1280x720,CODECS="avc1.640029,mp4a.40.2"
//        hls1920x1080/vonnie-20lesson-20three-1504820408.m3u8
//https://parellisavvyclub.com/api/v1/learning_libraries/categories/308/resources?time=1527793067148
        printContent()
    }

    @Test
    fun patTalks() {
        printIssues("https://parellisavvyclub.com/#!/library/594/categories", "audio", "pattalks")
    }

    @Test
    fun essentials() {
        printIssues("https://parellisavvyclub.com/#!/library/659/categories",fileName = "savvyessentials")
    }

    @Test
    fun touchstones(){
        printIssues("https://parellisavvyclub.com/#!/library/11/categories", fileName = "touchstones")
    }

    @Test
    fun savvyClubDVDs() {
        printIssues("https://parellisavvyclub.com/#!/library/12/categories", fileName = "savvyclubdvds")
    }

    @Test
    fun fourSavvysOnLine() {
        printIssues("https://parellisavvyclub.com/#!/library/531/categories", fileName = "foursavvysonline")
    }

    @Test
    fun fourSavvysLiberty() {
        printIssues("https://parellisavvyclub.com/#!/library/536/categories", fileName = "foursavvysliberty")
    }

    @Test
    fun fourSavvysFreestyle() {
        printIssues("https://parellisavvyclub.com/#!/library/547/categories", fileName = "foursavvysfreestyle")
    }

    @Test
    fun fourSavvysFinesse() {
        printIssues("https://parellisavvyclub.com/#!/library/554/categories", fileName = "foursavvysfinesse")
    }
    @Test
    fun Levels2009_1_2() {
        printIssues("https://parellisavvyclub.com/#!/library/554/categories", fileName = "levels2009_1_2")
    }

    @Test
    fun levels2009_3() {
        printIssues("https://parellisavvyclub.com/#!/library/508/categories", fileName = "levels2009_3")
    }

    @Test
    fun levels2009_4() {
        printIssues("https://parellisavvyclub.com/#!/library/512/categories", fileName = "levels2009_4")
    }

    @Test
    fun levels2009_Partnership() {
        printIssues("https://parellisavvyclub.com/#!/library/481/categories", fileName = "partnership")
    }

    @Test
    fun levels2009_Harmony() {
        printIssues("https://parellisavvyclub.com/#!/library/495/categories", fileName = "harmony")
    }

    @Test
    fun vhs_Partnership() {
        printIssues("https://parellisavvyclub.com/#!/library/528/categories", fileName = "vhs_partnership")
    }

    @Test
    fun vhs_Harmony() {
        printIssues("https://parellisavvyclub.com/#!/library/529/categories", fileName = "vhs_harmony")
    }

    @Test
    fun vhs_Refinement() {
        printIssues("https://parellisavvyclub.com/#!/library/530/categories", fileName = "vhs_refinement")
    }

    @Test
    fun insideAccess() {
        printIssues("https://parellisavvyclub.com/#!/library/9/categories", fileName = "insideaccess")
    }

    @Test
    fun masteryLessons() {
        printIssues("https://parellisavvyclub.com/#!/library/14/categories", fileName = "masterylessons")
    }

    @Test
    fun successSeries() {
        printIssues("https://parellisavvyclub.com/#!/library/559/categories", fileName = "successseries")
    }

    @Test
    fun libertyAndHorseBehaviour() {
        printIssues("https://parellisavvyclub.com/#!/library/517/categories", fileName = "libertyandhorsebehaviour")
    }


    @Test
    fun problemSolvingSeries() {
        printIssues("https://parellisavvyclub.com/#!/library/617/categories", fileName = "problemsolvingseries")
    }

    @Test
    fun parelliTV() {
        printIssues("https://parellisavvyclub.com/#!/library/13/categories", fileName = "parellity")
    }

//    @Test
    fun tutorials() {
        //Document
        //ToDo printIssues("https://parellisavvyclub.com/#!/library/703/categories")
    }

//    @Test
    fun memberDocuments() {
        printIssues("https://parellisavvyclub.com/#!/library/617/categories", fileName = "")
    }


    private fun printIssues(url: String, tab: String = "video", fileName: String = ""){
        login()

        driver.get(URI(url).toString())

        loopOverIssues(tab,fileName)
    }

    private fun login() {
        val startPage = StartPage(driver)
        startPage.login(UtilResources.getProperties("email"), UtilResources.getProperties("password"))
        val wait = WebDriverWait(driver, 40)
        wait.until(ExpectedConditions.textMatches(By.xpath("//*[@id=\"main\"]/dashboard-header/div/div/div[1]/h1"), Pattern.compile("My Dashboard")))

        Assert.assertTrue(driver.currentUrl.contains("dashboard"))
    }

//    private fun loopOverIssues() {
//        val dvdOverViewPage = DvdOverViewPage(driver)
//        val hrefs = dvdOverViewPage.getDVDs()
//
//        for (href: String in hrefs) {
//            driver.get(URI(href).toString())
//            printContent()
//        }
//    }

    private fun loopOverIssues(tab: String = "video", fileName: String) {
        val dvdOverViewPage = DvdOverViewPage(driver)
        val hrefs = dvdOverViewPage.getDVDs()

        var printContent:String =""

        for (href: String in hrefs) {
            driver.get(URI(href).toString())
            printContent += printContent(tab)
        }

        if(fileName.isNotEmpty()){
            var myfile: File = File("docs/$fileName.txt")
            myfile.bufferedWriter().use {
                it.write(printContent)
            }
        }
    }

    private fun printContent(): String {
        val dvdPage = SavvyClubDVDPage(driver)

        dvdPage.printTitle()
        dvdPage.printContent()
        dvdPage.printURL()
        dvdPage.printEnd()

        return dvdPage.fileContent
    }

    private fun printContent(tab: String): String {
        val dvdPage = SavvyClubDVDPage(driver)

        when (tab) {
            "audio" -> dvdPage.clickTab(2)
        }

        dvdPage.printTitle()
        dvdPage.printContent()
        dvdPage.printURL()
        dvdPage.printEnd()

        return dvdPage.fileContent
    }
}
