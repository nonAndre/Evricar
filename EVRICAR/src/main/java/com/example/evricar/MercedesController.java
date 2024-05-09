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

public class MercedesController implements Initializable {

    public TextField linea_sportiva;
    public TextField linea_citycar;
    public TextField linea_suv;

    public Button btn_citycar;
    public Button btn_suv;
    public Button btn_sportiva;

    public Pane panel_sportive;
    public Pane panel_citycar;
    public Pane panel_suv;

    public ImageView mostra_classeA;
    public ImageView mostra_GLC;
    public ImageView mostra_amgGTR;

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

    public void classeA (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,9);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,9);
    }
    public void Gtr (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,7);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,7);
    }
    public void Glc (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,8);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,8);
    }

}
