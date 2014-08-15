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
            
            String query = "INSERT INTO Patient (chartno, fullname, birthday, sex, address, philhealth, dateadmitted, physician, diagnosis, room, remarks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, p.getChartno());
            ps.setString(2, p.getFullname());
            ps.setDate(3, new java.sql.Date(p.getBirthday().getTime().getTime())); // convert to Date object
            ps.setString(4, p.getSex());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getPhilhealth());
            ps.setDate(7, new java.sql.Date(p.getDateAdmitted().getTime().getTime()));
            ps.setString(8, p.getPhysician());
            ps.setString(9, p.getDiagnosis());
            ps.setString(10, p.getRoom());
            ps.setString(11, p.getRemarks());
            
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
                Date d = rs.getDate(4);
                Calendar c = new GregorianCalendar();
                c.setTimeInMillis(d.getTime());
                p.setBirthday(c);
                p.setSex(rs.getString(5));
                p.setAddress(rs.getString(6));
                p.setPhilhealth(rs.getString(7));
                d = rs.getDate(8);
                c.setTimeInMillis(d.getTime());
                p.setDateAdmitted(c);
                p.setPhysician(rs.getString(9));
                p.setDiagnosis(rs.getString(10));
                p.setRoom(rs.getString(11));
                p.setRemarks(rs.getString(12));
                
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
                Date d = rs.getDate(4);
                Calendar c = new GregorianCalendar();
                c.setTimeInMillis(d.getTime());
                p.setBirthday(c);
                p.setSex(rs.getString(5));
                p.setAddress(rs.getString(6));
                p.setPhilhealth(rs.getString(7));
                d = rs.getDate(8);
                c.setTimeInMillis(d.getTime());
                p.setDateAdmitted(c);
                p.setPhysician(rs.getString(9));
                p.setDiagnosis(rs.getString(10));
                p.setRoom(rs.getString(11));
                p.setRemarks(rs.getString(12));
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
            
            String query = "UPDATE PATIENT SET chartno = ?, fullname = ?, birthday = ?, sex = ?, address = ?, philhealth = ?, dateadmitted = ?, physician = ?, diagnosis = ?, room = ?, remarks = ? WHERE patientid = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, newData.getChartno());
            ps.setString(2, newData.getFullname());
            ps.setDate(3, new java.sql.Date(newData.getBirthday().getTime().getTime())); // convert to Date object
            ps.setString(4, newData.getSex());
            ps.setString(5, newData.getAddress());
            ps.setString(6, newData.getPhilhealth());
            ps.setDate(7, new java.sql.Date(newData.getDateAdmitted().getTime().getTime()));
            ps.setString(8, newData.getPhysician());
            ps.setString(9, newData.getDiagnosis());
            ps.setString(10, newData.getRoom());
            ps.setString(11, newData.getRemarks());
            ps.setInt(12, newData.getPatientid());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
