package repo;

import library.Team;
import library.User;
import library.UserStats;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jandie on 2017-05-03.
 */
public class UserRepo {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UserRepo() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PoolStatsDB");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addUser(String username) {
        entityManager.getTransaction().begin();

        // Save userStats
        UserStats userStats = new UserStats(0, 0, 0, 0, 0, 0, 0, 0);
        entityManager.persist(userStats);

        // Save user
        User user = new User(username, userStats);
        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }
}
