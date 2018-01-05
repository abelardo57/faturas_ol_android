package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 24/11/2017.
 */

public class ListLojas {




    private int id_loja;
    private String nome;
    private int total;


    public ListLojas(int id_loja,String nome, int total) {
        this.id_loja = id_loja;
        this.nome = nome;
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }

    @Override
    public String toString() {
        return "ListLojas{" +
                "id_loja=" + id_loja +
                ", nome='" + nome + '\'' +
                ", total=" + total +
                '}';
    }
}
