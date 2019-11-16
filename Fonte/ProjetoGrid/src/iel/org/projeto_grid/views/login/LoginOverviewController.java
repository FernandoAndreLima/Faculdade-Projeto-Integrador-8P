package iel.org.projeto_grid.views.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import iel.org.projeto_grid.MainApp;
import iel.org.projeto_grid.utils.EventosJavaFxUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class LoginOverviewController implements Initializable {

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
	void goTo(ActionEvent event) {
		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("views/GradeGerarOverview.fxml"));
		} catch (IOException ex) {
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void efetuaLogin() {	
		if ((txtFieldLogin.getText().equals("admin")) && (txtFieldSenha.getText().equals("admin"))) {
			EventosJavaFxUtil.alertaSenhaPasswordLogin(lbActionTarget, Color.GREEN,
					"Login efetuado com sucesso", TextAlignment.CENTER);
			mainApp.showGradeGerarOverview();
		} else {
			EventosJavaFxUtil.alerta(AlertType.WARNING, "Erro login", "Erro login",
					"Login ou senha incorreto!");
			EventosJavaFxUtil.alertaSenhaPasswordLogin(lbActionTarget, Color.FIREBRICK,
					"Login ou senha incorreto!", TextAlignment.CENTER);
			txtFieldLogin.setText("");
			txtFieldSenha.setText("");
		}
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
