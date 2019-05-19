package controller;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DashboardController {

    public Label lblTitle;

    public void initialize(){
//        TranslateTransition tt = new TranslateTransition(Duration.millis(2000), lblTitle);
//        tt.setFromX(-2500);
//        tt.setToX(70);
//
//        RotateTransition rt = new RotateTransition(Duration.millis(3000), lblTitle);
//        rt.setFromAngle(0);
//        rt.setToAngle(360);
//
//        rt.play();
//        tt.play();
    }

    public void btnManageCustomer_OnAction(ActionEvent actionEvent) throws IOException {
        Parent manageCustomer = FXMLLoader.load(this.getClass().getResource("/view/manage-customer.fxml"));
        Scene firstScene = new Scene(manageCustomer);

        Stage mainStage = (Stage) lblTitle.getScene().getWindow();
        mainStage.setScene(firstScene);
    }

    public void btnManageItems_OnAction(ActionEvent actionEvent) throws IOException {
        Parent manageCustomer = FXMLLoader.load(this.getClass().getResource("/view/manage-item.fxml"));
        Scene firstScene = new Scene(manageCustomer);

        Stage mainStage = (Stage) lblTitle.getScene().getWindow();
        mainStage.setScene(firstScene);
    }
}
