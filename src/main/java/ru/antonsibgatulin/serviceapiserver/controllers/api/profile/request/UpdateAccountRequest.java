package ru.antonsibgatulin.serviceapiserver.controllers.api.profile.request;

import ru.antonsibgatulin.serviceapiserver.include.IRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.BadRequest;

public class UpdateAccountRequest implements IRequest {


    public Integer day;
    public Integer start;
    public Integer end;
    public String name;
    public String surname;
    public String minDescription;
    public String description ;
    public Integer typePayment;

    public UpdateAccountRequest(Integer day, Integer start, Integer end, String name, String surname, String minDescription, String description, Integer typePayment) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.name = name;
        this.surname = surname;
        this.minDescription = minDescription;
        this.description = description;
        this.typePayment = typePayment;
    }
    public UpdateAccountRequest(){

    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
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

    @Override
    public Exception getException() {
        if (start == null || end == null)
            return new BadRequest();
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
