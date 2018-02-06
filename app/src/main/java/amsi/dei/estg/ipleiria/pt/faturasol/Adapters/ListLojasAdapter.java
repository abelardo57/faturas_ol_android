package amsi.dei.estg.ipleiria.pt.faturasol.Adapters;

import android.content.Context;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.ListLojas;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.SingletonF_OL;
import amsi.dei.estg.ipleiria.pt.faturasol.MenuActivity;
import amsi.dei.estg.ipleiria.pt.faturasol.R;

/**
 * Created by Abel_ on 03/11/2017.
 */

public class ListLojasAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Empresa> listEmpresas;
    public TextView txtLoja;
    public Fatura fatura;


    public ListLojasAdapter(Context context, ArrayList listLojas){
        this.context = context;
        this.listEmpresas = listLojas;
    }

    @Override
    public int getCount() { return listEmpresas.size(); }

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


        txtLoja = (TextView) convertView.findViewById(R.id.txtLoja);
        Empresa listempresa = listEmpresas.get(position);

        String nome = listempresa.getNome();
        txtLoja.setHint(String.valueOf(listempresa.getId()));
        txtLoja.setText(nome);

        return convertView;



        //Livro livro = livros.get(position);
        //imageView.setImageResource(livro.getCapa());


    }
    public void refresh(ArrayList<Empresa> empresas){
        this.listEmpresas = empresas;
        notifyDataSetChanged();
    }
}
