package org.projeto.javafx.projetosimplejavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.projeto.javafx.projetosimplejavafx.HelloApplication;
import org.projeto.javafx.projetosimplejavafx.model.services.DepartmentService;
import org.projeto.javafx.projetosimplejavafx.util.Alerts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbort;

    @FXML
    private Label labelTxt;

    public void oMenuItemSallerAction() {
        System.out.println("MenuItemSaller");
    }

    public void oMenuItemDepartmentAction() {
        //System.out.println("MenuItemDepartment");
        loadView("Department-view.fxml", (DepartmentController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }

    public void oMenuItemAbortAction() {
        //System.out.println("MenuItemabort");
        loadView("About-view.fxml", x -> {});
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public synchronized <T> void loadView(String windows, Consumer<T> initializingAction) {
        try {
            FXMLLoader loadView = new FXMLLoader(HelloApplication.class.getResource(windows));
            VBox newVbox = loadView.load();

            Scene sceneLoad = HelloApplication.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) sceneLoad.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVbox.getChildren());

            T controller = loadView.getController();
            initializingAction.accept(controller);

        }
        catch (IOException e) {
            Alerts.showAlert("Erro de compilaçao", "erro information", "renecie e lige", Alert.AlertType.ERROR);
        }
    }

 /*   private synchronized void loadView2(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = HelloApplication.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

            DepartmentController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }*/
}
