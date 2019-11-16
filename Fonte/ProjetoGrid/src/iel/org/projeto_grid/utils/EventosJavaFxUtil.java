package iel.org.projeto_grid.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class EventosJavaFxUtil {

    public static void alertaSenhaPasswordLogin(Text texto, Color cor, String mensagem, TextAlignment alinhamentoTexto) {
    	texto.setFill(cor);
    	texto.setText(mensagem);
    	texto.setTextAlignment(alinhamentoTexto);
    }
	
    public static void alerta(AlertType tipoAlerta, String titulo, String textoCabecalho, String conteudo) {
		Alert alert =  new Alert(tipoAlerta);
		alert.setTitle(titulo);
		alert.setHeaderText(textoCabecalho);
		alert.setContentText(conteudo);
		alert.showAndWait();
    }
}
