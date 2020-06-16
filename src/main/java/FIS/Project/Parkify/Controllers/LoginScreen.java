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
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sun.security.krb5.internal.PAData;

public class LoginScreen {
    @FXML
    private ObservableList<String> roleList = FXCollections.observableArrayList("Driver","Manager");

    @FXML
    public TextField userName;

    @FXML
    public PasswordField userPassword;

    @FXML
    public Text screenMessage;

    @FXML
    public ChoiceBox rol;

    @FXML
    private void initialize() {
        rol.setItems(roleList);
    }

    private static String getUser;

    @FXML
    public void LoginButtonOnClick(){
        String username = userName.getText();
        String password = userPassword.getText();
        String role = rol.getValue().toString();
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
                String Password = (String) person.get("Password");
                String Role = (String) person.get("Role");

                if(username.equals(Username) && password.equals(EnDec.decrypt(Password,secretKey)) && role.equals(Role)){

                    if(Role.equals("Driver")){
                        getUser = Username;
                        try{
                            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/DriverMenu.fxml").toURI().toURL();

                            Stage stage = (Stage) screenMessage.getScene().getWindow();
                            Parent viewStudentsRoot = FXMLLoader.load(url);
                            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
                            stage.setScene(scene);
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    if(Role.equals("Manager")) {
                        try {
                            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/ManagerMenu.fxml").toURI().toURL();

                            Stage stage = (Stage) screenMessage.getScene().getWindow();
                            Parent viewStudentsRoot = FXMLLoader.load(url);
                            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
                            stage.setScene(scene);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                screenMessage.setText("Invalid credentials.");
            }
        }catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void GoToRegister(){
        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/Register.fxml").toURI().toURL();

            Stage stage = (Stage) screenMessage.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1200, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getUsername(){
        return getUser;
    }
}