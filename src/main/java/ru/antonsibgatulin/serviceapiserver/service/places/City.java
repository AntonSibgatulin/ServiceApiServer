package ru.antonsibgatulin.serviceapiserver.service.places;

import jakarta.persistence.*;

@Entity(name = "City")
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer City_id;
    private Integer country_id;
    private Integer region_id;
    private String name;
    private Long yandex_id;


    public City(Long id, Integer city_id, Integer country_id, Integer region_id, String name, Long yandex_id) {
        this.id = id;
        this.City_id = city_id;
        this.country_id = country_id;
        this.region_id = region_id;
        this.name = name;
        this.yandex_id = yandex_id;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCity_id() {
        return City_id;
    }

    public void setCity_id(Integer city_id) {
        this.City_id = city_id;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYandex_id() {
        return yandex_id;
    }

    public void setYandex_id(Long yandex_id) {
        this.yandex_id = yandex_id;
    }
}
