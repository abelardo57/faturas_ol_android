package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Fatura_Cliente {

    private int id_fatura;
    private int numero_cartao_cliente;

    public Fatura_Cliente(int id_fatura, int numero_cartao_cliente) {
        this.id_fatura = id_fatura;
        this.numero_cartao_cliente = numero_cartao_cliente;
    }

    public int getId_fatura() {
        return id_fatura;
    }

    public void setId_fatura(int id_fatura) {
        this.id_fatura = id_fatura;
    }

    public int getNumero_cartao_cliente() {
        return numero_cartao_cliente;
    }

    public void setNumero_cartao_cliente(int numero_cartao_cliente) {
        this.numero_cartao_cliente = numero_cartao_cliente;
    }

    @Override
    public String toString() {
        return "Fatura_Cliente{" +
                "id_fatura=" + id_fatura +
                ", numero_cartao_cliente=" + numero_cartao_cliente +
                '}';
    }


}
