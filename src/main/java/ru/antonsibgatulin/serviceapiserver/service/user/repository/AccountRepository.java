package ru.antonsibgatulin.serviceapiserver.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.user.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
