package ru.antonsibgatulin.serviceapiserver.service.places.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.service.places.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region getRegionById(Integer id);
}
