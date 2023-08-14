package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.mapper

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.CustomerMessage
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    fun toCustomer(customerMessage: CustomerMessage): Customer
}