package nl.ITAcademy.project.LINGO.controller;

import nl.ITAcademy.project.LINGO.model.Player;
import nl.ITAcademy.project.LINGO.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/players/{playerName}")
    public Player getPlayerbyPlayerName(@PathVariable(value = "playerName") String playerName) {
        return playerRepository.findByPlayerName(playerName);
    }

    @PutMapping("/players/{playerName}")
    public Player updatePlayer(@PathVariable(value = "playerName") String playerName, @Valid @RequestBody Player playerDetails) {

        Player player = playerRepository.findByPlayerName(playerName);

        player.setPlayerName(playerDetails.getPlayerName());
        player.setLingoScore(playerDetails.getLingoScore());
        player.setMemoryScore(playerDetails.getMemoryScore());

        Player updatedPlayer = playerRepository.save(player);
        return updatedPlayer;
    }

    @DeleteMapping("/players/{playerName}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "playerName") String playerName) {
        Player player = playerRepository.findByPlayerName(playerName);

        playerRepository.delete(player);

        return ResponseEntity.ok().build();
    }
}