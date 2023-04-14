package ru.antonsibgatulin.serviceapiserver.user;

import jakarta.persistence.*;

@Entity(name = "Account")
public class Account {


    @Id
    @SequenceGenerator(name = "account_squence",sequenceName = "account_squence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "account_squence")
    private Long id;

    @Column(unique = true,nullable = false)
    private Long userId;

    @Column(nullable = false,columnDefinition = "VARCHAR(256)")
    private String minDescription;

    @Column(nullable = true,columnDefinition = "VARCHAR(4096)")
    private String description ;

    private Integer typePayment;
    private Integer phoneTrue;
    private Long region;
    private Long city;
    private Integer emailTrue;

    public Account(Long id, Long userId, String minDescription, String description, Integer typePayment, Integer phoneTrue, Long region, Long city, Integer emailTrue) {
        this.id = id;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Integer getEmailTrue() {
        return emailTrue;
    }

    public void setEmailTrue(Integer emailTrue) {
        this.emailTrue = emailTrue;
    }
}
