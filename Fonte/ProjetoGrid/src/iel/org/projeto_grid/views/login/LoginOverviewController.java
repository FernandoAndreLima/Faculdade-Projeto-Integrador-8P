package iel.org.projeto_grid.views.login;

import java.net.URL;
import java.util.ResourceBundle;

import iel.org.projeto_grid.MainApp;
import iel.org.projeto_grid.utils.EventosJavaFxUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LoginOverviewController  implements Initializable{

	@SuppressWarnings("unused")
	private MainApp mainApp;
	
    @FXML
    private PasswordField txtFieldSenha;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private Button btnLogar;
    
    @FXML
    private Text lbActionTarget;


	public LoginOverviewController() { }

	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void efetuaLogin() {
		btnLogar.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override
		    public void handle(ActionEvent e) {
		    	EventosJavaFxUtil.alertaSenhaPasswordLogin(lbActionTarget, Color.FIREBRICK, "E-mail ou senha incorreto!",TextAlignment.CENTER);
		    }
		});
	}

	public PasswordField getTxtFieldSenha() {
		return txtFieldSenha;
	}

	public void setTxtFieldSenha(PasswordField txtFieldSenha) {
		this.txtFieldSenha = txtFieldSenha;
	}

	public TextField getTxtFieldEmail() {
		return txtFieldEmail;
	}

	public void setTxtFieldEmail(TextField txtFieldEmail) {
		this.txtFieldEmail = txtFieldEmail;
	}

	public Button getBtnLogar() {
		return btnLogar;
	}

	public void setBtnLogar(Button btnLogar) {
		this.btnLogar = btnLogar;
	}
	
}
