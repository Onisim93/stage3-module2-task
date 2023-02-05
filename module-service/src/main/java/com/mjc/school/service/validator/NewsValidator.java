package com.mjc.school.service.validator;

import com.mjc.school.service.dto.NewsDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NewsValidator extends BaseValidator<NewsDto>{
    @Override
    public void validate(NewsDto newsDto) {
        validateString(newsDto.getTitle(), Constants.NEWS_TITLE.getDescription(), Constants.NEWS_TITLE.getMinValue(), Constants.NEWS_TITLE.getMaxValue());
        validateString(newsDto.getContent(), Constants.NEWS_CONTENT.getDescription(), Constants.NEWS_CONTENT.getMinValue(), Constants.NEWS_CONTENT.getMaxValue());
        validateNumber(newsDto.getAuthorId(), Constants.AUTHOR_ID.getDescription());
    }

    @Override
    public void validateId(Long id) {
        validateNumber(id, Constants.NEWS_ID.getDescription());
    }
}
