package logic;

import library.Player;
import library.Team;
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

    public void deleteFromTeam(Team team, Player player) {
        team.getPlayers().remove(player);
        player.setTeam(null);
        JPAConnector.getInstance().commitTransaction();
    }

    public Team getTeamByUser(Player player) {

        try{
            return teamRepo.getTeamByUser(player);

        } catch (NoResultException ex) {
            return null;
        }
    }

    public Team addToTeam(String teamName, Player player) {
        Team team = null;

        try{
             team = teamRepo.getTeamByName(teamName);
            team.addMember(player);

            JPAConnector.getInstance().commitTransaction();

             return team;

        } catch (NoResultException ex) {

            team = new Team(teamName);
            teamRepo.createTeam(team);

            team.addMember(player);

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
