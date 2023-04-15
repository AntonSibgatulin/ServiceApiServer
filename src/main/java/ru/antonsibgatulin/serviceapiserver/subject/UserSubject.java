package ru.antonsibgatulin.serviceapiserver.subject;

import jakarta.persistence.*;

@Entity
public class UserSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private Long id_subject;
    private Double price_on_hour;
    private Integer experience;

    @Column(nullable = false)
    private String information;

    private Integer online;
    private Integer intramural;
    private Integer oplata;
    private Integer block;

    public UserSubject(Long id, Long id_subject, Double price_on_hour, Integer experience, String information, Integer online, Integer intramural, Integer oplata, Integer block) {
        this.id = id;
        this.id_subject = id_subject;
        this.price_on_hour = price_on_hour;
        this.experience = experience;
        this.information = information;
        this.online = online;
        this.intramural = intramural;
        this.oplata = oplata;
        this.block = block;
    }

    public UserSubject() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId_subject() {
        return id_subject;
    }

    public void setId_subject(Long id_subject) {
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
