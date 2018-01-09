package amsi.dei.estg.ipleiria.pt.faturasol.Classes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.time.format.FormatStyle.MEDIUM;

/**
 * Created by Abel_ on 09/01/2018.
 */

public class FaturaDBHelper extends SQLiteOpenHelper {

    private  final SQLiteDatabase database;

    public FaturaDBHelper(Context context, SQLiteDatabase database)
    {
        super(context, "faturasol", null, 1);
        this.database = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createFaturaTables = "CREATE TABLE `cliente` (\n" +
                "  `numero_cartao` int(10) NOT NULL,\n" +
                "  `nome` varchar(500) NOT NULL,\n" +
                "  `email` varchar(100) NOT NULL,\n" +
                "  `username` varchar(100) NOT NULL,\n" +
                "  `password_hash` varchar(255) NOT NULL,\n" +
                "  `telemovel` varchar(9) DEFAULT NULL,\n" +
                "  `nif` varchar(9) NOT NULL,\n" +
                "  `auth_key` varchar(32) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "CREATE TABLE `customfatura` (\n" +
                "  `id` int(10) NOT NULL,\n" +
                "  `numero` varchar(10) NOT NULL,\n" +
                "  `data` date NOT NULL,\n" +
                "  `nif_empresa` varchar(9) NOT NULL,\n" +
                "  `nome_empresa` varchar(100) NOT NULL,\n" +
                "  `morada_empresa` varchar(100) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "CREATE TABLE `custom_fatura_cliente` (\n" +
                "  `id_custom_faturas` int(10) NOT NULL,\n" +
                "  `numero_cartao_cliente` int(10) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "\n" +
                "CREATE TABLE `empresa` (\n" +
                "  `id` int(10) NOT NULL,\n" +
                "  `nome` varchar(100) NOT NULL,\n" +
                "  `nif` int(9) NOT NULL,\n" +
                "  `morada` varchar(500) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "CREATE TABLE `fatura` (\n" +
                "  `id` int(10) NOT NULL,\n" +
                "  `numero` int(100) NOT NULL,\n" +
                "  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `imagem_path` varchar(1024) DEFAULT NULL,\n" +
                "  `favorito` smallint(1) NOT NULL DEFAULT '0'\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "CREATE TABLE `fatura_cliente` (\n" +
                "  `id_fatura` int(10) NOT NULL,\n" +
                "  `numero_cartao_cliente` int(10) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "CREATE TABLE `fatura_empresa` (\n" +
                "  `id_fatura` int(10) NOT NULL,\n" +
                "  `id_empresa` int(10) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "CREATE TABLE `linha_fatura` (\n" +
                "  `id` int(10) NOT NULL,\n" +
                "  `valor_unitario` float NOT NULL,\n" +
                "  `quantidade` int(10) NOT NULL,\n" +
                "  `nome_produto` varchar(100) NOT NULL,\n" +
                "  `descricao` varchar(100) NOT NULL,\n" +
                "  `id_fatura` int(10) DEFAULT NULL,\n" +
                "  `id_custom_fatura` int(10) DEFAULT NULL,\n" +
                "  `valor_total` float DEFAULT '0'\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "\n" +
                "CREATE TRIGGER `valor_total_final` BEFORE INSERT ON `linha_fatura` FOR EACH ROW BEGIN\n" +
                "    SET NEW.valor_total = NEW.valor_unitario*NEW.quantidade;          \n" +
                "END\n" +
                "\n" +
                "\n" +
                "CREATE TABLE `user` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,\n" +
                "  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,\n" +
                "  `auth_key` varchar(32) COLLATE utf8_unicode_ci NOT NULL,\n" +
                "  `password_hash` varchar(255) COLLATE utf8_unicode_ci NOT NULL,\n" +
                "  `password_reset_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,\n" +
                "  `status` smallint(6) NOT NULL DEFAULT '10',\n" +
                "  `created_at` int(11) NOT NULL,\n" +
                "  `updated_at` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;\n" +
                "\n" +
                "CREATE TABLE `migration` (\n" +
                "  `version` varchar(180) NOT NULL,\n" +
                "  `apply_time` int(11) DEFAULT NULL\n" +
                ") ENGINE=MyISAM DEFAULT CHARSET=latin1;\n" +
                "\n" +
                "INSERT INTO `migration` (`version`, `apply_time`) VALUES\n" +
                "('m000000_000000_base', 1510673971),\n" +
                "('m130524_201442_init', 1510673978);\n" +
                "\n" +
                "ALTER TABLE `cliente`\n" +
                "  ADD PRIMARY KEY (`numero_cartao`);\n" +
                "\n" +
                "ALTER TABLE `customfatura`\n" +
                "  ADD PRIMARY KEY (`id`);\n" +
                "\n" +
                "ALTER TABLE `custom_fatura_cliente`\n" +
                "  ADD KEY `id_custom_faturas` (`id_custom_faturas`),\n" +
                "  ADD KEY `numero_cartao_cliente` (`numero_cartao_cliente`);\n" +
                "\n" +
                "ALTER TABLE `empresa`\n" +
                "  ADD PRIMARY KEY (`id`);\n" +
                "\n" +
                "ALTER TABLE `fatura`\n" +
                "  ADD PRIMARY KEY (`id`);\n" +
                "\n" +
                "ALTER TABLE `fatura_cliente`\n" +
                "  ADD KEY `id_fatura` (`id_fatura`),\n" +
                "  ADD KEY `numero_cartao_cliente` (`numero_cartao_cliente`);\n" +
                "\n" +
                "ALTER TABLE `fatura_empresa`\n" +
                "  ADD KEY `id_fatura` (`id_fatura`),\n" +
                "  ADD KEY `id_empresa` (`id_empresa`);\n" +
                "\n" +
                "ALTER TABLE `linha_fatura`\n" +
                "  ADD PRIMARY KEY (`id`),\n" +
                "  ADD KEY `id_fatura` (`id_fatura`),\n" +
                "  ADD KEY `id_custom_fatura` (`id_custom_fatura`);\n" +
                "\n" +
                "ALTER TABLE `migration`\n" +
                "  ADD PRIMARY KEY (`version`);\n" +
                "\n" +
                "ALTER TABLE `user`\n" +
                "  ADD PRIMARY KEY (`id`),\n" +
                "  ADD UNIQUE KEY `username` (`username`),\n" +
                "  ADD UNIQUE KEY `email` (`email`),\n" +
                "  ADD UNIQUE KEY `password_reset_token` (`password_reset_token`);\n" +
                "\n" +
                "ALTER TABLE `cliente`\n" +
                "  MODIFY `numero_cartao` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `customfatura`\n" +
                "  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `empresa`\n" +
                "  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `fatura`\n" +
                "  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `linha_fatura`\n" +
                "  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `user`\n" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `custom_fatura_cliente`\n" +
                "  ADD CONSTRAINT `custom_fatura_cliente_ibfk_1` FOREIGN KEY (`id_custom_faturas`) REFERENCES `customfatura` (`id`),\n" +
                "  ADD CONSTRAINT `custom_fatura_cliente_ibfk_2` FOREIGN KEY (`numero_cartao_cliente`) REFERENCES `cliente` (`numero_cartao`);\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `fatura_cliente`\n" +
                "  ADD CONSTRAINT `fatura_cliente_ibfk_1` FOREIGN KEY (`id_fatura`) REFERENCES `fatura` (`id`),\n" +
                "  ADD CONSTRAINT `fatura_cliente_ibfk_2` FOREIGN KEY (`numero_cartao_cliente`) REFERENCES `cliente` (`numero_cartao`);\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `fatura_empresa`\n" +
                "  ADD CONSTRAINT `fatura_empresa_ibfk_1` FOREIGN KEY (`id_fatura`) REFERENCES `fatura` (`id`),\n" +
                "  ADD CONSTRAINT `fatura_empresa_ibfk_2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`);\n" +
                "\n" +
                "\n" +
                "\n" +
                "ALTER TABLE `linha_fatura`\n" +
                "  ADD CONSTRAINT `linha_fatura_ibfk_1` FOREIGN KEY (`id_fatura`) REFERENCES `fatura` (`id`),\n" +
                "  ADD CONSTRAINT `linha_fatura_ibfk_2` FOREIGN KEY (`id_custom_fatura`) REFERENCES `customfatura` (`id`);\n";
                db.execSQL(createFaturaTables);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "";
        db.execSQL(sql);
        this.onCreate(db);
    }



    public ArrayList<Cliente> getAllClientesBD(){

        ArrayList<Cliente> cliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        Cursor cursor = this.database.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Cliente auxCliente = new Cliente(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getString(7));

                auxCliente.setNumero_cartao(cursor.getInt(0));
                cliente.add(auxCliente);
            }while(cursor.moveToNext());
        }
        return cliente;

    }

    public ArrayList<Custom_Fatura> getAllCustomFaturasBD(){


        Date date = new Date(); //or new Date(long millis);
        Long millis = date.getTime();
        date.setTime(millis); //for now, use: System.currentTimeMillis()




        ArrayList<Custom_Fatura> customfatura = new ArrayList<>();
        String sql = "SELECT * FROM customfatura";
        Cursor cursor = this.database.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Custom_Fatura auxCustomFatura = new Custom_Fatura(cursor.getInt(0),
                        cursor.getInt(1),
                        date = new Date(cursor.getLong(2)*1000),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5));

                auxCustomFatura.setId(cursor.getInt(0));
                customfatura.add(auxCustomFatura);
            }while(cursor.moveToNext());
        }
        return customfatura;

    }


    public ArrayList<Custom_Fatura_Cliente> getAllClientesBD(){

        ArrayList<Custom_Fatura_Cliente> customfaturacliente = new ArrayList<>();
        String sql = "SELECT * FROM id_custom_fatura";
        Cursor cursor = this.database.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                Cliente auxCliente = new Cliente(cursor.getInt(0),
                        cursor.getString(1),


                auxCustomFaturaCliente.setNumero_cartao(cursor.getInt(0));
                cliente.add(auxCliente);
            }while(cursor.moveToNext());
        }
        return cliente;

    }

}



