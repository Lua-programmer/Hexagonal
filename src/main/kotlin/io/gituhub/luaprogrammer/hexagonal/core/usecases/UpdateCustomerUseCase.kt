package io.gituhub.luaprogrammer.hexagonal.core.usecases

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.UpdateCustomerInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindAddressByZipCodeOutputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindCustomerByIdOutputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val customerOutput: FindCustomerByIdOutputPort,
    private val addressOutput: FindAddressByZipCodeOutputPort,
    private val customerUpdateOutput: UpdateCustomerOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String): Unit {
        customer.id?.let { customerOutput.find(it) }
        val address = addressOutput.find(zipCode)
        customer.address = address
        customerUpdateOutput.update(customer)
    }
}