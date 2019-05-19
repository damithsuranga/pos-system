package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageItemController {

    public Label lblTitle;

    public void btnGoBack_OnAction(ActionEvent actionEvent) throws IOException {
        Parent manageCustomer = FXMLLoader.load(this.getClass().getResource("/view/dashboard.fxml"));
        Scene firstScene = new Scene(manageCustomer);

        Stage mainStage = (Stage) lblTitle.getScene().getWindow();
        mainStage.setScene(firstScene);
    }

}
