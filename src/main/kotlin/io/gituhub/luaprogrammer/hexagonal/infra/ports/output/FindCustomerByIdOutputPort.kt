package io.gituhub.luaprogrammer.hexagonal.infra.ports.output

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import java.util.Optional

fun interface FindCustomerByIdOutputPort {

    fun find(id: String): Optional<Customer>
}