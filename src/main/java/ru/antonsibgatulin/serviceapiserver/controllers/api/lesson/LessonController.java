package ru.antonsibgatulin.serviceapiserver.controllers.api.lesson;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.serviceapiserver.controllers.api.lesson.request.CreateLessonRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.ForbiddenException;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.NotFoundRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.UnauthorizedResponse;
import ru.antonsibgatulin.serviceapiserver.include.request.DeleteRequest;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;
import ru.antonsibgatulin.serviceapiserver.service.lesson.Lesson;
import ru.antonsibgatulin.serviceapiserver.service.lesson.repository.LessonMapper;
import ru.antonsibgatulin.serviceapiserver.service.lesson.repository.LessonRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.service.user.User;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/lesson")
public class LessonController {

    private final UserRepository userRepository;
    private final TokenUserRepository tokenUserRepository;
    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;



    public LessonController(UserRepository userRepository, TokenUserRepository tokenUserRepository, LessonMapper lessonMapper, LessonRepository lessonRepository) {
        this.userRepository = userRepository;
        this.tokenUserRepository = tokenUserRepository;
        this.lessonMapper = lessonMapper;
        this.lessonRepository = lessonRepository;
    }


    @PostMapping("/create")
    public TypeResult createLesson(@Valid @RequestBody CreateLessonRequest createLessonRequest) throws Exception {
        if (createLessonRequest.getException()!=null) {
            return createLessonRequest.getException();

        }
        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(createLessonRequest.getToken());
        if(tokenUser==null){
            return new UnauthorizedResponse().getError();
        }
        User user = userRepository.getUserByUserId(tokenUser.getUserId());
        Lesson lesson = lessonMapper.fromLessonRequestToLesson(createLessonRequest);
        user.lessons.add(lesson);
        userRepository.save(user);
        TypeResult typeResult = new TypeResult("ok",200,"create_lesson");
        typeResult.setUser(user);

        return typeResult;
    }


    @PostMapping("/update/{id}")
    public TypeResult updateLesson(@PathVariable("id") Long id,@Valid @RequestBody CreateLessonRequest createLessonRequest) throws Exception {
        if (createLessonRequest.getException()!=null) {
            return createLessonRequest.getException();

        }
        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(createLessonRequest.getToken());
        if(tokenUser==null){
            return new UnauthorizedResponse().getError();
        }
        User user = userRepository.getUserByUserId(tokenUser.getUserId());
        Lesson lesson = lessonRepository.getLessonById(id);
        if (lesson == null) {
            return new NotFoundRequest().getError();
        }
        if (lesson.getUserId() == user.getUserId() || user.getType() > 0) {



            lesson.setId_subject(createLessonRequest.getId_subject());
            lesson.setPrice_on_hour(createLessonRequest.getPrice_on_hour());
            lesson.setExperience(createLessonRequest.getExperience());
            lesson.setInformation(createLessonRequest.getInformation());
            lesson.setOnline(createLessonRequest.getOnline());
            lesson.setIntramural(createLessonRequest.getIntramural());
            lesson.setOplata(createLessonRequest.getOplata());

            lessonRepository.save(lesson);

        }

        TypeResult typeResult = new TypeResult("ok",200,"update_lesson");
        typeResult.setUser(userRepository.getUserByUserId(tokenUser.getUserId()));

        return typeResult;
    }

    @PostMapping("/delete/{id}")
    public TypeResult deleteLesson(@PathVariable("id") Long id, @Valid @RequestBody DeleteRequest deleteRequest) throws Exception {
        TypeResult typeResult = new TypeResult("ok",200,"delete_lesson_by_id");
        if(deleteRequest.getException()!=null){
            return deleteRequest.getException();
        }


        TokenUser tokenUser = tokenUserRepository.getTokenUserByToken(deleteRequest.getToken());
        if(tokenUser==null){
            return new UnauthorizedResponse().getError();
        }

        User user = userRepository.getUserByUserId(tokenUser.getUserId());

        Lesson lesson = lessonRepository.getLessonById(id);
        if(lesson == null){
            return new NotFoundRequest().getError();
        }
        if (lesson.getUserId() == user.getUserId() || user.getType() > 0){
           Lesson lesson1 = user.deleteLessonAnotherByType(lesson.getId());
            if(lesson1!=null){
                userRepository.save(user);
            }
            lessonRepository.delete(lesson);
        }else{
            return new ForbiddenException().getError();
        }
        typeResult.setUser(user);

       return typeResult;
    }
}
