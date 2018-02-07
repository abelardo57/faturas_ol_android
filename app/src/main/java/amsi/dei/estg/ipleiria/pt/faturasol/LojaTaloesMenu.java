package amsi.dei.estg.ipleiria.pt.faturasol;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.GetChars;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Adapters.ListLojaTaloesAdapter;
import amsi.dei.estg.ipleiria.pt.faturasol.Adapters.ListLojasAdapter;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.ListLojaTaloes;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class LojaTaloesMenu extends AppCompatActivity {

    private TextView lojaView;
    public ListView listViewLojaTaloes;
    private ArrayList<Empresa> empresa;
    private ArrayList<ListLojaTaloes> listaLojaTaloes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja_taloes_menu);

        //setTitle(SingletonF_OL.getInstance().CurrentUserEmail);

        /**SingletonF_OL.getInstance(getApplicationContext()).FiltrarTaloesLoja(); */

        //lojaView = (TextView) findViewById(R.id.lojaView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {
            empresa = SingletonF_OL.getInstance(getApplicationContext()).getEmpresas();
            SingletonF_OL.getInstance(getApplicationContext()).FiltrarTaloesLoja();
            setTitle(empresa.get(Integer.parseInt(SingletonF_OL.getInstance(getApplicationContext()).LojaSelecionada)).getNome());
            listViewLojaTaloes = (ListView) findViewById(R.id.listLojaTaloes);

            listViewLojaTaloes.setAdapter(new ListLojaTaloesAdapter(this, SingletonF_OL.getInstance(getApplicationContext()).arrayListLojaTaloes));

        listViewLojaTaloes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent talaoselecionado = new Intent(getApplicationContext(), FaturaSelecionada.class);

                TextView txtTalao = (TextView) view.findViewById(R.id.txtLoja);
                String texto = txtTalao.getText().toString();
                SingletonF_OL.getInstance(getApplicationContext()).TalaoSelecionado = texto;

                startActivity(talaoselecionado);

                ListLojaTaloesAdapter adapt = (ListLojaTaloesAdapter)listViewLojaTaloes.getAdapter();
                adapt.clearData();
                adapt.notifyDataSetChanged();
                setTitle(SingletonF_OL.getInstance(getApplicationContext()).CurrentUserEmail);


            }
        });
        }catch(Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
    }


    public void LojaOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), FaturaSelecionada.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_loja_taloes, menu);
        MenuItem itemPesquisa = menu.findItem(R.id.itemPesquisa);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(itemPesquisa);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<ListLojaTaloes> templistaLojaTaloes = new ArrayList<>();
                for (ListLojaTaloes temp:listaLojaTaloes) {

                        templistaLojaTaloes.add(temp);

                }
                listViewLojaTaloes.setAdapter(new ListLojaTaloesAdapter(LojaTaloesMenu.this, templistaLojaTaloes));


                listViewLojaTaloes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent talaoselecionado = new Intent(getApplicationContext(), FaturaSelecionada.class);

                        TextView txtTalao = (TextView) view.findViewById(R.id.txtLoja);
                        String texto = txtTalao.getText().toString();
                        SingletonF_OL.getInstance(getApplicationContext()).TalaoSelecionado = texto;

                        startActivity(talaoselecionado);

                        ListLojaTaloesAdapter adapt = (ListLojaTaloesAdapter)listViewLojaTaloes.getAdapter();
                        adapt.clearData();
                        adapt.notifyDataSetChanged();
                        setTitle(SingletonF_OL.getInstance(getApplicationContext()).CurrentUserEmail);

                    }
                });

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
            {
                try {
                        ListLojaTaloesAdapter adapt = (ListLojaTaloesAdapter) listViewLojaTaloes.getAdapter();
                        adapt.clearData();
                        adapt.notifyDataSetChanged();
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                        startActivity(intent);
                        }catch(Exception e) {
                        System.out.println("Error"+ e.getMessage());
                        }
                        return true;


                }
            }


        return super.onOptionsItemSelected(item);
    }

}
