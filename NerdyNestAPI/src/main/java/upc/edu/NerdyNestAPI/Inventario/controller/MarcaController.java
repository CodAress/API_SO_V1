package upc.edu.NerdyNestAPI.Inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import upc.edu.NerdyNestAPI.Inventario.dto.MarcaRequest;
import upc.edu.NerdyNestAPI.Inventario.dto.MarcaResponse;
import upc.edu.NerdyNestAPI.Inventario.dto.mapper.MarcaMapper;
import upc.edu.NerdyNestAPI.Inventario.service.MarcaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @Transactional
    @GetMapping("/marcas")
    public ResponseEntity<List<MarcaResponse>> getAllMarcas() {
        var marcasResponse = MarcaMapper.INSTANCE.marcaListToMarcaResponseList(marcaService.getAllMarcas());
        return new ResponseEntity<List<MarcaResponse>>(marcasResponse, HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/marcas/{id}")
    public ResponseEntity<MarcaResponse> getMarcaById(@PathVariable(value = "id") Long marcaId) {
        var marcaResponse = MarcaMapper.INSTANCE.marcaToMarcaResponse(marcaService.getMarcaById(marcaId));
        return new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.OK);
    }

    /*
    @Transactional
    @GetMapping("/marcas/{name}")
    public ResponseEntity<MarcaResponse> getMarcaByName(@PathVariable(value = "name") String marcaName) {
        var marcaResponse = MarcaMapper.INSTANCE.marcaToMarcaResponse(marcaService.getMarcaByName(marcaName));
        return new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.OK);
    }
    */

    @Transactional
    @PostMapping("/marcas")
    public ResponseEntity<MarcaResponse> createMarca(@RequestBody MarcaRequest marcaRequest) {
        var marca = MarcaMapper.INSTANCE.marcaRequestToMarca(marcaRequest);
        var marcaResponse = MarcaMapper.INSTANCE.marcaToMarcaResponse(marcaService.saveMarca(marca));
        return new ResponseEntity<MarcaResponse>(marcaResponse, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/marcas/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable(value = "id") Long marcaId) {
        marcaService.deleteMarca(marcaId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
