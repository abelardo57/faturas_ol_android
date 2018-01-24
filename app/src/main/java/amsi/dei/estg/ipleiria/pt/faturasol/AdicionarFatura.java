package amsi.dei.estg.ipleiria.pt.faturasol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Custom_Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class AdicionarFatura extends AppCompatActivity {

    private Integer value;
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
    EditText txtData;
    EditText txtNifCliente;
    EditText txtMoradaEmpresa;
    EditText txtNomeEmpresa;
    EditText txtNIFEmpresa;
    EditText txtNFatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_fatura);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        value = getIntent().getIntExtra("ADICIONAR_FATURA", -1);

        txtNFatura = (EditText) findViewById(R.id.txtNFatura);
        txtNIFEmpresa = (EditText) findViewById(R.id.txtNifFatura);
        txtNomeEmpresa = (EditText) findViewById(R.id.txtNomeEmpresa);
        txtMoradaEmpresa = (EditText) findViewById(R.id.txtMoradaEmpresa);
        txtNifCliente = (EditText) findViewById(R.id.txtNifCliente);
        txtData = (EditText) findViewById(R.id.txtData);
    }

    public void onClickAdicionarCustomFatura(View view) {

        if (txtNFatura.getText().toString().equals("")||txtNIFEmpresa.getText().toString().equals("")||txtNomeEmpresa.getText().toString().equals("")||txtMoradaEmpresa.getText().toString().equals("")||txtNifCliente.getText().toString().equals("")||txtData.getText().toString().equals(""))
        {
            Toast.makeText(this, "Campos vazios", Toast.LENGTH_SHORT).show();
        }
        else {
            //nova fatura
            try {
                    SingletonF_OL.getInstance(getApplicationContext()).adicionarCustomFaturaDB(new Custom_Fatura(0,Integer.parseInt(txtNFatura.getText().toString()), format.parse(txtData.getText().toString()), Integer.parseInt(txtNIFEmpresa.getText().toString()), txtNomeEmpresa.getText().toString(), txtMoradaEmpresa.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                finish();

        }
    }

}
