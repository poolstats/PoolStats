package library;

import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
public class Tournament {
    private int id;
    private String name;
    private List<Match> matches;
    private List<Team> teams;

    public Tournament(int id, String name, List<Match> matches, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.matches = matches;
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<Team> getTeams() {
        return teams;
    }

    private void addMatch(Match match) {
        matches.add(match);
    }

    private void removeMatch(Match match) {
        matches.remove(match);
    }

    private void addTeam(Team team) {
        teams.add(team);
    }

    private void removeTeam(Team team) {
        teams.remove(team);
    }
}
