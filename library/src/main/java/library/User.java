package library;

import javax.persistence.*;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
public class User {
    @Id
    private String username;

    @OneToOne
    private UserStats userStats;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public User() {
        super();
    }

    public User(String username, UserStats userStats) {
        this.username = username;
        this.userStats = userStats;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserStats getUserStats() {
        return userStats;
    }

    public void setUserStats(UserStats userStats) {
        this.userStats = userStats;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
