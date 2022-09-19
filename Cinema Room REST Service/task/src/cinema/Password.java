package cinema;

public class Password{
    String password;

    public Password() {}

    public Password(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEquals(Password otherPassword) {
        return password.equals(otherPassword.getPassword());
    }
}
