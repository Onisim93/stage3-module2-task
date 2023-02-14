package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.annotation.CommandHandler;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NewsController implements BaseController<NewsDto, NewsDto, Long> {

    private final BaseService<NewsDto, NewsDto, Long> service;

    @Autowired
    public NewsController(BaseService<NewsDto, NewsDto, Long> service) {
        this.service = service;
    }

    @Override
    @CommandHandler(nameOperation = "GET_ALL_NEWS")
    public List<NewsDto> readAll() {
        return service.readAll();
    }

    @Override
    @CommandHandler(nameOperation = "GET_NEWS_BY_ID")
    public NewsDto readById(Long id) {
        return service.readById(id);
    }

    @Override
    @CommandHandler(nameOperation = "CREATE_NEWS")
    public NewsDto create(NewsDto createRequest) {
        return service.create(createRequest);
    }

    @Override
    @CommandHandler(nameOperation = "UPDATE_NEWS")
    public NewsDto update(NewsDto updateRequest) {
        return service.update(updateRequest);
    }

    @Override
    @CommandHandler(nameOperation = "DELETE_NEWS")
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
