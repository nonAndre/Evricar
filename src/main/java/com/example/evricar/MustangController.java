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

public class MustangController implements Initializable {

    public TextField linea_suv;
    public TextField linea_sportiva;

    public Button btn_sportiva;
    public Button btn_suv;

    public Pane panel_suv;
    public Pane panel_sportive;

    public ImageView mostra_gt500;
    public ImageView mostra_machE;


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
            panel_suv.setVisible(false);
            panel_sportive.setVisible(false);
        }

    public void gt500 (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,11);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,11);
    }
    public void Mache (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,10);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,10);
    }

}
