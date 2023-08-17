package io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.mapper

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.response.AddressResponse
import io.gituhub.luaprogrammer.hexagonal.core.domain.Address

fun AddressResponse.toAddress(): Address =
    Address(
        street = this.street,
        city = this.city,
        state = this.state,
    )
