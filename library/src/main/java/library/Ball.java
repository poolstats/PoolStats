package library;

/**
 * Created by Jandie on 2017-05-03.
 */
public class Ball {
    private int Id;
    private int number;
    private BallType ballType;
    private BallColor ballColor;
    private User potter;
    private Pocket.PocketLocation pocket;

    public Ball(int id, int number, BallType ballType, BallColor ballColor, User potter, Pocket.PocketLocation pocket) {
        Id = id;
        this.number = number;
        this.ballType = ballType;
        this.ballColor = ballColor;
        this.potter = potter;
        this.pocket = pocket;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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

    public User getPotter() {
        return potter;
    }

    public void setPotter(User potter) {
        this.potter = potter;
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
