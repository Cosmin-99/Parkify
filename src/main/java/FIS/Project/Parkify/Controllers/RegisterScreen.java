package FIS.Project.Parkify.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    public Text message;

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
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        JSONObject userDetails = new JSONObject();
        userDetails.put("FirstName", firstName);
        userDetails.put("LastName", lastName);
        userDetails.put("Adress", Address);
        userDetails.put("Phone Number", phoneNumber);
        userDetails.put("Username", userName);
        userDetails.put("Password", EnDec.encrypt(password,secretKey));
        userDetails.put("Role", registerrole);

    //Add user to list
    JSONArray userList = new JSONArray();
        userList.add(userDetails);

        try (FileWriter file = new FileWriter("Parkify.json")) {

        file.write(userList.toJSONString());
        file.flush();

            URL url = new File("src/main/resources/fxml/sample.fxml").toURI().toURL();

            Stage stage = (Stage) message.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1200, 640);
            stage.setScene(scene);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
