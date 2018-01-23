package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Fatura {



    private long id;
    private int numero;
    private Date data;
    //private String imagem_path;
    private int numero_cartao;
    private int id_empresa;
    private int is_fav;


    public Fatura(int id, int numero, Date data, int numero_cartao, int id_empresa,int is_fav) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.numero_cartao = numero_cartao;
        this.id_empresa = id_empresa;
        this.is_fav = is_fav;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(int numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getIs_fav() {
        return is_fav;
    }

    public void setIs_fav(int is_fav) {
        this.is_fav = is_fav;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "id=" + id +
                ", numero=" + numero +
                ", data=" + data +
                ", numero_cartao=" + numero_cartao +
                ", id_empresa=" + id_empresa +
                ", is_fav=" + is_fav +
                '}';
    }

}
