/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr334Coin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
   public static Connection getConnection( ) throws ClassNotFoundException, SQLException  {

        
  Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Base", "root", "root");
      

    }
   

   
  
}
