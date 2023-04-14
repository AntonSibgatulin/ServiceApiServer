package ru.antonsibgatulin.serviceapiserver.money;

import jakarta.persistence.*;

@Entity
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true,nullable = false)
    private Long userId;

    private Double money;

    public Money(Long id, Long userId, Double money) {
        this.id = id;
        this.userId = userId;
        this.money = money;
    }

    public Money() {

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
