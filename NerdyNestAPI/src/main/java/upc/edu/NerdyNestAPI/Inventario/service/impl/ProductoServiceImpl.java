package upc.edu.NerdyNestAPI.Inventario.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.NerdyNestAPI.Inventario.model.Producto;
import upc.edu.NerdyNestAPI.Inventario.repository.MarcaRepository;
import upc.edu.NerdyNestAPI.Inventario.repository.ProductoRepository;
import upc.edu.NerdyNestAPI.Inventario.service.ProductoService;
import upc.edu.NerdyNestAPI.Inventario.repository.CategoriaRepository;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Producto getProductoById(Long id) {
        existProductoById(id);
        return productoRepository.findById(id).get();
    }

    @Override
    public List<Producto> getAllProductos() {
        List<Producto> allProductos = productoRepository.findAll();
        if(allProductos.isEmpty())
        {
            allProductos = null;
            throw new RuntimeException("Unregistered productos");
        }
        return allProductos;
    }

    @Override
    public Producto saveProducto(Long idMarca, Long idCategoria, Producto producto) {
        existMarcaById(idMarca);
        existCategoriaById(idCategoria);
        validateProducto(producto);
        producto.setMarca(marcaRepository.findById(idMarca).get());
        producto.setCategoria(categoriaRepository.findById(idCategoria).get());
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long idProducto, Producto productoDatails) {
        existProductoById(idProducto);
        validateProducto(productoDatails);
        Producto producto = productoRepository.findById(idProducto).get();
        producto.setNombre(productoDatails.getNombre());
        producto.setDescripcion(productoDatails.getDescripcion());
        producto.setPrecio(productoDatails.getPrecio());
        producto.setStock(productoDatails.getStock());
        producto.setFotos(productoDatails.getFotos());
        return productoRepository.save(producto);
    }
    @Override
    public List<Producto> getProductosByCategoriaId(Long idCategoria) {
        existCategoriaById(idCategoria);
        List<Producto> productosByCategoria = productoRepository.findByCategoriaId(idCategoria);
        if(productosByCategoria.isEmpty())
        {
            productosByCategoria = null;
            throw new RuntimeException("Unregistered productos by category");
        }
        return productosByCategoria;
    }
    @Override
    public void deleteProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto with id " + id + " not found"));

        productoRepository.delete(producto);
    }

    private void existMarcaById(Long id) {
        if (!marcaRepository.existsById(id)) {
            throw new RuntimeException("Marca with id " + id + " not found");
        }
    }

    private void existProductoById(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto with id " + id + " not found");
        }
    }
    private void existCategoriaById(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria with id " + id + " not found");
        }
    }
    private void validateProducto(Producto producto) {
       if(producto.getNombre() == null || producto.getNombre().isEmpty()){
           throw new RuntimeException("Product name is required");
       }
        if(producto.getDescripcion() == null || producto.getDescripcion().isEmpty()){
           throw new RuntimeException("Product description is required");
       }
        if(producto.getPrecio() == null){
            throw new RuntimeException("Product price is required");
        }
        if(producto.getPrecio() < 0){
            throw new RuntimeException("Product price cannot be negative");
        }
        if(producto.getStock() == null){
            throw new RuntimeException("Product stock is required");
        }
        if(producto.getStock() < 0){
            throw new RuntimeException("Product stock cannot be negative");
        }
        if(producto.getFotos().isEmpty() || producto.getFotos() == null){
            throw new RuntimeException("Product photos are required");
        }
    }
}
