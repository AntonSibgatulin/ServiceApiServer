package ru.antonsibgatulin.serviceapiserver.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.subject.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
