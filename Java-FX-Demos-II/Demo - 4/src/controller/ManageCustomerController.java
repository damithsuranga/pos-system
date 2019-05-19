package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.CustomerTM;

import java.io.IOException;
import java.sql.*;

public class ManageCustomerController {

    public Label lblTitle;
    public TableView<CustomerTM> tblCustomers;

    public void initialize(){

        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        double colWidth = tblCustomers.getColumns().get(3).getWidth();
        tblCustomers.getColumns().remove(3);

        TableColumn<CustomerTM, String> lastCol = new TableColumn<>("Delete");
        tblCustomers.getColumns().add(lastCol);
        lastCol.setPrefWidth(colWidth);
        lastCol.setCellFactory(new Callback<TableColumn<CustomerTM, String>, TableCell<CustomerTM, String>>() {
            @Override
            public TableCell<CustomerTM, String> call(TableColumn<CustomerTM, String> param) {
                return new TableCell<CustomerTM, String>(){

                    Button btnDelete = new Button("Delete");

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty)
                        setGraphic(btnDelete);
                        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                int rowIndex = ((TableRow)((Button)event.getSource()).getParent().getParent()).getIndex();
                                tblCustomers.getItems().remove(rowIndex);

                            }
                        });
                    }
                };
            }
        });

//        EventHandler<ActionEvent> myEventHandler = new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                CustomerTM selectedItem = tblCustomers.getSelectionModel().getSelectedItem();
//                tblCustomers.getItems().remove(selectedItem);
//            }
//        };

//        tblCustomers.getItems().add(new CustomerTM("C001","Kasun","Galle",myEventHandler));
//        tblCustomers.getItems().add(new CustomerTM("C002","Nimal","Matara",myEventHandler));

        try {

            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "SELECT * FROM Customer";

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();

            while(rst.next()){
                String id = rst.getString("id");
                String name = rst.getString("name");
                String address = rst.getString("address");
                tblCustomers.getItems().add(new CustomerTM(id,name,address));
            }

            rst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void btnGoBack_OnAction(ActionEvent actionEvent) throws IOException {
        Parent manageCustomer = FXMLLoader.load(this.getClass().getResource("/view/dashboard.fxml"));
        Scene firstScene = new Scene(manageCustomer);

        Stage mainStage = (Stage) lblTitle.getScene().getWindow();
        mainStage.setScene(firstScene);
    }

}
