/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Priyamvada
 */
@ManagedBean
@RequestScoped
public class newAccountCreation {
    private String UID;
    private String FirstName;
    private String pwd;
    private String UserType; 

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
    
    /**
     * Creates a new instance of newAccountCreation
     */
    public String newAccountCreation() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            return ("Internal Error!!!!!");
        }
       final String DATABSE_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
       
        
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultset = null;
        try
        {
         connection = DriverManager.getConnection(DATABSE_URL,"seerapup8892","1347006");
         statement = connection.createStatement();//set of results
         resultset = statement.executeQuery("select * from accounts where AID = '" +UID + "' and Type = '" + UserType + "'");
         if(resultset.next())
             {
                return ("Account Already exists");
                
            }
             else
             {
      int r = statement.executeUpdate("insert into accounts values ('" + UserType + "','" + UID
                    + "','" + pwd + "','" + FirstName + "')");
        }
         return ("Account Created");
        }
        catch(SQLException e)
        {
             //Handle the exceptions
             e.printStackTrace();
             return ("Account creation failed");            
        }
        finally
        {
             try
            {
                resultset.close();
                statement.close();
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }        
        
    }
    
}
