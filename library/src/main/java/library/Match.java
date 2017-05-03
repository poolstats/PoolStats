package library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
public class Match {
    private int Id;
    private String name;
    private Table table;
    private Team[] teams;
    private List<Turn> turns;

    public Match(int id, String name, Table table, Team team1, Team team2) {
        Id = id;
        this.name = name;
        this.table = table;

        turns = new ArrayList<>();

        teams = new Team[2];
        teams[0] = team1;
        teams[1] = team2;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
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
