package logic;

import library.Team;
import library.User;
import repo.TeamRepo;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TeamLogic {
    private TeamRepo teamRepo;

    public TeamLogic() {
        this.teamRepo = new TeamRepo();
    }

    public void deleteFromTeam(Team team, User user) {
        teamRepo.removeUserFromTeam(team, user);
    }

    public Team getTeamByUser(User user) {

        try{
            return teamRepo.getTeamByUser(user);

        } catch (NoResultException ex) {
            return null;
        }
    }

    public Team addToTeam(String teamName, User user) {
        Team team = null;

        try{
             team = teamRepo.getTeamByName(teamName);
             team.getPlayers().add(user);
             teamRepo.addTeam(team);

             return team;

        } catch (NoResultException ex) {

            team = new Team(teamName);
            team.addMember(user);
            teamRepo.addUserToTeam(team, user);

            return team;
        }
    }
      
    public Team createTeam(String teamName) {
        Team team = new Team(teamName);

        team = teamRepo.createTeam(team);

        return team;
    }
}
