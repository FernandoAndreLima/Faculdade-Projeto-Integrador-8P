package iel.org.projeto_grid.views.grade;

import java.util.ArrayList;
import java.util.List;

import iel.org.projeto_grid.MainApp;
import iel.org.projeto_grid.model.entities.Curso;
import iel.org.projeto_grid.model.entities.Turma;
import iel.org.projeto_grid.model.enums.SemestreEnum;
import iel.org.projeto_grid.utils.UtilCreteFakeData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class GradeGerarOverviewController{

	private MainApp mainApp;
	private UtilCreteFakeData createFakeData;
	private List<Turma> turmas;
	private List<Curso> cursos;

	@FXML
    private Text txtPeriodoPos1;

    @FXML
    private Text txtPeriodoPos4;

    @FXML
    private ComboBox<?> btEscolhaSemestre;

    @FXML
    private Text txtPeriodoPos2;

    @FXML
    private Button btnConfPos4;

    @FXML
    private Text txtPeriodoPos3;

    @FXML
    private ComboBox<String> btEscolhaCurso;

    @FXML
    private Button btnConfPos2;

    @FXML
    private Button btnConfPos3;

    @FXML
    private Button btnConfPos1;
	
	@FXML
	private Label labelCurso;

	@FXML
	private Label labelSemestre;

	public GradeGerarOverviewController() { }

	@FXML
	public void initialize() {
		createFakeData = new UtilCreteFakeData();
		createFakeData.createData();
		
		turmas = new ArrayList<Turma>(createFakeData.getTurmas());
		cursos = new ArrayList<Curso>(createFakeData.getCursos());
		
		for (Curso curso : cursos) {
			btEscolhaCurso.getItems().add(curso.getNome());
		}
	}
	
	@FXML
	public void holdComboCurso() {
		
	}

	@FXML
	private void handleGerarGrade() {}

	public void setMainApp(MainApp mainApp) {this.mainApp = mainApp;}

	public ComboBox<String> getBtEscolhaCurso() {return btEscolhaCurso;}

	public void setBtEscolhaCurso(ComboBox<String> btEscolhaCurso) {this.btEscolhaCurso = btEscolhaCurso;}

	public void setBtEscolhaSemestre(ComboBox<SemestreEnum> btEscolhaSemestre) {this.btEscolhaSemestre = btEscolhaSemestre;}

	public Label getLabelCurso() {return labelCurso;}

	public void setLabelCurso(Label labelCurso) {this.labelCurso = labelCurso;}

	public Label getLabelSemestre() {return labelSemestre;}

	public void setLabelSemestre(Label labelSemestre) {this.labelSemestre = labelSemestre;}
}
