package com.example.evricar;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


public class DButils
{
	public static void changeScene(ActionEvent event,String fxmlFile,String title , String username,String mail) {
		Parent root = null;

		if (username != null) {
			try {
				FXMLLoader loader = new FXMLLoader(DButils.class.getResource(fxmlFile));
				root = loader.load();

				if (fxmlFile.equals("structureCatalog.fxml"))
				{
					CatalogController controller = loader.getController();
					controller.setHyperLink(username);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				root = FXMLLoader.load(Objects.requireNonNull(DButils.class.getResource(fxmlFile)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(title);

		if ((fxmlFile.equals("structureSignIn.fxml")) || (fxmlFile.equals("structureSignUp.fxml"))) {
			stage.setScene(new Scene(root,950,600));
			stage.show();
		}
		else
		{
			stage.setScene(new Scene(root, 1350, 780));
			stage.show();
		}
	}



	public static void signUpUSer(ActionEvent event,String username,String password,String mail) {
		Connection connection = null;
		PreparedStatement pstInsert = null;
		PreparedStatement pstCheckUserExists = null;
		ResultSet resultSets = null;

		try{
			connection=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Car Dealer","freedb_notAndre","pGs!eJaDMPp3*56");
			pstCheckUserExists = connection.prepareStatement("SELECT username, password, mail FROM Autentificazione WHERE username=? OR mail=?");
			pstCheckUserExists.setString(1,username);
			pstCheckUserExists.setString(2,mail);
			resultSets = pstCheckUserExists.executeQuery();


			if (resultSets.isBeforeFirst())
			{
				System.out.println("Exist");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Problems:\nThe user name might be already used\nYou already have an account with this mail\n");
				alert.show();
			}
			else {
				pstInsert = connection.prepareStatement("INSERT INTO Autentificazione (username, password, mail) VALUES (?, ?, ?)");
				pstInsert.setString(1,username);
				pstInsert.setString(2,password);
				pstInsert.setString(3,mail);
				pstInsert.executeUpdate();
                changeScene(event,"structureSignIn.fxml","Welcome",username,null);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally{
			if(resultSets!=null)
			{
				try{
					resultSets.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
			if(pstCheckUserExists!=null)
			{
				try
				{
					pstCheckUserExists.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
			if (pstInsert!=null)
			{
				try
				{
					pstInsert.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
	public static void logInUSer(ActionEvent event,String mail,String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSets = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Car Dealer","freedb_notAndre","pGs!eJaDMPp3*56");
			preparedStatement =connection.prepareStatement("SELECT password, mail FROM Autentificazione WHERE username=?");
			preparedStatement.setString(1,mail);
			resultSets = preparedStatement.executeQuery();

			if (!resultSets.isBeforeFirst())
			{
				System.out.println("User not found");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Wrong password");
				alert.show();
			}else {
				while(resultSets.next()){
					String retrievePassword = resultSets.getString("password");
					String retriveMail = resultSets.getString("mail");
					if (retrievePassword.equals(password)) {
						changeScene(event,"structureCatalog.fxml","Welcome!",mail,retriveMail);
					}else{
						System.out.println("Wrong password");
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setContentText("Wrong password");
						alert.show();
					}
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			if(resultSets!=null)
			{
				try
				{
					resultSets.close();
				}catch (SQLException e){
					e.printStackTrace();
				}

			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}catch (SQLException e){
					e.printStackTrace();
				}


			}
		}
	}



	public static void ChangeSceneMouseEvent(MouseEvent event, String fxmlFile, String title , int id) {
		Parent root = null;

		if (id != 0) {
			try {
				FXMLLoader loader = new FXMLLoader(DButils.class.getResource(fxmlFile));
				root = loader.load();
                ShowController controller = loader.getController();
				controller.set(id);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				root = FXMLLoader.load(Objects.requireNonNull(DButils.class.getResource(fxmlFile)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(title);

		if ((fxmlFile.equals("structureSignIn.fxml")) || (fxmlFile.equals("structureSignUp.fxml"))) {
			stage.setScene(new Scene(root,950,600));
			stage.show();
		}
		else
		{
			stage.setScene(new Scene(root, 1350, 780));
			stage.show();
		}
	}

    public static void getInfo (MouseEvent event, int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSets = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Car Dealer","freedb_notAndre","pGs!eJaDMPp3*56");
			preparedStatement =connection.prepareStatement("SELECT descrizione,modello,marca, altezza ,lunghezza,larghezza,peso,volume_bagagliaio,prezzo FROM Automobili WHERE car_id=?");
			preparedStatement.setString(1, String.valueOf(id));
			resultSets = preparedStatement.executeQuery();

			if (!resultSets.isBeforeFirst())
			{
				System.out.println("Car not found");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Car not found");
				alert.show();
			}else {
				while(resultSets.next()){
					String retrieveDesc = resultSets.getString("descrizione");
					String retrieveMarca = resultSets.getString("marca");
					String retrieveModello = resultSets.getString("modello");
					String retriveAltezza = resultSets.getString("altezza");
					String retrieveLunghezza = resultSets.getString("lunghezza");
					String retrieveLarghezza = resultSets.getString("larghezza");
					String retrievePeso = resultSets.getString("peso");
					String retrieveVolumeBagagliaio = resultSets.getString("volume_bagagliaio");
					String retrievePrezzo = resultSets.getString("prezzo");

					testAutoData.marca=retrieveMarca;
					testAutoData.modello=retrieveModello;
					testAutoData.desc =retrieveDesc;
					testAutoData.alt= Float.parseFloat(retriveAltezza);
					testAutoData.lar= Float.parseFloat(retrieveLarghezza);
					testAutoData.peso= Float.parseFloat(retrievePeso);
					testAutoData.volume= Float.parseFloat(retrieveVolumeBagagliaio);
					testAutoData.prezzo= Float.parseFloat(retrievePrezzo);

				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if(resultSets!=null)
			{
				try
				{
					resultSets.close();
				}catch (SQLException e){
					e.printStackTrace();
				}

			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}catch (SQLException e){
					e.printStackTrace();
				}


			}
		}

	}



}