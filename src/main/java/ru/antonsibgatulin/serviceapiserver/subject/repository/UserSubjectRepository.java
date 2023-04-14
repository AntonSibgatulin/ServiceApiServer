package ru.antonsibgatulin.serviceapiserver.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.subject.UserSubject;

public interface UserSubjectRepository extends JpaRepository<UserSubject,Long> {
}
