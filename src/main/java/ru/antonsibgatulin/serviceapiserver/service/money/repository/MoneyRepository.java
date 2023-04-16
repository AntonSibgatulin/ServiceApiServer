package ru.antonsibgatulin.serviceapiserver.service.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.money.Money;

public interface MoneyRepository extends JpaRepository<Money,Long> {
}
