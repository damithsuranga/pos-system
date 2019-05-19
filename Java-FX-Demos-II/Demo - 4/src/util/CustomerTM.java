package util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CustomerTM {

    private String id;
    private String name;
    private String address;
//    private Button btnDelete = new Button("Delete");

    public CustomerTM() {
    }

//    public CustomerTM(String id, String name, String address, EventHandler<ActionEvent> actionEvent) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        btnDelete.setOnAction(actionEvent);
//    }

    public CustomerTM(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
/*
    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }*/
}
