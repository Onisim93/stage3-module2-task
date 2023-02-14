package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.util.MessageHelper;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.exception.ValidatorException;

import static com.mjc.school.controller.command.CommandConstants.ENTER_ID;

public class GetNewsByIdCommand implements Command {

    private final BaseController<NewsDto,NewsDto, Long> controller;

    public GetNewsByIdCommand(BaseController<NewsDto, NewsDto, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        MessageHelper.printMessage(ENTER_ID);
        long id = MessageHelper.readLong();
        try {
            MessageHelper.printMessage(controller.readById(id).toString());
        }
        catch (NoSuchEntityException | ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }
}
