package com.example.evricar;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OptionalController  implements Initializable {
    
    
    public Button button;
    public TextField autoText;
    public TextField optionalText;
    public GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DButils.getAutoInfo();
            for (int col = 0; col < 3; col++) {
                for (int row = 0; row < 23; row++) {
                    Label label = new Label();
                    label.setText(testAutoData.auto.get(row*3+col));
                    gridPane.add(label, col, row);
                    gridPane.setMaxSize(300,300);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void previus(ActionEvent event) {
        DButils.changeScene(event,"structureSegreteria.fxml",null,null,null);
    }

    public void inserisci(ActionEvent event) throws SQLException {

        if (autoText.getText().isEmpty() || optionalText.getText().isEmpty() ||(Integer.parseInt(autoText.getText())< 1 || Integer.parseInt(autoText.getText()) > 23)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Inserimento dati errato");
            alert.show();
        }else
        {
            DButils.insertOptional(autoText.getText()+"£",optionalText.getText()+"£",1);
            autoText.setText("");
            optionalText.setText("");
        }


    }
    
}
