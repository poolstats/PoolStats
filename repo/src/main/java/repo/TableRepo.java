package repo;

import library.Table;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TableRepo {
    private JPAConnector connector;

    public TableRepo() {
        this.connector = new JPAConnector();
    }

    public Table createTable(Table table) {
        connector.getEntityManager().persist(table);

        connector.commitTransaction();

        return table;
    }

    public Table updateTable(Table table) {
        connector.getEntityManager().persist(table);

        connector.commitTransaction();

        return table;
    }

    public void removeTable(Table table) {
        connector.getEntityManager().remove(table);

        connector.commitTransaction();
    }
}
