package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Linha_Fatura {


    private long id;
    private float valor_unitario;
    private String nome_produto;
    private String descricao;
    private int id_fatura;
    private int id_custom_fatura;
    private float valor_total;

    public Linha_Fatura(long id, float valor_unitario, String nome_produto, String descricao, int id_fatura, int id_custom_fatura, float valor_total) {
        this.id = id;
        this.valor_unitario = valor_unitario;
        this.nome_produto = nome_produto;
        this.descricao = descricao;
        this.id_fatura = id_fatura;
        this.id_custom_fatura = id_custom_fatura;
        this.valor_total = valor_total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_fatura() {
        return id_fatura;
    }

    public void setId_fatura(int id_fatura) {
        this.id_fatura = id_fatura;
    }

    public int getId_custom_fatura() {
        return id_custom_fatura;
    }

    public void setId_custom_fatura(int id_custom_fatura) {
        this.id_custom_fatura = id_custom_fatura;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    @Override
    public String toString() {
        return "Linha_Fatura{" +
                "id=" + id +
                ", valor_unitario=" + valor_unitario +
                ", nome_produto='" + nome_produto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", id_fatura=" + id_fatura +
                ", id_custom_fatura=" + id_custom_fatura +
                ", valor_total=" + valor_total +
                '}';
    }



}
