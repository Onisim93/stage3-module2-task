package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    AuthorDto toDto (AuthorModel authorModel);
    AuthorModel toEntity (AuthorDto authorDto);

    List<AuthorDto> toListDto (List<AuthorModel> authorModelList);
}
