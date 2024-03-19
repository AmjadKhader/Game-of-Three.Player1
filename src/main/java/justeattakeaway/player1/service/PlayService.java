package justeattakeaway.player1.service;

import justeattakeaway.player1.producer.MessageProducer;
import org.springframework.stereotype.Service;

import static justeattakeaway.player1.Player1Application.game;

@Service
public class PlayService {

    private final MessageProducer messageProducer;

    public PlayService(
            MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void startPlay(Integer startingValue) {
        game.setCurrentNumber(startingValue);
        messageProducer.send(startingValue);
    }
}