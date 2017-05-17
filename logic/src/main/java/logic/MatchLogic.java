package logic;

import library.Match;
import library.Table;
import library.Team;
import repo.MatchRepo;

/**
 * Created by Jandie on 2017-05-16.
 */
public class MatchLogic {
    private MatchRepo matchRepo;

    public MatchLogic() {
        this.matchRepo = new MatchRepo();
    }

    public Match createMatch(String name, Team team1, Team team2, Match.MatchType matchType) {
        Table table = new TableLogic().createTable(matchType);
        Match match = new Match(name, table, team1, team2, matchType);

        return matchRepo.createMatch(match);
    }
}
