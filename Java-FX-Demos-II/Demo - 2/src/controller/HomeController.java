package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HomeController {
    public ListView lstNames;
    public Label lblOutput;

    public void initialize(){
        lstNames.getItems().add("Kasun");
        lstNames.getItems().add("Nimal");
        lstNames.getItems().add("Anuja");
        lstNames.getItems().add("Maliban");
        lstNames.getItems().add("Seshan");

        lstNames.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        lblOutput.setText(newValue + "");
                    }
                });
    }

    public void lstNames_OnClick(MouseEvent mouseEvent) {
        lblOutput.setText(lstNames.getSelectionModel().getSelectedItem() + "");
    }
//
//    public void lstNames_OnKeyReleased(KeyEvent keyEvent) {
//        lblOutput.setText(lstNames.getSelectionModel().getSelectedItem() + "");
//    }
}
