/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.Calendar;

/**
 *
 * @author Jeffrey
 */
public class Patient {
    
    private int patientid;
    private int chartno;
    private String fullname;
    private int birthday;   // birthyear
    private String sex;
    private String address;
    private String philhealth;
    private String dateAdmitted;
    private String physician;
    private String diagnosis;
    private String room;
    private String remarks;
    private String priority;

    
    public int getPatientid() {
        return patientid;
    }

    
    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    
    public int getChartno() {
        return chartno;
    }

    
    public void setChartno(int chartno) {
        this.chartno = chartno;
    }

    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    
    public int getBirthday() {
        return birthday;
    }

    
    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    
    public String getSex() {
        return sex;
    }

    
    public void setSex(String sex) {
        this.sex = sex;
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address;
    }

    
    public String getPhilhealth() {
        return philhealth;
    }

    
    public void setPhilhealth(String philhealth) {
        this.philhealth = philhealth;
    }

    
    public String getDateAdmitted() {
        return dateAdmitted;
    }

    
    public void setDateAdmitted(String dateAdmitted) {
        this.dateAdmitted = dateAdmitted;
    }

    
    public String getPhysician() {
        return physician;
    }

    
    public void setPhysician(String physician) {
        this.physician = physician;
    }

    
    public String getDiagnosis() {
        return diagnosis;
    }

    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    
    public String getRoom() {
        return room;
    }

    
    public void setRoom(String room) {
        this.room = room;
    }

    
    public String getRemarks() {
        return remarks;
    }

    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
}
