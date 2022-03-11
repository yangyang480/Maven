package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity //now we can all this is entity class or the persist class.
@Table(name = "USERS") //table will be created by this name USERS, this name will be created rather than User.

public class User {
    //create pojo/model/persis object/entityclass
    //declare class variable
    //two default constructor
    //getter and setter

    //we will generate the table from this class by using @Entity @table on the top.
    @Column(name = "USER_ID") //we can create this column at anywhere any variable.
    @Id //this is specify the PK column. we can put this @id anywhere we want declare that variable to the the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    private String fullname;
   // @Column(name = "USER_email")
    private String email;
    private String password;
    private int age;
    private double salary;
    private String city;

    public User(String fullname, String email, String password, int age, double salary, String city) {

        this.userid = userid;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.city = city;
    }
    public User() {

    }

    public Integer getId() {
        return userid;
    }
    public void setId(Integer id) {
        this.userid = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
