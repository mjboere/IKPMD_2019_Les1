package boere.a2019_college1.models;

import java.io.Serializable;

public class Authentication implements Serializable {

    private String username;
    private String password;

    public Authentication (String uid, String pwd) {
        this.username = uid;
        this.password = pwd;
    }

    public boolean isAuthenticated (String uid, String pwd) {
        return ( (this.username.equals(uid)) && (this.password.equals(pwd) ) );
    }

    // GETTERS
    // SETTERS

}
