package ru.antonsibgatulin.serviceapiserver.controllers.api.get.request;

public class RegRequest {

    public String login;
    public String password;
    public String email;
    public String number;
    public String name;
    public String surname;
    public Integer typeUser;

    public Integer code = 400;

    public RegRequest(String login, String password, String email, String number, String name, String surname, Integer typeUser) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.typeUser = typeUser;
    }

    public RegRequest() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }
}
