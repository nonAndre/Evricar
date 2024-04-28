package com.example.evricar;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ShowController {



    public Label Test;
    public Label Desc;
    public Label Altezza;
    public Label Modello;
    public Label Marca;
    public Label Larghezza;
    public Label Peso;
    public Label Volume;
    public Label Prezzo;

    public void set (int id)
    {
        Modello.setText(testAutoData.modello);
        Marca.setText(testAutoData.marca);
        Desc.setText(testAutoData.desc);
        Altezza.setText(String.valueOf(testAutoData.alt));
        Larghezza.setText(String.valueOf(testAutoData.lar));
        Peso.setText(String.valueOf(testAutoData.peso));
        Volume.setText(String.valueOf(testAutoData.volume));
        Prezzo.setText(String.valueOf(testAutoData.prezzo));
        Test.setText((id)+"");
    }
}
