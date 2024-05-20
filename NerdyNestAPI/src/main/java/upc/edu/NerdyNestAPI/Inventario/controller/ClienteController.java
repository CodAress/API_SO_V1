package upc.edu.NerdyNestAPI.Inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import upc.edu.NerdyNestAPI.Inventario.dto.ClienteRequest;
import upc.edu.NerdyNestAPI.Inventario.dto.ClienteResponse;
import upc.edu.NerdyNestAPI.Inventario.dto.mapper.ClienteMapper;
import upc.edu.NerdyNestAPI.Inventario.service.ClienteService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Transactional
    @PostMapping("/cliente")
    public ResponseEntity<ClienteResponse> createCliente(@RequestBody ClienteRequest clienteRequest) {
       var cliente = ClienteMapper.INSTANCE.clienteRequestToCliente(clienteRequest);
       var clienteResponse = ClienteMapper.INSTANCE.clienteToClienteResponse(clienteService.saveClient(cliente));
        return new ResponseEntity<ClienteResponse>(clienteResponse, HttpStatus.CREATED);
    }

    @Transactional
    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteResponse> getClienteById(@PathVariable(value = "id") Long clienteId) {
        var clienteResponse = ClienteMapper.INSTANCE.clienteToClienteResponse(clienteService.getClientById(clienteId));
        return new ResponseEntity<ClienteResponse>(clienteResponse, HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponse>> getAllClientes() {
        var clientesResponse = ClienteMapper.INSTANCE.clienteListToClienteResponseList(clienteService.getAllClients());
        return new ResponseEntity<List<ClienteResponse>>(clientesResponse, HttpStatus.OK);
    }

    /*
    @Transactional
    @PutMapping("/cliente/{id}")
    public ResponseEntity<ClienteResponse> updateCliente(@PathVariable(value = "id") Long clienteId, @RequestBody ClienteRequest clienteRequest) {
        var cliente = ClienteMapper.INSTANCE.clienteRequestToCliente(clienteRequest);
        var clienteResponse = ClienteMapper.INSTANCE.clienteToClienteResponse(clienteService.updateClient(clienteId, cliente));
        return new ResponseEntity<ClienteResponse>(clienteResponse, HttpStatus.OK);
    }
    */
    @Transactional
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable(value = "id") Long clienteId) {
        clienteService.deleteClient(clienteId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
