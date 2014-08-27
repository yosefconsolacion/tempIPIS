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
import java.text.SimpleDateFormat;
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

            String query = "INSERT INTO Patient (fullname, birthday, sex, address, philhealth, dateadmitted, physician, diagnosis, room, remarks, priority, datedischarge) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getFullname());
            ps.setInt(2, p.getBirthday());
            ps.setString(3, p.getSex());
            ps.setString(4, p.getAddress());
            ps.setString(5, p.getPhilhealth());
            ps.setString(6, p.getDateAdmitted());
            ps.setString(7, p.getPhysician());
            ps.setString(8, p.getDiagnosis());
            ps.setString(9, p.getRoom());
            ps.setString(10, p.getRemarks());
            ps.setString(11, p.getPriority());
            ps.setString(12, p.getDateDischarged());

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
            while (rs.next()) {
                Patient p = new Patient();

                p.setPatientid(rs.getInt(1));
                p.setFullname(rs.getString(2));
                p.setBirthday(rs.getInt(3));
                p.setSex(rs.getString(4));
                p.setAddress(rs.getString(5));
                p.setPhilhealth(rs.getString(6));
                p.setDateAdmitted(rs.getString(7));
                p.setPhysician(rs.getString(8));
                p.setDiagnosis(rs.getString(9));
                p.setRoom(rs.getString(10));
                p.setRemarks(rs.getString(11));
                p.setPriority(rs.getString(12));
                p.setDateDischarged(rs.getString(13));

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
            if (rs.next()) {
                p.setPatientid(rs.getInt(1));
                p.setFullname(rs.getString(2));
                p.setBirthday(rs.getInt(3));
                p.setSex(rs.getString(4));
                p.setAddress(rs.getString(5));
                p.setPhilhealth(rs.getString(6));
                p.setDateAdmitted(rs.getString(7));
                p.setPhysician(rs.getString(8));
                p.setDiagnosis(rs.getString(9));
                p.setRoom(rs.getString(10));
                p.setRemarks(rs.getString(11));
                p.setPriority(rs.getString(12));
                p.setDateDischarged(rs.getString(13));
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

            String query = "UPDATE PATIENT SET fullname = ?, birthday = ?, sex = ?, address = ?, philhealth = ?, dateadmitted = ?, physician = ?, diagnosis = ?, room = ?, remarks = ?, priority = ?, datedischarge = ? WHERE patientid = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, newData.getFullname());
            ps.setInt(2, newData.getBirthday());
            ps.setString(3, newData.getSex());
            ps.setString(4, newData.getAddress());
            ps.setString(5, newData.getPhilhealth());
            ps.setString(6, newData.getDateAdmitted());
            ps.setString(7, newData.getPhysician());
            ps.setString(8, newData.getDiagnosis());
            ps.setString(9, newData.getRoom());
            ps.setString(10, newData.getRemarks());
            ps.setString(11, newData.getPriority());
            ps.setString(12, newData.getDateDischarged());
            ps.setInt(13, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Patient> search(String subStr) {
        ArrayList<Patient> allPatients = getAllPatients();
        ArrayList<Patient> matches = new ArrayList<>();
        for (int i = 0; i < allPatients.size(); i++) {
            if (allPatients.get(i).getFullname().toLowerCase().contains(subStr.toLowerCase()) || allPatients.get(i).getPhysician().toLowerCase().contains(subStr.toLowerCase())) {
                matches.add(allPatients.get(i));
            }
        }
        return matches;
    }
    
    public ArrayList<Patient> searchDaily(String subStr, String timeStamp) {
        ArrayList<Patient> allPatients = getAllPatients();
        ArrayList<Patient> matches = new ArrayList<>();
        String date = "";
        System.out.print(date);
        for (int i = 0; i < allPatients.size(); i++) {
            date = allPatients.get(i).getDateAdmitted();
            if ((allPatients.get(i).getFullname().toLowerCase().contains(subStr.toLowerCase()) || allPatients.get(i).getPhysician().toLowerCase().contains(subStr.toLowerCase())) && date.contains(timeStamp)) {
                matches.add(allPatients.get(i));
            }
        }
        return matches;
    }
    
    public ArrayList<Patient> censusDaily(String dateAdm) {
        ArrayList<Patient> allPatients = getAllPatients();
        ArrayList<Patient> matches = new ArrayList<>();
        for (int i = 0; i < allPatients.size(); i++) {
            String[] datetime = allPatients.get(i).getDateAdmitted().split(" ");
            String dateAdmitted = datetime[0];
            if (dateAdmitted.equals(dateAdm)) {
                matches.add(allPatients.get(i));
            }
        }    
        return matches;
    }
}
