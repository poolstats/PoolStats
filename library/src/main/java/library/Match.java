package library;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
@javax.persistence.Table
public class Match {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;

    @OneToOne
    private Table table;

    @OneToMany(targetEntity = Team.class)
    private List<Team> teams;

    @OneToMany(targetEntity = Turn.class)
    private List<Turn> turns;

    private MatchType matchType;

    public Match() {
        super();
    }

    public Match(String name, Table table, Team team1, Team team2, MatchType matchType) {
        this.name = name;
        this.table = table;
        this.matchType = matchType;

        turns = new ArrayList<>();

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void addTurn(Turn turn) {
        turns.add(turn);
    }

    public void removeTurn(Turn turn) {
        turns.remove(turn);
    }

    public enum MatchType {
        EIGHT_BALL,
        NINE_BALL,
        TEN_BALL
    }
}
