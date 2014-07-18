/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Patient;
import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            
            String query = "INSERT INTO Patient (lname, fname, mi, sex, birthday, city) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getLname());
            ps.setString(2, p.getFname());
            ps.setString(3, p.getMi());
            ps.setString(4, p.getSex());
            ps.setString(5, p.getBirthday());
            ps.setString(6, p.getCity());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void removePatient(int id) {
        try {
            Connection conn = new Connector().getConnection();
            
            String query = "DELETE FROM Patient WHERE id = ?";
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
                
                p.setId(rs.getInt(1));
                p.setLname(rs.getString(2));
                p.setFname(rs.getString(3));
                p.setMi(rs.getString(4));
                p.setSex(rs.getString(5));
                p.setBirthday(rs.getString(6));
                p.setCity(rs.getString(7));
                
                lahatPatient.add(p);
            }
            
            return lahatPatient;
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
}
