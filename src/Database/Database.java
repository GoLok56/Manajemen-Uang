package Database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Database {
    public static Connection conn;
    public static Statement st;
    public static ResultSet rs;
    public static void koneksi(){
        try{
            
            final String driver = "com.mysql.jdbc.Driver";
            final String link = "jdbc:mysql://localhost/my_db?useSSL=false";
            final String root = "root";
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(link,root,root); //Connect to mysql
            st   = conn.createStatement();
        
        }catch(ClassNotFoundException | SQLException s){
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
}
