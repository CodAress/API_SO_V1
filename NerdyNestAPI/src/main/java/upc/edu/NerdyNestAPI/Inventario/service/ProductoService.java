package upc.edu.NerdyNestAPI.Inventario.service;


import upc.edu.NerdyNestAPI.Inventario.model.Producto;

import java.util.List;

public interface ProductoService  {

    public Producto getProductoById(Long id);
    public List<Producto> getAllProductos();

    public Producto saveProducto(Long idMarca,Long idCategoria,Producto producto);
    public Producto updateProducto(Long idProducto, Producto productoDatails);

    public List<Producto> getProductosByCategoriaId(Long idCategoria);
    public void deleteProducto(Long id);
}
