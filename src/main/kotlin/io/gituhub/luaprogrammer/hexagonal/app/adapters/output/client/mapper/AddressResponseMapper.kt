package io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.mapper

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.response.AddressResponse
import io.gituhub.luaprogrammer.hexagonal.core.domain.Address
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
fun interface AddressResponseMapper {
    fun toAddress(addressResponse: AddressResponse): Address
}