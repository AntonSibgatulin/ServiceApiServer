package ru.antonsibgatulin.serviceapiserver.include.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.antonsibgatulin.serviceapiserver.service.lesson.Lesson;
import ru.antonsibgatulin.serviceapiserver.service.stockmarket.StockMarket;
import ru.antonsibgatulin.serviceapiserver.service.subject.Subject;
import ru.antonsibgatulin.serviceapiserver.service.user.Account;
import ru.antonsibgatulin.serviceapiserver.service.user.TokenUser;
import ru.antonsibgatulin.serviceapiserver.service.user.User;

import java.util.List;


public class TypeResult {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Account account;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TokenUser tokenUser;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Subject subject;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public StockMarket stockMarket;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Subject> subjectList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<StockMarket> stockMarketList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Lesson lesson = null;



    public TypeResult(String message,int code,String type){
        this.code = code;
        this.message = message;
        this.type  = type;

    }

    public TypeResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user.predictClass();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TokenUser getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(TokenUser tokenUser) {
        this.tokenUser = tokenUser;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public StockMarket getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<StockMarket> getStockMarketList() {
        return stockMarketList;
    }

    public void setStockMarketList(List<StockMarket> stockMarketList) {
        this.stockMarketList = stockMarketList;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
