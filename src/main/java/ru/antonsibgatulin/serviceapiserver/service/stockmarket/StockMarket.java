package ru.antonsibgatulin.serviceapiserver.service.stockmarket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double maxprice;
    private Integer typeWall;
    private Integer countOffer;
    private Long timeCreate;
    private Long time;
    private Long userId;
    private Integer deleted;
    private Integer block;


    public StockMarket(Long id, String name, String description, Double price, Double maxprice, Integer typeWall, Integer countOffer, Long timeCreate, Long time, Long userId, Integer deleted, Integer block) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.maxprice = maxprice;
        this.typeWall = typeWall;
        this.countOffer = countOffer;
        this.timeCreate = timeCreate;
        this.time = time;
        this.userId = userId;
        this.deleted = deleted;
        this.block = block;
    }

    public void init(){
        deleted = 0;
        block = 1;
        countOffer = 0;

    }


    public StockMarket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Double maxprice) {
        this.maxprice = maxprice;
    }

    public Integer getTypeWall() {
        return typeWall;
    }

    public void setTypeWall(Integer typeWall) {
        this.typeWall = typeWall;
    }

    public Integer getCountOffer() {
        return countOffer;
    }

    public void setCountOffer(Integer countOffer) {
        this.countOffer = countOffer;
    }

    public Long getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Long timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }
}
