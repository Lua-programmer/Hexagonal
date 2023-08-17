package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.mapper

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.CustomerMessage
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer

fun CustomerMessage.toCustomer(): Customer =
    Customer(
        id = this.id,
        name = this.name,
        cpf = this.cpf,
        isValidCpf = this.isValidCpf,
    )
