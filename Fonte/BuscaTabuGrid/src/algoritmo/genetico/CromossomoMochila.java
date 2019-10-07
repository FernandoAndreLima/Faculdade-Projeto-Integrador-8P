package algoritmo.genetico;

import java.lang.reflect.Array;

public class CromossomoMochila implements Comparable<CromossomoMochila> {
    private StringBuffer cromossomo;
    private double taxaMutacao;
    private double pesos[];
    private double[] valores;
    private double limitePeso=0;

    public CromossomoMochila() {
        cromossomo=new StringBuffer("");
        taxaMutacao=0.05;
    }

    

    public CromossomoMochila(double pesos[], double valores[], double limitePeso) {
        this();
        this.pesos=new double[pesos.length];
        this.valores=new double[valores.length];
        for(int i=0; i<pesos.length; i++) {
            this.pesos[i]=pesos[i];
            this.valores[i]=valores[i];
        }
        this.limitePeso=limitePeso;
        for(int i=1;i<=pesos.length;i++) {
            if (Math.random()<0.5) {
                cromossomo.append("0");
            } else {
                cromossomo.append("1");
            }
        }
    }

    public CromossomoMochila[] crossover (CromossomoMochila outro) {
        Class c=this.getClass();
        CromossomoMochila[] filhos=null;
        filhos = (CromossomoMochila[]) Array.newInstance(c,2);
        try {
            filhos[0] = (CromossomoMochila) c.newInstance();
            filhos[1] = (CromossomoMochila) c.newInstance();
            filhos[0].setPesos(pesos);
            filhos[0].setValores(valores);
            filhos[0].setTaxaMutacao(taxaMutacao);
            filhos[0].setLimitePeso(limitePeso);
            filhos[1].setPesos(pesos);
            filhos[1].setValores(valores);
            filhos[1].setTaxaMutacao(taxaMutacao);
            filhos[1].setLimitePeso(limitePeso);
            int posicaoCorte=(int) Math.round(Math.random()*this.cromossomo.length())-1;
            String stringFilho1=outro.getCromossomo().substring(0, posicaoCorte+1)+this.getCromossomo().substring(posicaoCorte+1);
            String stringFilho2=this.getCromossomo().substring(0, posicaoCorte+1)+outro.getCromossomo().substring(posicaoCorte+1);
            filhos[0].setCromossomo(new StringBuffer(stringFilho1));
            filhos[1].setCromossomo(new StringBuffer(stringFilho2));
        } catch (Exception ex) {
            System.out.println("Exceção: "+ex.getMessage());
            filhos=null;
        }
        return(filhos);
    }

     public CromossomoMochila mutacao () {
        Class c=this.getClass();
        CromossomoMochila filho=null;
        try {
            filho = (CromossomoMochila) c.newInstance();
            StringBuffer resultado=new StringBuffer();
            for (int i=0;i<this.cromossomo.length();i++) {
                if (Math.random()<this.taxaMutacao) {                    
                    if (this.cromossomo.charAt(i)=='1') {
                        resultado.append('0');
                    } else {
                        resultado.append('1');
                    }
                } else {
                    resultado.append(this.cromossomo.charAt(i));
                }
            }
            filho.setCromossomo(new StringBuffer(resultado));
            filho.setPesos(pesos);
            filho.setValores(valores);
            filho.setTaxaMutacao(taxaMutacao);
            filho.setLimitePeso(limitePeso);

        } catch (Exception ex) {
            filho=null;
        }
        return(filho);
    }

   public double avaliacao() {
        double retorno=0;
        double somaPesos=0;
        String crom=this.getCromossomo().toString();
        for(int i=0;i<crom.length();i++) {
            if (crom.charAt(i)=='1') {
                retorno+=getValores()[i];
                somaPesos+=getPesos()[i];
            }
        }
        if (somaPesos>this.getLimitePeso()) {
            retorno=1;
        }
        return(retorno);
    }

   public StringBuffer getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(StringBuffer cromossomo) {
        this.cromossomo = cromossomo;
    }

    public String toString() {
        return(this.cromossomo.toString());
    }

    /**
     * @return the taxaMutacao
     */
    public double getTaxaMutacao() {
        return taxaMutacao;
    }

    /**
     * @param taxaMutacao the taxaMutacao to set
     */
    public void setTaxaMutacao(double taxaMutacao) {
        this.taxaMutacao = taxaMutacao;
    }

    public double[] getPesos() {
        return pesos;
    }

    /**
     * @param pesos the pesos to set
     */
    public void setPesos(double[] pesos) {
        this.pesos = pesos;
    }

    /**
     * @return the valores
     */
    public double[] getValores() {
        return valores;
    }

   public void setValores(double[] valores) {
        this.valores = valores;
    }

    @Override
   public boolean equals(Object outro) {
       if (!this.getClass().equals(outro.getClass())) {
           return false;
       }
       return(this.getCromossomo().equals((CromossomoMochila)outro));
   }

   public int compareTo(CromossomoMochila outro)  {
       return((new Double(this.avaliacao())).compareTo(outro.avaliacao()));
   }

    /**
     * @return the limitePeso
     */
    public double getLimitePeso() {
        return limitePeso;
    }

    /**
     * @param limitePeso the limitePeso to set
     */
    public void setLimitePeso(double limitePeso) {
        this.limitePeso = limitePeso;
    }
    
}
