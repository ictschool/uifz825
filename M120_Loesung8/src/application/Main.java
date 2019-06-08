package application;

import application.view.*;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Laden des Layout Containers via FXMLLoader
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/MainView.fxml"));
			Parent rootLayout = loader.load();
			
			//Laden des Controllers
			MainViewController mainController = loader.getController();
			//Übergabe des Hauptfensters an den Controller
			mainController.setStage(primaryStage);
			
			//Scene erstellen und anzeigen (Die Fenstergrösse wird hier im TestView.fxml festgelegt)
			Scene scene = new Scene(rootLayout);
			
			primaryStage.setTitle("Kunden-Browser");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
