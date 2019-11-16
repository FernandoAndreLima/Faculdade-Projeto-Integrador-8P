package iel.org.projeto_grid.views.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogoffDialogController implements Initializable {


    private Stage dialogStage;
	private boolean okClicked = false;
    
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirma;

	
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {}    
    
    /**
     * Define o palco deste dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
            
    /**
     * Chamado quando o usuário clica OK.
     */
    @FXML
    private void handleOk() {
    	okClicked = true;
        dialogStage.close();
    }
    
    /**
     * Chamado quando o usuário clica Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

	public boolean isOkClicked() {
		return okClicked;
	}
}
