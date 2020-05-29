package com.teodor.ui;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.logging.Logger;
import com.sun.javafx.logging.PlatformLogger;
import com.teodor.models.Payment;
import com.teodor.services.FinancialService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

public class MainScreen extends Application implements Initializable {

    public static final CountDownLatch latch = new CountDownLatch(1);
    public static MainScreen MainScreen = null;
    public JFXButton tableStartButton;


    @FXML private JFXButton addEntryMainScreenButton;

    public static MainScreen waitForMainScreen() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return MainScreen;
    }

    public static void setMainScreen(MainScreen MainScreen0) {
        MainScreen = MainScreen0;
        latch.countDown();
    }

    public MainScreen() {
        setMainScreen(this);
    }

    public void printSomething() {
        System.out.println("You called a method on the application");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root, 1024, 600);
        stage.setScene(scene);
        stage.show();

        JFXButton testStartBtn = (JFXButton) scene.lookup("#tableStartButton");

        testStartBtn.setOnMouseClicked((event) -> {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("TableScreen.fxml"));
                /*
                 * if "fx:controller" is not set in fxml
                 * fxmlLoader.setController(NewWindowController);
                 */

                Scene scene2 = new Scene(fxmlLoader.load(), 800, 800);
                Stage stage2 = new Stage();

                stage2.setTitle("Tables");
                stage2.setScene(scene2);

                stage2.show();
            } catch (IOException e) {

            }
        });



    }

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addEntryMainScreenButton.setOnAction(e -> {
            try {
                FinancialService financialDB = new FinancialService();
                financialDB.addEntry(new Payment(99,"Ceva Nume",234,"6.6.2020"));

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        });
    }


}


