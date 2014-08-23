/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Patient;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeffrey
 */
public class DAOImpl implements DAOIntf {

    @Override
    public void addPatient(Patient p) {
        try {
            Connection conn = new Connector().getConnection();
            
            String query = "INSERT INTO Patient (chartno, fullname, birthday, sex, address, philhealth, dateadmitted, physician, diagnosis, room, remarks, priority) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, p.getChartno());
            ps.setString(2, p.getFullname());
            ps.setInt(3, p.getBirthday()); 
            ps.setString(4, p.getSex());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getPhilhealth());
            ps.setString(7, p.getDateAdmitted());
            ps.setString(8, p.getPhysician());
            ps.setString(9, p.getDiagnosis());
            ps.setString(10, p.getRoom());
            ps.setString(11, p.getRemarks());
            ps.setString(12, p.getPrioritylevel());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void removePatient(int id) {
        try {
            Connection conn = new Connector().getConnection();
            
            String query = "DELETE FROM Patient WHERE patientid = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Patient> getAllPatients() {
        try {
            Connection conn = new Connector().getConnection();
            
            String query = "SELECT * FROM Patient";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Patient> lahatPatient = new ArrayList<>();
            while(rs.next()) {
                Patient p = new Patient();
                
                p.setPatientid(rs.getInt(1));
                p.setChartno(rs.getInt(2));
                p.setFullname(rs.getString(3));
                p.setBirthday(rs.getInt(4));
                p.setSex(rs.getString(5));
                p.setAddress(rs.getString(6));
                p.setPhilhealth(rs.getString(7));
                p.setDateAdmitted(rs.getString(8));
                p.setPhysician(rs.getString(9));
                p.setDiagnosis(rs.getString(10));
                p.setRoom(rs.getString(11));
                p.setRemarks(rs.getString(12));
                p.setPrioritylevel(rs.getString(13));
                
                lahatPatient.add(p);
            }
            
            return lahatPatient;
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Patient getPatient(int id) {
        try {
            Connection conn = new Connector().getConnection();
            
            String query = "SELECT * FROM Patient WHERE patientid = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Patient p = new Patient();
            if(rs.next()) {
                p.setPatientid(rs.getInt(1));
                p.setChartno(rs.getInt(2));
                p.setFullname(rs.getString(3));
                p.setBirthday(rs.getInt(4));
                p.setSex(rs.getString(5));
                p.setAddress(rs.getString(6));
                p.setPhilhealth(rs.getString(7));
                p.setDateAdmitted(rs.getString(8));
                p.setPhysician(rs.getString(9));
                p.setDiagnosis(rs.getString(10));
                p.setRoom(rs.getString(11));
                p.setRemarks(rs.getString(12));
                p.setPrioritylevel(rs.getString(13));
            }
            
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void editPatient(int id, Patient newData) {
        try {
            Connection conn = new Connector().getConnection();
            
            String query = "UPDATE PATIENT SET chartno = ?, fullname = ?, birthday = ?, sex = ?, address = ?, philhealth = ?, dateadmitted = ?, physician = ?, diagnosis = ?, room = ?, remarks = ?, priority = ? WHERE patientid = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, newData.getChartno());
            ps.setString(2, newData.getFullname());
            ps.setInt(3, newData.getBirthday());
            ps.setString(4, newData.getSex());
            ps.setString(5, newData.getAddress());
            ps.setString(6, newData.getPhilhealth());
            ps.setString(7, newData.getDateAdmitted());
            ps.setString(8, newData.getPhysician());
            ps.setString(9, newData.getDiagnosis());
            ps.setString(10, newData.getRoom());
            ps.setString(11, newData.getRemarks());
            ps.setString(12, newData.getPrioritylevel());
            ps.setInt(13, newData.getPatientid());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Patient> searchPatientName(String subStr) {
        ArrayList<Patient> allPatients = getAllPatients();
        ArrayList<Patient> matches = new ArrayList<>();
        for(int i = 0; i < allPatients.size(); i++) {
            if(allPatients.get(i).getFullname().toLowerCase().contains(subStr.toLowerCase()))
                matches.add(allPatients.get(i));
        }
        return matches;
    }
    
    
    
    
}
