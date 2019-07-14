package hw7.entities;

public enum Users {

    PITER("epam", "1234", "PITER CHAILOVSKII");

    private final String login;
    private final String password;
    private final String name;

    Users(String uLogin, String uPass, String uName) {
        login = uLogin;
        password = uPass;
        name = uName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
