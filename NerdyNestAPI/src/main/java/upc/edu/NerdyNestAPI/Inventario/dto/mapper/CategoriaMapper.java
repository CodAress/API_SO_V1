package upc.edu.NerdyNestAPI.Inventario.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import upc.edu.NerdyNestAPI.Inventario.dto.CategoriaRequest;
import upc.edu.NerdyNestAPI.Inventario.dto.CategoriaResponse;
import upc.edu.NerdyNestAPI.Inventario.model.Categoria;

import java.util.List;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria categoriaRequestToCategoria(CategoriaRequest categoriaRequest);
    CategoriaResponse categoriaToCategoriaResponse(Categoria categoria);
    List<CategoriaResponse> categoriaListToCategoriaResponseList(List<Categoria> categorias);
}
