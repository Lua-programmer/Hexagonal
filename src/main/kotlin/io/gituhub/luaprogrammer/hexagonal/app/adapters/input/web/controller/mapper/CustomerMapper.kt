package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.mapper

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.request.CustomerRequest
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.response.AddressResponse
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.response.CustomerResponse
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer

fun CustomerRequest.toCustomer(): Customer =
    Customer(
        name = this.name,
        cpf = this.cpf,
    )

fun Customer.toCustomerResponse(): CustomerResponse? =
    this.address?.let {
        AddressResponse(
            street = it.street,
            city = this.address!!.city,
            state = this.address!!.state,
        )
    }?.let {
            this.isValidCpf?.let { iterator ->
                CustomerResponse(
                name = this.name,
                address = it,
                cpf = this.cpf,
                isValidCpf = iterator,
            )
        }
    }
