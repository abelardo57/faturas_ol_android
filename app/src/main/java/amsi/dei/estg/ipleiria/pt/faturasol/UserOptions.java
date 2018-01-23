package amsi.dei.estg.ipleiria.pt.faturasol;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;

public class UserOptions extends AppCompatActivity {
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView txtViewID = (TextView) findViewById(R.id.txtView_Username);
        txtViewID.setText(SingletonF_OL.getInstance(getApplicationContext()).CurrentUsername);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_settings_menu, menu);
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtTelemovel = (EditText) findViewById(R.id.txtTelemovel);
        EditText txtPass = (EditText) findViewById(R.id.txtPass);
        EditText txtPassConf = (EditText) findViewById(R.id.txtPassConf);
        switch(item.getItemId()){

            case R.id.item1:{
                if(SingletonF_OL.getInstance(getApplicationContext()).SaveChecker == 0)
                {
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_action_save));


                    txtEmail.setEnabled(true);
                    txtTelemovel.setEnabled(true);
                    txtPass.setEnabled(true);
                    txtPassConf.setEnabled(true);

                    SingletonF_OL.getInstance(getApplicationContext()).SaveChecker = 1;
                }
                else
                {
                    menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_action_edit));
                    txtEmail.setEnabled(false);
                    txtTelemovel.setEnabled(false);
                    txtPass.setEnabled(false);
                    txtPassConf.setEnabled(false);
                    SingletonF_OL.getInstance(getApplicationContext()).SaveChecker = 0;
                }

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void alterarUser(View view) {

    }
}
