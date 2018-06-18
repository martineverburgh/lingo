package nl.ITAcademy.project.LINGO.repository;

import nl.ITAcademy.project.LINGO.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    public Player findByPlayerName(String playerName);
}
