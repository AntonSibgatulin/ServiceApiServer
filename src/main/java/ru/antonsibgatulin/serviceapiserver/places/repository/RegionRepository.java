package ru.antonsibgatulin.serviceapiserver.places.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.serviceapiserver.places.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region getRegionByRegion_id(Long id);
}
