/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

/**
 *
 * @author Jarrette
 */
public class Patient {
    
    private int id;
    private String lname;
    private String fname;
    private String mi;
    private String sex;
    private String birthday;
    private String city;

    public Patient() {
    
    }

    public Patient(int id, String lname, String fname, String mi, String sex, String birthday) {
        this.id = id;
        this.lname = lname;
        this.fname = fname;
        this.mi = mi;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public String getSex() {
        return sex;
    }

    public String getMi() {
        return mi;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
}
