package FIS.Project.Parkify.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreen {

    @FXML
    public TextField userName;

    @FXML
    public PasswordField userPassword;

    @FXML
    public void LoginButtonOnClick(){
        String username = userName.getText();
        String password = userPassword.getText();
    }
}
