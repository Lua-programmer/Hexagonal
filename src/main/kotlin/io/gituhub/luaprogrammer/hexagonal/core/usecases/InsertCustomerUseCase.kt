package io.gituhub.luaprogrammer.hexagonal.core.usecases

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.InsertCustomerInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindAddressByZipCodeOutputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.InsertCustomerOutputPort

class InsertCustomerUseCase(
    private val addressOutput: FindAddressByZipCodeOutputPort,
    private val customerOutput: InsertCustomerOutputPort
): InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        var address = addressOutput.find(zipCode)
        customer.address = address
        customerOutput.insert(customer)
    }
}