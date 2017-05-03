package library;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
@Entity
@javax.persistence.Table
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "pockets")
    private List<Pocket> pockets;

    @OneToMany(mappedBy = "balls")
    private List<Ball> balls;

    public Table() {
        super();
    }

    public Table(long id, List<Pocket> pockets, List<Ball> balls) {
        this.id = id;
        this.pockets = pockets;
        this.balls = balls;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
