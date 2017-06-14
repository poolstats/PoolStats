package library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
@javax.persistence.Table
public class UserStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String matchesPlayed;
    private String matchesWon;
    private String matchesLost;
    private String tournamentsPlayed;
    private String tournamentsWon;
    private String tournamentsLost;
    private String ballsPotted;
    private String shots;

    public UserStats() {
        super();
    }

    public UserStats(String matchesPlayed, String matchesWon, String matchesLost, String tournamentsPlayed,
                     String tournamentsWon, String tournamentsLost, String ballsPotted, String shots) {
        this.matchesPlayed = matchesPlayed;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.tournamentsPlayed = tournamentsPlayed;
        this.tournamentsWon = tournamentsWon;
        this.tournamentsLost = tournamentsLost;
        this.ballsPotted = ballsPotted;
        this.shots = shots;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(String matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public String getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(String matchesWon) {
        this.matchesWon = matchesWon;
    }

    public String getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(String matchesLost) {
        this.matchesLost = matchesLost;
    }

    public String getTournamentsPlayed() {
        return tournamentsPlayed;
    }

    public void setTournamentsPlayed(String tournamentsPlayed) {
        this.tournamentsPlayed = tournamentsPlayed;
    }

    public String getTournamentsWon() {
        return tournamentsWon;
    }

    public void setTournamentsWon(String tournamentsWon) {
        this.tournamentsWon = tournamentsWon;
    }

    public String getTournamentsLost() {
        return tournamentsLost;
    }

    public void setTournamentsLost(String tournamentsLost) {
        this.tournamentsLost = tournamentsLost;
    }

    public String getBallsPotted() {
        return ballsPotted;
    }

    public void setBallsPotted(String ballsPotted) {
        this.ballsPotted = ballsPotted;
    }

    public String getShots() {
        return shots;
    }

    public void setShots(String shots) {
        this.shots = shots;
    }
}
