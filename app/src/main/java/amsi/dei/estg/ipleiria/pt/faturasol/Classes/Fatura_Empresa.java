package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Fatura_Empresa {

    private int id_fatura;
    private int id_empresa;

    public Fatura_Empresa(int id_fatura, int id_empresa) {
        this.id_fatura = id_fatura;
        this.id_empresa = id_empresa;
    }

    public int getId_fatura() {
        return id_fatura;
    }

    public void setId_fatura(int id_fatura) {
        this.id_fatura = id_fatura;
    }

    @Override
    public String toString() {
        return "Fatura_Empresa{" +
                "id_fatura=" + id_fatura +
                ", id_empresa=" + id_empresa +
                '}';
    }



}
