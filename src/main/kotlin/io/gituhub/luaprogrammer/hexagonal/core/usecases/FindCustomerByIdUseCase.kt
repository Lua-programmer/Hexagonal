package io.gituhub.luaprogrammer.hexagonal.core.usecases

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.FindCustomerByIdInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val customerOutput: FindCustomerByIdOutputPort
): FindCustomerByIdInputPort {

    override fun findById(id: String): Customer? {
        return customerOutput.find(id)
    }
}