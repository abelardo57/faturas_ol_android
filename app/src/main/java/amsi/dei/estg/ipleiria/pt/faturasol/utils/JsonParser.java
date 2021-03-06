package amsi.dei.estg.ipleiria.pt.faturasol.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Cliente;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;

/**
 * Created by Abel_ on 19/01/2018.
 */

public class JsonParser {


    public static ArrayList parserJsonClientes(JSONArray response, Context context){
        System.out.println("--> Parser Lista Livros: " + response.toString());

        ArrayList<Cliente> tempListaClientes = new ArrayList<Cliente>();
        try {
            for (int i = 0; i<response.length(); i++){
                JSONObject cliente = (JSONObject) response.get(i);

                long numero_cartao = cliente.getInt("numero_cartao");
                String nome = cliente.getString("nome");
                String email = cliente.getString("email");
                String username = cliente.getString("username");
                String password = cliente.getString("password");
                String telemovel = cliente.getString("telemovel");
                String nif = cliente.getString("nif");
                String auth_key = cliente.getString("auth_key");

                Cliente auxCliente = new Cliente(numero_cartao,nome,email,username,password,telemovel,nif,auth_key);
                tempListaClientes.add(auxCliente);
            }
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return tempListaClientes;
    }

    public static Cliente parserJsonCliente(String response, Context context){
        System.out.println("--> Parser Cliente: " + response.toString());

        Cliente auxCliente = null;

        try {
            JSONObject cliente = new JSONObject(response);

            long numero_cartao = cliente.getInt("numero_cartao");
            String nome = cliente.getString("nome");
            String email = cliente.getString("email");
            String username = cliente.getString("username");
            String password = cliente.getString("password");
            String telemovel = cliente.getString("telemovel");
            String nif = cliente.getString("nif");
            String auth_key = cliente.getString("auth_key");

            auxCliente = new Cliente(numero_cartao,nome,email,username,password,telemovel,nif,auth_key);

        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return auxCliente;
    }

    public static ArrayList parserJsonEmpresas(JSONArray response, Context context){
        System.out.println("--> Parser Lista Livros: " + response.toString());

        ArrayList<Empresa> tempListaEmpresas = new ArrayList<Empresa>();

        try {
            for (int i = 0; i<response.length(); i++){
                JSONObject empresa = (JSONObject) response.get(i);

                long id = empresa.getInt("id");
                String nome = empresa.getString("nome");
                String nif = empresa.getString("nif");
                String morada = empresa.getString("morada");

                Empresa auxEmpresa = new Empresa(id,nome,nif,morada);
                tempListaEmpresas.add(auxEmpresa);
            }
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return tempListaEmpresas;
    }

    public static Empresa parserJsonEmpresa(String response, Context context){
        System.out.println("--> Parser Cliente: " + response.toString());

        Empresa auxEmpresa = null;

        try {
            JSONObject empresa = new JSONObject(response);

            long id = empresa.getInt("id");
            String nome = empresa.getString("nome");
            String nif = empresa.getString("nif");
            String morada = empresa.getString("morada");

            auxEmpresa = new Empresa(id,nome,nif,morada);


        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return auxEmpresa;
    }


    public static ArrayList parserJsonFaturas(JSONArray response, Context context){
        System.out.println("--> Parser Lista Faturas: " + response.toString());

        ArrayList<Fatura> tempListaClientes = new ArrayList<Fatura>();
        try {
            for (int i = 0; i<response.length(); i++){
                JSONObject fatura = (JSONObject) response.get(i);

                long id = fatura.getInt("id");
                int numero = fatura.getInt("nome");
                //Date data = fatura.getString("data");
                Date data = Calendar.getInstance().getTime();
                String imagem_path = fatura.getString("imagem_path");
                int favorito = fatura.getInt("favorito");

                Fatura auxFaturas = new Fatura(id,numero,data,imagem_path,favorito);

                tempListaClientes.add(auxFaturas);
            }
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return tempListaClientes;
    }

    public static Fatura parserJsonFatura(String response, Context context){
        System.out.println("--> Parser Fatura: " + response.toString());

        Fatura auxFatura = null;

        try {
            JSONObject fatura = new JSONObject(response);

            long id = fatura.getInt("id");
            int numero = fatura.getInt("nome");
            //Date data = fatura.getString("data");
            Date data = Calendar.getInstance().getTime();
            String imagem_path = fatura.getString("imagem_path");
            int favorito = fatura.getInt("favorito");


            auxFatura = new Fatura(id,numero,data,imagem_path,favorito);

        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return auxFatura;
    }

    public static Boolean isConnectionInternet(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
