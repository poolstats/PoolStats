package ui;

import java.util.HashMap;

/**
 * Created by guillaimejanssen on 04/05/2017.
 */
public class SessionData implements AutoCloseable {

    public static final String CURRENT_USER = "currentUser";

    private HashMap<String, Object> data;

    public SessionData() {
        data = new HashMap<>();
    }

    public void addData(String key, Object value) {
        data.put(key, value);
    }

    public Object getData(String key) {
        return data.get(key);
    }

    public void removeData(String key) {
        data.remove(key);
    }

    @Override
    public void close() throws Exception {
        this.data.clear();
    }
}
