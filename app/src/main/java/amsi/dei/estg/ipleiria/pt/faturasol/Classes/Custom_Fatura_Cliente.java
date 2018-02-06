package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Custom_Fatura_Cliente {

    private long id;
    private int id_custom_faturas;
    private int numero_cartao_cliente;


    public Custom_Fatura_Cliente(long id,int id_custom_faturas, int numero_cartao_cliente) {
        this.id = id;
        this.id_custom_faturas = id_custom_faturas;
        this.numero_cartao_cliente = numero_cartao_cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_custom_faturas() {
        return id_custom_faturas;
    }

    public void setId_custom_faturas(int id_custom_faturas) {
        this.id_custom_faturas = id_custom_faturas;
    }

    public int getNumero_cartao_cliente() {
        return numero_cartao_cliente;
    }

    public void setNumero_cartao_cliente(int numero_cartao_cliente) {
        this.numero_cartao_cliente = numero_cartao_cliente;
    }

    @Override
    public String toString() {
        return "Custom_Fatura_Cliente{" +
                "id=" + id +
                " ,id_custom_faturas=" + id_custom_faturas +
                " ,numero_cartao_cliente=" + numero_cartao_cliente +
                '}';
    }


}

