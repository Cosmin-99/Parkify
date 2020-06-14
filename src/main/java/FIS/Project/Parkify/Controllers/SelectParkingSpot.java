package FIS.Project.Parkify.Controllers;

import FIS.Project.Parkify.Users.Driver;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SelectParkingSpot {

    @FXML
    public TextField inputSpot;

    @FXML
    public Text invalid;

    @FXML
    private void initialize() {}

    public void Reservate(){

        String hotelName = DriverHotelSelect.getHotelName();
        String hotelPath = hotelName.substring(18);
        hotelPath = "src/main/resources/Data/" + hotelPath.toLowerCase() + ".json";
        System.out.println(hotelPath);

        String getSpot = inputSpot.getText();

        if(getSpot == null || getSpot.isEmpty()){
            invalid.setText("Invalid spot number or occupied");
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
}
