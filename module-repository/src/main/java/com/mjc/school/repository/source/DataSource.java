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
        return authorMap.computeIfPresent(authorModel.getId(), (key, value) -> authorModel);
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
        return newsMap.computeIfPresent(newsModel.getId(), (key, value) -> newsModel);
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
