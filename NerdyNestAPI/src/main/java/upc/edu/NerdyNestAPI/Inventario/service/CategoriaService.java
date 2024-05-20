package upc.edu.NerdyNestAPI.Inventario.service;

import upc.edu.NerdyNestAPI.Inventario.model.Categoria;

import java.util.List;

public interface CategoriaService {
    public List<Categoria> getAllCategorias();
    public Categoria getCategoriaById(Long id);
    public Categoria saveCategoria(Categoria categoria);
    public Categoria updateCategoria(Long id, Categoria categoriaDetails);
    public void deleteCategoria(Long id);
}
