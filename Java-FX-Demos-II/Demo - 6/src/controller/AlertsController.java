package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertsController {

    public void btnShowMsg_OnAction(ActionEvent actionEvent) {
        Alert msgbox = new Alert(Alert.AlertType.INFORMATION, "Customer has been saved successfully");
        msgbox.show();
    }

    public void btnShowConfirm_OnAction(ActionEvent actionEvent) {
        Alert msgbox = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this customer?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> clickedButton = msgbox.showAndWait();
        if (clickedButton.get() ==ButtonType.YES){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

}
