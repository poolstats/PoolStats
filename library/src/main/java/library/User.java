package library;

/**
 * Created by Jandie on 2017-05-03.
 */
public class User {
    private int id;
    private String username;
    private UserStats userStats;

    public User(int id, String username, UserStats userStats) {
        this.id = id;
        this.username = username;
        this.userStats = userStats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
