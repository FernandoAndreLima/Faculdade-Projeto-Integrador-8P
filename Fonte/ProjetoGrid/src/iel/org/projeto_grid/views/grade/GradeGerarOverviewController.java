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
	
	private Curso cursoEscolhido;
	private List<Turma> turmasSelecionadas;

	@FXML
    private Text txtPeriodoPos1;

    @FXML
    private Text txtPeriodoPos4;

    @FXML
    private ComboBox<SemestreEnum> btEscolhaSemestre;

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
		btEscolhaSemestre.setDisable(true);
		btEscolhaSemestre.getItems().add(SemestreEnum.primeiro);
		btEscolhaSemestre.getItems().add(SemestreEnum.segundo);
		
		removeDadosFormulario();
	}
	
	@FXML
	public void holdComboCurso() {
		removeDadosFormulario();
		for (Curso curso : cursos) {
			if(btEscolhaCurso.getValue().equals(curso.getNome())) {
				cursoEscolhido = new Curso();
				cursoEscolhido = curso;
				btEscolhaSemestre.setDisable(false);
			}
		}
	}
	
	private void removeDadosFormulario() {
		btEscolhaSemestre.setValue(null);
		btEscolhaSemestre.setDisable(true);
		
		txtPeriodoPos1.setText("");
		txtPeriodoPos2.setText("");
		txtPeriodoPos3.setText("");
		txtPeriodoPos4.setText("");
		
		btnConfPos1.setDisable(true);
		btnConfPos2.setDisable(true);
		btnConfPos3.setDisable(true);
		btnConfPos4.setDisable(true);
	
	}

	@FXML
	public void holdComboSemestre() {
		turmasSelecionadas = new ArrayList<>();
		for(Turma turma : turmas) {
			if(turma.getSemestre().toString().equals(btEscolhaSemestre.getValue().toString())) {
				turmasSelecionadas.add(turma);
				System.out.println(turmasSelecionadas.size());
			}
		}
		
		
		for(Turma turma : turmasSelecionadas) {
			
			switch (turma.getPeriodo()) {
			case PRIMEIRO:
				txtPeriodoPos1.setText(turma.getPeriodo().toString());
				btnConfPos1.setDisable(false);
				break;
			
			case SEGUNDO:
				txtPeriodoPos1.setText(turma.getPeriodo().toString());
				btnConfPos1.setDisable(false);
				break;
			
			case TERCEIRO:
				txtPeriodoPos2.setText(turma.getPeriodo().toString());
				btnConfPos2.setDisable(false);
				break;
			
			case QUARTO:
				txtPeriodoPos2.setText(turma.getPeriodo().toString());
				btnConfPos2.setDisable(false);
				break;
				
			case QUINTO:
				txtPeriodoPos3.setText(turma.getPeriodo().toString());
				btnConfPos3.setDisable(false);
				break;
			
			case SEXTO:
				txtPeriodoPos3.setText(turma.getPeriodo().toString());
				btnConfPos3.setDisable(false);
				break;
				
			case SETIMO:
				txtPeriodoPos4.setText(turma.getPeriodo().toString());
				btnConfPos4.setDisable(false);
				break;
				
			case OITAVO:
				txtPeriodoPos4.setText(turma.getPeriodo().toString());
				btnConfPos4.setDisable(false);
				break;
				
			default:
				break;
			}
		} 
		
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
