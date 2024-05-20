package upc.edu.NerdyNestAPI.Inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.NerdyNestAPI.Inventario.model.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoriaId(Long categoriaId);
}
