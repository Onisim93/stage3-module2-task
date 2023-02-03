package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.source.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {

    private final DataSource dataSource;

    @Autowired
    public AuthorRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<AuthorModel> readAll() {
        return dataSource.getAuthorList();
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return dataSource.getAuthorById(id);
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        return dataSource.createAuthor(entity);
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        return dataSource.updateAuthor(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        return dataSource.deleteAuthorById(id);
    }

    @Override
    public boolean existById(Long id) {
        return dataSource.authorIsExistById(id);
    }
}
