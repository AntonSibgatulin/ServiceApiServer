package ru.antonsibgatulin.serviceapiserver.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
User getUserByLoginAndPassword(String login,String password);
User getUserByLogin(String login);
User getUserByNumber(String number);
User getUserByMail(String email);

}
