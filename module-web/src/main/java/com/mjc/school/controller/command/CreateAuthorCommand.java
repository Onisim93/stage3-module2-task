package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.util.MessageHelper;
import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.exception.ValidatorException;

import static com.mjc.school.controller.command.CommandConstants.ENTER_NAME;

public class CreateAuthorCommand implements Command{

    private final BaseController<AuthorDto, AuthorDto, Long> controller;

    public CreateAuthorCommand(BaseController<AuthorDto, AuthorDto, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        MessageHelper.printMessage(ENTER_NAME);
        String name = MessageHelper.readString();

        AuthorDto authorDto = new AuthorDto(name);

        try {
            AuthorDto created = controller.create(authorDto);
            MessageHelper.printMessage(created.toString());
        }
        catch (ValidatorException e) {
            MessageHelper.printMessage(e.getMessage());
        }
    }
}
