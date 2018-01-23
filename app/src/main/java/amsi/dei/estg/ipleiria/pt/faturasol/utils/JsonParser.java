package amsi.dei.estg.ipleiria.pt.faturasol.utils;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Cliente;

/**
 * Created by Abel_ on 19/01/2018.
 */

public class JsonParser {
    /*public static ArrayList parserJson(JSONArray response, Context context){
        System.out.println("--> Parser Lista Livros: " + response.toString());

        ArrayList<Cliente> tempListaClientes = new ArrayList<Cliente>();

        try {
            for (int i = 0; i<response.length(); i++){
                JSONObject cliente = (JSONObject) response.get(i);

                int num_cartao = livro.getInt("id");
                String titulo = livro.getString("titulo");
                String serie = livro.getString("serie");
                String autor = livro.getString("autor");
                String ano = livro.getString("ano");
                String capa = livro.getString("capa");

                Cliente auxCliente = new Cliente(idLivro,titulo,serie,autor,ano,capa);
                tempListaClientes.add(auxLivro);
            }
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }*/
}
