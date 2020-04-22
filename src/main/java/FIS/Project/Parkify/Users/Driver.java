package FIS.Project.Parkify.Users;

public class Driver {

    private String firstName;
    private String lastName;
    private String userAdress;
    private int phoneNumber;

    public Driver(String firstName, String lastName, String adress, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAdress = adress;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
