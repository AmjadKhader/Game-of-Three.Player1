package justeattakeaway.player1.controller;

import justeattakeaway.player1.service.PlayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController()
@RequestMapping("/game")
public class PlayController {

    private final PlayService playService;

    public PlayController(PlayService playService) {
        this.playService = playService;
    }

    @PostMapping(value = "/play", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> startPlay(@RequestBody String startingValue) {
        if (Objects.isNull(startingValue) || Integer.parseInt(startingValue) < 3) {
            throw new IllegalArgumentException();
        }

        playService.startPlay(Integer.parseInt(startingValue));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
