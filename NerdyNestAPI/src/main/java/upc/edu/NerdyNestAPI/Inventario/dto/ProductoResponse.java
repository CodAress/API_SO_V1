package upc.edu.NerdyNestAPI.Inventario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import upc.edu.NerdyNestAPI.Inventario.dto.MarcaResponse;

import java.util.List;

@Data
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    @JsonProperty("categoria")
    private CategoriaResponse categoria;
    @JsonProperty("marca")
    private MarcaResponse marca;
    private List<String> fotos;
}
