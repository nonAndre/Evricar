package com.example.evricar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class AudiController implements Initializable {
    public Pane panel_sportive;
    public Pane panel_citycar;
    public Pane panel_coupe;
    public TextField linea_sportiva;
    public TextField linea_citycar;
    public TextField linea_coupe;
    public Button btn_sportiva;
    public Button btn_citycar;
    public Button btn_coupe;

    public ImageView mostra_A5;
    public ImageView mostra_A1;
    public ImageView mostra_rs3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_sportiva.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                linea_sportiva.setVisible(true);
                panel_sportive.setVisible(true);
            }
        });

        btn_citycar.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                linea_citycar.setVisible(true);
                panel_citycar.setVisible(true);
            }
        });

        btn_coupe.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                linea_coupe.setVisible(true);
                panel_coupe.setVisible(true);
            }
        });
    }

    public void AllNotVisible() {
        linea_sportiva.setVisible(false);
        linea_coupe.setVisible(false);
        linea_citycar.setVisible(false);
        panel_citycar.setVisible(false);
        panel_coupe.setVisible(false);
        panel_sportive.setVisible(false);
    }

    public void A1 (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,3);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,3);
    }
    public void A5 (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,2);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,2);
    }
    public void RS_3 (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,1);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,1);
    }

}
