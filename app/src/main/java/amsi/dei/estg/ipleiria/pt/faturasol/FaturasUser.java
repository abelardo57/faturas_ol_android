package amsi.dei.estg.ipleiria.pt.faturasol;

import android.content.ClipData;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Adapters.ListaCustomFaturasAdapter;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Cliente;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Custom_Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;
import amsi.dei.estg.ipleiria.pt.faturasol.listeners.FaturasolListener;

public class FaturasUser extends AppCompatActivity implements FaturasolListener {

    private ListView LVlistaCustomFaturas;
    private ListaCustomFaturasAdapter listaCustomFaturasAdapter;
    private ArrayList<Custom_Fatura> listacustomfaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faturas_user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listacustomfaturas = SingletonF_OL.getInstance(getApplicationContext()).getAllCustomFaturasDB();

        //SingletonF_OL.getInstance(getApplicationContext()).setCustomFaturasListener(this);

        LVlistaCustomFaturas.setAdapter(new ListaCustomFaturasAdapter(this, listacustomfaturas));
        for (Custom_Fatura fatura: listacustomfaturas) {
            System.out.println("-->"+fatura);
        }

        LVlistaCustomFaturas=(ListView) findViewById(R.id.ListViewFaturasUser);
        //LVlistaCustomFaturas.setAdapter(new ListaCustomFaturasAdapter(this, listacustomfaturas));

        LVlistaCustomFaturas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Custom_Fatura tempFatura = (Custom_Fatura) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(), FaturaSelecionada.class);
                intent.putExtra("FATURA_SELECIONADA", tempFatura.getId() -1);
                startActivity(intent);


            }
        });


    }

    public void onClickAdicionarFatura(View view) {
        Intent intent = new Intent(getApplicationContext(), AdicionarFatura.class);
        startActivity(intent);
    }

    /*public void clickteste(View view) {
        Intent intent = new Intent(getApplicationContext(), FaturaSelecionada.class);
        startActivity(intent);
    }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.faturas_user, menu);

        MenuItem itemPesquisa = menu.findItem(R.id.itemPesquisar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(itemPesquisa);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Custom_Fatura> tempListaCustomFatura = new ArrayList<>();
                for (Custom_Fatura temp:listacustomfaturas) {
                    if (temp.getNome_empresa().toLowerCase().contains(s.toLowerCase())) {
                        tempListaCustomFatura.add(temp);
                    }
                }
                LVlistaCustomFaturas.setAdapter(new ListaCustomFaturasAdapter(FaturasUser.this, tempListaCustomFatura));


                LVlistaCustomFaturas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Custom_Fatura tempcustom = (Custom_Fatura) adapterView.getItemAtPosition(i);

                        Intent intent = new Intent(getApplicationContext(),FaturaSelecionada.class);
                        intent.putExtra("FATURA_SELECIONADA",i);
                        startActivity(intent);

                    }
                });

                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefreshFaturas(ArrayList<Fatura> listaFaturas) {

    }

    @Override
    public void onUpdateFaturas(Fatura fatura, int operação) {

    }

    @Override
    public void onRefreshCliente(ArrayList<Cliente> listaClientes) {

    }

    @Override
    public void onUpdateCliente(Cliente cliente, int operação) {

    }

    @Override
    public void onRefreshEmpresas(ArrayList<Empresa> listaEmpresas) {

    }

    @Override
    public void onUpdateEmpresas(Empresa empresa, int operação) {

    }

    @Override
    public void onRefreshCustomFaturas(ArrayList<Custom_Fatura> listaCustomFaturas) {
        listaCustomFaturasAdapter = new ListaCustomFaturasAdapter(getApplicationContext(), listaCustomFaturas);
        LVlistaCustomFaturas.setAdapter(listaCustomFaturasAdapter);
        listaCustomFaturasAdapter.refresh(listaCustomFaturas);
    }

    @Override
    public void onUpdateCustomFaturas(Custom_Fatura custom_fatura, int operação) {

    }

}
