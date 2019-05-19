package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import util.CustomerTM;

public class HomeController {

    public TableView<CustomerTM> tblCustomers;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;

    public void initialize(){

        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList<CustomerTM> items = tblCustomers.getItems();
        items.add(new CustomerTM("C001","Maliban","Kahawatta"));
        items.add(new CustomerTM("C002","Anuja","Kadawatha"));
        items.add(new CustomerTM("C003","Aba","Wawagedara"));

        txtId.setDisable(true);
        txtName.setDisable(true);
        txtAddress.setDisable(true);

        tblCustomers.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<CustomerTM>() {
                    @Override
                    public void changed(ObservableValue<? extends CustomerTM> observable, CustomerTM oldValue, CustomerTM newValue) {

                        if (newValue == null) {
                            txtId.clear();
                            txtName.clear();
                            txtAddress.clear();
                            return;
                        }

                        txtId.setText(newValue.getId());
                        txtName.setText(newValue.getName());
                        txtAddress.setText(newValue.getAddress());

                        txtId.setDisable(true);
                        txtName.setDisable(true);
                        txtAddress.setDisable(true);
                    }
                }
        );

    }

    public void btnNewCustomer_OnAction(ActionEvent actionEvent) {
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtId.requestFocus();
        tblCustomers.getSelectionModel().clearSelection();
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtId.getText().length() == 0 || txtName.getText().length() == 0
          ||txtAddress.getText().length() == 0 || txtId.isDisabled()){
            txtId.requestFocus();
            return;
        }

        CustomerTM newCustomer = new CustomerTM(txtId.getText(),
                txtName.getText(),
                txtAddress.getText());
        tblCustomers.getItems().add(newCustomer);

        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtId.requestFocus();
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
        CustomerTM selectedItem = tblCustomers.getSelectionModel().getSelectedItem();
        tblCustomers.getItems().remove(selectedItem);
        tblCustomers.getSelectionModel().clearSelection();
    }
}
