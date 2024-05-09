package com.example.evricar;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class OpelController implements Initializable {

    public TextField linea_citycar;
    public Button btn_citycar;
    public Pane panel_citycar;

    public TextField linea_suv;
    public Button btn_suv;
    public Pane panel_suv;

    public ImageView mostra_corsa;
    public ImageView mostra_karl;
    public ImageView mostra_mokka;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        linea_suv.setVisible(false);
        linea_citycar.setVisible(false);
        panel_citycar.setVisible(false);
        panel_suv.setVisible(false);
    }

    public void Corsa (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,12);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,12);
    }
    public void Karl (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,13);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,13);
    }
    public void Mokka (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,14);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,14);
    }
}
