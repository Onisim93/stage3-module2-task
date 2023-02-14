package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.util.MessageHelper;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.exception.ValidatorException;

import static com.mjc.school.controller.command.CommandConstants.*;

public class UpdateNewsCommand implements Command{

    private final BaseController<NewsDto, NewsDto, Long> controller;

    public UpdateNewsCommand(BaseController<NewsDto, NewsDto, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
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
            NewsDto updated = controller.update(newsDto);
            MessageHelper.printMessage(updated.toString());
        }
        catch (NoSuchEntityException | ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }
}
