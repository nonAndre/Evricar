package com.example.evricar;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ImpiegatiController implements Initializable {


    public ObservableList<String> lista;
    public GridPane Grid;
    public TableView <String> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DButils.setTable();
            System.out.println("THIS IS THE TABLE");
            System.out.println(testAutoData.prev);
            int rows = testAutoData.prev.size()/5;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
