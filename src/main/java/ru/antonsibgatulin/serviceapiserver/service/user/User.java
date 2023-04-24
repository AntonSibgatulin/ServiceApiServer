package ru.antonsibgatulin.serviceapiserver.service.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import ru.antonsibgatulin.serviceapiserver.service.lesson.Lesson;
import ru.antonsibgatulin.serviceapiserver.service.money.Money;
import ru.antonsibgatulin.serviceapiserver.service.pay.Pay;
import ru.antonsibgatulin.serviceapiserver.service.stockmarket.StockMarket;
import ru.antonsibgatulin.serviceapiserver.service.subject.UserSubject;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(name = "email",columnNames = "email"),
        @UniqueConstraint(name = "number",columnNames = "number")
})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",updatable = false)
    private Long userId;

    @Column(name = "login",columnDefinition = "VARCHAR(32)",nullable = false)
    private String login;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "password",columnDefinition = "VARCHAR(32)",nullable = false)
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "email",columnDefinition = "VARCHAR(35)",nullable = false)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "number",columnDefinition = "VARCHAR(20)",nullable = false)
    private String number;

    @Column(name = "name",columnDefinition = "VARCHAR(35)",nullable = false)
    private String name;

    @Column(name = "surname",columnDefinition = "VARCHAR(35)",nullable = false)
    private String surname;

    private Integer typeUser;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long type;
    private Long timeReg;
    private Long timeLastOnline;

    @Column(nullable = false)
    private Integer actionPage;//0 1-delete 2-ban 3-ban spam

    @ManyToOne
    @JoinTable(name = "profile_image_by_id")
    private ProfileImage profileImage;


    //@Query("FROM Money m where m.userId = ?1")
    //private Money money(Integer id);
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "money_id")
    private Money money;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_subjects_by_id")
    private List<UserSubject> lists;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String token;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stockmarket_id")
    public List<StockMarket> stockMarkets=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lesson_id")
    public List<Lesson> lessons = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pay_id")
    public List<Pay> pays=  new ArrayList<>();



    public User(String login, String password, String email, String number, String name, String surname, Integer typeUser, Long type, Long timeReg, Long timeLastOnline) {

        this.login = login;
        this.password = password;
        this.email = email;
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.typeUser = typeUser;
        this.type = type;
        this.timeReg = timeReg;
        this.timeLastOnline = timeLastOnline;
    }

    public User() {

    }

    public void predict(){
        this.setPassword(null);
        this.setMoney(null);
        this.setToken(null);
        this.setLogin(null);

        this.setNumber(null);
        this.setEmail(null);
        this.setPays(null);
    }

    public void predictClass(){
        password = null;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getTimeReg() {
        return timeReg;
    }

    public void setTimeReg(Long timeReg) {
        this.timeReg = timeReg;
    }

    public Long getTimeLastOnline() {
        return timeLastOnline;
    }

    public void setTimeLastOnline(Long timeLastOnline) {
        this.timeLastOnline = timeLastOnline;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<UserSubject> getLists() {
        return lists;
    }

    public void setLists(List<UserSubject> lists) {
        this.lists = lists;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<StockMarket> getStockMarkets() {
        return stockMarkets;
    }

    public void setStockMarkets(List<StockMarket> stockMarkets) {
        this.stockMarkets = stockMarkets;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Pay> getPays() {
        return pays;
    }

    public void setPays(List<Pay> pays) {
        this.pays = pays;
    }

    public Integer getActionPage() {
        return actionPage;
    }

    public void setActionPage(Integer actionPage) {
        this.actionPage = actionPage;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
    }

    public Pay deletePayAnotherByType(int type){
        for(Pay pay:pays){
            if(pay.getType() == type){
                pays.remove(pay);
                return pay;
            }
        }
        return null;
    }


    public void removeStockMarket(StockMarket stockMarket){
        for (StockMarket stockMarket1:stockMarkets){
            if (stockMarket.getId() == stockMarket1.getId()){
                stockMarkets.remove(stockMarket1);
                break;
            }
        }

    }
    /*
    public List<UserSubject> getLists() {
        return lists;
    }

    public void setLists(List<UserSubject> lists) {
        this.lists = lists;
    }

 */



    public Lesson deleteLessonAnotherByType(Long id) {
        for(Lesson lesson:lessons){
            if(lesson.getUserId() == id){
                lessons.remove(lesson);
                return lesson;
            }
        }
        return null;
    }
}
