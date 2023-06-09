package ru.antonsibgatulin.serviceapiserver.controllers.api.profile.request;

import ru.antonsibgatulin.serviceapiserver.include.ARequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.BadRequest;
import ru.antonsibgatulin.serviceapiserver.include.result.TypeResult;

public class UpdateAccountRequest extends ARequest implements IRequest {




    public String day;
    public Integer start;
    public Integer end;
    public String name;
    public String surname;
    public String minDescription;
    public String description ;
    public Integer typePayment;

    public Integer city;
    public Integer region;


    public UpdateAccountRequest(){

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


    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    @Override
    public TypeResult getException() {
        if(checkToken()!=null){
            return checkToken();
        }
        if (start == null || end == null)
            return new BadRequest().getError();
        if (start < 0)
            start = 0;
        if (start > 23)
            start = 0;


        if (end < 0)
            end = 0;
        if (end > 23)
            end = 0;


        if(start>end){
            int endd = end;
            end = start;
            start = endd;
        }

        return null;
    }
}
