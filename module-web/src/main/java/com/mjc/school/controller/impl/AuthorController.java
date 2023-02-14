package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.annotation.CommandHandler;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController implements BaseController<AuthorDto, AuthorDto, Long> {

    private final BaseService<AuthorDto, AuthorDto, Long> service;

    @Autowired
    public AuthorController(BaseService<AuthorDto, AuthorDto, Long> service) {
        this.service = service;
    }

    @Override
    @CommandHandler(nameOperation = "GET_ALL_AUTHORS")
    public List<AuthorDto> readAll() {
        return service.readAll();
    }

    @Override
    @CommandHandler(nameOperation = "GET_AUTHOR_BY_ID")
    public AuthorDto readById(Long id) {
        return service.readById(id);
    }

    @Override
    @CommandHandler(nameOperation = "CREATE_AUTHOR")
    public AuthorDto create(AuthorDto createRequest) {
        return service.create(createRequest);
    }

    @Override
    @CommandHandler(nameOperation = "UPDATE_AUTHOR")
    public AuthorDto update(AuthorDto updateRequest) {
        return service.update(updateRequest);
    }

    @Override
    @CommandHandler(nameOperation = "DELETE_AUTHOR")
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
