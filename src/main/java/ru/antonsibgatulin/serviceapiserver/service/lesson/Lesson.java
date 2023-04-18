package ru.antonsibgatulin.serviceapiserver.service.lesson;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Integer id_subject;
    private Double price_on_hour;
    private Integer experience;// 0 - 0 , 1 <12month , 2 - 1year, 3>1year and <3 ,4 more 3 year
    private String information;
    private Integer online;
    private Integer intramural;
    private Integer oplata;
    private Integer block;

    public Lesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getId_subject() {
        return id_subject;
    }

    public void setId_subject(Integer id_subject) {
        this.id_subject = id_subject;
    }

    public Double getPrice_on_hour() {
        return price_on_hour;
    }

    public void setPrice_on_hour(Double price_on_hour) {
        this.price_on_hour = price_on_hour;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getIntramural() {
        return intramural;
    }

    public void setIntramural(Integer intramural) {
        this.intramural = intramural;
    }

    public Integer getOplata() {
        return oplata;
    }

    public void setOplata(Integer oplata) {
        this.oplata = oplata;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }
}
