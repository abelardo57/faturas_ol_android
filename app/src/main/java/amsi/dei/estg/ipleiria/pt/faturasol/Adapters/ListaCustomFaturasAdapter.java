package amsi.dei.estg.ipleiria.pt.faturasol.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Custom_Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.ListLojas;
import amsi.dei.estg.ipleiria.pt.faturasol.R;

/**
 * Created by User on 24/01/2018.
 */

public class ListaCustomFaturasAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Custom_Fatura> listCustomFaturas;


    public ListaCustomFaturasAdapter(Context context, ArrayList<Custom_Fatura> listCustomFaturas){
        this.context = context;
        this.listCustomFaturas = listCustomFaturas;
    }

    @Override
    public int getCount() { return listCustomFaturas.size(); }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if( convertView == null){
            convertView = inflater.inflate(R.layout.item_lista_faturas_user,null);
        }


        TextView customFatura = (TextView) convertView.findViewById(R.id.textViewItemFaturaUser);
        Custom_Fatura listaCustomFaturas = listCustomFaturas.get(position);

        Custom_Fatura custom_fatura = listCustomFaturas.get(position);
        //String nome = listloja.getNome();
        //int total = listloja.getTotal();
        //txtLoja.setHint(Integer.toString(listloja.getId_loja()));
       // txtLoja.setText(nome + "( " + Integer.toString(total) + " )");
        customFatura.setText(listaCustomFaturas.getNumero());

        return convertView;

    }
    public void refresh(ArrayList<Custom_Fatura> custom_faturas){
        this.listCustomFaturas = custom_faturas;
        notifyDataSetChanged();
    }
}
