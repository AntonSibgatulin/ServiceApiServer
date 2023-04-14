package ru.antonsibgatulin.serviceapiserver.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.money.Money;

public interface MoneyRepository extends JpaRepository<Money,Long> {
}
