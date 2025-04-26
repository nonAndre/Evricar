package com.example.evricar;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

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
    public Label data_rit;
    public Label citta;
    public Label usato_mod;
    public Label marca_used;
    public Label anno_used;
    public Label telef;
    public Label mail;
    public Button indietro;
    public Label prezzo;
    public StringBuilder builder = new StringBuilder();
    public Button accetta;
    public Pane popUp_senzaUsato;
    public Button catalogo;
    public Pane popUp_conUsato;
    public Button catalogo1;

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
        usato_mod.setText(testAutoData.usatoModello);
        marca_used.setText(testAutoData.marcaUsato);
        anno_used.setText(testAutoData.usatoAnno);
        telef.setText(testAutoData.telefono);
        mail.setText(testAutoData.mail);
    }

    public void AccettaPrev(ActionEvent event) throws SQLException, IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Prev.txt"));
        bufferedWriter.write(String.valueOf(testAutoData.id_name));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.modello));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.prezzoFin));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");


        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.marca));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.colore));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.optional));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.engine));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.date));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.city));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.telefono));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(testAutoData.mail));
        bufferedWriter.write("£");
        bufferedWriter.write("\n");

        if (testAutoData.secondHand) {
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.usatoModello));
            bufferedWriter.write("£");
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.marcaUsato));
            bufferedWriter.write("£");
            bufferedWriter.write("\n");

            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(testAutoData.usatoAnno));
            bufferedWriter.write("£");
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
            popUp_conUsato.setVisible(true);
            popUp_conUsato.setDisable(false);
        }else {
            testAutoData.preventivoApprovato  = false;
            popUp_senzaUsato.setVisible(true);
            popUp_senzaUsato.setDisable(false);
        }

    }

    public void readFile() throws FileNotFoundException, SQLException {

        try (Scanner scanner = new Scanner(new File("Prev.txt"))) {
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
            }
        }
    }

    public void goToCatalog(ActionEvent event) {
        DButils.changeScene(event,"structureCatalog.fxml",null,null,null);
    }
}

