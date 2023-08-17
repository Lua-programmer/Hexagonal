package io.gituhub.luaprogrammer.hexagonal.core.usecases

import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.InsertCustomerInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindAddressByZipCodeOutputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.InsertCustomerOutputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.SendCPFforValidationOutputPort

class InsertCustomerUseCase(
    private val addressOutput: FindAddressByZipCodeOutputPort,
    private val customerOutput: InsertCustomerOutputPort,
    private val sendCPFforValidationOutputPort: SendCPFforValidationOutputPort
): InsertCustomerInputPort {

    override fun insert(customer: Customer, zipcode: String) {
        var address = addressOutput.find(zipcode)
        customer.address = address
        customerOutput.insert(customer)
        sendCPFforValidationOutputPort.send(customer.cpf)
    }
}