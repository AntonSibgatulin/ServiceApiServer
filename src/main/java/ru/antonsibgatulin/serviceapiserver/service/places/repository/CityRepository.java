package ru.antonsibgatulin.serviceapiserver.service.places.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.places.City;

public interface CityRepository extends JpaRepository<City,Long> {
    //City getCityByCity_id(Integer id);
    City getCityById(Integer city);
}
