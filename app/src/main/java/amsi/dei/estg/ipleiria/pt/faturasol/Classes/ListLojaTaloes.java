package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 05/12/2017.
 */

public class ListLojaTaloes {

    private int id;
    private int numero_fatura;

    public ListLojaTaloes(int id, int numero_fatura) {
        this.id = id;
        this.numero_fatura = numero_fatura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_fatura() {
        return numero_fatura;
    }

    public void setNumero_fatura(int numero_fatura) {
        this.numero_fatura = numero_fatura;
    }

    @Override
    public String toString() {
        return "ListLojaTaloes{" +
                "id=" + id +
                ", numero_fatura=" + numero_fatura +
                '}';
    }





}
