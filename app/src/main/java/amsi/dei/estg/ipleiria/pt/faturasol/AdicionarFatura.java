package amsi.dei.estg.ipleiria.pt.faturasol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
    SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yy");
    EditText txtData;
    EditText txtMoradaEmpresa;
    EditText txtNomeEmpresa;
    EditText txtNIFEmpresa;
    EditText txtNFatura;
    Date convertedDate = new Date();

    ArrayList<Custom_Fatura> customFaturas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_fatura);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        customFaturas = SingletonF_OL.getInstance(getApplicationContext()).getAllCustomFaturasDB();

        value = getIntent().getIntExtra("ADICIONAR_FATURA", -1);

        for (Custom_Fatura fatura: customFaturas) {
            System.out.println("-->"+fatura);
        }

        txtNFatura = (EditText) findViewById(R.id.txtNFatura);
        txtNIFEmpresa = (EditText) findViewById(R.id.txtNifEmpresa);
        txtNomeEmpresa = (EditText) findViewById(R.id.txtNomeEmpresa);
        txtMoradaEmpresa = (EditText) findViewById(R.id.txtMoradaEmpresa);
        txtData = (EditText) findViewById(R.id.txtData);
    }

    public void onClickAdicionarCustomFatura(View view) {

        /*if (txtNFatura.getText().toString().equals("")||txtNIFEmpresa.getText().toString().equals("")||txtNomeEmpresa.getText().toString().equals("")||txtMoradaEmpresa.getText().toString().equals("")||txtData.getText().toString().equals(""))
        {
            Toast.makeText(this, "Campos vazios", Toast.LENGTH_SHORT).show();
        }
        else {*/
        if (tentaRegisto() == true){
            //nova fatura
            try {
                long id = customFaturas.size()+1;

                convertedDate = formatdate.parse(txtData.getText().toString());
                    SingletonF_OL.getInstance(getApplicationContext()).adicionarCustomFaturaDB(new Custom_Fatura(id,Integer.parseInt(txtNFatura.getText().toString()), convertedDate, Integer.parseInt(txtNIFEmpresa.getText().toString()), txtNomeEmpresa.getText().toString(), txtMoradaEmpresa.getText().toString()));

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            System.out.println(convertedDate);
                System.out.println("--> Teste custom_fatura:" + txtNomeEmpresa.getText().toString());
                finish();

        }
    }

    private boolean tentaRegisto() {

        // Reset errors.
        txtNFatura.setError(null);
        txtNIFEmpresa.setError(null);
        txtNomeEmpresa.setError(null);
        txtMoradaEmpresa.setError(null);
        txtData.setError(null);


        String numero = txtNFatura.getText().toString();
        String nif = txtNIFEmpresa.getText().toString();
        String nome = txtNomeEmpresa.getText().toString();
        String morada = txtMoradaEmpresa.getText().toString();
        String data = txtData.getText().toString();


        boolean cancel = false;
        View focusView = null;

        /** Check numero not blank*/
        if (numero.trim().isEmpty()) {
            txtNFatura.setError(getString(R.string.error_field_required));
            focusView = txtNFatura;
            cancel = true;
        }

        /** Check for a valid nif.*/
        if (TextUtils.isEmpty(nif)) {
            txtNIFEmpresa.setError(getString(R.string.error_field_required));
            focusView = txtNIFEmpresa;
            cancel = true;
        }
        /** Check for valid nif length*/
        else if (nif.length() != 9){
            txtNIFEmpresa.setError(getString(R.string.error_invalid_nif));
            focusView = txtNIFEmpresa;
            cancel = true;
        }

        /** Check for a valid nome.*/
        if (TextUtils.isEmpty(nome)) {
            txtNomeEmpresa.setError(getString(R.string.error_field_required));
            focusView = txtNomeEmpresa;
            cancel = true;
        }

        /** Check for a valid morada.*/
        if (TextUtils.isEmpty(morada)) {
            txtMoradaEmpresa.setError(getString(R.string.error_field_required));
            focusView = txtMoradaEmpresa;
            cancel = true;
        }

        /** Check for a valid data.*/
        if (TextUtils.isEmpty(data)) {
            txtData.setError(getString(R.string.error_field_required));
            focusView = txtData;
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
