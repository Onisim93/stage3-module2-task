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
public class ControllerHandler {
    private final String ENTER_ID = "Enter id:";
    private final String ENTER_NAME = "Enter name:";
    private final String ENTER_TITLE = "Enter title:";
    private final String ENTER_CONTENT = "Enter content:";
    private final String ENTER_AUTHOR_ID = "Enter author id:";

    private final NewsController newsController;
    private final AuthorController authorController;


    public ControllerHandler(NewsController newsController, AuthorController authorController) {
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

    }

    public void createAuthor() {

    }

    public void updateNews() {

    }

    public void updateAuthor() {

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

    }

    public void exit() {
        MessageHelper.printMessage("Goodbye!");
        System.exit(0);
    }
}
