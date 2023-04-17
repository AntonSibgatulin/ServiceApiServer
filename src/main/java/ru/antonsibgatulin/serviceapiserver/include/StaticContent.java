package ru.antonsibgatulin.serviceapiserver.include;

public class StaticContent {
    public static Long timeToDay(){
        return System.currentTimeMillis()-1000*60*60*24;
    }
}
