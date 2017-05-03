package library;

import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
public class Turn {
    private int id;
    private Team team;
    private List<Ball> pottedBalls;

    public Turn(int id, Team team, List<Ball> pottedBalls) {
        this.id = id;
        this.team = team;
        this.pottedBalls = pottedBalls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

