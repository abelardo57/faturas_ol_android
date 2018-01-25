package amsi.dei.estg.ipleiria.pt.faturasol;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Adapters.ListLojasAdapter;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.ListLojas;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class MenuActivity extends AppCompatActivity {


    public static final String NOME_LOJA = "";
    private ArrayList<Fatura> fatura;
    public ListView listViewLojas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        SingletonF_OL.getInstance(getApplicationContext()).CurrentUserEmail = getIntent().getStringExtra(Login.DADOS_EMAIL);
        setTitle(SingletonF_OL.getInstance(getApplicationContext()).CurrentUserEmail);
        SingletonF_OL.getInstance(getApplicationContext()).CurrentUserEmail = getIntent().getStringExtra(Login.DADOS_EMAIL);
        SingletonF_OL.getInstance(getApplicationContext()).FiltrarLojasUser();
        //SingletonF_OL.getInstance(getApplicationContext()).getAllCustomFaturasBD();
        listViewLojas = (ListView) findViewById(R.id.listLojass);

        listViewLojas.setAdapter(new ListLojasAdapter(this, SingletonF_OL.getInstance(getApplicationContext()).ArrayListaLojas));

        listViewLojas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent lojaselecionada= new Intent(getApplicationContext(), LojaTaloesMenu.class);



                TextView txtLoja = (TextView) view.findViewById(R.id.txtLoja);
                String nome = txtLoja.getText().toString();

                /*String regx = "(123456790)";
                char[] ca = regx.toCharArray();
                for (char c : ca) {
                    nome = nome.replace(""+c, "");
                } FILTRO DE ESPAÇOS E NUMEROS
                */

                SingletonF_OL.getInstance(getApplicationContext()).LojaSelecionada = txtLoja.getHint().toString();

                startActivity(lojaselecionada);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent;
        switch(item.getItemId()){

                case R.id.usersettings: {
                    intent = new Intent(getApplicationContext(), UserOptions.class);
                    startActivity(intent);
                    return true;
                }
            case R.id.novafatura: {
                intent = new Intent(getApplicationContext(), AdicionarFatura.class);
                intent.putExtra("ADICIONAR_CUSTOM_FATURA", -1);
                startActivity(intent);
                return true;
            }
            case R.id.faturasuser:{
                intent = new Intent(getApplicationContext(), FaturasUser.class);
                startActivity(intent);
                return true;
            }
            case R.id.sair: {
                this.finishAffinity();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }



}
