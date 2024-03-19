package justeattakeaway.player1.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "kafka.producer")
@EnableConfigurationProperties
public class KafkaProducerConfiguration {
    private String bootstrapServers;
    private String keyDeserializer;
    private String valueDeserializer;
}