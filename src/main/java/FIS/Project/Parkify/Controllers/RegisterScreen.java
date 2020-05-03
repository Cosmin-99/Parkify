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
    public TextField userName;

    @FXML
    public PasswordField userPassword;

    @FXML
    public ChoiceBox registerRole;

    @FXML
    private void initialize() {
        registerRole.setItems(roleList);
    }

    @FXML
    public void LoginButtonOnClick(){
        String username = userName.getText();
        String password = userPassword.getText();
    }
}
