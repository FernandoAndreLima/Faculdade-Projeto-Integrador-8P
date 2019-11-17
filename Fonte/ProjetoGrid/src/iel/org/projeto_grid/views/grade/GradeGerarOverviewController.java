package iel.org.projeto_grid.views.grade;

import java.util.ArrayList;
import java.util.List;

import iel.org.projeto_grid.MainApp;
import iel.org.projeto_grid.controller.Resolvedor;
import iel.org.projeto_grid.model.entities.Curso;
import iel.org.projeto_grid.model.entities.Professor;
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
	private List<Turma> turmasSelecionadas;
	private List<Turma> turmasProntas;
	private List<Curso> cursos;
	private List<Professor> professores;
	
	private Curso cursoEscolhido;
	
	private Turma posUm;
	private Turma posDois;
	private Turma posTres;
	private Turma posQuatro;
	
	private boolean isConfigPos1 = false;
	private boolean isConfigPos2 = false;
	private boolean isConfigPos3 = false;
	private boolean isConfigPos4 = false;

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
	
    @FXML
    private Button btGerarGrade;

	public GradeGerarOverviewController() { }

	@FXML
	public void initialize() {
		createFakeData = new UtilCreteFakeData();
		createFakeData.createData();
		
		turmas = new ArrayList<Turma>(createFakeData.getTurmas());
		turmasProntas = new ArrayList<Turma>();
		cursos = new ArrayList<Curso>(createFakeData.getCursos());
		professores = new ArrayList<Professor>(createFakeData.getProfessores());
		
		
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
		
		btGerarGrade.setDisable(true);
	
	}

	@FXML
	public void holdComboSemestre() {
		turmasSelecionadas = new ArrayList<>();
		for(Turma turma : turmas) {
			if(turma.getSemestre().toString().equals(btEscolhaSemestre.getValue().toString())) {
				turmasSelecionadas.add(turma);
			}
		}
		
		
		for(Turma turma : turmasSelecionadas) {
			
			switch (turma.getPeriodo()) {
			case PRIMEIRO:
				txtPeriodoPos1.setText(turma.getPeriodo().toString());
				posUm = new Turma();
				posUm = turma;
				btnConfPos1.setDisable(false);
				break;
			
			case SEGUNDO:
				txtPeriodoPos1.setText(turma.getPeriodo().toString());
				posUm = new Turma();
				posUm = turma;
				btnConfPos1.setDisable(false);
				break;
			
			case TERCEIRO:
				txtPeriodoPos2.setText(turma.getPeriodo().toString());
				posDois = new Turma();
				posDois = turma;
				btnConfPos2.setDisable(false);
				break;
			
			case QUARTO:
				txtPeriodoPos2.setText(turma.getPeriodo().toString());
				posDois = new Turma();
				posDois = turma;
				btnConfPos2.setDisable(false);
				break;
				
			case QUINTO:
				txtPeriodoPos3.setText(turma.getPeriodo().toString());
				posTres = new Turma();
				posTres = turma;
				btnConfPos3.setDisable(false);
				break;
			
			case SEXTO:
				txtPeriodoPos3.setText(turma.getPeriodo().toString());
				posTres = new Turma();
				posTres = turma;
				btnConfPos3.setDisable(false);
				break;
				
			case SETIMO:
				txtPeriodoPos4.setText(turma.getPeriodo().toString());
				posQuatro = new Turma();
				posQuatro = turma;
				btnConfPos4.setDisable(false);
				break;
				
			case OITAVO:
				txtPeriodoPos4.setText(turma.getPeriodo().toString());
				posQuatro = new Turma();
				posQuatro = turma;
				btnConfPos4.setDisable(false);
				break;
				
			default:
				break;
			}
		} 
		
	}

	@FXML
	private void handleGerarGrade() {
		long tempoInicial = System.currentTimeMillis();
		cursoEscolhido.setTurmas(turmasProntas);
		
		Resolvedor resolvedor = new Resolvedor();
		Curso gradeFinalizada = new Curso();
		gradeFinalizada = resolvedor.controiGradeCurso(cursoEscolhido);
		
		for (Turma turma : gradeFinalizada.getTurmas()) {
			System.out.println(turma.getGrade());
		}
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Tempo em millis: " + (tempoFinal - tempoInicial) );
	}
	
	@FXML
	private void handleConfigurarPos1() {
		Turma finalizada = mainApp.showGerarGradeDialog(posUm);
		if(finalizada.diasConfigurados) {
			finalizada.setProfessores(professores);
			turmasProntas.add(finalizada);
			isConfigPos1 = true;
		}else {
			isConfigPos1 = false;
		}
		verificaSeTodosAsTurmasEstaoConfiguradas();
	}
	


	@FXML
	private void handleConfigurarPos2() {
		Turma finalizada = mainApp.showGerarGradeDialog(posDois);
		if(finalizada.diasConfigurados) {
			turmasProntas.add(finalizada);
			isConfigPos2 = true;
		}else {
			isConfigPos2 = false;
		}
		verificaSeTodosAsTurmasEstaoConfiguradas();
	}
	
	@FXML
	private void handleConfigurarPos3() {
		Turma finalizada =  mainApp.showGerarGradeDialog(posTres);
		if(finalizada.diasConfigurados) {
			turmasProntas.add(finalizada);
			isConfigPos3 = true;
		}else {
			isConfigPos3 = false;
		}
		verificaSeTodosAsTurmasEstaoConfiguradas();
	}
	
	@FXML
	private void handleConfigurarPos4() {
		Turma finalizada = mainApp.showGerarGradeDialog(posQuatro);
		if(finalizada.diasConfigurados) {
			turmasProntas.add(finalizada);
			isConfigPos4 = true;
		}else {
			isConfigPos4 = false;
		}
		verificaSeTodosAsTurmasEstaoConfiguradas();
	}
	
	private void verificaSeTodosAsTurmasEstaoConfiguradas() {
		if(isConfigPos1 && isConfigPos2 && isConfigPos3 && isConfigPos4) {
			btGerarGrade.setDisable(false);
		}else {
			btGerarGrade.setDisable(true);
		}
	}
	
	public void setMainApp(MainApp mainApp) {this.mainApp = mainApp;}

	public ComboBox<String> getBtEscolhaCurso() {return btEscolhaCurso;}

	public void setBtEscolhaCurso(ComboBox<String> btEscolhaCurso) {this.btEscolhaCurso = btEscolhaCurso;}

	public void setBtEscolhaSemestre(ComboBox<SemestreEnum> btEscolhaSemestre) {this.btEscolhaSemestre = btEscolhaSemestre;}

	public Label getLabelCurso() {return labelCurso;}

	public void setLabelCurso(Label labelCurso) {this.labelCurso = labelCurso;}

	public Label getLabelSemestre() {return labelSemestre;}

	public void setLabelSemestre(Label labelSemestre) {this.labelSemestre = labelSemestre;}
}
