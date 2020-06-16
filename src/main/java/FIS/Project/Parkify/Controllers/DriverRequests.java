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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class DriverRequests {

    @FXML
    public Text screenMessage;

    @FXML
    public TableView<Request> reqTable;
    @FXML
    public TableColumn<Request, String> reqUsername;
    @FXML
    public TableColumn<Request, String> reqHotel;
    @FXML
    public TableColumn<Request, Integer> reqSpotNo;
    @FXML
    public TableColumn<Request, String> reqZone;
    @FXML
    public TableColumn<Request, String> reqStatus;

    private static ObservableList<Request> requests = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        reqUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
        reqHotel.setCellValueFactory(new PropertyValueFactory<>("Hotel"));
        reqSpotNo.setCellValueFactory(new PropertyValueFactory<>("SpotNo"));
        reqZone.setCellValueFactory(new PropertyValueFactory<>("Zone"));
        reqStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));

        String userPath = "src/main/resources/Requests/" + LoginScreen.getUsername() + ".json";

        JSONParser parser = new JSONParser();
        try{
            JSONArray a = (JSONArray) parser.parse(new FileReader(userPath));

            for (Object o : a) {
                JSONObject request = (JSONObject) o;
                String status = (String) request.get("Status");
                long spotNo = (long) request.get("SpotNo");
                String username = (String) request.get("Username");
                String zone = (String) request.get("Zone");
                String hotel = (String) request.get("Hotel");

                requests.add(new Request(username,hotel,spotNo,zone,status));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        reqTable.setItems(requests);
    }

    public void GoBack(){
        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/DriverMenu.fxml").toURI().toURL();

            Stage stage = (Stage) screenMessage.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
            reqTable.getItems().clear();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void GoCancel(){
        Platform.exit();
    }
}
