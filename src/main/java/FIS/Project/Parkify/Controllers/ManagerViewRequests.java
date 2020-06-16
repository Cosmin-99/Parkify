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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class ManagerViewRequests {

    @FXML
    public Text screenMessage;
    @FXML
    public Text go;

    @FXML
    public TextField inputUser;
    @FXML
    public TextField inputHotel;
    @FXML
    public TextField inputSpot;
    @FXML
    public TextField inputReason;

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
        reqUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        reqHotel.setCellValueFactory(new PropertyValueFactory<>("hotel"));
        reqSpotNo.setCellValueFactory(new PropertyValueFactory<>("spotNo"));
        reqZone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        reqStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        File folder = new File("src/main/resources/Requests/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filename = "src/main/resources/Requests/" + file.getName();

                JSONParser parser = new JSONParser();
                try {
                    JSONArray a = (JSONArray) parser.parse(new FileReader(filename));

                    for (Object o : a) {
                        JSONObject request = (JSONObject) o;
                        String status = (String) request.get("Status");
                        long spotNo = (long) request.get("SpotNo");
                        String username = (String) request.get("Username");
                        String zone = (String) request.get("Zone");
                        String hotel = (String) request.get("Hotel");

                        if(status.equals("Waiting"))
                            requests.add(new Request(username, hotel, spotNo, zone, status));
                    }
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

                reqTable.setItems(requests);
            }
        }
    }

    public void accept(){

        String UserInput = inputUser.getText();
        String HotelInput = inputHotel.getText();
        String SpotInput = inputSpot.getText();
        long longSpotInput = Integer.parseInt(SpotInput);
        if(UserInput.isEmpty() || HotelInput.isEmpty() || SpotInput.isEmpty()){
            screenMessage.setText("Not all fields completed or invalid data");
        } else {
            String userPath = "src/main/resources/Requests/" + UserInput + ".json";
            JSONParser parser = new JSONParser();
            JSONArray requestList = new JSONArray();
            try{
                JSONArray a = (JSONArray) parser.parse(new FileReader(userPath));

                for (Object o : a) {
                    JSONObject request = (JSONObject) o;

                    String status = (String) request.get("Status");
                    long spotNo = (long) request.get("SpotNo");
                    String username = (String) request.get("Username");
                    String zone = (String) request.get("Zone");
                    String hotel = (String) request.get("Hotel");

                    JSONObject requestDetails = new JSONObject();

                    if(username.equals(UserInput) && hotel.equals(HotelInput) && spotNo == longSpotInput){

                        requestDetails.put("Username",username);
                        requestDetails.put("Hotel",hotel);
                        requestDetails.put("SpotNo",spotNo);
                        requestDetails.put("Zone",zone);
                        requestDetails.put("Status","Accepted");
                        requestList.add(requestDetails);
                    } else if(!status.equals("Waiting")){

                        requestDetails.put("Username", username);
                        requestDetails.put("Hotel", hotel);
                        requestDetails.put("SpotNo", spotNo);
                        requestDetails.put("Zone", zone);
                        requestDetails.put("Status", status);
                        requestList.add(requestDetails);
                    }
                    else {
                        requestDetails.put("Username", username);
                        requestDetails.put("Hotel", hotel);
                        requestDetails.put("SpotNo", spotNo);
                        requestDetails.put("Zone", zone);
                        requestDetails.put("Status", status);
                        requestList.add(requestDetails);
                    }
                }
                FileWriter writer = new FileWriter(userPath);
                writer.write(requestList.toJSONString());
                writer.flush();

            } catch (IOException | ParseException e){
                e.printStackTrace();
            }
        }

    }

    public void reject(){
        String UserInput = inputUser.getText();
        String HotelInput = inputHotel.getText();
        String SpotInput = inputSpot.getText();
        String RejectionReason = inputReason.getText();
        long longSpotInput = Integer.parseInt(SpotInput);
        if(UserInput.isEmpty() || HotelInput.isEmpty() || SpotInput.isEmpty()){
            screenMessage.setText("Not all fields completed or invalid data");
        } else {
            String userPath = "src/main/resources/Requests/" + UserInput + ".json";
            JSONParser parser = new JSONParser();
            JSONArray requestList = new JSONArray();
            try{
                JSONArray a = (JSONArray) parser.parse(new FileReader(userPath));

                for (Object o : a) {
                    JSONObject request = (JSONObject) o;

                    String status = (String) request.get("Status");
                    long spotNo = (long) request.get("SpotNo");
                    String username = (String) request.get("Username");
                    String zone = (String) request.get("Zone");
                    String hotel = (String) request.get("Hotel");

                    JSONObject requestDetails = new JSONObject();

                    if(username.equals(UserInput) && hotel.equals(HotelInput) && spotNo == longSpotInput){

                        requestDetails.put("Username",username);
                        requestDetails.put("Hotel",hotel);
                        requestDetails.put("SpotNo",spotNo);
                        requestDetails.put("Zone",zone);
                        requestDetails.put("Status","Rejected (Reason: "+RejectionReason);
                        requestList.add(requestDetails);
                    } else if(!status.equals("Waiting")){

                        requestDetails.put("Username", username);
                        requestDetails.put("Hotel", hotel);
                        requestDetails.put("SpotNo", spotNo);
                        requestDetails.put("Zone", zone);
                        requestDetails.put("Status", status);
                        requestList.add(requestDetails);
                    }
                    else {
                        requestDetails.put("Username", username);
                        requestDetails.put("Hotel", hotel);
                        requestDetails.put("SpotNo", spotNo);
                        requestDetails.put("Zone", zone);
                        requestDetails.put("Status", status);
                        requestList.add(requestDetails);
                    }
                }
                FileWriter writer = new FileWriter(userPath);
                writer.write(requestList.toJSONString());
                writer.flush();

            } catch (IOException | ParseException e){
                e.printStackTrace();
            }
        }

    }

    public void GoBack(){
        go.setText("Cool");
        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/ManagerMenu.fxml").toURI().toURL();

            Stage stage = (Stage) go.getScene().getWindow();
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
