package FIS.Project.Parkify.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterScreen {
    ObservableList<String> roleList = FXCollections.observableArrayList("Driver","Manager");

    @FXML
    public TextField firstname;

    @FXML
    public TextField lastname;

    @FXML
    public TextField address;

    @FXML
    public TextField phonenumber;

    @FXML
    public TextField username;

    @FXML
    public PasswordField userpassword;

    @FXML
    public ChoiceBox registerRole;

    @FXML
    private void initialize() {
        registerRole.setItems(roleList);
    }

    @FXML
    public void LoginButtonOnClick(){
        String firstName = firstname.getText();
        String lastName = lastname.getText();
        String Address = address.getText();
        String phoneNumber = phonenumber.getText();
        String userName = username.getText();
        String password = userpassword.getText();
    }
}
