package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

import android.content.Context;
import android.text.method.DateTimeKeyListener;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import amsi.dei.estg.ipleiria.pt.faturasol.AdicionarFatura;

/**
 * Created by Abel_ on 17/11/2017.
 */

public class SingletonF_OL {
    private static SingletonF_OL ourInstance = null;


    private FaturaDBHelper faturaDBHelper = null;
    public ArrayList<Cliente> cliente = new ArrayList<Cliente>();
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


    public static synchronized SingletonF_OL getInstance(Context context) {
        if (ourInstance == null)
        {
            ourInstance = new SingletonF_OL(context);
        }
        return ourInstance;
    }


    private SingletonF_OL(Context context) { GerarClientes(); GerarEmpresa();}


    public void GerarClientes(){
        cliente.add(new Cliente ( 10000000, "Rodrigo Paião", "RodriP@gmail.com", "RodriP22", "123456", 39219383, 293857261,"autkey")  );
        cliente.add(new Cliente ( 10000001, "Catarina Sales", "CataSal@gmail.com", "CataS", "123456", 39219383, 293857261, "authkey")  );
        cliente.add(new Cliente ( 10000002, "Miguel Faria", "FariaM@gmail.com", "RodriP22", "123456", 39219383, 293857261, "authkey")  );
        cliente.add(new Cliente ( 10000003, "João Oliveira", "Joliveira@gmail.com", "RodriP22", "123456", 39219383, 293857261, "authkey")  );
        cliente.add(new Cliente ( 10000004, "Luís Tiago", "LiagoTuis@gmail.com", "RodriP22", "123456", 39219383, 293857261, "authkey")  );
        cliente.add(new Cliente ( 10000005, "Joana Mateus", "JoanaM@gmail.com", "RodriP22", "123456", 39219383, 293857261, "authkey")  );
        cliente.add(new Cliente ( 10000006, "Rodrigo Araujo", "AraujoRRDigo@gmail .com", "RodriP22", "123456", 39219383, 293857261, "authkey")  );
    }
    public void GerarEmpresa (){

        empresa.add(new Empresa( 0, "Faturas User", 339293823, "Avenida do Brazil"));
        empresa.add(new Empresa( 1, "Jumbo", 383827183, "Praça do Mandarim"));
        empresa.add(new Empresa( 2, "Pingo Doce", 458828353, "Rua dos Prados Brancos"));
        empresa.add(new Empresa( 3, "Radio Popular", 990381290, "Praça D'ouro"));

    }
    public void GerarFaturas() {
        fatura.add(new Fatura (0, 10001, currentTime,10000000,1,0));
        fatura.add(new Fatura (1, 10002, currentTime,10000000,1,0));
        fatura.add(new Fatura (2, 10003, currentTime,10000000,2,0));
        fatura.add(new Fatura (3, 10004, currentTime,10000000,2,0));
        fatura.add(new Fatura (4, 10005, currentTime,10000000,3,0));
        fatura.add(new Fatura (5, 10006, currentTime,10000000,3,0));
        fatura.add(new Fatura (6, 10007, currentTime,10000000,2,0));
        fatura.add(new Fatura (7, 10008, currentTime,10000000,2,0));
        fatura.add(new Fatura (8, 10009, currentTime,10000000,1,0));
        fatura.add(new Fatura (9, 10010, currentTime,10000000,1,0));
        fatura.add(new Fatura (10, 10011, currentTime,10000000,2,0));
        fatura.add(new Fatura (11, 10012, currentTime,10000000,0,0));
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
    public void NovaFatura(String numero, String numero_cartao){

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




    }

    public int GetNumeroFaturasPorLojaCurrentUser(int IdEmpresa){
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
    }

    public ArrayList getClientes(){
        return cliente;
    }
    public ArrayList getEmpresa(){
        return empresa;
    }
    public ArrayList getFatura() { return fatura; }

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

    public boolean CheckUser(String Email, String Password) {
        boolean check = false;
        String email;
        String password;
        int i = 0;
        do{
            email = cliente.get(i).getEmail().toString();
            password =  cliente.get(i).getPassword().toString();
            if(Email.equals(email) && Password.equals(password))
            {
                check = true;
                CurrentUser = (int) cliente.get(i).getNumero_cartao();
                CurrentUsername = cliente.get(i).getUsername();
                i = cliente.size();
            }
            else{
                i++;
            }

        }
        while(i != cliente.size());
        
        return check;
    }

    public void AlterarUser(String username, String email, int telemovel, String password)
    {
        int i = 0;
        do{
            if(cliente.get(i).getUsername().equals(username));
            {
                cliente.get(i).setEmail(email);
                cliente.get(i).setTelemovel(telemovel);
                cliente.get(i).setPassword(email);
            }
        }while(i<cliente.size());
    }

    public void FiltrarLojasUser(){
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

    }
    public int getClientePosition(){
        int i = 0;
        while(i<cliente.size())
        {
            if(i==cliente.get(i).getNumero_cartao()) {
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
}
