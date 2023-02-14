package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.util.MessageHelper;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.exception.NoSuchEntityException;

import static com.mjc.school.controller.command.CommandConstants.ENTER_ID;

public class DeleteAuthorByIdCommand implements Command{

    public final BaseController<AuthorDto, AuthorDto, Long> controller;

    public DeleteAuthorByIdCommand(BaseController<AuthorDto, AuthorDto, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        MessageHelper.printMessage(ENTER_ID);
        Long id = MessageHelper.readLong();

        try {
            MessageHelper.printMessage(String.valueOf(controller.deleteById(id)));
        }
        catch (NoSuchEntityException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }
}
