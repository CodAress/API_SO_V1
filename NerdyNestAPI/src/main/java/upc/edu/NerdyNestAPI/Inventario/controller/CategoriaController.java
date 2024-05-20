package upc.edu.NerdyNestAPI.Inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import upc.edu.NerdyNestAPI.Inventario.dto.CategoriaRequest;
import upc.edu.NerdyNestAPI.Inventario.dto.CategoriaResponse;
import upc.edu.NerdyNestAPI.Inventario.dto.mapper.CategoriaMapper;
import upc.edu.NerdyNestAPI.Inventario.service.CategoriaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Transactional
    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaResponse>> getAllCategorias() {
        var categoriasResponse = CategoriaMapper.INSTANCE.categoriaListToCategoriaResponseList(categoriaService.getAllCategorias());
        return new ResponseEntity<List<CategoriaResponse>>(categoriasResponse, HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponse> getCategoriaById(@PathVariable(value = "id") Long categoriaId) {
        var categoriaResponse = CategoriaMapper.INSTANCE.categoriaToCategoriaResponse(categoriaService.getCategoriaById(categoriaId));
        return new ResponseEntity<CategoriaResponse>(categoriaResponse, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/categoria")
    public ResponseEntity<CategoriaResponse> createCategoria(@RequestBody CategoriaRequest categoriaRequest) {
        var categoria = CategoriaMapper.INSTANCE.categoriaRequestToCategoria(categoriaRequest);
        var categoriaResponse = CategoriaMapper.INSTANCE.categoriaToCategoriaResponse(categoriaService.saveCategoria(categoria));
        return new ResponseEntity<CategoriaResponse>(categoriaResponse, HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/categoria/{id}")
    public ResponseEntity<CategoriaResponse> updateCategoria(@PathVariable(value = "id") Long categoriaId, @RequestBody CategoriaRequest categoriaRequest) {
        var categoria = CategoriaMapper.INSTANCE.categoriaRequestToCategoria(categoriaRequest);
        var categoriaResponse = CategoriaMapper.INSTANCE.categoriaToCategoriaResponse(categoriaService.updateCategoria(categoriaId, categoria));
        return new ResponseEntity<CategoriaResponse>(categoriaResponse, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable(value = "id") Long categoriaId) {
        categoriaService.deleteCategoria(categoriaId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
