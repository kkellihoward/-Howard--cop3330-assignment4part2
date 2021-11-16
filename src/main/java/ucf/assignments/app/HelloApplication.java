/*
 * UCF COP3330 Fall 2021 Assignment 4 Solution
 * Copyright 2021 Kelli Howard
 */

package ucf.assignments.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("displayGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 615);
        stage.setTitle("Todo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}