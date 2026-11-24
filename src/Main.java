interface Combustivel {
    void abastecer();
}


abstract class Movimento {

    public void arrancar() {
        System.out.println("O veículo arrancou.");
    }

    public void travar() {
        System.out.println("O veículo está a travar.");
    }


    public abstract void buzinar();
}


class Transporte extends Movimento {

    private String fabricante;
    private String nome;
    private int anoFabrico;
    private int lotacao;

    public Transporte(String fabricante, String nome, int anoFabrico, int lotacao) {
        this.fabricante = fabricante;
        this.nome = nome;
        this.anoFabrico = anoFabrico;
        this.lotacao = lotacao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoFabrico() {
        return anoFabrico;
    }

    public int getLotacao() {
        return lotacao;
    }

    @Override
    public void buzinar() {
        System.out.println("O veículo faz um som de buzina genérico.");
    }
}


class Camiao extends Transporte implements Combustivel {

    private double cargaMaxima;
    private int numeroEixos;

    public Camiao(String fabricante, String nome, int anoFabrico, int lotacao,
                  double cargaMaxima, int numeroEixos) {

        super(fabricante, nome, anoFabrico, lotacao);

        this.cargaMaxima = cargaMaxima;
        this.numeroEixos = numeroEixos;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public int getNumeroEixos() {
        return numeroEixos;
    }

    @Override
    public void buzinar() {
        System.out.println("O camião buzina: BUUUUUM!");
    }

    @Override
    public void abastecer() {
        System.out.println("O camião está a abastecer gasóleo.");
    }
}


class Bicicleta extends Transporte {

    private int numeroVelocidades;
    private boolean eletrica;

    public Bicicleta(String fabricante, String nome, int anoFabrico,
                     int numeroVelocidades, boolean eletrica) {

        super(fabricante, nome, anoFabrico, 1);

        this.numeroVelocidades = numeroVelocidades;
        this.eletrica = eletrica;
    }

    public int getNumeroVelocidades() {
        return numeroVelocidades;
    }

    public boolean isEletrica() {
        return eletrica;
    }

    @Override
    public void buzinar() {
        System.out.println("A bicicleta toca a campainha: trim trim!");
    }
}


public class Main {

    public static void main(String[] args) {

        Transporte generico = new Transporte("Genérico", "Modelo Base", 2020, 4);
        Camiao camiao = new Camiao("Volvo", "FH16", 2024, 2, 25000.0, 3);
        Bicicleta bicicleta = new Bicicleta("Orbea", "Gain", 2023, 21, true);

        generico.buzinar();
        camiao.buzinar();
        bicicleta.buzinar();

        System.out.println();

        camiao.arrancar();
        camiao.abastecer();
        bicicleta.travar();

        System.out.println();

        System.out.println("Fabricante do camião: " + camiao.getFabricante());
        System.out.println("Nome do camião: " + camiao.getNome());
        System.out.println("Ano de fabrico: " + camiao.getAnoFabrico());
        System.out.println("Lotação: " + camiao.getLotacao());
        System.out.println("Carga máxima: " + camiao.getCargaMaxima() + " kg");
        System.out.println("Número de eixos: " + camiao.getNumeroEixos());

        System.out.println();

        System.out.println("Fabricante da bicicleta: " + bicicleta.getFabricante());
        System.out.println("Nome da bicicleta: " + bicicleta.getNome());
        System.out.println("Ano de fabrico: " + bicicleta.getAnoFabrico());
        System.out.println("Velocidades: " + bicicleta.getNumeroVelocidades());
        System.out.println("Elétrica: " + (bicicleta.isEletrica() ? "Sim" : "Não"));
    }
}