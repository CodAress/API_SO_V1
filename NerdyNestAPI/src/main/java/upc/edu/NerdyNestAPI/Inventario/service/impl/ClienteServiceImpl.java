package upc.edu.NerdyNestAPI.Inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.NerdyNestAPI.Inventario.model.Cliente;
import upc.edu.NerdyNestAPI.Inventario.repository.ClienteRepository;
import upc.edu.NerdyNestAPI.Inventario.service.ClienteService;
import upc.edu.NerdyNestAPI.shared.exception.ValidationException;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente getClientById(Long id) {
        return clienteRepository.findById(id).
                orElseThrow(()->new ValidationException("Cliente with id " + id + "not found"));
    }

    @Override
    public List<Cliente> getAllClients() {
        List<Cliente> allClients = clienteRepository.findAll();
        if(allClients.isEmpty())
        {
            allClients = null;
            throw new ValidationException("Unregistered clients");
        }
        return allClients;
    }

    @Override
    public void updateClient(Long id, Cliente clientDetails) {
        Cliente existingClient = clienteRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Client with id " + id + " not found"));
        updateClientFields(existingClient, clientDetails);
        validateClientRegister(clientDetails);
        clienteRepository.save(existingClient);
    }

    private void updateClientFields(Cliente existingClient, Cliente clientDetails) {
        existingClient.setNombre(clientDetails.getNombre() != null ? clientDetails.getNombre() : existingClient.getNombre());
        existingClient.setApellido(clientDetails.getApellido() != null ? clientDetails.getApellido() : existingClient.getApellido());
        existingClient.setCorreo(clientDetails.getCorreo() != null ? clientDetails.getCorreo() : existingClient.getCorreo());
        existingClient.setTelefono(clientDetails.getTelefono() != null ? clientDetails.getTelefono() : existingClient.getTelefono());
        existingClient.setDireccion(clientDetails.getDireccion() != null ? clientDetails.getDireccion() : existingClient.getDireccion());
        existingClient.setCodigoPostal(clientDetails.getCodigoPostal() != null ? clientDetails.getCodigoPostal() : existingClient.getCodigoPostal());
        existingClient.setDni(clientDetails.getDni() != null ? clientDetails.getDni() : existingClient.getDni());
    }

    @Override
    public Cliente saveClient(Cliente cliente) {
        validateClientRegister(cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteClient(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Client with id " + id + " not found"));
        clienteRepository.delete(cliente);
    }

    private void validateClientRegister(Cliente cliente) {
        if(cliente.getNombre() == null || cliente.getNombre().isEmpty())
            throw new ValidationException("Name is required");
        if(cliente.getApellido() == null || cliente.getApellido().isEmpty())
            throw new ValidationException("Last name is required");
        if(cliente.getCorreo() == null || cliente.getCorreo().isEmpty())
            throw new ValidationException("Email is required");
        if(cliente.getTelefono() == null || cliente.getTelefono().isEmpty())
            throw new ValidationException("Phone is required");
        if(cliente.getDireccion() == null || cliente.getDireccion().isEmpty())
            throw new ValidationException("Address is required");
        if(cliente.getCodigoPostal()== null || cliente.getCodigoPostal().isEmpty())
            throw new ValidationException("Postal code is required");
        if(cliente.getDni() == null || cliente.getDni().isEmpty())
            throw new ValidationException("DNI is required");
    }

}
