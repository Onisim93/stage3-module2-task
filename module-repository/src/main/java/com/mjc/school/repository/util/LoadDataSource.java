package com.mjc.school.repository.util;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.source.DataSource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoadDataSource {
    public void loadFromFile(List<String> list, String fileName) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            if (is == null) throw new IllegalArgumentException("File not found " + fileName);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                while (reader.ready()) {
                    list.add(reader.readLine());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadData(DataSource dataSource) {
        String authors = "authors";
        String news = "news";
        String contents = "content";

        List<String> authorList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        List<String> contentList = new ArrayList<>();

        loadFromFile(authorList, authors);
        loadFromFile(titleList, news);
        loadFromFile(contentList, contents);

        for (int i=0; i<20;i++) {
            AuthorModel authorModel = new AuthorModel(authorList.get(i));
            dataSource.createAuthor(authorModel);
            NewsModel newsModel = new NewsModel(titleList.get(i), contentList.get(i), authorModel.getId());
            dataSource.createNews(newsModel);
        }

    }
}
