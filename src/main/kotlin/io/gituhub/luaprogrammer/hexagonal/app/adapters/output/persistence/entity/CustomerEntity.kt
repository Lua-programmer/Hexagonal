package io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class CustomerEntity (

        @Id
        val id: String?,

        val name: String,

        var address: AddressEntity,

        val cpf: String,
)