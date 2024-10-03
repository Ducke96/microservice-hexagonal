package com.usuario.usuario.infrastructure.out.jpa.mapper;

import com.usuario.usuario.domain.model.UsuarioModel;
import com.usuario.usuario.infrastructure.out.jpa.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUsuarioEntityMapper {

    Usuario toEntity(UsuarioModel user);
    UsuarioModel toObjectModel(Usuario objectEntity);
    List<UsuarioModel> toObjectModelList(List<Usuario> userEntityList);
}