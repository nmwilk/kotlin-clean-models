package com.measuredsoftware.kotlinmodels

import android.util.Log
import com.measuredsoftware.kotlinmodels.api.ApiContact
import com.measuredsoftware.kotlinmodels.dto.Address
import com.measuredsoftware.kotlinmodels.dto.Contact
import com.measuredsoftware.kotlinmodels.util.displayFormat
import java.util.*

/**
 * Created by neil.wilkinson on 07/07/2016.
 */

fun generateUuid() = UUID.randomUUID().toString()

fun buildDisplayContactString(list: List<Contact>): String {
    val stringBuffer: StringBuffer = StringBuffer()

    list.forEach {
        val displayFormat = it.displayFormat()

        stringBuffer.append(displayFormat + "\n\n")
        Log.i("contact", displayFormat)
    }

    return stringBuffer.toString()
}

fun mapApiContactsToContacts(list: List<ApiContact>): List<Contact> {
    val uuid = generateUuid()
    return list.map {
        Contact(apiId = it.apiId, id = uuid, address = Address(id = uuid, street1 = it.street, street2 = "", town = it.town), name = it.name)
    }
}