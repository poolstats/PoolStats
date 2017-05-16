package logic;

import library.Team;
import library.User;
import repo.TeamRepo;

import java.util.List;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TeamLogic {
    private TeamRepo teamRepo;

    public TeamLogic() {
        this.teamRepo = new TeamRepo();
    }

    public Team createTeam(String teamName, List<User> players) {
        Team team = new Team(teamName, players);

        team = teamRepo.createTeam(team);

        return team;
    }
}
