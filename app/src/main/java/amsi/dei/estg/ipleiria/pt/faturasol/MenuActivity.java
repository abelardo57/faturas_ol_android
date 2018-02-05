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
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import amsi.dei.estg.ipleiria.pt.faturasol.Adapters.ListLojasAdapter;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura_Cliente;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura_Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.ListLojas;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class MenuActivity extends AppCompatActivity {

    /** MOSTRAR AS EMPRESAS QUE TEM FATURAS DO CLIENTE AUTENTICADO */

    public static final String NOME_LOJA = "";
    private ArrayList<Fatura> fatura;
    public ListView listViewLojas;

    private ArrayList<Fatura> faturas = new ArrayList<>();
    private ArrayList<Empresa> empresas = new ArrayList<>();
    private ArrayList<Fatura_Empresa> faturaEmpresas = new ArrayList<>();
    private ArrayList<Fatura_Cliente> faturaClientes = new ArrayList<>();

    public Date currentTime = Calendar.getInstance().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //SingletonF_OL.getInstance(getApplicationContext()).CurrentUsername = getIntent().getStringExtra(Login.DADOS_EMAIL);
        setTitle(SingletonF_OL.getInstance(getApplicationContext()).CurrentUsername + " | " + SingletonF_OL.getInstance(getApplicationContext()).CurrentUser);

        /**SingletonF_OL.getInstance(getApplicationContext()).FiltrarLojasUser();
        SingletonF_OL.getInstance(getApplicationContext()).getAllCustomFaturasBD();*/

        /** Gerar faturas ao utilizador presente */
        //gerarFaturas();

        faturas = SingletonF_OL.getInstance(getApplicationContext()).getFatura();

        for (Fatura fatura: faturas) {
            System.out.println("-->"+fatura);
        }

        /**  associar faturas a empresas*/
        //associarFaturaEmpresa();

        faturaEmpresas = SingletonF_OL.getInstance(getApplicationContext()).getFaturasEmpresa();

        for (Fatura_Empresa fatura: faturaEmpresas) {
            System.out.println("-->"+fatura);
        }

        faturaClientes = SingletonF_OL.getInstance(getApplicationContext()).getFaturaCliente();

        for (Fatura_Cliente fatura: faturaClientes) {
            System.out.println("-->"+fatura);
        }

        listViewLojas = (ListView) findViewById(R.id.listLojass);

        listViewLojas.setAdapter(new ListLojasAdapter(this, SingletonF_OL.getInstance(getApplicationContext()).ArrayListaLojas));

        listViewLojas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent lojaselecionada= new Intent(getApplicationContext(), LojaTaloesMenu.class);


                TextView txtLoja = (TextView) view.findViewById(R.id.txtLoja);
                String nome = txtLoja.getText().toString();

                /** FILTRO DE ESPAÇOS E NUMEROS
                 *
                String regx = "(123456790)";
                char[] ca = regx.toCharArray();
                for (char c : ca) {
                    nome = nome.replace(""+c, "");
                }
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
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void gerarFaturas(){
        Random random = new Random();
        int num1 = random.nextInt(999999999 - 100000000);
        int num2 = random.nextInt(999999999 - 100000000);
        int num3 = random.nextInt(999999999 - 100000000);
        int num4 = random.nextInt(999999999 - 100000000);
        int num5 = random.nextInt(999999999 - 100000000);
        int num6 = random.nextInt(999999999 - 100000000);

        faturas = SingletonF_OL.getInstance(getApplicationContext()).getFatura();
        SingletonF_OL.getInstance(getApplicationContext()).adicionarFaturasDefinitivasBD(new Fatura(faturas.size()+1, random.nextInt(999999999-100000000),currentTime,"",1));
        faturas = SingletonF_OL.getInstance(getApplicationContext()).getFatura();
        SingletonF_OL.getInstance(getApplicationContext()).adicionarFaturasDefinitivasBD(new Fatura (faturas.size()+1, random.nextInt(999999999-100000000), currentTime,"",1));
        faturas = SingletonF_OL.getInstance(getApplicationContext()).getFatura();
        SingletonF_OL.getInstance(getApplicationContext()).adicionarFaturasDefinitivasBD(new Fatura (faturas.size()+1, random.nextInt(999999999-100000000), currentTime,"",1));
        faturas = SingletonF_OL.getInstance(getApplicationContext()).getFatura();
        SingletonF_OL.getInstance(getApplicationContext()).adicionarFaturasDefinitivasBD(new Fatura (faturas.size()+1, random.nextInt(999999999-100000000), currentTime,"",1));
        faturas = SingletonF_OL.getInstance(getApplicationContext()).getFatura();
        SingletonF_OL.getInstance(getApplicationContext()).adicionarFaturasDefinitivasBD(new Fatura (faturas.size()+1, random.nextInt(999999999-100000000), currentTime,"",1));
        faturas = SingletonF_OL.getInstance(getApplicationContext()).getFatura();
        SingletonF_OL.getInstance(getApplicationContext()).adicionarFaturasDefinitivasBD(new Fatura (faturas.size()+1, random.nextInt(999999999-100000000), currentTime,"",1));
    }

    public void associarFaturaEmpresa(){
        Random random = new Random();
        faturas = SingletonF_OL.getInstance(getApplicationContext()).getFatura();
        empresas = SingletonF_OL.getInstance(getApplicationContext()).getEmpresas();

        for (int i = 1; i == faturas.size(); i++) {
            faturaEmpresas = SingletonF_OL.getInstance(getApplicationContext()).getFaturasEmpresa();
            SingletonF_OL.getInstance(getApplicationContext()).adicionarFaturaEmpresa(faturaEmpresas.size() + 1, i, random.nextInt(empresas.size()));
        }
    }

}
