package ru.antonsibgatulin.serviceapiserver.service.lesson.repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.antonsibgatulin.serviceapiserver.controllers.api.lesson.request.CreateLessonRequest;
import ru.antonsibgatulin.serviceapiserver.service.lesson.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(target = "id_subject",source = "id_subject")
    @Mapping(target = "price_on_hour",source = "price_on_hour")
    @Mapping(target = "experience",source = "experience")
    @Mapping(target = "information",source = "information")
    @Mapping(target = "online",source = "online")
    @Mapping(target = "intramural",source = "intramural")
    @Mapping(target = "oplata",source = "oplata")
    Lesson fromLessonRequestToLesson(CreateLessonRequest request);
}
