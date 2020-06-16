package FIS.Project.Parkify.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class RequestSent {

    @FXML
    public Text finalMessage;

    @FXML
    public void initialize(){
        finalMessage.setText("The parking spot with number " + SelectParkingSpot.getSpotInput() +
                ", at the floor " + SelectParkingSpot.getSpots().get(SelectParkingSpot.getSpotInput()-1).getFloor() +
                ", section " + SelectParkingSpot.getSpots().get(SelectParkingSpot.getSpotInput()-1).getSection() +
                " has been requested. \n\nWait for confirmation from the manager! \n\nSee status in 'View Requests'.");

        String zone = SelectParkingSpot.getSpots().get(SelectParkingSpot.getSpotInput()-1).getFloor() +
                SelectParkingSpot.getSpots().get(SelectParkingSpot.getSpotInput()-1).getSection();

        JSONObject requestDetails = new JSONObject();
        requestDetails.put("Username",LoginScreen.getUsername());
        requestDetails.put("Hotel",DriverHotelSelect.getHotelName());
        requestDetails.put("SpotNo",SelectParkingSpot.getSpotInput());
        requestDetails.put("Zone",zone);
        requestDetails.put("Status","Waiting");

        String requestFile = "src/main/resources/Requests/" + LoginScreen.getUsername() + ".json";

        JSONParser parser = new JSONParser();
        JSONArray requestList = new JSONArray();

        try {
            File check = new File(requestFile);
            if(check.exists()){
                FileReader reader = new FileReader(requestFile);
                Object obj = parser.parse(reader);
                requestList = (JSONArray) obj;
                requestList.add(requestDetails);

                FileWriter writer = new FileWriter(requestFile);
                writer.write(requestList.toJSONString());
                writer.flush();
            } else {
                FileWriter writer = new FileWriter(requestFile);
                requestList.add(requestDetails);
                writer.write(requestList.toJSONString());
                writer.flush();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }


    public void GoBack(){
        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/DriverMenu.fxml").toURI().toURL();

            Stage stage = (Stage) finalMessage.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void GoFinish(){
        Platform.exit();
    }
}
