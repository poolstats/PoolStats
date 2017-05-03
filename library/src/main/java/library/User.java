package library;

import javax.persistence.*;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
@javax.persistence.Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;

    @OneToOne
    private UserStats userStats;

    public User() {
        super();
    }

    public User(long id, String username, UserStats userStats) {
        this.id = id;
        this.username = username;
        this.userStats = userStats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
