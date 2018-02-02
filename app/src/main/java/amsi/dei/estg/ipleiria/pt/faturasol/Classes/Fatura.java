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
    private String imagem_path;
    private int is_fav;


    public Fatura(int id, int numero, Date data, String imagem_path, int is_fav) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.imagem_path = imagem_path;
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

    public String getImagem_path() {
        return imagem_path;
    }

    public void setImagem_path(String imagem_path) {
        this.imagem_path = imagem_path;
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
                ", imagem_path=" + imagem_path +
                ", is_fav=" + is_fav +
                '}';
    }

}
