package com.measuredsoftware.kotlinmodels.util

import com.measuredsoftware.kotlinmodels.dto.Address
import com.measuredsoftware.kotlinmodels.dto.Contact

/**
 * Created by neil.wilkinson on 07/07/2016.
 */
fun Contact.displayFormat() = "${this.apiId} ${this.id} ${this.name} ${this.address.displayFormat()}"

fun Address.displayFormat() = "${this.id} ${this.street1} ${this.street2}, ${this.town}"
