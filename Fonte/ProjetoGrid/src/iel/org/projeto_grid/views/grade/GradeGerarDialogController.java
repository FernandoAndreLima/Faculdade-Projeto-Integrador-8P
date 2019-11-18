package iel.org.projeto_grid.views.grade;

import iel.org.projeto_grid.model.entities.Aula;
import iel.org.projeto_grid.model.entities.Disciplina;
import iel.org.projeto_grid.model.entities.GradeHoraria;
import iel.org.projeto_grid.model.entities.Turma;
import iel.org.projeto_grid.model.enums.DiasEnum;
import iel.org.projeto_grid.utils.ConstantesUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class GradeGerarDialogController {
	
    private Stage dialogStage;
    private Turma turma;
    private boolean okClicked = false;
    
	private ObservableList<String> disciplinasDisponiveis = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> combSegunda;
    
    @FXML
    private ComboBox<String> combTerca;
    
    @FXML
    private ComboBox<String> combQuarta;

    @FXML
    private ComboBox<String> combQuinta;

    @FXML
    private ComboBox<String> combSexta;
    
    @FXML
    private Button btConfirma;
    
    @FXML
    private Button btCancela;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
    	btConfirma.setDisable(true);
    }
    
	public void setTurma(Turma turmaRecebida) {
		this.turma = turmaRecebida;
		
		for(Disciplina disciplina : turma.getDisciplinas()) {
			getDisciplinasDisponiveis().add(disciplina.getNome());
		}
		
		getDisciplinasDisponiveis().add(ConstantesUtil.ESTUDO_AUTO_DIRIGIDO);
				
		combSegunda.getItems().addAll(disciplinasDisponiveis);
		combTerca.getItems().addAll(disciplinasDisponiveis);
		combQuarta.getItems().addAll(disciplinasDisponiveis);
		combQuinta.getItems().addAll(disciplinasDisponiveis);
		combSexta.getItems().addAll(disciplinasDisponiveis);
	}

    @FXML
	public void verificaSeTodosEstaoPreenchidos() {
    	try {
    		if((!combSegunda.getValue().isEmpty())&&(!combTerca.getValue().isEmpty())&&(!combQuarta.getValue().isEmpty())&&(!combQuinta.getValue().isEmpty())&&(!combSexta.getValue().isEmpty())) {
    			btConfirma.setDisable(false);
    		}else {
    			btConfirma.setDisable(true);
    		}
		} catch (NullPointerException np) {}

	}
	
    /**
     * Define o palco deste dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    /**
     * Retorna true se o usuário clicar OK,caso contrário false.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Chamado quando o usuário clica OK.
     */
    @FXML
    private void handleOk() {
    	
    	GradeHoraria gradeHoraria = new GradeHoraria();
    	gradeHoraria.setAulaSegunda(new Aula(buscaDisciplinaSelecionada(combSegunda.getValue()), DiasEnum.SEGUNDA_FEIRA));
    	gradeHoraria.setAulaTerca(new Aula(buscaDisciplinaSelecionada(combTerca.getValue()), DiasEnum.TERCA_FEIRA));
    	gradeHoraria.setAulaQuarta(new Aula(buscaDisciplinaSelecionada(combQuarta.getValue()), DiasEnum.QUARTA_FEIRA));
    	gradeHoraria.setAulaQuinta(new Aula(buscaDisciplinaSelecionada(combQuinta.getValue()), DiasEnum.QUINTA_FEIRA));
    	gradeHoraria.setAulaSexta(new Aula(buscaDisciplinaSelecionada(combSexta.getValue()), DiasEnum.SEXTA_FEIRA));
    	
    	turma.setGrade(gradeHoraria);
    	turma.diasConfigurados = true;
    	
    	okClicked = true;
        dialogStage.close();
    }
    
    private Disciplina buscaDisciplinaSelecionada(String nomeDisciplina) {
    	
    	Disciplina disciplinaSelecionada = new Disciplina();
    	    	
    	for (Disciplina disciplina : turma.getDisciplinas()) {
			if(nomeDisciplina.equals(disciplina.getNome())){
				disciplinaSelecionada = disciplina;
			}
		}
    	
    	if(nomeDisciplina.equals(ConstantesUtil.ESTUDO_AUTO_DIRIGIDO)) {
    		disciplinaSelecionada.setNome(nomeDisciplina);
    		disciplinaSelecionada.setCargaHoraria("80");
    		disciplinaSelecionada.setDescricao("");
    		disciplinaSelecionada.setEstudoAutoDirigido(true);
    	}
    	
		return disciplinaSelecionada;
	}

	/**
     * Chamado quando o usuário clica Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }    
    
	public ObservableList<String> getDisciplinasDisponiveis() {
		return disciplinasDisponiveis;
	}

	public Turma getTurma() {
		return turma;
	}
}
