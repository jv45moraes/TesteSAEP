package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Stage stage;
	private static Scene main;
	private static Scene cadUser;
	private static Scene cadTarefa;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			
			//Definindo algumas configurações da tela
			primaryStage.setTitle("Programa");
			
			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/packageView/viewMain.fxml"));
			main = new Scene(fxmlMain);
			


			primaryStage.setScene(main);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TelaMain() throws IOException {
		FXMLLoader TelaMain = new FXMLLoader();
		TelaMain.setLocation(Main.class.getResource("/packageView/viewMain.fxml")); 
		Parent Main = TelaMain.load();
		main = new Scene(Main);
		stage.setScene(main);
		stage.show();
	}
	
	public static void TelaCadUsuario() throws IOException {
		FXMLLoader TelaCadUsuario = new FXMLLoader();
		TelaCadUsuario.setLocation(Main.class.getResource("/packageView/viewCadUsuario.fxml")); 
		Parent cadUsuario = TelaCadUsuario.load();
		cadUser = new Scene(cadUsuario);
		stage.setScene(cadUser);
		stage.show();
	}
	
	public static void TelaCadTarefa() throws IOException {
		FXMLLoader TelaCadTarefa = new FXMLLoader();
		TelaCadTarefa.setLocation(Main.class.getResource("/packageView/viewCadTarefa.fxml")); 
		Parent cadTarefas = TelaCadTarefa.load();
		cadTarefa = new Scene(cadTarefas);
		stage.setScene(cadTarefa);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
