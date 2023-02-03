package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.source.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<NewsModel, Long> {

    private final DataSource dataSource;

    @Autowired
    public NewsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNewsList();
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        return dataSource.getNewsById(id);
    }

    @Override
    public NewsModel create(NewsModel entity) {
        return dataSource.createNews(entity);
    }

    @Override
    public NewsModel update(NewsModel entity) {
        return dataSource.updateNews(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        return dataSource.deleteNewsById(id);
    }

    @Override
    public boolean existById(Long id) {
        return dataSource.newsIsExistsById(id);
    }
}
