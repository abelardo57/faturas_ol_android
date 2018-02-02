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

    public static ArrayList parserJsonClientes(JSONArray response, Context context){
        System.out.println("--> Parser Lista clientes: " + response.toString());

        ArrayList<Cliente> tempListaClientes = new ArrayList<Cliente>();

        try {
            for (int i = 0; i<response.length(); i++){
                JSONObject cliente = (JSONObject) response.get(i);

                int num_cartao = cliente.getInt("numero_cartao");
                String titulo = cliente.getString("titulo");
                String serie = cliente.getString("serie");
                String autor = cliente.getString("autor");
                String ano = cliente.getString("ano");
                String capa = cliente.getString("capa");
                String nif = cliente.getString("capa");
                String auth = cliente.getString("capa");

                Cliente auxCliente = new Cliente(num_cartao,titulo,serie,autor,ano,capa,nif,auth);
                tempListaClientes.add(auxCliente);
            }
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return tempListaClientes;
    }
}
