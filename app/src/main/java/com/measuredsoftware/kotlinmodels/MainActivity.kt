package com.measuredsoftware.kotlinmodels

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.measuredsoftware.kotlinmodels.api.ApiContact
import com.measuredsoftware.kotlinmodels.dto.Address
import com.measuredsoftware.kotlinmodels.dto.Contact
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view) as TextView

        tv.text = mapToContactString()
    }

    private val list: List<ApiContact>
        get() {
            val apiContacts = listOf(ApiContact(1, "Andy", "Aardvark Street", "Airton"), ApiContact(2, "Brian", "Bird Street", "Barton"))
            return apiContacts
        }

    private fun mapToContactString(): String {
        val stringBuffer: StringBuffer = StringBuffer()

        val uuid = generateUuid()
        val contacts = list.map {
            Contact(apiId = it.apiId, id = uuid, address = Address(id = uuid, street1 = it.street, street2 = "", town = it.town), name = it.name)
        }

        contacts.forEach {
            val displayFormat = it.displayFormat()

            stringBuffer.append(displayFormat + "\n\n")
            Log.i("contact", displayFormat)
        }

        return stringBuffer.toString()
    }

    private fun generateUuid() = UUID.randomUUID().toString()
}

fun Contact.displayFormat() = "${this.apiId} ${this.id} ${this.name} ${this.address.displayFormat()}"

fun Address.displayFormat() = "${this.id} ${this.street1} ${this.street2}, ${this.town}"