package User;

public class Staff extends User {

    private Staff(String username, String password) {
        super(username, password);
    }

    public static Staff initalStaffAcc() {
        return new Staff("staff", "today123");
    }
}
