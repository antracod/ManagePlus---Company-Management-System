package com.teodor.ui;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.logging.Logger;
import com.sun.javafx.logging.PlatformLogger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class MainScreen extends Application {

    public static final CountDownLatch latch = new CountDownLatch(1);
    public static MainScreen MainScreen = null;
    public JFXButton tableStartButton;




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



}


