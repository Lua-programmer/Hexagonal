package io.gituhub.luaprogrammer.hexagonal.config

import com.fasterxml.jackson.databind.ser.std.StringSerializer
import org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG
import org.apache.kafka.clients.producer.ProducerConfig.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


@Configuration
class KafkaProducerConfig {

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val configProps = HashMap<String, Any>()
        configProps.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        configProps.put(GROUP_ID_CONFIG, "programmer")
        configProps.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
        configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }
}