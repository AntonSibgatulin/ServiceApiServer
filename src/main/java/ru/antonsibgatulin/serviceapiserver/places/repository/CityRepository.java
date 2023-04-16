package ru.antonsibgatulin.serviceapiserver.places.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.places.City;

public interface CityRepository extends JpaRepository<City,Long> {
    City getCityByCity_id(Long id);

}
