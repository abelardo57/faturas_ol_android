package amsi.dei.estg.ipleiria.pt.faturasol;

import android.content.ClipData;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class FaturasUser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faturas_user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SingletonF_OL.getInstance(getApplicationContext()).getAllCustomFaturasBD();
    }

    public void clickteste(View view) {
        Intent intent = new Intent(getApplicationContext(), FaturaSelecionada.class);
        startActivity(intent);
    }

    public void openAdicionarFatura(View view) {
        Intent intent = new Intent(getApplicationContext(), AdicionarFatura.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_menu, menu);

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
