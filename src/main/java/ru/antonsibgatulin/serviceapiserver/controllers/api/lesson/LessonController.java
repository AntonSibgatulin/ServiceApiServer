package ru.antonsibgatulin.serviceapiserver.controllers.api.lesson;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.serviceapiserver.controllers.api.lesson.request.CreateLessonRequest;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.TokenUserRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class LessonController {

    private final UserRepository userRepository;
    private final TokenUserRepository tokenUserRepository;

    public LessonController(UserRepository userRepository, TokenUserRepository tokenUserRepository) {
        this.userRepository = userRepository;
        this.tokenUserRepository = tokenUserRepository;
    }


    @RequestMapping("/create")
    public TypeResult typeResult(@Valid @RequestBody CreateLessonRequest createLessonRequest){

        return null;
    }
}
