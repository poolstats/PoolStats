package repo;

import library.UserStats;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}
