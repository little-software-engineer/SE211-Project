/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class DBKonekcija {

    public Connection kon = null;

    public DBKonekcija() {
    }

    /**
     * Metoda koja zapocinje konekciju sa bazom
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection zapocniKonekciju() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        kon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/se211_pz", "root", "");
        return kon;
    }

    /**
     * Metoda koja prekida konekciju sa bazom
     *
     * @throws SQLException
     */
    public void prekiniKonekciju() throws SQLException {
        kon.close();
    }
}
