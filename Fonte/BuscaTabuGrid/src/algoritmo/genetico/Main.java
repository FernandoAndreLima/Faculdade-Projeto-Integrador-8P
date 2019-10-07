package algoritmo.genetico;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double pesos[]={10,20,30,20,10,90, 70, 100, 50, 10, 20, 70, 900, 5};
        double valores[]={5,30,20,20,10, 120, 60, 10, 5, 2, 4, 60, 94, 12, 52};
        GA meuGA=new GA(pesos, valores, 100);
        meuGA.run(0.01, 150000, 1500000);
        /*
        CromossomoMochila crom1=new CromossomoMochila(pesos,valores, 100);
        CromossomoMochila crom2=new CromossomoMochila(pesos,valores, 100);
        crom1.setCromossomo(new StringBuffer("11000"));
        System.out.println("avaliacao (esperado=35): "+crom1.avaliacao());
        crom1.setCromossomo(new StringBuffer("11111"));
        System.out.println("avaliacao (esperado=115): "+crom1.avaliacao());
        crom2.setCromossomo(new StringBuffer("00000"));
        System.out.println("avaliacao (esperado=0): "+crom2.avaliacao());
        CromossomoMochila[] filhos=crom1.crossover(crom2);
        System.out.println("Filhos da reprodução");
        System.out.println(filhos[0]);
        System.out.println(filhos[1]);
        System.out.println("Filhos da mutação");
        System.out.println(crom1.mutacao());
        System.out.println(crom1.mutacao());
        System.out.println(crom1.mutacao());
        System.out.println(crom1.mutacao());*/
    }

}
