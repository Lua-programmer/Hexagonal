package io.gituhub.luaprogrammer.hexagonal.core.usecases

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val customerOutput: FindCustomerByIdOutputPort
) {

    fun find(id: String): Customer? {
        return customerOutput.find(id)
    }
}