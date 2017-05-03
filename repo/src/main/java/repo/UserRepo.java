package repo;

import library.Team;
import library.User;
import library.UserStats;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
public class UserRepo {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PoolStatsDB");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        UserStats userStats1 = new UserStats(2, 3, 4, 5, 6, 7, 8, 9);

        entitymanager.persist(userStats1);

        User user1 = new User("guillaime", userStats1);
        User user2 = new User("michel", userStats1);

        entitymanager.persist(user1);
        entitymanager.persist(user2);

        List<User> players = new ArrayList<>();
        players.add(user1);
        players.add(user2);

        Team team = new Team("securoserve", players);

        entitymanager.persist(team);

        entitymanager.remove(entitymanager.find(Team.class, 304L));

        System.out.println(entitymanager.find(UserStats.class, 1L).getBallsPotted());

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}
