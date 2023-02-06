package com.mjc.school.menu;

import com.mjc.school.controller.MainController;
import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {

    private final MainController controller;

    public CommandExecutor(MainController controller) {
        this.controller = controller;
    }


    public void execute(MenuCommand command) {
        switch (command) {
            case GET_ALL_NEWS -> controller.getAllNews();
            case GET_ALL_AUTHORS -> controller.getAllAuthors();
            case CREATE_NEWS -> controller.createNews();
            case CREATE_AUTHOR -> controller.createAuthor();
            case DELETE_NEWS -> controller.deleteNewsById();
            case DELETE_AUTHOR -> controller.deleteAuthorById();
            case UPDATE_NEWS -> controller.updateNews();
            case UPDATE_AUTHOR -> controller.updateAuthor();
            case GET_NEWS_BY_ID -> controller.getNewsById();
            case GET_AUTHOR_BY_ID -> controller.getAuthorById();
            case EXIT -> controller.exit();
        }
    }

}
