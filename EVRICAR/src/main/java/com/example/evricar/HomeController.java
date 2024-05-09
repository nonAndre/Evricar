package com.example.evricar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public TextField greenLine_audi;
    public TextField greenLine_lamborghini;
    public TextField greenLine_mercedes;
    public TextField greenLine_mustang;
    public TextField greenLine_opel;
    public TextField greenLine_landRover;
    public TextField greenLine_renault;
    public TextField greenLine_tesla;

    public Button button_audi;
    public Button button_lamborghini;
    public Button button_mercedes;
    public Button button_mustang;
    public Button button_opel;
    public Button button_landRover;
    public Button button_renault;
    public Button button_tesla;
    public Hyperlink myEvricar;

    public Button catalogo;

    @FXML
    private AnchorPane panel_audi;
    @FXML
    private AnchorPane panel_lamborghini;
    @FXML
    private AnchorPane panel_mercedes;
    @FXML
    private AnchorPane panel_mustang;
    @FXML
    private AnchorPane panel_opel;
    @FXML
    private AnchorPane panel_landRover;
    @FXML
    private AnchorPane panel_renault;
    @FXML
    private AnchorPane panel_tesla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myEvricar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DButils.changeScene(event,"structureSignIn.fxml","Sign In",null,null);
            }
        });

        button_audi.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                panel_audi.setVisible(true);
                greenLine_audi.setVisible(true);
            }
        });

        button_lamborghini.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                panel_lamborghini.setVisible(true);
                greenLine_lamborghini.setVisible(true);
            }
        });

        button_mercedes.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                panel_mercedes.setVisible(true);
                greenLine_mercedes.setVisible(true);
            }
        });

        button_mustang.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                panel_mustang.setVisible(true);
                greenLine_mustang.setVisible(true);
            }
        });

        button_opel.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                panel_opel.setVisible(true);
                greenLine_opel.setVisible(true);
            }
        });

        button_landRover.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                panel_landRover.setVisible(true);
                greenLine_landRover.setVisible(true);
            }
        });

        button_renault.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                panel_renault.setVisible(true);
                greenLine_renault.setVisible(true);
            }
        });

        button_tesla.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                panel_tesla.setVisible(true);
                greenLine_tesla.setVisible(true);
            }
        });

        catalogo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                DButils.changeScene(event,"structureCatalog.fxml",null,null,null);
            }
        });
    }

    public void AllNotVisible() {
        panel_audi.setVisible(false);
        panel_lamborghini.setVisible(false);
        panel_mercedes.setVisible(false);
        panel_mustang.setVisible(false);
        panel_opel.setVisible(false);
        panel_landRover.setVisible(false);
        panel_renault.setVisible(false);
        panel_tesla.setVisible(false);
        greenLine_audi.setVisible(false);
        greenLine_lamborghini.setVisible(false);
        greenLine_mercedes.setVisible(false);
        greenLine_mustang.setVisible(false);
        greenLine_opel.setVisible(false);
        greenLine_landRover.setVisible(false);
        greenLine_renault.setVisible(false);
        greenLine_tesla.setVisible(false);
    }
}