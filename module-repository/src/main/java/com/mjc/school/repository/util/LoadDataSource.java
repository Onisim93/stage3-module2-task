package com.mjc.school.repository.util;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.source.DataSource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class LoadDataSource {
    public void loadFromFile(List<String> list, String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadData(DataSource dataSource) {
        String PATH_TO_AUTHORS = Objects.requireNonNull(this.getClass().getClassLoader().getResource("authors")).getPath();
        String PATH_TO_TITLES = Objects.requireNonNull(this.getClass().getClassLoader().getResource("news")).getPath();
        String PATH_TO_CONTENTS = Objects.requireNonNull(this.getClass().getClassLoader().getResource("content")).getPath();

        List<String> authorList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        List<String> contentList = new ArrayList<>();

        loadFromFile(authorList, PATH_TO_AUTHORS);
        loadFromFile(titleList, PATH_TO_TITLES);
        loadFromFile(contentList, PATH_TO_CONTENTS);

        for (int i=0; i<20;i++) {
            AuthorModel authorModel = new AuthorModel(authorList.get(i));
            dataSource.createAuthor(authorModel);
            NewsModel newsModel = new NewsModel(titleList.get(i), contentList.get(i), authorModel.getId());
            dataSource.createNews(newsModel);
        }

    }
}
