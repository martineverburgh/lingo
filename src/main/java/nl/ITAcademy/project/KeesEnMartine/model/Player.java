package nl.ITAcademy.project.KeesEnMartine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "players")
@EntityListeners(AuditingEntityListener.class)
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(unique=true)
    private String playerName;

    private int lingoScore;

    private int memoryScore;

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLingoScore() {
        return lingoScore;
    }

    public void setLingoScore(int lingoScore) {
        this.lingoScore = lingoScore;
    }

    public int getMemoryScore() {
        return memoryScore;
    }

    public void setMemoryScore(int memoryScore) {
        this.memoryScore = memoryScore;
    }
}
