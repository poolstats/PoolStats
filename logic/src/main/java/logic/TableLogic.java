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
        List<Ball> balls = createBallsEightBallTable();
        List<Pocket> pockets = createPocketsForTable();

        Table table = new Table(pockets, balls);

        table = tableRepo.createTable(table);

        return table;
    }

    private List<Ball> createBallsEightBallTable() {
        List<Ball> balls = new ArrayList<>();

        balls.add(new Ball(1, Ball.BallType.SOLID, Ball.BallColor.YELLOW, null));
        balls.add(new Ball(2, Ball.BallType.STRIPED, Ball.BallColor.BLUE, null));
        balls.add(new Ball(3, Ball.BallType.SOLID, Ball.BallColor.RED, null));
        balls.add(new Ball(4, Ball.BallType.STRIPED, Ball.BallColor.PURPLE, null));
        balls.add(new Ball(5, Ball.BallType.SOLID, Ball.BallColor.ORANGE, null));
        balls.add(new Ball(6, Ball.BallType.STRIPED, Ball.BallColor.GREEN, null));
        balls.add(new Ball(7, Ball.BallType.SOLID, Ball.BallColor.MAROON, null));
        balls.add(new Ball(8, Ball.BallType.STRIPED, Ball.BallColor.BLACK, null));
        balls.add(new Ball(0, Ball.BallType.CUE, Ball.BallColor.WHITE, null));

        return persistBalls(balls);
    }

    private List<Pocket> createPocketsForTable() {
        List<Pocket> pockets = new ArrayList<>();

        pockets.add(new Pocket(Pocket.PocketLocation.TOP_LEFT));
        pockets.add(new Pocket(Pocket.PocketLocation.TOP_MID));
        pockets.add(new Pocket(Pocket.PocketLocation.TOP_RIGHT));
        pockets.add(new Pocket(Pocket.PocketLocation.BOTTOM_LEFT));
        pockets.add(new Pocket(Pocket.PocketLocation.BOTTOM_MID));
        pockets.add(new Pocket(Pocket.PocketLocation.BOTTOM_RIGHT));

        return persistPockets(pockets);
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
