package io.gituhub.luaprogrammer.hexagonal

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.CustomerRepository
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignAutoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableFeignClients("io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client")
@EnableMongoRepositories(basePackageClasses = [CustomerRepository::class])
@ImportAutoConfiguration(FeignAutoConfiguration::class)
@SpringBootApplication
class HexagonalApplication

fun main(args: Array<String>) {
    runApplication<HexagonalApplication>(*args)
}
