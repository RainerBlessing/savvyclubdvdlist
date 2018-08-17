package de.rainerblessing.savvyclubdvdlist

import java.io.FileInputStream
import java.io.IOException
import java.util.*

object UtilResources {

    private var properties: Properties? = null

    fun loadProperties() {
        try {
            properties = Properties()
            properties?.load(FileInputStream("config.properties"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getProperties(property: String): String {
        loadProperties()
        try {
            return checkNotNull(System.getProperty(property))

        } catch (e: IllegalStateException) {
            return UtilResources.properties?.getProperty(property).toString()
        }
    }
}
