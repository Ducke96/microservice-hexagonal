package com.usuario.usuario.application.mapper;
import com.usuario.usuario.application.dto.response.RestauranteResponseDto;
import com.usuario.usuario.domain.model.RestauranteModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface RestauranteResponseMapper {
    RestauranteResponseDto toResponse(RestauranteModel objectModel);
    List<RestauranteResponseDto> toResponseList(List<RestauranteModel> objectModelList);
}
