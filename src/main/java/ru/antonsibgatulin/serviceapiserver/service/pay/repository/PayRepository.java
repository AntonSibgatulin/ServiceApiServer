package ru.antonsibgatulin.serviceapiserver.service.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.pay.Pay;

public interface PayRepository extends JpaRepository<Pay,Long> {
    Pay getPayById(Long id);
}
