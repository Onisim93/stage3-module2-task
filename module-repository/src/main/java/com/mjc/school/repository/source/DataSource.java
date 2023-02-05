package com.mjc.school.repository.source;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.util.LoadDataSource;
import com.mjc.school.repository.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DataSource {
    private final Map<Long, AuthorModel> authorMap = new ConcurrentHashMap<>();
    private final Map<Long, NewsModel> newsMap = new ConcurrentHashMap<>();

    @Autowired
    private LoadDataSource loadDataSource;

    @PostConstruct
    private void init() {
        loadDataSource.loadData(this);
    }

    public Optional<AuthorModel> getAuthorById (Long id) {
        return Optional.ofNullable(authorMap.get(id));
    }

    public Optional<NewsModel> getNewsById(Long id) {
        return Optional.ofNullable(newsMap.get(id));
    }

    public List<AuthorModel> getAuthorList() {
        return authorMap.values().stream().toList();
    }

    public List<NewsModel> getNewsList() {
        return newsMap.values().stream().toList();
    }

    public AuthorModel createAuthor(AuthorModel authorModel) {
        Long newId = SequenceGenerator.getNextSequence();
        authorModel.setId(newId);
        return authorMap.putIfAbsent(newId, authorModel) == null ? authorModel : null;
    }

    public AuthorModel updateAuthor(AuthorModel authorModel) {
        AuthorModel model = authorMap.get(authorModel.getId());

        model.setName(authorModel.getName());
        model.setLastUpdateDate(authorModel.getCreateDate());

        return model;
    }

    public Boolean deleteAuthorById(Long id) {
        return authorMap.remove(id) != null;
    }

    public NewsModel createNews(NewsModel newsModel) {
        Long newId = SequenceGenerator.getNextSequence();
        newsModel.setId(newId);
        return newsMap.putIfAbsent(newId, newsModel) == null ? newsModel : null;
    }

    public NewsModel updateNews(NewsModel newsModel) {
        NewsModel model = newsMap.get(newsModel.getId());

        model.setTitle(newsModel.getTitle());
        model.setContent(newsModel.getContent());
        model.setAuthorId(newsModel.getAuthorId());
        model.setLastUpdateDate(newsModel.getCreateDate());

        return model;
    }

    public Boolean deleteNewsById(Long id) {
        return newsMap.remove(id) != null;
    }

    public Boolean authorIsExistById(Long id) {
        return authorMap.containsKey(id);
    }

    public Boolean newsIsExistsById(Long id) {
        return newsMap.containsKey(id);
    }

}
