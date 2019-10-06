package algoritmo.busca_tabu;

import java.util.HashSet;
import java.util.Set;

public class ElementoListaTabu {

	private Set<Integer> listaTabu = new HashSet<Integer>();
	
	public void addAllListaTabu(Set<Integer> listaTabu) {
		this.listaTabu.addAll(listaTabu);
	}
	
	public void addItem(Integer elemento) {
		this.listaTabu.add(elemento);
	}
	
	public void removeItem(Integer elemento) {
		this.listaTabu.remove(elemento);
	}
	
	public void zeraLista() {
		this.listaTabu.removeAll(listaTabu);
		this.listaTabu = new HashSet<Integer>();
	}
	
}
