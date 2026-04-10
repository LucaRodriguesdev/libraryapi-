package io.github.luca.libraryapi.controller.mappers;

import io.github.luca.libraryapi.controller.dto.UsuarioDTO;
import io.github.luca.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
