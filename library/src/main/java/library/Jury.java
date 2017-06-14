package library;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jandie on 2017-05-24.
 */
@Entity
@XmlRootElement
public class Jury extends User {

    private String password;

    public Jury() {
        super();
    }

    public Jury(String username, String password) {
        super(username);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


