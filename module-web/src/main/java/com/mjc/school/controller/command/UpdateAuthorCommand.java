package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.util.MessageHelper;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.exception.ValidatorException;

import static com.mjc.school.controller.command.CommandConstants.ENTER_ID;
import static com.mjc.school.controller.command.CommandConstants.ENTER_NAME;

public class UpdateAuthorCommand implements Command{

    private final BaseController<AuthorDto, AuthorDto, Long> controller;

    public UpdateAuthorCommand(BaseController<AuthorDto, AuthorDto, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        MessageHelper.printMessage(ENTER_ID);
        Long id = MessageHelper.readLong();
        MessageHelper.printMessage(ENTER_NAME);
        String name  = MessageHelper.readString();

        AuthorDto authorDto = new AuthorDto(id, name);

        try {
            AuthorDto updated = controller.update(authorDto);
            MessageHelper.printMessage(updated.toString());
        }
        catch (NoSuchEntityException | ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }
}
