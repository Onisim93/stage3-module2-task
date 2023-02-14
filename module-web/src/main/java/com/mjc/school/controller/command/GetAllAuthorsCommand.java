package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.util.MessageHelper;
import com.mjc.school.service.dto.AuthorDto;

public class GetAllAuthorsCommand implements Command{

    private final BaseController<AuthorDto, AuthorDto, Long> controller;

    public GetAllAuthorsCommand(BaseController<AuthorDto, AuthorDto, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        MessageHelper.printMessage(controller.readAll().toString());
    }
}
