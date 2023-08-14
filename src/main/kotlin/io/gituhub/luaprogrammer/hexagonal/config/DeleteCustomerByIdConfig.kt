package io.gituhub.luaprogrammer.hexagonal.config

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.DeleteCustomerByIdAdapter
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.FindCustomerByIdAdapter
import io.gituhub.luaprogrammer.hexagonal.core.usecases.DeleteCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerByIdConfig {

    @Bean
    fun deleteCustomerByIdUseCase(
        findCustomerByIdAdapter: FindCustomerByIdAdapter,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ): DeleteCustomerByIdUseCase = DeleteCustomerByIdUseCase(findCustomerByIdAdapter, deleteCustomerByIdAdapter)
}