package net.usermd.jrkn87.models;

public class User {
    private static boolean login;

    public User() {
        this.login = false;
    }

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login) {
        User.login = login;
    }
}
