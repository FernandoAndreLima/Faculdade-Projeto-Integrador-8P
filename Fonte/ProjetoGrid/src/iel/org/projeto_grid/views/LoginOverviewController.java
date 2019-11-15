package iel.org.projeto_grid.views;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import iel.org.projeto_grid.MainApp;
import iel.org.projeto_grid.model.entities.Curso;
import iel.org.projeto_grid.model.entities.Turma;
import iel.org.projeto_grid.model.enums.SemestreEnum;
import iel.org.projeto_grid.utils.UtilCreteFakeData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class LoginOverviewController  implements Initializable{

	private List<Turma> turmas;
	private List<Curso> cursos;
	private String[] nomesCursos = { "BACHARELADO EM SISTEMAS DA INFORMAÇÃO", "ADMINISTRAÇÃO", "DIREITO" };
	private ObservableList<String> options;
	
	@FXML
	private ComboBox<String> btEscolhaCurso;

	@FXML
	private ComboBox<SemestreEnum> btEscolhaSemestre;

	@FXML
	private Label labelCurso;

	@FXML
	private Label labelSemestre;

	private MainApp mainApp;

	private UtilCreteFakeData createFakeData;

	public LoginOverviewController() { }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	
	}
	
	@FXML
	public void holdComboCurso() {
		
	}

	@FXML
	private void initialize() {
		this.createFakeData = new UtilCreteFakeData();
		this.createFakeData.createData();
		this.turmas = new ArrayList<Turma>(this.createFakeData.getTurmas());
		this.cursos = new ArrayList<Curso>(this.createFakeData.getCursos());

		this.options = FXCollections.observableArrayList( "Option 1",
	            "Option 2",
	            "Option 3"
	        );
		
		this.btEscolhaCurso = new ComboBox<>(FXCollections.observableArrayList(options));


	}

	@FXML
	private void handleGerarGrade() {
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

	public ComboBox<String> getBtEscolhaCurso() {
		return btEscolhaCurso;
	}

	public void setBtEscolhaCurso(ComboBox<String> btEscolhaCurso) {
		this.btEscolhaCurso = btEscolhaCurso;
	}

	public ComboBox<SemestreEnum> getBtEscolhaSemestre() {
		return btEscolhaSemestre;
	}

	public void setBtEscolhaSemestre(ComboBox<SemestreEnum> btEscolhaSemestre) {
		this.btEscolhaSemestre = btEscolhaSemestre;
	}

	public Label getLabelCurso() {
		return labelCurso;
	}

	public void setLabelCurso(Label labelCurso) {
		this.labelCurso = labelCurso;
	}

	public Label getLabelSemestre() {
		return labelSemestre;
	}

	public void setLabelSemestre(Label labelSemestre) {
		this.labelSemestre = labelSemestre;
	}
}
