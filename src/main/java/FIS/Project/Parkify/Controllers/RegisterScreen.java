package FIS.Project.Parkify.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RegisterScreen {
    ObservableList<String> roleList = FXCollections.observableArrayList("Driver","Manager");

    @FXML
    public TextField firstname,lastname,address,phonenumber,username;

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
        String registerrole = registerRole.getValue().toString();

        JSONObject userDetails = new JSONObject();
        userDetails.put("FirstName: ", firstName);
        userDetails.put("LastName: ", lastName);
        userDetails.put("Adress: ", Address);
        userDetails.put("Phone Number: ", phoneNumber);
        userDetails.put("Username: ", userName);
        userDetails.put("Password: ", password);
        userDetails.put("Role: ", registerrole);

    //Add user to list
    JSONArray userList = new JSONArray();
        userList.add(userDetails);

        try (FileWriter file = new FileWriter("Parkify.json")) {

        file.write(userList.toJSONString());
        file.flush();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
