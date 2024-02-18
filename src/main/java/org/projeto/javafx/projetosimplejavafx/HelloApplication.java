package org.projeto.javafx.projetosimplejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("projeto-view.fxml"));
        ScrollPane parent = fxmlLoader.load();

        parent.setFitToHeight(true);
        parent.setFitToWidth(true);

        scene = new Scene(parent);
        stage.setTitle("Projeto JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static Scene getMainScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}