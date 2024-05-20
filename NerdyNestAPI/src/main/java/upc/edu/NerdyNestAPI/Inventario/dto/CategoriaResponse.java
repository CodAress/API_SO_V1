package upc.edu.NerdyNestAPI.Inventario.dto;

import lombok.Data;

@Data
public class CategoriaResponse {
    private Long id;
    private String nombre;
    private String descripcion;
}
