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

public class RangeController implements Initializable {

    public TextField linea_offRoad;
    public TextField linea_suv;
    public Button btn_suv;
    public Pane panel_suv;

    public Button btn_offRoad;
    public Pane panel_offRoad;
    public ImageView mostra_rangeRover;
    public ImageView mostra_defender;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_suv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AllNotVisible();
                linea_suv.setVisible(true);
                panel_suv.setVisible(true);
            }
        });
        btn_offRoad.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
        linea_offRoad.setVisible(false);
        panel_offRoad.setVisible(false);
        panel_suv.setVisible(false);
    }

    public void Range (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,15);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,15);
    }
    public void Defender (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,16);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,16);
    }
    public void Discovery (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,17);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,17);
    }
}
