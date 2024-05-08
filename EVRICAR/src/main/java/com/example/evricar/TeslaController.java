package com.example.evricar;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class TeslaController implements Initializable {
    public TextField linea_sportiva;
    public TextField linea_citycar;
    public TextField linea_suv;

    public Button btn_citycar;
    public Button btn_suv;
    public Button btn_sportiva;

    public Pane panel_sportive;
    public Pane panel_citycar;
    public Pane panel_suv;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_sportiva.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                linea_sportiva.setVisible(true);
                panel_sportive.setVisible(true);
            }
        });

        btn_citycar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                linea_citycar.setVisible(true);
                panel_citycar.setVisible(true);
            }
        });

        btn_suv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                linea_suv.setVisible(true);
                panel_suv.setVisible(true);
            }
        });
    }

    public void AllNotVisible() {
        linea_sportiva.setVisible(false);
        linea_suv.setVisible(false);
        linea_citycar.setVisible(false);
        panel_citycar.setVisible(false);
        panel_suv.setVisible(false);
        panel_sportive.setVisible(false);
    }

    public void modelS (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,20);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,20);
    }
    public void model3 (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,21);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,21);
    }
    public void modelY (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,22);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,22);
    }

}
