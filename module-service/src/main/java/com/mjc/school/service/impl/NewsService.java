package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.exception.ServiceErrorCode;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.validator.BaseValidator;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsService implements BaseService<NewsDto, NewsDto, Long> {
    private final BaseRepository<NewsModel, Long> repository;
    private final BaseRepository<AuthorModel, Long> authorRepository;
    private final BaseValidator<NewsDto> validator;

    public NewsService(BaseRepository<NewsModel, Long> repository, BaseRepository<AuthorModel, Long> authorRepository, BaseValidator<NewsDto> validator) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.validator = validator;
    }


    @Override
    public List<NewsDto> readAll() {
        return NewsMapper.INSTANCE.toListDto(repository.readAll());
    }

    @Override
    public NewsDto readById(Long id) {
        validator.validateId(id);
        return NewsMapper.INSTANCE.toDto(repository.readById(id)
                .orElseThrow(()-> new NoSuchEntityException(String.format(ServiceErrorCode.NEWS_ID_DOES_NOT_EXIST.getMessage(), id))));
    }

    @Override
    public NewsDto create(NewsDto createRequest) {
        validator.validate(createRequest);
        if (!authorRepository.existById(createRequest.getAuthorId())) {
            throw new NoSuchEntityException(String.format(ServiceErrorCode.AUTHOR_ID_DOES_NOT_EXIST.getMessage(), createRequest.getAuthorId()));
        }
        NewsModel newsModel = NewsMapper.INSTANCE.toEntity(createRequest);
        return NewsMapper.INSTANCE.toDto(repository.create(newsModel));
    }

    @Override
    public NewsDto update(NewsDto updateRequest) {
        validator.validate(updateRequest);
        if (!repository.existById(updateRequest.getId())) {
            throw new NoSuchEntityException(String.format(ServiceErrorCode.NEWS_ID_DOES_NOT_EXIST.getMessage(), updateRequest.getId()));
        }
        if (!authorRepository.existById(updateRequest.getAuthorId())) {
            throw new NoSuchEntityException(String.format(ServiceErrorCode.AUTHOR_ID_DOES_NOT_EXIST.getMessage(), updateRequest.getAuthorId()));
        }
        NewsModel newsModel = NewsMapper.INSTANCE.toEntity(updateRequest);
        return NewsMapper.INSTANCE.toDto(repository.update(newsModel));
    }

    @Override
    public boolean deleteById(Long id) {
        validator.validateId(id);
        if (!repository.deleteById(id)) {
            throw new NoSuchEntityException(String.format(ServiceErrorCode.NEWS_ID_DOES_NOT_EXIST.getMessage(), id));
        }
        return true;
    }
}
