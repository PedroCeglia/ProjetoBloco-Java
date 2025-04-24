public class Bicicleta {
    String id, tipo, tamanho, marca, modelo, taxaDiaria, deposito, status;

    Bicicleta(String id, String tipo, String tamanho, String marca, String modelo,
              String taxaDiaria, String deposito, String status) {
        this.id = id;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.marca = marca;
        this.modelo = modelo;
        this.taxaDiaria = taxaDiaria;
        this.deposito = deposito;
        this.status = status;
    }

    String toCsvLine() {
        return id + "," + tipo + "," + tamanho + "," + marca + "," + modelo + "," +
                taxaDiaria + "," + deposito + "," + status;
    }
}
