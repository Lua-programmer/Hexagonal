package io.gituhub.luaprogrammer.hexagonal.config

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.FindAddressByZipCodeAdapter
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.InsertCustomerAdapter
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.SendCPFValidationAdapter
import io.gituhub.luaprogrammer.hexagonal.core.usecases.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomerUseCase(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter,
        sendCPFValidationAdapter: SendCPFValidationAdapter
    ): InsertCustomerUseCase = InsertCustomerUseCase(
        findAddressByZipCodeAdapter, insertCustomerAdapter,sendCPFValidationAdapter )
}