package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application{
	private int contador = 0;
	
	private void atualizarLabelNumero(Label labelNumero) {
		
		labelNumero.getStyleClass().remove("success");
		labelNumero.getStyleClass().remove("failed");
		
		if(contador > 0) {
			labelNumero.getStyleClass().add("success");
		}else if(contador < 0){
			labelNumero.getStyleClass().add("failed");
		}
		
		labelNumero.setText(Integer.toString(contador));
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("titulo");
		Label labelNumero = new Label("0");
		labelNumero.getStyleClass().add("numero");
		
		Button buttonPlus = new Button("+");
		buttonPlus.setOnAction(e -> {
			contador++;
			atualizarLabelNumero(labelNumero);
		});
		buttonPlus.getStyleClass().add("button");
		Button buttonMinus = new Button("-");
		buttonMinus.getStyleClass().add("button");
		buttonMinus.setOnAction(e -> {
			contador--;
			atualizarLabelNumero(labelNumero);
		});
		
		Button zerar = new Button("Zerar");
		zerar.getStyleClass().add("button");
		zerar.setOnAction(e -> {
			contador = 0;
			atualizarLabelNumero(labelNumero);
		});
		
		HBox boxAux = new HBox();
		boxAux.setSpacing(10);
		boxAux.setAlignment(Pos.CENTER);
		boxAux.getChildren().add(buttonMinus);
		boxAux.getChildren().add(zerar);
		boxAux.getChildren().add(buttonPlus);
		
		
		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxConteudo.setSpacing(10);
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNumero);
		boxConteudo.getChildren().add(boxAux);
		
		String pathCSS = getClass()
				.getResource("/basico/Contador.css")
				.toExternalForm();
		Scene scene = new Scene(boxConteudo, 400, 400);
		scene.getStylesheets().add(pathCSS);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
