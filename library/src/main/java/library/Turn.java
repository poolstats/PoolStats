package library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
@javax.persistence.Table
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Team team;
    private List<Ball> pottedBalls;

    public Turn() {
        super();
    }

    public Turn(long id, Team team, List<Ball> pottedBalls) {
        this.id = id;
        this.team = team;
        this.pottedBalls = pottedBalls;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Ball> getPottedBalls() {
        return pottedBalls;
    }

    public void setPottedBalls(List<Ball> pottedBalls) {
        this.pottedBalls = pottedBalls;
    }
}

