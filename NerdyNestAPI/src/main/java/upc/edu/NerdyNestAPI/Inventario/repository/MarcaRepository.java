package upc.edu.NerdyNestAPI.Inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.NerdyNestAPI.Inventario.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    boolean existsByNombre(String nombre);
}
