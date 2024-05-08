package com.example.evricar;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ImpiegatiController implements Initializable {


    public ObservableList<String> lista;

    @FXML
    public TableView <String> table;
    public GridPane root;
    public GridPane buttons;
    public TextField codice_prev;
    public Button show;
    public GridPane root2;
    public Hyperlink myEvricar;
    private String content;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myEvricar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DButils.changeScene(event,"structureSignIn.fxml","Sign In",null,null);
            }
        });

        try {
            DButils.setTable();

            for (int col = 0; col < 4; col++) {
                for (int row = 0; row < testAutoData.prev.size()/4; row++) {
                    Label label = new Label();
                    label.setText(testAutoData.prev.get(row*4+col));
                    root.add(label, col, row);
                    root.setMaxSize(300,300);
                }
            }

            for (int col1 = 0; col1 < 4; col1++) {
                for (int row1 = 0; row1 < testAutoData.prevV.size()/4; row1++) {
                    Label label = new Label();
                    label.setText(testAutoData.prevV.get(row1*4+col1));
                    root2.add(label, col1, row1);
                    root2.setMaxSize(300,300);
                }
            }
           setLink();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostraPrev(ActionEvent event) {

        if (!codice_prev.getText().isEmpty() && (testAutoData.prev.contains(codice_prev.getText()) || testAutoData.prevV.contains(codice_prev.getText())))
        {
            if(testAutoData.prev.contains(codice_prev.getText()))
            {
                testAutoData.cond = "1";
            }
            if (testAutoData.prevV.contains(codice_prev.getText())){
                testAutoData.cond = "0";
            }

            testAutoData.codPreventivo = codice_prev.getText();
            DButils.changeScene(event,"structureShowPreventivo.fxml",null,null,null);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Non hai inserito un codice valido");
            alert.setHeaderText(null);
            alert.setContentText("Inserisci un codice valido");
            alert.show();
        }

    }

    public void setLink ()
    {
        if (testAutoData.nameImpiegati != null && !testAutoData.nameImpiegati.isEmpty())
        {
            myEvricar.setText(testAutoData.nameImpiegati);
        }

    }
}
