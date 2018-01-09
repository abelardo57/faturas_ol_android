package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Cliente {

    private int numero_cartao;
    private String nome;
    private String email;
    private String username;
    private String password;
    private int telemovel;
    private int nif;
    private String authkey;


    public Cliente(int numero_cartao, String nome, String email, String username, String password, int telemovel, int nif, String authkey) {
        this.numero_cartao = numero_cartao;
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.telemovel = telemovel;
        this.nif = nif;
        this.authkey = authkey;
    }


    public int getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(int numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getAuthkey(){return authkey;}

    public void setAuthkey(){this.authkey = authkey;}


    @Override
    public String toString() {
        return "Cliente{" +
                "numero_cartao=" + numero_cartao +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telemovel=" + telemovel +
                ", nif=" + nif +
                ", authkey="+ authkey +
                '}';
    }
}
