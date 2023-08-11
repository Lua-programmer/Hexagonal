package io.gituhub.luaprogrammer.hexagonal.infra.ports.input

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer

fun interface InsertCustomerInputPort {
    fun insert(customer: Customer, zipCode: String)
}