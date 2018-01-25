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
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Custom_Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class FaturasUser extends AppCompatActivity {

    private ListView listaCustomFaturas;
    private ListaCustomFaturasAdapter listaCustomFaturasAdapter;
    private ArrayList<Custom_Fatura> listacustomfaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faturas_user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //listacustomfaturas = SingletonF_OL.getInstance(getApplicationContext()).getAllCustomFaturasDB();

        listaCustomFaturas=(ListView) findViewById(R.id.ListViewFaturasUser);
        if (listacustomfaturas != null) {
            listaCustomFaturas.setAdapter(new ListaCustomFaturasAdapter(this, listacustomfaturas));

            listaCustomFaturas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(getApplicationContext(), FaturaSelecionada.class);
                    intent.putExtra("FATURA_SELECIONADA", i);
                    startActivity(intent);


                }
            });
        }

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
                listaCustomFaturas.setAdapter(new ListaCustomFaturasAdapter(FaturasUser.this, tempListaCustomFatura));


                listaCustomFaturas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
}
