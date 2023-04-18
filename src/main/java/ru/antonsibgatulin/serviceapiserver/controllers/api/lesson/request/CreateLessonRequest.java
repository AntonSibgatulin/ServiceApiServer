package ru.antonsibgatulin.serviceapiserver.controllers.api.lesson.request;

import ru.antonsibgatulin.serviceapiserver.include.ARequest;
import ru.antonsibgatulin.serviceapiserver.include.IRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.BadRequest;
import ru.antonsibgatulin.serviceapiserver.include.exceptions.UnauthorizedResponse;

public class CreateLessonRequest extends ARequest implements IRequest {



    public Integer id_subject;
    public Double price_on_hour;
    public Integer experience;// 0 - 0 , 1 <12month , 2 - 1year, 3>1year and <3 ,4 more 3 year
    public String information;
    public Integer online;
    public Integer intramural;
    public Integer oplata;

    public CreateLessonRequest() {
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


    @Override
    public Exception getException() {
        if(checkToken() !=null){
            return new UnauthorizedResponse();
        }
        if(experience>4 || experience<0){
            return new BadRequest();
        }
        if(online!= 0 && online != 1){
            online = 0;

        }
        if(oplata!=0 && oplata != 1 && oplata!= 2){
           oplata = 0;
        }
        if(information.length()>4096){
            information = information.substring(0,256);

        }

        return null;
    }
}
