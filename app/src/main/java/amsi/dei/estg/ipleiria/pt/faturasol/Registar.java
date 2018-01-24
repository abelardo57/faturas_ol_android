package amsi.dei.estg.ipleiria.pt.faturasol;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Cliente;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class Registar extends AppCompatActivity {

    private String _email;
    private String _password;

    private EditText vNome;
    private EditText vNIF;
    private EditText vTelemovel;
    private EditText vUsername;
    private EditText vPassword;
    private EditText vconfPass;
    private EditText vEmail;
    
    //test
    private ArrayList<Cliente> clientes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _email = getIntent().getStringExtra("_EMAIL");
        _password = getIntent().getStringExtra("_PASSWORD");

        vNome = (EditText) findViewById(R.id.txtNome);
        vNIF = (EditText) findViewById(R.id.txtNIF);
        vTelemovel = (EditText) findViewById(R.id.txtTele);
        vUsername = (EditText) findViewById(R.id.txtUsername);
        vPassword = (EditText) findViewById(R.id.txtPassword);
        vconfPass = (EditText) findViewById(R.id.txtCPassword);
        vEmail = (EditText) findViewById(R.id.txtEmail);

        vEmail.setText(_email);
        vPassword.setText(_password);

        //test
        clientes = SingletonF_OL.getInstance(getApplicationContext()).getClientes();

        for (Cliente cliente: clientes) {
            System.out.println("-->"+cliente);
        }
        //end of test
        
    }

    public void onClickRegistar(View view) {

        if (vNome.getText().toString().equals("")||vNIF.getText().toString().equals("")||vUsername.getText().toString().equals("")||vEmail.getText().toString().equals("")||vPassword.getText().toString().equals(""))
        {
            Toast.makeText(this, "Campos Vazios", Toast.LENGTH_SHORT).show();
        }
        else if (vconfPass.getText().toString().equals(vPassword.getText().toString())){
            SingletonF_OL.getInstance(getApplicationContext()).registarClienteBD(new Cliente(0,vNome.getText().toString(),vEmail.getText().toString(),vUsername.getText().toString(),vPassword.getText().toString(), vTelemovel.getText().toString(),vNIF.getText().toString(),"nemInteressaSequeresSaber"));

            finish();
        }
        else{
            Toast.makeText(this, "Password diferente da inserida", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickVoltar(View view) {
        finish();
    }

}
