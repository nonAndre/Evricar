package com.example.evricar;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ShowController implements Initializable {
    public Hyperlink myEvricar;
    public ImageView imgAuto;
    public ImageView imgCollage;
    public Label marca;
    public Label modello;
    public Label prezzo;
    public TextArea desc;
    public Label altezza;
    public Label lunghezza;
    public Label larghezza;
    public Label peso;
    public Label volume;
    public Button back;
    public Button configura;
    public Image img1;
    public Image img2;


    public void back (ActionEvent event) {
        DButils.changeScene(event,"structureCatalog.fxml",null,testAutoData.id_name,null);
    }
    public void conf (ActionEvent event) {
        DButils.getId(event,testAutoData.id_name);
        DButils.changeScene(event,"structureConfigure.fxml",null,testAutoData.id_name,null);
    }

    public void log(ActionEvent event) {
        DButils.changeScene(event,"structureSignIn.fxml",null,null,null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (testAutoData.id_name!=null) {
            myEvricar.setText(testAutoData.id_name);
        }else {
            myEvricar.setText("My Evricar");
        }

        modello.setText(testAutoData.modello);
        marca.setText(testAutoData.marca);
        desc.setText(testAutoData.desc);
        lunghezza.setText(String.valueOf(testAutoData.lun));
        altezza.setText(String.valueOf(testAutoData.alt));
        larghezza.setText(String.valueOf(testAutoData.lar));
        peso.setText(String.valueOf(testAutoData.peso));
        volume.setText(String.valueOf(testAutoData.volume));
        prezzo.setText(String.valueOf(testAutoData.prezzo));

        switch (testAutoData.idAuto) {
            case 1:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Audi/AudiRS3.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Audi/Rs3Collage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 2:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Audi/AudiA5.jpeg");
                img2= new Image("file::src/main/resources/com/example/evricar/Image/Audi/A5Collage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 3:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Audi/AudiA1.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Audi/A1Collage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 4:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/LamborghiniSTO.jpeg");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/stoCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 5:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/LamborghiniHuracan.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/HuracanCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 6:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/LamborghiniAventador.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Lamborghini/AventadorCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 7:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/MercedesAmgGt.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/AmgGtCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 8:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/MercedesGLC.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/GlcCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;

            case 9:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/MercedesClasseA.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Mercedes/Acollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 10:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Mustang/MustangMachE.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Mustang/MachECollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;

            case 12:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Opel/OpelCorsa.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Opel/CorsaCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;

            case 11:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Mustang/MustangGT500.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Mustang/Gt500Collage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 13:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Opel/OpelKarl.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Opel/KarlsCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 14:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Opel/OpelMokka.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Opel/MokkaCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 15:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/LandRoverRangeRover.jpeg/");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/RangeRoverCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 16:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/LandRoverDefender.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/DefenderCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 18:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Renault/RenaultAustral.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Renault/AustralCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 17:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/LandRoverDiscovery.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/LandRover/DiscoveryCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 19:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Renault/RenaultClio.jpeg");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Renault/ClioCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 20:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/TeslaModelS.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/SCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 21:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/TeslaModel3.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/3Collage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 22:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/TeslaModelY.jpeg");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Tesla/YCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
            case 23:
                img1= new Image("file:src/main/resources/com/example/evricar/Image/Renault/RenaultMeganeE-tech.png");
                img2= new Image("file:src/main/resources/com/example/evricar/Image/Renault/MeganCollage.JPEG");
                imgAuto.setImage(img1);
                imgCollage.setImage(img2);
                break;
        }
    }
}
