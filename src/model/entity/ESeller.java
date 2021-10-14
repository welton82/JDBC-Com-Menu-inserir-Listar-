package model.entity;

import exception.Exception;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ESeller {
    private Integer id;
    private String name;
    private String email;
    private java.sql.Date birthdate;
    private Double baseSalary;
    private Integer department;



    public ESeller() {
    }

    public ESeller(String name, String email, String dat, Double baseSalary, Integer department) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.name = name;
        this.email = email;
        java.util.Date data ;
        try{
            data = sdf.parse(dat);
            this.birthdate = (java.sql.Date) new java.sql.Date(data.getTime());

        } catch (ParseException e) {
            throw new Exception(e.getMessage());
        }


        this.baseSalary = baseSalary;
        this.department = department;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  java.sql.Date getBirthdate() {

        return birthdate;
    }

    public void setBirthdate(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        try{
            date = sdf.parse(d);
            java.sql.Date myDate = (java.sql.Date) new java.sql.Date(date.getTime());
            this.birthdate = myDate;

        } catch (ParseException e) {
            throw new Exception(e.getMessage());
        }

        this.birthdate = birthdate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }
}
