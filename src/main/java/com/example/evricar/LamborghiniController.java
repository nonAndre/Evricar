package com.example.evricar;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LamborghiniController {
    public ImageView mostra_aventador;
    public ImageView mostra_huracan;
    public ImageView mostra_sto;

    public void Aventador (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,6);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,6);
    }
    public void Huracan (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,5);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,5);
    }
    public void Sto (MouseEvent mouseEvent)
    {
        DButils.getInfo(mouseEvent,4);
        DButils.ChangeSceneMouseEvent(mouseEvent,"structureShow.fxml",null,4);
    }
}
