package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Fatura_Empresa {

    private long id;
    private int id_fatura;
    private int id_empresa;

    public Fatura_Empresa(long id, int id_fatura, int id_empresa) {
        this.id = id;
        this.id_fatura = id_fatura;
        this.id_empresa = id_empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_fatura() {
        return id_fatura;
    }

    public void setId_fatura(int id_fatura) {
        this.id_fatura = id_fatura;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    @Override
    public String toString() {
        return "Fatura_Empresa{" +
                "id=" + id +
                ",id_fatura=" + id_fatura +
                ",id_empresa=" + id_empresa +
                '}';
    }



}
