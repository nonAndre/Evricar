package com.example.evricar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.event.EventHandler;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConfigController implements Initializable {
    public Label prezzo;
    public ImageView image;
    public ImageView Xnero;
    public ImageView Xbianco;
    public ImageView Xrosso;
    public ImageView Xblu;
    public ImageView Xverde;
    public ImageView Xarancione;
    public ImageView Xgiallo;
    public Button nero;
    public Button bianco;
    public Button rosso;
    public Button blu;
    public Button verde;
    public Button giallo;
    public Button arancione;
    public RadioButton s_benzina;
    public RadioButton s_elettrica;
    public RadioButton s_gasolio;
    public RadioButton s_ibrida;
    public RadioButton s_ibridaPlugIn;

    public CheckBox interniPelle;
    public CheckBox vetriOscurati;
    public CheckBox telecPost;
    public CheckBox cambioAuto;
    public CheckBox sensParcheggio;

    public Button prev;
    public Button btn_usato;
    public Text text_usato;
    public Pane pane_usato;
    public ImageView imageUsato;
    public TextField marca_usato;
    public TextField modello_usato;
    public TextField anno_usato;
    public Button rimuovi_img;
    public Image img;
    public ScrollPane scrollPane;
    public AnchorPane anchorPane;
    public Button back;


    public String currentPrice;
    public Pane popUp;
    public ImageView esci;
    public Hyperlink accedi;

    @FXML
    public DatePicker data;
    @FXML
    public ChoiceBox<String> luogo;
    public TextField tel;
    public TextField email;

    private int currentMotore;
    public float appo;
    public ObservableList <String> list = FXCollections.observableArrayList();
    private String[] city = {"Verona", "Bologna", "Milano", "Roma", "Torino", "Napoli", "Bari"};


    public void getDatePicker(ActionEvent actionEvent){
        LocalDate myDate = data.getValue();
        testAutoData.date = myDate.toString();
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        DButils.changeScene(actionEvent,"structureShow.fxml",null,null,null);
    }

    public void askPrev(ActionEvent actionEvent) throws IOException, SQLException {
        testAutoData.optional = list;
        testAutoData.telefono= tel.getText();
        testAutoData.mail = email.getText();
        testAutoData.prezzoFin = Float.parseFloat(currentPrice);
        testAutoData.city = luogo.getValue();

        if(testAutoData.secondHand)
        {
            testAutoData.marcaUsato= marca_usato.getText();
            testAutoData.usatoModello= modello_usato.getText();
            testAutoData.usatoAnno= anno_usato.getText();
        }

        if(testAutoData.id_name != null)
        {
            System.out.println("Going to preventivo  page");
            DButils.changeScene(actionEvent,"structurePreventivo.fxml",null,null,null);
        }else{
            DButils.changeScene(actionEvent,"structureSignIn.fxml",null,null,null);
            System.out.println("Non sei loggato ti devi loggare");
        }
    }

    public void setAccedi(ActionEvent actionEvent) {
        DButils.changeScene(actionEvent,"structureSignIn.fxml",null,null,null);
    }

    public void askUsato(ActionEvent actionEvent) {
        if(testAutoData.id_name != null) {
            pane_usato.setVisible(true);
            text_usato.setVisible(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            anchorPane.setPrefHeight(1250);
        }else{
            popUp.setVisible(true);
            popUp.setDisable(false);
        }
    }

    public void DragAndDrop(DragEvent dragEvent) throws FileNotFoundException {
        Dragboard dragboard = dragEvent.getDragboard();
        if (dragboard.hasImage() || dragboard.hasFiles()) {
            try {
                testAutoData.secondHand = true;
                imageUsato.setImage(new Image(new FileInputStream(dragboard.getFiles().get(0))));
            }catch(FileNotFoundException e)
            {
                throw new RuntimeException();
            }
        }else {
            testAutoData.secondHand = false;
        }
    }

    public void ViewImageDrag(DragEvent dragEvent) {
        Dragboard dragboard = dragEvent.getDragboard();
        if (dragboard.hasImage() || dragboard.hasFiles()) {
            dragEvent.acceptTransferModes(TransferMode.COPY);
        }
        dragEvent.consume();
    }

    public void removeImage(ActionEvent actionEvent) {
        imageUsato.setImage(null);
    }

    public void NotVisibleColor() {
        Xnero.setVisible(false);
        Xbianco.setVisible(false);
        Xrosso.setVisible(false);
        Xblu.setVisible(false);
        Xarancione.setVisible(false);
        Xgiallo.setVisible(false);
        Xverde.setVisible(false);
    }

    public void Prezzo(float colore,float prezzoMotore,float optional)
    {
        currentPrice = String.valueOf(Float.parseFloat(currentPrice)+colore+prezzoMotore+optional);
        prezzo.setText(currentPrice);
    }

    public void Motore(int num)
    {
        switch (num)
        {
            case 1:
                appo = 0;
                break;
            case 2:
                appo = 1;
                break;
            case 3:
                appo = 5;
                break;
            case 4:
                appo = 3;
                break;
            case 5:
                appo = 2;
                break;
        }
        Prezzo(0,-1 * appo,0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        prezzo.setText(String.valueOf(testAutoData.prezzo));
        currentPrice = String.valueOf(testAutoData.prezzo);

        nero.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.colore= "Nero";
                NotVisibleColor();
                Xnero.setVisible(true);
                if(Float.parseFloat(currentPrice)<=testAutoData.prezzo)
                {
                    Prezzo(0,0,0);
                }else {
                    Prezzo(-1,0,0);
                }

            }
        });
        bianco.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.colore= "Bianco";
                NotVisibleColor();
                Xbianco.setVisible(true);
                if(Float.parseFloat(currentPrice)<=testAutoData.prezzo)
                {
                    Prezzo(0,0,0);
                }else {
                    Prezzo(-1,0,0);
                }
            }
        });
        rosso.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.colore= "Rosso";
                NotVisibleColor();
                Xrosso.setVisible(true);
                    Prezzo(1,0,0);

            }
        });

        blu.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.colore= "Blu";
                NotVisibleColor();
                Xblu.setVisible(true);
                Prezzo(1,0,0);
            }
        });
        arancione.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.colore= "Arancione";
                NotVisibleColor();
                Xarancione.setVisible(true);
                Prezzo(1,0,0);
            }
        });
        giallo.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.colore= "Giallo";
                NotVisibleColor();
                Xgiallo.setVisible(true);
                Prezzo(1,0,0);
            }
        });
        verde.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.colore= "Verde";
                NotVisibleColor();
                Xverde.setVisible(true);
                Prezzo(1,0,0);
            }
        });

        esci.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                popUp.setVisible(false);
                popUp.setDisable(true);
            }
        });


        ToggleGroup toggleGroup = new ToggleGroup();


        s_benzina.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.engine= "Benzina";
                s_benzina.setToggleGroup(toggleGroup);
                Motore(currentMotore);
                Prezzo(0,0,0);
                currentMotore = 1;
            }
        });

        s_gasolio.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.engine= "Gasolio";
                s_gasolio.setToggleGroup(toggleGroup);
                //Prezzo 1
                Motore(currentMotore);
                Prezzo(0,1,0);
                currentMotore = 2;

            }
        });

        s_elettrica.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.engine= "Elettrica";
                s_elettrica.setToggleGroup(toggleGroup);
                //Prezzo 5
                Motore(currentMotore);
                Prezzo(0,5,0);
                currentMotore = 3;

            }
        });
        s_ibrida.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.engine= "Ibrida";
                s_ibrida.setToggleGroup(toggleGroup);
                //Prezzo 3
                Motore(currentMotore);
                Prezzo(0,3,0);
                currentMotore = 4;

            }
        });
        s_ibridaPlugIn.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                testAutoData.engine= "IbridaPlugIn";
                s_ibridaPlugIn.setToggleGroup(toggleGroup);
                //prezzo 2
                Motore(currentMotore);
                Prezzo(0,2,0);
                currentMotore = 5;
            }
        });

        luogo.getItems().setAll(city);
        System.out.println(luogo.getValue());

        switch (testAutoData.idAuto) {
            case 1:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Audi/AudiRS3.png");
                image.setImage(img);
                break;
            case 2:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Audi/AudiA5.jpeg");
                image.setImage(img);
                break;
            case 3:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Audi/AudiA1.png");
                image.setImage(img);
                break;
            case 4:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/LamborghiniSTO.jpeg");
                image.setImage(img);
                break;
            case 5:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/LamborghiniHuracan.png");
                image.setImage(img);
                break;
            case 6:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/LamborghiniAventador.png");
                image.setImage(img);
                break;
            case 7:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/MercedesAmgGt.png");
                image.setImage(img);
                break;
            case 8:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/MercedesGLC.png");
                image.setImage(img);
                break;

            case 9:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/MercedesClasseA.png");
                image.setImage(img);
                break;
            case 10:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Mustang/MustangMachE.png");
                image.setImage(img);
                break;

            case 12:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Opel/OpelCorsa.png");
                image.setImage(img);
                break;

            case 11:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Mustang/MustangGT500.png");
                image.setImage(img);
                break;
            case 13:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Opel/OpelKarl.png");
                image.setImage(img);
                break;
            case 14:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Opel/OpelMokka.png");
                image.setImage(img);
                break;
            case 15:
                img= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/RangeRoverFoto.jpeg/");
                image.setImage(img);
                break;
            case 16:
                img= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/LandRoverDefender.png");
                image.setImage(img);
                break;
            case 18:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Renault/RenaultAustral.png");
                image.setImage(img);
                break;
            case 17:
                img= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/LandRoverDiscovery.png");
                image.setImage(img);
                break;
            case 19:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Renault/RenaultClio.jpeg");
                image.setImage(img);
                break;
            case 20:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/TeslaModelS.png");
                image.setImage(img);
                break;
            case 21:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/TeslaModel3.png");
                image.setImage(img);

                break;
            case 22:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/TeslaModelY.jpeg");
                image.setImage(img);
                break;
            case 23:
                img= new Image("file:src/main/resources/com/example/evricar/Image/Renault/RenaultMeganeE-tech.png");
                image.setImage(img);
                break;
        }
    }

    public void Pelle(ActionEvent event) {
        if(interniPelle.isSelected())
        {
            list.add("Interni in pelle\n");
            Prezzo(0,0,1);
        }else {
            list.remove("Interni in pelle\n");
            Prezzo(0,0,-1);
        }

    }
    public void Vetri(ActionEvent event) {
        if(vetriOscurati.isSelected())
        {
            list.add("Vetri Oscurati\n");
            Prezzo(0,0,2);
        }else {
            list.remove("Vetri Oscurati\n");
            Prezzo(0,0,-2);
        }
    }
    public void Telecamera(ActionEvent event) {
        if(telecPost.isSelected())
        {
            list.add("Retrocamera\n");
            Prezzo(0,0,3);
        }else {
            list.remove("Retrocamera\n");
            Prezzo(0,0,-3);
        }
    }
    public void Cambio(ActionEvent event) {
        if(cambioAuto.isSelected())
        {
            list.add("Cambio Automatico\n");
            Prezzo(0,0,4);
        }else {
            list.remove("Cambio Automatico\n");
            Prezzo(0,0,-4);
        }
    }
    public void Sensori(ActionEvent event) {
        if(sensParcheggio.isSelected())
        {
            list.add("Sensori\n");
            Prezzo(0,0,5);
        }else {
            list.remove("Sensori\n");
            Prezzo(0,0,-5);
        }
    }

    public void getChoice(MouseEvent mouseEvent) {
        System.out.println(luogo.getValue());
    }
}