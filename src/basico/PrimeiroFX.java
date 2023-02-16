package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimeiroFX extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button buttonA = new Button("A");
		Button buttonB = new Button("B");
		Button buttonC = new Button("Sair do Programa");
		
		buttonA.setOnAction(e -> System.out.println("A"));
		buttonB.setOnAction(e -> System.out.println("B"));
		buttonC.setOnAction(e -> System.exit(0));
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		box.getChildren().add(buttonA);
		box.getChildren().add(buttonB);
		box.getChildren().add(buttonC);
		
		Scene cena = new Scene(box, 200, 400);
		
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
