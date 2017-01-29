/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author uty
 */
public class koneksi {
    public Statement cn;
    public Connection con;
    public Properties mypanel, mylanguages;
    private String strNamaPanel;
    
    public String SettingPanel(String nmPanel){
        try {
            mypanel = new Properties();
            mypanel.load(new FileInputStream("lib/db.ini"));
            strNamaPanel = mypanel.getProperty(nmPanel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Tidak Ada Koneksi","Error", JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return strNamaPanel;
            
        }
        
}
