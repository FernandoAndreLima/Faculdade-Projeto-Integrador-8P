package iel.org.projeto_grid.views;

import java.util.ArrayList;
import java.util.List;

import iel.org.projeto_grid.MainApp;
import iel.org.projeto_grid.model.entities.Curso;
import iel.org.projeto_grid.model.entities.Turma;
import iel.org.projeto_grid.model.enums.SemestreEnum;
import iel.org.projeto_grid.utils.UtilCreteFakeData;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class GradeGerarOverviewController {
	
	private List<Turma> turmas;
	private List<Curso> cursos;

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
	
	public GradeGerarOverviewController() {}
	
	@FXML
	private void initialize() {
		this.createFakeData = new UtilCreteFakeData();
		this.createFakeData.createData();
		this.turmas = new ArrayList<Turma>(this.createFakeData.getTurmas());
		this.cursos = new ArrayList<Curso>(this.createFakeData.getCursos());
		String[] nomesCursos =  { "BACHARELADO EM SISTEMAS DA INFORMAÇÃO","ADMINISTRAÇÃO", "DIREITO" };
		this.btEscolhaCurso = new ComboBox<>(FXCollections.observableArrayList(nomesCursos));
		
        EventHandler<ActionEvent> event = 
                new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          { 
              System.out.println(btEscolhaCurso.getValue() + " selected"); 
          } 
      }; 
      
      this.btEscolhaCurso.setOnAction(event);
		
	}
	
	
	
	@FXML
	private void handleGerarGrade() {}
	
	
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
