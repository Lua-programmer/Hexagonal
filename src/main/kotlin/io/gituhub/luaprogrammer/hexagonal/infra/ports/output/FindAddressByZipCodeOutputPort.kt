package io.gituhub.luaprogrammer.hexagonal.infra.ports.output

import io.gituhub.luaprogrammer.hexagonal.core.domain.Address

fun interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}