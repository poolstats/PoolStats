package library;

import javax.persistence.*;
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

    @OneToMany(targetEntity = Match.class)
    private List<Match> matches;

    @OneToMany(targetEntity = Team.class)
    private List<Team> teams;

    public Tournament() {
        super();
    }

    public Tournament(String name, List<Match> matches, List<Team> teams) {
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

    @OneToMany
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
