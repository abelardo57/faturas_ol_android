package amsi.dei.estg.ipleiria.pt.faturasol.listeners;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Cliente;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Empresa;
import amsi.dei.estg.ipleiria.pt.faturasol.Classes.Fatura;

/**
 * Created by Diogo on 31/01/2018.
 */

public interface FaturasolListener {

    void onRefreshFaturas(ArrayList<Fatura> listaFaturas);

    void onUpdateFaturas(Fatura fatura, int operação);

    void onRefreshCliente(ArrayList<Cliente> listaClientes);

    void onUpdateCliente(Cliente cliente, int operação);

    void onRefreshEmpresas(ArrayList<Empresa> listaEmpresas);

    void onUpdateEmpresas(Empresa empresa, int operação);


}
