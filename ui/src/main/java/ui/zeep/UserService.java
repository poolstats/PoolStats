
package ui.zeep;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserService", targetNamespace = "http://services/")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface UserService {


    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns ui.zeep.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loginUser", targetNamespace = "http://services/", className = "ui.zeep.LoginUser")
    @ResponseWrapper(localName = "loginUserResponse", targetNamespace = "http://services/", className = "ui.zeep.LoginUserResponse")
    @Action(input = "http://services/UserService/loginUserRequest", output = "http://services/UserService/loginUserResponse")
    public User loginUser(
            @WebParam(name = "username", targetNamespace = "")
                    String username,
            @WebParam(name = "password", targetNamespace = "")
                    String password);

}
