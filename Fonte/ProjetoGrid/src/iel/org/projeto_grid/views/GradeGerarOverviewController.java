package iel.org.projeto_grid.views;

import java.util.ArrayList;
import java.util.List;

import org.jboss.jandex.Main;

import iel.org.projeto_grid.MainApp;
import iel.org.projeto_grid.model.entities.Curso;
import iel.org.projeto_grid.model.entities.Turma;
import iel.org.projeto_grid.model.enums.SemestreEnum;
import iel.org.projeto_grid.utils.UtilCreteFakeData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class GradeGerarOverviewController {
	
	private List<Turma> turmas;

	@FXML
	private ChoiceBox<Curso> btEscolhaCurso;
	
	@FXML
	private ChoiceBox<SemestreEnum> btEscolhaSemestre;
	
	@FXML
	private Label labelCurso;
	
	@FXML
	private Label labelSemestre;

	
	private MainApp mainApp;
	
	private UtilCreteFakeData createFakeData;
	
	public GradeGerarOverviewController() {}
	
	@FXML
	private void initialize() {
		this.createFakeData = new UtilCreteFakeData();
		this.createFakeData.createData();
		this.turmas = new ArrayList<Turma>(this.createFakeData.getTurmas());
	}
	
	@FXML
	private void handleGerarGrade() {}
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
	
	public ChoiceBox<Curso> getBtEscolhaCurso() {
		return btEscolhaCurso;
	}

	public void setBtEscolhaCurso(ChoiceBox<Curso> btEscolhaCurso) {
		this.btEscolhaCurso = btEscolhaCurso;
	}

	public ChoiceBox<SemestreEnum> getBtEscolhaSemestre() {
		return btEscolhaSemestre;
	}

	public void setBtEscolhaSemestre(ChoiceBox<SemestreEnum> btEscolhaSemestre) {
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
