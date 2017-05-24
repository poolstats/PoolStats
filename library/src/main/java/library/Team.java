package library;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
@javax.persistence.Table
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;

    @OneToMany(mappedBy="team", cascade = {CascadeType.PERSIST})
    private List<User> players;

    public Team() {
        super();
    }

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
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

    public void addMember(User user) {
        if(!players.contains(user)) {
            players.add(user);
        }

        user.setTeam(this);
    }
}
