
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Dbconnection {
   static String connectDB() throws SQLException
    {
        String record="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/goddatabase?user=root");
            Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("SELECT * from godtable");
               System.out.println("Connected successfully");
             while(rs.next())
             { 
                 record=record+(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" ");
                 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" ");
             }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }return record; 
    }
   static void insertQuery(int SNO,String Name,int Age)
   {
       try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/goddatabase?user=root");
            PreparedStatement ps=con.prepareStatement("INSERT INTO godtable(SNO,Name,Age)values(?,?,?)");
            ps.setInt(1,SNO);
            ps.setString(2,Name);
            ps.setInt(3,Age);
            ps.executeUpdate();
            System.out.println("Inserted Successfully");      
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
   }

    
    
}
