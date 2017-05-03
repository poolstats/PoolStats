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
public class Ball {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private int number;
    private BallType ballType;
    private BallColor ballColor;
    private Pocket.PocketLocation pocket;

    public Ball() {
        super();
    }

    public Ball(int number, BallType ballType, BallColor ballColor, Pocket.PocketLocation pocket) {
        this.number = number;
        this.ballType = ballType;
        this.ballColor = ballColor;
        this.pocket = pocket;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public BallColor getBallColor() {
        return ballColor;
    }

    public void setBallColor(BallColor ballColor) {
        this.ballColor = ballColor;
    }

    public Pocket.PocketLocation getPocket() {
        return pocket;
    }

    public void setPocket(Pocket.PocketLocation pocket) {
        this.pocket = pocket;
    }

    public enum BallType {
        STRIPED,
        SOLID,
        CUE
    }

    public enum BallColor{
        YELLOW,
        BLUE,
        RED,
        GREEN,
        PURPLE,
        BLACK,
        WHITE,
        ORANGE,
        BROWN
    }
}
