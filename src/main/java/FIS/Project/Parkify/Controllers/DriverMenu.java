package FIS.Project.Parkify.Controllers;

import javafx.application.Platform;
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
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;
import java.net.URL;

public class DriverMenu {

    @FXML
    public Text invalid;

    @FXML
    public Text noRequests;

    @FXML
    public void chooseHotel(){

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

    @FXML
    public void viewReservations(){

        String requestFile = "src/main/resources/Requests/" + LoginScreen.getUsername() + ".json";
        File check = new File(requestFile);
        if(check.exists()){
            try{
                URL url = new File("src/main/java/FIS/Project/Parkify/FXML/DriverRequests.fxml").toURI().toURL();

                Stage stage = (Stage) invalid.getScene().getWindow();
                Parent viewStudentsRoot = FXMLLoader.load(url);
                Scene scene = new Scene(viewStudentsRoot, 1000, 640);
                stage.setScene(scene);
            }catch(IOException e){
                e.printStackTrace();
            }
        } else {
            noRequests.setText("You have no resevation requests.");
        }
    }

    @FXML
    public void GoBack(){

        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/Login.fxml").toURI().toURL();

            Stage stage = (Stage) invalid.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1200, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void GoCancel(){

        Platform.exit();

    }
}
