package FIS.Project.Parkify.Controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.stage.Stage;

public class DriverHotelSelect {

    @FXML
    private ObservableList<String> hotelList = FXCollections.observableArrayList("Hotel Continental Arad","Hotel Continental Timisoara","Hotel Continental Oradea","Hotel Continental Bucuresti");

    private static String getHotel;

    @FXML
    public ChoiceBox hotelSelect;

    @FXML
    public Text invalid;

    @FXML
    private void initialize() {
        hotelSelect.setItems(hotelList);
    }

    public static String getHotelName(){
        return getHotel;
    }



    public void GoNext(){
        getHotel = hotelSelect.getValue().toString();

        if(getHotel == null || getHotel.isEmpty()){
            invalid.setText("Please select a hotel!");
        }

        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/SelectParkingSpot.fxml").toURI().toURL();

            Stage stage = (Stage) invalid.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void GoBack(){
        try{
            URL url = new File("src/main/resources/fxml/sample.fxml").toURI().toURL();

            Stage stage = (Stage) invalid.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1200, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void GoCancel(){
        Platform.exit();
    }
}
