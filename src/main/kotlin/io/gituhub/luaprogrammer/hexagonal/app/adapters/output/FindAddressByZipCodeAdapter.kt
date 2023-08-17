package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.FindAddressByZipCodeClient
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.mapper.toAddress
import io.gituhub.luaprogrammer.hexagonal.core.domain.Address
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val addressByZipCodeClient: FindAddressByZipCodeClient,
): FindAddressByZipCodeOutputPort {

    override fun find(zipcode: String): Address {
        addressByZipCodeClient.find(zipcode).toAddress().let { address ->
            return address
        }
    }
}