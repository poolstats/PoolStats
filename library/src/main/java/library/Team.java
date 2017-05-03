package library;

import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
public class Team {
    private int Id;
    private String name;
    private List<User> players;

    public Team(int id, String name, List<User> players) {
        Id = id;
        this.name = name;
        this.players = players;
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

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }
}
