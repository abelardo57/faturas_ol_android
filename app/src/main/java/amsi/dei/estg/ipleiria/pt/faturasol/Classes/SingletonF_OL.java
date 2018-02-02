package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

import android.content.ContentValues;
import android.content.Context;
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


    public void GerarClientes(){
        clientes.add(new Cliente ( 10000000, "Rodrigo Paião", "RodriP@gmail.com", "RodriP22", "123456", "39219383", "293857261","autkey")  );
        clientes.add(new Cliente ( 10000001, "Catarina Sales", "CataSal@gmail.com", "CataS", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000002, "Miguel Faria", "FariaM@gmail.com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000003, "João Oliveira", "Joliveira@gmail.com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000004, "Luís Tiago", "LiagoTuis@gmail.com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000005, "Joana Mateus", "JoanaM@gmail.com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
        clientes.add(new Cliente ( 10000006, "Rodrigo Araujo", "AraujoRRDigo@gmail .com", "RodriP22", "123456", "39219383", "293857261", "authkey")  );
    }
    public void GerarEmpresa (){

        empresa.add(new Empresa( 0, "Faturas User", 339293823, "Avenida do Brazil"));
        empresa.add(new Empresa( 1, "Jumbo", 383827183, "Praça do Mandarim"));
        empresa.add(new Empresa( 2, "Pingo Doce", 458828353, "Rua dos Prados Brancos"));
        empresa.add(new Empresa( 3, "Radio Popular", 990381290, "Praça D'ouro"));

    }
    /*public void GerarFaturas() {
        fatura.add(new Fatura (0, 10001, currentTime,"",1));
        fatura.add(new Fatura (0, 10001, currentTime,"",1));
        fatura.add(new Fatura (0, 10001, currentTime,"",1));
        fatura.add(new Fatura (0, 10001, currentTime,"",1));
        fatura.add(new Fatura (0, 10001, currentTime,"",1));
        fatura.add(new Fatura (0, 10001, currentTime,"",1));
    }*/

    public void registarClienteBD(Cliente cliente){
        faturaDBHelper.adicionarClienteBD(cliente);
    }

    public void adicionarFaturasDefinitivasBD(ArrayList<Fatura> faturas){

        for (Fatura fatura: faturas) {
            faturaDBHelper.adicionarFaturaDB(fatura);

            adicionarFaturaClienteBD(fatura);

            adicionarFaturaEmpresa(fatura);
        }

        /** adicionar relação fatura_cliente*/

        /** adicionar relação fatura_empresa*/

    }

    public void adicionarFaturaClienteBD(Fatura fatura){
        // TODO: 02/02/2018 foreach fatura get id --> set id_fatura = fatura.id e numero_cartao_cliente = cliente.numero_cartao; i++
        long id_fatura = fatura.getId();
    }

    public void adicionarFaturaEmpresa(Fatura fatura){
        // TODO: 02/02/2018 foreach fatura get id --> set id_fatura = fatura.id e id_empresa = empresa.id; i++
    }




    public ArrayList<Cliente> getClientes(){
        return faturaDBHelper.getAllClientesBD();
    }
    public ArrayList getEmpresa(){
        return empresa;
    }
    public ArrayList getFatura() {
        return fatura;
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

    public boolean CheckUser(String Username, String Password) {
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
                i = clientes.size();
            }
            else{
                i++;
            }

        }
        while(i != clientes.size());
        
        return check;
    }

    public void AlterarUser(String username, String email, String telemovel, String password)
    {
        int i = 0;
        do{
            if(clientes.get(i).getUsername().equals(username));
            {
                clientes.get(i).setEmail(email);
                clientes.get(i).setTelemovel(telemovel);
                clientes.get(i).setPassword(email);
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


    public final static boolean isEmailValid(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

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
