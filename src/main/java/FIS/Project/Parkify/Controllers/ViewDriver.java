package FIS.Project.Parkify.Controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ViewDriver {

    @FXML
    public Text text;

    @FXML
    public TableView<Driver> driverTable;
    @FXML
    public TableColumn<Driver, String> firstName;
    @FXML
    public TableColumn<Driver, String> lastName;
    @FXML
    public TableColumn<Driver, String> address;
    @FXML
    public TableColumn<Driver, String> phoneNumber;
    @FXML
    public TableColumn<Driver, String> userName;

    private ObservableList<Driver> drivers = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));

        JSONParser parser = new JSONParser();
        try{
            JSONArray a = (JSONArray) parser.parse(new FileReader("Parkify.json"));

            for (Object o : a) {
                JSONObject driver = (JSONObject) o;

                String role = (String) driver.get("Role");

                if(!role.equals("Manager")) {
                    String firstname = (String) driver.get("FirstName");
                    String lastname = (String) driver.get("LastName");
                    String address = (String) driver.get("Adress");
                    String phonenumber = (String) driver.get("Phone Number");
                    String username = (String) driver.get("Username");

                    drivers.add(new Driver(firstname, lastname, address, phonenumber, username));

                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        driverTable.setItems(drivers);
    }

    @FXML
    public void GoBack(){

        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/ManagerMenu.fxml").toURI().toURL();

            Stage stage = (Stage) text.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
            driverTable.getItems().clear();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void GoCancel(){
        Platform.exit();
    }
}
