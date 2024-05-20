package upc.edu.NerdyNestAPI.Inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.NerdyNestAPI.Inventario.model.Marca;
import upc.edu.NerdyNestAPI.Inventario.repository.MarcaRepository;
import upc.edu.NerdyNestAPI.Inventario.service.MarcaService;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;


    @Override
    public List<Marca> getAllMarcas() {
        List<Marca> allMarcas = marcaRepository.findAll();
        if(allMarcas.isEmpty())
        {
            allMarcas = null;
            throw new RuntimeException("Unregistered marcas");
        }
        return allMarcas;
    }

    @Override
    public Marca getMarcaById(Long id) {
        return marcaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Marca not found"));
    }

    @Override
    public Marca saveMarca(Marca marca) {

        validateMarcaRegister(marca);
        isRegisteredMarca(marca);
        return marcaRepository.save(marca);
    }

    @Override
    public Marca updateMarca(Marca marca) {
        Marca existingMarca = marcaRepository.findById(marca.getId())
                .orElseThrow(() -> new RuntimeException("Marca with id " + marca.getId() + " not found"));
        updateMarcaFields(existingMarca, marca);
        validateMarcaRegister(marca);
        return marcaRepository.save(existingMarca);
    }

    @Override
    public void deleteMarca(Long id) {
        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca with id " + id + " not found"));

        marcaRepository.delete(marca);
    }

    private void updateMarcaFields(Marca existingMarca, Marca marca) {
        existingMarca.setNombre(marca.getNombre() != null ? marca.getNombre() : existingMarca.getNombre());
    }

    private void validateMarcaRegister(Marca marca) {
        if (marca.getNombre() == null || marca.getNombre().isEmpty()) {
            throw new RuntimeException("Marca name is required");
        }
    }

    private void isRegisteredMarca(Marca marca) {
        if (marcaRepository.existsByNombre(marca.getNombre())) {
            throw new RuntimeException("Marca " + marca.getNombre() + " already exists");
        }
    }
}
