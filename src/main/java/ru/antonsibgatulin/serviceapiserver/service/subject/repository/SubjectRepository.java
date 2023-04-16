package ru.antonsibgatulin.serviceapiserver.service.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.subject.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
