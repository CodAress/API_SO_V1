package upc.edu.NerdyNestAPI.Inventario.service;

import upc.edu.NerdyNestAPI.Inventario.model.Cliente;

import java.util.List;

public interface ClienteService {
    public Cliente getClientById(Long id);
    public List<Cliente> getAllClients();
    public void updateClient(Long id, Cliente clientDetails);
    public Cliente saveClient(Cliente client);
    public void deleteClient(Long id);

}
