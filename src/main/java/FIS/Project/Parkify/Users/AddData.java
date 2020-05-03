package FIS.Project.Parkify.Users;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AddData {

    @FXML
    public TextField firstname,lastname,address,phonenumber,username;

    @FXML
    public PasswordField userpassword;

    @FXML
    public ChoiceBox registerRole;


    @FXML
    public void LoginOnClick(){
        String choice = registerRole.getValue().toString();
        String firstName = firstname.getText();
        String lastName = lastname.getText();
        String adress = address.getText();
        String phone = phonenumber.getText();
        String userName = username.getText();
        String userPassword = userpassword.getText();

        JSONObject userDetails = new JSONObject();
        userDetails.put("FirstName: ", firstName);
        userDetails.put("LastName: ", lastName);
        userDetails.put("Adress: ", adress);
        userDetails.put("Phone Number: ", phone);
        userDetails.put("Username: ", userName);
        userDetails.put("Password: ", userPassword);
        userDetails.put("Role: ", choice);

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
