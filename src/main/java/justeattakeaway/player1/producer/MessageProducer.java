package justeattakeaway.player1.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static justeattakeaway.player1.Player1Application.game;

@Component
public class MessageProducer {

    private final KafkaTemplate<String, Integer> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, Integer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Integer message) {
        System.out.println("[GAME-OF-THREE][Player 1] sends :" + message);
        kafkaTemplate.send("game.p2", message);
    }
}
