package library;

/**
 * Created by Jandie on 2017-05-03.
 */
public class Ball {
    private int Id;
    private int number;
    private BallType ballType;
    private BallColor ballColor;
    private User user;

    public Ball(int id, int number, BallType ballType, BallColor ballColor, User user) {
        Id = id;
        this.number = number;
        this.ballType = ballType;
        this.ballColor = ballColor;
        this.user = user;
    }

    public int getId() {
        return Id;
    }

    public int getNumber() {
        return number;
    }

    public BallType getBallType() {
        return ballType;
    }

    public BallColor getBallColor() {
        return ballColor;
    }

    public User getUser() {
        return user;
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
