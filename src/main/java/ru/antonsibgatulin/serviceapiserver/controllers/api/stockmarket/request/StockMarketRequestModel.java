package ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request;


import ru.antonsibgatulin.serviceapiserver.include.ARequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

public class StockMarketRequestModel extends ARequest implements IRequest {

    public Long id;
    public String name;
    public String description;
    public Double price;
    public Double maxprice;
    public Integer typeWall;
    //public Integer countOffer;
    public Long timeCreate=System.currentTimeMillis();
    public Long time=24*1000*60*60*2L;


    public StockMarketRequestModel() {
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
/*
    public Integer getCountOffer() {
        return countOffer;
    }

    public void setCountOffer(Integer countOffer) {
        this.countOffer = countOffer;
    }

 */

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



    @Override
    public TypeResult getException() {
        if(checkToken()!=null){
            return checkToken();
        }
        return null;
    }
}
