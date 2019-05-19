package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HomeController {


    @FXML
    private ComboBox cmbNames;
    @FXML
    private Label lblOutput;

    public HomeController(){
        System.out.println("Constructor");
        System.out.println(lblOutput);
    }

    public void initialize(){
        System.out.println("Initialize");
        System.out.println(lblOutput);

        /*
        ObservableList items = cmbNames.getItems();
        items.add("Maliban");
        items.add("Seeni");
        items.add("Sudu Baba");
        items.add("Aba");
        items.add("Kolami");
        */

        /*
        ObservableList items = FXCollections.observableArrayList();
        items.add("Maliban");
        items.add("Seeni");
        items.add("Sudu Baba");
        items.add("Aba");
        items.add("Kolami");
        cmbNames.setItems(items);
        */

        ArrayList items = new ArrayList();
        items.add("Maliban");
        items.add("Seeni");
        items.add("Sudu Baba");
        items.add("Aba");
        items.add("Kolami");
        ObservableList obsl = FXCollections.observableArrayList(items);
        cmbNames.setItems(obsl);

    }

    public void cmbNames_OnAction(ActionEvent actionEvent) {
//        lblOutput.setText(cmbNames.getValue() + "");
        lblOutput.setText(cmbNames.getSelectionModel().getSelectedItem() + "");
    }



}
