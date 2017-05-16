package logic;

import library.Ball;
import library.Match;
import library.Pocket;
import library.Table;
import repo.BallRepo;
import repo.PocketRepo;
import repo.TableRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TableLogic {
    private TableRepo tableRepo;
    private BallRepo ballRepo;
    private PocketRepo pocketRepo;

    public TableLogic() {
        this.tableRepo = new TableRepo();
        this.ballRepo = new BallRepo();
        this.pocketRepo = new PocketRepo();
    }

    public Table createTable(Match.MatchType matchType) {
        switch (matchType) {
            case EIGHT_BALL:
                return createEightBallTable();
            case NINE_BALL:
                return createNineBallTable();
            default:
            case TEN_BALL:
                return createTenBallTable();
        }
    }

    private Table createEightBallTable() {
        List<Ball> balls = new ArrayList<>();
        List<Pocket> pockets = new ArrayList<>();

        balls.add(new Ball(1, Ball.BallType.SOLID, Ball.BallColor.YELLOW, null));
        balls.add(new Ball(2, Ball.BallType.STRIPED, Ball.BallColor.BLUE, null));

        // TODO: create rest of balls and pockets and persist that then add to table.

        balls = persistBalls(balls);
        pockets = persistPockets(pockets);

        Table table = new Table(pockets, balls);

        table = tableRepo.createTable(table);

        return table;
    }

    private Table createNineBallTable() {
        return null;
    }

    private Table createTenBallTable() {
        return null;
    }

    private List<Ball> persistBalls(List<Ball> balls) {
        for (Ball ball : balls) {
            ballRepo.createBall(ball);
        }

        return balls;
    }

    private List<Pocket> persistPockets(List<Pocket> pockets) {
        for (Pocket pocket : pockets) {
            pocketRepo.createPocket(pocket);
        }

        return pockets;
    }
}
