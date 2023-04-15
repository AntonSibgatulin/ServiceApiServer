package ru.antonsibgatulin.serviceapiserver.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.user.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
