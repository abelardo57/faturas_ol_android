package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.method.DateTimeKeyListener;
import android.util.Patterns;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import amsi.dei.estg.ipleiria.pt.faturasol.AdicionarFatura;
import amsi.dei.estg.ipleiria.pt.faturasol.listeners.FaturasolListener;
import amsi.dei.estg.ipleiria.pt.faturasol.utils.JsonParser;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class SingletonF_OL implements amsi.dei.estg.ipleiria.pt.faturasol.listeners.FaturasolListener{


    String mUrlAPI= "localhost:8888/numseique/api";
    String mUrlAPILogin= "";
    String tokenAPI= "";


    //private static RequestQueue volleyQueue = null;
    private static SingletonF_OL INSTANCE = null;
    private FaturaDBHelper faturaDBHelper = null;


    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public ArrayList<Empresa> empresa = new ArrayList<Empresa>();
    public ArrayList<Fatura> fatura = new ArrayList<Fatura>();
    private ArrayList<Custom_Fatura> custom_faturas;

    public Date currentTime = Calendar.getInstance().getTime();
    public ArrayList<ListLojas>  ArrayListaLojas = new ArrayList<ListLojas>();
    public ArrayList<ListLojaTaloes> arrayListLojaTaloes = new ArrayList<ListLojaTaloes>();
    public long CurrentUser;
    public String CurrentUsername;
    public String CurrentUserEmail;
    public String LojaSelecionada;
    public String TalaoSelecionado;
    public int CurrentFatura;
    public int SaveChecker = 0;

    private FaturasolListener listener;
    private static RequestQueue volleyQueue = null;


    public static synchronized SingletonF_OL getInstance(Context context) {
        if (INSTANCE == null)
        {
            INSTANCE = new SingletonF_OL(context);
            //volleyQueue = Volley.newRequestQueue(context);
        }
        return INSTANCE;
    }


    private SingletonF_OL(Context context) {
        clientes=new ArrayList<>();
        faturaDBHelper = new FaturaDBHelper(context);

        //GerarClientes();
        //GerarEmpresa();
    }

/**nao mais necessario //
    /*public void GerarClientes(){
        clientes.add(new Cliente ( 10000000, "Rodrigo Paião", "RodriP@gmail.com", "RodriP22", "123456", "39219383", "293857261","autkey")  );
        clientes.add(new Cliente ( 10000001, "Catarina Sales", "CataSal@gmail.com", "CataS", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000002, "Miguel Faria", "FariaM@gmail.com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000003, "João Oliveira", "Joliveira@gmail.com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000004, "Luís Tiago", "LiagoTuis@gmail.com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000005, "Joana Mateus", "JoanaM@gmail.com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000006, "Rodrigo Araujo", "AraujoRRDigo@gmail .com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
    }*/
    public void GerarEmpresa (){

        empresa.add(new Empresa( 1, "Faturas User", "504789456", "Avenida do Brazil"));
        empresa.add(new Empresa( 2, "Verten", "504786321", "Praça do Mandarim"));
        empresa.add(new Empresa( 3, "Pinga Douce", "504853178", "Rua dos Prados Brancos"));
        empresa.add(new Empresa( 4, "Zumbo", "504368159", "Praça D'ouro"));

    }
    public void GerarFaturas() {
        fatura.add(new Fatura (1, 10001, currentTime,"",1));
        fatura.add(new Fatura (2, 10001, currentTime,"",1));
        fatura.add(new Fatura (3, 10001, currentTime,"",1));
        fatura.add(new Fatura (4, 10001, currentTime,"",1));
        fatura.add(new Fatura (5, 10001, currentTime,"",1));
        fatura.add(new Fatura (6, 10001, currentTime,"",1));
    }

    public void registarClienteBD(Cliente cliente){
        /**faturaDBHelper.removerAllClientesBD();
*/
        faturaDBHelper.adicionarClienteBD(cliente);
    }

    public void adicionarEmpresa(Empresa empresas){
        faturaDBHelper.adicionarEmpresaDB(empresas);
    }

    public void adicionarFaturasDefinitivasBD(Fatura fatura){


            faturaDBHelper.adicionarFaturaDB(fatura);

        /** adicionar relação fatura_cliente*/
            adicionarFaturaClienteBD(fatura);
    }


    public void adicionarFaturaClienteBD(Fatura fatura){
        // TODO: 02/02/2018 foreach fatura get id --> set id_fatura = fatura.id e numero_cartao_cliente = cliente.numero_cartao; i++
        ArrayList<Fatura> faturas = new ArrayList<>();
        long id_fatura = fatura.getId();

        faturas = getFatura();
        faturaDBHelper.adicionarFaturaClienteDB(new Fatura_Cliente(faturas.size()+1, (int) id_fatura,(int) CurrentUser));
    }

    public void adicionarFaturaEmpresa(long id, int id_fatura,int id_empresa){
        // TODO: 02/02/2018 foreach fatura get id --> set id_fatura = fatura.id e id_empresa = empresa.id; i++

        faturaDBHelper.adicionarFaturaEmpresaDB(new Fatura_Empresa(id,id_fatura,id_empresa));
    }




    public ArrayList<Cliente> getClientes(){
        return faturaDBHelper.getAllClientesBD();
    }
    public ArrayList getEmpresas(){
        return faturaDBHelper.getAllEmpresasBD();
    }
    public ArrayList getFatura() {
        return faturaDBHelper.getAllFaturasBD();
    }

    public ArrayList getFaturasEmpresa() {
        return faturaDBHelper.getAllFaturasEmpresaBD();
    }

    public ArrayList getFaturaCliente() {
        return faturaDBHelper.getAllFaturasClientesBD();
    }

    public int getTotalFaturas()
    {
        ArrayList<Fatura> fatura = getFatura();
        return fatura.size();
    }

     public void DelFatura(String numero)
     {
         int i = 0;
         int ii = -10;
         ArrayList<Fatura> fatura = getFatura();
         boolean check = false;
         do{
             if(fatura.get(i).getNumero() == Integer.parseInt(numero))
             {
                 check = true;
                 ii = i;
             }
             i++;
         }while(i<getTotalFaturas());

         if(check == true && ii != -10)
         {
             fatura.remove(ii);
         }

     }
    /*public void NovaFatura(String numero, String numero_cartao){

        int i = 0;
        ArrayList<Fatura> fatura = getFatura();
        int ii = getTotalFaturas();
        boolean check = true;
        do{

            if(fatura.get(i).getNumero() == Integer.parseInt(numero))
            {
                check = false;
            }
            i++;
        }while(i<getTotalFaturas());
        if(check == true)
        {
            fatura.add(new Fatura(getTotalFaturas(), Integer.parseInt(numero), currentTime, Integer.parseInt(numero_cartao),0,0));
        }


    }*/

    /**public int GetNumeroFaturasPorLojaCurrentUser(int IdEmpresa){
        int total = 0;
        int i = 0;
        do{
            if(fatura.get(i).getId_empresa() == IdEmpresa)
            {
                total++;
            }
            i++;
        }while(i < fatura.size());
        return total;
    }*/


    public int CheckFav(String numero_fatura){
        int i = 0;
        int ii = 0;
        do{
            if(fatura.get(i).getNumero() == Integer.parseInt(numero_fatura))
            {
                if(fatura.get(i).getIs_fav() == 1)
                {
                    ii=1;
                }
                System.out.println(fatura.get(i).getIs_fav());

            }
            i++;
        }while(i<fatura.size());
        return ii;
    }
    public void IsFav(String numero_fatura){
        int i = 0;
        do{
            if(fatura.get(i).getNumero() == Integer.parseInt(numero_fatura))
            {
                fatura.get(i).setIs_fav(1);
                System.out.println(fatura.get(i).getIs_fav());
            }
            i++;
        }while(i<fatura.size());
    }
    public void NoFav(String numero_fatura){
        int i = 0;
        do{
            if(fatura.get(i).getNumero() == Integer.parseInt(numero_fatura))
            {
                fatura.get(i).setIs_fav(0);
                System.out.print(fatura.get(i).getIs_fav());
            }
            i++;
        }while(i<fatura.size());
    }


    /** Verificações login */
    public boolean checkLogin(String Username, String Password) {
        boolean check = false;
        String username;
        String password;
        int i = 0;
        clientes = getClientes();
        do{
            username = clientes.get(i).getUsername().toString();
            password =  clientes.get(i).getPassword().toString();
            if(Username.equals(username) && Password.equals(password))
            {
                check = true;
                CurrentUser = (int) clientes.get(i).getNumero_cartao();
                CurrentUsername = clientes.get(i).getUsername();
                CurrentUserEmail = clientes.get(i).getEmail();
                i = clientes.size();
            }
            else{
                i++;
            }

        }
        while(i != clientes.size());
        
        return check;
    }


    /** Verificações registo de campos existentes */
    public boolean checkUser(String Username) {
        boolean check = false;
        String username;
        int i = 0;
        clientes = getClientes();

        if (clientes.size()==0){
            return false;
        }
        else {

            do {
                username = clientes.get(i).getUsername().toString();

                if (Username.equals(username)) {
                    check = true;
                } else {
                    i++;
                }
            }
            while (!check && i != clientes.size());

            return check;
        }
    }

    public boolean chekEmail(String Email) {
        boolean check = false;
        String _email;
        int i = 0;
        clientes = getClientes();

        if (clientes.size() == 0) {
            return false;
        } else {
            do {
                _email = clientes.get(i).getEmail().toString();
                if (Email.equals(_email)) {
                    check = true;
                } else {
                    i++;
                }
            }
            while (!check && i != clientes.size());

            return check;
        }
    }

    public boolean checkNIF(String NIF) {
        boolean check = false;
        String _nif;
        int i = 0;
        clientes = getClientes();

        if (clientes.size()==0){
            return false;
        }
        else {
            do {
                _nif = clientes.get(i).getNif().toString();
                if (NIF.equals(_nif)) {
                    check = true;
                } else {
                    i++;
                }
            }
            while (!check && i != clientes.size());

            return check;
        }
    }

    public boolean checkTele(String Tele) {
        boolean check = false;
        String _tele;
        int i = 0;
        clientes = getClientes();

        if (clientes.size()==0){
            return false;
        }
        else {
            do {
                _tele = clientes.get(i).getTelemovel().toString();
                if (Tele.equals(_tele)) {
                    check = true;
                } else {
                    i++;
                }
            }
            while (!check && i != clientes.size());

            return check;
        }
    }
/** */

    public void AlterarUser(String username, String email, String telemovel, String password) {
        int i = 0;
        do{
            if(clientes.get(i).getUsername().equals(username));
            {
                clientes.get(i).setEmail(email);
                clientes.get(i).setTelemovel(telemovel);
                clientes.get(i).setPassword(password);
            }
        }while(i<clientes.size());
    }

    /**public void FiltrarLojasUser(){
        int i= 0;
        int ii=0;
        boolean check = false;
        do {
            if(ArrayListaLojas.size() == 0)
            {
                ArrayListaLojas.add(new ListLojas(fatura.get(i).getId_empresa(),empresa.get(fatura.get(i).getId_empresa()).getNome(), GetNumeroFaturasPorLojaCurrentUser(fatura.get(i).getId_empresa())));
                i++;
            }
            while(ii<ArrayListaLojas.size() )
            {
                if(ArrayListaLojas.get(ii).getNome() == empresa.get(fatura.get(i).getId_empresa()).getNome())
                {
                    check = true;
                }


                ii++;
            }
            if(check == false)
            {
                ArrayListaLojas.add(new ListLojas(fatura.get(i).getId_empresa(),empresa.get(fatura.get(i).getId_empresa()).getNome(), GetNumeroFaturasPorLojaCurrentUser(fatura.get(i).getId_empresa())));
            }
            ii=0;
            check = false;
            i++;
        }while(i<fatura.size());

    }
    public void FiltrarTaloesLoja(){
        int i = 0;
        int oke;
        int oke2;
        do{
            if( fatura.get(i).getId_empresa() == Integer.parseInt(LojaSelecionada))
            {
                oke = i + 1;
                oke2 = fatura.get(i).getNumero();
                arrayListLojaTaloes.add(new ListLojaTaloes(oke, oke2));
            }
            i++;
        }while(i<fatura.size());

    }*/

    public int getClientePosition(){
        int i = 0;
        while(i<clientes.size())
        {
            if(i==clientes.get(i).getNumero_cartao()) {
                return i;
            }
        }
        return 0;
    }

    public void adicionarCustomFaturaDB(Custom_Fatura custom_fatura){
        faturaDBHelper.adicionarCustomFaturaDB(custom_fatura);
    }

    public void removerCustomFaturaBD(int value) {

        if (custom_faturas.get(value) != null){
            if (faturaDBHelper.removerCustomFaturaBD(custom_faturas.get(value).getId())){
                custom_faturas.remove(value);
            }
        }

    }

    public void editarCustomFaturaBD(int value, Custom_Fatura custom_fatura){

        if (custom_faturas.get(value) != null){
            if (faturaDBHelper.guardarCustomFaturaBD(custom_fatura)){
                custom_fatura.setId(value);
                custom_faturas.add(value, custom_fatura);
            }
        }

    }

    public ArrayList getAllCustomFaturasDB(){
        custom_faturas = faturaDBHelper.getAllCustomFaturasBD();

        return custom_faturas;
    }

    public void adicionarClienteBD(Cliente cliente){
        faturaDBHelper.adicionarClienteBD(cliente);
    }

    public void adicionarClientesBD(ArrayList<Cliente> clientes)
    {
        for(Cliente cliente: clientes){
            adicionarClienteBD(cliente);
        }
    }

    public void getAllClientesAPI(final Context context, boolean isConnected){
        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, mUrlAPI, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                clientes = JsonParser.parserJsonClientes(response, context);
                System.out.println("--> Resposta" + response);

                adicionarClientesBD(clientes);

                if(listener != null){
                    listener.onRefreshCliente(clientes);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error Getalllivros " + error.getMessage());
            }
        });
        volleyQueue.add(req);


    }


/** PORQUE E Q ESTA AQUI UMA CONFIRMAÇÃO !? */
    public final static boolean isEmailValid(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
/** */

    public void setClientesListener(FaturasolListener listener){
        this.listener = listener;
    }

    @Override
    public void onRefreshFaturas(ArrayList<Fatura> listaFaturas) {

    }

    @Override
    public void onUpdateFaturas(Fatura fatura, int operação) {

    }

    @Override
    public void onRefreshCliente(ArrayList<Cliente> listaClientes) {

    }

    @Override
    public void onUpdateCliente(Cliente cliente, int operação) {

    }

    @Override
    public void onRefreshEmpresas(ArrayList<Empresa> listaEmpresas) {

    }

    @Override
    public void onUpdateEmpresas(Empresa empresa, int operação) {

    }
}
