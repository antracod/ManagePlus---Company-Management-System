package com.teodor.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;

public class MainScreen extends Application {

    public static final CountDownLatch latch = new CountDownLatch(1);
    public static MainScreen MainScreen = null;

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
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
