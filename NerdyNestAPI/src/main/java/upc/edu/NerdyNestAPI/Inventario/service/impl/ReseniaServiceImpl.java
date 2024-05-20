package upc.edu.NerdyNestAPI.Inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
import upc.edu.NerdyNestAPI.Inventario.model.Resenia;
import upc.edu.NerdyNestAPI.Inventario.repository.ReseniaRepository;
import upc.edu.NerdyNestAPI.Inventario.service.ReseniaService;

import java.util.List;

@Service
public class ReseniaServiceImpl implements ReseniaService {

    @Autowired
    private ReseniaRepository reseniaRepository;
    @Override
    public Resenia getReseniaById(Long id) {
        return reseniaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Resenia not found"));
    }

    @Override
    public List<Resenia> getAllResenias() {
        List<Resenia> allResenias = reseniaRepository.findAll();
        if(allResenias.isEmpty())
        {
            allResenias = null;
            throw new RuntimeException("Unregistered resenias");
        }
        return allResenias;
    }

    @Override
    public Resenia saveResenia(Resenia resenia) {
        validateReseniaRegister(resenia);
        return reseniaRepository.save(resenia);
    }

    //////
    @Override
    public Resenia updateResenia(Resenia resenia) {
        Resenia existingResenia = reseniaRepository.findByClienteIdAndProductoId(resenia.getCliente().getId(), resenia.getProducto().getId());

        if(existingResenia == null){
            throw new RuntimeException(
                    "Product with id " + resenia.getProducto().getId() + " not found for client with id " + resenia.getCliente().getId() + " not found or Client with id " + resenia.getCliente().getId() + " not found for product with id " + resenia.getProducto().getId() + " not found"));
        }

         Resenia existingResenia = reseniaRepository.findById(resenia.getId())
                .orElseThrow(() -> new RuntimeException("Resenia with id " + resenia.getId() + " not found"));


        updateReseniaFields(existingResenia, resenia);
        validateReseniaRegister(resenia);
        return reseniaRepository.save(existingResenia);
    }
    //////


    @Override
    public void deleteResenia(Long id) {
        Resenia resenia = reseniaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resenia with id " + id + " not found"));
        reseniaRepository.delete(resenia);
    }

    private void updateReseniaFields(Resenia existingResenia, Resenia resenia) {
        existingResenia.setComentario(resenia.getComentario() != null ? resenia.getComentario() : existingResenia.getComentario());
        existingResenia.setPuntuacion(resenia.getPuntuacion() < 0 ? resenia.getPuntuacion() : existingResenia.getPuntuacion());
        existingResenia.setProducto(resenia.getProducto() != null ? resenia.getProducto() : existingResenia.getProducto());
        existingResenia.setCliente(resenia.getCliente() != null ? resenia.getCliente() : existingResenia.getCliente());
    }

    private void validateReseniaRegister(Resenia resenia) {
        if (resenia.getComentario() == null || resenia.getComentario().isEmpty()) {
            throw new RuntimeException("Comentario is required");
        }
        //puntaje no puede ser negativo
        if (resenia.getPuntuacion() < 0) {
            throw new RuntimeException("Invalid puntaje, the puntaje cannot be negative");
        }
        if (resenia.getProducto() == null) {
            throw new RuntimeException("Producto is required");
        }
        if (resenia.getCliente() == null) {
            throw new RuntimeException("Cliente is required");
        }
    }
}
*/