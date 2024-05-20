package upc.edu.NerdyNestAPI.Inventario.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import upc.edu.NerdyNestAPI.Inventario.dto.ClienteRequest;
import upc.edu.NerdyNestAPI.Inventario.dto.ClienteResponse;
import upc.edu.NerdyNestAPI.Inventario.model.Cliente;

import java.util.List;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente clienteRequestToCliente(ClienteRequest clienteRequest);
    ClienteResponse clienteToClienteResponse(Cliente cliente);

    List<ClienteResponse> clienteListToClienteResponseList(List<Cliente> clienteList);
}
