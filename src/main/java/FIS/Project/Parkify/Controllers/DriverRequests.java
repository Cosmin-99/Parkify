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

public class DriverRequests {

    @FXML
    public Text invalid;

    public void GoBack(){
        try{
            URL url = new File("src/main/java/FIS/Project/Parkify/FXML/DriverMenu.fxml").toURI().toURL();

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
