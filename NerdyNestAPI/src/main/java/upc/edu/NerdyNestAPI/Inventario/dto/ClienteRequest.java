package upc.edu.NerdyNestAPI.Inventario.dto;

import lombok.Data;

@Data
public class ClienteRequest {
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private String dni;
    private String codigoPostal;
}
