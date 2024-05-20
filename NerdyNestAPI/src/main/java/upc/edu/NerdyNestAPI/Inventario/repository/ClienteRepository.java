package upc.edu.NerdyNestAPI.Inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.NerdyNestAPI.Inventario.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
