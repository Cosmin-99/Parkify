package FIS.Project.Parkify.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class RequestSent {
    @FXML
    public Text finalMessage;

    @FXML
    public void initialize(){
        finalMessage.setText("The parking spot with number " + SelectParkingSpot.getSpotInput() +
                " , at the floor " + SelectParkingSpot.getSpots().get(SelectParkingSpot.getSpotInput()).getFloor() +
                " , section " + SelectParkingSpot.getSpots().get(SelectParkingSpot.getSpotInput()).getSection() +
                " has been reserved. Wait for confirmation ! ");
    }

    @FXML
    public void GoFinish(){

        Platform.exit();
    }
}
