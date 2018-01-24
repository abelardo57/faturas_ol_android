package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class Cliente {

    private long numero_cartao;
    private String nome;
    private String email;
    private String username;
    private String password;
    private String telemovel;
    private String nif;
    private String auth_key;


    public Cliente(long numero_cartao, String nome, String email, String username, String password, String telemovel, String nif, String auth_key) {
        this.numero_cartao = numero_cartao;
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.telemovel = telemovel;
        this.nif = nif;
        this.auth_key = auth_key;
    }


    public long getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(long numero_cartao) {
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

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getAuthkey(){return auth_key;}

    public void setAuthkey(String auth_key){this.auth_key = auth_key;}


    @Override
    public String toString() {
        return "Cliente{" +
                "numero_cartao=" + numero_cartao +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telemovel=" + telemovel + '\'' +
                ", nif=" + nif + '\'' +
                ", auth_key="+ auth_key +
                '}';
    }
}
