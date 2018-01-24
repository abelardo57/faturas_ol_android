package amsi.dei.estg.ipleiria.pt.faturasol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    }

    public void onClickVoltar(View view) {
        finish();
    }
}
