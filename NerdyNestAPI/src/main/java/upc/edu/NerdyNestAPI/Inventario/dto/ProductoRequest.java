package upc.edu.NerdyNestAPI.Inventario.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private List<String> fotos;
}
