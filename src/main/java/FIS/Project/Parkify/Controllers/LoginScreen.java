package FIS.Project.Parkify.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        if(username == null || username.isEmpty()){
            screenMessage.setText("Please enter a valid username");
        }

        if(password == null || password.isEmpty()){
            screenMessage.setText("Please enter a valid password");
        }

            JSONParser parser = new JSONParser();

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("Parkify.json"));

            for (Object o : a) {
                JSONObject person = (JSONObject) o;

                String Username = (String) person.get("Username");
                System.out.println(Username);

                String city = (String) person.get("Adress");
                System.out.println(city);

                String pass = (String) person.get("Password");
                System.out.println(EnDec.decrypt(pass,secretKey));

                if(username.equals(Username) && password.equals(EnDec.decrypt(pass,secretKey))){
                    System.out.println("Success");
                    break;
                }

            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
