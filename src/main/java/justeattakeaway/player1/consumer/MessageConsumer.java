package justeattakeaway.player1.consumer;

import justeattakeaway.player1.producer.MessageProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static justeattakeaway.player1.Player1Application.game;

@Component
public class MessageConsumer {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final MessageProducer producer;

    public MessageConsumer(MessageProducer producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = "game.p1", groupId = "player1")
    public void listen(ConsumerRecord<String, Integer> consumerRecord) {
        Integer receivedNumber = consumerRecord.value();
        logger.info("----------------------");
        logger.info("[GAME-OF-THREE][Player 1] receives: " + receivedNumber);

        game.playTurn(receivedNumber);
        if (game.isGameOver()) {
            logger.info("[GAME-OF-THREE] Player 1 WINS!!");
        } else {
            producer.send(game.getCurrentNumber());
        }
    }
}
