package library;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jandie on 2017-05-24.
 */
@Entity
@XmlRootElement
public class Player extends User {

    @OneToOne
    private UserStats userStats;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Player() {
        super();
    }

    public Player(String username, UserStats userStats) {
        super(username);
        this.userStats = userStats;
        this.team = team;
    }

    public UserStats getUserStats() {
        return userStats;
    }

    public void setUserStats(UserStats userStats) {
        this.userStats = userStats;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
