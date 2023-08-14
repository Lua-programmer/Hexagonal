package io.gituhub.luaprogrammer.hexagonal.config

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.FindCustomerByIdAdapter
import io.gituhub.luaprogrammer.hexagonal.core.usecases.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerByIdUseCase(
        findCustomerByIdAdapter: FindCustomerByIdAdapter
    ): FindCustomerByIdUseCase = FindCustomerByIdUseCase(findCustomerByIdAdapter)
}