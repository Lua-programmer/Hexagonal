package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.SendCPFforValidationOutputPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendCPFValidationAdapter(
    private val kafkaTemplate: KafkaTemplate<String, String>
): SendCPFforValidationOutputPort {
    override fun send(cpf: String) {
        kafkaTemplate.send("tp-cpf-validation", cpf)
    }
}
