package upc.edu.NerdyNestAPI.Inventario.service;

import upc.edu.NerdyNestAPI.Inventario.model.Marca;

import java.util.List;

public interface MarcaService {
    public List<Marca> getAllMarcas();
    public Marca getMarcaById(Long id);
    public Marca saveMarca(Marca marca);
    public Marca updateMarca(Marca marca);
    public void deleteMarca(Long id);
}
