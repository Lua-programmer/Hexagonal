package io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.mapper

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.entity.AddressEntity
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.entity.CustomerEntity
import io.gituhub.luaprogrammer.hexagonal.core.domain.Address
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer

fun Customer.toEntity(): CustomerEntity? =
    this.address?.let {
        AddressEntity(
            street = it.street,
            city = this.address!!.city,
            state = this.address!!.state,
        )
    }?.let {
        CustomerEntity(
            id = this.id,
            name = this.name,
            address = it,
            cpf = this.cpf
        )
    }

fun CustomerEntity.toDomain(): Customer =
    Customer(
        name = this.name,
        address = Address(
            street = this.address.street,
            city = this.address.city,
            state = this.address.state,
        ),
        cpf = this.cpf
    )