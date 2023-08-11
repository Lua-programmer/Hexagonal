package io.gituhub.luaprogrammer.hexagonal.infra.ports.input

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import org.springframework.stereotype.Service

@Service
fun interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}