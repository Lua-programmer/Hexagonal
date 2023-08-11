package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.mapper

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.request.CustomerRequest
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.response.CustomerResponse
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    fun toCustomer(customerRequest: CustomerRequest): Customer

    fun toCustomerResponse(customer: Customer): CustomerResponse
}