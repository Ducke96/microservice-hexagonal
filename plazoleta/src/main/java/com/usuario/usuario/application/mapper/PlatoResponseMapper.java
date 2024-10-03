package com.usuario.usuario.application.mapper;
import com.usuario.usuario.application.dto.response.PlatoResponseDto;
import com.usuario.usuario.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PlatoResponseMapper {
    PlatoResponseDto toResponse(PlatoModel objectModel);
    List<PlatoResponseDto> toResponseList(List<PlatoModel> objectModelList);
}
