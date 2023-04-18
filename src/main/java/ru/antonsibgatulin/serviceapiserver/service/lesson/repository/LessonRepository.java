package ru.antonsibgatulin.serviceapiserver.service.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.lesson.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    Lesson getLessonById(Long id);
    Lesson getLessonByUserId(Long userId);

}
