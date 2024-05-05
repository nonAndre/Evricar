package com.example.evricar;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class PreventivoController implements Initializable {

    public Label nome;
    public Label modello;
    public Label marca;
    public Label col;
    public Label opt;
    public Label mot;
    public Label used;
    public Label data_rit;
    public Label citta;
    public Label usato_mod;
    public Label marca_used;
    public Label telef;
    public Label mail;
    public Button indietro;
    public Label prezzo;
    public StringBuilder builder = new StringBuilder();
    public Button accetta;

    public void goBack(ActionEvent event) {
        DButils.changeScene(event,"structureConfigure.fxml",null,null,null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nome.setText(testAutoData.id_name);
        modello.setText(testAutoData.modello);
        prezzo.setText(String.valueOf(testAutoData.prezzoFin));
        marca.setText(testAutoData.marca);
        col.setText(testAutoData.colore);
        opt.setText(String.valueOf(testAutoData.optional));
        mot.setText(testAutoData.engine);
        data_rit.setText(testAutoData.date);
        citta.setText(testAutoData.city);
        used.setText(String.valueOf(testAutoData.secondHand));
        usato_mod.setText(testAutoData.usatoModello);
        marca_used.setText(testAutoData.marcaUsato);
        telef.setText(testAutoData.telefono);
        mail.setText(testAutoData.mail);
    }

    public void AccettaPrev(ActionEvent event) throws SQLException, IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Prev.txt"));
            bufferedWriter.write(String.valueOf(testAutoData.id_name));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.modello));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.prezzoFin));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.marca));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.colore));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.optional));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.engine));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.date));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.city));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.telefono));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.mail));
            bufferedWriter.write("\n");

             if (testAutoData.secondHand) {
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.usatoModello));
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.marcaUsato));
            bufferedWriter.write("\n");
             }

            bufferedWriter.close();
            readFile();
            DButils.setPrev(builder);
            DButils.getIdPrev(builder);
            DButils.setLink(testAutoData.idUser,testAutoData.idPreventivo,testAutoData.secondHand,testAutoData.city);

            if(testAutoData.secondHand)
            {
                testAutoData.preventivoApprovato  = true;
                //Pop-up Grazie per aver acquistato da noi ( pulsante torna la catalogo )
                DButils.changeScene(event,"structureCatalog.fxml",null,null,null);
            }else {
                testAutoData.preventivoApprovato  = false;
                //Pop-up il suo preventivo dovrà essere accettato ( pulsante ok torna al catalogo )
                DButils.changeScene(event,"structureCatalog.fxml",null,null,null);
            }

    }

    public void readFile() throws FileNotFoundException, SQLException {

        try (Scanner scanner = new Scanner(new File("Prev.txt"))) {
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
            }
        }
    }
}

