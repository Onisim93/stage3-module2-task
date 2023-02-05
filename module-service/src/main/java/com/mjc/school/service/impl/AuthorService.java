package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.aop.annotation.OnDelete;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.exception.ServiceErrorCode;
import com.mjc.school.service.mapper.AuthorMapper;
import com.mjc.school.service.validator.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService implements BaseService<AuthorDto, AuthorDto, Long> {
    private final BaseRepository<AuthorModel, Long> repository;
    private final BaseValidator<AuthorDto> validator;

    @Autowired
    public AuthorService(BaseRepository<AuthorModel, Long> repository, BaseValidator<AuthorDto> validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<AuthorDto> readAll() {
        return AuthorMapper.INSTANCE.toListDto(repository.readAll());
    }

    @Override
    public AuthorDto readById(Long id) {
        validator.validateId(id);
        return AuthorMapper.INSTANCE.toDto(repository.readById(id).orElseThrow(
                () -> new NoSuchEntityException(String.format(ServiceErrorCode.AUTHOR_ID_DOES_NOT_EXIST.getMessage(), id))));
    }

    @Override
    public AuthorDto create(AuthorDto createRequest) {
        validator.validate(createRequest);
        AuthorModel authorModel = AuthorMapper.INSTANCE.toEntity(createRequest);

        return AuthorMapper.INSTANCE.toDto(repository.create(authorModel));
    }

    @Override
    public AuthorDto update(AuthorDto updateRequest) {
        validator.validate(updateRequest);
        if (repository.existById(updateRequest.getId())) {
            AuthorModel authorModel = AuthorMapper.INSTANCE.toEntity(updateRequest);
            return AuthorMapper.INSTANCE.toDto(repository.update(authorModel));
        }
        throw new NoSuchElementException(String.format(ServiceErrorCode.AUTHOR_ID_DOES_NOT_EXIST.getMessage(), updateRequest.getId()));
    }

    @OnDelete
    @Override
    public boolean deleteById(Long id) {
        validator.validateId(id);
        if (!repository.deleteById(id)) {
            throw new NoSuchEntityException(String.format(ServiceErrorCode.AUTHOR_ID_DOES_NOT_EXIST.getMessage(), id));
        }
        return true;
     }
}
