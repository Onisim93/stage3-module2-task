package com.mjc.school.controller.util;

import com.mjc.school.controller.command.*;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {

    private final NewsController newsController;
    private final AuthorController authorController;

    @Autowired
    public CommandExecutor(NewsController newsController, AuthorController authorController) {
        this.newsController = newsController;
        this.authorController = authorController;
    }

    public void getAndExecuteNextCommand() {
        int action = (int) MessageHelper.readLong();
        try {
            MenuCommand menuCommand = MenuCommand.values()[action];
            Command command = null;
            switch (menuCommand) {
                case GET_ALL_NEWS -> command = new GetAllNewsCommand(newsController);
                case GET_ALL_AUTHORS -> command = new GetAllAuthorsCommand(authorController);
                case CREATE_NEWS -> command = new CreateNewsCommand(newsController);
                case CREATE_AUTHOR -> command = new CreateAuthorCommand(authorController);
                case DELETE_NEWS -> command = new DeleteNewsByIdCommand(newsController);
                case DELETE_AUTHOR -> command = new DeleteAuthorByIdCommand(authorController);
                case UPDATE_NEWS -> command = new UpdateNewsCommand(newsController);
                case UPDATE_AUTHOR -> command = new UpdateAuthorCommand(authorController);
                case GET_NEWS_BY_ID -> command = new GetNewsByIdCommand(newsController);
                case GET_AUTHOR_BY_ID -> command = new GetAuthorByIdCommand(authorController);
                case EXIT -> command = new ExitCommand();
            }
            command.execute();
        }
        catch (Exception e) {
            MessageHelper.printMessage("Invalid command.");
        }
    }

}
