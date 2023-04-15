package ru.antonsibgatulin.serviceapiserver.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.user.TokenUser;

public interface TokenUserRepository extends JpaRepository<TokenUser,Long> {



}
