package upc.edu.NerdyNestAPI.Inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.NerdyNestAPI.Inventario.model.Categoria;
import upc.edu.NerdyNestAPI.Inventario.repository.CategoriaRepository;
import upc.edu.NerdyNestAPI.Inventario.service.CategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> getAllCategorias() {
        List<Categoria> allCategorias = categoriaRepository.findAll();
        if(allCategorias.isEmpty())
        {
            allCategorias = null;
            throw new RuntimeException("Unregistered categorias");
        }
        return allCategorias;
    }

    @Override
    public Categoria getCategoriaById(Long id) {
        existCategoriaById(id);
        return categoriaRepository.findById(id).get();
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        validateCategoria(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria categoriaDetails) {
        existCategoriaById(id);
        validateCategoria(categoriaDetails);
        Categoria categoria = categoriaRepository.findById(id).get();
        categoria.setNombre(categoriaDetails.getNombre());
        categoria.setDescripcion(categoriaDetails.getDescripcion());
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        existCategoriaById(id);
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }

    private void validateCategoria(Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new RuntimeException("Categoria name is required");
        }
        if(categoria.getDescripcion()==null || categoria.getDescripcion().isEmpty()){
            throw new RuntimeException("Categoria description is required");
        }
    }
    private void existCategoriaById(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria with id " + id + " not found");
        }
    }
}
