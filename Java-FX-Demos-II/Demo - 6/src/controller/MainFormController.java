package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.nio.ch.sctp.SctpNet;

import java.io.IOException;

public class MainFormController {

    public AnchorPane root;

    public void btnShowSomething_OnAction(ActionEvent actionEvent) throws IOException {
        Parent alertfxml = FXMLLoader.load(this.getClass().getResource("/view/alerts.fxml"));
        Scene alertScene = new Scene(alertfxml);

        Stage primaryStage =  new Stage();
        primaryStage.setScene(alertScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
