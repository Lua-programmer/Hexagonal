package io.gituhub.luaprogrammer.hexagonal.config

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.FindAddressByZipCodeAdapter
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.FindCustomerByIdAdapter
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.UpdateCustomerAdapter
import io.gituhub.luaprogrammer.hexagonal.core.usecases.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomerUseCase(
        updateCustomerAdapter: UpdateCustomerAdapter,
        findCustomerByIdAdapter: FindCustomerByIdAdapter,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter
    ): UpdateCustomerUseCase = UpdateCustomerUseCase(
        findCustomerByIdAdapter, findAddressByZipCodeAdapter, updateCustomerAdapter)
}