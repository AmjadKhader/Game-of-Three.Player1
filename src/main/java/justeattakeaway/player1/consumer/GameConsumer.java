package justeattakeaway.player1.consumer;

import justeattakeaway.player1.gameplay.Play;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class GameConsumer {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final Play gameplay;

    public GameConsumer(Play gameplay) {
        this.gameplay = gameplay;
    }

    @KafkaListener(topics = "game.p1", groupId = "player1")
    public void listen(ConsumerRecord<String, Integer> consumerRecord) {
        Integer receivedNumber = consumerRecord.value();

        logger.info("----------------------");
        logger.info("[GAME-OF-THREE][Player 1] receives: " + receivedNumber);

        gameplay.myTurn(receivedNumber);
    }
}
