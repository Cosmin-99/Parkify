package FIS.Project.Parkify.Users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DriverHotelSelect {
    ObservableList<String> roleList = FXCollections.observableArrayList("Hotel Continental Timisoara","Hotel Continental Arad","Hotel Continental Oradea","Hotel Continental Bucuresti");

    @FXML
    public ChoiceBox hotel;

    @FXML
    private void initialize() {
        hotel.setItems(roleList);
    }

    @FXML
    public void NextClick(){

    }

    @FXML
    public void BackClick(){

    }

    @FXML
    public void CancelClick(){

    }
}
