/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author simarjit singh pannu
 */
public class Stock {
    private String shareName; 
    private String sharePrice;
    private String shareCountry;    

    public Stock(String shareName, String sharePrice, String shareCountry) {
        this.shareName = shareName;
        this.sharePrice = sharePrice;
        this.shareCountry = shareCountry;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public String getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(String sharePrice) {
        this.sharePrice = sharePrice;
    }

    public String getShareCountry() {
        return shareCountry;
    }

    public void setShareCountry(String shareCountry) {
        this.shareCountry = shareCountry;
    }
    
    
public void insertIntoDB() throws SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try{
            //connecting to the database 
           conn = DriverManager.getConnection("jdbc:mysql://aws.computerstudi.es/"

                    + "gc200359541", "gc200359541", "wl3tDZWsQf");

            
      //string to hold values
     // System.out.println("There was an error connecting the database");
      
      String sql = "INSERT INTO Stocks (shareName ,shareName , shareCountry)" 
              + "VALUES (?,?,?,?,?)";
       preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
      
      preparedStatement.setString(1,shareName);
      preparedStatement.setString(2,sharePrice);
      preparedStatement.setString(3,shareCountry);
    
      preparedStatement.executeUpdate();
      
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            if(preparedStatement != null)
                preparedStatement.close();
            
            if(conn != null)
            conn.close();
               
    }
    
}
}