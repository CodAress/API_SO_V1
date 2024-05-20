package upc.edu.NerdyNestAPI.Inventario.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import upc.edu.NerdyNestAPI.Inventario.dto.ProductoRequest;
import upc.edu.NerdyNestAPI.Inventario.dto.ProductoResponse;
import upc.edu.NerdyNestAPI.Inventario.model.Producto;

import java.util.List;

@Mapper
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
    Producto productoRequestToProducto(ProductoRequest productoRequest);
    ProductoResponse productoToProductoResponse(Producto producto);
    List<ProductoResponse> productoListToProductoResponseList(List<Producto> allProductos);
}
