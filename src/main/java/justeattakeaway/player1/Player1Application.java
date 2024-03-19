package justeattakeaway.player1;

import justeattakeaway.Game;
import justeattakeaway.player1.configuration.KafkaConsumerConfiguration;
import justeattakeaway.player1.configuration.KafkaProducerConfiguration;
import justeattakeaway.player1.producer.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({KafkaConsumerConfiguration.class, KafkaProducerConfiguration.class})
public class Player1Application {

    public static Game game = new Game();
    private static MessageProducer producer = null;

    public Player1Application(MessageProducer producer) {
        Player1Application.producer = producer;
    }

    public static void main(String[] args) {
        SpringApplication.run(Player1Application.class, args);

        /**
         * If you want to stop the automatic starting of the game add manual string as an argument.
         * This was added because I had a question to the recruiter about explaining this sentence:
         * "Both players should be able to play automatically without user input.
         * The type of input (manual, automatic) should be optionally adjustable by the player."
         * Which was confusing to me, I asked for a clarification but got nothing.
         * In Automatic mode, once the application is started the game will start, PLUS giving the user the ability
         * to start a game manually by calling POST game/start.
         * In Manual mode, the game wont start automatically and the user has the ability to use the api to start a game
         * */
        if (args.length == 0 || !args[0].equalsIgnoreCase("manual")) {
            createGame();
        }
    }

    public static void createGame() {
        producer.send(game.getCurrentNumber());
    }
}
