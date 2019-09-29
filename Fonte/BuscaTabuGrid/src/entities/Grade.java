package entities;

import java.util.HashSet;
import java.util.Set;

public class Grade {
	
	private Long id;
	private Curso curso;
	private Set<Professor> professores = new HashSet<>();
	private Set<Disciplina> disciplinas = new HashSet<>();

}
