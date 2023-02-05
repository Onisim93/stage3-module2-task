package com.mjc.school.service.aop;

import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Objects;

@Aspect
@Component
public class MyAspect {

    private final BaseService<NewsDto, NewsDto, Long> newsService;

    @Autowired
    public MyAspect(BaseService<NewsDto, NewsDto, Long> newsService) {
        this.newsService = newsService;
    }

    @Pointcut("@annotation(com.mjc.school.service.aop.annotation.OnDelete)")
    public void deleteAuthor(){}


    @After("deleteAuthor()")
    public void afterDeleteAuthorAdvice(JoinPoint joinPoint) {
        Long id = (Long) joinPoint.getArgs()[0];
        List<NewsDto> newsDtoList = newsService.readAll().stream().filter((d) -> Objects.equals(d.getAuthorId(), id)).toList();
        newsDtoList.forEach(d -> newsService.deleteById(d.getId()));
    }
}
