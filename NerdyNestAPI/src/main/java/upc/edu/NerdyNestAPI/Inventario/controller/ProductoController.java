package upc.edu.NerdyNestAPI.Inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import upc.edu.NerdyNestAPI.Inventario.dto.ProductoRequest;
import upc.edu.NerdyNestAPI.Inventario.dto.ProductoResponse;
import upc.edu.NerdyNestAPI.Inventario.dto.mapper.ProductoMapper;
import upc.edu.NerdyNestAPI.Inventario.service.ProductoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Transactional
    @GetMapping("/productos")
    public ResponseEntity<List<ProductoResponse>> getAllProductos() {
        var productosResponse = ProductoMapper.INSTANCE.productoListToProductoResponseList(productoService.getAllProductos());
        return new ResponseEntity<List<ProductoResponse>>(productosResponse, HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoResponse> getProductoById(@PathVariable(value = "id") Long productoId) {
        var productoResponse = ProductoMapper.INSTANCE.productoToProductoResponse(productoService.getProductoById(productoId));
        return new ResponseEntity<ProductoResponse>(productoResponse, HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/categoria/{categoria_id}/productos")
    public ResponseEntity<List<ProductoResponse>> getProductosByCategoria(@PathVariable(value = "categoria_id") Long categoriaId) {
        var productosResponse = ProductoMapper.INSTANCE.productoListToProductoResponseList(productoService.getProductosByCategoriaId(categoriaId));
        return new ResponseEntity<List<ProductoResponse>>(productosResponse, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/marca/{marca_id}/categoria/{categoria_id}/producto")
    public ResponseEntity<ProductoResponse> createProducto(@PathVariable("marca_id") Long marca_id, @PathVariable("categoria_id") Long categoria_id,@RequestBody ProductoRequest productoRequest) {
        var producto = ProductoMapper.INSTANCE.productoRequestToProducto(productoRequest);
        var productoCreated = productoService.saveProducto(marca_id, categoria_id, producto);
        var productoResponse = ProductoMapper.INSTANCE.productoToProductoResponse(productoCreated);
        return new ResponseEntity<ProductoResponse>(productoResponse, HttpStatus.CREATED);

    }

    @Transactional
    @PutMapping("/producto/{id}")
    public ResponseEntity<ProductoResponse> updateProducto(@PathVariable(value = "id") Long productoId, @RequestBody ProductoRequest productoRequest) {
        var producto = ProductoMapper.INSTANCE.productoRequestToProducto(productoRequest);
        var productoUpdated = productoService.updateProducto(productoId, producto);
        var productoResponse = ProductoMapper.INSTANCE.productoToProductoResponse(productoUpdated);
        return new ResponseEntity<ProductoResponse>(productoResponse, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable(value = "id") Long productoId) {
        productoService.deleteProducto(productoId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
