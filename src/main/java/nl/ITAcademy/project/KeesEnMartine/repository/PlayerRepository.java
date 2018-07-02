package nl.ITAcademy.project.KeesEnMartine.repository;

import nl.ITAcademy.project.KeesEnMartine.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByPlayerName(String playerName);
}
