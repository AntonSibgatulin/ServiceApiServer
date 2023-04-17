package ru.antonsibgatulin.serviceapiserver.service.user;

import jakarta.persistence.*;
import ru.antonsibgatulin.serviceapiserver.service.places.City;
import ru.antonsibgatulin.serviceapiserver.service.places.Region;

@Entity(name = "Account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Account {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = true,columnDefinition = "VARCHAR(256)")
    private String minDescription;

    @Column(nullable = true,columnDefinition = "VARCHAR(4096)")
    private String description ;

    private Integer typePayment;
    private Integer phoneTrue;


    @ManyToOne
    @JoinColumn(name = "region")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "city")
    private City city;

    private Integer emailTrue;

    private String day;
    private Integer start;
    private Integer end;

    @Transient
    private String name;
    @Transient
    private String surname;

    public Account(Long id, String minDescription, String description, Integer typePayment, Integer phoneTrue, Region region, City city, Integer emailTrue) {
        this.id = id;
        this.minDescription = minDescription;
        this.description = description;
        this.typePayment = typePayment;
        this.phoneTrue = phoneTrue;
        this.region = region;
        this.city = city;
        this.emailTrue = emailTrue;
    }

    public Account() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  public String getMinDescription() {
        return minDescription;
    }

    public void setMinDescription(String minDescription) {
        this.minDescription = minDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(Integer typePayment) {
        this.typePayment = typePayment;
    }

    public Integer getPhoneTrue() {
        return phoneTrue;
    }

    public void setPhoneTrue(Integer phoneTrue) {
        this.phoneTrue = phoneTrue;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getEmailTrue() {
        return emailTrue;
    }

    public void setEmailTrue(Integer emailTrue) {
        this.emailTrue = emailTrue;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
