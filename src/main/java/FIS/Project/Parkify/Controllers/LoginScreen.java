package FIS.Project.Parkify.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginScreen {

    ObservableList<String> roleList = FXCollections.observableArrayList("Driver","Manager");

    @FXML
    public TextField userName;

    @FXML
    public PasswordField userPassword;
    @FXML
    public Text screenMessage;

    @FXML
    public ChoiceBox role;

    @FXML
    private void initialize() {
        role.setItems(roleList);
    }

    @FXML
    public void LoginButtonOnClick(){
        String username = userName.getText();
        String password = userPassword.getText();

        if(username == null || username.isEmpty()){
            screenMessage.setText("Please enter a valid username");
        }

        if(password == null || password.isEmpty()){
            screenMessage.setText("Please enter a valid password");
        }


    }
}
