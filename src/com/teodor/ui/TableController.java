package com.teodor.ui;

import com.teodor.models.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private ObservableList<Payment> data;
    @FXML private TableView<Payment> paymentTableView;
    @FXML private TableColumn<Payment, String> idColumn;
    @FXML private TableColumn<Payment, String> ReceiverColumn;
    @FXML private TableColumn<Payment, String> ValueColumn;
    @FXML private TableColumn<Payment, String> DateColumn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        idColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("paymentID"));
        ReceiverColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("paymentReceiver"));
        ValueColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("paymentValue"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<Payment, String>("paymentDate"));

        Payment p = new Payment(1,"Daniel",2234,"dsad");
        data = FXCollections.observableArrayList();
        data.add(p);

        paymentTableView.getItems().setAll(data);


    }




}
