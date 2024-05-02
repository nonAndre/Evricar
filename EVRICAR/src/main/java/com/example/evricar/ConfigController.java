package com.example.evricar;

import javafx.event.ActionEvent;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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

    public void goBack(ActionEvent actionEvent) throws IOException {
        DButils.changeScene(actionEvent,"structureShow.fxml",null,null,null);
    }

    public void askPrev(ActionEvent actionEvent) {
        if(testAutoData.id_name != null)
        {
            System.out.println("Going to preventivo  page");
        }else{
            DButils.changeScene(actionEvent,"structureSignIn.fxml",null,null,null);
            System.out.println("Non sei loggato ti devi loggare");
        }
    }

    public void DragAndDrop(DragEvent dragEvent) throws FileNotFoundException {
        Dragboard dragboard = dragEvent.getDragboard();
        if (dragboard.hasImage() || dragboard.hasFiles()) {
            try
            {
                imageUsato.setImage(new Image(new FileInputStream(dragboard.getFiles().get(0))));
            }catch(FileNotFoundException e)
            {
                throw new RuntimeException();
            }

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

    public void setPrezzo()
    {
        currentPrice = String.valueOf(testAutoData.prezzo+0.820);
        prezzo.setText(currentPrice);
    }

    public void resetPrezzo()
    {
        prezzo.setText(String.valueOf(testAutoData.prezzo));
        currentPrice = String.valueOf(testAutoData.prezzo);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prezzo.setText(String.valueOf(testAutoData.prezzo));
        
        nero.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                resetPrezzo();
                NotVisibleColor();
                Xnero.setVisible(true);
            }
        });
        bianco.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                resetPrezzo();
                NotVisibleColor();
                Xbianco.setVisible(true);
            }
        });
        rosso.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPrezzo();
                NotVisibleColor();
                Xrosso.setVisible(true);
            }
        });

        blu.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPrezzo();
                NotVisibleColor();
                Xblu.setVisible(true);
            }
        });
        arancione.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPrezzo();
                NotVisibleColor();
                Xarancione.setVisible(true);
            }
        });
        giallo.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPrezzo();
                NotVisibleColor();
                Xgiallo.setVisible(true);
            }
        });
        verde.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPrezzo();
                NotVisibleColor();
                Xverde.setVisible(true);
            }
        });


        ToggleGroup toggleGroup = new ToggleGroup();
        s_benzina.setToggleGroup(toggleGroup);
        s_gasolio.setToggleGroup(toggleGroup);
        s_elettrica.setToggleGroup(toggleGroup);
        s_ibrida.setToggleGroup(toggleGroup);
        s_ibridaPlugIn.setToggleGroup(toggleGroup);

        btn_usato.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (testAutoData.id_name != null)
                {
                    pane_usato.setVisible(true);
                    text_usato.setVisible(true);
                    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
                    anchorPane.setPrefHeight(1060);
                }else{
                    System.out.println("Non sei loggato ti devi loggare");
                }

            }
        });

        switch (testAutoData.idAuto)
        {
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


}
