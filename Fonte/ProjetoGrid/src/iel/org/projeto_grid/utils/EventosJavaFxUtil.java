package iel.org.projeto_grid.utils;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class EventosJavaFxUtil {

    public static void alertaSenhaPasswordLogin(Text texto, Color cor, String mensagem, TextAlignment alinhamentoTexto) {
    	texto.setFill(cor);
    	texto.setText(mensagem);
    	texto.setTextAlignment(alinhamentoTexto);
    }
	
}
