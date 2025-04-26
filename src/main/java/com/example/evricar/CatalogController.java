package com.example.evricar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CatalogController  implements Initializable {
    public StackPane contentArea;
    public Hyperlink hyperLink;
    public TextField linea_audi;
    public TextField linea_lamborghini;
    public TextField linea_mustang;
    public TextField linea_opel;
    public TextField linea_landRover;
    public TextField linea_renault;
    public TextField linea_tesla;
    public TextField linea_mercedes;
    public Label esitoAcquisto;
    public Label consegna;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureAudi.fxml")));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        hyperLink.setOnAction((ActionEvent event) -> {
            DButils.changeScene(event, "structureSignIn.fxml", null, null, null);
        });
    }

    public void audiCatalog(ActionEvent event) throws IOException {
        AllNotVisible();
        linea_audi.setVisible(true);
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureAudi.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void lamboCatalog(javafx.event.ActionEvent actionEvent) throws IOException {
        AllNotVisible();
        linea_lamborghini.setVisible(true);
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureLamborghini.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void mercedesCatalog(javafx.event.ActionEvent actionEvent) throws IOException {
        AllNotVisible();
        linea_mercedes.setVisible(true);
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureMercedes.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void mustangCatalog(javafx.event.ActionEvent actionEvent) throws IOException {
        AllNotVisible();
        linea_mustang.setVisible(true);
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureMustang.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void opelCatalog(javafx.event.ActionEvent actionEvent) throws IOException {
        AllNotVisible();
        linea_opel.setVisible(true);
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureOpel.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void rangeCatalog(javafx.event.ActionEvent actionEvent) throws IOException {
        AllNotVisible();
        linea_landRover.setVisible(true);
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureLandRover.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void renaultCatalog(javafx.event.ActionEvent actionEvent) throws IOException {
        AllNotVisible();
        linea_renault.setVisible(true);
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureRenault.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void teslaCatalog(javafx.event.ActionEvent actionEvent) throws IOException {
        AllNotVisible();
        linea_tesla.setVisible(true);
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("structureTesla.fxml")));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void setHyperLink(String name) {
        if (name != null) {
            testAutoData.id_name = name;
            System.out.println(testAutoData.id_name);
            DButils.getIdFromCatalog(testAutoData.id_name);

            DButils.getResult(testAutoData.idUserFromCatalog);
            DButils.getArrivo(testAutoData.idUserFromCatalog);

            if (Objects.equals(testAutoData.esito, "true"))
            {
                esitoAcquisto.setVisible(true);
                esitoAcquisto.setText("Preventivo Accettato");
            }
            else if (Objects.equals(testAutoData.esito, "false"))
            {
                esitoAcquisto.setVisible(true);
                esitoAcquisto.setText("Preventivo Rifiutato");
            }
            else {
                esitoAcquisto.setVisible(false);
            }

            if(Objects.equals(testAutoData.arrivo, "true"))
            {
                consegna.setVisible(true);
                consegna.setText("ARRIVATA");
            }else {
                consegna.setVisible(false);
            }


            hyperLink.setText(name);
        }

    }

    public void AllNotVisible() {
        linea_audi.setVisible(false);
        linea_lamborghini.setVisible(false);
        linea_mercedes.setVisible(false);
        linea_mustang.setVisible(false);
        linea_opel.setVisible(false);
        linea_landRover.setVisible(false);
        linea_renault.setVisible(false);
        linea_tesla.setVisible(false);
    }
}
