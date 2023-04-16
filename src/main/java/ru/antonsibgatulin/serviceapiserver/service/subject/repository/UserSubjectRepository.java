package ru.antonsibgatulin.serviceapiserver.service.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.subject.UserSubject;

public interface UserSubjectRepository extends JpaRepository<UserSubject,Long> {
}
