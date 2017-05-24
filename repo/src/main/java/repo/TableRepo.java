package repo;

import library.Table;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TableRepo {
    private JPAConnector connector;

    public TableRepo() {
        this.connector = JPAConnector.getInstance();
    }

    public Table createTable(Table table) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(table);

        connector.getEntityManager().getTransaction().commit();

        return table;
    }
}
