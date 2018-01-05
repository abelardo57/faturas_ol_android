package amsi.dei.estg.ipleiria.pt.faturasol.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.ListLojaTaloes;
import amsi.dei.estg.ipleiria.pt.faturasol.R;

/**
 * Created by Abel_ on 05/12/2017.
 */

public class ListLojaTaloesAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ListLojaTaloes> listLojaTaloes;
    public TextView txtFatura;
    public Fatura fatura;

    public ListLojaTaloesAdapter(Context context, ArrayList listLojaTaloes)
    {
        this.context = context;
        this.listLojaTaloes = listLojaTaloes;
    }


    @Override
    public int getCount() {
        return listLojaTaloes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if( convertView == null){
            convertView = inflater.inflate(R.layout.item_lista_lojas,null);
        }

        txtFatura = (TextView) convertView.findViewById(R.id.txtLoja);
        ListLojaTaloes listlojataloes = listLojaTaloes.get(position);

        int numero_fatura = listlojataloes.getNumero_fatura();
        txtFatura.setText(Integer.toString(numero_fatura));


        return convertView;
    }

    public void clearData() {
        // clear the data
        listLojaTaloes.clear();
    }
}
