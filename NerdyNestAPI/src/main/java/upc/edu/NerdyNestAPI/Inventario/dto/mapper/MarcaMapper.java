package upc.edu.NerdyNestAPI.Inventario.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import upc.edu.NerdyNestAPI.Inventario.dto.MarcaRequest;
import upc.edu.NerdyNestAPI.Inventario.dto.MarcaResponse;
import upc.edu.NerdyNestAPI.Inventario.model.Marca;

import java.util.List;

@Mapper
public interface MarcaMapper {
    MarcaMapper INSTANCE = Mappers.getMapper(MarcaMapper.class);
    Marca marcaRequestToMarca(MarcaRequest marcaRequest);
    MarcaResponse marcaToMarcaResponse(Marca marca);

    List<MarcaResponse> marcaListToMarcaResponseList(List<Marca> allMarcas);
}
