package amsi.dei.estg.ipleiria.pt.faturasol;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Cliente;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class Registar extends AppCompatActivity {

    private String _username;
    private String _password;

    private EditText vNome;
    private EditText vNIF;
    private EditText vTelemovel;
    private EditText vUsername;
    private EditText vPassword;
    private EditText vconfPass;
    private EditText vEmail;

    /**test**/
    private ArrayList<Cliente> clientes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _username = getIntent().getStringExtra("_USERNAME");
        _password = getIntent().getStringExtra("_PASSWORD");

        vNome = findViewById(R.id.txtNome);
        vNIF = findViewById(R.id.txtNIF);
        vTelemovel = findViewById(R.id.txtTele);
        vUsername = findViewById(R.id.txtUsername);
        vPassword = findViewById(R.id.txtPassword);
        vconfPass = findViewById(R.id.txtCPassword);
        vEmail = findViewById(R.id.txtEmail);

        vUsername.setText(_username);
        vPassword.setText(_password);

        /** mostra clientes na base de dados (consola) */
        clientes = SingletonF_OL.getInstance(getApplicationContext()).getClientes();

        for (Cliente cliente: clientes) {
            System.out.println("-->"+cliente);
        }
        /**end of test */

    }

    public void onClickRegistar(View view) {

        //TODO confirmação e-mail(igual,estrutura), username(igual), password, nif e telemovel(comprimento)

        if (tentaRegisto() == true)
        {
            //TODO hash da password
            long id = clientes.size()+1;

            SingletonF_OL.getInstance(getApplicationContext()).registarClienteBD(new Cliente(id,vNome.getText().toString(),vEmail.getText().toString(),vUsername.getText().toString(),vPassword.getText().toString(), vTelemovel.getText().toString(),vNIF.getText().toString(),"nemInteressaSeQueresSaber"));

            finish();
        }
        else {
            /** num da*/
            System.out.println("--> ta certo sqn");
        }

    }

    public void onClickVoltar(View view) {
        finish();
    }

    private boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {

        return password.length() >= 6;
    }

    private boolean isPasswordConfValid(String password, String passwordConf) {

        return password.equals(passwordConf);
    }

    private boolean isUsernameValid(String username) {
        return username.length() > 1 && username.length()<16;
    }

    private boolean isNFIValid(String NIF) {
        return NIF.length() == 9;
    }

    private boolean isTelemovelValid(String telemovel) {
        return telemovel.length() == 9;
    }

    private boolean tentaRegisto() {

        // Reset errors.
        vNome.setError(null);
        vUsername.setError(null);
        vEmail.setError(null);
        vPassword.setError(null);
        vconfPass.setError(null);
        vNIF.setError(null);
        vTelemovel.setError(null);

        String nome = vNome.getText().toString();
        String email = vEmail.getText().toString();
        String password = vPassword.getText().toString();
        String passwordConf = vconfPass.getText().toString();
        String username = vUsername.getText().toString();
        String nif = vNIF.getText().toString();
        String telemovel = vTelemovel.getText().toString();



        boolean cancel = false;
        View focusView = null;

        if (nome.trim().isEmpty()) {
            vNome.setError(getString(R.string.error_field_required));
            focusView = vNome;
            cancel = true;
        }

        /** Check for a valid username.*/
        if (TextUtils.isEmpty(username)) {
            vUsername.setError(getString(R.string.error_field_required));
            focusView = vUsername;
            cancel = true;
        }
        else if (!isUsernameValid(username)){
            vUsername.setError(getString(R.string.error_invalid_username));
            focusView = vUsername;
            cancel = true;
        }
        else if (SingletonF_OL.getInstance(getApplicationContext()).checkUser(username)==true){
            vUsername.setError(getString(R.string.error_invalid_username_exists));
            focusView = vUsername;
            cancel = true;
        }

        /** Check for a valid email address.*/
        if (TextUtils.isEmpty(email)) {
            vEmail.setError(getString(R.string.error_field_required));
            focusView = vEmail;
            cancel = true;
        }else if (!isEmailValid(email)) {
            vEmail.setError(getString(R.string.error_invalid_email));
            focusView = vEmail;
            cancel = true;
        }
        else if (SingletonF_OL.getInstance(getApplicationContext()).chekEmail(email)==true){
            vEmail.setError(getString(R.string.error_invalid_email_exists));
            focusView = vEmail;
            cancel = true;
        }

        /** Check for a valid password.*/
        if (password.trim().isEmpty() || !isPasswordValid(password)) {
            vPassword.setError(getString(R.string.error_invalid_password));
            focusView = vPassword;
            cancel = true;
        }

        /** Check for a valid password.*/
        if (password.trim().isEmpty() || !isPasswordConfValid(password,passwordConf)) {
            vconfPass.setError("Password Diferente");
            focusView = vconfPass;
            cancel = true;
        }

        /** Check for a valid nif.*/
        if (TextUtils.isEmpty(nif)) {
            vNIF.setError(getString(R.string.error_field_required));
            focusView = vNIF;
            cancel = true;
        }
        else if (!isNFIValid(nif)){
            vNIF.setError(getString(R.string.error_invalid_nif));
            focusView = vNIF;
            cancel=true;
        }
        else if (SingletonF_OL.getInstance(getApplicationContext()).checkNIF(nif)==true){
            vNIF.setError(getString(R.string.error_invalid_nif_exists));
            focusView = vNIF;
            cancel = true;
        }


        /** Check for a valid telemovel*/
        if (telemovel.trim().isEmpty()) {
            /** deixar passar em branco */
        }
        else if (!isTelemovelValid(telemovel)){
            vTelemovel.setError(getString(R.string.error_invalid_telemovel));
            focusView = vTelemovel;
            cancel=true;
        }
        else if (SingletonF_OL.getInstance(getApplicationContext()).checkTele(telemovel)==true){
            vTelemovel.setError(getString(R.string.error_invalid_telemovel_exists));
            focusView = vTelemovel;
            cancel = true;
        }

        if (cancel == true) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
            return false;
        }
        return true;
    }

}
