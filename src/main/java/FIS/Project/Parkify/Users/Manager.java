package FIS.Project.Parkify.Users;

public class Manager {
    private String firstName;
    private String lastName;
    private String ID;
    private int phoneNumber;

    public Manager(String firstName, String lastName, String ID, int phoneNumber) {
        this.firstName = firstName;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserAdress() {
        return ID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
