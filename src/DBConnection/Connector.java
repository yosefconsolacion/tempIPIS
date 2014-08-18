/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Jeffrey
 */
public class Connector {
    
    private String username = "";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/orangedb";	// please insert db name here, and modify port if needed
    private String driver = "com.mysql.jdbc.Driver";
    
    // init code
    public Connector() {
        Scanner sc = null;
        try {
            File f = new File("auth.txt");
//            System.out.println("f = " + f.getAbsolutePath());
            sc = new Scanner(f);
            username = sc.nextLine();
            password = sc.nextLine();
//            System.out.println("u = " + username);
//            System.out.println("p = " + password);
            
            sc.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("You did not edit the auth.txt file");
        }
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            Connection c = DriverManager.getConnection(url, username, password);
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
