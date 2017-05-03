package library;

/**
 * Created by Jandie on 2017-05-03.
 */
public class UserStats {
    private int id;
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;
    private int tournamentsPlayed;
    private int tournamentsWon;
    private int tournamentsLost;
    private int ballsPotted;
    private int shots;

    public UserStats(int id, int matchesPlayed, int matchesWon, int matchesLost, int tournamentsPlayed,
                     int tournamentsWon, int tournamentsLost, int ballsPotted, int shots) {
        this.id = id;
        this.matchesPlayed = matchesPlayed;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.tournamentsPlayed = tournamentsPlayed;
        this.tournamentsWon = tournamentsWon;
        this.tournamentsLost = tournamentsLost;
        this.ballsPotted = ballsPotted;
        this.shots = shots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getTournamentsPlayed() {
        return tournamentsPlayed;
    }

    public void setTournamentsPlayed(int tournamentsPlayed) {
        this.tournamentsPlayed = tournamentsPlayed;
    }

    public int getTournamentsWon() {
        return tournamentsWon;
    }

    public void setTournamentsWon(int tournamentsWon) {
        this.tournamentsWon = tournamentsWon;
    }

    public int getTournamentsLost() {
        return tournamentsLost;
    }

    public void setTournamentsLost(int tournamentsLost) {
        this.tournamentsLost = tournamentsLost;
    }

    public int getBallsPotted() {
        return ballsPotted;
    }

    public void setBallsPotted(int ballsPotted) {
        this.ballsPotted = ballsPotted;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }
}
