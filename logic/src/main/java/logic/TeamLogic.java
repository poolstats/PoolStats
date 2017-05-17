package logic;

import library.Team;
import library.User;
import repo.TeamRepo;
import repo.connector.JPAConnector;

import javax.persistence.NoResultException;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TeamLogic {
    private TeamRepo teamRepo;

    public TeamLogic() {
        this.teamRepo = new TeamRepo();
    }

    public void deleteFromTeam(Team team, User user) {
        team.getPlayers().remove(user);
        user.setTeam(null);
        JPAConnector.getInstance().commitTransaction();
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
            team.addMember(user);

            JPAConnector.getInstance().commitTransaction();

             return team;

        } catch (NoResultException ex) {

            team = new Team(teamName);
            teamRepo.createTeam(team);

            team.addMember(user);
            JPAConnector.getInstance().commitTransaction();

            return team;
        }
    }
      
    public Team createTeam(String teamName) {
        Team team = new Team(teamName);

        team = teamRepo.createTeam(team);

        return team;
    }
}
