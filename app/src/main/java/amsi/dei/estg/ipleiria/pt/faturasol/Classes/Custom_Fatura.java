package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Custom_Fatura {

    private long id;
    private int numero;
    private Date data;
    private int nif_empresa;
    private String nome_empresa;
    private String morada_empresa;



    public Custom_Fatura(long id, int numero, Date data, int nif_empresa, String nome_empresa, String morada_empresa) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.nif_empresa = nif_empresa;
        this.nome_empresa = nome_empresa;
        this.morada_empresa = morada_empresa;
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

    public int getNif_empresa() {
        return nif_empresa;
    }

    public void setNif_empresa(int nif_empresa) {
        this.nif_empresa = nif_empresa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getMorada_empresa() {
        return morada_empresa;
    }

    public void setMorada_empresa(String morada_empresa) {
        this.morada_empresa = morada_empresa;
    }

    @Override
    public String toString() {
        return "Custom_Fatura{" +
                "id=" + id + '\'' +
                ", numero=" + numero + '\'' +
                ", data=" + data + '\'' +
                ", nif_empresa=" + nif_empresa + '\'' +
                ", nome_empresa='" + nome_empresa + '\'' +
                ", morada_empresa='" + morada_empresa +
                '}';
    }


}
