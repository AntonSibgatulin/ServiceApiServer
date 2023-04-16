package ru.antonsibgatulin.serviceapiserver.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
User getUserByLoginAndPassword(String login,String password);
User getUserByLogin(String login);
User getUserByNumber(String number);
User getUserByEmail(String email);

User getUserByUserId(Long id);

}
