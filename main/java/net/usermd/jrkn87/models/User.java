package net.usermd.jrkn87.models;

public class User {
    private boolean login_status;

    public User() {
        this.login_status = false;
    }

    public boolean isLogin() {
        return login_status;
    }

    public void setLogin(boolean login) {
        this.login_status = login;
    }
}
