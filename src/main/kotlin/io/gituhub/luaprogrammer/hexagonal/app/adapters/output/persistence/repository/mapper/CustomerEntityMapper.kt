package io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.mapper

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.entity.CustomerEntity
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
fun interface CustomerEntityMapper {
    fun toEntity(customer: Customer): CustomerEntity
}