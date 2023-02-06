package com.mjc.school.controller;

import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.controller.util.MessageHelper;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.exception.ValidatorException;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    private final String ENTER_ID = "Enter id:";
    private final String ENTER_NAME = "Enter name:";
    private final String ENTER_TITLE = "Enter title:";
    private final String ENTER_CONTENT = "Enter content:";
    private final String ENTER_AUTHOR_ID = "Enter author id:";

    private final NewsController newsController;
    private final AuthorController authorController;


    public MainController(NewsController newsController, AuthorController authorController) {
        this.newsController = newsController;
        this.authorController = authorController;
    }

    public void getAllNews() {
        MessageHelper.printMessage(newsController.readAll().toString());
    }

    public void getAllAuthors() {
        MessageHelper.printMessage(authorController.readAll().toString());
    }

    public void getNewsById() {
        MessageHelper.printMessage(ENTER_ID);
        Long id = MessageHelper.readLong();
        try {
            MessageHelper.printMessage(newsController.readById(id).toString());
        }
        catch (NoSuchEntityException | ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }

    public void getAuthorById() {
        MessageHelper.printMessage(ENTER_ID);
        Long id = MessageHelper.readLong();
        try {
            MessageHelper.printMessage(authorController.readById(id).toString());
        }
        catch (NoSuchEntityException | ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }

    public void createNews() {
        MessageHelper.printMessage(ENTER_TITLE);
        String title = MessageHelper.readString();
        MessageHelper.printMessage(ENTER_CONTENT);
        String content = MessageHelper.readString();
        MessageHelper.printMessage(ENTER_AUTHOR_ID);
        Long id = MessageHelper.readLong();

        NewsDto newsDto = new NewsDto(title, content, id);

        try {
            NewsDto created  = newsController.create(newsDto);
            MessageHelper.printMessage(created.toString());
        }
        catch (NoSuchEntityException | ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }

    public void createAuthor() {
        MessageHelper.printMessage(ENTER_NAME);
        String name = MessageHelper.readString();

        AuthorDto authorDto = new AuthorDto(name);

        try {
            AuthorDto created = authorController.create(authorDto);
            MessageHelper.printMessage(created.toString());
        }
        catch (ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }

    public void updateNews() {
        MessageHelper.printMessage(ENTER_ID);
        Long id = MessageHelper.readLong();
        MessageHelper.printMessage(ENTER_TITLE);
        String title = MessageHelper.readString();
        MessageHelper.printMessage(ENTER_CONTENT);
        String content = MessageHelper.readString();
        MessageHelper.printMessage(ENTER_AUTHOR_ID);
        Long authorId = MessageHelper.readLong();

        NewsDto newsDto = new NewsDto(id, title, content, authorId);

        try {
            NewsDto updated = newsController.update(newsDto);
            MessageHelper.printMessage(updated.toString());
        }
        catch (NoSuchEntityException | ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }

    public void updateAuthor() {
        MessageHelper.printMessage(ENTER_ID);
        Long id = MessageHelper.readLong();
        MessageHelper.printMessage(ENTER_NAME);
        String name  = MessageHelper.readString();

        AuthorDto authorDto = new AuthorDto(id, name);

        try {
            AuthorDto updated = authorController.update(authorDto);
            MessageHelper.printMessage(updated.toString());
        }
        catch (NoSuchEntityException | ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }

    public void deleteNewsById() {
        MessageHelper.printMessage(ENTER_ID);
        Long id = MessageHelper.readLong();

        try {
            MessageHelper.printMessage(String.valueOf(newsController.deleteById(id)));
        }
        catch (NoSuchEntityException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }

    public void deleteAuthorById() {
        MessageHelper.printMessage(ENTER_ID);
        Long id = MessageHelper.readLong();

        try {
            MessageHelper.printMessage(String.valueOf(authorController.deleteById(id)));
        }
        catch (NoSuchEntityException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }

    public void exit() {
        MessageHelper.printMessage("Goodbye!");
        System.exit(0);
    }
}
