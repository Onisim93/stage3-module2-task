package com.mjc.school.main.menu;

import lombok.Getter;

@Getter
public enum MenuCommand {
    EXIT("0 - Exit."),
    CREATE_NEWS("1 - Create News."),
    CREATE_AUTHOR("2 - Create Author."),
    GET_ALL_NEWS("3 - Get all news."),
    GET_ALL_AUTHORS("4 - Get all authors."),
    GET_NEWS_BY_ID("5 - Get News by id."),
    GET_AUTHOR_BY_ID("6 - Get Author by id."),
    UPDATE_NEWS("7 - Update News."),
    UPDATE_AUTHOR("8 - Update Author."),
    DELETE_NEWS("9 - Delete News by id."),
    DELETE_AUTHOR("10 - Delete Author by id.");


    private final String description;

    MenuCommand(String description) {
        this.description = description;
    }
}
