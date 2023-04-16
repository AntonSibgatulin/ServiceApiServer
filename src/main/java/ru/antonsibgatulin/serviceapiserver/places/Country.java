package ru.antonsibgatulin.serviceapiserver.places;

import jakarta.persistence.*;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private Integer country_id;
    private Integer city_id;
    private Integer name;

    @Column(name = "short")
    private Integer short_n;

    public Country(Long id, Integer country_id, Integer city_id, Integer name, Integer short_n) {
        this.id = id;
        this.country_id = country_id;
        this.city_id = city_id;
        this.name = name;
        this.short_n = short_n;
    }

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getShort_n() {
        return short_n;
    }

    public void setShort_n(Integer short_n) {
        this.short_n = short_n;
    }
}
