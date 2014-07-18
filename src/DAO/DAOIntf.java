/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Patient;
import java.util.ArrayList;

/**
 *
 * @author Jeffrey
 */
public interface DAOIntf {
    
    public void addPatient(Patient p);
    
    public void removePatient(int id);
    
    public ArrayList<Patient> getAllPatients();
}
