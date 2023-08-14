package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.FindAddressByZipCodeClient
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.mapper.AddressResponseMapper
import io.gituhub.luaprogrammer.hexagonal.core.domain.Address
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val addressByZipCodeClient: FindAddressByZipCodeClient,
): FindAddressByZipCodeOutputPort {

    private lateinit var addressResponseMapper: AddressResponseMapper

    override fun find(zipCode: String): Address {
        var addressResponse = addressByZipCodeClient.find(zipCode)
        return addressResponseMapper.toAddress(addressResponse)
    }
}