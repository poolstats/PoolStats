package library;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
@javax.persistence.Table
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User player;

    @OneToMany(mappedBy = "pottedBalls")
    private List<Ball> pottedBalls;

    public Turn() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public List<Ball> getPottedBalls() {
        return pottedBalls;
    }

    public void setPottedBalls(List<Ball> pottedBalls) {
        this.pottedBalls = pottedBalls;
    }
}

