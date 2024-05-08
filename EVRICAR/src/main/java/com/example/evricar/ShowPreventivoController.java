package com.example.evricar;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class ShowPreventivoController implements Initializable {

    public Button back;
    public Label Richiedente;
    public Label modelloAuto;
    public Label Prezzo;
    public Label Marca;
    public Label Colore;
    public Label Optional;
    public Label alimentazione;
    public Label dataRit;
    public Label LuogoRit;
    public Label tel;
    public Label marcaUsato;
    public Label annoUsato;
    public Label modelloUsato;
    public Label mail;

    public void Accetta(ActionEvent actionEvent) {
        DButils.getIdFromImpiegati(actionEvent,Richiedente.getText());
        testAutoData.accettato = "true";
        DButils.updateTable(testAutoData.accettato,testAutoData.codPreventivo);
        DButils.eliminaPrev(testAutoData.codPreventivo);
        DButils.changeScene(actionEvent,"structureImpiegati.fxml",null,null,null);
    }

    public void Rifiuta(ActionEvent actionEvent) {
        DButils.getIdFromImpiegati(actionEvent,Richiedente.getText());
        testAutoData.accettato = "false";
        DButils.updateTable(testAutoData.accettato,testAutoData.codPreventivo);
        DButils.eliminaPrev(testAutoData.codPreventivo);
        DButils.changeScene(actionEvent,"structureImpiegati.fxml",null,null,null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DButils.getPrevCont(testAutoData.codPreventivo);

            if (Objects.equals(testAutoData.cond, "0"))
            {
                String[] parts = testAutoData.contenuto.split("£");
                Richiedente.setText(parts[0]);
                modelloAuto.setText(parts[1]);
                Prezzo.setText(parts[2]);
                Marca.setText(parts[3]);
                Colore.setText(parts[4]);
                Optional.setText(parts[5]);
                alimentazione.setText(parts[6]);
                dataRit.setText(parts[7]);
                LuogoRit.setText(parts[8]);
                tel.setText(parts[9]);
                mail.setText(parts[10]);
                modelloUsato.setVisible(true);
                marcaUsato.setVisible(true);
                annoUsato.setVisible(true);
                modelloUsato.setText(parts[12]);
                marcaUsato.setText(parts[11]);
                annoUsato.setText(parts[13]);


            }else {
                String[] parts = testAutoData.contenuto.split("£");
                Richiedente.setText(parts[0]);
                modelloAuto.setText(parts[1]);
                Prezzo.setText(parts[2]);
                Marca.setText(parts[3]);
                Colore.setText(parts[4]);
                Optional.setText(parts[5]);
                alimentazione.setText(parts[6]);
                dataRit.setText(parts[7]);
                LuogoRit.setText(parts[8]);
                tel.setText(parts[9]);
                mail.setText(parts[10]);
                modelloUsato.setVisible(false);
                marcaUsato.setVisible(false);
                annoUsato.setVisible(false);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void indietro(ActionEvent event) {
        DButils.changeScene(event,"structureImpiegati.fxml",null,null,null);
    }
}
