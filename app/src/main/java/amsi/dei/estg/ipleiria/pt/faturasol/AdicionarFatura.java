package amsi.dei.estg.ipleiria.pt.faturasol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class AdicionarFatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_fatura);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void AdicionarClick(View view) {
        EditText txtFatura = (EditText) findViewById(R.id.txtNFatura);
        //EditText txtNIFEmpresa = (EditText) findViewById(R.id.txtNifFatura);
        //EditText txtNomeEmpresa = (EditText) findViewById(R.id.txtNomeEmpresa);
        //EditText txtMoradaEmpresa = (EditText) findViewById(R.id.txtMoradaEmpresa);
        EditText txtNCartao = (EditText) findViewById(R.id.txtNifCliente);
        //EditText txtData = (EditText) findViewById(R.id.txtData);

        SingletonF_OL.getInstance().NovaFatura(txtFatura.getText().toString(),txtNCartao.getText().toString());






    }

}
