package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

//import static java.time.format.FormatStyle.MEDIUM;

/**
 * Created by Abel_ on 09/01/2018.
 */

 public class FaturaDBHelper extends SQLiteOpenHelper {

    private  final SQLiteDatabase database;

    //CLIENTE

    /*private static final String NUMERO_CARTAO ="numero_cartao";
    private static final String NUMERO_CARTAO ="numero_cartao";
    private static final String NUMERO_CARTAO ="numero_cartao";
    private static final String NUMERO_CARTAO ="numero_cartao";
    private static final String NUMERO_CARTAO ="numero_cartao";*/



    public FaturaDBHelper(Context context)
    {
        super(context, "faturasol", null, 1);
        this.database = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createFaturaTables = "CREATE TABLE cliente (" +
                "  numero_cartao INTEGER PRYMARY KEY AUTOINCREMENT,"+
                "  nome TEXT NOT NULL," +
                "  email TEXT NOT NULL," +
                "  username TEXT NOT NULL," +
                "  password_hash TEXT NOT NULL," +
                "  telemovel TEXT DEFAULT NULL," +
                "  nif TEXT NOT NULL," +
                "  auth_key TEXT NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE customfatura (" +
                "  id INTEGER NOT NULL PRYMARY KEY AUTOINCREMENT," +
                "  numero TEXT NOT NULL," +
                "  data date NOT NULL," +
                "  nif_empresa TEXT NOT NULL," +
                "  nome_empresa TEXT NOT NULL," +
                "  morada_empresa TEXT NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE custom_fatura_cliente (" +
                "  id INTEGER AUTOINCREMENT PRIMARY KEY,"+
                "  id_custom_faturas INTEGER NOT NULL," +
                "  numero_cartao_cliente INTEGER NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE empresa (" +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "  nome TEXT NOT NULL," +
                "  nif TEXT NOT NULL," +
                "  morada TEXT NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE fatura (" +
                "  id INTEGER NOT NULL," +
                "  numero TEXT NOT NULL," +
                "  data DATE NOT NULL," +
                "  imagem_path TEXT DEFAULT NULL," +
                "  favorito INTEGER NOT NULL DEFAULT '0'" +
                ");" +
                "" +
                "CREATE TABLE fatura_cliente (" +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,"+
                "  id_fatura INTEGER NOT NULL," +
                "  numero_cartao_cliente INTEGER NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE fatura_empresa (" +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                "  id_fatura INTEGER NOT NULL," +
                "  id_empresa INTEGER NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE linha_fatura (" +
                "  id INTEGER NOT NULL PRYMARY KEY AUTOINCREMENT," +
                "  valor_unitario FLOAT NOT NULL," +
                "  quantidade INTEGER NOT NULL," +
                "  nome_produto TEXT NOT NULL," +
                "  descricao TEXT NOT NULL," +
                "  id_fatura INTEGER DEFAULT NULL," +
                "  id_custom_fatura INTEGER DEFAULT NULL," +
                "  valor_total FLOAT DEFAULT '0'" +
                ");" +
                "" +
                "CREATE TRIGGER valor_total_final BEFORE INSERT ON linha_fatura FOR EACH ROW BEGIN" +
                "    SET NEW.valor_total = NEW.valor_unitario*NEW.quantidade;" +
                "END" +
                "" +
                "CREATE TABLE user (" +
                "  id INTEGER NOT NULL," +
                "  name TEXT COLLATE utf8_unicode_ci NOT NULL," +
                "  username TEXT COLLATE utf8_unicode_ci NOT NULL," +
                "  auth_key TEXT COLLATE utf8_unicode_ci NOT NULL," +
                "  password_hash TEXT COLLATE utf8_unicode_ci NOT NULL," +
                "  password_reset_token TEXT COLLATE utf8_unicode_ci DEFAULT NULL," +
                "  email TEXT COLLATE utf8_unicode_ci NOT NULL," +
                "  status INTEGER NOT NULL DEFAULT '10'," +
                "  created_at INTEGER NOT NULL," +
                "  updated_at INTEGER NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE `migration` (" +
                "  `version` varchar(180) NOT NULL," +
                "  `apply_time` int(11) DEFAULT NULL" +
                ") ENGINE=MyISAM DEFAULT CHARSET=latin1;" +
                "" +
                "INSERT INTO `migration` (`version`, `apply_time`) VALUES" +
                "('m000000_000000_base', 1510673971)," +
                "('m130524_201442_init', 1510673978);" +
                "" +
                "ALTER TABLE cliente" +
                "  ADD PRIMARY KEY (numero_cartao);" +
                "" +
                "ALTER TABLE `customfatura`" +
                "  ADD PRIMARY KEY (`id`);" +
                "" +
                "ALTER TABLE `custom_fatura_cliente`" +
                "  ADD KEY `id_custom_faturas` (`id_custom_faturas`)," +
                "  ADD KEY `numero_cartao_cliente` (`numero_cartao_cliente`);" +
                "" +
                "ALTER TABLE `empresa`" +
                "  ADD PRIMARY KEY (`id`);" +
                "" +
                "ALTER TABLE `fatura`" +
                "  ADD PRIMARY KEY (`id`);" +
                "" +
                "ALTER TABLE `fatura_cliente`" +
                "  ADD KEY `id_fatura` (`id_fatura`)," +
                "  ADD KEY `numero_cartao_cliente` (`numero_cartao_cliente`);" +
                "" +
                "ALTER TABLE `fatura_empresa`" +
                "  ADD KEY `id_fatura` (`id_fatura`)," +
                "  ADD KEY `id_empresa` (`id_empresa`);" +
                "" +
                "ALTER TABLE `linha_fatura`" +
                "  ADD PRIMARY KEY (`id`)," +
                "  ADD KEY `id_fatura` (`id_fatura`)," +
                "  ADD KEY `id_custom_fatura` (`id_custom_fatura`);" +
                "" +
                "ALTER TABLE `migration`" +
                "  ADD PRIMARY KEY (`version`);" +
                "" +
                "ALTER TABLE `user`" +
                "  ADD PRIMARY KEY (`id`)," +
                "  ADD UNIQUE KEY `username` (`username`)," +
                "  ADD UNIQUE KEY `email` (`email`)," +
                "  ADD UNIQUE KEY `password_reset_token` (`password_reset_token`);" +
                "" +
                "ALTER TABLE `cliente`" +
                "  MODIFY `numero_cartao` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;" +
                "" +
                "ALTER TABLE `customfatura`" +
                "  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;" +
                "" +
                "ALTER TABLE `empresa`" +
                "  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;" +
                "" +
                "ALTER TABLE `fatura`" +
                "  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;" +
                "" +
                "ALTER TABLE `linha_fatura`" +
                "  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;" +
                "" +
                "ALTER TABLE `user`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;" +
                "" +
                "ALTER TABLE `fatura_empresa`" +
                "  ADD CONSTRAINT `fatura_empresa_ibfk_1` FOREIGN KEY (`id_fatura`) REFERENCES `fatura` (`id`)," +
                "  ADD CONSTRAINT `fatura_empresa_ibfk_2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`);" +
                "" +
                "ALTER TABLE `linha_fatura`" +
                "  ADD CONSTRAINT `linha_fatura_ibfk_1` FOREIGN KEY (`id_fatura`) REFERENCES `fatura` (`id`)," +
                "  ADD CONSTRAINT `linha_fatura_ibfk_2` FOREIGN KEY (`id_custom_fatura`) REFERENCES `customfatura` (`id`);";

        db.execSQL(createFaturaTables);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP DATABASE faturasol";
        db.execSQL(sql);
        this.onCreate(db);
    }


    public Cliente adicionarClienteBD(Cliente cliente){

        ContentValues value = new ContentValues();

        value.put("numero_cartao", cliente.getNumero_cartao());
        value.put("nome", cliente.getNome());
        value.put("email", cliente.getEmail());
        value.put("username", cliente.getUsername());
        value.put("password_hash", cliente.getPassword());
        value.put("telemovel", cliente.getTelemovel());
        value.put("nif", cliente.getNif());
        value.put("auth_key", cliente.getAuthkey());
        long numero_cartao = this.database.insert("cliente", null, value);
        if (numero_cartao > -1){
            System.out.println("--> INSERIU BD ID: " + numero_cartao);
            cliente.setNumero_cartao(numero_cartao);
            return cliente;
        }

        return null;
    }

    public Fatura adiconarFaturaDB(Fatura fatura){
        ContentValues value = new ContentValues();

        value.put("numero", fatura.getNumero());
        value.put("data", String.valueOf(fatura.getData()));
        value.put("numero_cartao", fatura.getNumero_cartao());
        value.put("id_empresa", fatura.getId_empresa());
        value.put("is_fav", fatura.getIs_fav());
        long id = this.database.insert("fatura", null, value);
        if (id > -1){
            System.out.println("--> INSERIU BD ID: " + id);
            fatura.setId(id);
            return fatura;
        }

        return null;
    }

    public Custom_Fatura adicionarCustomFaturaDB(Custom_Fatura custom_fatura){
        ContentValues value = new ContentValues();

        value.put("numero", custom_fatura.getNumero());
        value.put("data", String.valueOf(custom_fatura.getData()));
        value.put("nome_empresa", custom_fatura.getNome_empresa());
        value.put("nif_empresa", custom_fatura.getNif_empresa());
        value.put("morada_empresa", custom_fatura.getMorada_empresa());
        long id = this.database.insert("customfatura", null, value);
        if (id > -1){
            System.out.println("--> INSERIU BD ID: " + id);
            custom_fatura.setId(id);
            return custom_fatura;
        }

        return null;
    }

    public ArrayList<Cliente> getAllClientesBD(){

        ArrayList<Cliente> cliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        Cursor cursor = this.database.rawQuery("SELECT * FROM cliente", null);
        if(cursor.moveToFirst()){
            do{
                Cliente auxCliente = new Cliente(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7));

                auxCliente.setNumero_cartao(cursor.getLong(0));
                /*auxCliente.setNome(cursor.getString(1));
                auxCliente.setEmail(cursor.getString(2));
                auxCliente.setUsername(cursor.getString(3));
                auxCliente.setPassword(cursor.getString(4));
                auxCliente.setTelemovel(cursor.getInt(5));
                auxCliente.setNif(cursor.getInt(6));
                auxCliente.setAuthkey(cursor.getString(7));*/
                cliente.add(auxCliente);
            }while(cursor.moveToNext());
        }
        return cliente;

    }

    public ArrayList<Custom_Fatura> getAllCustomFaturasBD(){

        ArrayList<Custom_Fatura> customfatura = new ArrayList<>();
        String sql = "SELECT * FROM customfatura";
        Cursor cursor = this.database.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Custom_Fatura auxCustomFatura = new Custom_Fatura(cursor.getInt(0),
                        cursor.getInt(1),
                        new Date(cursor.getLong(2)),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5));


                auxCustomFatura.setId(cursor.getInt(0));
                /*auxCustomFatura.setNumero(cursor.getInt(1));
                auxCustomFatura.setData(2);
                customfatura.add(auxCustomFatura);*/
            }while(cursor.moveToNext());
        }
        return customfatura;

    }

    public ArrayList<Custom_Fatura_Cliente> getAllCustomFaturasClientesBD(){

        ArrayList<Custom_Fatura_Cliente> customfaturacliente = new ArrayList<>();
        String sql = "SELECT * FROM custom_fatura_cliente";
        Cursor cursor = this.database.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Custom_Fatura_Cliente auxCustomFaturaCliente = new Custom_Fatura_Cliente(cursor.getInt(0),
                        cursor.getInt(1));

                auxCustomFaturaCliente.setId_custom_faturas(cursor.getInt(0));
                auxCustomFaturaCliente.setNumero_cartao_cliente(cursor.getInt(1));
                customfaturacliente.add(auxCustomFaturaCliente);
            }while(cursor.moveToNext());
        }
        return customfaturacliente;

    }

    public ArrayList<Empresa> getAllEmpresasBD(){
        ArrayList<Empresa> empresa = new ArrayList<>();
        String sql = "SELECT * FROM empresa";
        Cursor cursor = this.database.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Empresa auxEmpresa = new Empresa(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3));
                auxEmpresa.setId(cursor.getInt(0));
                empresa.add(auxEmpresa);
            }while(cursor.moveToNext());
        }
        return empresa;
    }

    public ArrayList<Fatura> getAllFaturasBD(){
        ArrayList<Fatura> fatura = new ArrayList<>();
        String sql = "SELECT * FROM fatura";
        Cursor cursor = this.database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Fatura auxFatura = new Fatura(cursor.getInt(0),
                        cursor.getInt(1),
                        new Date(cursor.getLong(2)*1000),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5));
                auxFatura.setId(cursor.getInt(0));
                fatura.add(auxFatura);
            }while(cursor.moveToNext());
        }
        return fatura;
    }

    public ArrayList<Linha_Fatura> getAllLinhaFaturasBD(){
        ArrayList<Linha_Fatura> linhafatura = new ArrayList<>();
        String sql = "SELECT * FROM fatura";
        Cursor cursor = this.database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Linha_Fatura auxLinhaFatura = new Linha_Fatura(cursor.getInt(0),
                        cursor.getFloat(1),
                        cursor.getString(2),
                        cursor.getString( 3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getFloat(6));
                auxLinhaFatura.setId(cursor.getInt(0));
                linhafatura.add(auxLinhaFatura);
            }while(cursor.moveToNext());
        }
        return linhafatura;
    }

    public ArrayList<Fatura_Empresa> getAllFaturasEmpresaBD(){

        ArrayList<Fatura_Empresa> faturaempresa = new ArrayList<>();
        String sql = "SELECT * FROM fatura";
        Cursor cursor = this.database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Fatura_Empresa auxFaturaEmpresa = new Fatura_Empresa(cursor.getInt(0),
                        cursor.getInt(1));
                auxFaturaEmpresa.setId_fatura(cursor.getInt(0));
                faturaempresa.add(auxFaturaEmpresa);

            }while(cursor.moveToNext());
        }
        return faturaempresa;
    }

    public ArrayList<Fatura_Cliente> getAllFaturasClientesBD(){
        ArrayList<Fatura_Cliente> faturacliente = new ArrayList<>();
        String sql = "SELECT * FROM fatura_cliente";
        Cursor cursor = this.database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Fatura_Cliente auxFaturaCliente = new Fatura_Cliente(cursor.getInt(0),
                        cursor.getInt(1));
                auxFaturaCliente.setId_fatura(cursor.getInt(0));
                faturacliente.add((auxFaturaCliente));
            }while(cursor.moveToNext());
        }
        return faturacliente;
    }

    public boolean guardarClienteBD(Cliente cliente){
        ContentValues value = new ContentValues();

        value.put("numero_cartao", cliente.getNumero_cartao());
        value.put("nome", cliente.getNome());
        value.put("email", cliente.getEmail());
        value.put("username", cliente.getUsername());
        value.put("password", cliente.getPassword());
        value.put("telemovel", cliente.getTelemovel());
        value.put("nif", cliente.getNif());
        value.put("auth_key", cliente.getAuthkey());

        return this.database.update("cliente", value, "id = ?", new String[]{"" + cliente.getNumero_cartao()}) > 0;

    }

    public boolean guardarFaturaBD(Fatura fatura){
        ContentValues value = new ContentValues();

        value.put("numero", fatura.getNumero());
        value.put("data", String.valueOf(fatura.getData()));
        value.put("numero_cartao", fatura.getNumero_cartao());
        value.put("id_empresa", fatura.getId_empresa());
        value.put("is_fav", fatura.getIs_fav());

        return this.database.update("fatura", value, "id = ?", new String[]{"" + fatura.getId()}) > 0;

    }

    public boolean guardarCustomFaturaBD(Custom_Fatura custom_fatura){
        ContentValues values = new ContentValues();

        values.put("numero", custom_fatura.getNumero());
        values.put("data", String.valueOf(custom_fatura.getData()));
        values.put("nome_empresa", custom_fatura.getNome_empresa());
        values.put("nif_empresa", custom_fatura.getNif_empresa());
        values.put("morada_empresa", custom_fatura.getMorada_empresa());

        return  this.database.update("customfatura", values, "id= ?", new String[]{""+custom_fatura.getId()}) > 0;
    }

    public boolean removerClienteBD(long NumeroCartaoCliente){
        return (this.database.delete("cliente","id = ?", new String[]{"" + NumeroCartaoCliente}) > 0);
    }

    public boolean removerFaturaBD(long idFatura){
        return (this.database.delete("fatura","id = ?", new String[]{"" + idFatura}) > 0);
    }

    public boolean removerCustomFaturaBD(long idCustomFatura){
        return (this.database.delete("customfatura","id= ?", new String[]{"" + idCustomFatura}) > 0);
    }

    public void removerAllClientesBD() {
        this.database.delete("cliente", null,null);
    }

    public void removerAllFaturasBD() {
        this.database.delete("fatura", null,null);
    }

    public void removerAllCustomFaturasBD() {
        this.database.delete("customfatura", null,null);
    }

    public void removerAllEmpresasBD() {
        this.database.delete("empresa", null,null);
    }

    public void removerAllLinhasFaturaBD() {
        this.database.delete("linhafatura", null,null);
    }
}



