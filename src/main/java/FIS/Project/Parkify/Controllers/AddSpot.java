package FIS.Project.Parkify.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class AddSpot {

    @FXML
    public Text finalMessage;

    @FXML
    public TextField spotNo;
    @FXML
    public TextField floor;
    @FXML
    public TextField section;
    @FXML
    public TextField price;


    public void GoBack(){
        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/ManagerHotelSelect.fxml").toURI().toURL();

            Stage stage = (Stage) finalMessage.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void Save(){
        String no = spotNo.getText();
        String fl = floor.getText();
        String Section = section.getText();
        String pr = price.getText();
        long Number = Integer.parseInt(no);
        long Floor = Integer.parseInt(fl);
        double Price = Double.parseDouble(pr);

        String hotelPath = "src/main/resources/Data/" + ManagerHotelSelect.getHotelName().substring(18).toLowerCase() + ".json";

        JSONObject spotDetails = new JSONObject();
        spotDetails.put("Number",Number);
        spotDetails.put("Floor",Floor);
        spotDetails.put("Section",Section);
        spotDetails.put("Price",Price);
        spotDetails.put("Availability","Free");

        JSONParser parser = new JSONParser();
        JSONArray spotList = new JSONArray();

        try {
            File check = new File(hotelPath);
            if(check.exists()){
                FileReader reader = new FileReader(hotelPath);
                Object obj = parser.parse(reader);
                spotList = (JSONArray) obj;
                spotList.add(spotDetails);

                FileWriter writer = new FileWriter(hotelPath);
                writer.write(spotList.toJSONString());
                writer.flush();
            } else {
                FileWriter writer = new FileWriter(hotelPath);
                spotList.add(spotDetails);
                writer.write(spotList.toJSONString());
                writer.flush();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
