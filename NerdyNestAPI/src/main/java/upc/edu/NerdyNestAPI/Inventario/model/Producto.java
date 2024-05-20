package upc.edu.NerdyNestAPI.Inventario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCTO_CATEGORIA_ID"))
    private Categoria categoria; // Referencia a la categoría

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCTO_MARCA_ID"))
    private Marca marca;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "producto_fotos", joinColumns = @JoinColumn(name = "producto_id"))
    @Column(name = "foto")
    private List<String> fotos; // Lista de URLs o rutas de las fotos
}
