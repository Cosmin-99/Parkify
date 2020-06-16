package FIS.Project.Parkify.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ManagerMenu {

    @FXML
    public Text invalid;

    @FXML
    public void viewDriverDetails(){

        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/ViewDriverDetails.fxml").toURI().toURL();

            Stage stage = (Stage) invalid.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void viewRequests(){

        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/ViewRequests.fxml").toURI().toURL();

            Stage stage = (Stage) invalid.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void addSpot(){

        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/ManagerHotelSelect.fxml").toURI().toURL();

            Stage stage = (Stage) invalid.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(url);
            Scene scene = new Scene(viewStudentsRoot, 1000, 640);
            stage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
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
