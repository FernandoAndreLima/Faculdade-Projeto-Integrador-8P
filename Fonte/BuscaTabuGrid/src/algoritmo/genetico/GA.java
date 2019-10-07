package algoritmo.genetico;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class GA {
    private List<CromossomoMochila> populacao;    
    private double pesos[];
    private double[] valores;
    double limitePeso=0;


    

    private GA() {
        populacao=new ArrayList<CromossomoMochila>();
    }

    public GA(double pesos[], double valores[], double limitePeso) {
        this();
        this.pesos=new double[pesos.length];
        this.valores=new double[valores.length];
        for(int i=0; i<pesos.length; i++) {
            this.pesos[i]=pesos[i];
            this.valores[i]=valores[i];
        }
        this.limitePeso=limitePeso;
    }

    public void inicializaPopulacao(int tamanhoPopulacao) {
        this.populacao.clear();
        for(int i=0;i<tamanhoPopulacao;i++) {
            this.populacao.add(new CromossomoMochila(pesos, valores, limitePeso));
        }
    }

    private double somaAvaliacoes() {
        double retorno=0;
        Iterator<CromossomoMochila> it=this.populacao.iterator();
        while(it.hasNext()) {
            CromossomoMochila prox=it.next();            
            retorno+=prox.avaliacao();
        }        
        return(retorno);
    }

    private int selecionaPai(double somaAvaliacoes) {
        int retorno=-1;
        double valorSorteado=Math.random()*somaAvaliacoes;        
        double soma=0;
        Iterator<CromossomoMochila> it=this.populacao.iterator();
        do {
            soma+=it.next().avaliacao();
            retorno++;
        } while ((it.hasNext())&&(soma<valorSorteado));        
        return(retorno);
        
    }

    public void run(double taxaMutacao, int numGeracoes, int tamanhoPopulacao) {
        CromossomoMochila melhor;
        List<CromossomoMochila> novaPopulacao=new ArrayList<CromossomoMochila>();
        inicializaPopulacao(tamanhoPopulacao);        
        for(int geracaoCorrente=0;geracaoCorrente<numGeracoes;geracaoCorrente++) {
            double somaAvaliacoes=this.somaAvaliacoes();
            novaPopulacao.clear();
            for(int individuosGerados=0;individuosGerados<tamanhoPopulacao;individuosGerados+=2) {
                int pai1=this.selecionaPai(somaAvaliacoes);
                int pai2=this.selecionaPai(somaAvaliacoes);
                CromossomoMochila[] filhos=populacao.get(pai1).crossover(populacao.get(pai2));
                novaPopulacao.add(filhos[0].mutacao());
                novaPopulacao.add(filhos[1].mutacao());
            }
            //novaPopulacao.add(populacao.get(populacao.size()-1));
            populacao.clear();
            populacao.addAll(novaPopulacao);
            Collections.sort(populacao);
            melhor=populacao.get(populacao.size()-1);
            System.out.println("Melhor da geracao #"+geracaoCorrente+" = "+melhor+" com avaliação "+melhor.avaliacao());
        }
    }

}
