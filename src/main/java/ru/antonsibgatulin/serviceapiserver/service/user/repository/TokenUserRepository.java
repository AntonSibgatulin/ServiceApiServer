package ru.antonsibgatulin.serviceapiserver.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;

public interface TokenUserRepository extends JpaRepository<TokenUser,Long> {

TokenUser getTokenUserByToken(String token);


}
