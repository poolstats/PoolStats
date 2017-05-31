package server;

import services.UserService;

import javax.xml.ws.Endpoint;

/**
 * Created by Jandie on 2017-05-31.
 */
public class Server {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/userService",
                new UserService());
    }
}
