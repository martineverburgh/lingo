package nl.ITAcademy.project.KeesEnMartine.controller;

import nl.ITAcademy.project.KeesEnMartine.model.Player;
import nl.ITAcademy.project.KeesEnMartine.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @PostMapping
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/{playerName}")
    public Player getPlayerbyPlayerName(@PathVariable(value = "playerName") String playerName) {
        return playerRepository.findByPlayerName(playerName);
    }

    @PutMapping("/players")
    public Player updatePlayerName(Player currentPlayer, Player playerWithNewUsername) {

        Player existingPlayer = getPlayerbyPlayerName(currentPlayer.getPlayerName());
        existingPlayer.setPlayerName(playerWithNewUsername.getPlayerName());

        Player updatedPlayer = playerRepository.save(existingPlayer);
        return updatedPlayer;
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "playerName") String playerName) {
        Player player = playerRepository.findByPlayerName(playerName);

        playerRepository.delete(player);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/lingohighscores")
    public List<Player> getLingoHighScores(){
        return playerRepository.findTop3ByOrderByLingoScoreDesc();
    }
}