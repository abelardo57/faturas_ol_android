package amsi.dei.estg.ipleiria.pt.faturasol;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class FaturaSelecionada extends AppCompatActivity {

    public int check;
    private ArrayList<Empresa> empresa;
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatura_selecionada);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        empresa = SingletonF_OL.getInstance(getApplicationContext()).getEmpresas();

        this.setTitle(empresa.get(Integer.parseInt(SingletonF_OL.getInstance(getApplicationContext()).LojaSelecionada)).getNome());
        TextView txtFatura = (TextView) findViewById(R.id.txtFatura);
        TextView txtTextoFatura = (TextView)findViewById(R.id.txtTextoFatura);



        txtFatura.setText(SingletonF_OL.getInstance(getApplicationContext()).TalaoSelecionado);
        txtTextoFatura.setText("Buscar texto da fatura a DB");
        check = SingletonF_OL.getInstance(getApplicationContext()).CheckFav(txtFatura.getText().toString());


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fatura_selecionada_menu, menu);
        this.menu = menu;
        if(check == 1)
        {
            menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_action_isfav));
        }
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()){
            case R.id.item1: {
                TextView txtfatura = (TextView) findViewById(R.id.txtFatura);
                if(check == 0)
                {
                    SingletonF_OL.getInstance(getApplicationContext()).IsFav(txtfatura.getText().toString());
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_action_isfav));
                }
                else if(check == 1)
                {
                    SingletonF_OL.getInstance(getApplicationContext()).NoFav(txtfatura.getText().toString());
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_action_notfav));
                }

                check = SingletonF_OL.getInstance(getApplicationContext()).CheckFav(txtfatura.getText().toString());

                return true;
            }
            case R.id.item2:
                TextView txtfatura = (TextView) findViewById(R.id.txtFatura);
                SingletonF_OL.getInstance(getApplicationContext()).DelFatura(txtfatura.getText().toString());
                Intent removido = new Intent(getApplicationContext(), LojaTaloesMenu.class);
                startActivity(removido);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
