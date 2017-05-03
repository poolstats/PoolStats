package library;

import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
public class Table {
    private int id;
    private List<Pocket> pockets;
    private List<Ball> balls;

    public Table(int id, List<Pocket> pockets, List<Ball> balls) {
        this.id = id;
        this.pockets = pockets;
        this.balls = balls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pocket> getPockets() {
        return pockets;
    }

    public void setPockets(List<Pocket> pockets) {
        this.pockets = pockets;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }
}
