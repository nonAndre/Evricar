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


    public Button catalogo_audi;
    public Button catalogo_lamborghini;
    public Button catalogo_mercedes;
    public Button catalogo_mustang;
    public Button catalogo_opel;
    public Button catalogo_landRover;
    public Button catalogo_renault;
    public Button catalogo_tesla;
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
    @FXML
    private Button left_arrow;
    @FXML
    private Button right_arrow;

    int slide = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myEvricar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DButils.changeScene(event,"structureSignIn.fxml","Sign In",null,null);
            }
        });

        right_arrow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                slide++;
                switch (slide) {
                    case 1:
                        panel_audi.setVisible(false);
                        greenLine_audi.setVisible(false);
                        panel_lamborghini.setVisible(true);
                        greenLine_lamborghini.setVisible(true);
                        break;
                    case 2:
                        panel_lamborghini.setVisible(false);
                        greenLine_lamborghini.setVisible(false);
                        panel_mercedes.setVisible(true);
                        greenLine_mercedes.setVisible(true);
                        break;
                    case 3:
                        panel_mercedes.setVisible(false);
                        greenLine_mercedes.setVisible(false);
                        panel_mustang.setVisible(true);
                        greenLine_mustang.setVisible(true);
                        break;
                    case 4:
                        panel_mustang.setVisible(false);
                        greenLine_mustang.setVisible(false);
                        panel_opel.setVisible(true);
                        greenLine_opel.setVisible(true);
                        break;
                    case 5:
                        panel_opel.setVisible(false);
                        greenLine_opel.setVisible(false);
                        panel_landRover.setVisible(true);
                        greenLine_landRover.setVisible(true);
                        break;
                    case 6:
                        panel_landRover.setVisible(false);
                        greenLine_landRover.setVisible(false);
                        panel_renault.setVisible(true);
                        greenLine_renault.setVisible(true);
                        break;
                    case 7:
                        panel_renault.setVisible(false);
                        greenLine_renault.setVisible(false);
                        panel_tesla.setVisible(true);
                        greenLine_tesla.setVisible(true);
                        break;
                    default:
                        slide = 7;
                        break;
                }
            }
        });

        left_arrow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                slide--;
                switch (slide) {
                    case 0:
                        panel_audi.setVisible(true);
                        greenLine_audi.setVisible(true);
                        panel_lamborghini.setVisible(false);
                        greenLine_lamborghini.setVisible(false);
                        break;
                    case 1:
                        panel_lamborghini.setVisible(true);
                        greenLine_lamborghini.setVisible(true);
                        panel_mercedes.setVisible(false);
                        greenLine_mercedes.setVisible(false);
                        break;
                    case 2:
                        panel_mercedes.setVisible(true);
                        greenLine_mercedes.setVisible(true);
                        panel_mustang.setVisible(false);
                        greenLine_mustang.setVisible(false);
                        break;
                    case 3:
                        panel_mustang.setVisible(true);
                        greenLine_mustang.setVisible(true);
                        panel_opel.setVisible(false);
                        greenLine_opel.setVisible(false);
                        break;
                    case 4:
                        panel_opel.setVisible(true);
                        greenLine_opel.setVisible(true);
                        panel_landRover.setVisible(false);
                        greenLine_landRover.setVisible(false);
                        break;
                    case 5:
                        panel_landRover.setVisible(true);
                        greenLine_landRover.setVisible(true);
                        panel_renault.setVisible(false);
                        greenLine_renault.setVisible(false);
                        break;
                    case 6:
                        panel_renault.setVisible(true);
                        greenLine_renault.setVisible(true);
                        panel_tesla.setVisible(false);
                        greenLine_tesla.setVisible(false);
                        break;
                    default:
                        slide = 0;
                        break;
                }
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

        catalogo_audi.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                DButils.changeScene(event,"structureCatalog.fxml",null,null,null);
            }
        });

        catalogo_lamborghini.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                DButils.changeScene(actionEvent,"structureCatalog.fxml",null,null,null);
            }
        });

        catalogo_mercedes.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                DButils.changeScene(actionEvent,"structureCatalog.fxml",null,null,null);
            }
        });

        catalogo_landRover.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                DButils.changeScene(actionEvent,"structureCatalog.fxml",null,null,null);
            }
        });

        catalogo_opel.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                DButils.changeScene(actionEvent,"structureCatalog.fxml",null,null,null);
            }
        });

        catalogo_mustang.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                DButils.changeScene(actionEvent,"structureCatalog.fxml",null,null,null);
            }
        });

        catalogo_renault.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                DButils.changeScene(actionEvent,"structureCatalog.fxml",null,null,null);
            }
        });

        catalogo_tesla.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                DButils.changeScene(actionEvent,"structureCatalog.fxml",null,null,null);
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