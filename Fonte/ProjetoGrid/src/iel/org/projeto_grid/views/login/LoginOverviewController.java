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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LoginOverviewController implements Initializable {

	@SuppressWarnings("unused")
	private MainApp mainApp;

	@FXML
	private PasswordField txtFieldSenha;

	@FXML
	private TextField txtFieldLogin;

	@FXML
	private Button btnLogar;

	@FXML
	private Text lbActionTarget;

	public LoginOverviewController() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	public void efetuaLogin() {
		btnLogar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				if ((txtFieldLogin.getText().equals("admin")) && (txtFieldSenha.getText().equals("admin"))) {
					EventosJavaFxUtil.alertaSenhaPasswordLogin(
							lbActionTarget, 
							Color.GREEN, 
							"Login efetuado com sucesso",
							TextAlignment.CENTER);
					

				} else {
					EventosJavaFxUtil.alerta(AlertType.WARNING, "Erro login", "Erro login", "Login ou senha incorreto!");
					EventosJavaFxUtil.alertaSenhaPasswordLogin(
							lbActionTarget, 
							Color.FIREBRICK,
							"Login ou senha incorreto!",
							TextAlignment.CENTER);
					txtFieldLogin.setText("");
					txtFieldSenha.setText("");
				}
			}
		});
	}

	public PasswordField getTxtFieldSenha() {
		return txtFieldSenha;
	}

	public void setTxtFieldSenha(PasswordField txtFieldSenha) {
		this.txtFieldSenha = txtFieldSenha;
	}

	public TextField getTxtFieldLogin() {
		return txtFieldLogin;
	}

	public void setTxtFieldLogin(TextField txtFieldEmail) {
		this.txtFieldLogin = txtFieldEmail;
	}

	public Button getBtnLogar() {
		return btnLogar;
	}

	public void setBtnLogar(Button btnLogar) {
		this.btnLogar = btnLogar;
	}

}
