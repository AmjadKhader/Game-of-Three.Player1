package justeattakeaway.player1;

import justeattakeaway.enums.GameMode;
import justeattakeaway.player1.configuration.KafkaConsumerConfiguration;
import justeattakeaway.player1.configuration.KafkaProducerConfiguration;
import justeattakeaway.player1.producer.GameProducer;
import justeattakeaway.player1.utils.Constants;
import justeattakeaway.scan.ScanInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Objects;

@SpringBootApplication
@EnableConfigurationProperties({KafkaConsumerConfiguration.class, KafkaProducerConfiguration.class})
public class Player1Application {

    private static GameProducer gameProducer = null;

    public Player1Application(GameProducer gameProducer) {
        Player1Application.gameProducer = gameProducer;
    }

    public static void main(String[] args) {

        String mode = System.getenv("mode");
        if (Objects.nonNull(mode) &&
                (mode.equalsIgnoreCase("manual")
                        || mode.equalsIgnoreCase("automatic"))) {
            SpringApplication.run(Player1Application.class, args);

            if (mode.equalsIgnoreCase("manual")) {
                Constants.gameMode = (GameMode.MANUAL);
                createGame(ScanInput.getInstance().scanInt());
            } else {
                Constants.gameMode = (GameMode.AUTOMATIC);
                createGame();
            }
        }
    }

    public static void createGame() {
        gameProducer.send(Constants.game.getCurrentNumber());
    }

    public static void createGame(int startingValue) {
        gameProducer.send(startingValue);
    }
}

