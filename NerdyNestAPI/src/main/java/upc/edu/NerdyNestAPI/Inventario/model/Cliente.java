package upc.edu.NerdyNestAPI.Inventario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    @Column(name = "codigo_postal", nullable = false, length = 5)
    private String codigoPostal;
    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;
}
