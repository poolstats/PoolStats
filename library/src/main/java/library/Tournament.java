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
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private List<Match> matches;
    private List<Team> teams;

    public Tournament() {
        super();
    }

    public Tournament(long id, String name, List<Match> matches, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.matches = matches;
        this.teams = teams;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
