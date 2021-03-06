package library;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
@javax.persistence.Table
public class Pocket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private PocketLocation pocketLocation;

    @OneToMany(targetEntity = Ball.class)
    private List<Ball> pottedBalls;

    public Pocket() {
        super();
    }

    public Pocket(PocketLocation pocketLocation) {
        this.pocketLocation = pocketLocation;

        pottedBalls = new ArrayList<>();
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public PocketLocation getPocketLocation() {
        return pocketLocation;
    }

    public void setPocketLocation(PocketLocation pocketLocation) {
        this.pocketLocation = pocketLocation;
    }

    public void addBall(Ball ball) {
        pottedBalls.add(ball);
    }

    public void removeBall(Ball ball) {
        pottedBalls.remove(ball);
    }

    public enum PocketLocation {
        TOP_LEFT,
        TOP_MID,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_MID,
        BOTTOM_RIGHT
    }
}
