package pojo;

public class Company {

    private User user;

    @Override
    public String toString() {
        return "Company{" +
                "user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
