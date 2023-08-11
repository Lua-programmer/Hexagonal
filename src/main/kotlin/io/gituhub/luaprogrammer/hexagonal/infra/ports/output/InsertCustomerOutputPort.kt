package io.gituhub.luaprogrammer.hexagonal.infra.ports.output

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer

fun interface InsertCustomerOutputPort {
        fun insert(customer: Customer)
}