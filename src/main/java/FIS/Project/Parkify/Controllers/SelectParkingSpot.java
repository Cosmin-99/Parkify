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
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class SelectParkingSpot {

    @FXML
    public TextField inputSpot;

    @FXML
    public Text invalid;

    @FXML
    public TableView<Spot> spotTable;
    @FXML
    public TableColumn<Spot, Integer> spotNumber;
    @FXML
    public TableColumn<Spot, Integer> spotFloor;
    @FXML
    public TableColumn<Spot, String> spotSection;
    @FXML
    public TableColumn<Spot, Double> spotPrice;
    @FXML
    public TableColumn<Spot, String> spotAvailability;

    private static ObservableList<Spot> spots = FXCollections.observableArrayList();
    private static int spotInput;

    @FXML
    public void initialize(){
        spotNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        spotFloor.setCellValueFactory(new PropertyValueFactory<>("Floor"));
        spotSection.setCellValueFactory(new PropertyValueFactory<>("Section"));
        spotPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        spotAvailability.setCellValueFactory(new PropertyValueFactory<>("Availability"));


        String hotelPath = "src/main/resources/Data/" + DriverHotelSelect.getHotelName().substring(18).toLowerCase() + ".json";

        JSONParser parser = new JSONParser();
        try{
            JSONArray a = (JSONArray) parser.parse(new FileReader(hotelPath));

            for (Object o : a) {
                JSONObject spot = (JSONObject) o;
                long number = (long) spot.get("Number");
                long floor = (long) spot.get("Floor");
                String section = (String) spot.get("Section");
                double price = (double) spot.get("Price");
                String availability = (String) spot.get("Availability");
                spots.add(new Spot(number,floor,section,price,availability));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        spotTable.setItems(spots);
    }


    public void reservate(){

        String getSpot = inputSpot.getText();

        if(getSpot == null || getSpot.isEmpty()){
            invalid.setText("Invalid spot number or occupied");
        } else {

             spotInput = Integer.parseInt(getSpot);

            if(spots.get(spotInput - 1).getAvailability().equals("Free")) {

                try{
                    URL url = new File("src/main/java/FIS/Project/Parkify/FXML/RequestSent.fxml").toURI().toURL();

                    Stage stage = (Stage) invalid.getScene().getWindow();
                    Parent viewStudentsRoot = FXMLLoader.load(url);
                    Scene scene = new Scene(viewStudentsRoot, 1000, 640);
                    stage.setScene(scene);
                }catch(IOException e){
                    e.printStackTrace();
                }

            } else{
                invalid.setText("This parking spot is occupied");
            }
        }
    }

    public void GoBack(){

        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/DriverHotelSelect.fxml").toURI().toURL();

            Stage stage = (Stage) invalid.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void GoCancel(){
        Platform.exit();
    }

    public static ObservableList<Spot> getSpots() {
        return spots;
    }

    public static int getSpotInput() {
        return spotInput;
    }
}
