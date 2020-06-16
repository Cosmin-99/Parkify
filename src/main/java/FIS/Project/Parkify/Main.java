package FIS.Project.Parkify;

import FIS.Project.Parkify.Controllers.RegisterScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        URL url = new File("src/main/java/FIS/Project/Parkify/FXML/Login.fxml").toURI().toURL();

        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Parkify");
        primaryStage.setScene(new Scene(root, 1200, 640));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
