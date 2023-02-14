package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.util.MessageHelper;
import com.mjc.school.service.dto.NewsDto;

public class GetAllNewsCommand implements Command{
    private final BaseController<NewsDto,NewsDto, Long> controller;

    public GetAllNewsCommand(BaseController<NewsDto, NewsDto, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        MessageHelper.printMessage(controller.readAll().toString());
    }
}
